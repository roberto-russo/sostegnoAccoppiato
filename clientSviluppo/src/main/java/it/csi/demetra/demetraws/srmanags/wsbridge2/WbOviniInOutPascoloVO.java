
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per wbOviniInOutPascoloVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbOviniInOutPascoloVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="aslAzienda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="aslPascolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceAzienda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codicePascolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceSpecie" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="comunePascolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cuaa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataComAutorita" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dataIngressoPascolo" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dataModello" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dataUscitaPascolo" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="estremiModAccompagnamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idAllevamento" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="idFiscaleAllevamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idPascolo" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="numeroOvini" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wbOviniInOutPascoloVO", propOrder = {
    "aslAzienda",
    "aslPascolo",
    "codiceAzienda",
    "codicePascolo",
    "codiceSpecie",
    "comunePascolo",
    "cuaa",
    "dataComAutorita",
    "dataIngressoPascolo",
    "dataModello",
    "dataUscitaPascolo",
    "estremiModAccompagnamento",
    "idAllevamento",
    "idFiscaleAllevamento",
    "idPascolo",
    "numeroOvini"
})
public class WbOviniInOutPascoloVO {

    protected String aslAzienda;
    protected String aslPascolo;
    protected String codiceAzienda;
    protected String codicePascolo;
    protected String codiceSpecie;
    protected String comunePascolo;
    protected String cuaa;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataComAutorita;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataIngressoPascolo;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataModello;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataUscitaPascolo;
    protected String estremiModAccompagnamento;
    protected BigDecimal idAllevamento;
    protected String idFiscaleAllevamento;
    protected BigDecimal idPascolo;
    protected BigDecimal numeroOvini;

    /**
     * Recupera il valore della propriet� aslAzienda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAslAzienda() {
        return aslAzienda;
    }

    /**
     * Imposta il valore della propriet� aslAzienda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAslAzienda(String value) {
        this.aslAzienda = value;
    }

    /**
     * Recupera il valore della propriet� aslPascolo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAslPascolo() {
        return aslPascolo;
    }

    /**
     * Imposta il valore della propriet� aslPascolo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAslPascolo(String value) {
        this.aslPascolo = value;
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
     * Recupera il valore della propriet� codicePascolo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodicePascolo() {
        return codicePascolo;
    }

    /**
     * Imposta il valore della propriet� codicePascolo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodicePascolo(String value) {
        this.codicePascolo = value;
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
     * Recupera il valore della propriet� comunePascolo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComunePascolo() {
        return comunePascolo;
    }

    /**
     * Imposta il valore della propriet� comunePascolo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComunePascolo(String value) {
        this.comunePascolo = value;
    }

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
     * Recupera il valore della propriet� dataComAutorita.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataComAutorita() {
        return dataComAutorita;
    }

    /**
     * Imposta il valore della propriet� dataComAutorita.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataComAutorita(XMLGregorianCalendar value) {
        this.dataComAutorita = value;
    }

    /**
     * Recupera il valore della propriet� dataIngressoPascolo.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataIngressoPascolo() {
        return dataIngressoPascolo;
    }

    /**
     * Imposta il valore della propriet� dataIngressoPascolo.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataIngressoPascolo(XMLGregorianCalendar value) {
        this.dataIngressoPascolo = value;
    }

    /**
     * Recupera il valore della propriet� dataModello.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataModello() {
        return dataModello;
    }

    /**
     * Imposta il valore della propriet� dataModello.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataModello(XMLGregorianCalendar value) {
        this.dataModello = value;
    }

    /**
     * Recupera il valore della propriet� dataUscitaPascolo.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataUscitaPascolo() {
        return dataUscitaPascolo;
    }

    /**
     * Imposta il valore della propriet� dataUscitaPascolo.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataUscitaPascolo(XMLGregorianCalendar value) {
        this.dataUscitaPascolo = value;
    }

    /**
     * Recupera il valore della propriet� estremiModAccompagnamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstremiModAccompagnamento() {
        return estremiModAccompagnamento;
    }

    /**
     * Imposta il valore della propriet� estremiModAccompagnamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstremiModAccompagnamento(String value) {
        this.estremiModAccompagnamento = value;
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
     * Recupera il valore della propriet� idFiscaleAllevamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdFiscaleAllevamento() {
        return idFiscaleAllevamento;
    }

    /**
     * Imposta il valore della propriet� idFiscaleAllevamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdFiscaleAllevamento(String value) {
        this.idFiscaleAllevamento = value;
    }

    /**
     * Recupera il valore della propriet� idPascolo.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdPascolo() {
        return idPascolo;
    }

    /**
     * Imposta il valore della propriet� idPascolo.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdPascolo(BigDecimal value) {
        this.idPascolo = value;
    }

    /**
     * Recupera il valore della propriet� numeroOvini.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNumeroOvini() {
        return numeroOvini;
    }

    /**
     * Imposta il valore della propriet� numeroOvini.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNumeroOvini(BigDecimal value) {
        this.numeroOvini = value;
    }

}
