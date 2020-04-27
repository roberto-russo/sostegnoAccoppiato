
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per response complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codRet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codiceErrore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descrizioneErrore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="esito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="giacDichiarazioniVO" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}giacDichiarazioniVO" minOccurs="0"/>
 *         &lt;element name="info" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="msgRet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="requestXml" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoOutput" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trovaFascicolo" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}trovaFascicolo" minOccurs="0"/>
 *         &lt;element name="warning" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vAGEAInfoSelAnomalia" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}ageaInfoSelAnomaliaVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vAnagAllevamenti" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbAnagraficaAllevamentoVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vCapi" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}capo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vCapiMacellati" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}capoMacellato" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vCapiOvicaprini" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}capoOvicaprino" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vCapiVacche" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}capoVacca" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vConsistenzaAllevamento" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbConsistenzaAllevamentoVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vConsistenzaPascolo" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbConsistenzaPascoloVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vConsistenzaPascoloPAC2015" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbConsistenzaPascoloPAC2015VO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vConsistenzaStatAllevamento" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbConsistenzaStatAllevamentoVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vEsito" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbEsitoInvioVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vEsitoDomanda" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbEsitoDomanda" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vOviniInOutPascolo" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbOviniInOutPascoloVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vQuoteLatte" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbQuoteLatte" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vRegistriPascoli" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbRegistriPascoliVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vResponseForCUAASIANVO" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}responseForCUAASIANVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vStabilimenti" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}stabilimentoVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vTicket" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vTitoloAggregatoPAC2015" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}titoloAggregatoPAC2015" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vTitoloPAC2015" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}titoloPAC2015" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vTrovaPascoloPAC2015" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbPascoloVisitatoVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vUbaCensimentoOvino2012" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbUbaCensimentoOvino2012VO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vUbaConsistenzaOvini" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbUbaConsistenzaOviniVO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response", propOrder = {
    "codRet",
    "codiceErrore",
    "descrizioneErrore",
    "esito",
    "giacDichiarazioniVO",
    "info",
    "msgRet",
    "requestXml",
    "tipoOutput",
    "trovaFascicolo",
    "warning",
    "vageaInfoSelAnomalia",
    "vAnagAllevamenti",
    "vCapi",
    "vCapiMacellati",
    "vCapiOvicaprini",
    "vCapiVacche",
    "vConsistenzaAllevamento",
    "vConsistenzaPascolo",
    "vConsistenzaPascoloPAC2015",
    "vConsistenzaStatAllevamento",
    "vEsito",
    "vEsitoDomanda",
    "vOviniInOutPascolo",
    "vQuoteLatte",
    "vRegistriPascoli",
    "vResponseForCUAASIANVO",
    "vStabilimenti",
    "vTicket",
    "vTitoloAggregatoPAC2015",
    "vTitoloPAC2015",
    "vTrovaPascoloPAC2015",
    "vUbaCensimentoOvino2012",
    "vUbaConsistenzaOvini"
})
public class Response {

