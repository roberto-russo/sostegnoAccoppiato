
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per verificaCompensazioneRispostaVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="verificaCompensazioneRispostaVO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}responseVO">
 *       &lt;sequence>
 *         &lt;element name="listaCompensazioni" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}compensazioneVO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "verificaCompensazioneRispostaVO", propOrder = {
    "listaCompensazioni"
})
public class VerificaCompensazioneRispostaVO
    extends ResponseVO
{

    @XmlElement(nillable = true)
    protected List<CompensazioneVO> listaCompensazioni;

    /**
     * Gets the value of the listaCompensazioni property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaCompensazioni property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaCompensazioni().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CompensazioneVO }
     * 
     * 
     */
    public List<CompensazioneVO> getListaCompensazioni() {
        if (listaCompensazioni == null) {
            listaCompensazioni = new ArrayList<CompensazioneVO>();
        }
        return this.listaCompensazioni;
    }

}
