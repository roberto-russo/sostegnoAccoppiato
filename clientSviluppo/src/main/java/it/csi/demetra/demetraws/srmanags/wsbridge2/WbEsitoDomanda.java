
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per wbEsitoDomanda complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbEsitoDomanda">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="identificativo" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="intestatario" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbIntestatario" minOccurs="0"/>
 *         &lt;element name="numeroTitoli" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tipoRichiesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vWBAnomaliaAggiornamento" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbAnomaliaAggiornamento" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wbEsitoDomanda", propOrder = {
    "idDocumento",
    "identificativo",
    "intestatario",
    "numeroTitoli",
    "tipoRichiesta",
    "vwbAnomaliaAggiornamento"
})
public class WbEsitoDomanda {

    protected String idDocumento;
    protected BigDecimal identificativo;
    protected WbIntestatario intestatario;
    protected int numeroTitoli;
    protected String tipoRichiesta;
    @XmlElement(name = "vWBAnomaliaAggiornamento", nillable = true)
    protected List<WbAnomaliaAggiornamento> vwbAnomaliaAggiornamento;

    /**
     * Recupera il valore della propriet� idDocumento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdDocumento() {
        return idDocumento;
    }

    /**
     * Imposta il valore della propriet� idDocumento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdDocumento(String value) {
        this.idDocumento = value;
    }

    /**
     * Recupera il valore della propriet� identificativo.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdentificativo() {
        return identificativo;
    }

    /**
     * Imposta il valore della propriet� identificativo.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdentificativo(BigDecimal value) {
        this.identificativo = value;
    }

    /**
     * Recupera il valore della propriet� intestatario.
     * 
     * @return
     *     possible object is
     *     {@link WbIntestatario }
     *     
     */
    public WbIntestatario getIntestatario() {
        return intestatario;
    }

    /**
     * Imposta il valore della propriet� intestatario.
     * 
     * @param value
     *     allowed object is
     *     {@link WbIntestatario }
     *     
     */
    public void setIntestatario(WbIntestatario value) {
        this.intestatario = value;
    }

    /**
     * Recupera il valore della propriet� numeroTitoli.
     * 
     */
    public int getNumeroTitoli() {
        return numeroTitoli;
    }

    /**
     * Imposta il valore della propriet� numeroTitoli.
     * 
     */
    public void setNumeroTitoli(int value) {
        this.numeroTitoli = value;
    }

    /**
     * Recupera il valore della propriet� tipoRichiesta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoRichiesta() {
        return tipoRichiesta;
    }

    /**
     * Imposta il valore della propriet� tipoRichiesta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoRichiesta(String value) {
        this.tipoRichiesta = value;
    }

    /**
     * Gets the value of the vwbAnomaliaAggiornamento property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vwbAnomaliaAggiornamento property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVWBAnomaliaAggiornamento().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WbAnomaliaAggiornamento }
     * 
     * 
     */
    public List<WbAnomaliaAggiornamento> getVWBAnomaliaAggiornamento() {
        if (vwbAnomaliaAggiornamento == null) {
            vwbAnomaliaAggiornamento = new ArrayList<WbAnomaliaAggiornamento>();
        }
        return this.vwbAnomaliaAggiornamento;
    }

}
