
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per annullamentoCompensazioneVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="annullamentoCompensazioneVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cuaa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="enteRecupero" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idPagamento" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "annullamentoCompensazioneVO", propOrder = {
    "cuaa",
    "enteRecupero",
    "idPagamento"
})
public class AnnullamentoCompensazioneVO {

    protected String cuaa;
    protected int enteRecupero;
    protected int idPagamento;

    /**
     * Recupera il valore della propriet� cuaa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCuaa() {
        return cuaa;
    }

    /**
     * Imposta il valore della propriet� cuaa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCuaa(String value) {
        this.cuaa = value;
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
     */
    public int getIdPagamento() {
        return idPagamento;
    }

    /**
     * Imposta il valore della propriet� idPagamento.
     * 
     */
    public void setIdPagamento(int value) {
        this.idPagamento = value;
    }

}
