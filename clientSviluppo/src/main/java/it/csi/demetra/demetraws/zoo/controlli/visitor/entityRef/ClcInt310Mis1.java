package it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef;

import it.csi.demetra.demetraws.zoo.calcoli.CalcoloException;
import it.csi.demetra.demetraws.zoo.calcoli.CtlUbaMinime;
import it.csi.demetra.demetraws.zoo.calcoli.CtlVerificaRegistrazioneCapi;
import it.csi.demetra.demetraws.zoo.controlli.UtilControlli;
import it.csi.demetra.demetraws.zoo.controlli.visitor.ControlloException;
import it.csi.demetra.demetraws.zoo.model.Analisi_produzioni_cuua;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_bovini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_errore;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_esclusi;
import it.csi.demetra.demetraws.zoo.repository.Analisi_produzioni_cuua_repository;
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

    /* MODEL DA INIZIALIZZARE PER I CONTROLLI */
    private List<Dmt_t_Tws_bdn_du_capi_bovini> modelVacche;
    private Integer importoLiquidabile;
    private Integer importoRichiesto;
    private List<Dmt_t_output_esclusi> listEsclusi = new ArrayList<>();

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

        boolean isAllevamentoChecked = true;
        List<Integer> listMesiControllati = new ArrayList<>();
        // Tolleranze per i mesi in cui è presente una sola analisi
        int tolleranzaCSOM = 0;
        int tolleranzaCMIC = 0;
        int tolleranzaPP = 0;
        boolean isAllevamentoInPianura = false;
        boolean isCircuitoQualitaFormaggio = false;

        List<Analisi_produzioni_cuua> listAnalisiProduzioniCuua = analisiProduzioniCuuaRepository.getByCUUAAndYear(getAzienda().getCuaa(), getAzienda().getAnnoCampagna());
        Calendar calendar = Calendar.getInstance();
        /** PER VERIFICARE LA LISTA DEI MESI CONTROLLATI BISOGNA ACCEDERE AI DATI DELLA VENDITA DIRETTA */
        int countCSOM;
        int countCMIC;
        int countPP;
        for (Integer i : listMesiControllati) { //1=GENNAIO,12=DICEMBRE
            countCSOM = 0;
            countCMIC = 0;
            countPP = 0;
            for (Analisi_produzioni_cuua apc : listAnalisiProduzioniCuua) {
                if (null == apc.getDataAnalisi()) continue;
                calendar.setTime(apc.getDataAnalisi());
                if (calendar.get(Calendar.MONTH) == i) {
                    if (null != apc.getCelluleSomatiche()) countCSOM++;
                    if (null != apc.getProteine()) countPP++;
                    if (null != apc.getCaricaBatterica()) countCMIC++;

                }
            }

            if (countCMIC == 0 || countCSOM == 0 || countPP == 0) {
                // SE PER UN MESE IN CUI E' STATA DICHIARATA LA PRODUZIONE NON E' PRESENTE L'ANALISI DEI DATI NON POSSO ACCEDERE AL PREMIO
                isAllevamentoChecked = false;
                break;
            }
            tolleranzaCMIC += countCMIC == 1 ? 1 : 0;
            tolleranzaCSOM += countCSOM == 1 ? 1 : 0;
            tolleranzaPP += countPP == 1 ? 1 : 0;
        }

        if (isAllevamentoChecked && isAllevamentoInPianura) {
            if (tolleranzaCMIC > 2 || tolleranzaCSOM > 2 || tolleranzaPP > 2)
                isAllevamentoChecked = false;
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
            if (!isAllevamentoInPianura && isCircuitoQualitaFormaggio && FLAG_MEDIE == 0) {
                isAllevamentoChecked = false;
            } else if (FLAG_MEDIE < 2) {
                isAllevamentoChecked = false;
            } else {
                if (FLAG_MEDIE_CSOM == 0) {
                    isAllevamentoChecked = CSOM_MED < SOGLIA_CSOM_MED_2;
                }
                if (FLAG_MEDIE_CMIC == 0) {
                    isAllevamentoChecked = CMIC_MED < SOGLIA_CMIC_MED_2;
                }
                if (FLAG_MEDIE_PP == 0) {
                    isAllevamentoChecked = PP_MED > SOGLIA_CMIC_MED_2;
                }
            }
        }

        if (isAllevamentoChecked)
            for (Dmt_t_Tws_bdn_du_capi_bovini b : modelVacche) {
                /**
                 * PRIMO CONTROLLO CHE IL CUAA SIA IL DETENTORE DELL'ALLEVAMENTO AL MOMENTO DEL PARTO.
                 */
                List<Dmt_t_Tws_bdn_du_capi_bovini> listVitelli = getControlliService().getVitelliNatiDaBovini(getSessione().getIdSessione(), b.getCapoId(), b.getCodicePremio());
                if (!UtilControlli.isDetentoreParto(b, listVitelli)) {
                    this.listEsclusi.add(UtilControlli.generaEscluso(b, getSessione(), "Il richiedente non è detentore del capo al momento del parto", getAzienda().getCodicePremio()));
                    continue;
                } else importoLiquidabile++;
            }
    }

    @Override
    public void postEsecuzione() throws ControlloException {

    }
}
