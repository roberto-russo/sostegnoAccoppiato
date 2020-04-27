
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per responseForCUAASIANVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="responseForCUAASIANVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cuaa" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dataAggiornamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responseForCUAASIANVO", propOrder = {
    "cuaa",
    "dataAggiornamento"
})
public class ResponseForCUAASIANVO {

    @XmlElement(nillable = true)
    protected List<String> cuaa;
    protected String dataAggiornamento;

    /**
     * Gets the value of the cuaa property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cuaa property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCuaa().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCuaa() {
        if (cuaa == null) {
            cuaa = new ArrayList<String>();
        }
        return this.cuaa;
    }

    /**
     * Recupera il valore della propriet� dataAggiornamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataAggiornamento() {
        return dataAggiornamento;
    }

    /**
     * Imposta il valore della propriet� dataAggiornamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataAggiornamento(String value) {
        this.dataAggiornamento = value;
    }

}
