package it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef;

import it.csi.demetra.demetraws.zoo.calcoli.CalcoloException;
import it.csi.demetra.demetraws.zoo.calcoli.CtlVerificaRegistrazioneCapi;
import it.csi.demetra.demetraws.zoo.calcoli.entity.ResultCtlUbaMinime;
import it.csi.demetra.demetraws.zoo.controlli.UtilControlli;
import it.csi.demetra.demetraws.zoo.controlli.visitor.ControlloException;
import it.csi.demetra.demetraws.zoo.model.*;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_tws_bdn_du_capi_bovini_services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * i controlli da applicare per il calcolo del premio zootecnia per
 * l’intervento 322 – Misura 20:<br>
 * vacche nutrici non iscritte nei Libri genealogici o nel registro anagrafico e
 * appartenenti ad allevamenti non iscritti nella BDN come allevamenti da latte.
 *
 * @author Bcsoft
 */
@Component("ClcInt322Mis20")
public class ClcInt322Mis20 extends Controllo {


    private List<Dmt_t_Tws_bdn_du_capi_bovini> modelVacche;
    private List<Dmt_t_Tws_bdn_du_capi_bovini> modelVaccheFiltrate;
    private List<Dmt_t_Tws_bdn_du_capi_bovini> listVitelli;
    private BigDecimal numeroCapiAmmissibili;
    private BigDecimal numeroCapiRichiesti;
    private Integer capiSanzionati;
    private List<Dmt_t_Tws_bdn_du_capi_bovini> listaCapiBocciati;
    private List<Dmt_t_Tws_bdn_du_capi_bovini> listaCapiSanzionati;
    @Autowired
    private CtlVerificaRegistrazioneCapi ref9901;
    @Autowired
    Dmt_t_tws_bdn_du_capi_bovini_services capiBoviniService;
    private Dmt_t_output_controlli oc;
    private List<Dmt_t_contr_loco> estrazioneACampione;
    private int numeroCapiBocciati;
    private Dmt_t_output_esclusi outputEsclusi;
    private String motivazione;
    private ResultCtlUbaMinime ubaMin;
    private List<Dmt_t_Tws_bdn_du_capi_bovini> listaCapiDichiarati;

    /**
     * nel metodo preEsecuzione vengono effettuate due operazioni principali. La
     * prima è l'inizializzazione delle variabili di classe. La seconda è
     * l'esecuzione dei controlli di preammissibilità trasversali. Il risultato di
     * tali controlli pregiudica l'esecuzione del calcolo stesso. Se l'esecuzione ha
     * esito positivo, allora si può procedere con il calcolo intervento 322 misura
     * 20. Se l'esecuzione ha esito negativo, allora viene generato un messaggio di
     * errore. il metodo preEsecuzione esegue il controlli:<br>
     * {@link it.csi.demetra.demetraws.zoo.calcoli.CtlVerificaRegistrazioneCapi} e
     * {@link it.csi.demetra.demetraws.zoo.calcoli.CtlUbaMinime}
     *
     * @return
     * @throws ControlloException eccezione relativa al controllo di tipo
     *                            {@link ControlloException}
     */
    @Override
    public List<Dmt_t_Tws_bdn_du_capi_bovini> preEsecuzione() throws ControlloException {
        System.out.println("INIZIO CALCOLO PREMIO 322 MISURA 20");
        if (1==1)
            System.out.println("CALCOLO PREMIO 322 MISURA 20, INIZIO PRE-ESECUZIONE");

        // INIZIALIZZAZIONE DELLE VARIABILI

        this.numeroCapiAmmissibili = new BigDecimal(0);
        this.numeroCapiBocciati = 0;
        this.numeroCapiRichiesti = BigDecimal.ZERO;
        this.modelVacche = null;
        this.listVitelli = null;
        this.oc = null;
        this.estrazioneACampione = null;
        this.listaCapiBocciati = new ArrayList<>();
        this.outputEsclusi = null;
        this.motivazione = null;
        this.ubaMin = new ResultCtlUbaMinime();
        this.modelVaccheFiltrate = null;
        this.capiSanzionati = 0;
        listaCapiSanzionati = new ArrayList<>();
        listaCapiBocciati = new ArrayList<>();

        // LE VACCHE CHE SUPERANO QUESTI CONTROLLI SARANNO NELLA LISTA modelVacche

        try {
            this.listaCapiDichiarati = this.controlloCapiDichiarati(getControlliService()
                    .getAllBoviniSessioneCuua(getSessione(), getAzienda().getCuaa(), getAzienda().getCodicePremio()));

            ref9901.init(this.listaCapiDichiarati, getSessione().getIdSessione(), getAzienda().getCodicePremio(),
                    Long.valueOf(getAzienda().getAnnoCampagna()), getAzienda().getCuaa());

            this.modelVacche = ref9901.calcolo();

            if (this.modelVacche == null)
                throw new CalcoloException(
                        "si e' verificato un errore durante l'esecuzione del controllo tempistica di registrazione dei capi");
            else if (this.modelVacche.isEmpty())
                throw new ControlloException(new Dmt_t_errore(getSessione(), "ClcInt322Mis20", getInput(),
                        "nessun capo ha superato il controllo: tempistica di registrazione capi"));

        } catch (CalcoloException e) {
            throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_9901", getInput(), e.getMessage()));
        }

        if (1==1)
            System.out.println("CALCOLO PREMIO 322 MISURA 20, FINE PRE-ESECUZIONE");
        System.out.println(
                "I CONTROLLI DI PRE-CALCOLO PER IL CALCOLO PREMIO 322 MISURA 20 SONO STATI ESEGUITI CORRETTAMENTE ✔");

        return modelVacche;
    }

