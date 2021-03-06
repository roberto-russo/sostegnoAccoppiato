
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per disposizionePagamentoVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="disposizionePagamentoVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="annoCampagna" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="codiceSettore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceUO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="identificativoOP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "disposizionePagamentoVO", propOrder = {
    "annoCampagna",
    "codiceSettore",
    "codiceUO",
    "identificativoOP",
    "numeroDispPagamento"
})
public class DisposizionePagamentoVO {

    protected int annoCampagna;
    protected String codiceSettore;
    protected String codiceUO;
    protected String identificativoOP;
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
