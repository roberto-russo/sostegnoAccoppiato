
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per anomaliaInteSupeVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="anomaliaInteSupeVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codiIntervento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiIstatComune" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiIstatProvincia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiProdotto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiVarieta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataFineVal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataInizioVal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="foglioCatastale" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idComunicazioneSupe" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="numeroParticella" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sezCensuaria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subalterno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="supeColt" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="supeUtil" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="tipoAnomalia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="valoAnomalia" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "anomaliaInteSupeVO", propOrder = {
    "codiIntervento",
    "codiIstatComune",
    "codiIstatProvincia",
    "codiProdotto",
    "codiVarieta",
    "dataFineVal",
    "dataInizioVal",
    "foglioCatastale",
    "idComunicazioneSupe",
    "numeroParticella",
    "sezCensuaria",
    "subalterno",
    "supeColt",
    "supeUtil",
    "tipoAnomalia",
    "valoAnomalia"
})
public class AnomaliaInteSupeVO {

    protected String codiIntervento;
    protected String codiIstatComune;
    protected String codiIstatProvincia;
    protected String codiProdotto;
    protected String codiVarieta;
    protected String dataFineVal;
    protected String dataInizioVal;
    protected int foglioCatastale;
    protected long idComunicazioneSupe;
    protected String numeroParticella;
    protected String sezCensuaria;
    protected String subalterno;
    protected long supeColt;
    protected long supeUtil;
    protected String tipoAnomalia;
    protected int valoAnomalia;

    /**
     * Recupera il valore della propriet� codiIntervento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiIntervento() {
        return codiIntervento;
    }

    /**
     * Imposta il valore della propriet� codiIntervento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiIntervento(String value) {
        this.codiIntervento = value;
    }

    /**
     * Recupera il valore della propriet� codiIstatComune.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiIstatComune() {
        return codiIstatComune;
    }

    /**
     * Imposta il valore della propriet� codiIstatComune.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiIstatComune(String value) {
        this.codiIstatComune = value;
    }

    /**
     * Recupera il valore della propriet� codiIstatProvincia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiIstatProvincia() {
        return codiIstatProvincia;
    }

    /**
     * Imposta il valore della propriet� codiIstatProvincia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiIstatProvincia(String value) {
        this.codiIstatProvincia = value;
    }

    /**
     * Recupera il valore della propriet� codiProdotto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiProdotto() {
        return codiProdotto;
    }

    /**
     * Imposta il valore della propriet� codiProdotto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiProdotto(String value) {
        this.codiProdotto = value;
    }

    /**
     * Recupera il valore della propriet� codiVarieta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiVarieta() {
        return codiVarieta;
    }

    /**
     * Imposta il valore della propriet� codiVarieta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiVarieta(String value) {
        this.codiVarieta = value;
    }

    /**
     * Recupera il valore della propriet� dataFineVal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataFineVal() {
        return dataFineVal;
    }

    /**
     * Imposta il valore della propriet� dataFineVal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataFineVal(String value) {
        this.dataFineVal = value;
    }

    /**
     * Recupera il valore della propriet� dataInizioVal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataInizioVal() {
        return dataInizioVal;
    }

    /**
     * Imposta il valore della propriet� dataInizioVal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataInizioVal(String value) {
        this.dataInizioVal = value;
    }

    /**
     * Recupera il valore della propriet� foglioCatastale.
     * 
     */
    public int getFoglioCatastale() {
        return foglioCatastale;
    }

    /**
     * Imposta il valore della propriet� foglioCatastale.
     * 
     */
    public void setFoglioCatastale(int value) {
        this.foglioCatastale = value;
    }

    /**
     * Recupera il valore della propriet� idComunicazioneSupe.
     * 
     */
    public long getIdComunicazioneSupe() {
        return idComunicazioneSupe;
    }

    /**
     * Imposta il valore della propriet� idComunicazioneSupe.
     * 
     */
    public void setIdComunicazioneSupe(long value) {
        this.idComunicazioneSupe = value;
    }

    /**
     * Recupera il valore della propriet� numeroParticella.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroParticella() {
        return numeroParticella;
    }

    /**
     * Imposta il valore della propriet� numeroParticella.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroParticella(String value) {
        this.numeroParticella = value;
    }

    /**
     * Recupera il valore della propriet� sezCensuaria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSezCensuaria() {
        return sezCensuaria;
    }

    /**
     * Imposta il valore della propriet� sezCensuaria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSezCensuaria(String value) {
        this.sezCensuaria = value;
    }

    /**
     * Recupera il valore della propriet� subalterno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubalterno() {
        return subalterno;
    }

    /**
     * Imposta il valore della propriet� subalterno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubalterno(String value) {
        this.subalterno = value;
    }

    /**
     * Recupera il valore della propriet� supeColt.
     * 
     */
    public long getSupeColt() {
        return supeColt;
    }

    /**
     * Imposta il valore della propriet� supeColt.
     * 
     */
    public void setSupeColt(long value) {
        this.supeColt = value;
    }

    /**
     * Recupera il valore della propriet� supeUtil.
     * 
     */
    public long getSupeUtil() {
        return supeUtil;
    }

    /**
     * Imposta il valore della propriet� supeUtil.
     * 
     */
    public void setSupeUtil(long value) {
        this.supeUtil = value;
    }

    /**
     * Recupera il valore della propriet� tipoAnomalia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoAnomalia() {
        return tipoAnomalia;
    }

    /**
     * Imposta il valore della propriet� tipoAnomalia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoAnomalia(String value) {
        this.tipoAnomalia = value;
    }

    /**
     * Recupera il valore della propriet� valoAnomalia.
     * 
     */
    public int getValoAnomalia() {
        return valoAnomalia;
    }

    /**
     * Imposta il valore della propriet� valoAnomalia.
     * 
     */
    public void setValoAnomalia(int value) {
        this.valoAnomalia = value;
    }

}