    /**
     * nel metodo esecuzione vengono eseguiti i controlli per il calcolo intervento
     * 322 misura 20. Se i controlli per il suddetto calcolo risultano essere
     * positivi, allora viene incrementato il contatore di capi ammissibili e il
     * capo sarà visibile in
     * {@link it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli}. Qualora i
     * capi risultassero non idonei al premio in questione, verrà incrementato il
     * numero di capi non ammessi a premio e tale capo sarà inserito nella lista di
     * capi non ammessi a premio. La lista di capi non ammessi a premio sarà
     * visibile in {@link it.csi.demetra.demetraws.zoo.model.Dmt_t_output_esclusi}.
     *
     * @throws ControlloException eccezione relativa al controllo di tipo
     *                            {@link ControlloException}
     */
    @Override
    public void esecuzione(List<Dmt_t_premio_capi> listUbaMinime) throws ControlloException {
        if (1==1)
            System.out.println("CALCOLO PREMIO 322 MISURA 20, INIZIO ESECUZIONE");

        this.modelVaccheFiltrate = capiBoviniService.getBoviniUbaMinime(getSessione().getIdSessione(),
                getAzienda().getCuaa(), getAzienda().getCodicePremio());

        // SE E' NULL ALLORA NON E' ESTRATTO A CAMPIONE
        this.estrazioneACampione = getControlliService().getEsrtazioneACampioneByCuaa(getAzienda().getCuaa(),
                getAzienda().getAnnoCampagna());
        numeroCapiRichiesti = BigDecimal.valueOf(this.listaCapiDichiarati.size());

        if (this.estrazioneACampione == null || this.estrazioneACampione.isEmpty()) {

            try {
                for (Dmt_t_Tws_bdn_du_capi_bovini b : this.modelVaccheFiltrate) {
                    this.listVitelli = getControlliService().getVitelliNatiDaBovini(getSessione().getIdSessione(),
                            b.getCapoId(), getAzienda().getCodicePremio());
                    /*
                     * L’aiuto spetta al richiedente detentore della vacca al momento del parto.
                     * Qualora la vacca abbia partorito più di una volta nel corso dell’anno
                     * presso la stalla di diversi detentori susseguitisi nel tempo, il premio è
                     * erogato al detentore presso il quale è nato il primo capo.
                     */

                    // SE IL BENEFICIARIO DEL CAPO DOPPIO VA SCELTO IN BASE AL CAA
                    if (UtilControlli.isBeneficiarioCapiDoppi(this.getAzienda().getAnnoCampagna(),
                            this.getAzienda().getCodicePremio(), this.getAzienda().getCuaa(), b.getCapoId(),
                            this.getControlliService())) {

                        UtilControlli.controlloRegistrazioneStallaDuplicato(b, this.getControlliService(),
                                this.getAzienda().getCuaa(), this.getAzienda().getAnnoCampagna(), this.getSessione());
                        this.numeroCapiAmmissibili = numeroCapiAmmissibili.add(BigDecimal.ONE);
                        if (UtilControlli.controlloTempisticheDiRegistrazione(b)) {
                            listaCapiSanzionati.add(b);
                            this.capiSanzionati++;
                        }

                    } else {

                        // ALTRIMENTI SI PROCEDE ALLA DETERMINAZIONE DEL BENEFICIARIO DEL CAPO DOPPIO IN
                        // MANIERA CLASSICA

                        if (UtilControlli.isDetentoreParto(b, listVitelli)) {
                            UtilControlli.controlloRegistrazioneStallaDuplicato(b, this.getControlliService(),
                                    this.getAzienda().getCuaa(), this.getAzienda().getAnnoCampagna(),
                                    this.getSessione());
                            if (UtilControlli.controlloTempisticheDiRegistrazione(b)) {
                                this.numeroCapiAmmissibili = numeroCapiAmmissibili.add(BigDecimal.ONE);
                            } else {
                                listaCapiSanzionati.add(b);
                                this.capiSanzionati++;
                            }
                        } else {
                            // CONTROLLO FALLITO
                            this.numeroCapiBocciati++;
                            this.listaCapiBocciati.add(b);
                            this.motivazione = " il richiedente " + getAzienda().getCuaa()
                                    + " non e' il detentore dell'allevamento presso cui e'nato il primo capo";
                        }
                    }
                }
                if (numeroCapiAmmissibili.compareTo(BigDecimal.ZERO) == 0) {
                    throw new ControlloException("per il cuaa " + getAzienda().getCuaa()
                            + " nessun capo ha suprato il controllo per il premio 322 misura 20");
                }

            } catch (ControlloException e) {
                // GESTIONE DEL FALLIMENTO DELL'ESECUZIONE
                new Dmt_t_errore(getSessione(), "ClcInt322Mis20", getInput(), e.getMessage());
            } catch (NullPointerException e) {
                throw new ControlloException(
                        new Dmt_t_errore(getSessione(), "esecuzione", getInput(), "nessun capo disponibile"));

            }

        } else
            // GESTIONE CONTROLLI BY DMT_CONTR_LOCO
            for (Dmt_t_contr_loco c : this.estrazioneACampione)
                if (!c.getAnomalie_cgo().contains("B"))
                    this.numeroCapiAmmissibili = numeroCapiAmmissibili.add(BigDecimal.ONE);

        if (1==1)
            System.out.println("CALCOLO PREMIO 322 MISURA 20, FINE ESECUZIONE");
    }

