
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per trovaFascicolo complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="trovaFascicolo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CUAA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceInps" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceTipoIscrizioneInps" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="comuneNascitaPF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataAperturaFascicolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataChiusuraFascicolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataElaborazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataFineIscrizioneInps" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataFineIscrizioneREA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataFineIscrizioneRI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataInizioIscrizioneInps" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataInizioIscrizioneREA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataInizioIscrizioneRI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataNascitaPF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataSottMandato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataValidazFascicolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="denominazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="detentore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="iscrizioneRea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="iscrizioneRegistroImprese" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomePF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroIscrizioneInps" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroIscrizioneREA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroIscrizioneRI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="organismoPagatore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="partitaIVA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recapito" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}indirizzo" minOccurs="0"/>
 *         &lt;element name="sedeResidenza" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}indirizzo" minOccurs="0"/>
 *         &lt;element name="sessoPF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoAzienda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoDetentore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trovaFascicolo", propOrder = {
    "cuaa",
    "codiceInps",
    "codiceTipoIscrizioneInps",
    "comuneNascitaPF",
    "dataAperturaFascicolo",
    "dataChiusuraFascicolo",
    "dataElaborazione",
    "dataFineIscrizioneInps",
    "dataFineIscrizioneREA",
    "dataFineIscrizioneRI",
    "dataInizioIscrizioneInps",
    "dataInizioIscrizioneREA",
    "dataInizioIscrizioneRI",
    "dataNascitaPF",
    "dataSottMandato",
    "dataValidazFascicolo",
    "denominazione",
    "detentore",
    "iscrizioneRea",
    "iscrizioneRegistroImprese",
    "nomePF",
    "numeroIscrizioneInps",
    "numeroIscrizioneREA",
    "numeroIscrizioneRI",
    "organismoPagatore",
    "partitaIVA",
    "recapito",
    "sedeResidenza",
    "sessoPF",
    "tipoAzienda",
    "tipoDetentore"
})
public class TrovaFascicolo {

    @XmlElement(name = "CUAA")
    protected String cuaa;
    protected String codiceInps;
    protected String codiceTipoIscrizioneInps;
    protected String comuneNascitaPF;
    protected String dataAperturaFascicolo;
    protected String dataChiusuraFascicolo;
    protected String dataElaborazione;
    protected String dataFineIscrizioneInps;
    protected String dataFineIscrizioneREA;
    protected String dataFineIscrizioneRI;
    protected String dataInizioIscrizioneInps;
    protected String dataInizioIscrizioneREA;
    protected String dataInizioIscrizioneRI;
    protected String dataNascitaPF;
    protected String dataSottMandato;
    protected String dataValidazFascicolo;
    protected String denominazione;
    protected String detentore;
    protected String iscrizioneRea;
    protected String iscrizioneRegistroImprese;
    protected String nomePF;
    protected String numeroIscrizioneInps;
    protected String numeroIscrizioneREA;
    protected String numeroIscrizioneRI;
    protected String organismoPagatore;
    protected String partitaIVA;
    protected Indirizzo recapito;
    protected Indirizzo sedeResidenza;
    protected String sessoPF;
    protected String tipoAzienda;
    protected String tipoDetentore;

