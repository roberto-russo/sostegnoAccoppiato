
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per wbQuoteLatte complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbQuoteLatte">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="campagnaLattiera" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="causaForzaMaggiore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceComunicazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cuaa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataUltimoAggiornamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="quotaConsegneDaPiano" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="quotaConsegneDis" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="quotaConsegneRif" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="quotaConsegneSoggetteVincolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="quotaVenditeDaPiano" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="quotaVenditeDiretteDis" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="quotaVenditeDiretteRif" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="quotaVenditeSoggettoVincolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tenoreGrassoDis" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tenoreGrassoRif" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoVincoloSoggettoVincolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ute" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wbQuoteLatte", propOrder = {
    "campagnaLattiera",
    "causaForzaMaggiore",
    "codiceComunicazione",
    "cuaa",
    "dataUltimoAggiornamento",
    "quotaConsegneDaPiano",
    "quotaConsegneDis",
    "quotaConsegneRif",
    "quotaConsegneSoggetteVincolo",
    "quotaVenditeDaPiano",
    "quotaVenditeDiretteDis",
    "quotaVenditeDiretteRif",
    "quotaVenditeSoggettoVincolo",
    "tenoreGrassoDis",
    "tenoreGrassoRif",
    "tipoVincoloSoggettoVincolo",
    "ute"
})
public class WbQuoteLatte {

    protected String campagnaLattiera;
    protected String causaForzaMaggiore;
    protected String codiceComunicazione;
    protected String cuaa;
    protected String dataUltimoAggiornamento;
    protected String quotaConsegneDaPiano;
    protected String quotaConsegneDis;
    protected String quotaConsegneRif;
    protected String quotaConsegneSoggetteVincolo;
    protected String quotaVenditeDaPiano;
    protected String quotaVenditeDiretteDis;
    protected String quotaVenditeDiretteRif;
    protected String quotaVenditeSoggettoVincolo;
    protected String tenoreGrassoDis;
    protected String tenoreGrassoRif;
    protected String tipoVincoloSoggettoVincolo;
    protected String ute;

    /**
     * Recupera il valore della propriet� campagnaLattiera.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampagnaLattiera() {
        return campagnaLattiera;
    }

    /**
     * Imposta il valore della propriet� campagnaLattiera.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampagnaLattiera(String value) {
        this.campagnaLattiera = value;
    }

    /**
     * Recupera il valore della propriet� causaForzaMaggiore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCausaForzaMaggiore() {
        return causaForzaMaggiore;
    }

    /**
     * Imposta il valore della propriet� causaForzaMaggiore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCausaForzaMaggiore(String value) {
        this.causaForzaMaggiore = value;
    }

    /**
     * Recupera il valore della propriet� codiceComunicazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceComunicazione() {
        return codiceComunicazione;
    }

    /**
     * Imposta il valore della propriet� codiceComunicazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceComunicazione(String value) {
        this.codiceComunicazione = value;
    }

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
     * Recupera il valore della propriet� dataUltimoAggiornamento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataUltimoAggiornamento() {
        return dataUltimoAggiornamento;
    }

    /**
     * Imposta il valore della propriet� dataUltimoAggiornamento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataUltimoAggiornamento(String value) {
        this.dataUltimoAggiornamento = value;
    }

    /**
     * Recupera il valore della propriet� quotaConsegneDaPiano.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuotaConsegneDaPiano() {
        return quotaConsegneDaPiano;
    }

    /**
     * Imposta il valore della propriet� quotaConsegneDaPiano.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuotaConsegneDaPiano(String value) {
        this.quotaConsegneDaPiano = value;
    }

    /**
     * Recupera il valore della propriet� quotaConsegneDis.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuotaConsegneDis() {
        return quotaConsegneDis;
    }

    /**
     * Imposta il valore della propriet� quotaConsegneDis.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuotaConsegneDis(String value) {
        this.quotaConsegneDis = value;
    }

    /**
     * Recupera il valore della propriet� quotaConsegneRif.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuotaConsegneRif() {
        return quotaConsegneRif;
    }

    /**
     * Imposta il valore della propriet� quotaConsegneRif.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuotaConsegneRif(String value) {
        this.quotaConsegneRif = value;
    }

    /**
     * Recupera il valore della propriet� quotaConsegneSoggetteVincolo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuotaConsegneSoggetteVincolo() {
        return quotaConsegneSoggetteVincolo;
    }

    /**
     * Imposta il valore della propriet� quotaConsegneSoggetteVincolo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuotaConsegneSoggetteVincolo(String value) {
        this.quotaConsegneSoggetteVincolo = value;
    }

    /**
     * Recupera il valore della propriet� quotaVenditeDaPiano.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuotaVenditeDaPiano() {
        return quotaVenditeDaPiano;
    }

    /**
     * Imposta il valore della propriet� quotaVenditeDaPiano.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuotaVenditeDaPiano(String value) {
        this.quotaVenditeDaPiano = value;
    }

    /**
     * Recupera il valore della propriet� quotaVenditeDiretteDis.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuotaVenditeDiretteDis() {
        return quotaVenditeDiretteDis;
    }

    /**
     * Imposta il valore della propriet� quotaVenditeDiretteDis.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuotaVenditeDiretteDis(String value) {
        this.quotaVenditeDiretteDis = value;
    }

    /**
     * Recupera il valore della propriet� quotaVenditeDiretteRif.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuotaVenditeDiretteRif() {
        return quotaVenditeDiretteRif;
    }

    /**
     * Imposta il valore della propriet� quotaVenditeDiretteRif.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuotaVenditeDiretteRif(String value) {
        this.quotaVenditeDiretteRif = value;
    }

    /**
     * Recupera il valore della propriet� quotaVenditeSoggettoVincolo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuotaVenditeSoggettoVincolo() {
        return quotaVenditeSoggettoVincolo;
    }

    /**
     * Imposta il valore della propriet� quotaVenditeSoggettoVincolo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuotaVenditeSoggettoVincolo(String value) {
        this.quotaVenditeSoggettoVincolo = value;
    }

    /**
     * Recupera il valore della propriet� tenoreGrassoDis.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTenoreGrassoDis() {
        return tenoreGrassoDis;
    }

    /**
     * Imposta il valore della propriet� tenoreGrassoDis.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTenoreGrassoDis(String value) {
        this.tenoreGrassoDis = value;
    }

    /**
     * Recupera il valore della propriet� tenoreGrassoRif.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTenoreGrassoRif() {
        return tenoreGrassoRif;
    }

    /**
     * Imposta il valore della propriet� tenoreGrassoRif.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTenoreGrassoRif(String value) {
        this.tenoreGrassoRif = value;
    }

    /**
     * Recupera il valore della propriet� tipoVincoloSoggettoVincolo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoVincoloSoggettoVincolo() {
        return tipoVincoloSoggettoVincolo;
    }

    /**
     * Imposta il valore della propriet� tipoVincoloSoggettoVincolo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoVincoloSoggettoVincolo(String value) {
        this.tipoVincoloSoggettoVincolo = value;
    }

    /**
     * Recupera il valore della propriet� ute.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUte() {
        return ute;
    }

    /**
     * Imposta il valore della propriet� ute.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUte(String value) {
        this.ute = value;
    }

}
