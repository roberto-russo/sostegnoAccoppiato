package it.csi.demetra.demetraws.zoo.controlli.visitor;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_errore;

public class ControlloException extends Exception {

    private Dmt_t_errore errore;

    public ControlloException(String message) {
        super(message);
        this.errore = null;
    }

    /**
     * ControlloException permette di istanziare un oggetto passando negli argomenti del costruttore un
     * Entity errore. In questo modo nel catch dell'eccezione è possibile salvare un log completo di errore in DB.
     * @param errore istanza di tipo {@link Dmt_t_errore}
     */
    public ControlloException(Dmt_t_errore errore) {
        this.errore = errore;
    }

    public Dmt_t_errore getErrore() {
        return errore;
    }

    public void setErrore(Dmt_t_errore errore) {
        this.errore = errore;
    }
}
