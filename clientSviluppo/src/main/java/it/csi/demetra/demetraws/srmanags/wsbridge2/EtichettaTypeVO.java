
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per etichettaTypeVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="etichettaTypeVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="identificativoInvio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partizione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "etichettaTypeVO", propOrder = {
    "identificativoInvio",
    "partizione"
})
public class EtichettaTypeVO {

    protected String identificativoInvio;
    protected String partizione;

    /**
     * Recupera il valore della propriet� identificativoInvio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificativoInvio() {
        return identificativoInvio;
    }

    /**
     * Imposta il valore della propriet� identificativoInvio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificativoInvio(String value) {
        this.identificativoInvio = value;
    }

    /**
     * Recupera il valore della propriet� partizione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartizione() {
        return partizione;
    }

    /**
     * Imposta il valore della propriet� partizione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartizione(String value) {
        this.partizione = value;
    }

}
