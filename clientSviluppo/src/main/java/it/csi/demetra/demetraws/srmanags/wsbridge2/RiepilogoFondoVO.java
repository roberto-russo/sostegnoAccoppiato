
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per riepilogoFondoVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="riepilogoFondoVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enteRecupero" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fondoPagamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "riepilogoFondoVO", propOrder = {
    "enteRecupero",
    "fondoPagamento"
})
public class RiepilogoFondoVO {

    protected int enteRecupero;
    protected String fondoPagamento;

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

}
