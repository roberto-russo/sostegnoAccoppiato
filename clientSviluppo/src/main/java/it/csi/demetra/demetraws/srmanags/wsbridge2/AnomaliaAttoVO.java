
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per anomaliaAttoVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="anomaliaAttoVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dataFineVal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataInizioVal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoAnomalia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="valoAnomalia" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "anomaliaAttoVO", propOrder = {
    "dataFineVal",
    "dataInizioVal",
    "tipoAnomalia",
    "valoAnomalia"
})
public class AnomaliaAttoVO {

    protected String dataFineVal;
    protected String dataInizioVal;
    protected String tipoAnomalia;
    protected int valoAnomalia;

    /**
     * Recupera il valore della propriet� dataFineVal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataFineVal() {
        return dataFineVal;
    }

    /**
     * Imposta il valore della propriet� dataFineVal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataFineVal(String value) {
        this.dataFineVal = value;
    }

    /**
     * Recupera il valore della propriet� dataInizioVal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataInizioVal() {
        return dataInizioVal;
    }

    /**
     * Imposta il valore della propriet� dataInizioVal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataInizioVal(String value) {
        this.dataInizioVal = value;
    }

    /**
     * Recupera il valore della propriet� tipoAnomalia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoAnomalia() {
        return tipoAnomalia;
    }

    /**
     * Imposta il valore della propriet� tipoAnomalia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoAnomalia(String value) {
        this.tipoAnomalia = value;
    }

    /**
     * Recupera il valore della propriet� valoAnomalia.
     * 
     */
    public int getValoAnomalia() {
        return valoAnomalia;
    }

    /**
     * Imposta il valore della propriet� valoAnomalia.
     * 
     */
    public void setValoAnomalia(int value) {
        this.valoAnomalia = value;
    }

}
