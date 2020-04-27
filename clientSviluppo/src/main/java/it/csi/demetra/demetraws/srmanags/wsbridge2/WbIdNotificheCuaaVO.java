
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per wbIdNotificheCuaaVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbIdNotificheCuaaVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codiceMotivoAggiornamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceSistemaSIB" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cuaa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataAggiornamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="identificativoSian" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vProtEsternoNotifica" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbProtEsternoNotificaVO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wbIdNotificheCuaaVO", propOrder = {
    "codiceMotivoAggiornamento",
    "codiceSistemaSIB",
    "cuaa",
    "dataAggiornamento",
    "identificativoSian",
    "vProtEsternoNotifica"
})
public class WbIdNotificheCuaaVO {

    protected String codiceMotivoAggiornamento;
    protected String codiceSistemaSIB;
    protected String cuaa;
    protected String dataAggiornamento;
    protected String identificativoSian;
    @XmlElement(nillable = true)
    protected List<WbProtEsternoNotificaVO> vProtEsternoNotifica;

    /**
     * Recupera il valore della propriet� codiceMotivoAggiornamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceMotivoAggiornamento() {
        return codiceMotivoAggiornamento;
    }

    /**
     * Imposta il valore della propriet� codiceMotivoAggiornamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceMotivoAggiornamento(String value) {
        this.codiceMotivoAggiornamento = value;
    }

    /**
     * Recupera il valore della propriet� codiceSistemaSIB.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceSistemaSIB() {
        return codiceSistemaSIB;
    }

    /**
     * Imposta il valore della propriet� codiceSistemaSIB.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceSistemaSIB(String value) {
        this.codiceSistemaSIB = value;
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
     * Recupera il valore della propriet� dataAggiornamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataAggiornamento() {
        return dataAggiornamento;
    }

    /**
     * Imposta il valore della propriet� dataAggiornamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataAggiornamento(String value) {
        this.dataAggiornamento = value;
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
     * Gets the value of the vProtEsternoNotifica property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vProtEsternoNotifica property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVProtEsternoNotifica().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WbProtEsternoNotificaVO }
     * 
     * 
     */
    public List<WbProtEsternoNotificaVO> getVProtEsternoNotifica() {
        if (vProtEsternoNotifica == null) {
            vProtEsternoNotifica = new ArrayList<WbProtEsternoNotificaVO>();
        }
        return this.vProtEsternoNotifica;
    }

}
