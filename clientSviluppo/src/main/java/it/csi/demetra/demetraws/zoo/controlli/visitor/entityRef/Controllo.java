package it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef;

import it.csi.demetra.demetraws.zoo.calcoli.CalcoloException;
import it.csi.demetra.demetraws.zoo.controlli.visitor.ControlloException;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;
import it.csi.demetra.demetraws.zoo.model.Rpu_V_pratica_zoote;
import it.csi.demetra.demetraws.zoo.services.ControlliService;

public abstract class Controllo {

    private Dmt_t_sessione sessione;

    private ControlliService controlliService;

    private Rpu_V_pratica_zoote azienda;

    /**
     * preEsecuzione() dei controlli
     *
     * @throws ControlloException
     * @throws CalcoloException
     */
    abstract public void preEsecuzione() throws ControlloException, CalcoloException;

    /**
     * esecuzione() dei controlli
     *
     * @throws ControlloException
     */
    abstract public void esecuzione() throws ControlloException;

    /**
     * postEsecuzione() dei controlli
     *
     * @throws ControlloException
     */
    abstract public void postEsecuzione() throws ControlloException;

    public Dmt_t_sessione getSessione() {
        return sessione;
    }

    public void setSessione(Dmt_t_sessione sessione) {
        this.sessione = sessione;
    }

    public Rpu_V_pratica_zoote getAzienda() {
        return azienda;
    }

    public void setAzienda(Rpu_V_pratica_zoote azienda) {
        this.azienda = azienda;
    }

    public ControlliService getControlliService() {
        return controlliService;
    }

    public void setControlliService(ControlliService controlliService) {
        this.controlliService = controlliService;
    }

    public String getInput() {
        return getAzienda().getCuaa() + "|" + getAzienda().getCodicePremio();
    }
}
