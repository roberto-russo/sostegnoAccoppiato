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
 * controlli da applicare per il calcolo del premio zootecnia per l’intervento
 * 314 – Misura 18:<br>
 * vacche nutrici di razze da carne o a duplice attitudine iscritte nei Libri
 * genealogici o nel Registro anagrafico delle razze bovine
 *
 * @author Federico Pomponii
 */
@Component("ClcInt314Mis18")
public class ClcInt314Mis18 extends Controllo {


    @Autowired
    CtlVerificaRegistrazioneCapi ref9901;
    @Autowired
    Dmt_t_tws_bdn_du_capi_bovini_services capiBoviniService;

    /* MODEL DA INIZIALIZZARE PER I CONTROLLI */
    private List<Dmt_t_Tws_bdn_du_capi_bovini> modelVacche;
    private List<Dmt_t_Tws_bdn_du_capi_bovini> modelVaccheFiltrate;
    private BigDecimal importoLiquidabile;
    private BigDecimal importoRichiesto;
    private Integer capiSanzionati;
    private List<Dmt_t_Tws_bdn_du_capi_bovini> listaCapiBocciati;
    private List<Dmt_t_Tws_bdn_du_capi_bovini> listaCapiSanzionati;
    private ResultCtlUbaMinime ubaMin;

    private void init() {
        System.out.println("INIZIO CALCOLO INTERVENTO 314 MISURA 18");
        importoRichiesto = null != modelVacche ? new BigDecimal(modelVacche.size()) : BigDecimal.ZERO;
        importoLiquidabile = new BigDecimal(0);
        modelVaccheFiltrate = null;
        ubaMin = null;
        listaCapiSanzionati = new ArrayList<>();
    }

    /**
     * il metodo preEsecuzione utilizza i controlli:
     * {@link it.csi.demetra.demetraws.zoo.calcoli.CtlVerificaRegistrazioneCapi} e
     * {@link it.csi.demetra.demetraws.zoo.calcoli.CtlUbaMinime}
     *
     * @return
     * @throws ControlloException eccezione relativa al controllo di tipo
     *                            {@link ControlloException}
     */
    @Override
    public List<Dmt_t_Tws_bdn_du_capi_bovini> preEsecuzione() throws ControlloException {
        if (1==1)
            System.out.println("CALCOLO INTERVENTO 314 MISURA 18, INIZIO PRE-ESECUZIONE");
        this.capiSanzionati = 0;
        // RECUPERO DATI DALLA BDN
        // modelVacche = getControlliService().getAllBoviniSessioneCuua(getSessione(),
        // getAzienda().getCuaa(),
        // getAzienda().getCodicePremio());

        listaCapiBocciati = new ArrayList<>();
        modelVacche = this.controlloCapiDichiarati(getControlliService().getAllBoviniSessioneCuua(getSessione(),
                getAzienda().getCuaa(), getAzienda().getCodicePremio()));
        init();
        if (modelVacche != null && modelVacche.size() > 0) {
            try {
                ref9901.init(modelVacche, getSessione().getIdSessione(), getAzienda().getCodicePremio(),
                        Long.valueOf(getAzienda().getAnnoCampagna()), getAzienda().getCuaa());
                modelVacche = ref9901.calcolo();
            } catch (CalcoloException e) {
                System.out.println(
                        "ERRORE CALCOLO INTERVENTO 314 MISURA 18, ERRORE DURANTE L'ESECUZIONE DEL CONTROLLO TEMPISTICA REGISTRAZIONE CAPI REF99.01");
                throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_9901", getInput(), e.getMessage()));
            }

            this.modelVaccheFiltrate = capiBoviniService.getBoviniUbaMinime(getSessione().getIdSessione(),
                    getAzienda().getCuaa(), getAzienda().getCodicePremio());

        }
        if (1==1)
            System.out.println("CALCOLO INTERVENTO 314 MISURA 18 FINE PRE-ESECUZIONE");
        System.out.println(
                "I CONTROLLI DI PRE-CALCOLO PER IL CALCOLO INTERVENTO 314 MISURA 18 SONO STATI ESEGUITI CORRETTAMENTE ✔");

        return modelVacche;
    }

