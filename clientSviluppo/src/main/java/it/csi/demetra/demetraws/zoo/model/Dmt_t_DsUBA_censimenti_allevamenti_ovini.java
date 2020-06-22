package it.csi.demetra.demetraws.zoo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;


@Entity
@Table(name = "DMT_T_UBA_CENSIM_ALLEV_OVINI")
public class Dmt_t_DsUBA_censimenti_allevamenti_ovini implements Serializable {

	private static final long serialVersionUID = 624599232395935059L;

	
    @Id
    @GeneratedValue(generator = "seq_dmt_t_uba_cens_allev_ov")
    @SequenceGenerator(name="seq_dmt_t_uba_cens_allev_ov",sequenceName="SEQ_DMT_T_UBA_CENS_ALLEV_OV", allocationSize=1)
    @Column(name= "id_autogenerato")
    private Long idAutogenerato;
	
	
	@ManyToOne
	@JoinColumn(name = "idSessione", nullable = false)
	 /**
     * id univoco associato all'istanza di sessione.
     */
	private Dmt_t_sessione idSessione;
	
	@Column(name = "censimento_id")
	@NotNull
	/**
	 * Identificativo univoco in BDN del censimento
	 */
	private BigDecimal censimentoId;

	@Column(name = "p_allev_id")
	@NotNull
	/**
	 * Identificativo univoco in BDN dell’allevamento 
	 */
	private BigDecimal pAllevId;

	@Column(name = "azienda_codice")
	/**
	 * Codice aziendale assegnato all’allevamento
	 */
	private String aziendaCodice;

	@Column(name = "cod_fiscale_prop")
	/**
	 * Codice fiscale della persona fisica o giuridica che
	 * risulta proprietario degli animali presenti in allevamento
	 */
	private String codFiscaleProp;

	@Column(name = "cod_fiscale_dete")
	/**
	 * Codice fiscale della persona fisica o giuridica che
	 * risulta detentore degli animali presenti in allevamento
	 */
	private String codFiscaleDete;

	@Column(name = "specie_codice")
	/**
	 * Codice della specie allevata
	 */
	private String specieCodice;

	@Column(name = "specie_descrizione")
	/**
	 * Descrizione della specie allevata
	 */
	private String specieDescrizione;

	@Column(name = "data_inizio_periodo")
	@Temporal(TemporalType.DATE)
	/**
	 * Data di inizio del periodo considerato (tiene conto
	 * della data fornita in input e della data di inizio attività
	 * dell’allevamento)
	 */
	private Date dataInizioPeriodo;

	@Column(name = "data_fine_periodo")
	@Temporal(TemporalType.DATE)
	/**
	 * Data di fine del periodo considerato (tiene conto
	 * della data fornita in input ed eventualmente della
	 * data di fine attività dell’allevamento)
	 */
	private Date dataFinePeriodo;

	@Column(name = "o_maschi_adulti")
	/**
	 * Numero ovini maschi adulti (oltre 12 mesi)
	 */
	private BigDecimal oMaschiAdulti;

	@Column(name = "o_maschi_adulti_lib")
	/**
	 * Numero ovini maschi adulti (oltre 12 mesi) iscritti a libro
	 */
	private BigDecimal oMaschiAdultiLib;

	@Column(name = "o_femmine_adulte")
	/**
	 * Numero ovini femmine adulte (oltre 12 mesi)
	 */
	private BigDecimal oFemmineAdulte;

	@Column(name = "o_femmine_adulte_lib")
	/**
	 * Numero ovini femmine adulte (oltre 12 mesi) iscritte a libro
	 */
	private BigDecimal oFemmineAdulteLib;

	@Column(name = "o_maschi_rimonta")
	/**
	 * Numero ovini maschi della quota di rimonta
	 */
	private BigDecimal oMaschiRimonta;

	@Column(name = "o_maschi_rimonta_lib")
	/**
	 * Numero ovini maschi della quota di rimonta iscritti a libro
	 */
	private BigDecimal oMaschiRimontaLib;

