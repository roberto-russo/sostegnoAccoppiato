
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per capoOvicaprino complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="capoOvicaprino">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="allevId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="aziendaCodice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="capoId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="codice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="consMedia" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="cuaa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtApplMarchio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtComMacellazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtComNascita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtFineDetenzione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtInizioDetenzione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtInserimentoBdnNascita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtMacellazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtNascita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtRegistrMacellazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtUltimoPrelProfilassi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flagDelegatoNascita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="genotipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="razzaCodice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ruoloUtenteNascita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sesso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "capoOvicaprino", propOrder = {
    "allevId",
    "aziendaCodice",
    "capoId",
    "codice",
    "consMedia",
    "cuaa",
    "dtApplMarchio",
    "dtComMacellazione",
    "dtComNascita",
    "dtFineDetenzione",
    "dtInizioDetenzione",
    "dtInserimentoBdnNascita",
    "dtMacellazione",
    "dtNascita",
    "dtRegistrMacellazione",
    "dtUltimoPrelProfilassi",
    "flagDelegatoNascita",
    "genotipo",
    "razzaCodice",
    "ruoloUtenteNascita",
    "sesso"
})
public class CapoOvicaprino {

    protected long allevId;
    protected String aziendaCodice;
    protected long capoId;
    protected String codice;
    protected float consMedia;
    protected String cuaa;
    protected String dtApplMarchio;
    protected String dtComMacellazione;
    protected String dtComNascita;
    protected String dtFineDetenzione;
    protected String dtInizioDetenzione;
    protected String dtInserimentoBdnNascita;
    protected String dtMacellazione;
    protected String dtNascita;
    protected String dtRegistrMacellazione;
    protected String dtUltimoPrelProfilassi;
    protected String flagDelegatoNascita;
    protected String genotipo;
    protected String razzaCodice;
    protected String ruoloUtenteNascita;
    protected String sesso;

    /**
     * Recupera il valore della propriet� allevId.
     * 
     */
    public long getAllevId() {
        return allevId;
    }

    /**
     * Imposta il valore della propriet� allevId.
     * 
     */
    public void setAllevId(long value) {
        this.allevId = value;
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
     * Recupera il valore della propriet� capoId.
     * 
     */
    public long getCapoId() {
        return capoId;
    }

    /**
     * Imposta il valore della propriet� capoId.
     * 
     */
    public void setCapoId(long value) {
        this.capoId = value;
    }

    /**
     * Recupera il valore della propriet� codice.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodice() {
        return codice;
    }

    /**
     * Imposta il valore della propriet� codice.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodice(String value) {
        this.codice = value;
    }

    /**
     * Recupera il valore della propriet� consMedia.
     * 
     */
    public float getConsMedia() {
        return consMedia;
    }

    /**
     * Imposta il valore della propriet� consMedia.
     * 
     */
    public void setConsMedia(float value) {
        this.consMedia = value;
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
     * Recupera il valore della propriet� dtComMacellazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtComMacellazione() {
        return dtComMacellazione;
    }

    /**
     * Imposta il valore della propriet� dtComMacellazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtComMacellazione(String value) {
        this.dtComMacellazione = value;
    }

    /**
     * Recupera il valore della propriet� dtComNascita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtComNascita() {
        return dtComNascita;
    }

    /**
     * Imposta il valore della propriet� dtComNascita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtComNascita(String value) {
        this.dtComNascita = value;
    }

    /**
     * Recupera il valore della propriet� dtFineDetenzione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtFineDetenzione() {
        return dtFineDetenzione;
    }

    /**
     * Imposta il valore della propriet� dtFineDetenzione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtFineDetenzione(String value) {
        this.dtFineDetenzione = value;
    }

    /**
     * Recupera il valore della propriet� dtInizioDetenzione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtInizioDetenzione() {
        return dtInizioDetenzione;
    }

    /**
     * Imposta il valore della propriet� dtInizioDetenzione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtInizioDetenzione(String value) {
        this.dtInizioDetenzione = value;
    }

    /**
     * Recupera il valore della propriet� dtInserimentoBdnNascita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtInserimentoBdnNascita() {
        return dtInserimentoBdnNascita;
    }

    /**
     * Imposta il valore della propriet� dtInserimentoBdnNascita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtInserimentoBdnNascita(String value) {
        this.dtInserimentoBdnNascita = value;
    }

    /**
     * Recupera il valore della propriet� dtMacellazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtMacellazione() {
        return dtMacellazione;
    }

    /**
     * Imposta il valore della propriet� dtMacellazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtMacellazione(String value) {
        this.dtMacellazione = value;
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
     * Recupera il valore della propriet� dtRegistrMacellazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtRegistrMacellazione() {
        return dtRegistrMacellazione;
    }

    /**
     * Imposta il valore della propriet� dtRegistrMacellazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtRegistrMacellazione(String value) {
        this.dtRegistrMacellazione = value;
    }

    /**
     * Recupera il valore della propriet� dtUltimoPrelProfilassi.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtUltimoPrelProfilassi() {
        return dtUltimoPrelProfilassi;
    }

    /**
     * Imposta il valore della propriet� dtUltimoPrelProfilassi.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtUltimoPrelProfilassi(String value) {
        this.dtUltimoPrelProfilassi = value;
    }

    /**
     * Recupera il valore della propriet� flagDelegatoNascita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlagDelegatoNascita() {
        return flagDelegatoNascita;
    }

    /**
     * Imposta il valore della propriet� flagDelegatoNascita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlagDelegatoNascita(String value) {
        this.flagDelegatoNascita = value;
    }

    /**
     * Recupera il valore della propriet� genotipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenotipo() {
        return genotipo;
    }

    /**
     * Imposta il valore della propriet� genotipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenotipo(String value) {
        this.genotipo = value;
    }

    /**
     * Recupera il valore della propriet� razzaCodice.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRazzaCodice() {
        return razzaCodice;
    }

    /**
     * Imposta il valore della propriet� razzaCodice.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRazzaCodice(String value) {
        this.razzaCodice = value;
    }

    /**
     * Recupera il valore della propriet� ruoloUtenteNascita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRuoloUtenteNascita() {
        return ruoloUtenteNascita;
    }

    /**
     * Imposta il valore della propriet� ruoloUtenteNascita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRuoloUtenteNascita(String value) {
        this.ruoloUtenteNascita = value;
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

}
