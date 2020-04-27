
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per wbSezioneZootecniaVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbSezioneZootecniaVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codiceASL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="consistenza" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gruppoAllevamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idProgressivoUP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="metodo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="specieAnimale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoProduzione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UBACorrispondenti" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wbSezioneZootecniaVO", propOrder = {
    "codiceASL",
    "consistenza",
    "gruppoAllevamento",
    "idProgressivoUP",
    "metodo",
    "specieAnimale",
    "tipoProduzione",
    "ubaCorrispondenti"
})
public class WbSezioneZootecniaVO {

    protected String codiceASL;
    protected String consistenza;
    protected String gruppoAllevamento;
    protected String idProgressivoUP;
    protected String metodo;
    protected String specieAnimale;
    protected String tipoProduzione;
    @XmlElement(name = "UBACorrispondenti")
    protected String ubaCorrispondenti;

    /**
     * Recupera il valore della propriet� codiceASL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceASL() {
        return codiceASL;
    }

    /**
     * Imposta il valore della propriet� codiceASL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceASL(String value) {
        this.codiceASL = value;
    }

    /**
     * Recupera il valore della propriet� consistenza.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConsistenza() {
        return consistenza;
    }

    /**
     * Imposta il valore della propriet� consistenza.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConsistenza(String value) {
        this.consistenza = value;
    }

    /**
     * Recupera il valore della propriet� gruppoAllevamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGruppoAllevamento() {
        return gruppoAllevamento;
    }

    /**
     * Imposta il valore della propriet� gruppoAllevamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGruppoAllevamento(String value) {
        this.gruppoAllevamento = value;
    }

    /**
     * Recupera il valore della propriet� idProgressivoUP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdProgressivoUP() {
        return idProgressivoUP;
    }

    /**
     * Imposta il valore della propriet� idProgressivoUP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdProgressivoUP(String value) {
        this.idProgressivoUP = value;
    }

    /**
     * Recupera il valore della propriet� metodo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMetodo() {
        return metodo;
    }

    /**
     * Imposta il valore della propriet� metodo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMetodo(String value) {
        this.metodo = value;
    }

    /**
     * Recupera il valore della propriet� specieAnimale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecieAnimale() {
        return specieAnimale;
    }

    /**
     * Imposta il valore della propriet� specieAnimale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecieAnimale(String value) {
        this.specieAnimale = value;
    }

    /**
     * Recupera il valore della propriet� tipoProduzione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoProduzione() {
        return tipoProduzione;
    }

    /**
     * Imposta il valore della propriet� tipoProduzione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoProduzione(String value) {
        this.tipoProduzione = value;
    }

    /**
     * Recupera il valore della propriet� ubaCorrispondenti.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUBACorrispondenti() {
        return ubaCorrispondenti;
    }

    /**
     * Imposta il valore della propriet� ubaCorrispondenti.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUBACorrispondenti(String value) {
        this.ubaCorrispondenti = value;
    }

}