	@Column(name = "o_femmine_rimonta")
	/**
	 * Numero femmine della quota di rimonta
	 */
	private BigDecimal oFemmineRimonta;

	@Column(name = "o_femmine_rimonta_lib")
	/**
	 * Numero femmine della quota di rimonta iscritte a libro
	 */
	private BigDecimal oFemmineRimontaLib;

	@Column(name = "o_capi_tot")
	/**
	 * Capi ovini totali presenti in allevamento Marcati / da
	 * marcare individualmente
	 */
	private BigDecimal oCapiTot;

	@Column(name = "o_agnelli_mac_tot")
	/**
	 * Totale agnelli da macello marcati collettivamente
	 * (da non computare nei "capi totali presenti in
	 * allevamento marcati/da marcare individualmente”)
	 */
	private BigDecimal oAgnelliMacTot;

	@Column(name = "c_maschi_adulti")
	/**
	 * Numero caprini maschi adulti (oltre 12 mesi)
	 */
	private BigDecimal cMaschiAdulti;

	@Column(name = "c_maschi_adulti_lib")
	/**
	 * Numero caprini maschi adulti (oltre 12 mesi) iscritti a libro
	 */
	private BigDecimal cMaschiAdultiLib;

	@Column(name = "c_femmine_adulte")
	/**
	 * Numero caprini femmine adulte (oltre 12 mesi)
	 */
	private BigDecimal cFemmineAdulte;

	@Column(name = "c_femmine_adulte_lib")
	/**
	 * Numero caprini femmine adulte (oltre 12 mesi) iscritte a libro

	 */
	private BigDecimal cFemmineAdulteLib;

	@Column(name = "c_maschi_rimonta")
	/**
	 * Numero caprini maschi della quota di rimonta
	 */
	private BigDecimal cMaschiRimonta;

	@Column(name = "c_maschi_rimonta_lib")
	/**
	 * Numero caprini maschi della quota di rimonta iscritti a libro
	 */
	private BigDecimal cMaschiRimontaLib;

	@Column(name = "c_femmine_rimonta")
	/**
	 * Numero caprini femmine della quota di rimonta
	 */
	private BigDecimal cFemmineRimonta;

	@Column(name = "c_femmine_rimonta_lib")
	/**
	 * Numero caprini femmine della quota di rimonta iscritte a libro
	 */
	private BigDecimal cFemmineRimontaLib;

	@Column(name = "c_capi_tot")
	/**
	 * Capi caprini totali presenti in allevamento Marcati / da marcare individualmente
	 */
	private BigDecimal cCapiTot;

	@Column(name = "c_capretti_mac_tot")
	/**
	 * Totale capretti da macello marcati collettivamente
	 * (da non computare nei "capi caprini totali presenti in
	 * allevamento marcati/da marcare individualmente”)
	 */
	private BigDecimal cCaprettiMacTot;

	@Column(name = "data_censimento")
	@Temporal(TemporalType.DATE)
	/**
	 * Data del censimento
	 */
	private Date dataCensimento;

	@Column(name = "dt_com_autorita")
	@Temporal(TemporalType.DATE)
	/**
	 * Data di comunicazione all’autorità competente
	 */
	private Date dtComAutorita;
	
	@Column(name = "codice_qualifica_scrapie")
	/**
	 * Codice che rappresenta l’ultima qualifica sanitaria comunicata rispetto al periodo di interesse.
	 * Può assumere i seguenti valori:
	 * - L1=LIVELLO I
	 * - L2=LIVELLO II
	 * - L3=LIVELLO III
	 * - L4=LIVELLO IV
	 * - L5=LIVELLO V
	 */
	private String codQualificaScrapie;
	
	@Column(name = "descr_qualifica_scrapie")
	/**
	 * Descrizione della qualifica.
	 */
	private String descrQualificaScrapie;
	
