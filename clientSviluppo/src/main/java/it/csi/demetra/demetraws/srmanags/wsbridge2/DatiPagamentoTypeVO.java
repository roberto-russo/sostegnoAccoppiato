
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per datiPagamentoTypeVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="datiPagamentoTypeVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="annoCampagna" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="codiceCapitolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceDomanda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceSettore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceUO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cuaa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataDispPagamento" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" minOccurs="0"/>
 *         &lt;element name="importo" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
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
@XmlType(name = "datiPagamentoTypeVO", propOrder = {
    "annoCampagna",
    "codiceCapitolo",
    "codiceDomanda",
    "codiceSettore",
    "codiceUO",
    "cuaa",
    "dataDispPagamento",
    "importo",
    "numeroDispPagamento"
})
public class DatiPagamentoTypeVO {

    protected int annoCampagna;
    protected String codiceCapitolo;
    protected String codiceDomanda;
    protected String codiceSettore;
    protected String codiceUO;
    protected String cuaa;
    protected Object dataDispPagamento;
    protected BigDecimal importo;
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
     * Recupera il valore della propriet� codiceCapitolo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceCapitolo() {
        return codiceCapitolo;
    }

    /**
     * Imposta il valore della propriet� codiceCapitolo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceCapitolo(String value) {
        this.codiceCapitolo = value;
    }

    /**
     * Recupera il valore della propriet� codiceDomanda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceDomanda() {
        return codiceDomanda;
    }

    /**
     * Imposta il valore della propriet� codiceDomanda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceDomanda(String value) {
        this.codiceDomanda = value;
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
     * Recupera il valore della propriet� dataDispPagamento.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getDataDispPagamento() {
        return dataDispPagamento;
    }

    /**
     * Imposta il valore della propriet� dataDispPagamento.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setDataDispPagamento(Object value) {
        this.dataDispPagamento = value;
    }

    /**
     * Recupera il valore della propriet� importo.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getImporto() {
        return importo;
    }

    /**
     * Imposta il valore della propriet� importo.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setImporto(BigDecimal value) {
        this.importo = value;
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
