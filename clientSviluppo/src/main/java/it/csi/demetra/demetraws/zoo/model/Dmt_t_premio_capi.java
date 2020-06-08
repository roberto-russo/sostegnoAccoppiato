package it.csi.demetra.demetraws.zoo.model;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_premio_capi_id;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "DMT_T_PREMIO_CAPI")
@IdClass(Dmt_t_premio_capi_id.class)
public class Dmt_t_premio_capi implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @MapsId
    @ManyToOne
    @JoinColumn(name = "idSessione", nullable = false)
    /**
     * Identificativo univoco associato all'esecuzione
     */
    private Dmt_t_sessione idSessione;

    @Id
    @Column(name = "ID_ALLEVAMENTO")
    @NotNull
    /**
     * Identificativo univoco interno in BDN dell’allevamento
     */
    private Long idAllevamento;


    @Column(name = "COD_AZIENDA")
    @NotNull
    /**
     * Codice dell’azienda cui appartiene l’allevamento
     */
    private String codiceAzienda;

    @Id
    @Column(name = "ID_CAPO")
    /**
     * Identificativo univodo del capo animale
     */
    private Long idCapo;

    @Id
    @Column(name = "CODICE_PREMIO")
    @NotNull
    /**
     * codice intervento
     */
    private String codicePremio;

    @Column(name = "CODICE_VITELLO")
    /**
     * codice identificativo del vitello
     */
    private String codiceVitello;

    @Id
    @Column(name = "CUAA")
    @NotNull
    /**
     * Codice fiscale del richiedente
     */
    private String cuaa;

    @Column(name = "FLAG_AMISSIBILE")
    @NotNull
    private String flagAmmissibile;

    @Column(name = "MSG")
    private String msg;

    /**
     * Metodo getter che ritorna l'identificativo univoco associato all'esecuzione
     * @return idSessione identificativo univoco associato all'esecuzione.
     */
    public Dmt_t_sessione getIdSessione() {
        return idSessione;
    }

    /**
     * Metodo setter che imposta l'identificativo univoco associato all'esecuzione
     * @param sessione identificativo univoco associato all'esecuzione
     */
    public void setIdSessione(Dmt_t_sessione sessione) {
        this.idSessione = sessione;
    }

    /**
     * Metodo getter che ritorna l'identificativo interno in BDN dell'allevamento
     * @return idAllevamento identificativo interno in BDN dell'allevamento
     */
    public Long getIdAllevamento() {
        return idAllevamento;
    }

    /**
     * Metodo setter che imposta l'identificativo interno in BDN dell'allevamento
     * @param idAllevamento identificativo interno in BDN dell'allevamento.
     */
    public void setIdAllevamento(Long idAllevamento) {
        this.idAllevamento = idAllevamento;
    }

    /**
     * Metodo getter che ritorna il codice dell'azienda a cui appartiene l'allevamento
     * @return codiceAzienda codice dell'azienda a cui appartiene l'allevamento.
     */
    public String getCodiceAzienda() {
        return codiceAzienda;
    }

    /**
     * Metodo setter che imposta il codice dell'azienda a cui appartiene l'allevamento
     * @param codiceAzienda codice dell'azienda a cui appartiene l'allevamento
     */
    public void setCodiceAzienda(String codiceAzienda) {
        this.codiceAzienda = codiceAzienda;
    }

    /**
     * Metodo getter che ritorna l'identificativo univoco del capo animale
     * @return idCapo identificativo univoco del capo animale
     */
    public Long getIdCapo() {
        return idCapo;
    }

    /**
     * Metodo setter che imposta l'identificativo univoco del campo animale
     * @param idCapo identificativo univoco del capo animale
     */
    public void setIdCapo(Long idCapo) {
        this.idCapo = idCapo;
    }

    /**
     * Metodo getter che ritorna il codice intervento
     * @return codicePremio codice intervento
     */
    public String getCodicePremio() {
        return codicePremio;
    }

    /**
     * Metodo setter che imposta il codice intervento
     * @param codicePremio codice intervento
     */
    public void setCodicePremio(String codicePremio) {
        this.codicePremio = codicePremio;
    }

    /**
     * Metodo getter che ritorna il codice identificativo univoco del vitello
     * @return codiceVitello codice identificativo univoco del vitello
     */
    public String getCodiceVitello() {
        return codiceVitello;
    }

    /**
     * Metodo setter che ritorna il codice identificativo univoco del vitello
     * @param codiceVitello codice identificativo univoco del vitello
     */
    public void setCodiceVitello(String codiceVitello) {
        this.codiceVitello = codiceVitello;
    }

    /**
     * Metodo getter che ritorna il codice fiscale del richiedente
     * @return cuaa codice fiscale del richiedente
     */
    public String getCuaa() {
        return cuaa;
    }

    /**
     * Metodo setter che imposta il codice fiscale del richiedente
     * @param cuaa codice fiscale del richiedente
     */
    public void setCuaa(String cuaa) {
        this.cuaa = cuaa;
    }

    public String getFlagAmmissibile() {
        return flagAmmissibile;
    }

    public void setFlagAmmissibile(String flagAmmissibile) {
        this.flagAmmissibile = flagAmmissibile;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}