	@Column(name = "data_rilevazione_qualifica")
	@Temporal(TemporalType.DATE)
	/**
	 * Data della rilevazione
	 */
	private Date dataRilevazioneQualifica;

	
	/**
	 * Metodo getter che ritorna il codice che rappresenta l’ultima qualifica 
	 * sanitaria comunicata rispetto al periodo di interesse.
	 * @return codQualificaScrapie codice che rappresenta l’ultima qualifica 
	 * sanitaria comunicata rispetto al periodo di interesse.
	 */
	public String getCodQualificaScrapie() {
		return codQualificaScrapie;
	}

	/**
	 * Metodo setter che imposta il codice che rappresenta l'ultima qualifica
	 * sanitaria comunicata rispetto al periodo di interesse.
	 * @param codQualificaScrapie
	 */
	public void setCodQualificaScrapie(String codQualificaScrapie) {
		this.codQualificaScrapie = codQualificaScrapie;
	}

	/**
	 * Metodo getter che ritorna la descrizione della qualifica.
	 * @return descrQualificaScrapie descrizione della qualifica.
	 */
	public String getDescrQualificaScrapie() {
		return descrQualificaScrapie;
	}

	/**
	 * Metodo setter che imposta la descrizione della qualifica.
	 * @param descrQualificaScrapie descrizione della qualifica.
	 */
	public void setDescrQualificaScrapie(String descrQualificaScrapie) {
		this.descrQualificaScrapie = descrQualificaScrapie;
	}

	/**
	 * Metodo getter che ritorna la data della rilevazione della qualifica.
	 * @return dataRilevazioneQualifica data della rilevazione della qualifica.
	 */
	public Date getDataRilevazioneQualifica() {
		return dataRilevazioneQualifica;
	}

	/**
	 * Metodo setter che imposta la data della rilevazione della qualifica.
	 * @param dataRilevazioneQualifica data della rilevazione della qualifica.
	 */
	public void setDataRilevazioneQualifica(Date dataRilevazioneQualifica) {
		this.dataRilevazioneQualifica = dataRilevazioneQualifica;
	}

	@XmlElement
	/**
	 * Metodo getter che ritorna l'Identificativo univoco in BDN del censimento.
	 * @return censimentoId identificativo univoco in BDN del censimento.
	 */
	public BigDecimal getCensimentoId() {
		return censimentoId;
	}
	
	/**
	 * Metodo setter che imposta l'identificativo univoco in BDN del censimento.
	 * @param bigDecimal identificativo univoco in BDN del censimento.
	 */
	public void setCensimentoId(BigDecimal bigDecimal) {
		this.censimentoId = bigDecimal;
	}

	@XmlElement
	/**
	 * Metodo getter che ritorna l'Identificativo univoco in BDN dell’allevamento. 
	 * @return pAllevId identificativo univoco in BDN dell'allevamento.
	 */
	public BigDecimal getpAllevId() {
		return pAllevId;
	}
	
	/**
	 * Metodo setter che imposta l'identificativo univoco in BDN dell'allevamento.
	 * @param pallevId identificativo univoco in BDN dell'allevamento.
	 */
	public void setpAllevId(BigDecimal pallevId) {
		this.pAllevId = pallevId;
	}

	@XmlElement
	/**
	 * Metodo getter che ritorna il codice aziendale assegnato all’allevamento.
	 * @return aziendaCodice codice aziendale assegnato all'allevamento.
	 */
	public String getAziendaCodice() {
		return aziendaCodice;
	}

	/**
	 * Metodo setter che imposta il codice aziendale assegnato all'allevamento.
	 * @param aziendaCodice codice aziendale assegnato all'allevamento.
	 */
	public void setAziendaCodice(String aziendaCodice) {
		this.aziendaCodice = aziendaCodice;
	}

	@XmlElement
	/**
	 * Metodo getter che ritorna il codice fiscale della persona fisica o giuridica che
	 * risulta proprietario degli animali presenti in allevamento.
	 * @return codFiscaleProp codice fiscale della persona fisica o giuridica che risulta
	 * proprietario degli animali presenti in allevamento.
	 */
	public String getCodFiscaleProp() {
		return codFiscaleProp;
	}

