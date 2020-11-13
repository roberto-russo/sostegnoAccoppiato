package it.csi.demetra.demetraws.zoo;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.csi.demetra.demetraws.srmanags.wsbridge2.Response;
import it.csi.demetra.demetraws.zoo.calcoli.CalcoloException;
import it.csi.demetra.demetraws.zoo.controlli.ControlliFramework;
import it.csi.demetra.demetraws.zoo.controlli.visitor.ControlloException;
import it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef.ref03;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;
import it.csi.demetra.demetraws.zoo.model.Rpu_V_pratica_zoote;
import it.csi.demetra.demetraws.zoo.services.AziendaService;
import it.csi.demetra.demetraws.zoo.services.CuaaScaricoManuale_services;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_errore_services;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_sessione_services;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_subentro_zoo_services;
import it.csi.demetra.demetraws.zoo.transformer.TransformerData;

@RestController
public class WebServiceController {

    @Autowired
    Dmt_t_subentro_zoo_services subentroService;

    @Autowired
    Dmt_t_errore_services erroreService;

    Response response;

    @Autowired
    private BdnWsManagerImpl bdnImpl;

    @Autowired
    private AziendaService aziendaService;

    @Autowired
    private Dmt_t_sessione_services sessioneService;
    
    @Autowired
    private CuaaScaricoManuale_services cuaaScaricoServices;

    @Autowired
    private ControlliFramework controlliFramework;

    @Autowired
    private ref03 calcoloRef03;

    // se invocato con chiamata POST restituisce in console il token d'accesso
//    @RequestMapping("/bdn")
//    public void bdn() throws IOException {
//        BdnHttpServices bdnHttpServices = new BdnHttpServices();
//        bdnHttpServices.httpClientPost();
//    }

    /**
     * l'endpoint calcoloArt52/_ANNO_ permette di calcolare i premi corrispondenti per l'anno campagna parametrizzato passato nella url.
     * Il controller esegue per ogni soggetto lo scarico dei dati dalla BDN. Solamente una volta completato, con esito positivo,
     * lo scarico per tutti i soggetti, vengono eseguiti i controlli. Ogni controllo restituisce il risultato atteso oppure lancia
     * un'eccezione contenente un log dettagliato dell'errore ottenuto.
     * Alla fine della procedura sarà possibile ripercorrere lo storico delle operazione in DB.
     *
     * @param annoCampagna anno della campagna
     */

    @GetMapping(value = "/calcoloArt52/{annoCampagna}")
    public void calcoloArt52(@PathVariable("annoCampagna") Integer annoCampagna, @PathParam("tipoEsecuzione") String tipoEsecuzione) {
        Dmt_t_sessione sessione = sessioneService.saveSession(new Dmt_t_sessione());
        List<Rpu_V_pratica_zoote> listVista = aziendaService.getAll(annoCampagna);;
        TransformerData transformer = new TransformerData();
        List<Rpu_V_pratica_zoote> listParziale = transformer.transformCuaa(this.cuaaScaricoServices.getAll(annoCampagna));


        eseguiScarico(listVista, listParziale, sessione, annoCampagna, tipoEsecuzione);
        if(!tipoEsecuzione.equals("2")) {
            eseguiControlli(listVista, annoCampagna, sessione);
            eseguiCalcoli(listVista, sessione);
        }

        System.out.println("Download dei dati dalla BDN completato\nInizio i controlli");
        
    }

    private void eseguiControlli(List<Rpu_V_pratica_zoote> listaCuaa, Integer annoCampagna, Dmt_t_sessione sessione) {
        for (Rpu_V_pratica_zoote azienda : listaCuaa) {
            try {
                controlliFramework.handleControlloCUUA(azienda, subentroService.getSubentro(annoCampagna, azienda.getCuaa()), sessione);
            } catch (ControlloException e) {
                if (null != e.getErrore())
                    erroreService.saveError(e.getErrore());
                else System.out.println(e.getMessage());
            } catch (CalcoloException e) {
                System.out.println(e.getCause() + e.getMessage());
            }
        }
    }