    protected String codRet;
    protected String codiceErrore;
    protected String descrizioneErrore;
    protected String esito;
    protected GiacDichiarazioniVO giacDichiarazioniVO;
    protected String info;
    protected String msgRet;
    protected String requestXml;
    protected String tipoOutput;
    protected TrovaFascicolo trovaFascicolo;
    protected String warning;
    @XmlElement(name = "vAGEAInfoSelAnomalia", nillable = true)
    protected List<AgeaInfoSelAnomaliaVO> vageaInfoSelAnomalia;
    @XmlElement(nillable = true)
    protected List<WbAnagraficaAllevamentoVO> vAnagAllevamenti;
    @XmlElement(nillable = true)
    protected List<Capo> vCapi;
    @XmlElement(nillable = true)
    protected List<CapoMacellato> vCapiMacellati;
    @XmlElement(nillable = true)
    protected List<CapoOvicaprino> vCapiOvicaprini;
    @XmlElement(nillable = true)
    protected List<CapoVacca> vCapiVacche;
    @XmlElement(nillable = true)
    protected List<WbConsistenzaAllevamentoVO> vConsistenzaAllevamento;
    @XmlElement(nillable = true)
    protected List<WbConsistenzaPascoloVO> vConsistenzaPascolo;
    @XmlElement(nillable = true)
    protected List<WbConsistenzaPascoloPAC2015VO> vConsistenzaPascoloPAC2015;
    @XmlElement(nillable = true)
    protected List<WbConsistenzaStatAllevamentoVO> vConsistenzaStatAllevamento;
    @XmlElement(nillable = true)
    protected List<WbEsitoInvioVO> vEsito;
    @XmlElement(nillable = true)
    protected List<WbEsitoDomanda> vEsitoDomanda;
    @XmlElement(nillable = true)
    protected List<WbOviniInOutPascoloVO> vOviniInOutPascolo;
    @XmlElement(nillable = true)
    protected List<WbQuoteLatte> vQuoteLatte;
    @XmlElement(nillable = true)
    protected List<WbRegistriPascoliVO> vRegistriPascoli;
    @XmlElement(nillable = true)
    protected List<ResponseForCUAASIANVO> vResponseForCUAASIANVO;
    @XmlElement(nillable = true)
    protected List<StabilimentoVO> vStabilimenti;
    @XmlElement(nillable = true)
    protected List<String> vTicket;
    @XmlElement(nillable = true)
    protected List<TitoloAggregatoPAC2015> vTitoloAggregatoPAC2015;
    @XmlElement(nillable = true)
    protected List<TitoloPAC2015> vTitoloPAC2015;
    @XmlElement(nillable = true)
    protected List<WbPascoloVisitatoVO> vTrovaPascoloPAC2015;
    @XmlElement(nillable = true)
    protected List<WbUbaCensimentoOvino2012VO> vUbaCensimentoOvino2012;
    @XmlElement(nillable = true)
    protected List<WbUbaConsistenzaOviniVO> vUbaConsistenzaOvini;

    /**
     * Recupera il valore della propriet� codRet.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodRet() {
        return codRet;
    }

    /**
     * Imposta il valore della propriet� codRet.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodRet(String value) {
        this.codRet = value;
    }

    /**
     * Recupera il valore della propriet� codiceErrore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceErrore() {
        return codiceErrore;
    }

    /**
     * Imposta il valore della propriet� codiceErrore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceErrore(String value) {
        this.codiceErrore = value;
    }

    /**
     * Recupera il valore della propriet� descrizioneErrore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescrizioneErrore() {
        return descrizioneErrore;
    }

    /**
     * Imposta il valore della propriet� descrizioneErrore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescrizioneErrore(String value) {
        this.descrizioneErrore = value;
    }

    /**
     * Recupera il valore della propriet� esito.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEsito() {
        return esito;
    }

    /**
     * Imposta il valore della propriet� esito.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEsito(String value) {
        this.esito = value;
    }

    /**
     * Recupera il valore della propriet� giacDichiarazioniVO.
     * 
     * @return
     *     possible object is
     *     {@link GiacDichiarazioniVO }
     *     
     */
    public GiacDichiarazioniVO getGiacDichiarazioniVO() {
        return giacDichiarazioniVO;
    }

    /**
     * Imposta il valore della propriet� giacDichiarazioniVO.
     * 
     * @param value
     *     allowed object is
     *     {@link GiacDichiarazioniVO }
     *     
     */
    public void setGiacDichiarazioniVO(GiacDichiarazioniVO value) {
        this.giacDichiarazioniVO = value;
    }

