
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per wbConsistenzaPascoloVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbConsistenzaPascoloVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="aziendaCodice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="capi624Mesi150gg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="capi624Mesi50gg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="capi624Mesi90gg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="capiOltre24Mesi150gg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="capiOltre24Mesi50gg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="capiOltre24Mesi90gg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codFiscaleDeten" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codPascolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="istatComune" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="localita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pasId" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="siglaProvincia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wbConsistenzaPascoloVO", propOrder = {
    "aziendaCodice",
    "capi624Mesi150Gg",
    "capi624Mesi50Gg",
    "capi624Mesi90Gg",
    "capiOltre24Mesi150Gg",
    "capiOltre24Mesi50Gg",
    "capiOltre24Mesi90Gg",
    "codFiscaleDeten",
    "codPascolo",
    "istatComune",
    "localita",
    "pasId",
    "siglaProvincia"
})
public class WbConsistenzaPascoloVO {

    protected String aziendaCodice;
    @XmlElement(name = "capi624Mesi150gg")
    protected String capi624Mesi150Gg;
    @XmlElement(name = "capi624Mesi50gg")
    protected String capi624Mesi50Gg;
    @XmlElement(name = "capi624Mesi90gg")
    protected String capi624Mesi90Gg;
    @XmlElement(name = "capiOltre24Mesi150gg")
    protected String capiOltre24Mesi150Gg;
    @XmlElement(name = "capiOltre24Mesi50gg")
    protected String capiOltre24Mesi50Gg;
    @XmlElement(name = "capiOltre24Mesi90gg")
    protected String capiOltre24Mesi90Gg;
    protected String codFiscaleDeten;
    protected String codPascolo;
    protected String istatComune;
    protected String localita;
    protected BigDecimal pasId;
    protected String siglaProvincia;

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
     * Recupera il valore della propriet� capi624Mesi150Gg.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapi624Mesi150Gg() {
        return capi624Mesi150Gg;
    }

    /**
     * Imposta il valore della propriet� capi624Mesi150Gg.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapi624Mesi150Gg(String value) {
        this.capi624Mesi150Gg = value;
    }

    /**
     * Recupera il valore della propriet� capi624Mesi50Gg.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapi624Mesi50Gg() {
        return capi624Mesi50Gg;
    }

    /**
     * Imposta il valore della propriet� capi624Mesi50Gg.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapi624Mesi50Gg(String value) {
        this.capi624Mesi50Gg = value;
    }

    /**
     * Recupera il valore della propriet� capi624Mesi90Gg.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapi624Mesi90Gg() {
        return capi624Mesi90Gg;
    }

    /**
     * Imposta il valore della propriet� capi624Mesi90Gg.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapi624Mesi90Gg(String value) {
        this.capi624Mesi90Gg = value;
    }

    /**
     * Recupera il valore della propriet� capiOltre24Mesi150Gg.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapiOltre24Mesi150Gg() {
        return capiOltre24Mesi150Gg;
    }

    /**
     * Imposta il valore della propriet� capiOltre24Mesi150Gg.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapiOltre24Mesi150Gg(String value) {
        this.capiOltre24Mesi150Gg = value;
    }

    /**
     * Recupera il valore della propriet� capiOltre24Mesi50Gg.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapiOltre24Mesi50Gg() {
        return capiOltre24Mesi50Gg;
    }

    /**
     * Imposta il valore della propriet� capiOltre24Mesi50Gg.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapiOltre24Mesi50Gg(String value) {
        this.capiOltre24Mesi50Gg = value;
    }

    /**
     * Recupera il valore della propriet� capiOltre24Mesi90Gg.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapiOltre24Mesi90Gg() {
        return capiOltre24Mesi90Gg;
    }

    /**
     * Imposta il valore della propriet� capiOltre24Mesi90Gg.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapiOltre24Mesi90Gg(String value) {
        this.capiOltre24Mesi90Gg = value;
    }

    /**
     * Recupera il valore della propriet� codFiscaleDeten.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodFiscaleDeten() {
        return codFiscaleDeten;
    }

    /**
     * Imposta il valore della propriet� codFiscaleDeten.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodFiscaleDeten(String value) {
        this.codFiscaleDeten = value;
    }

    /**
     * Recupera il valore della propriet� codPascolo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodPascolo() {
        return codPascolo;
    }

    /**
     * Imposta il valore della propriet� codPascolo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodPascolo(String value) {
        this.codPascolo = value;
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
     * Recupera il valore della propriet� pasId.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPasId() {
        return pasId;
    }

    /**
     * Imposta il valore della propriet� pasId.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPasId(BigDecimal value) {
        this.pasId = value;
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

}
