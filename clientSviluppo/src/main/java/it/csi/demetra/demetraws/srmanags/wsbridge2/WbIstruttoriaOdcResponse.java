
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per wbIstruttoriaOdcResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbIstruttoriaOdcResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="esito" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbConsultazioneEsitoIstruttoriaOdc" minOccurs="0"/>
 *         &lt;element ref="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}response" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wbIstruttoriaOdcResponse", propOrder = {
    "esito",
    "response"
})
public class WbIstruttoriaOdcResponse {

    protected WbConsultazioneEsitoIstruttoriaOdc esito;
    @XmlElement(namespace = "http://it/csi/smranags/wsbridge2/business/wsbridgefacade")
    protected Response response;

    /**
     * Recupera il valore della propriet� esito.
     * 
     * @return
     *     possible object is
     *     {@link WbConsultazioneEsitoIstruttoriaOdc }
     *     
     */
    public WbConsultazioneEsitoIstruttoriaOdc getEsito() {
        return esito;
    }

    /**
     * Imposta il valore della propriet� esito.
     * 
     * @param value
     *     allowed object is
     *     {@link WbConsultazioneEsitoIstruttoriaOdc }
     *     
     */
    public void setEsito(WbConsultazioneEsitoIstruttoriaOdc value) {
        this.esito = value;
    }

    /**
     * Recupera il valore della propriet� response.
     * 
     * @return
     *     possible object is
     *     {@link Response }
     *     
     */
    public Response getResponse() {
        return response;
    }

    /**
     * Imposta il valore della propriet� response.
     * 
     * @param value
     *     allowed object is
     *     {@link Response }
     *     
     */
    public void setResponse(Response value) {
        this.response = value;
    }

}
