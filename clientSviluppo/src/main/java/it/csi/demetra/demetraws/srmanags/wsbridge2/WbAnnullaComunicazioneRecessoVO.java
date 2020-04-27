
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per wbAnnullaComunicazioneRecessoVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbAnnullaComunicazioneRecessoVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="annullamentoVO" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbAnnullamentoVO" minOccurs="0"/>
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
@XmlType(name = "wbAnnullaComunicazioneRecessoVO", propOrder = {
    "annullamentoVO",
    "tipoOperazione"
})
public class WbAnnullaComunicazioneRecessoVO {

    protected WbAnnullamentoVO annullamentoVO;
    protected String tipoOperazione;

    /**
     * Recupera il valore della propriet� annullamentoVO.
     * 
     * @return
     *     possible object is
     *     {@link WbAnnullamentoVO }
     *     
     */
    public WbAnnullamentoVO getAnnullamentoVO() {
        return annullamentoVO;
    }

    /**
     * Imposta il valore della propriet� annullamentoVO.
     * 
     * @param value
     *     allowed object is
     *     {@link WbAnnullamentoVO }
     *     
     */
    public void setAnnullamentoVO(WbAnnullamentoVO value) {
        this.annullamentoVO = value;
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
