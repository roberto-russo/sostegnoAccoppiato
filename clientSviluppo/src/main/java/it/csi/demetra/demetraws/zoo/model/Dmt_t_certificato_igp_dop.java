package it.csi.demetra.demetraws.zoo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Dmt_t_certif_igp_dop")
public class Dmt_t_certificato_igp_dop implements Serializable {

    private static final long serialVersionUID = 5666097958872142621L;


    @Id
    @Column(name = "cuaa")
    /**
     * Codice fiscale del richiedente
     */
    private String cuaa;

    @Column(name = "flag_igp")
    /**
     * indicazione geografica protetta
     * puo' assumere valori: S, N
     */
    private String flagIgp;

    @Column(name = "flag_dop")
    /**
     * certificato a denominazione di origine protetta
     * puo' assumere valori: S, N
     */
    private String flagDop;

    @Column(length = 1)
    private String alpeggio;
    @Column(length = 1)
    private String zona;

    /**
     * Metodo getter che ritorna il flag di alpeggio
     * @return alpeggio flag di alpeggio
     */
    public String getAlpeggio() {
        return alpeggio;
    }

    /**
     * Metodo setter che imposta il flag di alpeggio
     * @param alpeggio flag di alpeggio
     */
    public void setAlpeggio(String alpeggio) {
        this.alpeggio = alpeggio;
    }

    /**
     * Metodo getter che ritorna la zona in cui è situato l'allevamento
     * @return zona zona in cui è situato l'allevamento
     */
    public String getZona() {
        return zona;
    }

    /**
     * Metodo setter che imposta la zona in cui è situato l'allevamento
     * @param zona zona in cui è situato l'allevamento
     */
    public void setZona(String zona) {
        this.zona = zona;
    }

    /**
     * metodo getter che ritorna il codice fiscale del richiedente
     * @return cuaa codice fiscale del richiedente.
     */
    public String getCuaa() {
        return cuaa;
    }

    /**
     * metodo setter che imposta il codice fiscale del richiedente
     * @param cuaa codice fiscale del richiedente.
     */
    public void setCuaa(String cuaa) {
        this.cuaa = cuaa;
    }

    /**
     * metodo getter che ritorna il flag per l'indicazione geografica protetta
     * @return flagIgp flag per l'indicazione geografica protetta.
     */
    public String getFlagIgp() {
        return flagIgp;
    }

    /**
     * metodo setter che imposta il flag per l'indicazione geografica protetta
     * @param flagIgp flag per l'indicazione geografica protetta.
     */
    public void setFlagIgp(String flagIgp) {
        this.flagIgp = flagIgp;
    }

    /**
     * metodo getter che ritorna il flag di certificato a denominazione di origine protetta
     * @return flagDop flag di certificato a denominazione di origine protetta.
     */
    public String getFlagDop() {
        return flagDop;
    }

    /**
     * metodo setter che imposta il flag di certificato a denominazione di origine protetta
     * @param flagDop flag di certificato a denominazione di origine protetta.
     */
    public void setFlagDop(String flagDop) {
        this.flagDop = flagDop;
    }
}
