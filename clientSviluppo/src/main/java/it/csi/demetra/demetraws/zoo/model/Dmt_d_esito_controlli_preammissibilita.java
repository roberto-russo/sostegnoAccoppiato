package it.csi.demetra.demetraws.zoo.model;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_d_esito_controlli_preammissibilita_id;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Classe model di rappresentazione dell'output dei metodi getElencoCapiPremioNew e
 * getElencoCapiPremio2New
 *
 * @author bcsoft
 * @version 1.0 (02/04/2020)
 */

@Entity
@Table(name = "DMT_D_ESITO_CONTR_PREAMM")
@IdClass(Dmt_d_esito_controlli_preammissibilita_id.class)
public class Dmt_d_esito_controlli_preammissibilita implements Serializable {

    private static final long serialVersionUID = -5710450180310221303L;

    @MapsId
    @ManyToOne
    @JoinColumn(name = "idSessione", nullable = false)
    private Dmt_t_sessione idSessione;

    @Id
    @Column(name = "ID")
    @NotNull
    private Long id;

    @Id
    @Column(name = "CUAA", length = 16)
    @NotNull
    private String cuaa;

    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;

    @Id
    @Column(name = "anno", length = 4, precision = 0)
    @NotNull
    private double anno;

    @Id
    @Column(name = "id_gestore")
    @NotNull
    private Long idGestore;

    @Column(name = "esito", length = 1)
    private String esito;

    @Column(name = "msg", length = 400)
    private String msg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCuaa() {
        return cuaa;
    }

    public void setCuaa(String cuaa) {
        this.cuaa = cuaa;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getAnno() {
        return anno;
    }

    public void setAnno(double anno) {
        this.anno = anno;
    }

    public Long getIdGestore() {
        return idGestore;
    }

    public void setIdGestore(Long idGestore) {
        this.idGestore = idGestore;
    }

    public String getEsito() {
        return esito;
    }

    public void setEsito(String esito) {
        this.esito = esito;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Dmt_t_sessione getIdSessione() {
        return idSessione;
    }

    public void setIdSessione(Dmt_t_sessione sessione) {
        this.idSessione = sessione;
    }
}
