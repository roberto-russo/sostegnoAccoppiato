
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per wbPascoloVisitatoVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbPascoloVisitatoVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codiceAsl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codicePascolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="denominazioneAsl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="denominazionePascolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrizioneComune" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="foglioCatastale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idAsl" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="idComune" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="idFiscaleResponsabile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idPascolo" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="istatComune" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="latitudine" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="localita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="longitudine" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="particella" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sezione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="siglaProvincia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subalterno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wbPascoloVisitatoVO", propOrder = {
    "codiceAsl",
    "codicePascolo",
    "denominazioneAsl",
    "denominazionePascolo",
    "descrizioneComune",
    "foglioCatastale",
    "idAsl",
    "idComune",
    "idFiscaleResponsabile",
    "idPascolo",
    "istatComune",
    "latitudine",
    "localita",
    "longitudine",
    "particella",
    "sezione",
    "siglaProvincia",
    "subalterno"
})
public class WbPascoloVisitatoVO {

    protected String codiceAsl;
    protected String codicePascolo;
    protected String denominazioneAsl;
    protected String denominazionePascolo;
    protected String descrizioneComune;
    protected String foglioCatastale;
    protected BigDecimal idAsl;
    protected BigDecimal idComune;
    protected String idFiscaleResponsabile;
    protected BigDecimal idPascolo;
    protected String istatComune;
    protected BigDecimal latitudine;
    protected String localita;
    protected BigDecimal longitudine;
    protected String particella;
    protected String sezione;
    protected String siglaProvincia;
    protected String subalterno;

    /**
     * Recupera il valore della propriet� codiceAsl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceAsl() {
        return codiceAsl;
    }

    /**
     * Imposta il valore della propriet� codiceAsl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceAsl(String value) {
        this.codiceAsl = value;
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
     * Recupera il valore della propriet� denominazioneAsl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenominazioneAsl() {
        return denominazioneAsl;
    }

    /**
     * Imposta il valore della propriet� denominazioneAsl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenominazioneAsl(String value) {
        this.denominazioneAsl = value;
    }

    /**
     * Recupera il valore della propriet� denominazionePascolo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenominazionePascolo() {
        return denominazionePascolo;
    }

    /**
     * Imposta il valore della propriet� denominazionePascolo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenominazionePascolo(String value) {
        this.denominazionePascolo = value;
    }

    /**
     * Recupera il valore della propriet� descrizioneComune.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrizioneComune() {
        return descrizioneComune;
    }

    /**
     * Imposta il valore della propriet� descrizioneComune.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrizioneComune(String value) {
        this.descrizioneComune = value;
    }

    /**
     * Recupera il valore della propriet� foglioCatastale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFoglioCatastale() {
        return foglioCatastale;
    }

    /**
     * Imposta il valore della propriet� foglioCatastale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFoglioCatastale(String value) {
        this.foglioCatastale = value;
    }

    /**
     * Recupera il valore della propriet� idAsl.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdAsl() {
        return idAsl;
    }

    /**
     * Imposta il valore della propriet� idAsl.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdAsl(BigDecimal value) {
        this.idAsl = value;
    }

    /**
     * Recupera il valore della propriet� idComune.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdComune() {
        return idComune;
    }

    /**
     * Imposta il valore della propriet� idComune.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdComune(BigDecimal value) {
        this.idComune = value;
    }

    /**
     * Recupera il valore della propriet� idFiscaleResponsabile.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdFiscaleResponsabile() {
        return idFiscaleResponsabile;
    }

    /**
     * Imposta il valore della propriet� idFiscaleResponsabile.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdFiscaleResponsabile(String value) {
        this.idFiscaleResponsabile = value;
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
     * Recupera il valore della propriet� istatComune.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIstatComune() {
        return istatComune;
    }

    /**
     * Imposta il valore della propriet� istatComune.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIstatComune(String value) {
        this.istatComune = value;
    }

    /**
     * Recupera il valore della propriet� latitudine.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLatitudine() {
        return latitudine;
    }

    /**
     * Imposta il valore della propriet� latitudine.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLatitudine(BigDecimal value) {
        this.latitudine = value;
    }

    /**
     * Recupera il valore della propriet� localita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalita() {
        return localita;
    }

    /**
     * Imposta il valore della propriet� localita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalita(String value) {
        this.localita = value;
    }

    /**
     * Recupera il valore della propriet� longitudine.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLongitudine() {
        return longitudine;
    }

    /**
     * Imposta il valore della propriet� longitudine.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLongitudine(BigDecimal value) {
        this.longitudine = value;
    }

    /**
     * Recupera il valore della propriet� particella.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParticella() {
        return particella;
    }

    /**
     * Imposta il valore della propriet� particella.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParticella(String value) {
        this.particella = value;
    }

    /**
     * Recupera il valore della propriet� sezione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSezione() {
        return sezione;
    }

    /**
     * Imposta il valore della propriet� sezione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSezione(String value) {
        this.sezione = value;
    }

    /**
     * Recupera il valore della propriet� siglaProvincia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiglaProvincia() {
        return siglaProvincia;
    }

    /**
     * Imposta il valore della propriet� siglaProvincia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiglaProvincia(String value) {
        this.siglaProvincia = value;
    }

    /**
     * Recupera il valore della propriet� subalterno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubalterno() {
        return subalterno;
    }

    /**
     * Imposta il valore della propriet� subalterno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubalterno(String value) {
        this.subalterno = value;
    }

}
