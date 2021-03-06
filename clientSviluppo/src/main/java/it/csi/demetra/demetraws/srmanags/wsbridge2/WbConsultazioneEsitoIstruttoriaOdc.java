
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per wbConsultazioneEsitoIstruttoriaOdc complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbConsultazioneEsitoIstruttoriaOdc">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codiceOperatore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataVisita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="esitoVerifica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="identificativoSian" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="misurePrescrittive" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nominativoIspettore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operatoreDelegato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prelieviPerAnalisi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="protocolliEsterni" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbProtEsternoNotificaVO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wbConsultazioneEsitoIstruttoriaOdc", propOrder = {
    "codiceOperatore",
    "dataVisita",
    "esitoVerifica",
    "identificativoSian",
    "misurePrescrittive",
    "nominativoIspettore",
    "note",
    "operatoreDelegato",
    "prelieviPerAnalisi",
    "protocolliEsterni"
})
public class WbConsultazioneEsitoIstruttoriaOdc {

    protected String codiceOperatore;
    protected String dataVisita;
    protected String esitoVerifica;
    protected String identificativoSian;
    protected String misurePrescrittive;
    protected String nominativoIspettore;
    protected String note;
    protected String operatoreDelegato;
    protected String prelieviPerAnalisi;
    @XmlElement(nillable = true)
    protected List<WbProtEsternoNotificaVO> protocolliEsterni;

    /**
     * Recupera il valore della propriet� codiceOperatore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceOperatore() {
        return codiceOperatore;
    }

    /**
     * Imposta il valore della propriet� codiceOperatore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceOperatore(String value) {
        this.codiceOperatore = value;
    }

    /**
     * Recupera il valore della propriet� dataVisita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataVisita() {
        return dataVisita;
    }

    /**
     * Imposta il valore della propriet� dataVisita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataVisita(String value) {
        this.dataVisita = value;
    }

    /**
     * Recupera il valore della propriet� esitoVerifica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEsitoVerifica() {
        return esitoVerifica;
    }

    /**
     * Imposta il valore della propriet� esitoVerifica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEsitoVerifica(String value) {
        this.esitoVerifica = value;
    }

    /**
     * Recupera il valore della propriet� identificativoSian.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificativoSian() {
        return identificativoSian;
    }

    /**
     * Imposta il valore della propriet� identificativoSian.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificativoSian(String value) {
        this.identificativoSian = value;
    }

    /**
     * Recupera il valore della propriet� misurePrescrittive.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMisurePrescrittive() {
        return misurePrescrittive;
    }

    /**
     * Imposta il valore della propriet� misurePrescrittive.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMisurePrescrittive(String value) {
        this.misurePrescrittive = value;
    }

    /**
     * Recupera il valore della propriet� nominativoIspettore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNominativoIspettore() {
        return nominativoIspettore;
    }

    /**
     * Imposta il valore della propriet� nominativoIspettore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNominativoIspettore(String value) {
        this.nominativoIspettore = value;
    }

    /**
     * Recupera il valore della propriet� note.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNote() {
        return note;
    }

    /**
     * Imposta il valore della propriet� note.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNote(String value) {
        this.note = value;
    }

    /**
     * Recupera il valore della propriet� operatoreDelegato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatoreDelegato() {
        return operatoreDelegato;
    }

    /**
     * Imposta il valore della propriet� operatoreDelegato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatoreDelegato(String value) {
        this.operatoreDelegato = value;
    }

    /**
     * Recupera il valore della propriet� prelieviPerAnalisi.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrelieviPerAnalisi() {
        return prelieviPerAnalisi;
    }

    /**
     * Imposta il valore della propriet� prelieviPerAnalisi.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrelieviPerAnalisi(String value) {
        this.prelieviPerAnalisi = value;
    }

    /**
     * Gets the value of the protocolliEsterni property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the protocolliEsterni property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProtocolliEsterni().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WbProtEsternoNotificaVO }
     * 
     * 
     */
    public List<WbProtEsternoNotificaVO> getProtocolliEsterni() {
        if (protocolliEsterni == null) {
            protocolliEsterni = new ArrayList<WbProtEsternoNotificaVO>();
        }
        return this.protocolliEsterni;
    }

}
