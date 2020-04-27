
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per recuperaRisultatoCompensazioniAsincroneVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="recuperaRisultatoCompensazioniAsincroneVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enteRichiedente" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idFornitura" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "recuperaRisultatoCompensazioniAsincroneVO", propOrder = {
    "enteRichiedente",
    "idFornitura"
})
public class RecuperaRisultatoCompensazioniAsincroneVO {

    protected int enteRichiedente;
    protected int idFornitura;

    /**
     * Recupera il valore della propriet� enteRichiedente.
     * 
     */
    public int getEnteRichiedente() {
        return enteRichiedente;
    }

    /**
     * Imposta il valore della propriet� enteRichiedente.
     * 
     */
    public void setEnteRichiedente(int value) {
        this.enteRichiedente = value;
    }

    /**
     * Recupera il valore della propriet� idFornitura.
     * 
     */
    public int getIdFornitura() {
        return idFornitura;
    }

    /**
     * Imposta il valore della propriet� idFornitura.
     * 
     */
    public void setIdFornitura(int value) {
        this.idFornitura = value;
    }

}
