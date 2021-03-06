
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per wbConsistenzaStatAllevamentoVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbConsistenzaStatAllevamentoVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codFiscDetentore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codFiscProprietario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceAzienda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceSpecie" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataFineAttivitaAllevamento" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dataFinePeriodo" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dataInizioAttivitaAllevamento" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dataInizioPeriodo" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dataMaxCalcoloCapi" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dataMinCalcoloCapi" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="idAllevamento" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="mediaCapiTotali" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="mediaFemmineBov0_12Mesi" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="mediaFemmineBov12_24Mesi" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="mediaFemmineBuf0_12Mesi" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="mediaFemmineBuf12_24Mesi" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="mediaMaschiBov0_12Mesi" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="mediaMaschiBov12_24Mesi" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="mediaMaschiBuf0_12Mesi" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="mediaMaschiBuf12_24Mesi" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="numElaborazioni" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wbConsistenzaStatAllevamentoVO", propOrder = {
    "codFiscDetentore",
    "codFiscProprietario",
    "codiceAzienda",
    "codiceSpecie",
    "dataFineAttivitaAllevamento",
    "dataFinePeriodo",
    "dataInizioAttivitaAllevamento",
    "dataInizioPeriodo",
    "dataMaxCalcoloCapi",
    "dataMinCalcoloCapi",
    "idAllevamento",
    "mediaCapiTotali",
    "mediaFemmineBov012Mesi",
    "mediaFemmineBov1224Mesi",
    "mediaFemmineBuf012Mesi",
    "mediaFemmineBuf1224Mesi",
    "mediaMaschiBov012Mesi",
    "mediaMaschiBov1224Mesi",
    "mediaMaschiBuf012Mesi",
    "mediaMaschiBuf1224Mesi",
    "numElaborazioni"
})
public class WbConsistenzaStatAllevamentoVO {

    protected String codFiscDetentore;
    protected String codFiscProprietario;
    protected String codiceAzienda;
    protected String codiceSpecie;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataFineAttivitaAllevamento;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataFinePeriodo;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataInizioAttivitaAllevamento;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataInizioPeriodo;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataMaxCalcoloCapi;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataMinCalcoloCapi;
    protected BigDecimal idAllevamento;
    protected BigDecimal mediaCapiTotali;
    @XmlElement(name = "mediaFemmineBov0_12Mesi")
    protected BigDecimal mediaFemmineBov012Mesi;
    @XmlElement(name = "mediaFemmineBov12_24Mesi")
    protected BigDecimal mediaFemmineBov1224Mesi;
    @XmlElement(name = "mediaFemmineBuf0_12Mesi")
    protected BigDecimal mediaFemmineBuf012Mesi;
    @XmlElement(name = "mediaFemmineBuf12_24Mesi")
    protected BigDecimal mediaFemmineBuf1224Mesi;
    @XmlElement(name = "mediaMaschiBov0_12Mesi")
    protected BigDecimal mediaMaschiBov012Mesi;
    @XmlElement(name = "mediaMaschiBov12_24Mesi")
    protected BigDecimal mediaMaschiBov1224Mesi;
    @XmlElement(name = "mediaMaschiBuf0_12Mesi")
    protected BigDecimal mediaMaschiBuf012Mesi;
    @XmlElement(name = "mediaMaschiBuf12_24Mesi")
    protected BigDecimal mediaMaschiBuf1224Mesi;
    protected BigDecimal numElaborazioni;

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
     * Recupera il valore della propriet� dataFineAttivitaAllevamento.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataFineAttivitaAllevamento() {
        return dataFineAttivitaAllevamento;
    }