    private void eseguiCalcoli(List<Rpu_V_pratica_zoote> listaCuaa, Dmt_t_sessione sessione) {
        for (Rpu_V_pratica_zoote azienda : listaCuaa) {
            calcoloRef03.inizializzazione(sessione, azienda);
            try {
                calcoloRef03.esecuzione();
            } catch (CalcoloException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void eseguiScarico(List<Rpu_V_pratica_zoote> listaVista,
                               List<Rpu_V_pratica_zoote> listaParziale,
                               Dmt_t_sessione sessione, Integer annoCampagna, String tipoEsecuzione) {
        List<Rpu_V_pratica_zoote> cuaaMancanti = new ArrayList<>();
        if (tipoEsecuzione.equals("3"))
            cuaaMancanti = listaVista;
        else {
            for (Rpu_V_pratica_zoote azienda : listaParziale) {
                if (!controlliFramework.
                        scaricoDati(azienda, subentroService.getSubentro(annoCampagna, azienda.getCuaa()), sessione, annoCampagna)) {
                    System.out.println("Errore nello scarico dei dati per " + azienda.getCuaa() + " nell'anno" + annoCampagna);
                    cuaaMancanti.add(azienda);
                } else {
                    System.out.println("Scarico dati completato per -> " + azienda.getCuaa());
                }
            }

            for(Rpu_V_pratica_zoote azienda : listaVista) {
                boolean trovato=false;
                for (Rpu_V_pratica_zoote aziendaParz : listaParziale) {
                    if(azienda.getCuaa().equals(aziendaParz.getCuaa())) {
                        trovato=true;
                        break;
                    }
                }
                if(!trovato) {
                    cuaaMancanti.add(azienda);
                }
            }
        }

        if (cuaaMancanti.size() > 0) {
            Dmt_t_sessione sessioneOld = sessioneService.getById(sessione.getIdSessione() - 1);
            for (Rpu_V_pratica_zoote a : cuaaMancanti) {
                controlliFramework.duplicaSessioneByCuaa(a, sessioneOld, sessione);
            }
        }
    }

    /* PROVA CHIAMATA AL DATABASE ORACLE */
//    @GetMapping(value = "/chiamataDb/{annoCampagna}")
//    public String chiamataDb(@PathVariable("annoCampagna") Integer annoCampagna) {
//        List<Rpu_V_pratica_zoote> list = aziendaService.getAll(annoCampagna);
//        System.out.println(list.size());
//        System.out.println("--- STAMPO INFORMAZIONI ---");
//        for (Rpu_V_pratica_zoote x : list)
//            System.out.println(x.toString());
//        if (list.isEmpty())
//            return "KO";
//        else
//            return "OK";
//    }
//
//    @GetMapping(value = "/proceduraCuua/{annoCampagna}")
//    public String proceduraCuua2(@PathVariable("annoCampagna") Integer annoCampagna) throws ParseException {
//        List<Rpu_V_pratica_zoote> list = aziendaService.getAll(annoCampagna);
//        WSBridge2 wsBridge2 = new WSBridgeService().getWSBridge2Port();
//
//        try {
//
//            Dmt_t_subentro_zoo subentro;
//
//
//            for (Rpu_V_pratica_zoote x : list) {
//                System.out.println("PROVO CHIAMATA CON CUAA: " + x.getCuaa());
//                subentro = subentroService.getSubentro(2018, x.getCuaa());
//                response = wsBridge2.getElencoCapiPremio2New(0, x.getCodicePremio(), x.getCuaa(), subentro.getCuaaSubentro(), 2018);
//                System.out.println("---------- INFORMAZIONI RESPONSE METODO GET ELENCO CAPI PREMIO 2 ----------");
//            }
//        } catch (WSBridgeInternalException_Exception | IndexOutOfBoundsException | NullPointerException e) {
//            e.printStackTrace();
//        }
//        return "Procedura avviata";
//    }
}