    /**
     * Recupera il valore della propriet� info.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfo() {
        return info;
    }

    /**
     * Imposta il valore della propriet� info.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfo(String value) {
        this.info = value;
    }

    /**
     * Recupera il valore della propriet� msgRet.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgRet() {
        return msgRet;
    }

    /**
     * Imposta il valore della propriet� msgRet.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgRet(String value) {
        this.msgRet = value;
    }

    /**
     * Recupera il valore della propriet� requestXml.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestXml() {
        return requestXml;
    }

    /**
     * Imposta il valore della propriet� requestXml.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestXml(String value) {
        this.requestXml = value;
    }

    /**
     * Recupera il valore della propriet� tipoOutput.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoOutput() {
        return tipoOutput;
    }

    /**
     * Imposta il valore della propriet� tipoOutput.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoOutput(String value) {
        this.tipoOutput = value;
    }

    /**
     * Recupera il valore della propriet� trovaFascicolo.
     * 
     * @return
     *     possible object is
     *     {@link TrovaFascicolo }
     *     
     */
    public TrovaFascicolo getTrovaFascicolo() {
        return trovaFascicolo;
    }

    /**
     * Imposta il valore della propriet� trovaFascicolo.
     * 
     * @param value
     *     allowed object is
     *     {@link TrovaFascicolo }
     *     
     */
    public void setTrovaFascicolo(TrovaFascicolo value) {
        this.trovaFascicolo = value;
    }

    /**
     * Recupera il valore della propriet� warning.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWarning() {
        return warning;
    }

    /**
     * Imposta il valore della propriet� warning.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWarning(String value) {
        this.warning = value;
    }

    /**
     * Gets the value of the vageaInfoSelAnomalia property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vageaInfoSelAnomalia property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVAGEAInfoSelAnomalia().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AgeaInfoSelAnomaliaVO }
     * 
     * 
     */
    public List<AgeaInfoSelAnomaliaVO> getVAGEAInfoSelAnomalia() {
        if (vageaInfoSelAnomalia == null) {
            vageaInfoSelAnomalia = new ArrayList<AgeaInfoSelAnomaliaVO>();
        }
        return this.vageaInfoSelAnomalia;
    }

    /**
     * Gets the value of the vAnagAllevamenti property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vAnagAllevamenti property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVAnagAllevamenti().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WbAnagraficaAllevamentoVO }
     * 
     * 
     */
    public List<WbAnagraficaAllevamentoVO> getVAnagAllevamenti() {
        if (vAnagAllevamenti == null) {
            vAnagAllevamenti = new ArrayList<WbAnagraficaAllevamentoVO>();
        }
        return this.vAnagAllevamenti;
    }

    /**
     * Gets the value of the vCapi property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vCapi property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVCapi().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Capo }
     * 
     * 
     */
    public List<Capo> getVCapi() {
        if (vCapi == null) {
            vCapi = new ArrayList<Capo>();
        }
        return this.vCapi;
    }

    /**
     * Gets the value of the vCapiMacellati property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vCapiMacellati property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVCapiMacellati().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CapoMacellato }
     * 
     * 
     */
    public List<CapoMacellato> getVCapiMacellati() {
        if (vCapiMacellati == null) {
            vCapiMacellati = new ArrayList<CapoMacellato>();
        }
        return this.vCapiMacellati;
    }

    /**
     * Gets the value of the vCapiOvicaprini property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vCapiOvicaprini property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVCapiOvicaprini().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CapoOvicaprino }
     * 
     * 
     */
    public List<CapoOvicaprino> getVCapiOvicaprini() {
        if (vCapiOvicaprini == null) {
            vCapiOvicaprini = new ArrayList<CapoOvicaprino>();
        }
        return this.vCapiOvicaprini;
    }

    /**
     * Gets the value of the vCapiVacche property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vCapiVacche property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVCapiVacche().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CapoVacca }
     * 
     * 
     */
    public List<CapoVacca> getVCapiVacche() {
        if (vCapiVacche == null) {
            vCapiVacche = new ArrayList<CapoVacca>();
        }
        return this.vCapiVacche;
    }

