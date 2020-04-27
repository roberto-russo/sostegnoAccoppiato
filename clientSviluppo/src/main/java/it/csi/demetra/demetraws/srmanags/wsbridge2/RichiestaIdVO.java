
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per richiestaIdVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="richiestaIdVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="returnAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalePartizioni" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "richiestaIdVO", propOrder = {
    "returnAddress",
    "totalePartizioni"
})
public class RichiestaIdVO {

    protected String returnAddress;
    protected BigInteger totalePartizioni;

    /**
     * Recupera il valore della propriet� returnAddress.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnAddress() {
        return returnAddress;
    }

    /**
     * Imposta il valore della propriet� returnAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnAddress(String value) {
        this.returnAddress = value;
    }

    /**
     * Recupera il valore della propriet� totalePartizioni.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalePartizioni() {
        return totalePartizioni;
    }

    /**
     * Imposta il valore della propriet� totalePartizioni.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalePartizioni(BigInteger value) {
        this.totalePartizioni = value;
    }

}
