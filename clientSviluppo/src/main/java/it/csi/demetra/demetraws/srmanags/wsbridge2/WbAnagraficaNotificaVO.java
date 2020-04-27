
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per wbAnagraficaNotificaVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbAnagraficaNotificaVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codiceCausaVariazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceTipologia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fonteRegione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="intestatarioCF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ODC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="odcPrecedente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partitaIVA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wbAnagraficaNotificaVO", propOrder = {
    "codiceCausaVariazione",
    "codiceTipologia",
    "fonteRegione",
    "intestatarioCF",
    "odc",
    "odcPrecedente",
    "partitaIVA"
})
public class WbAnagraficaNotificaVO {

    protected String codiceCausaVariazione;
    protected String codiceTipologia;
    protected String fonteRegione;
    protected String intestatarioCF;
    @XmlElement(name = "ODC")
    protected String odc;
    protected String odcPrecedente;
    protected String partitaIVA;

    /**
     * Recupera il valore della propriet� codiceCausaVariazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceCausaVariazione() {
        return codiceCausaVariazione;
    }

    /**
     * Imposta il valore della propriet� codiceCausaVariazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceCausaVariazione(String value) {
        this.codiceCausaVariazione = value;
    }

    /**
     * Recupera il valore della propriet� codiceTipologia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceTipologia() {
        return codiceTipologia;
    }

    /**
     * Imposta il valore della propriet� codiceTipologia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceTipologia(String value) {
        this.codiceTipologia = value;
    }

    /**
     * Recupera il valore della propriet� fonteRegione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFonteRegione() {
        return fonteRegione;
    }

    /**
     * Imposta il valore della propriet� fonteRegione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFonteRegione(String value) {
        this.fonteRegione = value;
    }

    /**
     * Recupera il valore della propriet� intestatarioCF.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntestatarioCF() {
        return intestatarioCF;
    }

    /**
     * Imposta il valore della propriet� intestatarioCF.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntestatarioCF(String value) {
        this.intestatarioCF = value;
    }

    /**
     * Recupera il valore della propriet� odc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getODC() {
        return odc;
    }

    /**
     * Imposta il valore della propriet� odc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setODC(String value) {
        this.odc = value;
    }

    /**
     * Recupera il valore della propriet� odcPrecedente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOdcPrecedente() {
        return odcPrecedente;
    }

    /**
     * Imposta il valore della propriet� odcPrecedente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOdcPrecedente(String value) {
        this.odcPrecedente = value;
    }

    /**
     * Recupera il valore della propriet� partitaIVA.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartitaIVA() {
        return partitaIVA;
    }

    /**
     * Imposta il valore della propriet� partitaIVA.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartitaIVA(String value) {
        this.partitaIVA = value;
    }

}
