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

@Entity
@Table(name = "dmt_t_anagrarfica_allev")
public class Dmt_t_anagrafica_allevamenti implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 9215943957155723524L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_autogenerato")
	private Long idAutogenerato;

	@ManyToOne
	@JoinColumn(name = "id_sessione", nullable = false)
	private Dmt_t_sessione sessione;

	@Column(name = "allev_id")
	private BigDecimal allevId;
	
	@Column(name = "azienda_codice", length = 15)
	private String aziendacodice;
	
	@Column(name = "spe_codice", length = 15)
	private String speCodice;
	
	@Column(name = "denominazione", length = 50)
	private String denominazione;
	
	@Column(name = "indirizzo", length = 100)
	private String indirizzo;
	
	@Column(name = "cap", length = 5)
	private String cap;
	
	@Column(name = "localita", length = 50)
	private String localita;
	
	@Column(name = "comune", length = 50)
	private String comune;
	
	@Column(name = "tipo_produzione", length = 20)
	private String tipoProduzione;
	
	@Column(name = "orientamento_produttivo", length = 50)
	private String orientamentoProduttivo;
	
	@Column(name = "autorizzazione_latte", length = 1)
	private String autorizzazioneLatte;
	
	@Column(name = "dt_inizio_attivita")
	@Temporal(TemporalType.DATE)
	private Date dtInizioAttivita;
	
	@Column(name = "dt_fine_attivita")
	@Temporal(TemporalType.DATE)
	private Date dtFineAttivita;
	
	@Column(name = "dt_inizio_detentore")
	@Temporal(TemporalType.DATE)
	private Date dtInizoDetentore;
	
	@Column(name = "dt_fine_detentore")
	@Temporal(TemporalType.DATE)
	private Date dtFineDetentore;
	
	@Column(name = "cod_fiscale_prop")
	private String codFiscaleProp;
	
	@Column(name = "denom_proprietario")
	private String denomProprietario;
	
	@Column(name = "cod_fiscale_deten")
	private String cod_fiscale_deten;
	
	@Column(name = "denom_detentore")
	private String denomDetentore;
	
	@Column(name = "soccida")
	private String soccida;
	
	@Column(name = "latitudine", precision = 11, scale = 6)
	private BigDecimal latitudine;
	
	@Column(name = "longitudine", precision = 11, scale = 6)
	private BigDecimal longitudine;
	
	@Column(name = "foglio_catastale")
	private String foglioCatastale;
	
	@Column(name = "sezione")
	private String sezione;
	
	@Column(name = "particella")
	private String particella;
	
	@Column(name="subalterno")
	private String subalterno;
	
	@Column(name = "capi_totali")
	private BigDecimal capiTotali;
	
	@Column(name = "data_calcolo_capi")
	@Temporal(TemporalType.DATE)
	private Date dataCalcoloCapi;
	
	@Column(name = "tipo_allev_cod")
	private String tipoAllevCod;
	
	@Column(name = "tipo_allev_descr")
	private String tipoAllevDescr;

	public Long getIdAutogenerato() {
		return idAutogenerato;
	}

	public void setIdAutogenerato(Long idAutogenerato) {
		this.idAutogenerato = idAutogenerato;
	}

	public Dmt_t_sessione getSessione() {
		return sessione;
	}

	public void setSessione(Dmt_t_sessione sessione) {
		this.sessione = sessione;
	}

	public BigDecimal getAllevId() {
		return allevId;
	}

	public void setAllevId(BigDecimal allevId) {
		this.allevId = allevId;
	}

	public String getAziendacodice() {
		return aziendacodice;
	}

	public void setAziendacodice(String aziendacodice) {
		this.aziendacodice = aziendacodice;
	}

	public String getSpeCodice() {
		return speCodice;
	}

	public void setSpeCodice(String speCodice) {
		this.speCodice = speCodice;
	}

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getLocalita() {
		return localita;
	}

	public void setLocalita(String localita) {
		this.localita = localita;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getTipoProduzione() {
		return tipoProduzione;
	}

	public void setTipoProduzione(String tipoProduzione) {
		this.tipoProduzione = tipoProduzione;
	}

	public String getOrientamentoProduttivo() {
		return orientamentoProduttivo;
	}

	public void setOrientamentoProduttivo(String orientamentoProduttivo) {
		this.orientamentoProduttivo = orientamentoProduttivo;
	}

	public String getAutorizzazioneLatte() {
		return autorizzazioneLatte;
	}

	public void setAutorizzazioneLatte(String autorizzazioneLatte) {
		this.autorizzazioneLatte = autorizzazioneLatte;
	}

	public Date getDtInizioAttivita() {
		return dtInizioAttivita;
	}

	public void setDtInizioAttivita(Date dtInizioAttivita) {
		this.dtInizioAttivita = dtInizioAttivita;
	}

	public Date getDtFineAttivita() {
		return dtFineAttivita;
	}

	public void setDtFineAttivita(Date dtFineAttivita) {
		this.dtFineAttivita = dtFineAttivita;
	}

	public String getCodFiscaleProp() {
		return codFiscaleProp;
	}

	public void setCodFiscaleProp(String codFiscaleProp) {
		this.codFiscaleProp = codFiscaleProp;
	}

	public String getDenomProprietario() {
		return denomProprietario;
	}

	public void setDenomProprietario(String denomProprietario) {
		this.denomProprietario = denomProprietario;
	}

	public String getCod_fiscale_deten() {
		return cod_fiscale_deten;
	}

	public void setCod_fiscale_deten(String cod_fiscale_deten) {
		this.cod_fiscale_deten = cod_fiscale_deten;
	}

	public String getDenomDetentore() {
		return denomDetentore;
	}

	public void setDenomDetentore(String denomDetentore) {
		this.denomDetentore = denomDetentore;
	}

	public String getSoccida() {
		return soccida;
	}

	public void setSoccida(String soccida) {
		this.soccida = soccida;
	}

	public BigDecimal getLatitudine() {
		return latitudine;
	}

	public void setLatitudine(BigDecimal latitudine) {
		this.latitudine = latitudine;
	}

	public BigDecimal getLongitudine() {
		return longitudine;
	}

	public void setLongitudine(BigDecimal longitudine) {
		this.longitudine = longitudine;
	}

	public String getFoglioCatastale() {
		return foglioCatastale;
	}

	public void setFoglioCatastale(String foglioCatastale) {
		this.foglioCatastale = foglioCatastale;
	}

	public String getSezione() {
		return sezione;
	}

	public void setSezione(String sezione) {
		this.sezione = sezione;
	}

	public String getParticella() {
		return particella;
	}

	public void setParticella(String particella) {
		this.particella = particella;
	}

	public String getSubalterno() {
		return subalterno;
	}

	public void setSubalterno(String subalterno) {
		this.subalterno = subalterno;
	}

	public BigDecimal getCapiTotali() {
		return capiTotali;
	}

	public void setCapiTotali(BigDecimal capiTotali) {
		this.capiTotali = capiTotali;
	}

	public Date getDataCalcoloCapi() {
		return dataCalcoloCapi;
	}

	public void setDataCalcoloCapi(Date dataCalcoloCapi) {
		this.dataCalcoloCapi = dataCalcoloCapi;
	}

	public String getTipoAllevCod() {
		return tipoAllevCod;
	}

	public void setTipoAllevCod(String tipoAllevCod) {
		this.tipoAllevCod = tipoAllevCod;
	}

	public String getTipoAllevDescr() {
		return tipoAllevDescr;
	}

	public void setTipoAllevDescr(String tipoAllevDescr) {
		this.tipoAllevDescr = tipoAllevDescr;
	}

	public Date getDtInizoDetentore() {
		return dtInizoDetentore;
	}

	public void setDtInizoDetentore(Date dtInizoDetentore) {
		this.dtInizoDetentore = dtInizoDetentore;
	}

	public Date getDtFineDetentore() {
		return dtFineDetentore;
	}

	public void setDtFineDetentore(Date dtFineDetentore) {
		this.dtFineDetentore = dtFineDetentore;
	}
	
}
