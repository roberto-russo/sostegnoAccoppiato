
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per iswsAnomaliePerCuaaVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="iswsAnomaliePerCuaaVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="campagna" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cuaaTypeVO" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}cuaaTypeVO" minOccurs="0"/>
 *         &lt;element name="idDomaOp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="regione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "iswsAnomaliePerCuaaVO", propOrder = {
    "campagna",
    "cuaaTypeVO",
    "idDomaOp",
    "regione"
})
public class IswsAnomaliePerCuaaVO {

    protected Integer campagna;
    protected CuaaTypeVO cuaaTypeVO;
    protected String idDomaOp;
    protected String regione;

    /**
     * Recupera il valore della propriet� campagna.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCampagna() {
        return campagna;
    }

    /**
     * Imposta il valore della propriet� campagna.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCampagna(Integer value) {
        this.campagna = value;
    }

    /**
     * Recupera il valore della propriet� cuaaTypeVO.
     * 
     * @return
     *     possible object is
     *     {@link CuaaTypeVO }
     *     
     */
    public CuaaTypeVO getCuaaTypeVO() {
        return cuaaTypeVO;
    }

    /**
     * Imposta il valore della propriet� cuaaTypeVO.
     * 
     * @param value
     *     allowed object is
     *     {@link CuaaTypeVO }
     *     
     */
    public void setCuaaTypeVO(CuaaTypeVO value) {
        this.cuaaTypeVO = value;
    }

    /**
     * Recupera il valore della propriet� idDomaOp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdDomaOp() {
        return idDomaOp;
    }

    /**
     * Imposta il valore della propriet� idDomaOp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdDomaOp(String value) {
        this.idDomaOp = value;
    }

    /**
     * Recupera il valore della propriet� regione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegione() {
        return regione;
    }

    /**
     * Imposta il valore della propriet� regione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegione(String value) {
        this.regione = value;
    }

}
