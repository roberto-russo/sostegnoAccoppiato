
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per responseVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="responseVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codRet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceErrore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrizioneErrore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="info" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="requestXml" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoOutput" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="warning" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responseVO", propOrder = {
    "codRet",
    "codiceErrore",
    "descrizioneErrore",
    "info",
    "requestXml",
    "tipoOutput",
    "warning"
})
@XmlSeeAlso({
    RichiestaCompensazioneRispostaVO.class,
    RichiestaCompensazioniAsincroneRispostaVO.class,
    CompensazioneVO.class,
    VerificaCompensazioneRispostaVO.class,
    RecuperaRisultatoCompensazioniAsincroneRispostaVO.class,
    AnnullamentoCompensazioneRispostaVO.class,
    FinalizzazioneCompensazioneRispostaVO.class,
    RiepilogoFondoRispostaVO.class
})
public class ResponseVO {

    protected String codRet;
    protected String codiceErrore;
    protected String descrizioneErrore;
    protected String info;
    protected String requestXml;
    protected String tipoOutput;
    protected String warning;

    /**
     * Recupera il valore della propriet� codRet.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodRet() {
        return codRet;
    }

    /**
     * Imposta il valore della propriet� codRet.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodRet(String value) {
        this.codRet = value;
    }

    /**
     * Recupera il valore della propriet� codiceErrore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceErrore() {
        return codiceErrore;
    }

    /**
     * Imposta il valore della propriet� codiceErrore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceErrore(String value) {
        this.codiceErrore = value;
    }

    /**
     * Recupera il valore della propriet� descrizioneErrore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrizioneErrore() {
        return descrizioneErrore;
    }

    /**
     * Imposta il valore della propriet� descrizioneErrore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrizioneErrore(String value) {
        this.descrizioneErrore = value;
    }

    /**
     * Recupera il valore della propriet� info.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfo() {
        return info;
    }

    /**
     * Imposta il valore della propriet� info.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfo(String value) {
        this.info = value;
    }

    /**
     * Recupera il valore della propriet� requestXml.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestXml() {
        return requestXml;
    }

    /**
     * Imposta il valore della propriet� requestXml.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestXml(String value) {
        this.requestXml = value;
    }

    /**
     * Recupera il valore della propriet� tipoOutput.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoOutput() {
        return tipoOutput;
    }

    /**
     * Imposta il valore della propriet� tipoOutput.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoOutput(String value) {
        this.tipoOutput = value;
    }

    /**
     * Recupera il valore della propriet� warning.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWarning() {
        return warning;
    }

    /**
     * Imposta il valore della propriet� warning.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWarning(String value) {
        this.warning = value;
    }

}