    /**
     * Gets the value of the vConsistenzaAllevamento property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vConsistenzaAllevamento property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVConsistenzaAllevamento().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WbConsistenzaAllevamentoVO }
     * 
     * 
     */
    public List<WbConsistenzaAllevamentoVO> getVConsistenzaAllevamento() {
        if (vConsistenzaAllevamento == null) {
            vConsistenzaAllevamento = new ArrayList<WbConsistenzaAllevamentoVO>();
        }
        return this.vConsistenzaAllevamento;
    }

    /**
     * Gets the value of the vConsistenzaPascolo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vConsistenzaPascolo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVConsistenzaPascolo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WbConsistenzaPascoloVO }
     * 
     * 
     */
    public List<WbConsistenzaPascoloVO> getVConsistenzaPascolo() {
        if (vConsistenzaPascolo == null) {
            vConsistenzaPascolo = new ArrayList<WbConsistenzaPascoloVO>();
        }
        return this.vConsistenzaPascolo;
    }

    /**
     * Gets the value of the vConsistenzaPascoloPAC2015 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vConsistenzaPascoloPAC2015 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVConsistenzaPascoloPAC2015().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WbConsistenzaPascoloPAC2015VO }
     * 
     * 
     */
    public List<WbConsistenzaPascoloPAC2015VO> getVConsistenzaPascoloPAC2015() {
        if (vConsistenzaPascoloPAC2015 == null) {
            vConsistenzaPascoloPAC2015 = new ArrayList<WbConsistenzaPascoloPAC2015VO>();
        }
        return this.vConsistenzaPascoloPAC2015;
    }

    /**
     * Gets the value of the vConsistenzaStatAllevamento property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vConsistenzaStatAllevamento property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVConsistenzaStatAllevamento().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WbConsistenzaStatAllevamentoVO }
     * 
     * 
     */
    public List<WbConsistenzaStatAllevamentoVO> getVConsistenzaStatAllevamento() {
        if (vConsistenzaStatAllevamento == null) {
            vConsistenzaStatAllevamento = new ArrayList<WbConsistenzaStatAllevamentoVO>();
        }
        return this.vConsistenzaStatAllevamento;
    }

    /**
     * Gets the value of the vEsito property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vEsito property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVEsito().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WbEsitoInvioVO }
     * 
     * 
     */
    public List<WbEsitoInvioVO> getVEsito() {
        if (vEsito == null) {
            vEsito = new ArrayList<WbEsitoInvioVO>();
        }
        return this.vEsito;
    }

    /**
     * Gets the value of the vEsitoDomanda property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vEsitoDomanda property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVEsitoDomanda().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WbEsitoDomanda }
     * 
     * 
     */
    public List<WbEsitoDomanda> getVEsitoDomanda() {
        if (vEsitoDomanda == null) {
            vEsitoDomanda = new ArrayList<WbEsitoDomanda>();
        }
        return this.vEsitoDomanda;
    }

    /**
     * Gets the value of the vOviniInOutPascolo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vOviniInOutPascolo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVOviniInOutPascolo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WbOviniInOutPascoloVO }
     * 
     * 
     */
    public List<WbOviniInOutPascoloVO> getVOviniInOutPascolo() {
        if (vOviniInOutPascolo == null) {
            vOviniInOutPascolo = new ArrayList<WbOviniInOutPascoloVO>();
        }
        return this.vOviniInOutPascolo;
    }

    /**
     * Gets the value of the vQuoteLatte property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vQuoteLatte property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVQuoteLatte().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WbQuoteLatte }
     * 
     * 
     */
    public List<WbQuoteLatte> getVQuoteLatte() {
        if (vQuoteLatte == null) {
            vQuoteLatte = new ArrayList<WbQuoteLatte>();
        }
        return this.vQuoteLatte;
    }

    /**
     * Gets the value of the vRegistriPascoli property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vRegistriPascoli property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVRegistriPascoli().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WbRegistriPascoliVO }
     * 
     * 
     */
    public List<WbRegistriPascoliVO> getVRegistriPascoli() {
        if (vRegistriPascoli == null) {
            vRegistriPascoli = new ArrayList<WbRegistriPascoliVO>();
        }
        return this.vRegistriPascoli;
    }

