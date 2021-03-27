package it.csi.demetra.demetraws.zoo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "DMT_T_SISTEMI_ETICHETTATURA")
public class Dmt_t_SistemiDiEtichettaturaFacoltativa implements Serializable {


    private static final long serialVersionUID = 1421420988744825874L;

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "CUAA")
    /**
     * codice fiscale del richiedente
     */
    private String cuaa;

    @Column(name = "CODICE_ORGANISMO")
    private String codiceOrganismo;

    @Column(name = "CODICE_ASL")
    private String codiceAsl;

    @Column(name = "PARTITA_IVA")
    private String partitaIva;

    @Column(name = "DATA_INIZIO_ADESIONE")
    private Date dataInizioAdesione;

    @Column(name = "DATA_FINE_ADESIONE")
    private Date dataFineAdesione;

    @Column(name = "ANNOTAZIONI")
    private String annotazioni;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getCodiceAsl() {
        return codiceAsl;
    }

    public void setCodiceAsl(String codiceAsl) {
        this.codiceAsl = codiceAsl;
    }

    /**
     * Metodo getter che ritorna il codice fiscale del richiedente
     *
     * @return cuaa codice fiscale del richiedente
     */
    public String getCuaa() {
        return cuaa;
    }

    /**
     * Metodo setter che ritorna il codice fiscale del richiedente
     *
     * @param cuaa codice fiscale del richiedente
     */
    public void setCuaa(String cuaa) {
        this.cuaa = cuaa;
    }

    public String getCodiceOrganismo() {
        return codiceOrganismo;
    }

    public void setCodiceOrganismo(String codiceOrganismo) {
        this.codiceOrganismo = codiceOrganismo;
    }

    public String getPartitaIva() {
        return partitaIva;
    }

    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }

    public Date getDataInizioAdesione() {
        return dataInizioAdesione;
    }

    public void setDataInizioAdesione(Date dataInizioAdesione) {
        this.dataInizioAdesione = dataInizioAdesione;
    }

    public Date getDataFineAdesione() {
        return dataFineAdesione;
    }

    public void setDataFineAdesione(Date dataFineAdesione) {
        this.dataFineAdesione = dataFineAdesione;
    }

    public String getAnnotazioni() {
        return annotazioni;
    }

    public void setAnnotazioni(String annotazioni) {
        this.annotazioni = annotazioni;
    }
}
