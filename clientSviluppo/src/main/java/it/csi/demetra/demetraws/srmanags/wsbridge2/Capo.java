
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per capo complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="capo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="allevId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="aziendaCodice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="capoCodMadre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="capoId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="codLibroMadre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descLibroMadre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtFineDetenzione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtInizioDetenzione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtMacellazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtNascita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "capo", propOrder = {
    "allevId",
    "aziendaCodice",
    "capoCodMadre",
    "capoId",
    "codLibroMadre",
    "codice",
    "descLibroMadre",
    "dtFineDetenzione",
    "dtInizioDetenzione",
    "dtMacellazione",
    "dtNascita",
    "razzaCodice",
    "sesso"
})
public class Capo {

    protected long allevId;
    protected String aziendaCodice;
    protected String capoCodMadre;
    protected long capoId;
    protected String codLibroMadre;
    protected String codice;
    protected String descLibroMadre;
    protected String dtFineDetenzione;
    protected String dtInizioDetenzione;
    protected String dtMacellazione;
    protected String dtNascita;
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
     * Recupera il valore della propriet� capoCodMadre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapoCodMadre() {
        return capoCodMadre;
    }

    /**
     * Imposta il valore della propriet� capoCodMadre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapoCodMadre(String value) {
        this.capoCodMadre = value;
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
     * Recupera il valore della propriet� codLibroMadre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodLibroMadre() {
        return codLibroMadre;
    }

    /**
     * Imposta il valore della propriet� codLibroMadre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodLibroMadre(String value) {
        this.codLibroMadre = value;
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
     * Recupera il valore della propriet� descLibroMadre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescLibroMadre() {
        return descLibroMadre;
    }

    /**
     * Imposta il valore della propriet� descLibroMadre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescLibroMadre(String value) {
        this.descLibroMadre = value;
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
