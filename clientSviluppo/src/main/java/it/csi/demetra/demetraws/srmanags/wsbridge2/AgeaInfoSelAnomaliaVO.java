
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per ageaInfoSelAnomaliaVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ageaInfoSelAnomaliaVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cuaaInfoSelAnomaliaVO" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}cuaaInfoSelAnomaliaVO" minOccurs="0"/>
 *         &lt;element name="responseAnomVO" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}responseAnomVO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ageaInfoSelAnomaliaVO", propOrder = {
    "cuaaInfoSelAnomaliaVO",
    "responseAnomVO"
})
public class AgeaInfoSelAnomaliaVO {

    protected CuaaInfoSelAnomaliaVO cuaaInfoSelAnomaliaVO;
    protected ResponseAnomVO responseAnomVO;

    /**
     * Recupera il valore della propriet� cuaaInfoSelAnomaliaVO.
     * 
     * @return
     *     possible object is
     *     {@link CuaaInfoSelAnomaliaVO }
     *     
     */
    public CuaaInfoSelAnomaliaVO getCuaaInfoSelAnomaliaVO() {
        return cuaaInfoSelAnomaliaVO;
    }

    /**
     * Imposta il valore della propriet� cuaaInfoSelAnomaliaVO.
     * 
     * @param value
     *     allowed object is
     *     {@link CuaaInfoSelAnomaliaVO }
     *     
     */
    public void setCuaaInfoSelAnomaliaVO(CuaaInfoSelAnomaliaVO value) {
        this.cuaaInfoSelAnomaliaVO = value;
    }

    /**
     * Recupera il valore della propriet� responseAnomVO.
     * 
     * @return
     *     possible object is
     *     {@link ResponseAnomVO }
     *     
     */
    public ResponseAnomVO getResponseAnomVO() {
        return responseAnomVO;
    }

    /**
     * Imposta il valore della propriet� responseAnomVO.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseAnomVO }
     *     
     */
    public void setResponseAnomVO(ResponseAnomVO value) {
        this.responseAnomVO = value;
    }

}
