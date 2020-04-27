
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per soggettoCuaaVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="soggettoCuaaVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cuaa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataAccertamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="enteCreditore" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="esito" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fondoPagamento" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idCredito" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idProvvedimento" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="importoCompensazione" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="importoPagamento" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="progressivoInternoElenco" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soggettoCuaaVO", propOrder = {
    "cuaa",
    "dataAccertamento",
    "enteCreditore",
    "esito",
    "fondoPagamento",
    "idCredito",
    "idProvvedimento",
    "importoCompensazione",
    "importoPagamento",
    "progressivoInternoElenco"
})
public class SoggettoCuaaVO {

    protected String cuaa;
    protected String dataAccertamento;
    protected int enteCreditore;
    protected int esito;
    protected int fondoPagamento;
    protected int idCredito;
    protected int idProvvedimento;
    protected BigDecimal importoCompensazione;
    protected BigDecimal importoPagamento;
    protected int progressivoInternoElenco;

    /**
     * Recupera il valore della propriet� cuaa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCuaa() {
        return cuaa;
    }

    /**
     * Imposta il valore della propriet� cuaa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCuaa(String value) {
        this.cuaa = value;
    }

    /**
     * Recupera il valore della propriet� dataAccertamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataAccertamento() {
        return dataAccertamento;
    }

    /**
     * Imposta il valore della propriet� dataAccertamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataAccertamento(String value) {
        this.dataAccertamento = value;
    }

    /**
     * Recupera il valore della propriet� enteCreditore.
     * 
     */
    public int getEnteCreditore() {
        return enteCreditore;
    }

    /**
     * Imposta il valore della propriet� enteCreditore.
     * 
     */
    public void setEnteCreditore(int value) {
        this.enteCreditore = value;
    }

    /**
     * Recupera il valore della propriet� esito.
     * 
     */
    public int getEsito() {
        return esito;
    }

    /**
     * Imposta il valore della propriet� esito.
     * 
     */
    public void setEsito(int value) {
        this.esito = value;
    }

    /**
     * Recupera il valore della propriet� fondoPagamento.
     * 
     */
    public int getFondoPagamento() {
        return fondoPagamento;
    }

    /**
     * Imposta il valore della propriet� fondoPagamento.
     * 
     */
    public void setFondoPagamento(int value) {
        this.fondoPagamento = value;
    }

    /**
     * Recupera il valore della propriet� idCredito.
     * 
     */
    public int getIdCredito() {
        return idCredito;
    }

    /**
     * Imposta il valore della propriet� idCredito.
     * 
     */
    public void setIdCredito(int value) {
        this.idCredito = value;
    }

    /**
     * Recupera il valore della propriet� idProvvedimento.
     * 
     */
    public int getIdProvvedimento() {
        return idProvvedimento;
    }

    /**
     * Imposta il valore della propriet� idProvvedimento.
     * 
     */
    public void setIdProvvedimento(int value) {
        this.idProvvedimento = value;
    }

    /**
     * Recupera il valore della propriet� importoCompensazione.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImportoCompensazione() {
        return importoCompensazione;
    }

    /**
     * Imposta il valore della propriet� importoCompensazione.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImportoCompensazione(BigDecimal value) {
        this.importoCompensazione = value;
    }

    /**
     * Recupera il valore della propriet� importoPagamento.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImportoPagamento() {
        return importoPagamento;
    }

    /**
     * Imposta il valore della propriet� importoPagamento.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImportoPagamento(BigDecimal value) {
        this.importoPagamento = value;
    }

    /**
     * Recupera il valore della propriet� progressivoInternoElenco.
     * 
     */
    public int getProgressivoInternoElenco() {
        return progressivoInternoElenco;
    }

    /**
     * Imposta il valore della propriet� progressivoInternoElenco.
     * 
     */
    public void setProgressivoInternoElenco(int value) {
        this.progressivoInternoElenco = value;
    }

}
