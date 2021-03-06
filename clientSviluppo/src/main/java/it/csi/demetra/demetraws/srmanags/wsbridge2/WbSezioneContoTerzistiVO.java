
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per wbSezioneContoTerzistiVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbSezioneContoTerzistiVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codComune" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codProvincia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codRegione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceFiscale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="elencoPreparazioni" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbSezionePreparazioneVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="elencoStrutture" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbSezioneStruttureVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="flagassogettato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="indirizzo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recapito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="telefono" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wbSezioneContoTerzistiVO", propOrder = {
    "codComune",
    "codProvincia",
    "codRegione",
    "codiceFiscale",
    "elencoPreparazioni",
    "elencoStrutture",
    "flagassogettato",
    "indirizzo",
    "recapito",
    "telefono"
})
public class WbSezioneContoTerzistiVO {

    protected String codComune;
    protected String codProvincia;
    protected String codRegione;
    protected String codiceFiscale;
    @XmlElement(nillable = true)
    protected List<WbSezionePreparazioneVO> elencoPreparazioni;
    @XmlElement(nillable = true)
    protected List<WbSezioneStruttureVO> elencoStrutture;
    protected String flagassogettato;
    protected String indirizzo;
    protected String recapito;
    protected String telefono;

    /**
     * Recupera il valore della propriet� codComune.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodComune() {
        return codComune;
    }

    /**
     * Imposta il valore della propriet� codComune.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodComune(String value) {
        this.codComune = value;
    }

    /**
     * Recupera il valore della propriet� codProvincia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodProvincia() {
        return codProvincia;
    }

    /**
     * Imposta il valore della propriet� codProvincia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodProvincia(String value) {
        this.codProvincia = value;
    }

    /**
     * Recupera il valore della propriet� codRegione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodRegione() {
        return codRegione;
    }

    /**
     * Imposta il valore della propriet� codRegione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodRegione(String value) {
        this.codRegione = value;
    }

    /**
     * Recupera il valore della propriet� codiceFiscale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    /**
     * Imposta il valore della propriet� codiceFiscale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceFiscale(String value) {
        this.codiceFiscale = value;
    }

    /**
     * Gets the value of the elencoPreparazioni property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the elencoPreparazioni property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElencoPreparazioni().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WbSezionePreparazioneVO }
     * 
     * 
     */
    public List<WbSezionePreparazioneVO> getElencoPreparazioni() {
        if (elencoPreparazioni == null) {
            elencoPreparazioni = new ArrayList<WbSezionePreparazioneVO>();
        }
        return this.elencoPreparazioni;
    }

    /**
     * Gets the value of the elencoStrutture property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the elencoStrutture property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElencoStrutture().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WbSezioneStruttureVO }
     * 
     * 
     */
    public List<WbSezioneStruttureVO> getElencoStrutture() {
        if (elencoStrutture == null) {
            elencoStrutture = new ArrayList<WbSezioneStruttureVO>();
        }
        return this.elencoStrutture;
    }

    /**
     * Recupera il valore della propriet� flagassogettato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlagassogettato() {
        return flagassogettato;
    }

    /**
     * Imposta il valore della propriet� flagassogettato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlagassogettato(String value) {
        this.flagassogettato = value;
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
     * Recupera il valore della propriet� recapito.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecapito() {
        return recapito;
    }

    /**
     * Imposta il valore della propriet� recapito.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecapito(String value) {
        this.recapito = value;
    }

    /**
     * Recupera il valore della propriet� telefono.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Imposta il valore della propriet� telefono.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefono(String value) {
        this.telefono = value;
    }

}
