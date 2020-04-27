
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per wbIterAmministrativoVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbIterAmministrativoVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="identificativoSian" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vProtocolliEsterni" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbProtEsternoNotificaVO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wbIterAmministrativoVO", propOrder = {
    "identificativoSian",
    "vProtocolliEsterni"
})
public class WbIterAmministrativoVO {

    protected String identificativoSian;
    @XmlElement(nillable = true)
    protected List<WbProtEsternoNotificaVO> vProtocolliEsterni;

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
     * Gets the value of the vProtocolliEsterni property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vProtocolliEsterni property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVProtocolliEsterni().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WbProtEsternoNotificaVO }
     * 
     * 
     */
    public List<WbProtEsternoNotificaVO> getVProtocolliEsterni() {
        if (vProtocolliEsterni == null) {
            vProtocolliEsterni = new ArrayList<WbProtEsternoNotificaVO>();
        }
        return this.vProtocolliEsterni;
    }

}