	/**
	 * Metodo setter che imposta il codice fiscale della persona fisica o giuridica che 
	 * risulta proprietario degli animali presenti in allevamento.
	 * @param codFiscaleProp codice fiscale della persona fisica o giuridica che risulta
	 * proprietario degli animali presenti in allevamento.
	 */
	public void setCodFiscaleProp(String codFiscaleProp) {
		this.codFiscaleProp = codFiscaleProp;
	}

	@XmlElement
	/**
	 * Metodo getter che ritorna il codice fiscale della persona fisica o giuridica che
	 * risulta detentore degli animali presenti in allevamento.
	 * @return codFiscaleDete codice fiscale della persona fisica o giuridica che risulta
	 * detentore degli animali in allevamento.
	 */
	public String getCodFiscaleDete() {
		return codFiscaleDete;
	}

	/**
	 * Metodo setter che imopsta il codice fiscale della persona fisica o giuridica che
	 * risulta detentore degli animali presenti in allevamento.
	 * @param codFiscaleDete codice fiscale della persona fisica o giuridica che risulta
	 * detentore degli animali presenti in allevamento.
	 */
	public void setCodFiscaleDete(String codFiscaleDete) {
		this.codFiscaleDete = codFiscaleDete;
	}

	@XmlElement
	/**
	 * Metodo getter che ritorna il codice della specie allevata.	 
	 * @return specieCodice codice della specie allevata.
	 */
	public String getSpecieCodice() {
		return specieCodice;
	}

	/**
	 * Metodo setter che imposta il codice della specie allevata.
	 * @param specieCodice codice della specie allevata.
	 */
	public void setSpecieCodice(String specieCodice) {
		this.specieCodice = specieCodice;
	}

	@XmlElement
	/**
	 * Metodo getter che ritorna la descrizione della specie allevata.
	 * @return specieDescrizione descrizione della specie allevata.
	 */
	public String getSpecieDescrizione() {
		return specieDescrizione;
	}

	/**
	 * Metodo setter che imposta la descrizione della specie allevata.
	 * @param specieDescrizione descrizione della specie allevata.
	 */
	public void setSpecieDescrizione(String specieDescrizione) {
		this.specieDescrizione = specieDescrizione;
	}

	@XmlElement
	/**
	 * Metodo getter che ritorna la data di inizio del periodo considerato.
	 * @return dataInizioPeriodo data di inizio del periodo considerato.
	 */
	public Date getDataInizioPeriodo() {
		return dataInizioPeriodo;
	}

	/**
	 * Metodo setter che imposta la data di inizio del periodo considerato.
	 * @param dataInizioPeriodo data di inizio del periodo considerato.
	 */
	public void setDataInizioPeriodo(Date dataInizioPeriodo) {
		this.dataInizioPeriodo = dataInizioPeriodo;
	}

	@XmlElement
	/**
	 * Metodo getter che ritorna la data di fine del periodo considerato.
	 * @return dataFinePeriodo data di fine del periodo considerato.
	 */
	public Date getDataFinePeriodo() {
		return dataFinePeriodo;
	}

	/**
	 * Metodo setter che imposta la data di fine del periodo considerato.
	 * @param dataFinePeriodo data di fine del periodo considerato.
	 */
	public void setDataFinePeriodo(Date dataFinePeriodo) {
		this.dataFinePeriodo = dataFinePeriodo;
	}

	@XmlElement
	/**
	 * Metodo getter che ritorna il numero ovini maschi adulti (oltre 12 mesi).
	 * @return oMaschiAdulti numero di ovini maschi adulti (oltre i 12 mesi).
	 */
	public BigDecimal getoMaschiAdulti() {
		return oMaschiAdulti;
	}

