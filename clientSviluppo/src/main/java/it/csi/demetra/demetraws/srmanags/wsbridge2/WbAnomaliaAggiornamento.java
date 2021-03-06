
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per wbAnomaliaAggiornamento complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbAnomaliaAggiornamento">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codiceAnomalia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceTipoAnomalia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idTitolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wbAnomaliaAggiornamento", propOrder = {
    "codiceAnomalia",
    "codiceTipoAnomalia",
    "idTitolo"
})
public class WbAnomaliaAggiornamento {

    protected String codiceAnomalia;
    protected String codiceTipoAnomalia;
    protected String idTitolo;

    /**
     * Recupera il valore della propriet� codiceAnomalia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceAnomalia() {
        return codiceAnomalia;
    }

    /**
     * Imposta il valore della propriet� codiceAnomalia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceAnomalia(String value) {
        this.codiceAnomalia = value;
    }

    /**
     * Recupera il valore della propriet� codiceTipoAnomalia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceTipoAnomalia() {
        return codiceTipoAnomalia;
    }

    /**
     * Imposta il valore della propriet� codiceTipoAnomalia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceTipoAnomalia(String value) {
        this.codiceTipoAnomalia = value;
    }

    /**
     * Recupera il valore della propriet� idTitolo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdTitolo() {
        return idTitolo;
    }

    /**
     * Imposta il valore della propriet� idTitolo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdTitolo(String value) {
        this.idTitolo = value;
    }

}
