
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per iterAmministrativo complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="iterAmministrativo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dataFine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataInizio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descEnte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idNotifica" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="idProgressivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="stato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="statoPrecedente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="statoSiap" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "iterAmministrativo", propOrder = {
    "dataFine",
    "dataInizio",
    "descEnte",
    "ente",
    "idNotifica",
    "idProgressivo",
    "stato",
    "statoPrecedente",
    "statoSiap"
})
public class IterAmministrativo {

    protected String dataFine;
    protected String dataInizio;
    protected String descEnte;
    protected String ente;
    protected Long idNotifica;
    protected String idProgressivo;
    protected String stato;
    protected String statoPrecedente;
    protected String statoSiap;

    /**
     * Recupera il valore della propriet� dataFine.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataFine() {
        return dataFine;
    }

    /**
     * Imposta il valore della propriet� dataFine.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataFine(String value) {
        this.dataFine = value;
    }

    /**
     * Recupera il valore della propriet� dataInizio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataInizio() {
        return dataInizio;
    }

    /**
     * Imposta il valore della propriet� dataInizio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataInizio(String value) {
        this.dataInizio = value;
    }

    /**
     * Recupera il valore della propriet� descEnte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescEnte() {
        return descEnte;
    }

    /**
     * Imposta il valore della propriet� descEnte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescEnte(String value) {
        this.descEnte = value;
    }

    /**
     * Recupera il valore della propriet� ente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnte() {
        return ente;
    }

    /**
     * Imposta il valore della propriet� ente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnte(String value) {
        this.ente = value;
    }

    /**
     * Recupera il valore della propriet� idNotifica.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdNotifica() {
        return idNotifica;
    }

    /**
     * Imposta il valore della propriet� idNotifica.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdNotifica(Long value) {
        this.idNotifica = value;
    }

    /**
     * Recupera il valore della propriet� idProgressivo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdProgressivo() {
        return idProgressivo;
    }

    /**
     * Imposta il valore della propriet� idProgressivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdProgressivo(String value) {
        this.idProgressivo = value;
    }

    /**
     * Recupera il valore della propriet� stato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStato() {
        return stato;
    }

    /**
     * Imposta il valore della propriet� stato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStato(String value) {
        this.stato = value;
    }

    /**
     * Recupera il valore della propriet� statoPrecedente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatoPrecedente() {
        return statoPrecedente;
    }

    /**
     * Imposta il valore della propriet� statoPrecedente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatoPrecedente(String value) {
        this.statoPrecedente = value;
    }

    /**
     * Recupera il valore della propriet� statoSiap.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatoSiap() {
        return statoSiap;
    }

    /**
     * Imposta il valore della propriet� statoSiap.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatoSiap(String value) {
        this.statoSiap = value;
    }

}
