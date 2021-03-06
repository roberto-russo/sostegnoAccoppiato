
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per wbConsistenzaAllevamentoVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbConsistenzaAllevamentoVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="capi06mesi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="capi624mesi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="capiOltre24mesi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codFiscDetentore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codFiscProprietario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceAzienda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceSpecie" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="consistenzaMediaTotale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataFinePeriodo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataInizioPeriodo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idAllevamento" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="vaccheOltre20mesi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wbConsistenzaAllevamentoVO", propOrder = {
    "capi06Mesi",
    "capi624Mesi",
    "capiOltre24Mesi",
    "codFiscDetentore",
    "codFiscProprietario",
    "codiceAzienda",
    "codiceSpecie",
    "consistenzaMediaTotale",
    "dataFinePeriodo",
    "dataInizioPeriodo",
    "idAllevamento",
    "vaccheOltre20Mesi"
})
public class WbConsistenzaAllevamentoVO {

    @XmlElement(name = "capi06mesi")
    protected String capi06Mesi;
    @XmlElement(name = "capi624mesi")
    protected String capi624Mesi;
    @XmlElement(name = "capiOltre24mesi")
    protected String capiOltre24Mesi;
    protected String codFiscDetentore;
    protected String codFiscProprietario;
    protected String codiceAzienda;
    protected String codiceSpecie;
    protected String consistenzaMediaTotale;
    protected String dataFinePeriodo;
    protected String dataInizioPeriodo;
    protected BigDecimal idAllevamento;
    @XmlElement(name = "vaccheOltre20mesi")
    protected String vaccheOltre20Mesi;

    /**
     * Recupera il valore della propriet� capi06Mesi.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapi06Mesi() {
        return capi06Mesi;
    }

    /**
     * Imposta il valore della propriet� capi06Mesi.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapi06Mesi(String value) {
        this.capi06Mesi = value;
    }

    /**
     * Recupera il valore della propriet� capi624Mesi.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapi624Mesi() {
        return capi624Mesi;
    }

    /**
     * Imposta il valore della propriet� capi624Mesi.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapi624Mesi(String value) {
        this.capi624Mesi = value;
    }

    /**
     * Recupera il valore della propriet� capiOltre24Mesi.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapiOltre24Mesi() {
        return capiOltre24Mesi;
    }

    /**
     * Imposta il valore della propriet� capiOltre24Mesi.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapiOltre24Mesi(String value) {
        this.capiOltre24Mesi = value;
    }

    /**
     * Recupera il valore della propriet� codFiscDetentore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodFiscDetentore() {
        return codFiscDetentore;
    }

    /**
     * Imposta il valore della propriet� codFiscDetentore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodFiscDetentore(String value) {
        this.codFiscDetentore = value;
    }

    /**
     * Recupera il valore della propriet� codFiscProprietario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodFiscProprietario() {
        return codFiscProprietario;
    }

    /**
     * Imposta il valore della propriet� codFiscProprietario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodFiscProprietario(String value) {
        this.codFiscProprietario = value;
    }

    /**
     * Recupera il valore della propriet� codiceAzienda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceAzienda() {
        return codiceAzienda;
    }

    /**
     * Imposta il valore della propriet� codiceAzienda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceAzienda(String value) {
        this.codiceAzienda = value;
    }

    /**
     * Recupera il valore della propriet� codiceSpecie.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceSpecie() {
        return codiceSpecie;
    }

    /**
     * Imposta il valore della propriet� codiceSpecie.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceSpecie(String value) {
        this.codiceSpecie = value;
    }

    /**
     * Recupera il valore della propriet� consistenzaMediaTotale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConsistenzaMediaTotale() {
        return consistenzaMediaTotale;
    }

    /**
     * Imposta il valore della propriet� consistenzaMediaTotale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConsistenzaMediaTotale(String value) {
        this.consistenzaMediaTotale = value;
    }

    /**
     * Recupera il valore della propriet� dataFinePeriodo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataFinePeriodo() {
        return dataFinePeriodo;
    }

    /**
     * Imposta il valore della propriet� dataFinePeriodo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataFinePeriodo(String value) {
        this.dataFinePeriodo = value;
    }

    /**
     * Recupera il valore della propriet� dataInizioPeriodo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataInizioPeriodo() {
        return dataInizioPeriodo;
    }

    /**
     * Imposta il valore della propriet� dataInizioPeriodo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataInizioPeriodo(String value) {
        this.dataInizioPeriodo = value;
    }

    /**
     * Recupera il valore della propriet� idAllevamento.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdAllevamento() {
        return idAllevamento;
    }

    /**
     * Imposta il valore della propriet� idAllevamento.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdAllevamento(BigDecimal value) {
        this.idAllevamento = value;
    }

    /**
     * Recupera il valore della propriet� vaccheOltre20Mesi.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVaccheOltre20Mesi() {
        return vaccheOltre20Mesi;
    }

    /**
     * Imposta il valore della propriet� vaccheOltre20Mesi.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVaccheOltre20Mesi(String value) {
        this.vaccheOltre20Mesi = value;
    }

}
