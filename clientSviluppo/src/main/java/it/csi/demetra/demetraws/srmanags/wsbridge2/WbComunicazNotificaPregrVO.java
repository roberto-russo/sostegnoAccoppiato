
package it.csi.demetra.demetraws.srmanags.wsbridge2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per wbComunicazNotificaPregrVO complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="wbComunicazNotificaPregrVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="anagrafica" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbAnagraficaNotificaVO" minOccurs="0"/>
 *         &lt;element name="chiusuraPricedimentoNotificaPregr" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbChiusuraProcedimentoNotificaPregrVO" minOccurs="0"/>
 *         &lt;element name="dataIdoneita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataPubblicazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataRilascio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="documentoGiustifNotificaPregr" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbDocumentoGiustificativoNotificaPregrVO" minOccurs="0"/>
 *         &lt;element name="protocolliEsterni" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbProtEsternoNotificaComunicazioneNotificaVO" minOccurs="0"/>
 *         &lt;element name="vSezioneAcquacoltura" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbSezioneAcquacolturaVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vSezioneContoTerzisti" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbSezioneContoTerzistiVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vSezioneImportatori" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbSezioneImportatoriVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vSezionePreparazione" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbSezionePreparazioneVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vSezioneStrutture" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbSezioneStruttureVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vSezioneTerritorio" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbSezioneTerritorioVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vSezioneZootecnia" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbSezioneZootecniaVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="vUnitaProduttive" type="{http://it/csi/smranags/wsbridge2/business/wsbridgefacade}wbUnitaProduttivaVO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wbComunicazNotificaPregrVO", propOrder = {
    "anagrafica",
    "chiusuraPricedimentoNotificaPregr",
    "dataIdoneita",
    "dataPubblicazione",
    "dataRilascio",
    "documentoGiustifNotificaPregr",
    "protocolliEsterni",
    "vSezioneAcquacoltura",
    "vSezioneContoTerzisti",
    "vSezioneImportatori",
    "vSezionePreparazione",
    "vSezioneStrutture",
    "vSezioneTerritorio",
    "vSezioneZootecnia",
    "vUnitaProduttive"
})
public class WbComunicazNotificaPregrVO {

    protected WbAnagraficaNotificaVO anagrafica;
    protected WbChiusuraProcedimentoNotificaPregrVO chiusuraPricedimentoNotificaPregr;
    protected String dataIdoneita;
    protected String dataPubblicazione;
    protected String dataRilascio;
    protected WbDocumentoGiustificativoNotificaPregrVO documentoGiustifNotificaPregr;
    protected WbProtEsternoNotificaComunicazioneNotificaVO protocolliEsterni;
    @XmlElement(nillable = true)
    protected List<WbSezioneAcquacolturaVO> vSezioneAcquacoltura;
    @XmlElement(nillable = true)
    protected List<WbSezioneContoTerzistiVO> vSezioneContoTerzisti;
    @XmlElement(nillable = true)
    protected List<WbSezioneImportatoriVO> vSezioneImportatori;
    @XmlElement(nillable = true)
    protected List<WbSezionePreparazioneVO> vSezionePreparazione;
    @XmlElement(nillable = true)
    protected List<WbSezioneStruttureVO> vSezioneStrutture;
    @XmlElement(nillable = true)
    protected List<WbSezioneTerritorioVO> vSezioneTerritorio;
    @XmlElement(nillable = true)
    protected List<WbSezioneZootecniaVO> vSezioneZootecnia;
    @XmlElement(nillable = true)
    protected List<WbUnitaProduttivaVO> vUnitaProduttive;

    /**
     * Recupera il valore della propriet� anagrafica.
     * 
     * @return
     *     possible object is
     *     {@link WbAnagraficaNotificaVO }
     *     
     */
    public WbAnagraficaNotificaVO getAnagrafica() {
        return anagrafica;
    }

    /**
     * Imposta il valore della propriet� anagrafica.
     * 
     * @param value
     *     allowed object is
     *     {@link WbAnagraficaNotificaVO }
     *     
     */
    public void setAnagrafica(WbAnagraficaNotificaVO value) {
        this.anagrafica = value;
    }

    /**
     * Recupera il valore della propriet� chiusuraPricedimentoNotificaPregr.
     * 
     * @return
     *     possible object is
     *     {@link WbChiusuraProcedimentoNotificaPregrVO }
     *     
     */
    public WbChiusuraProcedimentoNotificaPregrVO getChiusuraPricedimentoNotificaPregr() {
        return chiusuraPricedimentoNotificaPregr;
    }

    /**
     * Imposta il valore della propriet� chiusuraPricedimentoNotificaPregr.
     * 
     * @param value
     *     allowed object is
     *     {@link WbChiusuraProcedimentoNotificaPregrVO }
     *     
     */
    public void setChiusuraPricedimentoNotificaPregr(WbChiusuraProcedimentoNotificaPregrVO value) {
        this.chiusuraPricedimentoNotificaPregr = value;
    }

