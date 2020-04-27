
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per wbSezionePreparazioneVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbSezionePreparazioneVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="attivitaContoTerzi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descFiliera" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descTipologiaAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="filiera" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idProgressivoUP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lavorazioneProdotto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="origineMateriaPrima" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="separazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipologiaAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wbSezionePreparazioneVO", propOrder = {
    "attivitaContoTerzi",
    "descFiliera",
    "descTipologiaAttivita",
    "filiera",
    "idProgressivoUP",
    "lavorazioneProdotto",
    "origineMateriaPrima",
    "separazione",
    "tipologiaAttivita"
})
public class WbSezionePreparazioneVO {

    protected String attivitaContoTerzi;
    protected String descFiliera;
    protected String descTipologiaAttivita;
    protected String filiera;
    protected String idProgressivoUP;
    protected String lavorazioneProdotto;
    protected String origineMateriaPrima;
    protected String separazione;
    protected String tipologiaAttivita;

    /**
     * Recupera il valore della propriet� attivitaContoTerzi.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttivitaContoTerzi() {
        return attivitaContoTerzi;
    }

    /**
     * Imposta il valore della propriet� attivitaContoTerzi.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttivitaContoTerzi(String value) {
        this.attivitaContoTerzi = value;
    }

    /**
     * Recupera il valore della propriet� descFiliera.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescFiliera() {
        return descFiliera;
    }

    /**
     * Imposta il valore della propriet� descFiliera.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescFiliera(String value) {
        this.descFiliera = value;
    }

    /**
     * Recupera il valore della propriet� descTipologiaAttivita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescTipologiaAttivita() {
        return descTipologiaAttivita;
    }

    /**
     * Imposta il valore della propriet� descTipologiaAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescTipologiaAttivita(String value) {
        this.descTipologiaAttivita = value;
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
     * Recupera il valore della propriet� lavorazioneProdotto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLavorazioneProdotto() {
        return lavorazioneProdotto;
    }

    /**
     * Imposta il valore della propriet� lavorazioneProdotto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLavorazioneProdotto(String value) {
        this.lavorazioneProdotto = value;
    }

    /**
     * Recupera il valore della propriet� origineMateriaPrima.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigineMateriaPrima() {
        return origineMateriaPrima;
    }

    /**
     * Imposta il valore della propriet� origineMateriaPrima.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigineMateriaPrima(String value) {
        this.origineMateriaPrima = value;
    }

    /**
     * Recupera il valore della propriet� separazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeparazione() {
        return separazione;
    }

    /**
     * Imposta il valore della propriet� separazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeparazione(String value) {
        this.separazione = value;
    }

    /**
     * Recupera il valore della propriet� tipologiaAttivita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipologiaAttivita() {
        return tipologiaAttivita;
    }

    /**
     * Imposta il valore della propriet� tipologiaAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipologiaAttivita(String value) {
        this.tipologiaAttivita = value;
    }

}
