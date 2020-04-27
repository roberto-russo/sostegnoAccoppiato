
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per wbRifGeogImpiantiAcqueVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbRifGeogImpiantiAcqueVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="coordLat1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="coordLat2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="coordLat3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="coordLat4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="coordLong1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="coordLong2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="coordLong3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="coordLong4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="superficie" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wbRifGeogImpiantiAcqueVO", propOrder = {
    "coordLat1",
    "coordLat2",
    "coordLat3",
    "coordLat4",
    "coordLong1",
    "coordLong2",
    "coordLong3",
    "coordLong4",
    "superficie"
})
public class WbRifGeogImpiantiAcqueVO {

    protected String coordLat1;
    protected String coordLat2;
    protected String coordLat3;
    protected String coordLat4;
    protected String coordLong1;
    protected String coordLong2;
    protected String coordLong3;
    protected String coordLong4;
    protected String superficie;

    /**
     * Recupera il valore della propriet� coordLat1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoordLat1() {
        return coordLat1;
    }

    /**
     * Imposta il valore della propriet� coordLat1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoordLat1(String value) {
        this.coordLat1 = value;
    }

    /**
     * Recupera il valore della propriet� coordLat2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoordLat2() {
        return coordLat2;
    }

    /**
     * Imposta il valore della propriet� coordLat2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoordLat2(String value) {
        this.coordLat2 = value;
    }

    /**
     * Recupera il valore della propriet� coordLat3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoordLat3() {
        return coordLat3;
    }

    /**
     * Imposta il valore della propriet� coordLat3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoordLat3(String value) {
        this.coordLat3 = value;
    }

    /**
     * Recupera il valore della propriet� coordLat4.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoordLat4() {
        return coordLat4;
    }

    /**
     * Imposta il valore della propriet� coordLat4.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoordLat4(String value) {
        this.coordLat4 = value;
    }

    /**
     * Recupera il valore della propriet� coordLong1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoordLong1() {
        return coordLong1;
    }

    /**
     * Imposta il valore della propriet� coordLong1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoordLong1(String value) {
        this.coordLong1 = value;
    }

    /**
     * Recupera il valore della propriet� coordLong2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoordLong2() {
        return coordLong2;
    }

    /**
     * Imposta il valore della propriet� coordLong2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoordLong2(String value) {
        this.coordLong2 = value;
    }

    /**
     * Recupera il valore della propriet� coordLong3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoordLong3() {
        return coordLong3;
    }

    /**
     * Imposta il valore della propriet� coordLong3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoordLong3(String value) {
        this.coordLong3 = value;
    }

    /**
     * Recupera il valore della propriet� coordLong4.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoordLong4() {
        return coordLong4;
    }

    /**
     * Imposta il valore della propriet� coordLong4.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoordLong4(String value) {
        this.coordLong4 = value;
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

}
