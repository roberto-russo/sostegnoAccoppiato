
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per richiestaCompensazioneRispostaVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="richiestaCompensazioneRispostaVO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}responseVO">
 *       &lt;sequence>
 *         &lt;element name="importoCompensatoTotale" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="listaCompensazioni" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}compensazioneVO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "richiestaCompensazioneRispostaVO", propOrder = {
    "importoCompensatoTotale",
    "listaCompensazioni"
})
public class RichiestaCompensazioneRispostaVO
    extends ResponseVO
{

    protected BigDecimal importoCompensatoTotale;
    @XmlElement(nillable = true)
    protected List<CompensazioneVO> listaCompensazioni;

    /**
     * Recupera il valore della propriet� importoCompensatoTotale.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImportoCompensatoTotale() {
        return importoCompensatoTotale;
    }

    /**
     * Imposta il valore della propriet� importoCompensatoTotale.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImportoCompensatoTotale(BigDecimal value) {
        this.importoCompensatoTotale = value;
    }

    /**
     * Gets the value of the listaCompensazioni property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaCompensazioni property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaCompensazioni().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CompensazioneVO }
     * 
     * 
     */
    public List<CompensazioneVO> getListaCompensazioni() {
        if (listaCompensazioni == null) {
            listaCompensazioni = new ArrayList<CompensazioneVO>();
        }
        return this.listaCompensazioni;
    }

}
