
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per wbUnitaProduttivaVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbUnitaProduttivaVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codiceAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceBelfiore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceCap" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceTipologia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idProgressivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="indirizzo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rappDelegatoCF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recapito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wbUnitaProduttivaVO", propOrder = {
    "codiceAttivita",
    "codiceBelfiore",
    "codiceCap",
    "codiceTipologia",
    "idProgressivo",
    "indirizzo",
    "rappDelegatoCF",
    "recapito"
})
public class WbUnitaProduttivaVO {

    protected String codiceAttivita;
    protected String codiceBelfiore;
    protected String codiceCap;
    protected String codiceTipologia;
    protected String idProgressivo;
    protected String indirizzo;
    protected String rappDelegatoCF;
    protected String recapito;

    /**
     * Recupera il valore della propriet� codiceAttivita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceAttivita() {
        return codiceAttivita;
    }

    /**
     * Imposta il valore della propriet� codiceAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceAttivita(String value) {
        this.codiceAttivita = value;
    }

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
     * Recupera il valore della propriet� codiceCap.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceCap() {
        return codiceCap;
    }

    /**
     * Imposta il valore della propriet� codiceCap.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceCap(String value) {
        this.codiceCap = value;
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
     * Recupera il valore della propriet� idProgressivo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdProgressivo() {
        return idProgressivo;
    }

    /**
     * Imposta il valore della propriet� idProgressivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdProgressivo(String value) {
        this.idProgressivo = value;
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
     * Recupera il valore della propriet� rappDelegatoCF.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRappDelegatoCF() {
        return rappDelegatoCF;
    }

    /**
     * Imposta il valore della propriet� rappDelegatoCF.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRappDelegatoCF(String value) {
        this.rappDelegatoCF = value;
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

}
