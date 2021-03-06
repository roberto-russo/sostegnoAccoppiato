
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per disposizioneTipoVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="disposizioneTipoVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="disposizionePagamentoVO" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}disposizionePagamentoVO" minOccurs="0"/>
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
@XmlType(name = "disposizioneTipoVO", propOrder = {
    "disposizionePagamentoVO",
    "utente"
})
public class DisposizioneTipoVO {

    protected DisposizionePagamentoVO disposizionePagamentoVO;
    protected String utente;

    /**
     * Recupera il valore della propriet� disposizionePagamentoVO.
     * 
     * @return
     *     possible object is
     *     {@link DisposizionePagamentoVO }
     *     
     */
    public DisposizionePagamentoVO getDisposizionePagamentoVO() {
        return disposizionePagamentoVO;
    }

    /**
     * Imposta il valore della propriet� disposizionePagamentoVO.
     * 
     * @param value
     *     allowed object is
     *     {@link DisposizionePagamentoVO }
     *     
     */
    public void setDisposizionePagamentoVO(DisposizionePagamentoVO value) {
        this.disposizionePagamentoVO = value;
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