    /**
     * Recupera il valore della propriet� dataIdoneita.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataIdoneita() {
        return dataIdoneita;
    }

    /**
     * Imposta il valore della propriet� dataIdoneita.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataIdoneita(String value) {
        this.dataIdoneita = value;
    }

    /**
     * Recupera il valore della propriet� dataPubblicazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataPubblicazione() {
        return dataPubblicazione;
    }

    /**
     * Imposta il valore della propriet� dataPubblicazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataPubblicazione(String value) {
        this.dataPubblicazione = value;
    }

    /**
     * Recupera il valore della propriet� dataRilascio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataRilascio() {
        return dataRilascio;
    }

    /**
     * Imposta il valore della propriet� dataRilascio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataRilascio(String value) {
        this.dataRilascio = value;
    }

    /**
     * Recupera il valore della propriet� documentoGiustifNotificaPregr.
     * 
     * @return
     *     possible object is
     *     {@link WbDocumentoGiustificativoNotificaPregrVO }
     *     
     */
    public WbDocumentoGiustificativoNotificaPregrVO getDocumentoGiustifNotificaPregr() {
        return documentoGiustifNotificaPregr;
    }

    /**
     * Imposta il valore della propriet� documentoGiustifNotificaPregr.
     * 
     * @param value
     *     allowed object is
     *     {@link WbDocumentoGiustificativoNotificaPregrVO }
     *     
     */
    public void setDocumentoGiustifNotificaPregr(WbDocumentoGiustificativoNotificaPregrVO value) {
        this.documentoGiustifNotificaPregr = value;
    }

    /**
     * Recupera il valore della propriet� protocolliEsterni.
     * 
     * @return
     *     possible object is
     *     {@link WbProtEsternoNotificaComunicazioneNotificaVO }
     *     
     */
    public WbProtEsternoNotificaComunicazioneNotificaVO getProtocolliEsterni() {
        return protocolliEsterni;
    }

    /**
     * Imposta il valore della propriet� protocolliEsterni.
     * 
     * @param value
     *     allowed object is
     *     {@link WbProtEsternoNotificaComunicazioneNotificaVO }
     *     
     */
    public void setProtocolliEsterni(WbProtEsternoNotificaComunicazioneNotificaVO value) {
        this.protocolliEsterni = value;
    }

    /**
     * Gets the value of the vSezioneAcquacoltura property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vSezioneAcquacoltura property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVSezioneAcquacoltura().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WbSezioneAcquacolturaVO }
     * 
     * 
     */
    public List<WbSezioneAcquacolturaVO> getVSezioneAcquacoltura() {
        if (vSezioneAcquacoltura == null) {
            vSezioneAcquacoltura = new ArrayList<WbSezioneAcquacolturaVO>();
        }
        return this.vSezioneAcquacoltura;
    }

    /**
     * Gets the value of the vSezioneContoTerzisti property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vSezioneContoTerzisti property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVSezioneContoTerzisti().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WbSezioneContoTerzistiVO }
     * 
     * 
     */
    public List<WbSezioneContoTerzistiVO> getVSezioneContoTerzisti() {
        if (vSezioneContoTerzisti == null) {
            vSezioneContoTerzisti = new ArrayList<WbSezioneContoTerzistiVO>();
        }
        return this.vSezioneContoTerzisti;
    }

    /**
     * Gets the value of the vSezioneImportatori property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vSezioneImportatori property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVSezioneImportatori().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WbSezioneImportatoriVO }
     * 
     * 
     */
    public List<WbSezioneImportatoriVO> getVSezioneImportatori() {
        if (vSezioneImportatori == null) {
            vSezioneImportatori = new ArrayList<WbSezioneImportatoriVO>();
        }
        return this.vSezioneImportatori;
    }

    /**
     * Gets the value of the vSezionePreparazione property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vSezionePreparazione property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVSezionePreparazione().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WbSezionePreparazioneVO }
     * 
     * 
     */
    public List<WbSezionePreparazioneVO> getVSezionePreparazione() {
        if (vSezionePreparazione == null) {
            vSezionePreparazione = new ArrayList<WbSezionePreparazioneVO>();
        }
        return this.vSezionePreparazione;
    }

    /**
     * Gets the value of the vSezioneStrutture property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vSezioneStrutture property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVSezioneStrutture().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WbSezioneStruttureVO }
     * 
     * 
     */
    public List<WbSezioneStruttureVO> getVSezioneStrutture() {
        if (vSezioneStrutture == null) {
            vSezioneStrutture = new ArrayList<WbSezioneStruttureVO>();
        }
        return this.vSezioneStrutture;
    }

    /**
     * Gets the value of the vSezioneTerritorio property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vSezioneTerritorio property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVSezioneTerritorio().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WbSezioneTerritorioVO }
     * 
     * 
     */
    public List<WbSezioneTerritorioVO> getVSezioneTerritorio() {
        if (vSezioneTerritorio == null) {
            vSezioneTerritorio = new ArrayList<WbSezioneTerritorioVO>();
        }
        return this.vSezioneTerritorio;
    }

    /**
     * Gets the value of the vSezioneZootecnia property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vSezioneZootecnia property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVSezioneZootecnia().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WbSezioneZootecniaVO }
     * 
     * 
     */
    public List<WbSezioneZootecniaVO> getVSezioneZootecnia() {
        if (vSezioneZootecnia == null) {
            vSezioneZootecnia = new ArrayList<WbSezioneZootecniaVO>();
        }
        return this.vSezioneZootecnia;
    }

    /**
     * Gets the value of the vUnitaProduttive property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vUnitaProduttive property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVUnitaProduttive().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WbUnitaProduttivaVO }
     * 
     * 
     */
    public List<WbUnitaProduttivaVO> getVUnitaProduttive() {
        if (vUnitaProduttive == null) {
            vUnitaProduttive = new ArrayList<WbUnitaProduttivaVO>();
        }
        return this.vUnitaProduttive;
    }

}
