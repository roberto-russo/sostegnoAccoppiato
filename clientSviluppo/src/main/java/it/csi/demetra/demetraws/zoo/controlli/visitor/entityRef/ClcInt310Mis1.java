package it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef;

import it.csi.demetra.demetraws.zoo.calcoli.CalcoloException;
import it.csi.demetra.demetraws.zoo.calcoli.CtlUbaMinime;
import it.csi.demetra.demetraws.zoo.calcoli.CtlVerificaRegistrazioneCapi;
import it.csi.demetra.demetraws.zoo.controlli.UtilControlli;
import it.csi.demetra.demetraws.zoo.controlli.visitor.ControlloException;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_bovini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_errore;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_esclusi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Federico Pomponii
 * Title: Intervento 310 - Misura 1
 */
@Component("ClcInt310Mis1")
public class ClcInt310Mis1 extends Controllo {

    // SOGLIE PER I CALCOLI.
    private static final Long SOGLIA_CSOM_MED = new Long(300 * 10^3);
    private static final Long SOGLIA_CMIC_MED = new Long(40* 10^3);
    private static final BigDecimal SOGLIA_PP_MED = new BigDecimal("3.35");

    // SOGLIE PER I CALCOLI 2.
    private static final Long SOGLIA_CSOM_MED_2 = new Long(400 * 10^3);
    private static final Long SOGLIA_CMIC_MED_2 = new Long(100* 10^3);
    private static final BigDecimal SOGLIA_PP_MED_2 = new BigDecimal("3.20");



    @Autowired
    CtlVerificaRegistrazioneCapi ref9901;
    @Autowired
    CtlUbaMinime ref9903;

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
        for (Dmt_t_Tws_bdn_du_capi_bovini b : modelVacche) {
            /**
             * PRIMO CONTROLLO CHE IL CUAA SIA IL DETENTORE DELL'ALLEVAMENTO AL MOMENTO DEL PARTO.
             */
            List<Dmt_t_Tws_bdn_du_capi_bovini> listVitelli = getControlliService().getVitelliNatiDaBovini(getSessione().getIdSessione(), b.getCapoId(), b.getCodicePremio());
            if (!UtilControlli.isDetentoreParto(b, listVitelli)) {
                this.listEsclusi.add(UtilControlli.generaEscluso(b, getSessione(), "Il richiedente non è detentore del capo al momento del parto", getAzienda().getCodicePremio()));
                continue;
            }


        }
    }

    @Override
    public void postEsecuzione() throws ControlloException {

    }
}
