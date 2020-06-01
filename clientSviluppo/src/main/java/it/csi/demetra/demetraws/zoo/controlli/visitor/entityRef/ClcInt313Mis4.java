package it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef;

import it.csi.demetra.demetraws.zoo.calcoli.CalcoloException;
import it.csi.demetra.demetraws.zoo.calcoli.CtlUbaMinime;
import it.csi.demetra.demetraws.zoo.calcoli.CtlVerificaRegistrazioneCapi;
import it.csi.demetra.demetraws.zoo.controlli.UtilControlli;
import it.csi.demetra.demetraws.zoo.controlli.visitor.ControlloException;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_bovini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_errore;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_esclusi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Federico Pomponii
 * Title: Intervento 313 - Misura 4
 */
@Component("ClcInt313Mis4")
public class ClcInt313Mis4 extends Controllo {

    @Autowired
    CtlVerificaRegistrazioneCapi ref9901;
    @Autowired
    CtlUbaMinime ref9903;

    /* MODEL DA INIZIALIZZARE PER I CONTROLLI */
    private List<Dmt_t_Tws_bdn_du_capi_bovini> modelVacche;
    private Integer importoLiquidabile;
    private Integer importoRichiesto;
    private List<Dmt_t_output_esclusi> listEsclusi = new ArrayList<>();

    private void init() {
        listEsclusi = new ArrayList<>();
        importoRichiesto = null != modelVacche ? modelVacche.size() : 0;
        importoLiquidabile = 0;
    }

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

            try {
                ref9903.init(modelVacche, getAzienda().getCodicePremio(), Long.valueOf(getAzienda().getAnnoCampagna()), getAzienda().getCuaa(), getSessione());
                ref9903.calcolo();
            } catch (CalcoloException e) {
                throw new ControlloException(new Dmt_t_errore(getSessione(), "REF_9903", getInput(), e.getMessage()));
            }
        }
    }

    @Override
    public void esecuzione() throws ControlloException {
        if (null == modelVacche) return;

        importoLiquidabile = 0;
        for (Dmt_t_Tws_bdn_du_capi_bovini b : modelVacche) {
            List<Dmt_t_Tws_bdn_du_capi_bovini> listVitelli = getControlliService().getVitelliNatiDaBovini(getSessione().getIdSessione(), b.getCapoId(), b.getCodicePremio());
            if (!UtilControlli.isDetentoreParto(b, listVitelli)) {
                this.listEsclusi.add(UtilControlli.generaEscluso(b, getSessione(), "Il richiedente non è detentore del capo al momento del parto", getAzienda().getCodicePremio()));
                continue;
            } else importoLiquidabile++;
        }
    }


    @Override
    public void postEsecuzione() throws ControlloException {
        // ESECUZIONI CONTROLLI PER SOGGETTO
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
