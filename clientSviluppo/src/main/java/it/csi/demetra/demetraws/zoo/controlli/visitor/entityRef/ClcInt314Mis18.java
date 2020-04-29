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
import java.util.Date;
import java.util.List;

@Component("ref02_005")
public class ClcInt314Mis18 extends Controllo {

    @Autowired
    CtlVerificaRegistrazioneCapi ref9901;
    @Autowired
    CtlUbaMinime ref9903;

    /* MODEL DA INIZIALIZZARE PER I CONTROLLI */
    private List<Dmt_t_Tws_bdn_du_capi_bovini> modelVacche;
    private Integer importoLiquidabile;
    private Integer importoRichiesto;
    private List<Dmt_t_output_esclusi> listEsclusi = new ArrayList<>();

    @Override
    public void preEsecuzione() throws ControlloException {
        // RECUPERO DATI DALLA BDN
        modelVacche = getControlliService().getAllBoviniSessioneCuua(getSessione(), getAzienda().getCuaa(), getAzienda().getCodicePremio());
        importoRichiesto = modelVacche.size();
        if (modelVacche != null && modelVacche.size() > 0) {
            ref9901.init(modelVacche, getSessione().getIdSessione(), getAzienda().getCodicePremio(), Long.valueOf(getAzienda().getAnnoCampagna()), getAzienda().getCuaa());
            try {
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

    @Override
    public void esecuzione() throws ControlloException {
        /*Eseguito dall’OPR utilizzando i dati della BDN:
            Che le vacche nutrici facciano parte di allevamenti
            che aderiscono a piani di gestione della razza finalizzati
            al risanamento dal virus responsabile della Rinotracheite
            infettiva del bovino IBR.
        */

        importoLiquidabile = 0;

        for (Dmt_t_Tws_bdn_du_capi_bovini b : modelVacche) {
            if (b.getDtFineDetenzione().before(b.getDtNascitaVitello())
                    || b.getDtInizioDetenzione().after(b.getDtNascitaVitello())) {
                aggiungiEscluso(b);
                continue;
            }

            List<Dmt_t_Tws_bdn_du_capi_bovini> listVitelli = getControlliService().getVitelliNatiDaBovini(getSessione().getIdSessione(), b.getCapoId(), b.getCodicePremio());
            Date dataGiovane = UtilControlli.getVitelloGiovane(b, listVitelli);

            if (!(b.getDtFineDetenzione().before(dataGiovane)
                    || b.getDtInizioDetenzione().after(dataGiovane))) {
                aggiungiEscluso(b);
                continue;
            }

            // CONTROLLO CHE L'ALLEVAMENTO ABBIA IL flagIBR (Dati dalla BDN)
            if (null != b.getFlagIbr() && Boolean.valueOf(b.getFlagIbr())) importoLiquidabile++;
            else aggiungiEscluso(b);
        }
    }

    private void aggiungiEscluso(Dmt_t_Tws_bdn_du_capi_bovini b) {
        Dmt_t_output_esclusi escluso = new Dmt_t_output_esclusi();
        escluso.setCalcolo(this.getClass().getName());
        escluso.setCapoId(b.getCapoId());
        escluso.setMotivazioneEsclusione("");
        escluso.setSessione(getSessione());

        listEsclusi.add(escluso);
    }

    @Override
    public void postEsecuzione() throws ControlloException {
        // ESECUZIONI CONTROLLI PER SOGGETTO
        Dmt_t_output_controlli outputControlli = new Dmt_t_output_controlli();
        outputControlli.setSessione(getSessione());
        outputControlli.setAnnoCampagna(getAzienda().getAnnoCampagna());
        outputControlli.setCapiAmmissibili(importoLiquidabile);
        outputControlli.setCapiRichiesti(modelVacche.size());
        outputControlli.setCuaa(getAzienda().getCuaa());
        outputControlli.setIntervento(getAzienda().getCodicePremio());

        getControlliService().saveOutput(outputControlli);

        for (Dmt_t_output_esclusi o : listEsclusi)
            getControlliService().saveOutputEscl(o);
    }
}
