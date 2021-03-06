
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per wbConsultazioneDocumentoGiustificativoVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbConsultazioneDocumentoGiustificativoVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="inputSIBIdNotifica" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbInputSIBIdNotificaVO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wbConsultazioneDocumentoGiustificativoVO", propOrder = {
    "inputSIBIdNotifica"
})
public class WbConsultazioneDocumentoGiustificativoVO {

    protected WbInputSIBIdNotificaVO inputSIBIdNotifica;

    /**
     * Recupera il valore della propriet� inputSIBIdNotifica.
     * 
     * @return
     *     possible object is
     *     {@link WbInputSIBIdNotificaVO }
     *     
     */
    public WbInputSIBIdNotificaVO getInputSIBIdNotifica() {
        return inputSIBIdNotifica;
    }

    /**
     * Imposta il valore della propriet� inputSIBIdNotifica.
     * 
     * @param value
     *     allowed object is
     *     {@link WbInputSIBIdNotificaVO }
     *     
     */
    public void setInputSIBIdNotifica(WbInputSIBIdNotificaVO value) {
        this.inputSIBIdNotifica = value;
    }

}
