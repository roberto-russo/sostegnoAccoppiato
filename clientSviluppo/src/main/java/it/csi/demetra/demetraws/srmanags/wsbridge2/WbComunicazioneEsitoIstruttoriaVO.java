
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per wbComunicazioneEsitoIstruttoriaVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbComunicazioneEsitoIstruttoriaVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="esitoIstruttoria" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbEsitoIstruttoriaVO" minOccurs="0"/>
 *         &lt;element name="tipoOperazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wbComunicazioneEsitoIstruttoriaVO", propOrder = {
    "esitoIstruttoria",
    "tipoOperazione"
})
public class WbComunicazioneEsitoIstruttoriaVO {

    protected WbEsitoIstruttoriaVO esitoIstruttoria;
    protected String tipoOperazione;

    /**
     * Recupera il valore della propriet� esitoIstruttoria.
     * 
     * @return
     *     possible object is
     *     {@link WbEsitoIstruttoriaVO }
     *     
     */
    public WbEsitoIstruttoriaVO getEsitoIstruttoria() {
        return esitoIstruttoria;
    }

    /**
     * Imposta il valore della propriet� esitoIstruttoria.
     * 
     * @param value
     *     allowed object is
     *     {@link WbEsitoIstruttoriaVO }
     *     
     */
    public void setEsitoIstruttoria(WbEsitoIstruttoriaVO value) {
        this.esitoIstruttoria = value;
    }

    /**
     * Recupera il valore della propriet� tipoOperazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoOperazione() {
        return tipoOperazione;
    }

    /**
     * Imposta il valore della propriet� tipoOperazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoOperazione(String value) {
        this.tipoOperazione = value;
    }

}
