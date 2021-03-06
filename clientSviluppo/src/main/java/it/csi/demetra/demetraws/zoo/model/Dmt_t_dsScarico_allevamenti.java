package it.csi.demetra.demetraws.zoo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "dmt_t_dsScarico_allevamenti")
public class Dmt_t_dsScarico_allevamenti implements Serializable {

	private static final long serialVersionUID = 9215943957155723524L;




	@ManyToOne
	@JoinColumn(name = "idSessione", nullable = false)
	private Dmt_t_sessione idSessione;

	@Id
	@Column(name = "allev_id")
	/**
	 * identificativo univoco interno in BDN dell'allevamento
	 */
	private BigDecimal allevId;

	@Column(name = "cod_tipo_allev")
	private String codTipoAllevamento;

	@Column(name = "descr_tipo_allev")
	private String descrTipoAllevamento;

	@Column(name = "azienda_codice")
	/**
	 * codice aziendale assegnato all'allevamento
	 */
	private String aziendaCodice;

	@Column(name = "id_fiscale")
	/**
	 * identificativo fiscale dell'allevamento
	 */
	private String idFiscale;

	@Column(name = "spe_codice")
	/**
	 * codice specie animale allevata
	 */
	private String specodice;

	@Column(name = "denominazione")
	/**
	 * denominazione allevamento
	 */
	private String denominazione;

	@Column(name = "indirizzo")
	/**
	 * indirizzo dell'allevamento (sede di ubicazione degli animali; dal punto di
	 * vista tecnico viene reperito in BDN l'indirizzo dell'azienda)
	 */
	private String indirizzo;

	@Column(name = "cap")
	/**
	 * CAP dell'allevamento (sede di ubicazione degli animali. dal punto di vista
	 * tecnico viene reperito in BDN il CAP dell'azienda)
	 */
	private String cap;

	@Column(name = "localita")
	/**
	 * localita dell'allevamento ( sede di ubicazione degli animali. dal punto di
	 * vista tecnico viene reperito in BDN la licalità di ubicazione dell'azienda)
	 */
	private String localita;

	@Column(name = "com_codice")
	/**
	 * codice istat del comune dell'azienda
	 */
	private String comCodice;

	@Column(name = "pro_codice")
	/**
	 * codice istat della provincia dell'azienda
	 */
	private String proCodice;

	@Column(name = "flag_libri_genealogici")
	/**
	 * puo assumere i valori S,N in base all'iscrizione o meno dell'allevamento ad
	 * un libro genealogico
	 */
	private String flagLibriGenealogici;

	@Column(name = "orientamento_produttivo" )
	/**
	 * codice dell'orientamento produttivo che dipende dal gruppo specie di
	 * appartenenza dell'allevamento e al tipo_produzione. I valori ammissibili sono
	 * codificati nella tabella ORIENTAMENTI_PRODUTTIVI
	 */
	private String orientamentoProduttivo;

	@Column(name = "tipo_produzione" )
	/**
	 * codice del tipo di produzione a cui risulta dedicata la struttura. Puo
	 * assumere uno dei valori codificati nella tabella TIPI_PRODUZIONE
	 */
	private String tipoProduzione;

	@Column(name = "dt_inizio_attivita")
	/**
	 * data di apertura dell'allevamento
	 */
	@Temporal(TemporalType.DATE)
	private Date dtInizioAttivita;

	@Column(name = "dt_fine_attivita")
	/**
	 * data di chiusura dell'allevamento
	 */
	@Temporal(TemporalType.DATE)
	private Date dtFineAttivita;

	@Column(name = "cod_fiscale_prop" )
	/**
	 * codice fiscale della persona fisica o giuridica proprietaria dell'allevamento
	 */
	private String codFiscaleProp;

	@Column(name = "denom_proprietario")
	/**
	 * denominazione della persona fisica o giuridica proprietaria dell'allevamento
	 */
	private String denomProprietario;

	@Column(name = "codice_fiscale_deten")
	/**
	 * codice fiscale della persona fisica o giuridica che risulta detentore degli
	 * animali presenti in allevamento ( nel caso di allevamento in soccida riporta
	 * gli estremi del soccidario se il CUAA passato fa riferimento a questi; se il
	 * CUAA fa riferimento alla figura del proprietario il campo risultera vuoto)
	 */
	private String codiceFiscaleDeten;

	@Column(name = "denom_detentore")
	/**
	 * denominazione della persona fisica o giuridica che risulta detentore degli
	 * animali in allevamento ( nel caso di allevamento in soccida riporta gli
	 * estremi del soccidario se il CUAA passato fa riferimento a questi; se il CUAA
	 * fa riferimento alla figura del proprietario il campo risultera vuoto)
	 */
	private String denomDetentore;

