package it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef;

import it.csi.demetra.demetraws.zoo.calcoli.CalcoloException;
import it.csi.demetra.demetraws.zoo.calcoli.CtlVerificaRegistrazioneCapi;
import it.csi.demetra.demetraws.zoo.calcoli.entity.ResultCtlUbaMinime;
import it.csi.demetra.demetraws.zoo.controlli.UtilControlli;
import it.csi.demetra.demetraws.zoo.controlli.visitor.ControlloException;
import it.csi.demetra.demetraws.zoo.model.*;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_tws_bdn_du_capi_bovini_services;
import it.csi.demetra.demetraws.zoo.util.LocalDateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * controlli da applicare per il calcolo del premio zootecnia per l’intervento
 * 312 – Misura 3:<br>
 * Bufale
 *
 * @author bcsoft
 */
@Component("ClcInt312Mis3")
public class ClcInt312Mis3 extends Controllo {


    private List<Dmt_t_Tws_bdn_du_capi_bovini> modelVacche;

    private List<Dmt_t_Tws_bdn_du_capi_bovini> listVaccheDetentoriAllevAttivi;

    private BigDecimal importoLiquidabile = new BigDecimal(0);

    private Integer capiSanzionati;

    private BigDecimal sizeModelVacche = BigDecimal.ZERO;

    private static final int ETA_RICHIESTA_IN_MESI = 30;

    private List<Dmt_t_Tws_bdn_du_capi_bovini> modelVaccheAmmesseRegCapi;

    private List<Dmt_t_Tws_bdn_du_capi_bovini> modelVaccheAmmesseUba;

    private List<Dmt_t_Tws_bdn_du_capi_bovini> listaCapiBocciati;

    private List<Dmt_t_Tws_bdn_du_capi_bovini> listaCapiSanzionati;
    List<Dmt_t_Tws_bdn_du_capi_bovini> modelVaccheTmp = new ArrayList<Dmt_t_Tws_bdn_du_capi_bovini>();

    ResultCtlUbaMinime resultCtlUba;

    boolean ubaMinimeRaggiunte;

    @Autowired
    Dmt_t_tws_bdn_du_capi_bovini_services capiBoviniService;

    @Autowired
    private CtlVerificaRegistrazioneCapi ref9901;

    private List<Dmt_t_Tws_bdn_du_capi_bovini> listVaccheDetentoriAllevNonAttivi;

