
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per wbDatiNotificaPerIdentificativoInputVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbDatiNotificaPerIdentificativoInputVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="identificativoEsterno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="identificativoSian" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="provenienza" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wbDatiNotificaPerIdentificativoInputVO", propOrder = {
    "identificativoEsterno",
    "identificativoSian",
    "provenienza"
})
public class WbDatiNotificaPerIdentificativoInputVO {

    protected String identificativoEsterno;
    protected String identificativoSian;
    protected String provenienza;

    /**
     * Recupera il valore della propriet� identificativoEsterno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificativoEsterno() {
        return identificativoEsterno;
    }

    /**
     * Imposta il valore della propriet� identificativoEsterno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificativoEsterno(String value) {
        this.identificativoEsterno = value;
    }

    /**
     * Recupera il valore della propriet� identificativoSian.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificativoSian() {
        return identificativoSian;
    }

    /**
     * Imposta il valore della propriet� identificativoSian.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificativoSian(String value) {
        this.identificativoSian = value;
    }

    /**
     * Recupera il valore della propriet� provenienza.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvenienza() {
        return provenienza;
    }

    /**
     * Imposta il valore della propriet� provenienza.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvenienza(String value) {
        this.provenienza = value;
    }

}
