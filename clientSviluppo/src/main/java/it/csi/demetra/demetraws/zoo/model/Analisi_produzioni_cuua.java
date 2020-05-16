package it.csi.demetra.demetraws.zoo.model;

import it.csi.demetra.demetraws.zoo.compositeIds.Analisi_produzioni_cuua_id;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@IdClass(Analisi_produzioni_cuua_id.class)
public class Analisi_produzioni_cuua {

    @Id
    private String CUUA;
    private String ragioneSociale;
    private String codiceAsl;
    private String partitaIva;
    @Id
    private Date dataAnalisi;
    private BigDecimal proteine;
    private BigDecimal celluleSomatiche;
    private BigDecimal caricaBatterica;

    public String getCUUA() {
        return CUUA;
    }

    public void setCUUA(String CUUA) {
        this.CUUA = CUUA;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public String getCodiceAsl() {
        return codiceAsl;
    }

    public void setCodiceAsl(String codiceAsl) {
        this.codiceAsl = codiceAsl;
    }

    public String getPartitaIva() {
        return partitaIva;
    }

    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }

    public Date getDataAnalisi() {
        return dataAnalisi;
    }

    public void setDataAnalisi(Date dataAnalisi) {
        this.dataAnalisi = dataAnalisi;
    }

    public BigDecimal getProteine() {
        return proteine;
    }

    public void setProteine(BigDecimal proteine) {
        this.proteine = proteine;
    }

    public BigDecimal getCelluleSomatiche() {
        return celluleSomatiche;
    }

    public void setCelluleSomatiche(BigDecimal celluleSomatiche) {
        this.celluleSomatiche = celluleSomatiche;
    }

    public BigDecimal getCaricaBatterica() {
        return caricaBatterica;
    }

    public void setCaricaBatterica(BigDecimal caricaBatterica) {
        this.caricaBatterica = caricaBatterica;
    }
}
