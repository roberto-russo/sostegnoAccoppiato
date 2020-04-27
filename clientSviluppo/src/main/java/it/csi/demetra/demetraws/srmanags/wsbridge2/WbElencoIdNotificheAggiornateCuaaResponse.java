
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per wbElencoIdNotificheAggiornateCuaaResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbElencoIdNotificheAggiornateCuaaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="esito" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbIdNotificheCuaaVO" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "wbElencoIdNotificheAggiornateCuaaResponse", propOrder = {
    "esito",
    "response"
})
public class WbElencoIdNotificheAggiornateCuaaResponse {

    @XmlElement(nillable = true)
    protected List<WbIdNotificheCuaaVO> esito;
    @XmlElement(namespace = "http://it/csi/smranags/wsbridge2/business/wsbridgefacade")
    protected Response response;

    /**
     * Gets the value of the esito property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the esito property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEsito().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WbIdNotificheCuaaVO }
     * 
     * 
     */
    public List<WbIdNotificheCuaaVO> getEsito() {
        if (esito == null) {
            esito = new ArrayList<WbIdNotificheCuaaVO>();
        }
        return this.esito;
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
