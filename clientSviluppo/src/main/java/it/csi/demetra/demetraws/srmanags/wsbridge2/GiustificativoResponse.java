
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per giustificativoResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="giustificativoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="documentoGiustificativo" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}documentoGiustificativo" minOccurs="0"/>
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
@XmlType(name = "giustificativoResponse", propOrder = {
    "documentoGiustificativo",
    "response"
})
public class GiustificativoResponse {

    protected DocumentoGiustificativo documentoGiustificativo;
    @XmlElement(namespace = "http://it/csi/smranags/wsbridge2/business/wsbridgefacade")
    protected Response response;

    /**
     * Recupera il valore della propriet� documentoGiustificativo.
     * 
     * @return
     *     possible object is
     *     {@link DocumentoGiustificativo }
     *     
     */
    public DocumentoGiustificativo getDocumentoGiustificativo() {
        return documentoGiustificativo;
    }

    /**
     * Imposta il valore della propriet� documentoGiustificativo.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentoGiustificativo }
     *     
     */
    public void setDocumentoGiustificativo(DocumentoGiustificativo value) {
        this.documentoGiustificativo = value;
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
