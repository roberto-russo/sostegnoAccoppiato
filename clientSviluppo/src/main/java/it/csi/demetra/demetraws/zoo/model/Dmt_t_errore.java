package it.csi.demetra.demetraws.zoo.model;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_errore_id;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "DMT_t_errore")
@IdClass(Dmt_t_errore_id.class)
public class Dmt_t_errore implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -6196503556701889330L;

    @Id
    private String nomeMetodo;

    @Id
    private String input;
    @MapsId
    @ManyToOne
    @JoinColumn(name = "idSessione", nullable = false)
    private Dmt_t_sessione idSessione;

    @Column(name = "errore_descrizione")
    private String erroreDesc;

    @Column(name = "errore_codice")
    private String errorecodice;

    public Dmt_t_errore() {
        this.erroreDesc = erroreDesc;
    }

    public Dmt_t_errore(Dmt_t_sessione idSessione, String nomeMetodo, String input, String erroreDesc) {
        this.idSessione = idSessione;
        this.nomeMetodo = nomeMetodo;
        this.input = input;
        this.erroreDesc = erroreDesc;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Dmt_t_sessione getIdSessione() {
        return idSessione;
    }

    public void setIdSessione(Dmt_t_sessione sessione) {
        this.idSessione = sessione;
    }

    public String getErroreDesc() {
        return erroreDesc;
    }

    public void setErroreDesc(String erroreDesc) {
        this.erroreDesc = erroreDesc;
    }

    public String getErrorecodice() {
        return errorecodice;
    }

    public void setErrorecodice(String errorecodice) {
        this.errorecodice = errorecodice;
    }

    public String getNomeMetodo() {
        return nomeMetodo;
    }

    public void setNomeMetodo(String nomeMetodo) {
        this.nomeMetodo = nomeMetodo;
    }

    public String getInput() {
        return input;
    }

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
