
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per wbConsultazioneIterAmministrativoVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbConsultazioneIterAmministrativoVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="iterAmministrativoVO" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbIterAmministrativoVO" minOccurs="0"/>
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
@XmlType(name = "wbConsultazioneIterAmministrativoVO", propOrder = {
    "iterAmministrativoVO",
    "tipoOperazione"
})
public class WbConsultazioneIterAmministrativoVO {

    protected WbIterAmministrativoVO iterAmministrativoVO;
    protected String tipoOperazione;

    /**
     * Recupera il valore della propriet� iterAmministrativoVO.
     * 
     * @return
     *     possible object is
     *     {@link WbIterAmministrativoVO }
     *     
     */
    public WbIterAmministrativoVO getIterAmministrativoVO() {
        return iterAmministrativoVO;
    }

    /**
     * Imposta il valore della propriet� iterAmministrativoVO.
     * 
     * @param value
     *     allowed object is
     *     {@link WbIterAmministrativoVO }
     *     
     */
    public void setIterAmministrativoVO(WbIterAmministrativoVO value) {
        this.iterAmministrativoVO = value;
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
