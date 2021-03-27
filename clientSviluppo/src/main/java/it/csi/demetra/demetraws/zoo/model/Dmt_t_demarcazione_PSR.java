package it.csi.demetra.demetraws.zoo.model;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_demarcazione_PSR_id;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "DMT_T_DEMARCAZIONE_PSR")
@IdClass(Dmt_t_demarcazione_PSR_id.class)
public class Dmt_t_demarcazione_PSR implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 176824868151307294L;

    @Id
    @Column(name = "ANNO")
    private Integer anno;

    @Id
    @Column(name = "MARCHIO_AURICOLARE")
    private String marchioAuricolare;

    @Column(name = "OPERAZIONE")
    private String operazione;

    @Column(name = "NR_PROCEDIMENTO")
    private Long nrProcedimento;

    @Column(name = "CUAA")
    private String cuaa;

    @Column(name = "RAGIONE_SOCIALE")
    private String ragioneSociale;

    @Column(name = "STATO_PROCEDIMENTO")
    private String statoProcedimento;

    @Column(name = "SPECIE_ANIMALE")
    private String specieAnimale;

    @Column(name = "CATEGORIA")
    private String categoria;

    @Column(name = "RAZZA")
    private String razza;

    @Column(name = "NUMERO_CAPI")
    private BigDecimal numeroCapi;

    @Column(name = "NUMERO_CAPI_PAGABILI")
    private BigDecimal numeroCapiPagabili;

    @Column(name = "NR_CAPI_SOSTITUITI")
    private BigDecimal numeroCapiSostituiti;

    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    public String getMarchioAuricolare() {
        return marchioAuricolare;
    }

    public void setMarchioAuricolare(String marchioAuricolare) {
        this.marchioAuricolare = marchioAuricolare;
    }

    public String getOperazione() {
        return operazione;
    }

    public void setOperazione(String operazione) {
        this.operazione = operazione;
    }

    public Long getNrProcedimento() {
        return nrProcedimento;
    }

    public void setNrProcedimento(Long nrProcedimento) {
        this.nrProcedimento = nrProcedimento;
    }

    public String getCuaa() {
        return cuaa;
    }

    public void setCuaa(String cuaa) {
        this.cuaa = cuaa;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public String getStatoProcedimento() {
        return statoProcedimento;
    }

    public void setStatoProcedimento(String statoProcedimento) {
        this.statoProcedimento = statoProcedimento;
    }

    public String getSpecieAnimale() {
        return specieAnimale;
    }

    public void setSpecieAnimale(String specieAnimale) {
        this.specieAnimale = specieAnimale;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getRazza() {
        return razza;
    }

    public void setRazza(String razza) {
        this.razza = razza;
    }

    public BigDecimal getNumeroCapi() {
        return numeroCapi;
    }

    public void setNumeroCapi(BigDecimal numeroCapi) {
        this.numeroCapi = numeroCapi;
    }

    public BigDecimal getNumeroCapiPagabili() {
        return numeroCapiPagabili;
    }

    public void setNumeroCapiPagabili(BigDecimal numeroCapiPagabili) {
        this.numeroCapiPagabili = numeroCapiPagabili;
    }

    public BigDecimal getNumeroCapiSostituiti() {
        return numeroCapiSostituiti;
    }

    public void setNumeroCapiSostituiti(BigDecimal numeroCapiSostituiti) {
        this.numeroCapiSostituiti = numeroCapiSostituiti;
    }
}
