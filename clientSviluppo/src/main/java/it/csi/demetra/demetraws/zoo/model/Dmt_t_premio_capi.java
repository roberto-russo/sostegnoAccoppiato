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
    @JoinColumn(name = "sessione", nullable = false)
    private Dmt_t_sessione sessione;

    @Id
    @Column(name = "ID_ALLEVAMENTO")
    @NotNull
    private Long idAllevamento;


    @Column(name = "COD_AZIENDA")
    @NotNull
    private String codiceAzienda;

    @Id
    @Column(name = "ID_CAPO")
    private Long idCapo;

    @Id
    @Column(name = "CODICE_PREMIO")
    @NotNull
    private String codicePremio;

    @Column(name = "CODICE_VITELLO")
    private String codiceVitello;

    @Id
    @Column(name = "CUAA", length = 16)
    @NotNull
    private String cuaa;

    @Column(name = "FLAG_AMISSIBILE", length = 1)
    @NotNull
    private String flagAmmissibile;

    @Column(name = "MSG")
    private String msg;

    public Dmt_t_sessione getSessione() {
        return sessione;
    }

    public void setSessione(Dmt_t_sessione sessione) {
        this.sessione = sessione;
    }

    public Long getIdAllevamento() {
        return idAllevamento;
    }

    public void setIdAllevamento(Long idAllevamento) {
        this.idAllevamento = idAllevamento;
    }

    public String getCodiceAzienda() {
        return codiceAzienda;
    }

    public void setCodiceAzienda(String codiceAzienda) {
        this.codiceAzienda = codiceAzienda;
    }

    public Long getIdCapo() {
        return idCapo;
    }

    public void setIdCapo(Long idCapo) {
        this.idCapo = idCapo;
    }

    public String getCodicePremio() {
        return codicePremio;
    }

    public void setCodicePremio(String codicePremio) {
        this.codicePremio = codicePremio;
    }

    public String getCodiceVitello() {
        return codiceVitello;
    }

    public void setCodiceVitello(String codiceVitello) {
        this.codiceVitello = codiceVitello;
    }

    public String getCuaa() {
        return cuaa;
    }

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