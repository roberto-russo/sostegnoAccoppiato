
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per oviRegistroDiStallaVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="oviRegistroDiStallaVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="allevIdFiscale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="aziendaCodice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="aziendaComDescrizione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="aziendaProSigla" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cap" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="caricoNascita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codPrecedente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceElettronico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceMadre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataMorteVendita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="denominazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="destinazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="detenCognNome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtApplMarchio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtIngresso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtNascita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estremiModAcc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="indirizzo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ingrCapoId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="localita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="marchio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="propCognNome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="provenienza" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="razza" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="scaricoMorte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sesso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="specieCodice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoDestinazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoProvenienza" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "oviRegistroDiStallaVO", propOrder = {
    "allevIdFiscale",
    "aziendaCodice",
    "aziendaComDescrizione",
    "aziendaProSigla",
    "cap",
    "caricoNascita",
    "codPrecedente",
    "codiceElettronico",
    "codiceMadre",
    "dataMorteVendita",
    "denominazione",
    "destinazione",
    "detenCognNome",
    "dtApplMarchio",
    "dtIngresso",
    "dtNascita",
    "estremiModAcc",
    "indirizzo",
    "ingrCapoId",
    "localita",
    "marchio",
    "propCognNome",
    "provenienza",
    "razza",
    "scaricoMorte",
    "sesso",
    "specieCodice",
    "tipoDestinazione",
    "tipoProvenienza"
})
public class OviRegistroDiStallaVO {

    protected String allevIdFiscale;
    protected String aziendaCodice;
    protected String aziendaComDescrizione;
    protected String aziendaProSigla;
    protected String cap;
    protected String caricoNascita;
    protected String codPrecedente;
    protected String codiceElettronico;
    protected String codiceMadre;
    protected String dataMorteVendita;
    protected String denominazione;
    protected String destinazione;
    protected String detenCognNome;
    protected String dtApplMarchio;
    protected String dtIngresso;
    protected String dtNascita;
    protected String estremiModAcc;
    protected String indirizzo;
    protected String ingrCapoId;
    protected String localita;
    protected String marchio;
    protected String propCognNome;
    protected String provenienza;
    protected String razza;
    protected String scaricoMorte;
    protected String sesso;
    protected String specieCodice;
    protected String tipoDestinazione;
    protected String tipoProvenienza;

