
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per iswsListaAnomalieAsrVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="iswsListaAnomalieAsrVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="anomalia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoAnomalia" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "iswsListaAnomalieAsrVO", propOrder = {
    "anomalia",
    "tipoAnomalia"
})
public class IswsListaAnomalieAsrVO {

    protected String anomalia;
    protected int tipoAnomalia;

    /**
     * Recupera il valore della propriet� anomalia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnomalia() {
        return anomalia;
    }

    /**
     * Imposta il valore della propriet� anomalia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnomalia(String value) {
        this.anomalia = value;
    }

    /**
     * Recupera il valore della propriet� tipoAnomalia.
     * 
     */
    public int getTipoAnomalia() {
        return tipoAnomalia;
    }

    /**
     * Imposta il valore della propriet� tipoAnomalia.
     * 
     */
    public void setTipoAnomalia(int value) {
        this.tipoAnomalia = value;
    }

}
