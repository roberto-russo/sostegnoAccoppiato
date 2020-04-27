
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per datiRecuperoTypeVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="datiRecuperoTypeVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="annoCampagna" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CUAA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceCapitoloDonante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceCapitoloRicevente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceSettore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceUO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="identificativoOP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="importoRecupero" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="numeroDispPagamento" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datiRecuperoTypeVO", propOrder = {
    "annoCampagna",
    "cuaa",
    "codiceCapitoloDonante",
    "codiceCapitoloRicevente",
    "codiceSettore",
    "codiceUO",
    "identificativoOP",
    "importoRecupero",
    "numeroDispPagamento"
})
public class DatiRecuperoTypeVO {

    protected int annoCampagna;
    @XmlElement(name = "CUAA")
    protected String cuaa;
    protected String codiceCapitoloDonante;
    protected String codiceCapitoloRicevente;
    protected String codiceSettore;
    protected String codiceUO;
    protected String identificativoOP;
    protected BigDecimal importoRecupero;
    protected BigInteger numeroDispPagamento;

    /**
     * Recupera il valore della propriet� annoCampagna.
     * 
     */
    public int getAnnoCampagna() {
        return annoCampagna;
    }

    /**
     * Imposta il valore della propriet� annoCampagna.
     * 
     */
    public void setAnnoCampagna(int value) {
        this.annoCampagna = value;
    }

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
     * Recupera il valore della propriet� codiceCapitoloDonante.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceCapitoloDonante() {
        return codiceCapitoloDonante;
    }

    /**
     * Imposta il valore della propriet� codiceCapitoloDonante.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceCapitoloDonante(String value) {
        this.codiceCapitoloDonante = value;
    }

    /**
     * Recupera il valore della propriet� codiceCapitoloRicevente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceCapitoloRicevente() {
        return codiceCapitoloRicevente;
    }

    /**
     * Imposta il valore della propriet� codiceCapitoloRicevente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceCapitoloRicevente(String value) {
        this.codiceCapitoloRicevente = value;
    }

    /**
     * Recupera il valore della propriet� codiceSettore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceSettore() {
        return codiceSettore;
    }

    /**
     * Imposta il valore della propriet� codiceSettore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceSettore(String value) {
        this.codiceSettore = value;
    }

    /**
     * Recupera il valore della propriet� codiceUO.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceUO() {
        return codiceUO;
    }

    /**
     * Imposta il valore della propriet� codiceUO.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceUO(String value) {
        this.codiceUO = value;
    }

    /**
     * Recupera il valore della propriet� identificativoOP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificativoOP() {
        return identificativoOP;
    }

    /**
     * Imposta il valore della propriet� identificativoOP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificativoOP(String value) {
        this.identificativoOP = value;
    }

    /**
     * Recupera il valore della propriet� importoRecupero.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImportoRecupero() {
        return importoRecupero;
    }

    /**
     * Imposta il valore della propriet� importoRecupero.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImportoRecupero(BigDecimal value) {
        this.importoRecupero = value;
    }

    /**
     * Recupera il valore della propriet� numeroDispPagamento.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumeroDispPagamento() {
        return numeroDispPagamento;
    }

    /**
     * Imposta il valore della propriet� numeroDispPagamento.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumeroDispPagamento(BigInteger value) {
        this.numeroDispPagamento = value;
    }

}
