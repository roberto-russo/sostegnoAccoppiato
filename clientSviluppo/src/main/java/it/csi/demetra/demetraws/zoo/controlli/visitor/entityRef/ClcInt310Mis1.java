package it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef;

import it.csi.demetra.demetraws.zoo.calcoli.CalcoloException;
import it.csi.demetra.demetraws.zoo.calcoli.CtlUbaMinime;
import it.csi.demetra.demetraws.zoo.calcoli.CtlVerificaRegistrazioneCapi;
import it.csi.demetra.demetraws.zoo.controlli.UtilControlli;
import it.csi.demetra.demetraws.zoo.controlli.visitor.ControlloException;
import it.csi.demetra.demetraws.zoo.model.*;
import it.csi.demetra.demetraws.zoo.repository.Analisi_produzioni_cuua_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_tlatte_vendita_diretta_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Author: Federico Pomponii
 * Title: Intervento 310 - Misura 1
 */
@Component("ClcInt310Mis1")
public class ClcInt310Mis1 extends Controllo {

    // SOGLIE PER I CALCOLI.
    private static final Long SOGLIA_CSOM_MED = new Long(300 * 10 ^ 3);
    private static final Long SOGLIA_CMIC_MED = new Long(40 * 10 ^ 3);
    private static final Double SOGLIA_PP_MED = 3.35;

    // SOGLIE PER I CALCOLI 2.
    private static final Long SOGLIA_CSOM_MED_2 = new Long(400 * 10 ^ 3);
    private static final Long SOGLIA_CMIC_MED_2 = new Long(100 * 10 ^ 3);
    private static final Double SOGLIA_PP_MED_2 = 3.20;


    @Autowired
    CtlVerificaRegistrazioneCapi ref9901;
    @Autowired
    CtlUbaMinime ref9903;
    @Autowired
    Analisi_produzioni_cuua_repository analisiProduzioniCuuaRepository;
    @Autowired
    Dmt_t_tlatte_vendita_diretta_repository dmt_t_tlatte_vendita_diretta_repository; //DA CONVERTIRE IN SERVICE

    /* MODEL DA INIZIALIZZARE PER I CONTROLLI */
    private List<Dmt_t_Tws_bdn_du_capi_bovini> modelVacche;
    private Integer importoLiquidabile;
    private Integer importoRichiesto;
    private List<Dmt_t_output_esclusi> listEsclusi = new ArrayList<>();
    private String motivazioneEsclusione = "";

    private void mockDataForTest() {
        Dmt_t_Tlatte_vendita_diretta dmtLVD = new Dmt_t_Tlatte_vendita_diretta();
        dmtLVD.setCodiceMese("GEN");
        dmtLVD.setSottoCodiceMese("GEN");
        dmtLVD.setSessione(getSessione());
        dmtLVD.setQuantita(100L);
        dmtLVD.setCuua(getAzienda().getCuaa());
        dmtLVD.setIdAzienda(1L);
        dmtLVD.setVersione(1L);
        dmtLVD.setProgrRiga(1L);
        dmtLVD.setMatricola(1L);
        dmt_t_tlatte_vendita_diretta_repository.save(dmtLVD);
        Dmt_t_Tlatte_vendita_diretta dmtLVD2 = new Dmt_t_Tlatte_vendita_diretta();
        dmtLVD2.setCodiceMese("DIC");
        dmtLVD2.setSottoCodiceMese("DIC");
        dmtLVD2.setSessione(getSessione());
        dmtLVD2.setQuantita(100L);
        dmtLVD2.setCuua(getAzienda().getCuaa());
        dmtLVD2.setIdAzienda(1L);
        dmtLVD2.setVersione(1L);
        dmtLVD2.setMatricola(1L);
        dmtLVD2.setProgrRiga(1L);
        dmt_t_tlatte_vendita_diretta_repository.save(dmtLVD2);
    }

