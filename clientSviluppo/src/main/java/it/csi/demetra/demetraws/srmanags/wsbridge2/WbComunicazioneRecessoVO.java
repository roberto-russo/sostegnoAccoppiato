
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per wbComunicazioneRecessoVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbComunicazioneRecessoVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="recessoVO" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbRecessoVO" minOccurs="0"/>
 *         &lt;element name="tipoOperazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wbComunicazioneRecessoVO", propOrder = {
    "recessoVO",
    "tipoOperazione"
})
public class WbComunicazioneRecessoVO {

    protected WbRecessoVO recessoVO;
    protected String tipoOperazione;

    /**
     * Recupera il valore della propriet� recessoVO.
     * 
     * @return
     *     possible object is
     *     {@link WbRecessoVO }
     *     
     */
    public WbRecessoVO getRecessoVO() {
        return recessoVO;
    }

    /**
     * Imposta il valore della propriet� recessoVO.
     * 
     * @param value
     *     allowed object is
     *     {@link WbRecessoVO }
     *     
     */
    public void setRecessoVO(WbRecessoVO value) {
        this.recessoVO = value;
    }

    /**
     * Recupera il valore della propriet� tipoOperazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoOperazione() {
        return tipoOperazione;
    }

    /**
     * Imposta il valore della propriet� tipoOperazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoOperazione(String value) {
        this.tipoOperazione = value;
    }

}