    /**
     * Recupera il valore della propriet� cuaa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUAA() {
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
    public void setCUAA(String value) {
        this.cuaa = value;
    }

    /**
     * Recupera il valore della propriet� codiceInps.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceInps() {
        return codiceInps;
    }

    /**
     * Imposta il valore della propriet� codiceInps.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceInps(String value) {
        this.codiceInps = value;
    }

    /**
     * Recupera il valore della propriet� codiceTipoIscrizioneInps.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceTipoIscrizioneInps() {
        return codiceTipoIscrizioneInps;
    }

    /**
     * Imposta il valore della propriet� codiceTipoIscrizioneInps.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceTipoIscrizioneInps(String value) {
        this.codiceTipoIscrizioneInps = value;
    }

    /**
     * Recupera il valore della propriet� comuneNascitaPF.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComuneNascitaPF() {
        return comuneNascitaPF;
    }

    /**
     * Imposta il valore della propriet� comuneNascitaPF.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComuneNascitaPF(String value) {
        this.comuneNascitaPF = value;
    }

    /**
     * Recupera il valore della propriet� dataAperturaFascicolo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataAperturaFascicolo() {
        return dataAperturaFascicolo;
    }

    /**
     * Imposta il valore della propriet� dataAperturaFascicolo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataAperturaFascicolo(String value) {
        this.dataAperturaFascicolo = value;
    }

    /**
     * Recupera il valore della propriet� dataChiusuraFascicolo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataChiusuraFascicolo() {
        return dataChiusuraFascicolo;
    }

    /**
     * Imposta il valore della propriet� dataChiusuraFascicolo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataChiusuraFascicolo(String value) {
        this.dataChiusuraFascicolo = value;
    }

    /**
     * Recupera il valore della propriet� dataElaborazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataElaborazione() {
        return dataElaborazione;
    }

    /**
     * Imposta il valore della propriet� dataElaborazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataElaborazione(String value) {
        this.dataElaborazione = value;
    }

    /**
     * Recupera il valore della propriet� dataFineIscrizioneInps.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataFineIscrizioneInps() {
        return dataFineIscrizioneInps;
    }

    /**
     * Imposta il valore della propriet� dataFineIscrizioneInps.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataFineIscrizioneInps(String value) {
        this.dataFineIscrizioneInps = value;
    }

    /**
     * Recupera il valore della propriet� dataFineIscrizioneREA.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataFineIscrizioneREA() {
        return dataFineIscrizioneREA;
    }

    /**
     * Imposta il valore della propriet� dataFineIscrizioneREA.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataFineIscrizioneREA(String value) {
        this.dataFineIscrizioneREA = value;
    }

    /**
     * Recupera il valore della propriet� dataFineIscrizioneRI.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataFineIscrizioneRI() {
        return dataFineIscrizioneRI;
    }

    /**
     * Imposta il valore della propriet� dataFineIscrizioneRI.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataFineIscrizioneRI(String value) {
        this.dataFineIscrizioneRI = value;
    }

    /**
     * Recupera il valore della propriet� dataInizioIscrizioneInps.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataInizioIscrizioneInps() {
        return dataInizioIscrizioneInps;
    }

    /**
     * Imposta il valore della propriet� dataInizioIscrizioneInps.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataInizioIscrizioneInps(String value) {
        this.dataInizioIscrizioneInps = value;
    }

    /**
     * Recupera il valore della propriet� dataInizioIscrizioneREA.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataInizioIscrizioneREA() {
        return dataInizioIscrizioneREA;
    }

    /**
     * Imposta il valore della propriet� dataInizioIscrizioneREA.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataInizioIscrizioneREA(String value) {
        this.dataInizioIscrizioneREA = value;
    }

    /**
     * Recupera il valore della propriet� dataInizioIscrizioneRI.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataInizioIscrizioneRI() {
        return dataInizioIscrizioneRI;
    }

    /**
     * Imposta il valore della propriet� dataInizioIscrizioneRI.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataInizioIscrizioneRI(String value) {
        this.dataInizioIscrizioneRI = value;
    }

    /**
     * Recupera il valore della propriet� dataNascitaPF.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataNascitaPF() {
        return dataNascitaPF;
    }

    /**
     * Imposta il valore della propriet� dataNascitaPF.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataNascitaPF(String value) {
        this.dataNascitaPF = value;
    }

    /**
     * Recupera il valore della propriet� dataSottMandato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataSottMandato() {
        return dataSottMandato;
    }

    /**
     * Imposta il valore della propriet� dataSottMandato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataSottMandato(String value) {
        this.dataSottMandato = value;
    }

    /**
     * Recupera il valore della propriet� dataValidazFascicolo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataValidazFascicolo() {
        return dataValidazFascicolo;
    }

    /**
     * Imposta il valore della propriet� dataValidazFascicolo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataValidazFascicolo(String value) {
        this.dataValidazFascicolo = value;
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
     * Recupera il valore della propriet� detentore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetentore() {
        return detentore;
    }

    /**
     * Imposta il valore della propriet� detentore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetentore(String value) {
        this.detentore = value;
    }

    /**
     * Recupera il valore della propriet� iscrizioneRea.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIscrizioneRea() {
        return iscrizioneRea;
    }

    /**
     * Imposta il valore della propriet� iscrizioneRea.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIscrizioneRea(String value) {
        this.iscrizioneRea = value;
    }

    /**
     * Recupera il valore della propriet� iscrizioneRegistroImprese.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIscrizioneRegistroImprese() {
        return iscrizioneRegistroImprese;
    }

    /**
     * Imposta il valore della propriet� iscrizioneRegistroImprese.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIscrizioneRegistroImprese(String value) {
        this.iscrizioneRegistroImprese = value;
    }

    /**
     * Recupera il valore della propriet� nomePF.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomePF() {
        return nomePF;
    }

    /**
     * Imposta il valore della propriet� nomePF.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomePF(String value) {
        this.nomePF = value;
    }

    /**
     * Recupera il valore della propriet� numeroIscrizioneInps.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroIscrizioneInps() {
        return numeroIscrizioneInps;
    }

    /**
     * Imposta il valore della propriet� numeroIscrizioneInps.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroIscrizioneInps(String value) {
        this.numeroIscrizioneInps = value;
    }

    /**
     * Recupera il valore della propriet� numeroIscrizioneREA.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroIscrizioneREA() {
        return numeroIscrizioneREA;
    }

    /**
     * Imposta il valore della propriet� numeroIscrizioneREA.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroIscrizioneREA(String value) {
        this.numeroIscrizioneREA = value;
    }

    /**
     * Recupera il valore della propriet� numeroIscrizioneRI.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroIscrizioneRI() {
        return numeroIscrizioneRI;
    }

    /**
     * Imposta il valore della propriet� numeroIscrizioneRI.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroIscrizioneRI(String value) {
        this.numeroIscrizioneRI = value;
    }

    /**
     * Recupera il valore della propriet� organismoPagatore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganismoPagatore() {
        return organismoPagatore;
    }

    /**
     * Imposta il valore della propriet� organismoPagatore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganismoPagatore(String value) {
        this.organismoPagatore = value;
    }

    /**
     * Recupera il valore della propriet� partitaIVA.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartitaIVA() {
        return partitaIVA;
    }

    /**
     * Imposta il valore della propriet� partitaIVA.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartitaIVA(String value) {
        this.partitaIVA = value;
    }

    /**
     * Recupera il valore della propriet� recapito.
     * 
     * @return
     *     possible object is
     *     {@link Indirizzo }
     *     
     */
    public Indirizzo getRecapito() {
        return recapito;
    }

