
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per richiestaCompensazioniAsincroneRispostaVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="richiestaCompensazioniAsincroneRispostaVO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}responseVO">
 *       &lt;sequence>
 *         &lt;element name="enteRecupero" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idFornitura" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idPagamento" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ticket" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "richiestaCompensazioniAsincroneRispostaVO", propOrder = {
    "enteRecupero",
    "idFornitura",
    "idPagamento",
    "ticket"
})
public class RichiestaCompensazioniAsincroneRispostaVO
    extends ResponseVO
{

    protected int enteRecupero;
    protected int idFornitura;
    protected int idPagamento;
    protected String ticket;

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
     * Recupera il valore della propriet� idFornitura.
     * 
     */
    public int getIdFornitura() {
        return idFornitura;
    }

    /**
     * Imposta il valore della propriet� idFornitura.
     * 
     */
    public void setIdFornitura(int value) {
        this.idFornitura = value;
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

    /**
     * Recupera il valore della propriet� ticket.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicket() {
        return ticket;
    }

    /**
     * Imposta il valore della propriet� ticket.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicket(String value) {
        this.ticket = value;
    }

}
