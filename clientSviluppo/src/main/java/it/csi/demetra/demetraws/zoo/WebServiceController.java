package it.csi.demetra.demetraws.zoo;

import it.csi.demetra.demetraws.srmanags.wsbridge2.Response;
import it.csi.demetra.demetraws.srmanags.wsbridge2.WSBridge2;
import it.csi.demetra.demetraws.srmanags.wsbridge2.WSBridgeInternalException_Exception;
import it.csi.demetra.demetraws.srmanags.wsbridge2.WSBridgeService;
import it.csi.demetra.demetraws.zoo.calcoli.CalcoloException;
import it.csi.demetra.demetraws.zoo.controlli.ControlliFramework;
import it.csi.demetra.demetraws.zoo.controlli.visitor.ControlloException;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_subentro_zoo;
import it.csi.demetra.demetraws.zoo.model.Rpu_V_pratica_zoote;
import it.csi.demetra.demetraws.zoo.services.AziendaService;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_errore_services;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_sessione_services;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_subentro_zoo_services;
import it.csi.demetra.demetraws.zoo.services.http.BdnHttpServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;
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
    private ControlliFramework controlliFramework;

    // se invocato con chiamata POST restituisce in console il token d'accesso
    @RequestMapping("/bdn")
    public void bdn() throws IOException {
        BdnHttpServices bdnHttpServices = new BdnHttpServices();
        bdnHttpServices.httpClientPost();
    }

    /**
     * l'endpoint calcoloArt52/_ANNO_
     * permette di calcolare i premi corrispondenti per l'anno campagna parametrizzato passato nella url.
     * Il controller esegue per ogni soggetto lo scarico dei dati dalla BDN.
     * Solamente una volta completato, con esito positivo, lo scarico per tutti i soggetti, vengono eseguiti i controlli.
     * Ogni controllo restituisce il risultato atteso oppure lancia un'eccezione contenente un log dettagliato dell'errore
     * ottenuto.
     * Alla fine della procedura sarà possibile ripercorrere lo storico delle operazione in DB.
     *
     * @param annoCampagna
     * @return
     */
    @GetMapping(value = "/calcoloArt52/{annoCampagna}")
    public String calcoloArt52(@PathVariable("annoCampagna") Integer annoCampagna) {
        Dmt_t_sessione sessione = sessioneService.saveSession(new Dmt_t_sessione());
        System.out.println(sessione.getIdSessione());
        List<Rpu_V_pratica_zoote> list = aziendaService.getAll(annoCampagna);

        // ESEGUO IL PRIMO FOR PER SCARICARE TUTTI I DATI
        for (Rpu_V_pratica_zoote azienda : list) {

            if (!controlliFramework.scaricoDati(azienda, subentroService.getSubentro(annoCampagna, azienda.getCuaa()), sessione, annoCampagna))
                System.out.println("Errore nello scarico dei dati per " + azienda.getCuaa() + " nell'anno" + annoCampagna);
            else System.out.println("Scarico dati completato per -> " + azienda.getCuaa());
            try {
                controlliFramework.handleControlloCUUA(azienda, subentroService.getSubentro(annoCampagna, azienda.getCuaa()), sessione);
            } catch (ControlloException e) {
                e.printStackTrace();
            } catch (CalcoloException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Download dei dati dalla BDN completato\nInizio i controlli");

        for (Rpu_V_pratica_zoote azienda : list) {
            try {
                controlliFramework.handleControlloCUUA(azienda, subentroService.getSubentro(annoCampagna, azienda.getCuaa()), sessione);
            } catch (ControlloException e) {
                if (null != e.getErrore())
                    erroreService.saveError(e.getErrore());
                else System.out.println(e.getMessage());
            } catch (CalcoloException e) {
                System.out.println(e.getMessage());
            }
        }

        return "Procedura avviata";
    }

    /* PROVA CHIAMATA AL DATABASE ORACLE */
    @GetMapping(value = "/chiamataDb/{annoCampagna}")
    public String chiamataDb(@PathVariable("annoCampagna") Integer annoCampagna) {
        List<Rpu_V_pratica_zoote> list = aziendaService.getAll(annoCampagna);
        System.out.println(list.size());
        System.out.println("--- STAMPO INFORMAZIONI ---");
        for (Rpu_V_pratica_zoote x : list)
            System.out.println(x.toString());
        if (list.isEmpty())
            return "KO";
        else
            return "OK";
    }

    @GetMapping(value = "/proceduraCuua/{annoCampagna}")
    public String proceduraCuua2(@PathVariable("annoCampagna") Integer annoCampagna) throws ParseException {
        List<Rpu_V_pratica_zoote> list = aziendaService.getAll(annoCampagna);
        WSBridge2 wsBridge2 = new WSBridgeService().getWSBridge2Port();

        try {

            Dmt_t_subentro_zoo subentro;


            for (Rpu_V_pratica_zoote x : list) {
                System.out.println("PROVO CHIAMATA CON CUAA: " + x.getCuaa());
                subentro = subentroService.getSubentro(2018, x.getCuaa());
                response = wsBridge2.getElencoCapiPremio2New(0, x.getCodicePremio(), x.getCuaa(), subentro.getCuaaSubentro(), 2018);
                System.out.println("---------- INFORMAZIONI RESPONSE METODO GET ELENCO CAPI PREMIO 2 ----------");
            }
        } catch (WSBridgeInternalException_Exception | IndexOutOfBoundsException | NullPointerException e) {
            e.printStackTrace();
        }
        return "Procedura avviata";
    }
}