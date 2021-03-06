
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per cuaaInfoSelAnomaliaVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="cuaaInfoSelAnomaliaVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="anomalieAtto" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}anomaliaAttoVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="anomalieInteAlle" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}anomaliaInteAlleVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="anomalieInteSupe" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}anomaliaInteSupeVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="cuaa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idCoordimaneto" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="idDomaOP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cuaaInfoSelAnomaliaVO", propOrder = {
    "anomalieAtto",
    "anomalieInteAlle",
    "anomalieInteSupe",
    "cuaa",
    "idCoordimaneto",
    "idDomaOP"
})
public class CuaaInfoSelAnomaliaVO {

    @XmlElement(nillable = true)
    protected List<AnomaliaAttoVO> anomalieAtto;
    @XmlElement(nillable = true)
    protected List<AnomaliaInteAlleVO> anomalieInteAlle;
    @XmlElement(nillable = true)
    protected List<AnomaliaInteSupeVO> anomalieInteSupe;
    protected String cuaa;
    protected long idCoordimaneto;
    protected String idDomaOP;

    /**
     * Gets the value of the anomalieAtto property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the anomalieAtto property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnomalieAtto().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AnomaliaAttoVO }
     * 
     * 
     */
    public List<AnomaliaAttoVO> getAnomalieAtto() {
        if (anomalieAtto == null) {
            anomalieAtto = new ArrayList<AnomaliaAttoVO>();
        }
        return this.anomalieAtto;
    }

    /**
     * Gets the value of the anomalieInteAlle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the anomalieInteAlle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnomalieInteAlle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AnomaliaInteAlleVO }
     * 
     * 
     */
    public List<AnomaliaInteAlleVO> getAnomalieInteAlle() {
        if (anomalieInteAlle == null) {
            anomalieInteAlle = new ArrayList<AnomaliaInteAlleVO>();
        }
        return this.anomalieInteAlle;
    }

    /**
     * Gets the value of the anomalieInteSupe property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the anomalieInteSupe property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnomalieInteSupe().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AnomaliaInteSupeVO }
     * 
     * 
     */
    public List<AnomaliaInteSupeVO> getAnomalieInteSupe() {
        if (anomalieInteSupe == null) {
            anomalieInteSupe = new ArrayList<AnomaliaInteSupeVO>();
        }
        return this.anomalieInteSupe;
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
     * Recupera il valore della propriet� idCoordimaneto.
     * 
     */
    public long getIdCoordimaneto() {
        return idCoordimaneto;
    }

    /**
     * Imposta il valore della propriet� idCoordimaneto.
     * 
     */
    public void setIdCoordimaneto(long value) {
        this.idCoordimaneto = value;
    }

    /**
     * Recupera il valore della propriet� idDomaOP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdDomaOP() {
        return idDomaOP;
    }

    /**
     * Imposta il valore della propriet� idDomaOP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdDomaOP(String value) {
        this.idDomaOP = value;
    }

}
