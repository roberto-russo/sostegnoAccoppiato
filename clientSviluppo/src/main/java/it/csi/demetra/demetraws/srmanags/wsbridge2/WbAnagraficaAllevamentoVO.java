
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per wbAnagraficaAllevamentoVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbAnagraficaAllevamentoVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="autorizzazioneLatte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cap" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="capiTotali" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="codiceAzienda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceFiscaleDetentore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceFiscaleProprietario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceSpecie" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="comune" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataCalcoloCapi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataFineAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataFineDetentore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataInizioAttivita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataInizioDetentore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="denominazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="denominazioneDetentore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="denominazioneProprietario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="foglioCatastale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idAllevamento" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="indirizzo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="latitudine" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="localita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="longitudine" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="orientamentoProduttivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="particella" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sezione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="soccida" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subAlterno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoAllevamentoCodice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoAllevamentoDescrizione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoProduzione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wbAnagraficaAllevamentoVO", propOrder = {
    "autorizzazioneLatte",
    "cap",
    "capiTotali",
    "codiceAzienda",
    "codiceFiscaleDetentore",
    "codiceFiscaleProprietario",
    "codiceSpecie",
    "comune",
    "dataCalcoloCapi",
    "dataFineAttivita",
    "dataFineDetentore",
    "dataInizioAttivita",
    "dataInizioDetentore",
    "denominazione",
    "denominazioneDetentore",
    "denominazioneProprietario",
    "foglioCatastale",
    "idAllevamento",
    "indirizzo",
    "latitudine",
    "localita",
    "longitudine",
    "orientamentoProduttivo",
    "particella",
    "sezione",
    "soccida",
    "subAlterno",
    "tipoAllevamentoCodice",
    "tipoAllevamentoDescrizione",
    "tipoProduzione"
})
public class WbAnagraficaAllevamentoVO {

    protected String autorizzazioneLatte;
    protected String cap;
    protected BigDecimal capiTotali;
    protected String codiceAzienda;
    protected String codiceFiscaleDetentore;
    protected String codiceFiscaleProprietario;
    protected String codiceSpecie;
    protected String comune;
    protected String dataCalcoloCapi;
    protected String dataFineAttivita;
    protected String dataFineDetentore;
    protected String dataInizioAttivita;
    protected String dataInizioDetentore;
    protected String denominazione;
    protected String denominazioneDetentore;
    protected String denominazioneProprietario;
    protected String foglioCatastale;
    protected BigDecimal idAllevamento;
    protected String indirizzo;
    protected BigDecimal latitudine;
    protected String localita;
    protected BigDecimal longitudine;
    protected String orientamentoProduttivo;
    protected String particella;
    protected String sezione;
    protected String soccida;
    protected String subAlterno;
    protected String tipoAllevamentoCodice;
    protected String tipoAllevamentoDescrizione;
    protected String tipoProduzione;