    /**
     * Imposta il valore della propriet� recapito.
     * 
     * @param value
     *     allowed object is
     *     {@link Indirizzo }
     *     
     */
    public void setRecapito(Indirizzo value) {
        this.recapito = value;
    }

    /**
     * Recupera il valore della propriet� sedeResidenza.
     * 
     * @return
     *     possible object is
     *     {@link Indirizzo }
     *     
     */
    public Indirizzo getSedeResidenza() {
        return sedeResidenza;
    }

    /**
     * Imposta il valore della propriet� sedeResidenza.
     * 
     * @param value
     *     allowed object is
     *     {@link Indirizzo }
     *     
     */
    public void setSedeResidenza(Indirizzo value) {
        this.sedeResidenza = value;
    }

    /**
     * Recupera il valore della propriet� sessoPF.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessoPF() {
        return sessoPF;
    }

    /**
     * Imposta il valore della propriet� sessoPF.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessoPF(String value) {
        this.sessoPF = value;
    }

    /**
     * Recupera il valore della propriet� tipoAzienda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoAzienda() {
        return tipoAzienda;
    }

    /**
     * Imposta il valore della propriet� tipoAzienda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoAzienda(String value) {
        this.tipoAzienda = value;
    }

    /**
     * Recupera il valore della propriet� tipoDetentore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDetentore() {
        return tipoDetentore;
    }

    /**
     * Imposta il valore della propriet� tipoDetentore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDetentore(String value) {
        this.tipoDetentore = value;
    }

}