	@Column(name = "dt_inizio_detentore")
	@Temporal(TemporalType.DATE)
	/**
	 * data da cui il detentore dell'allevamento risulta responsabile sui capi
	 * presenti
	 */
	private Date dtInizioDetentore;

	@Column(name = "dt_fine_detentore")
	@Temporal(TemporalType.DATE)
	/**
	 * data da cui il detentore dell'allevamento non risulta piu' responsabile sui
	 * capi presenti
	 */
	private Date dtFineDetentore;

	@Column(name = "soccida")
	/**
	 * flag indicante se l'allevamento è gestito con più contratti di soccida. Può
	 * assumere i seguenti valori: S -> l'allevamento e in contratto di soccida. N
	 * -> l'allevamneto non e gestito in contratto di soccida
	 */
	private String soccida;

	@Column(name = "latitudine")
	/**
	 * coordinate geografiche - Latitudine (vista logica AZIENDE)
	 */
	private BigDecimal latitudine;

	@Column(name = "longitudine")
	/**
	 * coordinate geografiche - Longitudine (vista logica AZIENDE)
	 */
	private BigDecimal longitudine;

	@Column(name = "sezione")
	/**
	 * sezione catastale - Sezione (vista logica AZIENDE)
	 */
	private String sezione;

	@Column(name = "subalterno")
	/**
	 * subalterno dell'unita immobiliare come dichiarato nella mappa catastale -
	 * Subalterno (vista logica AZIENDE)
	 */
	private String subalterno;

	@Column(name = "foglio_catastale")
	/**
	 * codice del foglio catastale in cui e' ubicata l'azienda
	 */
	private String foglioCatastale;

	@Column(name = "particella")
	/**
	 * codice della particella catastale in cui e' ubicata l'azienda
	 */
	private String particella;

	@Column(name = "autorizzazione_latte")
	/**
	 * flag indicante se l'allevamento ha o meno l'autorizzazione sanitaria alla
	 * produzione di latte alimentare. Puo' assumere i seguenti valori: S ->
	 * l'allevamento ha l'autorizzazione sanitaria alla produzione di latte
	 * alimentare N -> l'allevamento non ha l'autorizzazione sanitaria alla
	 * produzione di latte alimentare
	 */
	private String autorizzazioneLatte;

	@Column(name = "data_inizio_autorizzazione")
	@Temporal(TemporalType.DATE)
	/**
	 * data do omozop autorizzazione sanitaria alla produzione di latte alimentare (
	 * nel caso l'allevamento abbia ottenuto diverse tipologie di autorizzazione
	 * verra indicata la data meno recente)
	 */
	private Date dataInizioAutorizzazione;

	@Column(name = "data_revoca_autorizzazione")
	@Temporal(TemporalType.DATE)
	/**
	 * data revoca autorizzazione sanitaria alla produzione di latte alimentare
	 */
	private Date dataRevocaAutorizzazione;

	@Column(name = "capi_0_6_mesi")
	/**
	 * numero di capi presenti nell'allevamento di eta' inferiore o uguale ai 6 mesi
	 * alla data di calcolo richiesta in input (<=6)
	 */
	private double capi06Mesi;

	@Column(name = "capi_6_24_mesi")
	/**
	 * numero di capi presenti nell'allevamento di eta' compresa tra i 6 mesi e i 24
	 * mesi alla data di calcolo richiesta in input (>6 e <= 24)
	 */
	private double capi624Mesi;

	@Column(name = "capi_oltre_24_mesi")
	/**
	 * numero di capi presenti nell'allevamento di oltre 24 mesi di eta' alla data
	 * di calcolo richiesta in input (>24)
	 */
	private double capiOltre24Mesi;

	@Column(name = "vacche_da_latte")
	/**
	 * numero di vacche che hanno partorito o hanno raggiunto il trentesimo mese di
	 * eta' alla data di calcolo richiesta in input
	 */
	private double vaccheDaLatte;

	@Column(name = "bufalini")
	/**
	 * numero di capi bufalini presenti nell'allevamento alla data di calcolo
	 * richiesta in input
	 */
	private double bufalini;

	@Column(name = "ovini")
	/**
	 * numero di capi di razza ovina, rispetto all'ultimo censimento
	 */
	private double ovini;

	@Column(name = "caprini")
	/**
	 * numero di capi di razza caprina, rispetto all'ultimo censimento
	 */
	private double caprini;

	@Column(name = "data_ultimo_censimento")
	@Temporal(TemporalType.DATE)
	/**
	 * data dell'ultimo censimento (ovi-caprino e/o suino) registrato in BDN
	 */
	private Date dataUltimoCensimento;

	@Column(name = "capi_totali")
	/**
	 * 1 -> allevamenti bovini e bufalini: numero totale dei capi presenti
	 * nell'allevamento alla data di calcolo richiesta in input
	 * 
	 * 2 -> allevamenti ovi-caprini e suini: numero totale dei capi presenti
	 * nell'allevamento rispetto all'ultimo censimento
	 */
	private BigDecimal capiTotali;

