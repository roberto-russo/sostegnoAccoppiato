package it.csi.demetra.demetraws.zoo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name= "id_autogenerato")
    private Long idAutogenerato;
	
	
	@ManyToOne
	@JoinColumn(name = "idSessione", nullable = false)
	private Dmt_t_sessione idSessione;
	
	@Column(name = "censimento_id")
	@NotNull
	private BigDecimal censimentoId;

	@Column(name = "p_allev_id")
	@NotNull
	private BigDecimal pAllevId;

	@Column(name = "azienda_codice")
	private String aziendaCodice;

	@Column(name = "cod_fiscale_prop")
	private String codFiscaleProp;

	@Column(name = "cod_fiscale_dete")
	private String codFiscaleDete;

	@Column(name = "specie_codice")
	private String specieCodice;

	@Column(name = "specie_descrizione")
	private String specieDescrizione;

	@Column(name = "data_inizio_periodo")
	@Temporal(TemporalType.DATE)
	private Date dataInizioPeriodo;

	@Column(name = "data_fine_periodo")
	@Temporal(TemporalType.DATE)
	private Date dataFinePeriodo;

	@Column(name = "o_maschi_adulti")
	private BigDecimal oMaschiAdulti;

	@Column(name = "o_maschi_adulti_lib")
	private BigDecimal oMaschiAdultiLib;

	@Column(name = "o_femmine_adulte")
	private BigDecimal oFemmineAdulte;

	@Column(name = "o_femmine_adulte_lib")
	private BigDecimal oFemmineAdulteLib;

	@Column(name = "o_maschi_rimonta")
	private BigDecimal oMaschiRimonta;

	@Column(name = "o_maschi_rimonta_lib")
	private BigDecimal oMaschiRimontaLib;

	@Column(name = "o_femmine_rimonta")
	private BigDecimal oFemmineRimonta;

	@Column(name = "o_femmine_rimonta_lib")
	private BigDecimal oFemmineRimontaLib;

	@Column(name = "o_capi_tot")
	private BigDecimal oCapiTot;

	@Column(name = "o_agnelli_mac_tot")
	private BigDecimal oAgnelliMacTot;

	@Column(name = "c_maschi_adulti")
	private BigDecimal cMaschiAdulti;

	@Column(name = "c_maschi_adulti_lib")
	private BigDecimal cMaschiAdultiLib;

	@Column(name = "c_femmine_adulte")
	private BigDecimal cFemmineAdulte;

	@Column(name = "c_femmine_adulte_lib")
	private BigDecimal cFemmineAdulteLib;

	@Column(name = "c_maschi_rimonta")
	private BigDecimal cMaschiRimonta;

	@Column(name = "c_maschi_rimonta_lib")
	private BigDecimal cMaschiRimontaLib;

	@Column(name = "c_femmine_rimonta")
	private BigDecimal cFemmineRimonta;

	@Column(name = "c_femmine_rimonta_lib")
	private BigDecimal cFemmineRimontaLib;

	@Column(name = "c_capi_tot")
	private BigDecimal cCapiTot;

	@Column(name = "c_capretti_mac_tot")
	private BigDecimal cCaprettiMacTot;

	@Column(name = "data_censimento")
	@Temporal(TemporalType.DATE)
	private Date dataCensimento;

	@Column(name = "dt_com_autorita")
	@Temporal(TemporalType.DATE)
	private Date dtComAutorita;
	
	@Column(name = "codice_qualifica_scrapie")
	private String codQualificaScrapie;
	
	@Column(name = "descr_qualifica_scrapie")
	private String descrQualificaScrapie;
	
	@Column(name = "data_rilevazione_qualifica")
	@Temporal(TemporalType.DATE)
	private Date dataRilevazioneQualifica;

	
	
	public String getCodQualificaScrapie() {
		return codQualificaScrapie;
	}

	public void setCodQualificaScrapie(String codQualificaScrapie) {
		this.codQualificaScrapie = codQualificaScrapie;
	}

	public String getDescrQualificaScrapie() {
		return descrQualificaScrapie;
	}

	public void setDescrQualificaScrapie(String descrQualificaScrapie) {
		this.descrQualificaScrapie = descrQualificaScrapie;
	}

	public Date getDataRilevazioneQualifica() {
		return dataRilevazioneQualifica;
	}

	public void setDataRilevazioneQualifica(Date dataRilevazioneQualifica) {
		this.dataRilevazioneQualifica = dataRilevazioneQualifica;
	}

	@XmlElement
	public BigDecimal getCensimentoId() {
		return censimentoId;
	}
	
	public void setCensimentoId(BigDecimal bigDecimal) {
		this.censimentoId = bigDecimal;
	}

	@XmlElement
	public BigDecimal getpAllevId() {
		return pAllevId;
	}
	
	public void setpAllevId(BigDecimal pallevId) {
		this.pAllevId = pallevId;
	}

	@XmlElement
	public String getAziendaCodice() {
		return aziendaCodice;
	}

	public void setAziendaCodice(String aziendaCodice) {
		this.aziendaCodice = aziendaCodice;
	}

	@XmlElement
	public String getCodFiscaleProp() {
		return codFiscaleProp;
	}

	public void setCodFiscaleProp(String codFiscaleProp) {
		this.codFiscaleProp = codFiscaleProp;
	}

	@XmlElement
	public String getCodFiscaleDete() {
		return codFiscaleDete;
	}

	public void setCodFiscaleDete(String codFiscaleDete) {
		this.codFiscaleDete = codFiscaleDete;
	}

	@XmlElement
	public String getSpecieCodice() {
		return specieCodice;
	}

	public void setSpecieCodice(String specieCodice) {
		this.specieCodice = specieCodice;
	}

	@XmlElement
	public String getSpecieDescrizione() {
		return specieDescrizione;
	}

	public void setSpecieDescrizione(String specieDescrizione) {
		this.specieDescrizione = specieDescrizione;
	}

	@XmlElement
	public Date getDataInizioPeriodo() {
		return dataInizioPeriodo;
	}

	public void setDataInizioPeriodo(Date dataInizioPeriodo) {
		this.dataInizioPeriodo = dataInizioPeriodo;
	}

	@XmlElement
	public Date getDataFinePeriodo() {
		return dataFinePeriodo;
	}

	public void setDataFinePeriodo(Date dataFinePeriodo) {
		this.dataFinePeriodo = dataFinePeriodo;
	}

	@XmlElement
	public BigDecimal getoMaschiAdulti() {
		return oMaschiAdulti;
	}

	public void setoMaschiAdulti(BigDecimal oMaschiAdulti) {
		this.oMaschiAdulti = oMaschiAdulti;
	}

	@XmlElement
	public BigDecimal getoMaschiAdultiLib() {
		return oMaschiAdultiLib;
	}

	public void setoMaschiAdultiLib(BigDecimal oMaschiAdultiLib) {
		this.oMaschiAdultiLib = oMaschiAdultiLib;
	}

	@XmlElement
	public BigDecimal getoFemmineAdulte() {
		return oFemmineAdulte;
	}

	public void setoFemmineAdulte(BigDecimal oFemmineAdulte) {
		this.oFemmineAdulte = oFemmineAdulte;
	}

	@XmlElement
	public BigDecimal getoFemmineAdulteLib() {
		return oFemmineAdulteLib;
	}

	public void setoFemmineAdulteLib(BigDecimal oFemmineAdulteLib) {
		this.oFemmineAdulteLib = oFemmineAdulteLib;
	}

	@XmlElement
	public BigDecimal getoMaschiRimonta() {
		return oMaschiRimonta;
	}

	public void setoMaschiRimonta(BigDecimal oMaschiRimonta) {
		this.oMaschiRimonta = oMaschiRimonta;
	}

	@XmlElement
	public BigDecimal getoMaschiRimontaLib() {
		return oMaschiRimontaLib;
	}

	public void setoMaschiRimontaLib(BigDecimal oMaschiRimontaLib) {
		this.oMaschiRimontaLib = oMaschiRimontaLib;
	}

	@XmlElement
	public BigDecimal getoFemmineRimonta() {
		return oFemmineRimonta;
	}

	public void setoFemmineRimonta(BigDecimal oFemmineRimonta) {
		this.oFemmineRimonta = oFemmineRimonta;
	}

	@XmlElement
	public BigDecimal getoFemmineRimontaLib() {
		return oFemmineRimontaLib;
	}

	public void setoFemmineRimontaLib(BigDecimal oFemmineRimontaLib) {
		this.oFemmineRimontaLib = oFemmineRimontaLib;
	}

	@XmlElement
	public BigDecimal getoCapiTot() {
		return oCapiTot;
	}

	public void setoCapiTot(BigDecimal oCapiTot) {
		this.oCapiTot = oCapiTot;
	}

	@XmlElement
	public BigDecimal getoAgnelliMacTot() {
		return oAgnelliMacTot;
	}

	public void setoAgnelliMacTot(BigDecimal oAgnelliMacTot) {
		this.oAgnelliMacTot = oAgnelliMacTot;
	}

	@XmlElement
	public BigDecimal getcMaschiAdulti() {
		return cMaschiAdulti;
	}

	public void setcMaschiAdulti(BigDecimal cMaschiAdulti) {
		this.cMaschiAdulti = cMaschiAdulti;
	}

	@XmlElement
	public BigDecimal getcMaschiAdultiLib() {
		return cMaschiAdultiLib;
	}

	public void setcMaschiAdultiLib(BigDecimal cMaschiAdultiLib) {
		this.cMaschiAdultiLib = cMaschiAdultiLib;
	}

	@XmlElement
	public BigDecimal getcFemmineAdulte() {
		return cFemmineAdulte;
	}

	public void setcFemmineAdulte(BigDecimal cFemmineAdulte) {
		this.cFemmineAdulte = cFemmineAdulte;
	}

	@XmlElement
	public BigDecimal getcFemmineAdulteLib() {
		return cFemmineAdulteLib;
	}

	public void setcFemmineAdulteLib(BigDecimal cFemmineAdulteLib) {
		this.cFemmineAdulteLib = cFemmineAdulteLib;
	}

	@XmlElement
	public BigDecimal getcMaschiRimonta() {
		return cMaschiRimonta;
	}

	public void setcMaschiRimonta(BigDecimal cMaschiRimonta) {
		this.cMaschiRimonta = cMaschiRimonta;
	}

	@XmlElement
	public BigDecimal getcMaschiRimontaLib() {
		return cMaschiRimontaLib;
	}

	public void setcMaschiRimontaLib(BigDecimal cMaschiRimontaLib) {
		this.cMaschiRimontaLib = cMaschiRimontaLib;
	}

	@XmlElement
	public BigDecimal getcFemmineRimonta() {
		return cFemmineRimonta;
	}

	public void setcFemmineRimonta(BigDecimal cFemmineRimonta) {
		this.cFemmineRimonta = cFemmineRimonta;
	}

	@XmlElement
	public BigDecimal getcFemmineRimontaLib() {
		return cFemmineRimontaLib;
	}

	public void setcFemmineRimontaLib(BigDecimal cFemmineRimontaLib) {
		this.cFemmineRimontaLib = cFemmineRimontaLib;
	}

	@XmlElement
	public BigDecimal getcCapiTot() {
		return cCapiTot;
	}

	public void setcCapiTot(BigDecimal cCapiTot) {
		this.cCapiTot = cCapiTot;
	}

	@XmlElement
	public BigDecimal getcCaprettiMacTot() {
		return cCaprettiMacTot;
	}

	public void setcCaprettiMacTot(BigDecimal cCaprettiMacTot) {
		this.cCaprettiMacTot = cCaprettiMacTot;
	}

	@XmlElement
	public Date getDataCensimento() {
		return dataCensimento;
	}

	public void setDataCensimento(Date dataCensimento) {
		this.dataCensimento = dataCensimento;
	}

	@XmlElement
	public Date getDtComAutorita() {
		return dtComAutorita;
	}

	public void setDtComAutorita(Date dtComAutorita) {
		this.dtComAutorita = dtComAutorita;
	}

	public Dmt_t_sessione getIdSessione() {
		return idSessione;
	}

	public void setIdSessione(Dmt_t_sessione sessione) {
		this.idSessione = sessione;
	}
}
