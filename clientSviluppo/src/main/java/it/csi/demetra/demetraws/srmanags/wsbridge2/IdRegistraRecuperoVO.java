
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per idRegistraRecuperoVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="idRegistraRecuperoVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="richiestaIdVO" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}richiestaIdVO" minOccurs="0"/>
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
@XmlType(name = "idRegistraRecuperoVO", propOrder = {
    "richiestaIdVO",
    "utente"
})
public class IdRegistraRecuperoVO {

    protected RichiestaIdVO richiestaIdVO;
    protected String utente;

    /**
     * Recupera il valore della propriet� richiestaIdVO.
     * 
     * @return
     *     possible object is
     *     {@link RichiestaIdVO }
     *     
     */
    public RichiestaIdVO getRichiestaIdVO() {
        return richiestaIdVO;
    }

    /**
     * Imposta il valore della propriet� richiestaIdVO.
     * 
     * @param value
     *     allowed object is
     *     {@link RichiestaIdVO }
     *     
     */
    public void setRichiestaIdVO(RichiestaIdVO value) {
        this.richiestaIdVO = value;
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
