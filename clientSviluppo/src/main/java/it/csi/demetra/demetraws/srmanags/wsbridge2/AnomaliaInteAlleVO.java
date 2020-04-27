
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per anomaliaInteAlleVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="anomaliaInteAlleVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codiASL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceIntervento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataFineVal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataInizioVal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idComunicazione" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
@XmlType(name = "anomaliaInteAlleVO", propOrder = {
    "codiASL",
    "codiceIntervento",
    "dataFineVal",
    "dataInizioVal",
    "idComunicazione",
    "tipoAnomalia",
    "valoAnomalia"
})
public class AnomaliaInteAlleVO {

    protected String codiASL;
    protected String codiceIntervento;
    protected String dataFineVal;
    protected String dataInizioVal;
    protected long idComunicazione;
    protected String tipoAnomalia;
    protected int valoAnomalia;

    /**
     * Recupera il valore della propriet� codiASL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiASL() {
        return codiASL;
    }

    /**
     * Imposta il valore della propriet� codiASL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiASL(String value) {
        this.codiASL = value;
    }

    /**
     * Recupera il valore della propriet� codiceIntervento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceIntervento() {
        return codiceIntervento;
    }

    /**
     * Imposta il valore della propriet� codiceIntervento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceIntervento(String value) {
        this.codiceIntervento = value;
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
     * Recupera il valore della propriet� idComunicazione.
     * 
     */
    public long getIdComunicazione() {
        return idComunicazione;
    }

    /**
     * Imposta il valore della propriet� idComunicazione.
     * 
     */
    public void setIdComunicazione(long value) {
        this.idComunicazione = value;
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