    /**
     * Imposta il valore della propriet� dataFineAttivitaAllevamento.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataFineAttivitaAllevamento(XMLGregorianCalendar value) {
        this.dataFineAttivitaAllevamento = value;
    }

    /**
     * Recupera il valore della propriet� dataFinePeriodo.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataFinePeriodo() {
        return dataFinePeriodo;
    }

    /**
     * Imposta il valore della propriet� dataFinePeriodo.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataFinePeriodo(XMLGregorianCalendar value) {
        this.dataFinePeriodo = value;
    }

    /**
     * Recupera il valore della propriet� dataInizioAttivitaAllevamento.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataInizioAttivitaAllevamento() {
        return dataInizioAttivitaAllevamento;
    }

    /**
     * Imposta il valore della propriet� dataInizioAttivitaAllevamento.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataInizioAttivitaAllevamento(XMLGregorianCalendar value) {
        this.dataInizioAttivitaAllevamento = value;
    }

    /**
     * Recupera il valore della propriet� dataInizioPeriodo.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataInizioPeriodo() {
        return dataInizioPeriodo;
    }

    /**
     * Imposta il valore della propriet� dataInizioPeriodo.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataInizioPeriodo(XMLGregorianCalendar value) {
        this.dataInizioPeriodo = value;
    }

    /**
     * Recupera il valore della propriet� dataMaxCalcoloCapi.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataMaxCalcoloCapi() {
        return dataMaxCalcoloCapi;
    }

    /**
     * Imposta il valore della propriet� dataMaxCalcoloCapi.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataMaxCalcoloCapi(XMLGregorianCalendar value) {
        this.dataMaxCalcoloCapi = value;
    }

    /**
     * Recupera il valore della propriet� dataMinCalcoloCapi.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataMinCalcoloCapi() {
        return dataMinCalcoloCapi;
    }

    /**
     * Imposta il valore della propriet� dataMinCalcoloCapi.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataMinCalcoloCapi(XMLGregorianCalendar value) {
        this.dataMinCalcoloCapi = value;
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
     * Recupera il valore della propriet� mediaCapiTotali.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMediaCapiTotali() {
        return mediaCapiTotali;
    }

    /**
     * Imposta il valore della propriet� mediaCapiTotali.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMediaCapiTotali(BigDecimal value) {
        this.mediaCapiTotali = value;
    }

    /**
     * Recupera il valore della propriet� mediaFemmineBov012Mesi.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMediaFemmineBov012Mesi() {
        return mediaFemmineBov012Mesi;
    }

    /**
     * Imposta il valore della propriet� mediaFemmineBov012Mesi.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMediaFemmineBov012Mesi(BigDecimal value) {
        this.mediaFemmineBov012Mesi = value;
    }

    /**
     * Recupera il valore della propriet� mediaFemmineBov1224Mesi.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMediaFemmineBov1224Mesi() {
        return mediaFemmineBov1224Mesi;
    }

    /**
     * Imposta il valore della propriet� mediaFemmineBov1224Mesi.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMediaFemmineBov1224Mesi(BigDecimal value) {
        this.mediaFemmineBov1224Mesi = value;
    }

    /**
     * Recupera il valore della propriet� mediaFemmineBuf012Mesi.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMediaFemmineBuf012Mesi() {
        return mediaFemmineBuf012Mesi;
    }

    /**
     * Imposta il valore della propriet� mediaFemmineBuf012Mesi.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMediaFemmineBuf012Mesi(BigDecimal value) {
        this.mediaFemmineBuf012Mesi = value;
    }

    /**
     * Recupera il valore della propriet� mediaFemmineBuf1224Mesi.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMediaFemmineBuf1224Mesi() {
        return mediaFemmineBuf1224Mesi;
    }

    /**
     * Imposta il valore della propriet� mediaFemmineBuf1224Mesi.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMediaFemmineBuf1224Mesi(BigDecimal value) {
        this.mediaFemmineBuf1224Mesi = value;
    }

    /**
     * Recupera il valore della propriet� mediaMaschiBov012Mesi.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMediaMaschiBov012Mesi() {
        return mediaMaschiBov012Mesi;
    }

    /**
     * Imposta il valore della propriet� mediaMaschiBov012Mesi.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMediaMaschiBov012Mesi(BigDecimal value) {
        this.mediaMaschiBov012Mesi = value;
    }

    /**
     * Recupera il valore della propriet� mediaMaschiBov1224Mesi.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMediaMaschiBov1224Mesi() {
        return mediaMaschiBov1224Mesi;
    }

    /**
     * Imposta il valore della propriet� mediaMaschiBov1224Mesi.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMediaMaschiBov1224Mesi(BigDecimal value) {
        this.mediaMaschiBov1224Mesi = value;
    }

    /**
     * Recupera il valore della propriet� mediaMaschiBuf012Mesi.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMediaMaschiBuf012Mesi() {
        return mediaMaschiBuf012Mesi;
    }

    /**
     * Imposta il valore della propriet� mediaMaschiBuf012Mesi.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMediaMaschiBuf012Mesi(BigDecimal value) {
        this.mediaMaschiBuf012Mesi = value;
    }

    /**
     * Recupera il valore della propriet� mediaMaschiBuf1224Mesi.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMediaMaschiBuf1224Mesi() {
        return mediaMaschiBuf1224Mesi;
    }

    /**
     * Imposta il valore della propriet� mediaMaschiBuf1224Mesi.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMediaMaschiBuf1224Mesi(BigDecimal value) {
        this.mediaMaschiBuf1224Mesi = value;
    }

    /**
     * Recupera il valore della propriet� numElaborazioni.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNumElaborazioni() {
        return numElaborazioni;
    }

    /**
     * Imposta il valore della propriet� numElaborazioni.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNumElaborazioni(BigDecimal value) {
        this.numElaborazioni = value;
    }

}
