
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per iswsResponseAnomalieAsrVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="iswsResponseAnomalieAsrVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="elencoResponseDettaglioAsr" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}iswsResponseDettaglioAsrVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="responseVO" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}responseVO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "iswsResponseAnomalieAsrVO", propOrder = {
    "elencoResponseDettaglioAsr",
    "responseVO"
})
public class IswsResponseAnomalieAsrVO {

    @XmlElement(nillable = true)
    protected List<IswsResponseDettaglioAsrVO> elencoResponseDettaglioAsr;
    protected ResponseVO responseVO;

    /**
     * Gets the value of the elencoResponseDettaglioAsr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the elencoResponseDettaglioAsr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElencoResponseDettaglioAsr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IswsResponseDettaglioAsrVO }
     * 
     * 
     */
    public List<IswsResponseDettaglioAsrVO> getElencoResponseDettaglioAsr() {
        if (elencoResponseDettaglioAsr == null) {
            elencoResponseDettaglioAsr = new ArrayList<IswsResponseDettaglioAsrVO>();
        }
        return this.elencoResponseDettaglioAsr;
    }

    /**
     * Recupera il valore della propriet� responseVO.
     * 
     * @return
     *     possible object is
     *     {@link ResponseVO }
     *     
     */
    public ResponseVO getResponseVO() {
        return responseVO;
    }

    /**
     * Imposta il valore della propriet� responseVO.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseVO }
     *     
     */
    public void setResponseVO(ResponseVO value) {
        this.responseVO = value;
    }

}
