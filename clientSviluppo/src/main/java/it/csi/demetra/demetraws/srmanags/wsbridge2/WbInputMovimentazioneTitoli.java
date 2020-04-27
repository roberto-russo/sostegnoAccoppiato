
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per wbInputMovimentazioneTitoli complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbInputMovimentazioneTitoli">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="campagna" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cedente" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbCedente" minOccurs="0"/>
 *         &lt;element name="consensoCedente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataCompilazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataConsenso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataRilascio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataTermineConferimento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fattispecie" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="intestatario" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbIntestatario" minOccurs="0"/>
 *         &lt;element name="vTitoliMovimentati" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbTitoliMovimentati" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wbInputMovimentazioneTitoli", propOrder = {
    "campagna",
    "cedente",
    "consensoCedente",
    "dataCompilazione",
    "dataConsenso",
    "dataRilascio",
    "dataTermineConferimento",
    "fattispecie",
    "idDocumento",
    "intestatario",
    "vTitoliMovimentati"
})
public class WbInputMovimentazioneTitoli {

    protected String campagna;
    protected WbCedente cedente;
    protected String consensoCedente;
    protected String dataCompilazione;
    protected String dataConsenso;
    protected String dataRilascio;
    protected String dataTermineConferimento;
    protected String fattispecie;
    protected String idDocumento;
    protected WbIntestatario intestatario;
    @XmlElement(nillable = true)
    protected List<WbTitoliMovimentati> vTitoliMovimentati;

    /**
     * Recupera il valore della propriet� campagna.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampagna() {
        return campagna;
    }

    /**
     * Imposta il valore della propriet� campagna.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampagna(String value) {
        this.campagna = value;
    }

    /**
     * Recupera il valore della propriet� cedente.
     * 
     * @return
     *     possible object is
     *     {@link WbCedente }
     *     
     */
    public WbCedente getCedente() {
        return cedente;
    }

    /**
     * Imposta il valore della propriet� cedente.
     * 
     * @param value
     *     allowed object is
     *     {@link WbCedente }
     *     
     */
    public void setCedente(WbCedente value) {
        this.cedente = value;
    }

    /**
     * Recupera il valore della propriet� consensoCedente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConsensoCedente() {
        return consensoCedente;
    }

    /**
     * Imposta il valore della propriet� consensoCedente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConsensoCedente(String value) {
        this.consensoCedente = value;
    }

    /**
     * Recupera il valore della propriet� dataCompilazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataCompilazione() {
        return dataCompilazione;
    }

    /**
     * Imposta il valore della propriet� dataCompilazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataCompilazione(String value) {
        this.dataCompilazione = value;
    }

    /**
     * Recupera il valore della propriet� dataConsenso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataConsenso() {
        return dataConsenso;
    }

    /**
     * Imposta il valore della propriet� dataConsenso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataConsenso(String value) {
        this.dataConsenso = value;
    }

    /**
     * Recupera il valore della propriet� dataRilascio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataRilascio() {
        return dataRilascio;
    }

    /**
     * Imposta il valore della propriet� dataRilascio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataRilascio(String value) {
        this.dataRilascio = value;
    }

    /**
     * Recupera il valore della propriet� dataTermineConferimento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataTermineConferimento() {
        return dataTermineConferimento;
    }

    /**
     * Imposta il valore della propriet� dataTermineConferimento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataTermineConferimento(String value) {
        this.dataTermineConferimento = value;
    }

    /**
     * Recupera il valore della propriet� fattispecie.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFattispecie() {
        return fattispecie;
    }

    /**
     * Imposta il valore della propriet� fattispecie.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFattispecie(String value) {
        this.fattispecie = value;
    }

    /**
     * Recupera il valore della propriet� idDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdDocumento() {
        return idDocumento;
    }

    /**
     * Imposta il valore della propriet� idDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdDocumento(String value) {
        this.idDocumento = value;
    }

    /**
     * Recupera il valore della propriet� intestatario.
     * 
     * @return
     *     possible object is
     *     {@link WbIntestatario }
     *     
     */
    public WbIntestatario getIntestatario() {
        return intestatario;
    }

    /**
     * Imposta il valore della propriet� intestatario.
     * 
     * @param value
     *     allowed object is
     *     {@link WbIntestatario }
     *     
     */
    public void setIntestatario(WbIntestatario value) {
        this.intestatario = value;
    }

    /**
     * Gets the value of the vTitoliMovimentati property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vTitoliMovimentati property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVTitoliMovimentati().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WbTitoliMovimentati }
     * 
     * 
     */
    public List<WbTitoliMovimentati> getVTitoliMovimentati() {
        if (vTitoliMovimentati == null) {
            vTitoliMovimentati = new ArrayList<WbTitoliMovimentati>();
        }
        return this.vTitoliMovimentati;
    }

}
