
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per wbSezioneImportatoriVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbSezioneImportatoriVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codicePaese" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="filiera" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idProgressivoUP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipologiaProdotto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipologiaStruttura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wbSezioneImportatoriVO", propOrder = {
    "codicePaese",
    "filiera",
    "idProgressivoUP",
    "tipologiaProdotto",
    "tipologiaStruttura"
})
public class WbSezioneImportatoriVO {

    protected String codicePaese;
    protected String filiera;
    protected String idProgressivoUP;
    protected String tipologiaProdotto;
    protected String tipologiaStruttura;

    /**
     * Recupera il valore della propriet� codicePaese.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodicePaese() {
        return codicePaese;
    }

    /**
     * Imposta il valore della propriet� codicePaese.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodicePaese(String value) {
        this.codicePaese = value;
    }

    /**
     * Recupera il valore della propriet� filiera.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFiliera() {
        return filiera;
    }

    /**
     * Imposta il valore della propriet� filiera.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFiliera(String value) {
        this.filiera = value;
    }

    /**
     * Recupera il valore della propriet� idProgressivoUP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdProgressivoUP() {
        return idProgressivoUP;
    }

    /**
     * Imposta il valore della propriet� idProgressivoUP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdProgressivoUP(String value) {
        this.idProgressivoUP = value;
    }

    /**
     * Recupera il valore della propriet� tipologiaProdotto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipologiaProdotto() {
        return tipologiaProdotto;
    }

    /**
     * Imposta il valore della propriet� tipologiaProdotto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipologiaProdotto(String value) {
        this.tipologiaProdotto = value;
    }

    /**
     * Recupera il valore della propriet� tipologiaStruttura.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipologiaStruttura() {
        return tipologiaStruttura;
    }

    /**
     * Imposta il valore della propriet� tipologiaStruttura.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipologiaStruttura(String value) {
        this.tipologiaStruttura = value;
    }

}
