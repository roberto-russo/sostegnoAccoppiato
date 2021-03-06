
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per richiestaRegistraRecuperoInputVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="richiestaRegistraRecuperoInputVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="elencoDatiPagamentoType" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}datiPagamentoTypeVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="etichettaTypeVO" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}etichettaTypeVO" minOccurs="0"/>
 *         &lt;element name="returnAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="utente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "richiestaRegistraRecuperoInputVO", propOrder = {
    "elencoDatiPagamentoType",
    "etichettaTypeVO",
    "returnAddress",
    "utente"
})
public class RichiestaRegistraRecuperoInputVO {

    @XmlElement(nillable = true)
    protected List<DatiPagamentoTypeVO> elencoDatiPagamentoType;
    protected EtichettaTypeVO etichettaTypeVO;
    protected String returnAddress;
    protected String utente;

    /**
     * Gets the value of the elencoDatiPagamentoType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the elencoDatiPagamentoType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElencoDatiPagamentoType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DatiPagamentoTypeVO }
     * 
     * 
     */
    public List<DatiPagamentoTypeVO> getElencoDatiPagamentoType() {
        if (elencoDatiPagamentoType == null) {
            elencoDatiPagamentoType = new ArrayList<DatiPagamentoTypeVO>();
        }
        return this.elencoDatiPagamentoType;
    }

    /**
     * Recupera il valore della propriet� etichettaTypeVO.
     * 
     * @return
     *     possible object is
     *     {@link EtichettaTypeVO }
     *     
     */
    public EtichettaTypeVO getEtichettaTypeVO() {
        return etichettaTypeVO;
    }

    /**
     * Imposta il valore della propriet� etichettaTypeVO.
     * 
     * @param value
     *     allowed object is
     *     {@link EtichettaTypeVO }
     *     
     */
    public void setEtichettaTypeVO(EtichettaTypeVO value) {
        this.etichettaTypeVO = value;
    }

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
     * Recupera il valore della propriet� utente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUtente() {
        return utente;
    }

    /**
     * Imposta il valore della propriet� utente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUtente(String value) {
        this.utente = value;
    }

}