	@Column(name = "data_calcolo_capi")
	@Temporal(TemporalType.DATE)
	/**
	 * data alla quale e' calcolato il numero di capi presenti nell'allevamento
	 */
	private Date dataCalcoloCapi;

	@Column(name = "cons_media_capi_0_6_mesi")
	/**
	 * consistenza media dei capi di eta' compresa tra 0 e 6 mesi
	 */
	private double consMediaCapi06Mesi;

	@Column(name = "cons_media_capi_6_24_mesi")
	/**
	 * consistenza media dei capi di eta' compresa tra 6 e 24 mesi
	 */
	private double consMediaCapi624Mesi;

	@Column(name = "cons_media_capi_oltre_24_mesi")
	/**
	 * consistenza media dei capi di oltre 24 mesi di eta'
	 */
	private double consMediaCapiOltre24Mesi;

	@Column(name = "cons_media_vacche_oltre_20")
	/**
	 * consistenza media delle vacche di oltre 20 mesi di eta'
	 */
	private double consMediaVaccheOltre20;

	@Column(name = "cons_media_totale")
	/**
	 * consistenza media totale dei capi detenuti
	 */
	private double consMediaTotale;

	@Column(name = "dt_inizio_periodo")
	@Temporal(TemporalType.DATE)
	/**
	 * data di inizio periodo di riferimento ricalcolata rispetto alla data di
	 * inizio attivita' dell'allevamento se successiva alla data di inizio periodo
	 * richiesta dall'utente
	 */
	private Date dtInizioPeriodo;

	@Column(name = "dt_fine_periodo")
	@Temporal(TemporalType.DATE)
	/**
	 * data di fine periodo di riferimento ricalcolata rispetto alla data di fine
	 * attivita' dell'allevamento, se valorizzata
	 */
	private Date dtFinePeriodo;

	public BigDecimal getAllevId() {
		return allevId;
	}

	public void setAllevId(BigDecimal allevId) {
		this.allevId = allevId;
	}

	public String getAziendaCodice() {
		return aziendaCodice;
	}

	public void setAziendaCodice(String aziendaCodice) {
		this.aziendaCodice = aziendaCodice;
	}

	public String getIdFiscale() {
		return idFiscale;
	}

	public void setIdFiscale(String idFiscale) {
		this.idFiscale = idFiscale;
	}

	public String getSpecodice() {
		return specodice;
	}

