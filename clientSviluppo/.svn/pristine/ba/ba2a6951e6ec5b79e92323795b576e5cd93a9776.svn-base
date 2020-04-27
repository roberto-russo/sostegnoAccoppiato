
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per elencoRecuperiResponseVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="elencoRecuperiResponseVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="elencoDatiRecuperoType" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}datiRecuperoTypeVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="etichettaTypeVO" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}etichettaTypeVO" minOccurs="0"/>
 *         &lt;element name="responseVO" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}responseVO" minOccurs="0"/>
 *         &lt;element name="tipologiaRecupero" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "elencoRecuperiResponseVO", propOrder = {
    "elencoDatiRecuperoType",
    "etichettaTypeVO",
    "responseVO",
    "tipologiaRecupero"
})
public class ElencoRecuperiResponseVO {

    @XmlElement(nillable = true)
    protected List<DatiRecuperoTypeVO> elencoDatiRecuperoType;
    protected EtichettaTypeVO etichettaTypeVO;
    protected ResponseVO responseVO;
    protected int tipologiaRecupero;

    /**
     * Gets the value of the elencoDatiRecuperoType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the elencoDatiRecuperoType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElencoDatiRecuperoType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DatiRecuperoTypeVO }
     * 
     * 
     */
    public List<DatiRecuperoTypeVO> getElencoDatiRecuperoType() {
        if (elencoDatiRecuperoType == null) {
            elencoDatiRecuperoType = new ArrayList<DatiRecuperoTypeVO>();
        }
        return this.elencoDatiRecuperoType;
    }

    /**
     * Recupera il valore della propriet� etichettaTypeVO.
     * 
     * @return
     *     possible object is
     *     {@link EtichettaTypeVO }
     *     
     */
    public EtichettaTypeVO getEtichettaTypeVO() {
        return etichettaTypeVO;
    }

    /**
     * Imposta il valore della propriet� etichettaTypeVO.
     * 
     * @param value
     *     allowed object is
     *     {@link EtichettaTypeVO }
     *     
     */
    public void setEtichettaTypeVO(EtichettaTypeVO value) {
        this.etichettaTypeVO = value;
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

    /**
     * Recupera il valore della propriet� tipologiaRecupero.
     * 
     */
    public int getTipologiaRecupero() {
        return tipologiaRecupero;
    }

    /**
     * Imposta il valore della propriet� tipologiaRecupero.
     * 
     */
    public void setTipologiaRecupero(int value) {
        this.tipologiaRecupero = value;
    }

}
