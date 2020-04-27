
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per annullamentoCompensazioneRispostaVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="annullamentoCompensazioneRispostaVO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}responseVO">
 *       &lt;sequence>
 *         &lt;element name="numCompensazioniAnnullate" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "annullamentoCompensazioneRispostaVO", propOrder = {
    "numCompensazioniAnnullate"
})
public class AnnullamentoCompensazioneRispostaVO
    extends ResponseVO
{

    protected int numCompensazioniAnnullate;

    /**
     * Recupera il valore della propriet� numCompensazioniAnnullate.
     * 
     */
    public int getNumCompensazioniAnnullate() {
        return numCompensazioniAnnullate;
    }

    /**
     * Imposta il valore della propriet� numCompensazioniAnnullate.
     * 
     */
    public void setNumCompensazioniAnnullate(int value) {
        this.numCompensazioniAnnullate = value;
    }

}