	/**
	 * Metodo setter che imposta il numero di ovini maschi adulti (oltre i 12 mesi).
	 * @param oMaschiAdulti numero di ovini maschi adulti (oltre i 12 mesi).
	 */
	public void setoMaschiAdulti(BigDecimal oMaschiAdulti) {
		this.oMaschiAdulti = oMaschiAdulti;
	}

	@XmlElement
	/**
	 * Metodo getter che ritorna il numero di ovini maschi adulti (oltre i 12 mesi)
	 * iscritti a libro.
	 * @return oMaschiAdultiLib numero di ovini maschi adulti (oltre i 12 mesi)
	 * iscritti a libro.
	 */
	public BigDecimal getoMaschiAdultiLib() {
		return oMaschiAdultiLib;
	}

	/**
	 * Metodo setter che imposta il numero di ovini maschi adulti (oltre i 12 mesi)
	 * iscritti a libro.
	 * @param oMaschiAdultiLib numero di ovini maschi adulti (oltre i 12 mesi)
	 * iscritti a libro.
	 */
	public void setoMaschiAdultiLib(BigDecimal oMaschiAdultiLib) {
		this.oMaschiAdultiLib = oMaschiAdultiLib;
	}

	@XmlElement
	/**
	 * Metodo getter che ritorna il numero di ovini femmine adulte (oltre i 12 mesi).
	 * @return oFemmineAdulte numero di ovini femmine adulte (oltre i 12 mesi).
	 */
	public BigDecimal getoFemmineAdulte() {
		return oFemmineAdulte;
	}

	/**
	 * Metodo setter che imposta il numero di ovini femmine adulte (oltre i 12 mesi).
	 * @param oFemmineAdulte numero di ovini femmine adulte (oltre i 12 mesi).
	 */
	public void setoFemmineAdulte(BigDecimal oFemmineAdulte) {
		this.oFemmineAdulte = oFemmineAdulte;
	}

	@XmlElement
	/**
	 * Metodo getter che ritorna il numero di ovini femmine adulte (oltre i 12 mesi)
	 * iscritti a libro.
	 * @return oFemmineAdulteLib numero di ovini femmine adulte (oltre i 12 mesi)
	 * iscritti a libro.	
	 */
	public BigDecimal getoFemmineAdulteLib() {
		return oFemmineAdulteLib;
	}

	/**
	 * Metodo setter che imposta il numero di ovini femmine adulte (oltre i 12 mesi)
	 * iscritti a libro.
	 * @param oFemmineAdulteLib numero di ovini femmine adulte(oltre i 12 mesi)
	 * iscritti a libro.
	 */
	public void setoFemmineAdulteLib(BigDecimal oFemmineAdulteLib) {
		this.oFemmineAdulteLib = oFemmineAdulteLib;
	}

	@XmlElement
	/**
	 * Metodo getter che ritorna il numero di ovini maschi della quota di rimonta.
	 * @return oMaschiRimonta numero di ovini maschi della quota di rimonta.
	 */
	public BigDecimal getoMaschiRimonta() {
		return oMaschiRimonta;
	}

	/**
	 * Metodo setter che imposta il numero di ovini maschi della quota di rimonta.
	 * @param oMaschiRimonta numero di ovini maschi della quota di rimonta.
	 */
	public void setoMaschiRimonta(BigDecimal oMaschiRimonta) {
		this.oMaschiRimonta = oMaschiRimonta;
	}

	@XmlElement
	/**
	 * Metodo getter che ritorna il numero di ovini maschi della quota di rimonta
	 * iscritti a libro.
	 * @return oMaschiRimontaLib numero di ovini maschi della quota di rimonta
	 * iscritti a libro. 
	 */
	public BigDecimal getoMaschiRimontaLib() {
		return oMaschiRimontaLib;
	}

	/**
	 * Metodo setter che imposta il numero di ovini maschi della quota di rimonta
	 * iscritti a libro
	 * @param oMaschiRimontaLib numro di ovini maschi della quota di rimonta
	 * iscritti a libro.
	 */
	public void setoMaschiRimontaLib(BigDecimal oMaschiRimontaLib) {
		this.oMaschiRimontaLib = oMaschiRimontaLib;
	}

