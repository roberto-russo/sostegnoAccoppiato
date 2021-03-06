
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per wbConsistenzaPascoloPAC2015VO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbConsistenzaPascoloPAC2015VO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codFiscaleDetentore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codicePascolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cuaa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fasciaEta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="foglioCatastale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="grspeCodice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="istatComune" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="latitudine" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="localita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="longitudine" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="numCapi" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="particella" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sezione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="siglaProvincia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="speCodice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="speDescrizione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subalterno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totGgPascolamento" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wbConsistenzaPascoloPAC2015VO", propOrder = {
    "codFiscaleDetentore",
    "codicePascolo",
    "cuaa",
    "fasciaEta",
    "foglioCatastale",
    "grspeCodice",
    "istatComune",
    "latitudine",
    "localita",
    "longitudine",
    "numCapi",
    "particella",
    "sezione",
    "siglaProvincia",
    "speCodice",
    "speDescrizione",
    "subalterno",
    "totGgPascolamento"
})
public class WbConsistenzaPascoloPAC2015VO {

    protected String codFiscaleDetentore;
    protected String codicePascolo;
    protected String cuaa;
    protected String fasciaEta;
    protected String foglioCatastale;
    protected String grspeCodice;
    protected String istatComune;
    protected BigDecimal latitudine;
    protected String localita;
    protected BigDecimal longitudine;
    protected BigDecimal numCapi;
    protected String particella;
    protected String sezione;
    protected String siglaProvincia;
    protected String speCodice;
    protected String speDescrizione;
    protected String subalterno;
    protected BigDecimal totGgPascolamento;

    /**
     * Recupera il valore della propriet� codFiscaleDetentore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodFiscaleDetentore() {
        return codFiscaleDetentore;
    }

    /**
     * Imposta il valore della propriet� codFiscaleDetentore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodFiscaleDetentore(String value) {
        this.codFiscaleDetentore = value;
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
     * Recupera il valore della propriet� fasciaEta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFasciaEta() {
        return fasciaEta;
    }

    /**
     * Imposta il valore della propriet� fasciaEta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFasciaEta(String value) {
        this.fasciaEta = value;
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
     * Recupera il valore della propriet� grspeCodice.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGrspeCodice() {
        return grspeCodice;
    }

    /**
     * Imposta il valore della propriet� grspeCodice.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrspeCodice(String value) {
        this.grspeCodice = value;
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
     * Recupera il valore della propriet� numCapi.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNumCapi() {
        return numCapi;
    }

    /**
     * Imposta il valore della propriet� numCapi.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNumCapi(BigDecimal value) {
        this.numCapi = value;
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
     * Recupera il valore della propriet� speCodice.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpeCodice() {
        return speCodice;
    }

    /**
     * Imposta il valore della propriet� speCodice.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpeCodice(String value) {
        this.speCodice = value;
    }

    /**
     * Recupera il valore della propriet� speDescrizione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpeDescrizione() {
        return speDescrizione;
    }

    /**
     * Imposta il valore della propriet� speDescrizione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpeDescrizione(String value) {
        this.speDescrizione = value;
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

    /**
     * Recupera il valore della propriet� totGgPascolamento.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotGgPascolamento() {
        return totGgPascolamento;
    }

    /**
     * Imposta il valore della propriet� totGgPascolamento.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotGgPascolamento(BigDecimal value) {
        this.totGgPascolamento = value;
    }

}