    /**
     * Gets the value of the vResponseForCUAASIANVO property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vResponseForCUAASIANVO property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVResponseForCUAASIANVO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResponseForCUAASIANVO }
     * 
     * 
     */
    public List<ResponseForCUAASIANVO> getVResponseForCUAASIANVO() {
        if (vResponseForCUAASIANVO == null) {
            vResponseForCUAASIANVO = new ArrayList<ResponseForCUAASIANVO>();
        }
        return this.vResponseForCUAASIANVO;
    }

    /**
     * Gets the value of the vStabilimenti property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vStabilimenti property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVStabilimenti().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StabilimentoVO }
     * 
     * 
     */
    public List<StabilimentoVO> getVStabilimenti() {
        if (vStabilimenti == null) {
            vStabilimenti = new ArrayList<StabilimentoVO>();
        }
        return this.vStabilimenti;
    }

    /**
     * Gets the value of the vTicket property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vTicket property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVTicket().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getVTicket() {
        if (vTicket == null) {
            vTicket = new ArrayList<String>();
        }
        return this.vTicket;
    }

    /**
     * Gets the value of the vTitoloAggregatoPAC2015 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vTitoloAggregatoPAC2015 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVTitoloAggregatoPAC2015().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TitoloAggregatoPAC2015 }
     * 
     * 
     */
    public List<TitoloAggregatoPAC2015> getVTitoloAggregatoPAC2015() {
        if (vTitoloAggregatoPAC2015 == null) {
            vTitoloAggregatoPAC2015 = new ArrayList<TitoloAggregatoPAC2015>();
        }
        return this.vTitoloAggregatoPAC2015;
    }

    /**
     * Gets the value of the vTitoloPAC2015 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vTitoloPAC2015 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVTitoloPAC2015().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TitoloPAC2015 }
     * 
     * 
     */
    public List<TitoloPAC2015> getVTitoloPAC2015() {
        if (vTitoloPAC2015 == null) {
            vTitoloPAC2015 = new ArrayList<TitoloPAC2015>();
        }
        return this.vTitoloPAC2015;
    }

    /**
     * Gets the value of the vTrovaPascoloPAC2015 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vTrovaPascoloPAC2015 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVTrovaPascoloPAC2015().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WbPascoloVisitatoVO }
     * 
     * 
     */
    public List<WbPascoloVisitatoVO> getVTrovaPascoloPAC2015() {
        if (vTrovaPascoloPAC2015 == null) {
            vTrovaPascoloPAC2015 = new ArrayList<WbPascoloVisitatoVO>();
        }
        return this.vTrovaPascoloPAC2015;
    }

    /**
     * Gets the value of the vUbaCensimentoOvino2012 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vUbaCensimentoOvino2012 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVUbaCensimentoOvino2012().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WbUbaCensimentoOvino2012VO }
     * 
     * 
     */
    public List<WbUbaCensimentoOvino2012VO> getVUbaCensimentoOvino2012() {
        if (vUbaCensimentoOvino2012 == null) {
            vUbaCensimentoOvino2012 = new ArrayList<WbUbaCensimentoOvino2012VO>();
        }
        return this.vUbaCensimentoOvino2012;
    }

    /**
     * Gets the value of the vUbaConsistenzaOvini property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vUbaConsistenzaOvini property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVUbaConsistenzaOvini().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WbUbaConsistenzaOviniVO }
     * 
     * 
     */
    public List<WbUbaConsistenzaOviniVO> getVUbaConsistenzaOvini() {
        if (vUbaConsistenzaOvini == null) {
            vUbaConsistenzaOvini = new ArrayList<WbUbaConsistenzaOviniVO>();
        }
        return this.vUbaConsistenzaOvini;
    }

}