	@XmlElement
	/**
	 * Metodo getter che ritorna il numero di ovini femmine della quota di rimonta.
	 * @return oFemmineRimonta numero di ovini femmine della quota di rimonta.
	 */
	public BigDecimal getoFemmineRimonta() {
		return oFemmineRimonta;
	}

	/**
	 * Metodo setter che imposta il numero di ovini femmine della quota di rimonta.
	 * @param oFemmineRimonta numero di ovini femmine della quota di rimonta.
	 */
	public void setoFemmineRimonta(BigDecimal oFemmineRimonta) {
		this.oFemmineRimonta = oFemmineRimonta;
	}

	@XmlElement
	/**
	 * Metodo getter che ritorna il numero di ovini femmine della quota di rimonta
	 * iscritti a libro.
	 * @return oFemmineRimontaLib numero di ovini femmine della quota di rimonta
	 * iscritti a libro.
	 */
	public BigDecimal getoFemmineRimontaLib() {
		return oFemmineRimontaLib;
	}

	/**
	 * Metodo setter che imposta il numero di ovini femmine della quota di rimonta
	 * iscritti a libro.
	 * @param oFemmineRimontaLib numero di ovini femmine della quota di rimonta
	 * iscritti a libro.
	 */
	public void setoFemmineRimontaLib(BigDecimal oFemmineRimontaLib) {
		this.oFemmineRimontaLib = oFemmineRimontaLib;
	}

	@XmlElement
	/**
	 * Metodo getter che ritorna il numero di capi ovini totali presenti in allevamento Marcati / da
	 * marcare individualmente.
	 * @return oCapiTot numero di capi ovini totali presenti in allevamento marcati / da marcare individualmente.
	 */
	public BigDecimal getoCapiTot() {
		return oCapiTot;
	}

	/**
	 * Metodo setter che imposta il numero di capi ovini totali presenti in allevamento
	 * Marcati / da marcare individualmente.
	 * @param oCapiTot numero di capi ovini totali presenti in allevamento marcati / da marcare individualmente.
	 */
	public void setoCapiTot(BigDecimal oCapiTot) {
		this.oCapiTot = oCapiTot;
	}

	@XmlElement
	/**
	 * Metodo getter che ritorna il numero totale di agnelli da macello marcati collettivamente.
	 * @return oAgnelliMacTot numero totale di agnelli da macello marcati collettivamente.
	 */
	public BigDecimal getoAgnelliMacTot() {
		return oAgnelliMacTot;
	}

	/**
	 * Metodo setter che imposta il numero totale di agnelli da macello marcati collettivamente.
	 * @param oAgnelliMacTot numero totale di agnelli da macello marcati collettivamente.
	 */
	public void setoAgnelliMacTot(BigDecimal oAgnelliMacTot) {
		this.oAgnelliMacTot = oAgnelliMacTot;
	}

	@XmlElement
	/**
	 * Metodo getter che ritorna il numero di caprini maschi adulti (oltre 12 mesi).
	 * @return cMaschiAdulti numero di caprini maschi adulti (oltre i 12 mesi).
	 */
	public BigDecimal getcMaschiAdulti() {
		return cMaschiAdulti;
	}

	/**
	 * Metodo setter che imposta il numero di caprini maschi adulti (oltre i 12 mesi).
	 * @param cMaschiAdulti numero di caprini maschi adulti (oltre i 12 mesi).
	 */
	public void setcMaschiAdulti(BigDecimal cMaschiAdulti) {
		this.cMaschiAdulti = cMaschiAdulti;
	}

	@XmlElement
	/**
	 * Metodo getter che ritorna il numero di caprini maschi adulti (oltre i 12 mesi)
	 * iscritti a libro.
	 * @return cMaschiAdultiLib numero di caprini maschi adulti (oltre i 12 mesi)
	 * iscritti a libro.
	 */
	public BigDecimal getcMaschiAdultiLib() {
		return cMaschiAdultiLib;
	}

