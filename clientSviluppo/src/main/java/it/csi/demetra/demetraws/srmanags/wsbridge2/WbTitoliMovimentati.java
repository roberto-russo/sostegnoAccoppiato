
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per wbTitoliMovimentati complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbTitoliMovimentati">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CUAATerzoSoggetto" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbcuaaTerzoSoggetto" minOccurs="0"/>
 *         &lt;element name="dataScadenzaAffitto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="primoIdentificativo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="superficieUBA" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="ultimoIdentificativo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wbTitoliMovimentati", propOrder = {
    "cuaaTerzoSoggetto",
    "dataScadenzaAffitto",
    "primoIdentificativo",
    "superficieUBA",
    "ultimoIdentificativo"
})
public class WbTitoliMovimentati {

    @XmlElement(name = "CUAATerzoSoggetto")
    protected WbcuaaTerzoSoggetto cuaaTerzoSoggetto;
    protected String dataScadenzaAffitto;
    protected String primoIdentificativo;
    protected BigDecimal superficieUBA;
    protected String ultimoIdentificativo;

    /**
     * Recupera il valore della propriet� cuaaTerzoSoggetto.
     * 
     * @return
     *     possible object is
     *     {@link WbcuaaTerzoSoggetto }
     *     
     */
    public WbcuaaTerzoSoggetto getCUAATerzoSoggetto() {
        return cuaaTerzoSoggetto;
    }

    /**
     * Imposta il valore della propriet� cuaaTerzoSoggetto.
     * 
     * @param value
     *     allowed object is
     *     {@link WbcuaaTerzoSoggetto }
     *     
     */
    public void setCUAATerzoSoggetto(WbcuaaTerzoSoggetto value) {
        this.cuaaTerzoSoggetto = value;
    }

    /**
     * Recupera il valore della propriet� dataScadenzaAffitto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataScadenzaAffitto() {
        return dataScadenzaAffitto;
    }

    /**
     * Imposta il valore della propriet� dataScadenzaAffitto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataScadenzaAffitto(String value) {
        this.dataScadenzaAffitto = value;
    }

    /**
     * Recupera il valore della propriet� primoIdentificativo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimoIdentificativo() {
        return primoIdentificativo;
    }

    /**
     * Imposta il valore della propriet� primoIdentificativo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimoIdentificativo(String value) {
        this.primoIdentificativo = value;
    }

    /**
     * Recupera il valore della propriet� superficieUBA.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSuperficieUBA() {
        return superficieUBA;
    }

    /**
     * Imposta il valore della propriet� superficieUBA.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSuperficieUBA(BigDecimal value) {
        this.superficieUBA = value;
    }

    /**
     * Recupera il valore della propriet� ultimoIdentificativo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUltimoIdentificativo() {
        return ultimoIdentificativo;
    }

    /**
     * Imposta il valore della propriet� ultimoIdentificativo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUltimoIdentificativo(String value) {
        this.ultimoIdentificativo = value;
    }

}
