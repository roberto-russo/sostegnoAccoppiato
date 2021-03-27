package it.csi.demetra.demetraws.zoo.model;

import it.csi.demetra.demetraws.zoo.compositeIds.Analisi_produzioni_cuua_id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@IdClass(Analisi_produzioni_cuua_id.class)
public class Dmt_T_analisi_produzioni_cuua {

    @Id
    /**
     * Codice fiscale del richiedente
     */
    private String CUUA;
    @Id
    @Column(name = "data_analisi")
    private Date dataAnalisi;
    /**
     * Anno della campagna premi per cui si è formulata la
     * richiesta di estrazione
     */
    @Id
    @Column(name = "anno_campagna")
    private int annoCampagna;
    @Column(name = "ragione_sociale")
    private String ragioneSociale;
    @Column(name = "codice_asl")
    private String codiceAsl;
    @Column(name = "partita_iva")
    private String partitaIva;
    @Column(name = "proteine")
    private BigDecimal proteine;
    @Column(name = "cellule_somatiche")
    private BigDecimal celluleSomatiche;
    @Column(name = "carica_batterica")
    private BigDecimal caricaBatterica;

    public int getAnnoCampagna() {
        return annoCampagna;
    }

    public void setAnnoCampagna(int annoCampagna) {
        this.annoCampagna = annoCampagna;
    }

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