    /**
     * Recupera il valore della propriet� allevIdFiscale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAllevIdFiscale() {
        return allevIdFiscale;
    }

    /**
     * Imposta il valore della propriet� allevIdFiscale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAllevIdFiscale(String value) {
        this.allevIdFiscale = value;
    }

    /**
     * Recupera il valore della propriet� aziendaCodice.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAziendaCodice() {
        return aziendaCodice;
    }

    /**
     * Imposta il valore della propriet� aziendaCodice.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAziendaCodice(String value) {
        this.aziendaCodice = value;
    }

    /**
     * Recupera il valore della propriet� aziendaComDescrizione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAziendaComDescrizione() {
        return aziendaComDescrizione;
    }

    /**
     * Imposta il valore della propriet� aziendaComDescrizione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAziendaComDescrizione(String value) {
        this.aziendaComDescrizione = value;
    }

    /**
     * Recupera il valore della propriet� aziendaProSigla.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAziendaProSigla() {
        return aziendaProSigla;
    }

    /**
     * Imposta il valore della propriet� aziendaProSigla.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAziendaProSigla(String value) {
        this.aziendaProSigla = value;
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
     * Recupera il valore della propriet� caricoNascita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaricoNascita() {
        return caricoNascita;
    }

    /**
     * Imposta il valore della propriet� caricoNascita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaricoNascita(String value) {
        this.caricoNascita = value;
    }

    /**
     * Recupera il valore della propriet� codPrecedente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodPrecedente() {
        return codPrecedente;
    }

    /**
     * Imposta il valore della propriet� codPrecedente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodPrecedente(String value) {
        this.codPrecedente = value;
    }

    /**
     * Recupera il valore della propriet� codiceElettronico.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceElettronico() {
        return codiceElettronico;
    }

    /**
     * Imposta il valore della propriet� codiceElettronico.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceElettronico(String value) {
        this.codiceElettronico = value;
    }

    /**
     * Recupera il valore della propriet� codiceMadre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceMadre() {
        return codiceMadre;
    }

    /**
     * Imposta il valore della propriet� codiceMadre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceMadre(String value) {
        this.codiceMadre = value;
    }

    /**
     * Recupera il valore della propriet� dataMorteVendita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataMorteVendita() {
        return dataMorteVendita;
    }

    /**
     * Imposta il valore della propriet� dataMorteVendita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataMorteVendita(String value) {
        this.dataMorteVendita = value;
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
     * Recupera il valore della propriet� destinazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinazione() {
        return destinazione;
    }

    /**
     * Imposta il valore della propriet� destinazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinazione(String value) {
        this.destinazione = value;
    }

    /**
     * Recupera il valore della propriet� detenCognNome.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetenCognNome() {
        return detenCognNome;
    }

    /**
     * Imposta il valore della propriet� detenCognNome.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetenCognNome(String value) {
        this.detenCognNome = value;
    }

    /**
     * Recupera il valore della propriet� dtApplMarchio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtApplMarchio() {
        return dtApplMarchio;
    }

    /**
     * Imposta il valore della propriet� dtApplMarchio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtApplMarchio(String value) {
        this.dtApplMarchio = value;
    }

    /**
     * Recupera il valore della propriet� dtIngresso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtIngresso() {
        return dtIngresso;
    }

    /**
     * Imposta il valore della propriet� dtIngresso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtIngresso(String value) {
        this.dtIngresso = value;
    }

    /**
     * Recupera il valore della propriet� dtNascita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtNascita() {
        return dtNascita;
    }

    /**
     * Imposta il valore della propriet� dtNascita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtNascita(String value) {
        this.dtNascita = value;
    }

    /**
     * Recupera il valore della propriet� estremiModAcc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstremiModAcc() {
        return estremiModAcc;
    }

    /**
     * Imposta il valore della propriet� estremiModAcc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstremiModAcc(String value) {
        this.estremiModAcc = value;
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
     * Recupera il valore della propriet� ingrCapoId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIngrCapoId() {
        return ingrCapoId;
    }

    /**
     * Imposta il valore della propriet� ingrCapoId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIngrCapoId(String value) {
        this.ingrCapoId = value;
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
     * Recupera il valore della propriet� marchio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarchio() {
        return marchio;
    }

    /**
     * Imposta il valore della propriet� marchio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarchio(String value) {
        this.marchio = value;
    }

    /**
     * Recupera il valore della propriet� propCognNome.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropCognNome() {
        return propCognNome;
    }

    /**
     * Imposta il valore della propriet� propCognNome.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropCognNome(String value) {
        this.propCognNome = value;
    }

    /**
     * Recupera il valore della propriet� provenienza.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvenienza() {
        return provenienza;
    }

    /**
     * Imposta il valore della propriet� provenienza.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvenienza(String value) {
        this.provenienza = value;
    }

    /**
     * Recupera il valore della propriet� razza.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRazza() {
        return razza;
    }

    /**
     * Imposta il valore della propriet� razza.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRazza(String value) {
        this.razza = value;
    }

    /**
     * Recupera il valore della propriet� scaricoMorte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScaricoMorte() {
        return scaricoMorte;
    }

    /**
     * Imposta il valore della propriet� scaricoMorte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScaricoMorte(String value) {
        this.scaricoMorte = value;
    }

    /**
     * Recupera il valore della propriet� sesso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSesso() {
        return sesso;
    }

    /**
     * Imposta il valore della propriet� sesso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSesso(String value) {
        this.sesso = value;
    }

    /**
     * Recupera il valore della propriet� specieCodice.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecieCodice() {
        return specieCodice;
    }

    /**
     * Imposta il valore della propriet� specieCodice.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecieCodice(String value) {
        this.specieCodice = value;
    }

    /**
     * Recupera il valore della propriet� tipoDestinazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDestinazione() {
        return tipoDestinazione;
    }

    /**
     * Imposta il valore della propriet� tipoDestinazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDestinazione(String value) {
        this.tipoDestinazione = value;
    }

    /**
     * Recupera il valore della propriet� tipoProvenienza.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoProvenienza() {
        return tipoProvenienza;
    }

    /**
     * Imposta il valore della propriet� tipoProvenienza.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoProvenienza(String value) {
        this.tipoProvenienza = value;
    }

}
