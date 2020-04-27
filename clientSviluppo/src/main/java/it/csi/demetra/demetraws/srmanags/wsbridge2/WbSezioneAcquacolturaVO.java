
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per wbSezioneAcquacolturaVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbSezioneAcquacolturaVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="capacitaProduttiva" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceASL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrizioneImpianto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dettaglioMacrouso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dimensione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idProgressivoUP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="macrouso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="metodo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomeImpianto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="riferimentiGeografici" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbRifGeogAcquaculturaVO" minOccurs="0"/>
 *         &lt;element name="specie" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoImpianto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoUbicazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unitaMisuraCapacita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unitaMisuraDimensione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wbSezioneAcquacolturaVO", propOrder = {
    "capacitaProduttiva",
    "codiceASL",
    "descrizioneImpianto",
    "dettaglioMacrouso",
    "dimensione",
    "idProgressivoUP",
    "macrouso",
    "metodo",
    "nomeImpianto",
    "riferimentiGeografici",
    "specie",
    "tipoImpianto",
    "tipoUbicazione",
    "unitaMisuraCapacita",
    "unitaMisuraDimensione"
})
public class WbSezioneAcquacolturaVO {

    protected String capacitaProduttiva;
    protected String codiceASL;
    protected String descrizioneImpianto;
    protected String dettaglioMacrouso;
    protected String dimensione;
    protected String idProgressivoUP;
    protected String macrouso;
    protected String metodo;
    protected String nomeImpianto;
    protected WbRifGeogAcquaculturaVO riferimentiGeografici;
    protected String specie;
    protected String tipoImpianto;
    protected String tipoUbicazione;
    protected String unitaMisuraCapacita;
    protected String unitaMisuraDimensione;

    /**
     * Recupera il valore della propriet� capacitaProduttiva.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapacitaProduttiva() {
        return capacitaProduttiva;
    }

    /**
     * Imposta il valore della propriet� capacitaProduttiva.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapacitaProduttiva(String value) {
        this.capacitaProduttiva = value;
    }

    /**
     * Recupera il valore della propriet� codiceASL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceASL() {
        return codiceASL;
    }

    /**
     * Imposta il valore della propriet� codiceASL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceASL(String value) {
        this.codiceASL = value;
    }

    /**
     * Recupera il valore della propriet� descrizioneImpianto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrizioneImpianto() {
        return descrizioneImpianto;
    }

    /**
     * Imposta il valore della propriet� descrizioneImpianto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrizioneImpianto(String value) {
        this.descrizioneImpianto = value;
    }

    /**
     * Recupera il valore della propriet� dettaglioMacrouso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDettaglioMacrouso() {
        return dettaglioMacrouso;
    }

    /**
     * Imposta il valore della propriet� dettaglioMacrouso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDettaglioMacrouso(String value) {
        this.dettaglioMacrouso = value;
    }

    /**
     * Recupera il valore della propriet� dimensione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDimensione() {
        return dimensione;
    }

    /**
     * Imposta il valore della propriet� dimensione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDimensione(String value) {
        this.dimensione = value;
    }

    /**
     * Recupera il valore della propriet� idProgressivoUP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdProgressivoUP() {
        return idProgressivoUP;
    }

    /**
     * Imposta il valore della propriet� idProgressivoUP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdProgressivoUP(String value) {
        this.idProgressivoUP = value;
    }

    /**
     * Recupera il valore della propriet� macrouso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMacrouso() {
        return macrouso;
    }

    /**
     * Imposta il valore della propriet� macrouso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMacrouso(String value) {
        this.macrouso = value;
    }

    /**
     * Recupera il valore della propriet� metodo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMetodo() {
        return metodo;
    }

    /**
     * Imposta il valore della propriet� metodo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMetodo(String value) {
        this.metodo = value;
    }

    /**
     * Recupera il valore della propriet� nomeImpianto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeImpianto() {
        return nomeImpianto;
    }

    /**
     * Imposta il valore della propriet� nomeImpianto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeImpianto(String value) {
        this.nomeImpianto = value;
    }

    /**
     * Recupera il valore della propriet� riferimentiGeografici.
     * 
     * @return
     *     possible object is
     *     {@link WbRifGeogAcquaculturaVO }
     *     
     */
    public WbRifGeogAcquaculturaVO getRiferimentiGeografici() {
        return riferimentiGeografici;
    }

    /**
     * Imposta il valore della propriet� riferimentiGeografici.
     * 
     * @param value
     *     allowed object is
     *     {@link WbRifGeogAcquaculturaVO }
     *     
     */
    public void setRiferimentiGeografici(WbRifGeogAcquaculturaVO value) {
        this.riferimentiGeografici = value;
    }

    /**
     * Recupera il valore della propriet� specie.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecie() {
        return specie;
    }

    /**
     * Imposta il valore della propriet� specie.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecie(String value) {
        this.specie = value;
    }

    /**
     * Recupera il valore della propriet� tipoImpianto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoImpianto() {
        return tipoImpianto;
    }

    /**
     * Imposta il valore della propriet� tipoImpianto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoImpianto(String value) {
        this.tipoImpianto = value;
    }

    /**
     * Recupera il valore della propriet� tipoUbicazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoUbicazione() {
        return tipoUbicazione;
    }

    /**
     * Imposta il valore della propriet� tipoUbicazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoUbicazione(String value) {
        this.tipoUbicazione = value;
    }

    /**
     * Recupera il valore della propriet� unitaMisuraCapacita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitaMisuraCapacita() {
        return unitaMisuraCapacita;
    }

    /**
     * Imposta il valore della propriet� unitaMisuraCapacita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitaMisuraCapacita(String value) {
        this.unitaMisuraCapacita = value;
    }

    /**
     * Recupera il valore della propriet� unitaMisuraDimensione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitaMisuraDimensione() {
        return unitaMisuraDimensione;
    }

    /**
     * Imposta il valore della propriet� unitaMisuraDimensione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitaMisuraDimensione(String value) {
        this.unitaMisuraDimensione = value;
    }

}