    /**
     * Recupera il valore della propriet� autorizzazioneLatte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutorizzazioneLatte() {
        return autorizzazioneLatte;
    }

    /**
     * Imposta il valore della propriet� autorizzazioneLatte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutorizzazioneLatte(String value) {
        this.autorizzazioneLatte = value;
    }

    /**
     * Recupera il valore della propriet� cap.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCap() {
        return cap;
    }

    /**
     * Imposta il valore della propriet� cap.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCap(String value) {
        this.cap = value;
    }

    /**
     * Recupera il valore della propriet� capiTotali.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCapiTotali() {
        return capiTotali;
    }

    /**
     * Imposta il valore della propriet� capiTotali.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCapiTotali(BigDecimal value) {
        this.capiTotali = value;
    }

    /**
     * Recupera il valore della propriet� codiceAzienda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceAzienda() {
        return codiceAzienda;
    }

    /**
     * Imposta il valore della propriet� codiceAzienda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceAzienda(String value) {
        this.codiceAzienda = value;
    }

    /**
     * Recupera il valore della propriet� codiceFiscaleDetentore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceFiscaleDetentore() {
        return codiceFiscaleDetentore;
    }

    /**
     * Imposta il valore della propriet� codiceFiscaleDetentore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceFiscaleDetentore(String value) {
        this.codiceFiscaleDetentore = value;
    }

    /**
     * Recupera il valore della propriet� codiceFiscaleProprietario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceFiscaleProprietario() {
        return codiceFiscaleProprietario;
    }

    /**
     * Imposta il valore della propriet� codiceFiscaleProprietario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceFiscaleProprietario(String value) {
        this.codiceFiscaleProprietario = value;
    }

    /**
     * Recupera il valore della propriet� codiceSpecie.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceSpecie() {
        return codiceSpecie;
    }

    /**
     * Imposta il valore della propriet� codiceSpecie.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceSpecie(String value) {
        this.codiceSpecie = value;
    }

    /**
     * Recupera il valore della propriet� comune.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComune() {
        return comune;
    }

    /**
     * Imposta il valore della propriet� comune.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComune(String value) {
        this.comune = value;
    }

    /**
     * Recupera il valore della propriet� dataCalcoloCapi.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataCalcoloCapi() {
        return dataCalcoloCapi;
    }

    /**
     * Imposta il valore della propriet� dataCalcoloCapi.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataCalcoloCapi(String value) {
        this.dataCalcoloCapi = value;
    }

    /**
     * Recupera il valore della propriet� dataFineAttivita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataFineAttivita() {
        return dataFineAttivita;
    }

    /**
     * Imposta il valore della propriet� dataFineAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataFineAttivita(String value) {
        this.dataFineAttivita = value;
    }

    /**
     * Recupera il valore della propriet� dataFineDetentore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataFineDetentore() {
        return dataFineDetentore;
    }

    /**
     * Imposta il valore della propriet� dataFineDetentore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataFineDetentore(String value) {
        this.dataFineDetentore = value;
    }

    /**
     * Recupera il valore della propriet� dataInizioAttivita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataInizioAttivita() {
        return dataInizioAttivita;
    }

    /**
     * Imposta il valore della propriet� dataInizioAttivita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataInizioAttivita(String value) {
        this.dataInizioAttivita = value;
    }

    /**
     * Recupera il valore della propriet� dataInizioDetentore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataInizioDetentore() {
        return dataInizioDetentore;
    }

    /**
     * Imposta il valore della propriet� dataInizioDetentore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataInizioDetentore(String value) {
        this.dataInizioDetentore = value;
    }

    /**
     * Recupera il valore della propriet� denominazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenominazione() {
        return denominazione;
    }

    /**
     * Imposta il valore della propriet� denominazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenominazione(String value) {
        this.denominazione = value;
    }

    /**
     * Recupera il valore della propriet� denominazioneDetentore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenominazioneDetentore() {
        return denominazioneDetentore;
    }

    /**
     * Imposta il valore della propriet� denominazioneDetentore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenominazioneDetentore(String value) {
        this.denominazioneDetentore = value;
    }

    /**
     * Recupera il valore della propriet� denominazioneProprietario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenominazioneProprietario() {
        return denominazioneProprietario;
    }

    /**
     * Imposta il valore della propriet� denominazioneProprietario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenominazioneProprietario(String value) {
        this.denominazioneProprietario = value;
    }

    /**
     * Recupera il valore della propriet� foglioCatastale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFoglioCatastale() {
        return foglioCatastale;
    }

    /**
     * Imposta il valore della propriet� foglioCatastale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFoglioCatastale(String value) {
        this.foglioCatastale = value;
    }

    /**
     * Recupera il valore della propriet� idAllevamento.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdAllevamento() {
        return idAllevamento;
    }

    /**
     * Imposta il valore della propriet� idAllevamento.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdAllevamento(BigDecimal value) {
        this.idAllevamento = value;
    }

    /**
     * Recupera il valore della propriet� indirizzo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndirizzo() {
        return indirizzo;
    }

    /**
     * Imposta il valore della propriet� indirizzo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndirizzo(String value) {
        this.indirizzo = value;
    }

    /**
     * Recupera il valore della propriet� latitudine.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLatitudine() {
        return latitudine;
    }

    /**
     * Imposta il valore della propriet� latitudine.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLatitudine(BigDecimal value) {
        this.latitudine = value;
    }

    /**
     * Recupera il valore della propriet� localita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalita() {
        return localita;
    }

    /**
     * Imposta il valore della propriet� localita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalita(String value) {
        this.localita = value;
    }

    /**
     * Recupera il valore della propriet� longitudine.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLongitudine() {
        return longitudine;
    }

    /**
     * Imposta il valore della propriet� longitudine.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLongitudine(BigDecimal value) {
        this.longitudine = value;
    }

    /**
     * Recupera il valore della propriet� orientamentoProduttivo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrientamentoProduttivo() {
        return orientamentoProduttivo;
    }

    /**
     * Imposta il valore della propriet� orientamentoProduttivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrientamentoProduttivo(String value) {
        this.orientamentoProduttivo = value;
    }

    /**
     * Recupera il valore della propriet� particella.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParticella() {
        return particella;
    }

    /**
     * Imposta il valore della propriet� particella.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParticella(String value) {
        this.particella = value;
    }

    /**
     * Recupera il valore della propriet� sezione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSezione() {
        return sezione;
    }

    /**
     * Imposta il valore della propriet� sezione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSezione(String value) {
        this.sezione = value;
    }

    /**
     * Recupera il valore della propriet� soccida.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSoccida() {
        return soccida;
    }

    /**
     * Imposta il valore della propriet� soccida.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSoccida(String value) {
        this.soccida = value;
    }

    /**
     * Recupera il valore della propriet� subAlterno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubAlterno() {
        return subAlterno;
    }

    /**
     * Imposta il valore della propriet� subAlterno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubAlterno(String value) {
        this.subAlterno = value;
    }

    /**
     * Recupera il valore della propriet� tipoAllevamentoCodice.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoAllevamentoCodice() {
        return tipoAllevamentoCodice;
    }

    /**
     * Imposta il valore della propriet� tipoAllevamentoCodice.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoAllevamentoCodice(String value) {
        this.tipoAllevamentoCodice = value;
    }

    /**
     * Recupera il valore della propriet� tipoAllevamentoDescrizione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoAllevamentoDescrizione() {
        return tipoAllevamentoDescrizione;
    }

    /**
     * Imposta il valore della propriet� tipoAllevamentoDescrizione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoAllevamentoDescrizione(String value) {
        this.tipoAllevamentoDescrizione = value;
    }

    /**
     * Recupera il valore della propriet� tipoProduzione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoProduzione() {
        return tipoProduzione;
    }

    /**
     * Imposta il valore della propriet� tipoProduzione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoProduzione(String value) {
        this.tipoProduzione = value;
    }

}