	/**
	 * Metodo setter che imposta il numero di caprini maschi adulti (oltre i 12 mesi)
	 * iscritti a libro.
	 * @param cMaschiAdultiLib numero di caprini maschi adulti (oltre i 12 mesi)
	 * iscritti a libro.
	 */
	public void setcMaschiAdultiLib(BigDecimal cMaschiAdultiLib) {
		this.cMaschiAdultiLib = cMaschiAdultiLib;
	}

	@XmlElement
	/**
	 * Metodo getter che ritorna il numero di caprini femmine adulte (oltre i 12 mesi).
	 * @return cFemmineAdulte numero di caprini femimne adulte (oltre i 12 mesi).
	 */
	public BigDecimal getcFemmineAdulte() {
		return cFemmineAdulte;
	}

	/**
	 * Metodo setter che ritorna il numero di caprini femmine adulte (oltre i 12 mesi).
	 * @param cFemmineAdulte numero di caprini femmine adulte (oltre i 12 mesi).
	 */
	public void setcFemmineAdulte(BigDecimal cFemmineAdulte) {
		this.cFemmineAdulte = cFemmineAdulte;
	}

	@XmlElement
	/**
	 * Metodo getter che ritorna il numero di caprini femmine adulte (oltre i 12 mesi)
	 * iscritti a libro.
	 * @return cFemmineAdulteLib numero di caprini femmine adulte (oltre i 12 mesi)
	 * iscritti a libro.
	 */
	public BigDecimal getcFemmineAdulteLib() {
		return cFemmineAdulteLib;
	}

	/**
	 * Metodo setter che imposta il numero di caprini femmine adulte (oltre i 12 mesi)
	 * iscritti a libro.
	 * @param cFemmineAdulteLib numero di caprini femmine adulte (oltre i 12 mesi)
	 * iscritti a libro.
	 */
	public void setcFemmineAdulteLib(BigDecimal cFemmineAdulteLib) {
		this.cFemmineAdulteLib = cFemmineAdulteLib;
	}

	@XmlElement
	/**
	 * Metodo getter che ritorna il numero di caprini maschi della quota di rimonta.
	 * @return cMaschiRimonta numero di caprini maschi della quota di rimonta.
	 */
	public BigDecimal getcMaschiRimonta() {
		return cMaschiRimonta;
	}

	/**
	 * Metodo setter che imposta il numero di caprini maschi della quota di rimonta.
	 * @param cMaschiRimonta numero di caprini maschi della quota di rimonta.
	 */
	public void setcMaschiRimonta(BigDecimal cMaschiRimonta) {
		this.cMaschiRimonta = cMaschiRimonta;
	}

	@XmlElement
	/**
	 * Metodo getter che ritorna il numero di caprini maschi della quota di rimonta
	 * iscritti a libro.
	 * @return cMaschiRimontaLib numero di caprini maschi della quota di rimonta
	 * iscritti a libro.
	 */
	public BigDecimal getcMaschiRimontaLib() {
		return cMaschiRimontaLib;
	}

	/**
	 * Metodo setter che imposta il numero di caprini maschi della quota di rimonta
	 * iscritti a libro.
	 * @param cMaschiRimontaLib numero di caprini maschi della quota di rimonta 
	 * iscritti a libro.
	 */
	public void setcMaschiRimontaLib(BigDecimal cMaschiRimontaLib) {
		this.cMaschiRimontaLib = cMaschiRimontaLib;
	}

	@XmlElement
	/**
	 * Metodo getter che ritorna il numero di caprini femmine della quota di rimonta.
	 * @return cFemmineRimonta numero di caprini femmine della quota di rimonta.
	 */
	public BigDecimal getcFemmineRimonta() {
		return cFemmineRimonta;
	}

	/**
	 * Metodo setter che imposta il numero di caprini femmine della quota di rimonta.
	 * @param cFemmineRimonta numero di caprini femmine della quota di rimonta.
	 */
	public void setcFemmineRimonta(BigDecimal cFemmineRimonta) {
		this.cFemmineRimonta = cFemmineRimonta;
	}

