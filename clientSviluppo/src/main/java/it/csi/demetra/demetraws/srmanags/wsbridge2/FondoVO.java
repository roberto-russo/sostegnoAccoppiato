
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per fondoVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="fondoVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fondoPagamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="importoCompensazione" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fondoVO", propOrder = {
    "fondoPagamento",
    "importoCompensazione"
})
public class FondoVO {

    protected String fondoPagamento;
    protected BigDecimal importoCompensazione;

    /**
     * Recupera il valore della propriet� fondoPagamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFondoPagamento() {
        return fondoPagamento;
    }

    /**
     * Imposta il valore della propriet� fondoPagamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFondoPagamento(String value) {
        this.fondoPagamento = value;
    }

    /**
     * Recupera il valore della propriet� importoCompensazione.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImportoCompensazione() {
        return importoCompensazione;
    }

    /**
     * Imposta il valore della propriet� importoCompensazione.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImportoCompensazione(BigDecimal value) {
        this.importoCompensazione = value;
    }

}
