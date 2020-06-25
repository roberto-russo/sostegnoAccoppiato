package it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef;

import it.csi.demetra.demetraws.zoo.calcoli.CalcoloException;
import it.csi.demetra.demetraws.zoo.calcoli.CtlUbaMinime;
import it.csi.demetra.demetraws.zoo.calcoli.CtlVerificaRegistrazioneCapi;
import it.csi.demetra.demetraws.zoo.calcoli.entity.ResultCtlUbaMinime;
import it.csi.demetra.demetraws.zoo.controlli.UtilControlli;
import it.csi.demetra.demetraws.zoo.controlli.visitor.ControlloException;
import it.csi.demetra.demetraws.zoo.model.*;
import it.csi.demetra.demetraws.zoo.repository.Analisi_produzioni_cuua_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_tlatte_vendita_diretta_repository;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_tws_bdn_du_capi_bovini_services;

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
    
    @Autowired
    Dmt_t_tws_bdn_du_capi_bovini_services capiBoviniService;

    /* MODEL DA INIZIALIZZARE PER I CONTROLLI */
    private List<Dmt_t_Tws_bdn_du_capi_bovini> modelVacche;
	private List<Dmt_t_Tws_bdn_du_capi_bovini> modelVaccheFiltrate;
    private Integer importoLiquidabile;
    private Integer importoRichiesto;
    private List<Dmt_t_output_esclusi> listEsclusi;
    private String motivazioneEsclusione = "";
    private Boolean isProduttoreChecked;
	private ResultCtlUbaMinime ubaMin;



    private void init() {
        listEsclusi = new ArrayList<>();
        importoRichiesto = null != modelVacche ? modelVacche.size() : 0;
        importoLiquidabile = 0;
        modelVaccheFiltrate = null;
    }

    /**
     * ClcInt310Mis1 - preEsecuzione() intervento 310 Misura 1
     * Ref case utilizzati : Ref99.01 - Ref99.03
     *
     * @throws ControlloException eccezzione relativa al controllo di tipo {@link ControlloException}
     */
    @Override
    public void preEsecuzione() throws ControlloException {
        // RECUPERO DATI DALLA BDN
        modelVacche = getControlliService().getAllBoviniSessioneCuua(getSessione(), getAzienda().getCuaa(), getAzienda().getCodicePremio());
        init();
        if (modelVacche != null && modelVacche.size() > 0) {
            try {
                ref9901.init(modelVacche, getSessione().getIdSessione(), getAzienda().getCodicePremio(), Long.valueOf(getAzienda().getAnnoCampagna()), getAzienda().getCuaa());
                modelVacche = ref9901.calcolo();
            } catch (CalcoloException e) {
                throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_9901", getInput(), e.getMessage()));
            }

            ref9903.init(modelVacche, getAzienda().getCodicePremio(), Long.valueOf(getAzienda().getAnnoCampagna()), getAzienda().getCuaa(), getSessione());
            try {
            	ubaMin = ref9903.calcolo();
            	if( ubaMin.isErrors())
    				throw new CalcoloException("errore durante l'esecuzione del controllo delle uba minime");
    			else
    				if(!ubaMin.isResult())
    					throw new ControlloException(new Dmt_t_errore(getSessione(), "ClcInt310Mis1", getInput(), "controllo uba minime non rispettato"));
            } catch (CalcoloException e) {
                throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_9903", getInput(), e.getMessage()));
            }
    		this.modelVaccheFiltrate = capiBoviniService.getBoviniUbaMinime(getSessione().getIdSessione(), getAzienda().getCuaa(), getAzienda().getCodicePremio());
        }
    }


    /**
     * ClcInt310Mis1 - Esecuzione()
     * Esecuzione dei controlli per l'intervento 310 Misura 1
     *
     * @throws ControlloException eccezione relativa al controllo di tipov {@link ControlloException}
     */
    @Override
    public void esecuzione() throws ControlloException {
        if (null == modelVaccheFiltrate) return;
        /*
         * PUNTI APERTI DA CHIARIRE.
         * Per valutare se un allevamento è adibito alla vendita diretta di latte controllo la tabella
         * Dmt_t_Tlatte_vendita_diretta?
         * Definire un metodo per riempire questa tabella: Vedi Antonio e Giuseppe
         * Bisogna definire quali allevamenti sono in pianura
         * 
         * 
         * RISPOSTA DI ANTONIO: Dmt_t_Tlatte_vendita_diretta è una di quelle tabelle il cui riempimento viene fatto dal cliente.
         * Non c'è bisogno di fare un metodo per prevederne il riempimento. (almeno così ho capito da un confronto con Roberto).
         * Ad ogni modo parlare con Roberto se ci sono delle incertezze in merito.
         **/

        isProduttoreChecked = true;
        List<Integer> listMesiControllati = new ArrayList<>();
        // Tolleranze per i mesi in cui è presente una sola analisi
        int tolleranzaCSOM = 0;
        int tolleranzaCMIC = 0;
        int tolleranzaPP = 0;

        Dmt_t_certificato_igp_dop dmtCID = getControlliService().getCertificatoIgpDop(getAzienda().getCuaa());
        if (dmtCID == null) {
            isProduttoreChecked = false;
            motivazioneEsclusione = "Impossibile reperire informazioni sul produttore";
            throw new ControlloException(new Dmt_t_errore(getSessione(), "esecuzione", getInput(), motivazioneEsclusione));
        }
        Boolean isProduttoreMontagna = dmtCID.getZona() != null && dmtCID.getZona().equals("M");
        Boolean isProduttoreAlpeggio = dmtCID.getAlpeggio() != null && dmtCID.getAlpeggio().equals("S");
        Boolean isCircuitoQualitaFormaggio = dmtCID.getFlagDop() != null && dmtCID.getFlagDop().equals("S");

        List<Dmt_T_analisi_produzioni_cuua> listAnalisiProduzioniCuua = analisiProduzioniCuuaRepository.getByCUUAAndYear(getAzienda().getCuaa(), getAzienda().getAnnoCampagna());

        List<Dmt_t_latte_vendita_diretta> listDmtLVD = dmt_t_tlatte_vendita_diretta_repository.findByCUUAAndAnnoCampagna(getAzienda().getCuaa(), getAzienda().getAnnoCampagna());
        Integer month;
        for (Dmt_t_latte_vendita_diretta dmtLVD : listDmtLVD) {
            month = UtilControlli.convertCodiceMeseInt(dmtLVD.getMese());
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
            for (Dmt_T_analisi_produzioni_cuua apc : listAnalisiProduzioniCuua) {
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
                throw new ControlloException(new Dmt_t_errore(getSessione(), "esecuzione", getInput(), motivazioneEsclusione));
            }
            tolleranzaCMIC += countCMIC == 1 ? 1 : 0;
            tolleranzaCSOM += countCSOM == 1 ? 1 : 0;
            tolleranzaPP += countPP == 1 ? 1 : 0;
        }

        if (isProduttoreChecked && !isProduttoreMontagna && !isProduttoreAlpeggio) {
            if (tolleranzaCMIC > 2 || tolleranzaCSOM > 2 || tolleranzaPP > 2) {
                isProduttoreChecked = false;
                motivazioneEsclusione = "Per gli allevamentiin  pianura è necessario che siano state comunicate almeno due analisi per ogni mese di produzione";
                throw new ControlloException(new Dmt_t_errore(getSessione(), "esecuzione", getInput(), motivazioneEsclusione));
            }
        }

        List<BigDecimal> csomList = new ArrayList<>();
        List<BigDecimal> cmicList = new ArrayList<>();
        List<BigDecimal> ppList = new ArrayList<>();
        for (Dmt_T_analisi_produzioni_cuua apc : listAnalisiProduzioniCuua) {
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
            if (isProduttoreMontagna && isCircuitoQualitaFormaggio && FLAG_MEDIE == 0) {
                isProduttoreChecked = false;
                throw new ControlloException(new Dmt_t_errore(getSessione(), "esecuzione", getInput(), motivazioneEsclusione));
            } else if (FLAG_MEDIE < 2) {
                isProduttoreChecked = false;
                throw new ControlloException(new Dmt_t_errore(getSessione(), "esecuzione", getInput(), motivazioneEsclusione));
            } else {
                if (FLAG_MEDIE_CSOM == 0) {
                    isProduttoreChecked = CSOM_MED < SOGLIA_CSOM_MED_2;
                }
                if (FLAG_MEDIE_CMIC == 0) {
                    isProduttoreChecked = CMIC_MED < SOGLIA_CMIC_MED_2;
                }
                if (FLAG_MEDIE_PP == 0) {
                    isProduttoreChecked = PP_MED > SOGLIA_PP_MED_2;
                }
            }
        }

        if (!isProduttoreChecked) {
            motivazioneEsclusione = "I valori delle medie non sono stati rispettati";
            throw new ControlloException(new Dmt_t_errore(getSessione(), "esecuzione", getInput(), motivazioneEsclusione));
        }

        if (isProduttoreChecked) {
            for (Dmt_t_Tws_bdn_du_capi_bovini b : modelVaccheFiltrate) {
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
        System.out.println(getClass().getName() + " postEsecuzione()");
        Dmt_t_output_controlli outputControlli = new Dmt_t_output_controlli();
        outputControlli.setIdSessione(getSessione());
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
