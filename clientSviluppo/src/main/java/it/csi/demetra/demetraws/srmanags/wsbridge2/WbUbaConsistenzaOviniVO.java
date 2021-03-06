
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per wbUbaConsistenzaOviniVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbUbaConsistenzaOviniVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="aziendaCodice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="capriniFemmine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="capriniMaschi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="capriniTotali" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceFiscaleDetentore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceFiscaleProprietario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceSpecie" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataFinePeriodo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataInizioPeriodo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idAllevamento" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="oviniFemmine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oviniMaschi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oviniTotali" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wbUbaConsistenzaOviniVO", propOrder = {
    "aziendaCodice",
    "capriniFemmine",
    "capriniMaschi",
    "capriniTotali",
    "codiceFiscaleDetentore",
    "codiceFiscaleProprietario",
    "codiceSpecie",
    "dataFinePeriodo",
    "dataInizioPeriodo",
    "idAllevamento",
    "oviniFemmine",
    "oviniMaschi",
    "oviniTotali"
})
public class WbUbaConsistenzaOviniVO {

    protected String aziendaCodice;
    protected String capriniFemmine;
    protected String capriniMaschi;
    protected String capriniTotali;
    protected String codiceFiscaleDetentore;
    protected String codiceFiscaleProprietario;
    protected String codiceSpecie;
    protected String dataFinePeriodo;
    protected String dataInizioPeriodo;
    protected BigDecimal idAllevamento;
    protected String oviniFemmine;
    protected String oviniMaschi;
    protected String oviniTotali;

    /**
     * Recupera il valore della propriet� aziendaCodice.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAziendaCodice() {
        return aziendaCodice;
    }

    /**
     * Imposta il valore della propriet� aziendaCodice.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAziendaCodice(String value) {
        this.aziendaCodice = value;
    }

    /**
     * Recupera il valore della propriet� capriniFemmine.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapriniFemmine() {
        return capriniFemmine;
    }

    /**
     * Imposta il valore della propriet� capriniFemmine.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapriniFemmine(String value) {
        this.capriniFemmine = value;
    }

    /**
     * Recupera il valore della propriet� capriniMaschi.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapriniMaschi() {
        return capriniMaschi;
    }

    /**
     * Imposta il valore della propriet� capriniMaschi.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapriniMaschi(String value) {
        this.capriniMaschi = value;
    }

    /**
     * Recupera il valore della propriet� capriniTotali.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapriniTotali() {
        return capriniTotali;
    }

    /**
     * Imposta il valore della propriet� capriniTotali.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapriniTotali(String value) {
        this.capriniTotali = value;
    }

    /**
     * Recupera il valore della propriet� codiceFiscaleDetentore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceFiscaleDetentore() {
        return codiceFiscaleDetentore;
    }

    /**
     * Imposta il valore della propriet� codiceFiscaleDetentore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceFiscaleDetentore(String value) {
        this.codiceFiscaleDetentore = value;
    }

    /**
     * Recupera il valore della propriet� codiceFiscaleProprietario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceFiscaleProprietario() {
        return codiceFiscaleProprietario;
    }

    /**
     * Imposta il valore della propriet� codiceFiscaleProprietario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceFiscaleProprietario(String value) {
        this.codiceFiscaleProprietario = value;
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
     * Recupera il valore della propriet� oviniFemmine.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOviniFemmine() {
        return oviniFemmine;
    }

    /**
     * Imposta il valore della propriet� oviniFemmine.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOviniFemmine(String value) {
        this.oviniFemmine = value;
    }

    /**
     * Recupera il valore della propriet� oviniMaschi.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOviniMaschi() {
        return oviniMaschi;
    }

    /**
     * Imposta il valore della propriet� oviniMaschi.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOviniMaschi(String value) {
        this.oviniMaschi = value;
    }

    /**
     * Recupera il valore della propriet� oviniTotali.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOviniTotali() {
        return oviniTotali;
    }

    /**
     * Imposta il valore della propriet� oviniTotali.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOviniTotali(String value) {
        this.oviniTotali = value;
    }

}