	public void setSpecodice(String specodice) {
		this.specodice = specodice;
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

	public String getComCodice() {
		return comCodice;
	}

	public void setComCodice(String comCodice) {
		this.comCodice = comCodice;
	}

	public String getProCodice() {
		return proCodice;
	}

	public void setProCodice(String proCodice) {
		this.proCodice = proCodice;
	}

	public String getFlagLibriGenealogici() {
		return flagLibriGenealogici;
	}

	public void setFlagLibriGenealogici(String flagLibriGenealogici) {
		this.flagLibriGenealogici = flagLibriGenealogici;
	}

	public String getOrientamentoProduttivo() {
		return orientamentoProduttivo;
	}

	public void setOrientamentoProduttivo(String orientamentoProduttivo) {
		this.orientamentoProduttivo = orientamentoProduttivo;
	}

	public String getTipoProduzione() {
		return tipoProduzione;
	}

	public void setTipoProduzione(String tipoProduzione) {
		this.tipoProduzione = tipoProduzione;
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

	public String getCodiceFiscaleDeten() {
		return codiceFiscaleDeten;
	}

	public void setCodiceFiscaleDeten(String codiceFiscaleDeten) {
		this.codiceFiscaleDeten = codiceFiscaleDeten;
	}

	public String getDenomDetentore() {
		return denomDetentore;
	}

	public void setDenomDetentore(String denomDetentore) {
		this.denomDetentore = denomDetentore;
	}

	public Date getDtInizioDetentore() {
		return dtInizioDetentore;
	}

	public void setDtInizioDetentore(Date dtInizioDetentore) {
		this.dtInizioDetentore = dtInizioDetentore;
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

	public String getSezione() {
		return sezione;
	}

	public void setSezione(String sezione) {
		this.sezione = sezione;
	}

	public String getSubalterno() {
		return subalterno;
	}

	public void setSubalterno(String subalterno) {
		this.subalterno = subalterno;
	}

	public String getFoglioCatastale() {
		return foglioCatastale;
	}

	public void setFoglioCatastale(String foglioCatastale) {
		this.foglioCatastale = foglioCatastale;
	}

	public String getParticella() {
		return particella;
	}

	public void setParticella(String particella) {
		this.particella = particella;
	}

	public String getAutorizzazioneLatte() {
		return autorizzazioneLatte;
	}

	public void setAutorizzazioneLatte(String autorizzazioneLatte) {
		this.autorizzazioneLatte = autorizzazioneLatte;
	}

	public Date getDataInizioAutorizzazione() {
		return dataInizioAutorizzazione;
	}

	public void setDataInizioAutorizzazione(Date dataInizioAutorizzazione) {
		this.dataInizioAutorizzazione = dataInizioAutorizzazione;
	}

	public Date getDataRevocaAutorizzazione() {
		return dataRevocaAutorizzazione;
	}

	public void setDataRevocaAutorizzazione(Date dataRevocaAutorizzazione) {
		this.dataRevocaAutorizzazione = dataRevocaAutorizzazione;
	}

	public double getCapi06Mesi() {
		return capi06Mesi;
	}

	public void setCapi06Mesi(double capi06Mesi) {
		this.capi06Mesi = capi06Mesi;
	}

	public double getCapi624Mesi() {
		return capi624Mesi;
	}

	public void setCapi624Mesi(double capi624Mesi) {
		this.capi624Mesi = capi624Mesi;
	}

	public double getCapiOltre24Mesi() {
		return capiOltre24Mesi;
	}

	public void setCapiOltre24Mesi(double capiOltre24Mesi) {
		this.capiOltre24Mesi = capiOltre24Mesi;
	}

	public double getVaccheDaLatte() {
		return vaccheDaLatte;
	}

	public void setVaccheDaLatte(double vaccheDaLatte) {
		this.vaccheDaLatte = vaccheDaLatte;
	}

	public double getBufalini() {
		return bufalini;
	}

	public void setBufalini(double bufalini) {
		this.bufalini = bufalini;
	}

	public double getOvini() {
		return ovini;
	}

	public void setOvini(double ovini) {
		this.ovini = ovini;
	}

	public double getCaprini() {
		return caprini;
	}

	public void setCaprini(double caprini) {
		this.caprini = caprini;
	}

	public Date getDataUltimoCensimento() {
		return dataUltimoCensimento;
	}

	public void setDataUltimoCensimento(Date dataUltimoCensimento) {
		this.dataUltimoCensimento = dataUltimoCensimento;
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

	public double getConsMediaCapi06Mesi() {
		return consMediaCapi06Mesi;
	}

	public void setConsMediaCapi06Mesi(double consMediaCapi06Mesi) {
		this.consMediaCapi06Mesi = consMediaCapi06Mesi;
	}

	public double getConsMediaCapi624Mesi() {
		return consMediaCapi624Mesi;
	}

	public void setConsMediaCapi624Mesi(double consMediaCapi624Mesi) {
		this.consMediaCapi624Mesi = consMediaCapi624Mesi;
	}

	public double getConsMediaCapiOltre24Mesi() {
		return consMediaCapiOltre24Mesi;
	}

	public void setConsMediaCapiOltre24Mesi(double consMediaCapiOltre24Mesi) {
		this.consMediaCapiOltre24Mesi = consMediaCapiOltre24Mesi;
	}

	public double getConsMediaVaccheOltre20() {
		return consMediaVaccheOltre20;
	}

	public void setConsMediaVaccheOltre20(double consMediaVaccheOltre20) {
		this.consMediaVaccheOltre20 = consMediaVaccheOltre20;
	}

	public double getConsMediaTotale() {
		return consMediaTotale;
	}

	public void setConsMediaTotale(double consMediaTotale) {
		this.consMediaTotale = consMediaTotale;
	}

	public Date getDtInizioPeriodo() {
		return dtInizioPeriodo;
	}

	public void setDtInizioPeriodo(Date dtInizioPeriodo) {
		this.dtInizioPeriodo = dtInizioPeriodo;
	}

	public Date getDtFinePeriodo() {
		return dtFinePeriodo;
	}

	public void setDtFinePeriodo(Date dtFinePeriodo) {
		this.dtFinePeriodo = dtFinePeriodo;
	}

	public Date getDtFineDetentore() {
		return dtFineDetentore;
	}

	public void setDtFineDetentore(Date dtFineDetentore) {
		this.dtFineDetentore = dtFineDetentore;
	}

	public String getCodTipoAllevamento() {
		return codTipoAllevamento;
	}

	public void setCodTipoAllevamento(String codTipoAllevamento) {
		this.codTipoAllevamento = codTipoAllevamento;
	}

	public String getDescrTipoAllevamento() {
		return descrTipoAllevamento;
	}

	public void setDescrTipoAllevamento(String descrTipoAllevamento) {
		this.descrTipoAllevamento = descrTipoAllevamento;
	}

	public Dmt_t_sessione getIdSessione() {
		return idSessione;
	}

	public void setIdSessione(Dmt_t_sessione sessione) {
		this.idSessione = sessione;
	}

}
