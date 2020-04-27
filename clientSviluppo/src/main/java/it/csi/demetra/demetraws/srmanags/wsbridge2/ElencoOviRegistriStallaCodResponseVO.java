
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per elencoOviRegistriStallaCodResponseVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="elencoOviRegistriStallaCodResponseVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="elencoOVIRegistriStallaCodResultVO" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}elencoOviRegistriStallaCodResultVO" minOccurs="0"/>
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
@XmlType(name = "elencoOviRegistriStallaCodResponseVO", propOrder = {
    "elencoOVIRegistriStallaCodResultVO",
    "segnalazioneVO"
})
public class ElencoOviRegistriStallaCodResponseVO {

    protected ElencoOviRegistriStallaCodResultVO elencoOVIRegistriStallaCodResultVO;
    protected SegnalazioneVO segnalazioneVO;

    /**
     * Recupera il valore della propriet� elencoOVIRegistriStallaCodResultVO.
     * 
     * @return
     *     possible object is
     *     {@link ElencoOviRegistriStallaCodResultVO }
     *     
     */
    public ElencoOviRegistriStallaCodResultVO getElencoOVIRegistriStallaCodResultVO() {
        return elencoOVIRegistriStallaCodResultVO;
    }

    /**
     * Imposta il valore della propriet� elencoOVIRegistriStallaCodResultVO.
     * 
     * @param value
     *     allowed object is
     *     {@link ElencoOviRegistriStallaCodResultVO }
     *     
     */
    public void setElencoOVIRegistriStallaCodResultVO(ElencoOviRegistriStallaCodResultVO value) {
        this.elencoOVIRegistriStallaCodResultVO = value;
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