    /**
     * il metodo esecuzione effettua l'esecuzione dei controlli per l'intervento 314
     * Misura 18
     *
     * @throws ControlloException eccezione relativa al controllo di tipo
     *                            {@link ControlloException}
     */
    @Override
    public void esecuzione(List<Dmt_t_premio_capi> listUbaMinime) throws ControlloException {
        if (1==1)
            System.out.println("CALCOLO INTERVENTO 314 MISURA 18 INIZIO ESECUZIONE");

        this.modelVaccheFiltrate = capiBoviniService.getBoviniUbaMinime(getSessione().getIdSessione(),
                getAzienda().getCuaa(), getAzienda().getCodicePremio());
        importoLiquidabile = BigDecimal.ZERO;

        try {
            for (Dmt_t_Tws_bdn_du_capi_bovini b : modelVaccheFiltrate) {
                // SE IL BENEFICIARIO DEL CAPO DOPPIO VA SCELTO IN BASE AL CAA
                if (UtilControlli.isBeneficiarioCapiDoppi(this.getAzienda().getAnnoCampagna(),
                        this.getAzienda().getCodicePremio(), this.getAzienda().getCuaa(), b.getCapoId(),
                        this.getControlliService())) {
                    UtilControlli.controlloRegistrazioneStallaDuplicato(b, this.getControlliService(),
                            this.getAzienda().getCuaa(), this.getAzienda().getAnnoCampagna(), this.getSessione());
                    this.importoLiquidabile = importoLiquidabile.add(BigDecimal.ONE);
                    if (UtilControlli.controlloTempisticheDiRegistrazione(b)) {
                        listaCapiSanzionati.add(b);
                        this.capiSanzionati++;
                    }
                } else {

                    // ALTRIMENTI SI PROCEDE ALLA DETERMINAZIONE DEL BENEFICIARIO DEL CAPO DOPPIO IN
                    // MANIERA CLASSICA

                    List<Dmt_t_Tws_bdn_du_capi_bovini> listVitelli = getControlliService()
                            .getVitelliNatiDaBovini(getSessione().getIdSessione(), b.getCapoId(), b.getCodicePremio());
                    if (!UtilControlli.isDetentoreParto(b, listVitelli)) {
                        b.setMotivazioneEsclusione("Il richiedente non e' detentore del capo al momento del parto");
                        b.setTipologiaEsclusione("E");
                        listaCapiBocciati.add(b);
                        continue;
                    }
                }

                if (null != b.getFlagIbr() && b.getFlagIbr().equals("S")) {
                    UtilControlli.controlloRegistrazioneStallaDuplicato(b, this.getControlliService(),
                            this.getAzienda().getCuaa(), this.getAzienda().getAnnoCampagna(), this.getSessione());
                    importoLiquidabile = importoLiquidabile.add(BigDecimal.ONE);
                } else {
                    b.setTipologiaEsclusione("E");
                    listaCapiBocciati.add(b);
                }
            }

        } catch (NullPointerException e) {
            System.out.println("ERRORE CALCOLO INTERVENTO 314 MISURA 18, NESSUN CAPO DISPONIBILE");
            throw new ControlloException(
                    new Dmt_t_errore(getSessione(), "esecuzione", getInput(), "nessun capo disponibile"));
        }
        if (1==1)
            System.out.println("CALCOLO INTERVENTO 314 MISURA 18 FINE ESECUZIONE");
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
            System.out.println("CALCOLO INTERVENTO 314 MISURA 18 INIZIO POST-ESECUZIONE");
        Dmt_t_output_controlli outputControlli = new Dmt_t_output_controlli();
        outputControlli.setIdSessione(getSessione());
        outputControlli.setAnnoCampagna(getAzienda().getAnnoCampagna());
        outputControlli.setCapiAmmissibili(importoLiquidabile);
        outputControlli.setCapiRichiesti(importoRichiesto);
        outputControlli.setCapiSanzionati(capiSanzionati);
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
            System.out.println("CALCOLO INTERVENTO 314 MISURA 18 FINE POST-ESECUZIONE");
        System.out.println("FINE ESECUZIONE CALCOLO INTERVENTO 314 MISURA 18");
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
                    && UtilControlli.controlloAmmissibilitaPremio314((Dmt_t_Tws_bdn_du_capi_bovini) capo) &&
                    // UtilControlli.controlloAmmissibilitaPremioPerPremiCompatibili(
                    // (Dmt_t_Tws_bdn_du_capi_bovini) capo) &&
                    UtilControlli.controlloDemarcazione((Dmt_t_Tws_bdn_du_capi_bovini) capo, this.getControlliService(),
                            this.getAzienda().getAnnoCampagna()))
                listaCapiDichiarati.add(capo);
            else {
                ((Dmt_t_Tws_bdn_du_capi_bovini) capo).setTipologiaEsclusione("E");
                ((Dmt_t_Tws_bdn_du_capi_bovini) capo).setMotivazioneEsclusione("Criterio IBR non rispettato o pagato su PSR");
                listaCapiBocciati.add((Dmt_t_Tws_bdn_du_capi_bovini) capo);
            }

        return listaCapiDichiarati.isEmpty() ? Collections.emptyList() : listaCapiDichiarati;
    }
}