    /**
     * nel metodo postEsecuzione vengono salvati a db i dati relativi ai capi
     * ammessi a premio in
     * {@link it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli} e i dati
     * relativi ai capi non ammessi a premio in
     * {@link it.csi.demetra.demetraws.zoo.model.Dmt_t_output_esclusi}. Dei capi non
     * ammessi a premio sarà salvata l'informazione di identificazione del capo, il
     * premio per cui è stata effettuata la richiesta di amissione e la motivazione
     * per cui risulta non idoneo al premio. Per i capi risultanti idonei al premio
     * in questione, sarà salvata l'informazione dell'anno campagna per cui
     * concorrono, il numero di capi ammessi a premio, il cuaa che ha presentato la
     * domanda e il codice premio.
     *
     * @throws ControlloException eccezione relativa al controllo di tipo
     *                            {@link ControlloException}
     */
    @Override
    public void postEsecuzione() throws ControlloException {

        if (1==1)
            System.out.println("CALCOLO PREMIO 322 MISURA 20, INIZIO POST-ESECUZIONE");

        if (null != this.numeroCapiRichiesti && numeroCapiRichiesti.longValue() != 0) {
            // SE NON SONO STATI RISCONTRATI ERRORI ALLORA POSSO SALVARE A DB QUI SALVARE
            // SIA I CAPI RICHIESTI CHE I CAPI AMMISSIBILI A PREMIO

            this.oc = new Dmt_t_output_controlli();

            this.oc.setAnnoCampagna(getAzienda().getAnnoCampagna());
            this.oc.setCapiAmmissibili(this.numeroCapiAmmissibili);
            this.oc.setCapiRichiesti(this.numeroCapiRichiesti);
            this.oc.setCapiSanzionati(capiSanzionati);
            this.oc.setCuaa(getAzienda().getCuaa());
            // PERCHE' QUI ENTRANO SOLO LE AZIENDE CON CODICE PREMIO = 322
            this.oc.setIntervento(getAzienda().getCodicePremio());
            this.oc.setIdSessione(getSessione());
            getControlliService().saveOutput(this.oc);

        }

        if (this.numeroCapiBocciati != 0) {
            // SALVATAGGIO A DB DEI CAPI BOCCIATI

            this.outputEsclusi = new Dmt_t_output_esclusi();

            for (Dmt_t_Tws_bdn_du_capi_bovini x : this.listaCapiBocciati) {
                this.outputEsclusi.setCalcolo(getClass().getSimpleName());
                this.outputEsclusi.setCapoId(x.getCapoId());
                this.outputEsclusi.setIdSessione(getSessione());
                outputEsclusi.setCuaa(getAzienda().getCuaa());
                outputEsclusi.setCodicePremio(getAzienda().getCodicePremio());
                outputEsclusi.setTipologiaEsclusione(x.getTipologiaEsclusione());
                this.outputEsclusi.setMotivazioneEsclusione(x.getMotivazioneEsclusione());
                this.getControlliService().saveOutputEscl(this.outputEsclusi);
            }
        }

        for (Dmt_t_Tws_bdn_du_capi_bovini x : this.listaCapiSanzionati) {
            Dmt_t_output_esclusi oe = new Dmt_t_output_esclusi();
            oe.setCalcolo(getClass().getSimpleName());
            oe.setCapoId(x.getCapoId());
            oe.setIdSessione(getSessione());
            oe.setCuaa(getAzienda().getCuaa());
            oe.setTipologiaEsclusione("S");
            oe.setCodicePremio(getAzienda().getCodicePremio());
            oe.setMotivazioneEsclusione(x.getMotivazioneEsclusione());
            getControlliService().saveOutputEscl(oe);
        }

        if (1==1)
            System.out.println("CALCOLO PREMIO 322 MISURA 20, FINE POST-ESECUZIONE");
        System.out.println("FINE ESECUZIONE CALCOLO PREMIO 322 MISURA 20");
    }

    @Override
    public <T> List<T> controlloCapiDichiarati(List<T> capiBDN) {

        List<T> listaCapiDichiarati = new ArrayList<T>();

        UtilControlli.clearList(listaCapiDichiarati);

        for (T capo : capiBDN)
            if (UtilControlli.controlloDataInterpartoBovino((Dmt_t_Tws_bdn_du_capi_bovini) capo,
                    this.getControlliService(), this.getSessione().getIdSessione())
                    && UtilControlli.controlloRegistrazioneVitello((Dmt_t_Tws_bdn_du_capi_bovini) capo,
                    getControlliService(), this.getSessione().getIdSessione(),
                    this.getAzienda().getCodicePremio()) // &&
                /*
                 * UtilControlli.controlloAmmissibilitaPremioPerPremiCompatibili(
                 * (Dmt_t_Tws_bdn_du_capi_bovini) capo)
                 */)
                listaCapiDichiarati.add(capo);

        return listaCapiDichiarati.isEmpty() ? Collections.emptyList() : listaCapiDichiarati;
    }
}