    /**
     * ClcInt310Mis1 - preEsecuzione() intervento 310 Misura 1
     * Ref case utilizzati : Ref99.01 - Ref99.03
     *
     * @throws ControlloException
     */
    @Override
    public void preEsecuzione() throws ControlloException {
        // RECUPERO DATI DALLA BDN
        modelVacche = getControlliService().getAllBoviniSessioneCuua(getSessione(), getAzienda().getCuaa(), getAzienda().getCodicePremio());
        importoRichiesto = modelVacche.size();
        if (modelVacche != null && modelVacche.size() > 0) {
            try {
                ref9901.init(modelVacche, getSessione().getIdSessione(), getAzienda().getCodicePremio(), Long.valueOf(getAzienda().getAnnoCampagna()), getAzienda().getCuaa());
                modelVacche = ref9901.calcolo();
            } catch (CalcoloException e) {
                throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_9901", getInput(), e.getMessage()));
            }

            ref9903.init(modelVacche, getAzienda().getCodicePremio(), Long.valueOf(getAzienda().getAnnoCampagna()), getAzienda().getCuaa(), getSessione());
            try {
                ref9903.calcolo();
            } catch (CalcoloException e) {
                throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_9903", getInput(), e.getMessage()));
            }
        }
    }


    /**
     * ClcInt310Mis1 - Esecuzione()
     * Esecuzione dei controlli per l'intervento 310 Misura 1
     *
     * @throws ControlloException
     */
    @Override
    public void esecuzione() throws ControlloException {
        if (null == modelVacche) return;
        /**
         * PUNTI APERTI DA CHIARIRE.
         * Per valutare se un allevamento è adibito alla vendita diretta di latte controllo la tabella
         * Dmt_t_Tlatte_vendita_diretta?
         * Definire un metodo per riempire questa tabella: Vedi Antonio e Giuseppe
         * Bisogna definire quali allevamenti sono in pianura
         */

        mockDataForTest(); // DA RIMUOVERE

        boolean isProduttoreChecked = true;
        List<Integer> listMesiControllati = new ArrayList<>();
        // Tolleranze per i mesi in cui è presente una sola analisi
        int tolleranzaCSOM = 0;
        int tolleranzaCMIC = 0;
        int tolleranzaPP = 0;
        boolean isProduttorePianura = false;
        boolean isProduttoreAlpeggio = false;
        boolean isCircuitoQualitaFormaggio = false;

        List<Analisi_produzioni_cuua> listAnalisiProduzioniCuua = analisiProduzioniCuuaRepository.getByCUUAAndYear(getAzienda().getCuaa(), String.valueOf(getAzienda().getAnnoCampagna()));

        List<Dmt_t_Tlatte_vendita_diretta> listDmtLVD = dmt_t_tlatte_vendita_diretta_repository.findByCUUA(getAzienda().getCuaa());
        Integer month;
        for (Dmt_t_Tlatte_vendita_diretta dmtLVD : listDmtLVD) {
            month = UtilControlli.convertCodiceMeseInt(dmtLVD.getCodiceMese());
            if (listMesiControllati.indexOf(month) < 0)
                listMesiControllati.add(month);
        }

        /** PER VERIFICARE LA LISTA DEI MESI CONTROLLATI BISOGNA ACCEDERE AI DATI DELLA VENDITA DIRETTA */
        int countCSOM;
        int countCMIC;
        int countPP;
        Calendar calendar = Calendar.getInstance();
        for (Integer i : listMesiControllati) { //1=GENNAIO,12=DICEMBRE
            countCSOM = 0;
            countCMIC = 0;
            countPP = 0;
            for (Analisi_produzioni_cuua apc : listAnalisiProduzioniCuua) {
                if (null == apc.getDataAnalisi()) continue;
                calendar.setTime(apc.getDataAnalisi());
                if (calendar.get(Calendar.MONTH) == i - 1) {
                    if (null != apc.getCelluleSomatiche()) countCSOM++;
                    if (null != apc.getProteine()) countPP++;
                    if (null != apc.getCaricaBatterica()) countCMIC++;
                }
            }

            if ((countCMIC == 0 || countCSOM == 0 || countPP == 0) && !isProduttoreAlpeggio) {
                // SE PER UN MESE IN CUI E' STATA DICHIARATA LA PRODUZIONE NON E' PRESENTE L'ANALISI DEI DATI NON POSSO ACCEDERE AL PREMIO
                isProduttoreChecked = false;
                motivazioneEsclusione = "Per il mese " + i + " non sono stati inviati i dati sull'analisi";
                break;
            }
            tolleranzaCMIC += countCMIC == 1 ? 1 : 0;
            tolleranzaCSOM += countCSOM == 1 ? 1 : 0;
            tolleranzaPP += countPP == 1 ? 1 : 0;
        }

        if (isProduttoreChecked && isProduttorePianura) {
            if (tolleranzaCMIC > 2 || tolleranzaCSOM > 2 || tolleranzaPP > 2) {
                isProduttoreChecked = false;
                motivazioneEsclusione = "Per gli allevamenti in pianura è necessario che siano state comunicate almeno due analisi per ogni mese di produzione";
            }
        }

        List<BigDecimal> csomList = new ArrayList<>();
        List<BigDecimal> cmicList = new ArrayList<>();
        List<BigDecimal> ppList = new ArrayList<>();
        for (Analisi_produzioni_cuua apc : listAnalisiProduzioniCuua) {
            csomList.add(apc.getCelluleSomatiche());
            cmicList.add(apc.getCaricaBatterica());
            ppList.add(apc.getProteine());
        }

        double CSOM_MED = UtilControlli.mediaGeometrica(csomList);
        double CMIC_MED = UtilControlli.mediaGeometrica(cmicList);
        double PP_MED = UtilControlli.mediaAritmetica(ppList);

        int FLAG_MEDIE_CSOM = 0;
        int FLAG_MEDIE_CMIC = 0;
        int FLAG_MEDIE_PP = 0;

        if (CSOM_MED < SOGLIA_CSOM_MED) FLAG_MEDIE_CSOM++;
        if (CMIC_MED < SOGLIA_CMIC_MED) FLAG_MEDIE_CMIC++;
        if (PP_MED > SOGLIA_PP_MED) FLAG_MEDIE_PP++;

        int FLAG_MEDIE = FLAG_MEDIE_CMIC + FLAG_MEDIE_CSOM + FLAG_MEDIE_PP;

        if (FLAG_MEDIE < 3) {
            if (!isProduttorePianura && isCircuitoQualitaFormaggio && FLAG_MEDIE == 0) {
                isProduttoreChecked = false;
            } else if (FLAG_MEDIE < 2) {
                isProduttoreChecked = false;
            } else {
                if (FLAG_MEDIE_CSOM == 0) {
                    isProduttoreChecked = CSOM_MED < SOGLIA_CSOM_MED_2;
                }
                if (FLAG_MEDIE_CMIC == 0) {
                    isProduttoreChecked = CMIC_MED < SOGLIA_CMIC_MED_2;
                }
                if (FLAG_MEDIE_PP == 0) {
                    isProduttoreChecked = PP_MED > SOGLIA_CMIC_MED_2;
                }
            }
        }

        if (isProduttoreChecked) {
            for (Dmt_t_Tws_bdn_du_capi_bovini b : modelVacche) {
                /**
                 * PRIMA CONTROLLO CHE IL CUAA SIA IL DETENTORE DELL'ALLEVAMENTO AL MOMENTO DEL PARTO.
                 */
                List<Dmt_t_Tws_bdn_du_capi_bovini> listVitelli = getControlliService().getVitelliNatiDaBovini(getSessione().getIdSessione(), b.getCapoId(), b.getCodicePremio());
                if (!UtilControlli.isDetentoreParto(b, listVitelli)) {
                    this.listEsclusi.add(UtilControlli.generaEscluso(b, getSessione(), "Il richiedente non è detentore del capo al momento del parto", getAzienda().getCodicePremio()));
                    continue;
                } else importoLiquidabile++;
            }
        } else importoLiquidabile = 0;
    }

    @Override
    public void postEsecuzione() throws ControlloException {
        // ESECUZIONI CONTROLLI PER SOGGETTO
        Dmt_t_output_controlli outputControlli = new Dmt_t_output_controlli();
        outputControlli.setSessione(getSessione());
        outputControlli.setAnnoCampagna(getAzienda().getAnnoCampagna());
        outputControlli.setCapiAmmissibili(importoLiquidabile);
        outputControlli.setCapiRichiesti(importoRichiesto);
        outputControlli.setCuaa(getAzienda().getCuaa());
        outputControlli.setIntervento(getAzienda().getCodicePremio());
        getControlliService().saveOutput(outputControlli);

        for (Dmt_t_output_esclusi o : listEsclusi)
            getControlliService().saveOutputEscl(o);

    }
}
