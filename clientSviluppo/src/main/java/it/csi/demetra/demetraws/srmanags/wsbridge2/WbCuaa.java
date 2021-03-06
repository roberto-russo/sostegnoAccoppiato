
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per wbCuaa complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbCuaa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codiceFiscalePersonaFisica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceFiscalePersonaGiuridica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wbCuaa", propOrder = {
    "codiceFiscalePersonaFisica",
    "codiceFiscalePersonaGiuridica"
})
public class WbCuaa {

    protected String codiceFiscalePersonaFisica;
    protected String codiceFiscalePersonaGiuridica;

    /**
     * Recupera il valore della propriet� codiceFiscalePersonaFisica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceFiscalePersonaFisica() {
        return codiceFiscalePersonaFisica;
    }

    /**
     * Imposta il valore della propriet� codiceFiscalePersonaFisica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceFiscalePersonaFisica(String value) {
        this.codiceFiscalePersonaFisica = value;
    }

    /**
     * Recupera il valore della propriet� codiceFiscalePersonaGiuridica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceFiscalePersonaGiuridica() {
        return codiceFiscalePersonaGiuridica;
    }

    /**
     * Imposta il valore della propriet� codiceFiscalePersonaGiuridica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceFiscalePersonaGiuridica(String value) {
        this.codiceFiscalePersonaGiuridica = value;
    }

}
