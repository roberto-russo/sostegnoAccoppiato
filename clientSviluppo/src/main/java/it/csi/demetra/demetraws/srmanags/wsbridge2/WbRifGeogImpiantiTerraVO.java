
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per wbRifGeogImpiantiTerraVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbRifGeogImpiantiTerraVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codiceBelfiore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="foglio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="indirizzo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="particella" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sezione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subalterno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="superficie" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="titoloPossesso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="utilizzoPrincipale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="volume" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wbRifGeogImpiantiTerraVO", propOrder = {
    "codiceBelfiore",
    "foglio",
    "indirizzo",
    "particella",
    "sezione",
    "subalterno",
    "superficie",
    "titoloPossesso",
    "utilizzoPrincipale",
    "volume"
})
public class WbRifGeogImpiantiTerraVO {

    protected String codiceBelfiore;
    protected String foglio;
    protected String indirizzo;
    protected String particella;
    protected String sezione;
    protected String subalterno;
    protected String superficie;
    protected String titoloPossesso;
    protected String utilizzoPrincipale;
    protected String volume;

    /**
     * Recupera il valore della propriet� codiceBelfiore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceBelfiore() {
        return codiceBelfiore;
    }

    /**
     * Imposta il valore della propriet� codiceBelfiore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceBelfiore(String value) {
        this.codiceBelfiore = value;
    }

    /**
     * Recupera il valore della propriet� foglio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFoglio() {
        return foglio;
    }

    /**
     * Imposta il valore della propriet� foglio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFoglio(String value) {
        this.foglio = value;
    }

    /**
     * Recupera il valore della propriet� indirizzo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndirizzo() {
        return indirizzo;
    }

    /**
     * Imposta il valore della propriet� indirizzo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndirizzo(String value) {
        this.indirizzo = value;
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
     * Recupera il valore della propriet� superficie.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuperficie() {
        return superficie;
    }

    /**
     * Imposta il valore della propriet� superficie.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuperficie(String value) {
        this.superficie = value;
    }

    /**
     * Recupera il valore della propriet� titoloPossesso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitoloPossesso() {
        return titoloPossesso;
    }

    /**
     * Imposta il valore della propriet� titoloPossesso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitoloPossesso(String value) {
        this.titoloPossesso = value;
    }

    /**
     * Recupera il valore della propriet� utilizzoPrincipale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUtilizzoPrincipale() {
        return utilizzoPrincipale;
    }

    /**
     * Imposta il valore della propriet� utilizzoPrincipale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUtilizzoPrincipale(String value) {
        this.utilizzoPrincipale = value;
    }

    /**
     * Recupera il valore della propriet� volume.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVolume() {
        return volume;
    }

    /**
     * Imposta il valore della propriet� volume.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVolume(String value) {
        this.volume = value;
    }

}
