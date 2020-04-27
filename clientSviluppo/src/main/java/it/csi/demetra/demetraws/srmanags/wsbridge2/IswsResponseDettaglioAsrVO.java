
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per iswsResponseDettaglioAsrVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="iswsResponseDettaglioAsrVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="elencoListaAnomalieAsr" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}iswsListaAnomalieAsrVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="iswsDomaAsrVO" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}iswsDomaAsrVO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "iswsResponseDettaglioAsrVO", propOrder = {
    "elencoListaAnomalieAsr",
    "iswsDomaAsrVO"
})
public class IswsResponseDettaglioAsrVO {

    @XmlElement(nillable = true)
    protected List<IswsListaAnomalieAsrVO> elencoListaAnomalieAsr;
    protected IswsDomaAsrVO iswsDomaAsrVO;

    /**
     * Gets the value of the elencoListaAnomalieAsr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the elencoListaAnomalieAsr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElencoListaAnomalieAsr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IswsListaAnomalieAsrVO }
     * 
     * 
     */
    public List<IswsListaAnomalieAsrVO> getElencoListaAnomalieAsr() {
        if (elencoListaAnomalieAsr == null) {
            elencoListaAnomalieAsr = new ArrayList<IswsListaAnomalieAsrVO>();
        }
        return this.elencoListaAnomalieAsr;
    }

    /**
     * Recupera il valore della propriet� iswsDomaAsrVO.
     * 
     * @return
     *     possible object is
     *     {@link IswsDomaAsrVO }
     *     
     */
    public IswsDomaAsrVO getIswsDomaAsrVO() {
        return iswsDomaAsrVO;
    }

    /**
     * Imposta il valore della propriet� iswsDomaAsrVO.
     * 
     * @param value
     *     allowed object is
     *     {@link IswsDomaAsrVO }
     *     
     */
    public void setIswsDomaAsrVO(IswsDomaAsrVO value) {
        this.iswsDomaAsrVO = value;
    }

}
