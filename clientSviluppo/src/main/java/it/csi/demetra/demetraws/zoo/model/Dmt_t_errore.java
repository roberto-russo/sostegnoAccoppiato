package it.csi.demetra.demetraws.zoo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_errore_id;

@Entity(name = "DMT_t_errore")
@IdClass(Dmt_t_errore_id.class)
public class Dmt_t_errore implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -6196503556701889330L;

    @Id
    /**
     * nome del metodo richiamato. 
     */
    private String nomeMetodo;

    @Id
    /**
     * parametri di input del metodo richiamato.
     */
    private String input;
    @MapsId
    @ManyToOne
    @JoinColumn(name = "idSessione", nullable = false)
    /**
     * codice univoco associato all'istanza di sessione
     */
    private Dmt_t_sessione idSessione;

    @Column(name = "errore_descrizione")
    /**
     * descrizione dell'errore occorso
     */
    private String erroreDesc;

    @Column(name = "errore_codice")
    /**
     * codice dell'errore occorso
     */
    private String errorecodice;

    /**
     * Costruttore senza parametri che imposta erroreDesc
     */
    public Dmt_t_errore() {
        this.erroreDesc = erroreDesc;
    }

    /**
     * Costruttore con parametri che imposta idSessione, nomeMetodo, input ed erroreDesc
     * @param idSessione id della sessione corrente
     * @param nomeMetodo nome del metodo richiamato
     * @param input parametri di input del metodo richiamato
     * @param erroreDesc descrizione dell'errore occorso
     */
    public Dmt_t_errore(Dmt_t_sessione idSessione, String nomeMetodo, String input, String erroreDesc) {
        this.idSessione = idSessione;
        this.nomeMetodo = nomeMetodo;
        this.input = input;
        this.erroreDesc = erroreDesc;
    }

    /**
     * metodo getter che ritorna  SerialVersionUID
     * @return serialVerisonUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * Metodo getter che ritorna il codice univoco associato all'esecuzione
     * @return idSessione codice univoco associato all'esecuzione.
     */
    public Dmt_t_sessione getIdSessione() {
        return idSessione;
    }

    /**
     * Metodo setter che imposta il codice univoco associato all'esecuzione.
     * <b>ATTENZIONE</b> questo metodo non viene utilizzato in quanto il codice
     * univoco della sessione viene generato automaticamente, @see Dmt_t_sessione.
     * @param sessione
     */
    public void setIdSessione(Dmt_t_sessione sessione) {
        this.idSessione = sessione;
    }

    /**
     * metodo getter che ritorna la descrizione dell'errore occorso
     * @return erroreDesc descrizione dell'errore occorso.
     */
    public String getErroreDesc() {
        return erroreDesc;
    }

    /**
     * Metodo setter che imposta la descrizione dell'errore occorso.
     * @param erroreDesc descrizione dell'errore occorso.
     */
    public void setErroreDesc(String erroreDesc) {
        this.erroreDesc = erroreDesc;
    }

    /**
     * metodo getter che ritorna il codice dell'errore occorso.
     * @return erroreCodice codice dell'errore occorso.
     */
    public String getErrorecodice() {
        return errorecodice;
    }

    /**
     * Metodo setter che imposta il codice dell'errore occorso.
     * @param errorecodice codice dell'errore occorso.
     */
    public void setErrorecodice(String errorecodice) {
        this.errorecodice = errorecodice;
    }

    /**
     * Metodo getter che ritorna il nome del metodo richiamato
     * @return nomeMetodo nome del metodo richiamato.
     */
    public String getNomeMetodo() {
        return nomeMetodo;
    }

    /**
     * Metodo setter che imposta il nome del metodo richiamato.
     * @param nomeMetodo nome del metodo richiamato.
     */
    public void setNomeMetodo(String nomeMetodo) {
        this.nomeMetodo = nomeMetodo;
    }

    /**
     * Metodo getter che ritorna i parametri di input del metodo richiamato
     * @return input parametri di input del metodo richiamato.
     */
    public String getInput() {
        return input;
    }

    /**
     * Metodo setter che imposta i parametri di input del metodo richiamato.
     * @param input parametri di input del metodo richiamato.
     */
    public void setInput(String input) {
        this.input = input;
    }



    @Override
    public String toString() {
        return "Dmt_t_errore{" +
                "nomeMetodo='" + nomeMetodo + '\'' +
                ", input='" + input + '\'' +
                ", idSessione=" + idSessione +
                ", sessione=" + idSessione +
                ", erroreDesc='" + erroreDesc + '\'' +
                ", errorecodice='" + errorecodice + '\'' +
                '}';
    }
}
