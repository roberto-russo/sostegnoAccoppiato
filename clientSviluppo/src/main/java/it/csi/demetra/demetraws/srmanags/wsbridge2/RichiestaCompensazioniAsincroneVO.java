
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per richiestaCompensazioniAsincroneVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="richiestaCompensazioniAsincroneVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="enteRecupero" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idPagamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="listaSoggetti" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}soggettoCuaaVO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "richiestaCompensazioniAsincroneVO", propOrder = {
    "email",
    "enteRecupero",
    "idPagamento",
    "listaSoggetti"
})
public class RichiestaCompensazioniAsincroneVO {

    protected String email;
    protected int enteRecupero;
    protected String idPagamento;
    @XmlElement(nillable = true)
    protected List<SoggettoCuaaVO> listaSoggetti;

    /**
     * Recupera il valore della propriet� email.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Imposta il valore della propriet� email.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Recupera il valore della propriet� enteRecupero.
     * 
     */
    public int getEnteRecupero() {
        return enteRecupero;
    }

    /**
     * Imposta il valore della propriet� enteRecupero.
     * 
     */
    public void setEnteRecupero(int value) {
        this.enteRecupero = value;
    }

    /**
     * Recupera il valore della propriet� idPagamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdPagamento() {
        return idPagamento;
    }

    /**
     * Imposta il valore della propriet� idPagamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdPagamento(String value) {
        this.idPagamento = value;
    }

    /**
     * Gets the value of the listaSoggetti property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaSoggetti property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaSoggetti().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SoggettoCuaaVO }
     * 
     * 
     */
    public List<SoggettoCuaaVO> getListaSoggetti() {
        if (listaSoggetti == null) {
            listaSoggetti = new ArrayList<SoggettoCuaaVO>();
        }
        return this.listaSoggetti;
    }

}