    /**
     * il metodo preEsecuzione utilizza i controlli:
     * {@link it.csi.demetra.demetraws.zoo.calcoli.CtlVerificaRegistrazioneCapi} e
     * {@link it.csi.demetra.demetraws.zoo.calcoli.CtlUbaMinime}
     *
     * @return
     * @throws ControlloException eccezione relativa al controllo di tipo
     *                            {@link ControlloException}
     * @throws CalcoloException   eccezione relativa al calcolo di tipo
     *                            {@link CalcoloException}
     */
    @Override
    public List<Dmt_t_Tws_bdn_du_capi_bovini> preEsecuzione() throws ControlloException, CalcoloException {

        System.out.println("INIZIO CALCOLO INTERVENTO 312 MISURA 3");
        if (1==1)
            System.out.println("CALCOLO INTERVENTO 312 MISURA 3, INIZIO PRE-ESECUZIONE");

        listaCapiSanzionati = new ArrayList<>();

        listaCapiBocciati = new ArrayList<>();
        this.capiSanzionati = 0;
        // reset delle variabili di classe prima di iniziare l'esecuzione
        this.resetLists();

        /*
         * Prendo dal DB tutte le vacche richieste per sessione cua e codice Intervento
         */
        // modelVacche = getControlliService().getAllBoviniSessioneCuua(getSessione(),
        // getAzienda().getCuaa(), getAzienda().getCodicePremio());
        modelVacche = this.controlloCapiDichiarati(getControlliService().getAllBoviniSessioneCuua(getSessione(),
                getAzienda().getCuaa(), getAzienda().getCodicePremio()));
        /*
         * Prendo dal DB tutte le vacche appartenenti ad un detentore di allevamenti
         * attivi
         */
        listVaccheDetentoriAllevAttivi = getControlliService().getBoviniOfDetentoriAllevamentiAttivi(
                getSessione().getIdSessione(), getAzienda().getCuaa(), getAzienda().getCodicePremio());
        listVaccheDetentoriAllevNonAttivi = new ArrayList<>();

        for(Dmt_t_Tws_bdn_du_capi_bovini x : modelVacche) {
            Boolean find = false;
            for(Dmt_t_Tws_bdn_du_capi_bovini y : listVaccheDetentoriAllevAttivi) {
                if(x.getCapoId() == y.getCapoId()) {
                    find = true;
                    break;
                }
            }
            if(!find)
                listVaccheDetentoriAllevNonAttivi.add(x);
        }

        if (modelVacche == null) {
            System.out.println("ERRORE CALCOLO INTERVENTO 312 MISURA 3, NON E' STATO POSSIBILE RECUPERARE I DATI REF02.003");
            throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_02003", getInput(),
                    "Non è stato possibile recuperare i dati"));
        }

        sizeModelVacche = BigDecimal.valueOf(modelVacche.size());

        if (listVaccheDetentoriAllevAttivi == null) {
            System.out.println("ERRORE CALCOLO INTERVENTO 312 MISURA 3, NESSUN ALLEVAMENTO ATTIVO REF02.003");
            throw new ControlloException(
                    new Dmt_t_errore(getSessione(), "REF_02003", getInput(), "Nessun allevamento attivo"));
        }

        if (listVaccheDetentoriAllevNonAttivi != null && !listVaccheDetentoriAllevNonAttivi.isEmpty()) {
            setListEsclusi(listVaccheDetentoriAllevNonAttivi,
                    "Il capo è escluso poichè appartenente ad un allevamento non attivo");
        }

        try {

            ref9901.init(listVaccheDetentoriAllevAttivi, getSessione().getIdSessione(), getAzienda().getCodicePremio(),
                    Long.valueOf(getAzienda().getAnnoCampagna()), getAzienda().getCuaa());

            this.modelVaccheAmmesseRegCapi = ref9901.calcolo();

            if (this.modelVaccheAmmesseRegCapi == null) {
                System.out.println(
                        "ERRORE CALCOLO INTERVENTO 312 MISURA 3, SI E' VERIFICATO UN ERRORE DURANTE L'ESECUZIONE DEL CONTROLLO TEMPISITA DI REGISTRAZIONE DEI CAPI");
                throw new CalcoloException(
                        "si e' verificato un errore durante l'esecuzione del controllo tempistica di registrazione dei capi");
            } else {
                if (this.modelVaccheAmmesseRegCapi.isEmpty()) {
                    System.out.println(
                            "ERRORE CALCOLO INTERVENTO 312 MISURA 3, NESSUN CAPO HA SUPERATO IL CONTROLLO: TEMPISTICA DI REGISTRAZIONE CAPI");
                    throw new ControlloException(new Dmt_t_errore(getSessione(), "ClcInt312Mis3", getInput(),
                            "Nessun capo ha superato il controllo: tempistica di registrazione capi"));
                }
            }

        } catch (CalcoloException e) {
            System.out.println(
                    "ERRORE CALCOLO INTERVENTO 312 MISURA 3, ERRORE DURANTE L'ESECUZIONE DEL CONTROLLO DELLA TEMPISTICA DI REGISTRAZIONE CAPI REF99.01");
            throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_9901", getInput(), e.getMessage()));
        }

        if (1==1)
            System.out.println("CALCOLO INTERVENTO 312 MISURA 3, FINE PRE-ESECUZIONE");
        System.out.println(
                "I CONTROLLI DI PRE-CALCOLO PER IL CALCOLO INTERVENTO 312 MISURA 3 SONO STATI ESEGUITI CORRETTAMENTE ✔");

        return modelVaccheAmmesseRegCapi;
    }

    /**
     * il metodo esecuzione effettua l'esecuzione dei controlli per l'intervento 312
     * Misura 3
     *
     * @throws ControlloException eccezione relativa al controllo di tipo
     *                            {@link ControlloException}
     */
    @Override
    public void esecuzione(List<Dmt_t_premio_capi> listUbaMinime) throws ControlloException {
        if (1==1)
            System.out.println("CALCOLO INTERVENTO 312 MISURA 3, INIZIO ESECUZIONE");
        modelVaccheAmmesseUba = capiBoviniService.getBoviniUbaMinime(getSessione().getIdSessione(),
                getAzienda().getCuaa(), getAzienda().getCodicePremio());

        if (modelVaccheAmmesseUba != null && !modelVaccheAmmesseUba.isEmpty()) {

            for (Dmt_t_Tws_bdn_du_capi_bovini bufala : modelVaccheAmmesseUba) {
                // SE IL BENEFICIARIO DEL CAPO DOPPIO VA SCELTO IN BASE AL CAA

                if (UtilControlli.isBeneficiarioCapiDoppi(this.getAzienda().getAnnoCampagna(),
                        this.getAzienda().getCodicePremio(), this.getAzienda().getCuaa(), bufala.getCapoId(),
                        this.getControlliService())) {

                    UtilControlli.controlloRegistrazioneStallaDuplicato(bufala, this.getControlliService(),
                            this.getAzienda().getCuaa(), this.getAzienda().getAnnoCampagna(), this.getSessione());
                    this.importoLiquidabile = importoLiquidabile.add(BigDecimal.ONE);
                    if (UtilControlli.controlloTempisticheDiRegistrazione(bufala, getAzienda().getAnnoCampagna())) {
                        this.capiSanzionati++;
                        listaCapiSanzionati.add(bufala);
                    }
                } else {

                    if (bufala.getDtNascitaVitello() != null) {
                        LocalDate dataNascitaVitello = LocalDateConverter
                                .convertToLocalDateViaInstant(bufala.getDtNascitaVitello());
                        if (dataNascitaVitello.getYear() == getAzienda().getAnnoCampagna()) {
                            LocalDate dataNascita = LocalDateConverter
                                    .convertToLocalDateViaInstant(bufala.getDataNascita());
                            LocalDate oggi = LocalDateConverter.convertToLocalDateViaInstant(new Date());
                            long mesiDiVita = ChronoUnit.MONTHS.between(dataNascita, oggi);
                            if (mesiDiVita > ETA_RICHIESTA_IN_MESI) {

                                UtilControlli.controlloRegistrazioneStallaDuplicato(bufala, this.getControlliService(),
                                        this.getAzienda().getCuaa(), this.getAzienda().getAnnoCampagna(),
                                        this.getSessione());
                                this.importoLiquidabile = importoLiquidabile.add(BigDecimal.ONE);
                                if (UtilControlli.controlloTempisticheDiRegistrazione(bufala, getAzienda().getAnnoCampagna())) {
                                    listaCapiSanzionati.add(bufala);
                                    this.capiSanzionati++;
                                }
                            } else {
                                addEscluso(bufala, "I mesi di vita del capo sono inferiori o uguali a 30.");
                            }
                        } else {
                            addEscluso(bufala, "Il capo non ha partorito nell'anno.");
                        }
                    } else {
                        addEscluso(bufala, "Il capo non ha partorito nell'anno.");
                    }
                }
            }

        } else {
            System.out.println(
                    "ERRORE CALCOLO INTERVENTO 312 MISURA 3, NESSUNA VACCA PRESENTE, IMPOSSIBILE ESEGUIRE IL CALCOLO DEL PREMIO REF02.003");
            throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_02003", getInput(),
                    "Nessuna vacca presente impossibile eseguire il calcolo del premio"));
        }
        if (1==1)
            System.out.println("CALCOLO INTERVENTO 312 MISURA 3, FINE ESECUZIONE");
    }

    /**
     * il metodo postEsecuzione effettua il salvataggio a db dei risultati
     * dell'intervento
     *
     * @throws ControlloException eccezione relativa al controllo di tipo
     *                            {@link ControlloException}
     */
    @Override
    public void postEsecuzione() throws ControlloException {
        // ESECUZIONI CONTROLLI PER SOGGETTO
        if (1==1)
            System.out.println("CALCOLO INTERVENTO 312 MISURA 3, INIZIO POST-ESECUZIONE");
        Dmt_t_output_controlli outputControlli = new Dmt_t_output_controlli();
        outputControlli.setIdSessione(getSessione());
        outputControlli.setAnnoCampagna(getAzienda().getAnnoCampagna());
        outputControlli.setCapiAmmissibili(importoLiquidabile);
        outputControlli.setCapiRichiesti(sizeModelVacche);
        outputControlli.setCuaa(getAzienda().getCuaa());
        outputControlli.setIntervento(getAzienda().getCodicePremio());

        getControlliService().saveOutput(outputControlli);
        for (Dmt_t_Tws_bdn_du_capi_bovini x : this.listaCapiBocciati) {
            Dmt_t_output_esclusi oe = new Dmt_t_output_esclusi();
            oe.setCalcolo(getClass().getSimpleName());
            oe.setCapoId(x.getCapoId());
            oe.setIdSessione(getSessione());
            oe.setCuaa(getAzienda().getCuaa());
            oe.setTipologiaEsclusione(x.getTipologiaEsclusione());
            oe.setCodicePremio(getAzienda().getCodicePremio());
            oe.setMotivazioneEsclusione(x.getMotivazioneEsclusione());
            this.getControlliService().saveOutputEscl(oe);
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
            this.getControlliService().saveOutputEscl(oe);
        }

        if (1==1)
            System.out.println("CALCOLO INTERVENTO 312 MISURA 3, FINE POST-ESECUZIONE");
        System.out.println("FINE ESECUZIONE CALCOLO INTERVENTO 312 MISURA 3");
    }

    private void setListEsclusi(List<Dmt_t_Tws_bdn_du_capi_bovini> bovini, String motivazione) {
        for (Dmt_t_Tws_bdn_du_capi_bovini b : bovini) {
            b.setMotivazioneEsclusione(motivazione);
            b.setTipologiaEsclusione("E");
            listaCapiBocciati.add(b);
        }

    }

    private void addEscluso(Dmt_t_Tws_bdn_du_capi_bovini capo, String motivazione) {
        capo.setMotivazioneEsclusione(motivazione);
        capo.setTipologiaEsclusione("E");
        listaCapiBocciati.add(capo);
    }

    private void resetLists() {

        if (this.importoLiquidabile.compareTo(BigDecimal.ZERO) > 0)
            this.importoLiquidabile = BigDecimal.ZERO;

        if (this.listVaccheDetentoriAllevAttivi != null)
            this.listVaccheDetentoriAllevAttivi.clear();

        if (this.listVaccheDetentoriAllevNonAttivi != null)
            this.listVaccheDetentoriAllevNonAttivi.clear();

        if (this.modelVacche != null)
            this.modelVacche.clear();

        if (this.modelVaccheAmmesseRegCapi != null)
            this.modelVaccheAmmesseRegCapi.clear();

        if (this.modelVaccheAmmesseUba != null)
            this.modelVaccheAmmesseUba.clear();

        if (this.modelVaccheTmp != null)
            this.modelVaccheTmp.clear();

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
                    this.getAzienda().getCodicePremio())
                    &&
                    // UtilControlli.controlloAmmissibilitaPremioPerPremiCompatibili(
                    // (Dmt_t_Tws_bdn_du_capi_bovini) capo) &&
                    UtilControlli.controlloDemarcazione((Dmt_t_Tws_bdn_du_capi_bovini) capo, this.getControlliService(),
                            this.getAzienda().getAnnoCampagna()))
                listaCapiDichiarati.add(capo);

        return listaCapiDichiarati.isEmpty() ? Collections.emptyList() : listaCapiDichiarati;
    }

}
