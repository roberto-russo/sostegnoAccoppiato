
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per giacDichiarazioniVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="giacDichiarazioniVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="altriMosti" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}qtaDichGiacenzaVO" minOccurs="0"/>
 *         &lt;element name="mostoConcentrato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="mostoConcentratoRettificato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="vinoDop" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}qtaDichGiacenzaVO" minOccurs="0"/>
 *         &lt;element name="vinoIgp" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}qtaDichGiacenzaVO" minOccurs="0"/>
 *         &lt;element name="vinoTavola" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}qtaDichGiacenzaVO" minOccurs="0"/>
 *         &lt;element name="vinoVarietale" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}qtaDichGiacenzaVO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "giacDichiarazioniVO", propOrder = {
    "altriMosti",
    "mostoConcentrato",
    "mostoConcentratoRettificato",
    "vinoDop",
    "vinoIgp",
    "vinoTavola",
    "vinoVarietale"
})
public class GiacDichiarazioniVO {

    protected QtaDichGiacenzaVO altriMosti;
    protected BigDecimal mostoConcentrato;
    protected BigDecimal mostoConcentratoRettificato;
    protected QtaDichGiacenzaVO vinoDop;
    protected QtaDichGiacenzaVO vinoIgp;
    protected QtaDichGiacenzaVO vinoTavola;
    protected QtaDichGiacenzaVO vinoVarietale;

    /**
     * Recupera il valore della propriet� altriMosti.
     * 
     * @return
     *     possible object is
     *     {@link QtaDichGiacenzaVO }
     *     
     */
    public QtaDichGiacenzaVO getAltriMosti() {
        return altriMosti;
    }

    /**
     * Imposta il valore della propriet� altriMosti.
     * 
     * @param value
     *     allowed object is
     *     {@link QtaDichGiacenzaVO }
     *     
     */
    public void setAltriMosti(QtaDichGiacenzaVO value) {
        this.altriMosti = value;
    }

    /**
     * Recupera il valore della propriet� mostoConcentrato.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMostoConcentrato() {
        return mostoConcentrato;
    }

    /**
     * Imposta il valore della propriet� mostoConcentrato.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMostoConcentrato(BigDecimal value) {
        this.mostoConcentrato = value;
    }

    /**
     * Recupera il valore della propriet� mostoConcentratoRettificato.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMostoConcentratoRettificato() {
        return mostoConcentratoRettificato;
    }

    /**
     * Imposta il valore della propriet� mostoConcentratoRettificato.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMostoConcentratoRettificato(BigDecimal value) {
        this.mostoConcentratoRettificato = value;
    }

    /**
     * Recupera il valore della propriet� vinoDop.
     * 
     * @return
     *     possible object is
     *     {@link QtaDichGiacenzaVO }
     *     
     */
    public QtaDichGiacenzaVO getVinoDop() {
        return vinoDop;
    }

    /**
     * Imposta il valore della propriet� vinoDop.
     * 
     * @param value
     *     allowed object is
     *     {@link QtaDichGiacenzaVO }
     *     
     */
    public void setVinoDop(QtaDichGiacenzaVO value) {
        this.vinoDop = value;
    }

    /**
     * Recupera il valore della propriet� vinoIgp.
     * 
     * @return
     *     possible object is
     *     {@link QtaDichGiacenzaVO }
     *     
     */
    public QtaDichGiacenzaVO getVinoIgp() {
        return vinoIgp;
    }

    /**
     * Imposta il valore della propriet� vinoIgp.
     * 
     * @param value
     *     allowed object is
     *     {@link QtaDichGiacenzaVO }
     *     
     */
    public void setVinoIgp(QtaDichGiacenzaVO value) {
        this.vinoIgp = value;
    }

    /**
     * Recupera il valore della propriet� vinoTavola.
     * 
     * @return
     *     possible object is
     *     {@link QtaDichGiacenzaVO }
     *     
     */
    public QtaDichGiacenzaVO getVinoTavola() {
        return vinoTavola;
    }

    /**
     * Imposta il valore della propriet� vinoTavola.
     * 
     * @param value
     *     allowed object is
     *     {@link QtaDichGiacenzaVO }
     *     
     */
    public void setVinoTavola(QtaDichGiacenzaVO value) {
        this.vinoTavola = value;
    }

    /**
     * Recupera il valore della propriet� vinoVarietale.
     * 
     * @return
     *     possible object is
     *     {@link QtaDichGiacenzaVO }
     *     
     */
    public QtaDichGiacenzaVO getVinoVarietale() {
        return vinoVarietale;
    }

    /**
     * Imposta il valore della propriet� vinoVarietale.
     * 
     * @param value
     *     allowed object is
     *     {@link QtaDichGiacenzaVO }
     *     
     */
    public void setVinoVarietale(QtaDichGiacenzaVO value) {
        this.vinoVarietale = value;
    }

}
