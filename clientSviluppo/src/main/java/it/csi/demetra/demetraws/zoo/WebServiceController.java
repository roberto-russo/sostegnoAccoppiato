package it.csi.demetra.demetraws.zoo;

import it.csi.demetra.demetraws.srmanags.wsbridge2.Response;
import it.csi.demetra.demetraws.zoo.calcoli.CalcoloException;
import it.csi.demetra.demetraws.zoo.controlli.ControlliFramework;
import it.csi.demetra.demetraws.zoo.controlli.visitor.ControlloException;
import it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef.ref03;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_errore;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;
import it.csi.demetra.demetraws.zoo.model.Rpu_V_pratica_zoote;
import it.csi.demetra.demetraws.zoo.services.*;
import it.csi.demetra.demetraws.zoo.transformer.TransformerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * l'endpoint calcoloArt52/_ANNO_ permette di calcolare i premi corrispondenti per l'anno campagna parametrizzato passato nella url.
     * Il controller esegue per ogni soggetto lo scarico dei dati dalla BDN. Solamente una volta completato, con esito positivo,
     * lo scarico per tutti i soggetti, vengono eseguiti i controlli. Ogni controllo restituisce il risultato atteso oppure lancia
     * un'eccezione contenente un log dettagliato dell'errore ottenuto.
     * Alla fine della procedura sarà possibile ripercorrere lo storico delle operazione in DB.
     *
     * @param annoCampagna anno della campagna
     */

    @RequestMapping(value = "/calcoloArt52/{annoCampagna}", method = RequestMethod.GET)
    public void calcoloArt52(@PathVariable("annoCampagna") Integer annoCampagna, @RequestParam("tipoEsecuzione") String tipoEsecuzione) {
        Dmt_t_sessione sessione = sessioneService.saveSession(new Dmt_t_sessione());
//        List<Rpu_V_pratica_zoote> listVista = aziendaService.getAll(annoCampagna);
        TransformerData transformer = new TransformerData();
        List<Rpu_V_pratica_zoote> listParziale = transformer.transformCuaa(this.cuaaScaricoServices.getAll(annoCampagna));
        List<Rpu_V_pratica_zoote> listVista = listParziale;


        List<Rpu_V_pratica_zoote> listaScarico = eseguiScarico(listVista, (listParziale != null && listParziale.size() > 0) ? listParziale : listVista, sessione, annoCampagna, tipoEsecuzione);
        if (!tipoEsecuzione.equals("2")) {
            eseguiControlli(listaScarico, annoCampagna, sessione);
            eseguiCalcoli(listaScarico, sessione);
        }

        System.out.println("Download dei dati dalla BDN completato\nInizio i controlli");

    }

    private void eseguiControlli(List<Rpu_V_pratica_zoote> listaCuaa, Integer annoCampagna, Dmt_t_sessione sessione) {
        System.out.println("INIZIO CONTROLLI SU N.ELEMENTI -> " + listaCuaa.size());
        for (Rpu_V_pratica_zoote azienda : listaCuaa) {
            try {
                controlliFramework.handleControlloCUUA(azienda, subentroService.getSubentro(annoCampagna, azienda.getCuaa()), sessione);
            } catch (ControlloException e) {
                if (null != e.getErrore()) {
                    Dmt_t_errore err = e.getErrore();
                    err.setIdSessione(sessione);
                    erroreService.saveError(err);
                }
            } catch (CalcoloException e) {
                e.printStackTrace();
            }
        }
    }

    private void eseguiCalcoli(List<Rpu_V_pratica_zoote> listaCuaa, Dmt_t_sessione sessione) {
        System.out.println("INIZIO CALCOLI SU N.ELEMENTI -> " + listaCuaa.size());
        for (Rpu_V_pratica_zoote azienda : listaCuaa) {
            calcoloRef03.inizializzazione(sessione, azienda);
            try {
                calcoloRef03.esecuzione();
            } catch (CalcoloException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private List<Rpu_V_pratica_zoote> eseguiScarico(List<Rpu_V_pratica_zoote> listaVista,
                                                    List<Rpu_V_pratica_zoote> listaParziale,
                                                    Dmt_t_sessione sessione, Integer annoCampagna, String tipoEsecuzione) {
        System.out.println("INIZIO SCARICO");
        List<Rpu_V_pratica_zoote> cuaaMancanti = new ArrayList<>();
        List<Rpu_V_pratica_zoote> result = new ArrayList<>();
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
                    result.add(azienda);
                }
            }

            for (Rpu_V_pratica_zoote azienda : listaVista) {
                boolean trovato = false;
                for (Rpu_V_pratica_zoote aziendaParz : listaParziale) {
                    if (azienda.getCuaa().equals(aziendaParz.getCuaa())) {
                        trovato = true;
                        break;
                    }
                }
                if (!trovato) {
                    cuaaMancanti.add(azienda);
                }
            }
        }

        if (cuaaMancanti.size() > 0) {
            System.out.println("INIZIO DUPLICAZIONE CUAA DA SESSIONE PRECEDENTE");
            for (Rpu_V_pratica_zoote a : cuaaMancanti) {
                Dmt_t_sessione sessioneOld = sessioneService.getOldSessione(sessione.getIdSessione(), a.getCuaa(), a.getCodicePremio());
                if (null == sessioneOld) {
                    System.out.println("DUPLICATO NON TROVATO PER IL CUAA -> " + a.getCuaa());
                    continue;
                }
                controlliFramework.duplicaSessioneByCuaa(a, sessioneOld, sessione);
                result.add(a);
                System.out.println("DUPLICATO CORRETTAMENTE CUAA -> " + a.getCuaa());
            }
        }
        return result;
    }
}
