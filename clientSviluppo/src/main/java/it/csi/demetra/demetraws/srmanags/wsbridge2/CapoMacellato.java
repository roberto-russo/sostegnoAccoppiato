
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per capoMacellato complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="capoMacellato">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="allevId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="aziendaCodice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="aziendaLatitudine" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="aziendaLongitudine" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="capoId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="codLibro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cuaa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrLibro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtComAutoritaIngresso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtComAutoritaUscita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtFineDetenzione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtIngresso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtInizioDetenzione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtInserimentoBdnIngresso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtInserimentoBdnUscita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtMacellazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtNascita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtUscita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flagDelegatoIngresso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flagDelegatoUscita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="razzaCodice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "capoMacellato", propOrder = {
    "allevId",
    "aziendaCodice",
    "aziendaLatitudine",
    "aziendaLongitudine",
    "capoId",
    "codLibro",
    "codice",
    "cuaa",
    "descrLibro",
    "dtComAutoritaIngresso",
    "dtComAutoritaUscita",
    "dtFineDetenzione",
    "dtIngresso",
    "dtInizioDetenzione",
    "dtInserimentoBdnIngresso",
    "dtInserimentoBdnUscita",
    "dtMacellazione",
    "dtNascita",
    "dtUscita",
    "flagDelegatoIngresso",
    "flagDelegatoUscita",
    "razzaCodice",
    "sesso"
})
public class CapoMacellato {

    protected long allevId;
    protected String aziendaCodice;
    protected double aziendaLatitudine;
    protected double aziendaLongitudine;
    protected long capoId;
    protected String codLibro;
    protected String codice;
    protected String cuaa;
    protected String descrLibro;
    protected String dtComAutoritaIngresso;
    protected String dtComAutoritaUscita;
    protected String dtFineDetenzione;
    protected String dtIngresso;
    protected String dtInizioDetenzione;
    protected String dtInserimentoBdnIngresso;
    protected String dtInserimentoBdnUscita;
    protected String dtMacellazione;
    protected String dtNascita;
    protected String dtUscita;
    protected String flagDelegatoIngresso;
    protected String flagDelegatoUscita;
    protected String razzaCodice;
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
     * Recupera il valore della propriet� aziendaLatitudine.
     * 
     */
    public double getAziendaLatitudine() {
        return aziendaLatitudine;
    }

    /**
     * Imposta il valore della propriet� aziendaLatitudine.
     * 
     */
    public void setAziendaLatitudine(double value) {
        this.aziendaLatitudine = value;
    }

    /**
     * Recupera il valore della propriet� aziendaLongitudine.
     * 
     */
    public double getAziendaLongitudine() {
        return aziendaLongitudine;
    }

    /**
     * Imposta il valore della propriet� aziendaLongitudine.
     * 
     */
    public void setAziendaLongitudine(double value) {
        this.aziendaLongitudine = value;
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
     * Recupera il valore della propriet� codLibro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodLibro() {
        return codLibro;
    }

    /**
     * Imposta il valore della propriet� codLibro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodLibro(String value) {
        this.codLibro = value;
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
     * Recupera il valore della propriet� descrLibro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrLibro() {
        return descrLibro;
    }

    /**
     * Imposta il valore della propriet� descrLibro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrLibro(String value) {
        this.descrLibro = value;
    }

    /**
     * Recupera il valore della propriet� dtComAutoritaIngresso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtComAutoritaIngresso() {
        return dtComAutoritaIngresso;
    }

    /**
     * Imposta il valore della propriet� dtComAutoritaIngresso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtComAutoritaIngresso(String value) {
        this.dtComAutoritaIngresso = value;
    }

    /**
     * Recupera il valore della propriet� dtComAutoritaUscita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtComAutoritaUscita() {
        return dtComAutoritaUscita;
    }

    /**
     * Imposta il valore della propriet� dtComAutoritaUscita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtComAutoritaUscita(String value) {
        this.dtComAutoritaUscita = value;
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
     * Recupera il valore della propriet� dtInserimentoBdnIngresso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtInserimentoBdnIngresso() {
        return dtInserimentoBdnIngresso;
    }

    /**
     * Imposta il valore della propriet� dtInserimentoBdnIngresso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtInserimentoBdnIngresso(String value) {
        this.dtInserimentoBdnIngresso = value;
    }

    /**
     * Recupera il valore della propriet� dtInserimentoBdnUscita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtInserimentoBdnUscita() {
        return dtInserimentoBdnUscita;
    }

    /**
     * Imposta il valore della propriet� dtInserimentoBdnUscita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtInserimentoBdnUscita(String value) {
        this.dtInserimentoBdnUscita = value;
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
     * Recupera il valore della propriet� dtUscita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtUscita() {
        return dtUscita;
    }

    /**
     * Imposta il valore della propriet� dtUscita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtUscita(String value) {
        this.dtUscita = value;
    }

    /**
     * Recupera il valore della propriet� flagDelegatoIngresso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlagDelegatoIngresso() {
        return flagDelegatoIngresso;
    }

    /**
     * Imposta il valore della propriet� flagDelegatoIngresso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlagDelegatoIngresso(String value) {
        this.flagDelegatoIngresso = value;
    }

    /**
     * Recupera il valore della propriet� flagDelegatoUscita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlagDelegatoUscita() {
        return flagDelegatoUscita;
    }

    /**
     * Imposta il valore della propriet� flagDelegatoUscita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlagDelegatoUscita(String value) {
        this.flagDelegatoUscita = value;
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
