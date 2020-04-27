
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per riepilogoFondoRispostaVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="riepilogoFondoRispostaVO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}responseVO">
 *       &lt;sequence>
 *         &lt;element name="fondoPagamento" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="importoPagamento" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="listaFondi" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}fondoVO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "riepilogoFondoRispostaVO", propOrder = {
    "fondoPagamento",
    "importoPagamento",
    "listaFondi"
})
public class RiepilogoFondoRispostaVO
    extends ResponseVO
{

    protected int fondoPagamento;
    protected BigDecimal importoPagamento;
    @XmlElement(nillable = true)
    protected List<FondoVO> listaFondi;

    /**
     * Recupera il valore della propriet� fondoPagamento.
     * 
     */
    public int getFondoPagamento() {
        return fondoPagamento;
    }

    /**
     * Imposta il valore della propriet� fondoPagamento.
     * 
     */
    public void setFondoPagamento(int value) {
        this.fondoPagamento = value;
    }

    /**
     * Recupera il valore della propriet� importoPagamento.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImportoPagamento() {
        return importoPagamento;
    }

    /**
     * Imposta il valore della propriet� importoPagamento.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImportoPagamento(BigDecimal value) {
        this.importoPagamento = value;
    }

    /**
     * Gets the value of the listaFondi property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaFondi property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaFondi().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FondoVO }
     * 
     * 
     */
    public List<FondoVO> getListaFondi() {
        if (listaFondi == null) {
            listaFondi = new ArrayList<FondoVO>();
        }
        return this.listaFondi;
    }

}
