
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per elencoRegistriStallaCodResponseVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="elencoRegistriStallaCodResponseVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="elencoRegistriStallaCodResultVO" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}elencoRegistriStallaCodResultVO" minOccurs="0"/>
 *         &lt;element name="segnalazioneVO" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}segnalazioneVO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "elencoRegistriStallaCodResponseVO", propOrder = {
    "elencoRegistriStallaCodResultVO",
    "segnalazioneVO"
})
public class ElencoRegistriStallaCodResponseVO {

    protected ElencoRegistriStallaCodResultVO elencoRegistriStallaCodResultVO;
    protected SegnalazioneVO segnalazioneVO;

    /**
     * Recupera il valore della propriet� elencoRegistriStallaCodResultVO.
     * 
     * @return
     *     possible object is
     *     {@link ElencoRegistriStallaCodResultVO }
     *     
     */
    public ElencoRegistriStallaCodResultVO getElencoRegistriStallaCodResultVO() {
        return elencoRegistriStallaCodResultVO;
    }

    /**
     * Imposta il valore della propriet� elencoRegistriStallaCodResultVO.
     * 
     * @param value
     *     allowed object is
     *     {@link ElencoRegistriStallaCodResultVO }
     *     
     */
    public void setElencoRegistriStallaCodResultVO(ElencoRegistriStallaCodResultVO value) {
        this.elencoRegistriStallaCodResultVO = value;
    }

    /**
     * Recupera il valore della propriet� segnalazioneVO.
     * 
     * @return
     *     possible object is
     *     {@link SegnalazioneVO }
     *     
     */
    public SegnalazioneVO getSegnalazioneVO() {
        return segnalazioneVO;
    }

    /**
     * Imposta il valore della propriet� segnalazioneVO.
     * 
     * @param value
     *     allowed object is
     *     {@link SegnalazioneVO }
     *     
     */
    public void setSegnalazioneVO(SegnalazioneVO value) {
        this.segnalazioneVO = value;
    }

}