	@XmlElement
	/**
	 * Metodo getter che ritorna il numero di caprini femmine della quota di rimonta
	 * iscritti a libro.
	 * @return cFemmineRimontaLib numero di caprini femmine della quota di rimonta
	 * iscritti a libro.
	 */
	public BigDecimal getcFemmineRimontaLib() {
		return cFemmineRimontaLib;
	}

	/**
	 * metodo setter che imposta il numero di caprini femmine della quota di rimonta
	 * iscritti a libro.
	 * @param cFemmineRimontaLib numero di caprini femmine della quota di rimonta
	 * iscritti a libro.
	 */
	public void setcFemmineRimontaLib(BigDecimal cFemmineRimontaLib) {
		this.cFemmineRimontaLib = cFemmineRimontaLib;
	}

	@XmlElement
	/**
	 * Metodo getter che ritorna il numero di capi caprini totali presenti in allevamento Marcati / da marcare individualmente.
	 * @return cCapiTot numero di capi caprini totali presenti in allevamento marcati / da marcare individualmente.
	 */
	public BigDecimal getcCapiTot() {
		return cCapiTot;
	}

	/**
	 * Metodo setter che imposta il numero di capi caprini totali presenti in allevamento marcati / da marcare individualmente.
	 * @param cCapiTot numero di capi caprini totali presenti in allevamento marcati / da marcare individualmente.
	 */
	public void setcCapiTot(BigDecimal cCapiTot) {
		this.cCapiTot = cCapiTot;
	}

	@XmlElement
	/**
	 * Metodo getter che ritorna il numero totale di capretti da macello marcati collettivamente.
	 * @return cCaprettiMacTot numero totale di capretti da macello marcati collettivamente.
	 */
	public BigDecimal getcCaprettiMacTot() {
		return cCaprettiMacTot;
	}

	/**
	 * Metodo setter che imposta il numero totale di capretti da macello marcati collettivamente.
	 * @param cCaprettiMacTot
	 */
	public void setcCaprettiMacTot(BigDecimal cCaprettiMacTot) {
		this.cCaprettiMacTot = cCaprettiMacTot;
	}

	@XmlElement
	/**
	 * Metodo getter che ritorna la data del censimento.
	 * @return dataCensimento data del censimento.
	 */
	public Date getDataCensimento() {
		return dataCensimento;
	}

	/**
	 * Metodo setter che imposta la data del censimento.
	 * @param dataCensimento data del censimento.
	 */
	public void setDataCensimento(Date dataCensimento) {
		this.dataCensimento = dataCensimento;
	}

	@XmlElement
	/**
	 * Metodo getter che imposta la data di comunicazione all'autorita competente
	 * @return dtComAutorita data di comunicazione all'autorita competente.
	 */
	public Date getDtComAutorita() {
		return dtComAutorita;
	}

	/**
	 * Metodo setter che imposta la data di comunicazione all'autorita competente.
	 * @param dtComAutorita data di comunicazione all'autorita competente.
	 */
	public void setDtComAutorita(Date dtComAutorita) {
		this.dtComAutorita = dtComAutorita;
	}

	/**
	 * MEtodo che ritorna l'id univoco associato all'istanza di sessione.
	 * @return idSessione id univoco associato all'istanza di sessione.
	 */
	public Dmt_t_sessione getIdSessione() {
		return idSessione;
	}

	/**
	 * Metodo setter che imposta l'id univoco associato all'istanza di sessione.
	 * <b>ATTENZIONE</b> questo metodo non è usato in quanto l'id univoco associato
	 * all'istanza di sessione viene generato automaticamente @see Dmt_t_sessione.
	 * @param sessione id univoco associato all'istanza di sessione.
	 */
	public void setIdSessione(Dmt_t_sessione sessione) {
		this.idSessione = sessione;
	}
}
