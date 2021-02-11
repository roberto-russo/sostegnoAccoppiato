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

@Entity
@Table(name = "dmt_t_anagrafica_allev")
public class Dmt_t_anagrafica_allevamenti implements Serializable {

	private static final long serialVersionUID = 9215943957155723524L;

	@Id
	@GeneratedValue(generator = "seq_dmt_t_anagrafica_allev")
	@SequenceGenerator(name="seq_dmt_t_anagrafica_allev",sequenceName="SEQ_DMT_T_ANAGRAFICA_ALLEV", allocationSize=1)
	@Column(name = "id_autogenerato")
	/**
	 * codice id autogenerato associato all'oggetto di tipo Dmt_t_anagrafica_allevamenti
	 */
	private Long idAutogenerato;

	@ManyToOne
	@JoinColumn(name = "id_sessione", nullable = false)
	/**
	 * codice sessione associato all'esecuzione
	 */
	private Dmt_t_sessione idSessione;

	@Column(name = "allev_id")
	/**
	 * Identificativo univoco in DBN dell’allevamento
	 */
	private BigDecimal allevId;
	
	@Column(name = "azienda_codice")
	/**
	 * Codice aziendale assegnato all’allevamento.
	 */
	private String aziendacodice;
	
	@Column(name = "spe_codice")
	/**
	 * Codice della specie allevata nell’allevamento di origine
	 */
	private String speCodice;
	
	@Column(name = "denominazione")
	/**
	 * Denominazione dell'allevamento
	 */
	private String denominazione;
	
	@Column(name = "indirizzo")
	/**
	 * Indirizzo dell’allevamento (sede di ubicazione degli
	 * animali). 
	 */
	private String indirizzo;
	
	@Column(name = "cap")
	/**
	 * Codice di Avviamento Postale dell’allevamento (sede di ubicazione degli animali).
	 */
	private String cap;
	
	@Column(name = "localita")
	/**
	 * Località dell’allevamento (sede di ubicazione degli animali).
	 */
	private String localita;
	
	@Column(name = "comune")
	/**
	 * Codice comune di ubicazione (dell’azienda).
	 */
	private String comune;
	
	@Column(name = "tipo_produzione")
	/**
	 * Codice del tipo di produzione a cui risulta dedicata la
	 * struttura
	 */
	private String tipoProduzione;
	
	@Column(name = "orientamento_produttivo")
	/**
	 * Codice dell’orientamento produttivo che dipende dal
	 * gruppo specie di appartenenza dell’allevamento e dal
	 * tipo_produzione. 
	 */
	private String orientamentoProduttivo;
	
	@Column(name = "autorizzazione_latte")
	/**
	 * Flag indicante se l’allevamento ha o meno
	 * l’autorizzazione sanitaria alla produzione di latte
	 * alimentare. Può assumere i seguenti valori:
	 *  - S → l’allevamento ha l’autorizzazione sanitaria alla
	 *        produzione di latte alimentare
	 *  - N → l’allevamento non ha l’autorizzazione sanitaria alla
	 *        produzione di latte alimentare.

	 */
	private String autorizzazioneLatte;
	
	@Column(name = "dt_inizio_attivita")
	@Temporal(TemporalType.DATE)
	/**
	 * Data di apertura dell’allevamento
	 */
	private Date dtInizioAttivita;
	
	@Column(name = "dt_fine_attivita")
	@Temporal(TemporalType.DATE)
	/**
	 * Data di chiusura dell’allevamento. 
	 */
	private Date dtFineAttivita;
	
	@Column(name = "dt_inizio_detentore")
	@Temporal(TemporalType.DATE)
	/**
	 * Data da cui il detentore indicato risulta responsabile sui
	 * capi presenti in allevamento (nel caso di allevamenti in
	 * soccida ed il CUAA passato fa riferimento al codice
	 * fiscale del proprietario il campo risulterà vuoto).
	 */
	private Date dtInizoDetentore;
	
	@Column(name = "dt_fine_detentore")
	@Temporal(TemporalType.DATE)
	/**
	 * Data da cui il detentore non risulta più essere responsabile
	 * sui capi presenti in allevamento.
	 */
	private Date dtFineDetentore;
	
	@Column(name = "cod_fiscale_prop")
	/**
	 * Codice fiscale della persona fisica o giuridica
	 * proprietaria dell’allevamento
	 */
	private String codFiscaleProp;
	
	@Column(name = "denom_proprietario")
	/**
	 * Denominazione della persona fisica o giuridica
	 * proprietaria dell’allevamento
	 */
	private String denomProprietario;
	
	@Column(name = "cod_fiscale_deten")
	/**
	 * Codice fiscale della persona fisica o giuridica che
	 * risulta detentore degli animali presenti in allevamento
	 * (nel caso di allevamento in soccida riporta gli estremi
	 * del soccidario se il CUAA passato fa riferimento a
	 * questi; se il CUAA fa riferimento alla figura del
	 * proprietario il campo risulterà vuoto)
	 */
	private String cod_fiscale_deten;
	
	@Column(name = "denom_detentore")
	/**
	 * Denominazione della persona fisica o giuridica che
	 * risulta detentore degli animali presenti in allevamento
	 * (nel caso di allevamento in soccida riporta gli estremi
	 * del soccidario se il CUAA passato fa riferimento a
	 * questi; se il CUAA fa riferimento alla figura del
	 * proprietario il campo risulterà vuoto)
	 */
	private String denomDetentore;
	
	@Column(name = "soccida")
	/**
	 * Flag indicante se l’allevamento è gestito con più
	 * contratti di soccida. Può assumere i seguenti valori:
	 *  - S → l’allevamento è in contratto di soccida
	 *  - N → l’allevamento non è gestito in contratto di soccida
	 */
	private String soccida;
	
	@Column(name = "latitudine")
	/**
	 * Coordinate geografiche – Latitudine.
	 */
	private BigDecimal latitudine;
	
	@Column(name = "longitudine")
	/**
	 * LONGITUDINE Coordinate geografiche – Longitudine
	 */
	private BigDecimal longitudine;
	
	@Column(name = "foglio_catastale")
	/**
	 * Codice del foglio catastale in cui è ubicata l’azienda.
	 */
	private String foglioCatastale;
	
	@Column(name = "sezione")
	/**
	 * Sezione catastale – Sezione
	 */
	private String sezione;
	
	@Column(name = "particella")
	/**
	 * Codice della particella catastale in cui è ubicata
	 * l’azienda
	 */
	private String particella;
	
	@Column(name="subalterno")
	/**
	 * Subalterno dell’unità immobiliare come dichiarato nella
	 * mappa catastale – Subalterno
	 */
	private String subalterno;
	
	@Column(name = "capi_totali")
	/**
	 * Numero dei capi presenti nell’allevamento (relativi alla
	 * specie indicata) alla data di calcolo indicata

	 */
	private BigDecimal capiTotali;
	
	@Column(name = "data_calcolo_capi")
	@Temporal(TemporalType.DATE)
	/**
	 * Data alla quale è calcolato il numero di capi presenti
	 * nell’allevamento.
	 */
	private Date dataCalcoloCapi;
	
	@Column(name = "tipo_allev_cod")
	/**
	 * Codice della tipologia di allevamento.
	 */
	private String tipoAllevCod;
	
	@Column(name = "tipo_allev_descr")
	/**
	 * Descrizione della tipologia di allevamento.
	 */
	private String tipoAllevDescr;

	/**
	 * metodo getter che ritorna l'id autogenerato associato all'oggetto di tipo Dmt_t_anagrafica_allevamenti
	 * @return idAutogenerarto id autogenerato associato all'oggetto di tipo  @see Dmt_t_anagrafica_allevamenti.
	 */
	public Long getIdAutogenerato() {
		return idAutogenerato;
	}

	/**
	 * metodo setter che imposta l'id autogenerato dell'oggetto di tipo Dmt_t_anagrafica_allevamenti.
	 * <b>ATTENZIONE</b> questo setter non dovrebbe essere utilizzato poichè l'id viene generato
	 * automaticamente dal framework.
	 * @param idAutogenerato id autogenerato associato all'oggetto di tipo @see Dmt_t_anagrafica_allevamenti
	 */
	public void setIdAutogenerato(Long idAutogenerato) {
		this.idAutogenerato = idAutogenerato;
	}

	/**
	 * metodo getter che ritorna il codice sessione associato all'esecuzione.
	 * @return sessione sessione associata all'esecuzione.
	 */
	public Dmt_t_sessione getIdSessione() {
		return idSessione;
	}

	/**
	 * metodo setter che imposta il codice sessione associato all'esecuzione
	 * @param sessione sessione associata all'esecuzione.
	 */
	public void setIdSessione(Dmt_t_sessione sessione) {
		this.idSessione = sessione;
	}

	/**
	 * metodo getter che ritorna l'identificativo univoco in BDN dell’allevamento.
	 * @return allevId identificativo univoco in BDN dell'allevamento.
	 */
	public BigDecimal getAllevId() {
		return allevId;
	}

	/**
	 * metodo setter che imposta l'identificativo univoco in BDN dell'allevamento
	 * @param allevId identificativo univoco in BDN dell'allevamento.
	 */
	public void setAllevId(BigDecimal allevId) {
		this.allevId = allevId;
	}

	/**
	 * metodo getter che ritorna il codice aziendale assegnato all’allevamento.
	 * @return aziendaCodice codice aziendale assegnato all'allevamento
	 */
	public String getAziendacodice() {
		return aziendacodice;
	}

	/**
	 * metodo setter che imposta il codice aziendale assegnato all'allevamento
	 * @param aziendacodice codice aziendale assegnato all'allevamento
	 */
	public void setAziendacodice(String aziendacodice) {
		this.aziendacodice = aziendacodice;
	}

	/**
	 *  metodo getter che ritorna il codice della specie allevata nell’allevamento di origine
	 * @return speCodice codice specie allevata nell'allevamento di origine.
	 */
	public String getSpeCodice() {
		return speCodice;
	}

	/**
	 * metodo setter che imposta il codice specie allevata nell'allevamento di origine.
	 * @param speCodice codice specie allevata nell'allevamento di origine.
	 */
	public void setSpeCodice(String speCodice) {
		this.speCodice = speCodice;
	}

	/**
	 * metodo getter che ritorna la denominazione dell'allevamento.
	 * @return denominazione denominazione
	 */
	public String getDenominazione() {
		return denominazione;
	}

	/**
	 * metodo setter che imposta la denominazione dell'allevamento.
	 * @param denominazione denominazione
	 */
	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	/**
	 * metodo getter che ritorna l'indirizzo dell’allevamento (sede di ubicazione degli animali). 
	 * @return indirizzo indirizzo dell'allevamento.
	 */
	public String getIndirizzo() {
		return indirizzo;
	}

	/**
	 * metodo setter che imposta l'indirizzo dell'allevamento (sede di ubicazione degli animali).
	 * @param indirizzo indirizzo dell'allevamento.
	 */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	/**
	 * metodo getter che ritorna il codice di avviamento postale dell'allevamento.
	 * @return cap codice di avviamento postale dell'allevamento.
	 */
	public String getCap() {
		return cap;
	}

	/**
	 * metodo setter che imposta il codice di avviamento postale dell'allevamento
	 * @param cap codice di avviamento postale dell'allevamento.
	 */
	public void setCap(String cap) {
		this.cap = cap;
	}

	/**
	 * metodo getter che ritorna la località dell’allevamento
	 * @return località località dell'allevamento
	 */
	public String getLocalita() {
		return localita;
	}

	/**
	 * metodo setter che imposta la località dell'allevamento
	 * @param localita località dell'allevamento
	 */
	public void setLocalita(String localita) {
		this.localita = localita;
	}

	/**
	 * metodo getter che ritorna il codice comune di ubicazione (dell’azienda).
	 * @return comune codice comune di ubicazione dell'azienda.
	 */
	public String getComune() {
		return comune;
	}

	/**
	 * metodo setter che imposta il codice comune di ubicazione (dell'azienda).
	 * @param comune codice comune di ubicazione dell'azienda
	 */
	public void setComune(String comune) {
		this.comune = comune;
	}

	/**
	 * metodo getter che ritorna il codice del tipo di produzione a cui risulta dedicata la
	 * struttura.
	 * @return codice del tipo di produzione a cui risulta dedicata la struttura.
	 */
	public String getTipoProduzione() {
		return tipoProduzione;
	}

	/**
	 * metodo setter che imposta il codice del tipo di produzione a cui risulta dedicata la
	 * struttura.
	 * @param tipoProduzione codice del tipo di produzione a cui risulta dedicata la struttura.
	 */
	public void setTipoProduzione(String tipoProduzione) {
		this.tipoProduzione = tipoProduzione;
	}

	/**
	 * metodo getter che ritorna il codice dell’orientamento produttivo che dipende dal
	 * gruppo specie di appartenenza dell’allevamento e dal tipo_produzione. 
	 * @return orientamentoProduttivo codice dell'orientamento produttivo che dipende dal
	 * gruppo specie di appartenenza dell'allevamento e dal tipo_produzione.
	 */
	public String getOrientamentoProduttivo() {
		return orientamentoProduttivo;
	}

	/**
	 * metodo setter che imposta il codice dell'orientamento produttivo che dipende dal
	 * gruppo specie di appartenenza dell'allevamento e dal tipo_produzione.
	 * @param orientamentoProduttivo codice dell'orientamento produttivo che dipende dal
	 * gruppo specie di appartenenza dell'allevamento e dal tipo_produzione.
	 */
	public void setOrientamentoProduttivo(String orientamentoProduttivo) {
		this.orientamentoProduttivo = orientamentoProduttivo;
	}

	/**
	 * metodo getter che ritorna il flag indicante se l’allevamento ha o meno
	 * l’autorizzazione sanitaria alla produzione di latte alimentare.
	 * @return autorizzazioneLatte flag indicante se l'allevamento ha o meno
	 * l'autorizzazione sanitaria alla produzione di latte alimentare.
	 */
	public String getAutorizzazioneLatte() {
		return autorizzazioneLatte;
	}

	/**
	 * metodo setter che imposta il flag indicante se l'allevamento ha o meno 
	 * l'autorrizazione sanitaria alla produzione di latte alimentare.
	 * @param autorizzazioneLatte flag indciante se l'allevamento ha o meno 
	 * l'autorrizazione sanitaria alla produzione di latte alimentare.
	 */
	public void setAutorizzazioneLatte(String autorizzazioneLatte) {
		this.autorizzazioneLatte = autorizzazioneLatte;
	}

	/**
	 * metodo getter che ritorna la data di apertura dell’allevamento
	 * @return dtInizioAttivita data di apertura dell'allevamento.
	 */
	public Date getDtInizioAttivita() {
		return dtInizioAttivita;
	}

	/**
	 * metodo setter che imposta la data di apertura dell'allevamento
	 * @param dtInizioAttivita data di apertura dell'allevamento.
	 */
	public void setDtInizioAttivita(Date dtInizioAttivita) {
		this.dtInizioAttivita = dtInizioAttivita;
	}

	/**
	 * mertodo getter che ritorna la data di chiusura dell'allevamento.
	 * @return dtFineAttivita data di chiusura dell'allevamento.
	 */
	public Date getDtFineAttivita() {
		return dtFineAttivita;
	}

	/**
	 * metodo setter che imposta la data di chiusura dell'allevamento.
	 * @param dtFineAttivita data di chiusura dell'allevamento.
	 */
	public void setDtFineAttivita(Date dtFineAttivita) {
		this.dtFineAttivita = dtFineAttivita;
	}

	/**
	 * metodo getter che ritorna il codice fiscale della persona fisica o giuridica
	 * proprietaria dell’allevamento.
	 * @return codFiscaleProp codice fiscale della persona fisica o giuridica 
	 * proprietaria dell'allevamento.
	 */
	public String getCodFiscaleProp() {
		return codFiscaleProp;
	}

	/**
	 * metodo setter che imposta il codice fiscale della persona fisica o giuridica 
	 * proprietaria dell'allevamento.
	 * @param codFiscaleProp codice fiscale della persona fisica o giuridica proprietaria
	 * dell'allevamento.
	 */
	public void setCodFiscaleProp(String codFiscaleProp) {
		this.codFiscaleProp = codFiscaleProp;
	}

	/**
	 * metodo getter che ritorna la denominazione della persona fisica o giuridica 
	 * proprietaria dell'allevamento.  
	 * @return denomProprietario denominazione della persona fisica o giuridica proprietaria dell'allevamento.
	 */
	public String getDenomProprietario() {
		return denomProprietario;
	}

	/**
	 * metodo setter che imposta la denominazione della persona fisica o giuridica proprietaria dell'allevamento.
	 * @param denomProprietario denominazione della persona fisica o giuridica proprietaria dell'allevamento.
	 */
	public void setDenomProprietario(String denomProprietario) {
		this.denomProprietario = denomProprietario;
	}

	/**
	 * metodo getter che ritorna il codice fiscale della persona fisica o giuridica che
	 * risulta detentore degli animali presenti in allevamento.
	 * @return cod_fiscale_deten codice fiscale della persona fisica o giuridica che risulta
	 * detentore degli animali presenti in allevamento.
	 */
	public String getCod_fiscale_deten() {
		return cod_fiscale_deten;
	}

	/**
	 * metodo setter che imposta il codice fiscale della persona fisica o giuridica che 
	 * risulta essere detentore degli animali presenti in allevamento.
	 * @param cod_fiscale_deten codice fiscale della persona fisica o giuridica che risulta
	 * essere detentore degli animali presenti in allevamento.
	 */
	public void setCod_fiscale_deten(String cod_fiscale_deten) {
		this.cod_fiscale_deten = cod_fiscale_deten;
	}

	/**
	 * metodo getter che ritorna la denominazione della persona fisica o giuridica che 
	 * risulta essere detentore degli animali presenti in allevamento.
	 * @return denomDetentore denominazione della persona fisica o giuridica che risulta essere
	 * detentore degli animali presenti in allevamento.
	 */
	public String getDenomDetentore() {
		return denomDetentore;
	}

	/**
	 * metodo setter che imposta la denominazione della persona fisica o giuridica che 
	 * risulta essere detentore degli animali presenti in allevamento.
	 * @param denomDetentore denominazione della persona fisica o giuridica che risulta
	 * essere detentore degli animali presenti in allevamento.
	 */
	public void setDenomDetentore(String denomDetentore) {
		this.denomDetentore = denomDetentore;
	}

	/**
	 * metodo getter che ritorna il flag indicante se l’allevamento è gestito con più
	 * contratti di soccida.
	 * @return soccida flag indicante se l'allevamento è gestito con più contratti di
	 * soccida.
	 */
	public String getSoccida() {
		return soccida;
	}

	/**
	 * metodo setter che imposta il flag indicante se l'allevamento è gestito con più
	 * contratti di soccida.
	 * @param soccida flag indicante se l'allevamento è gestito con più contratti di
	 * soccida.
	 */
	public void setSoccida(String soccida) {
		this.soccida = soccida;
	}

	/**
	 * metodo getter che ritorna la coordinata geograficha di latitudine
	 * @return latituine coordinata geografica di latitudine
	 */
	public BigDecimal getLatitudine() {
		return latitudine;
	}

	/**
	 * metodo setter che imposta la coordinata geografica di latitudine.
	 * @param latitudine coordinata geografica di latitudine.
	 */
	public void setLatitudine(BigDecimal latitudine) {
		this.latitudine = latitudine;
	}

	/**
	 * metodo getter che ritorna la coordinata geografica di longitudine.
	 * @return longitudine coordinata geografica di longitudine.
	 */
	public BigDecimal getLongitudine() {
		return longitudine;
	}

	/**
	 * metodo setter che imposta la coordinata geografica di longitudine.
	 * @param longitudine coordinata geografica di longitudine.
	 */
	public void setLongitudine(BigDecimal longitudine) {
		this.longitudine = longitudine;
	}

	/**
	 * metodo getter che ritorna il codice del foglio catastale in cui è ubicata l’azienda.
	 * @return foglioCatastale codice del foglio catastale in cui è ubicata l'azienda.
	 */
	public String getFoglioCatastale() {
		return foglioCatastale;
	}

	/**
	 * metodo setter che imposta il codice del foglio catastale in cui è ubicata l'azienda.
	 * @param foglioCatastale codice del foglio catastale in cui è ubicata l'azienda.
	 */
	public void setFoglioCatastale(String foglioCatastale) {
		this.foglioCatastale = foglioCatastale;
	}

	/**
	 * metodo getter che ritorna la sezione catastale
	 * @return sezione sezione catastale.
	 */
	public String getSezione() {
		return sezione;
	}

	/**
	 * metodo setter che imposta la sezione catastale
	 * @param sezione sezione catastale
	 */
	public void setSezione(String sezione) {
		this.sezione = sezione;
	}

	/**
	 * metodo getter che ritorna il codice della particella catastale in cui è ubicata
	 * l’azienda.
	 * @return particella codice della particella catastale in cui è ubicata l'azienda.
	 */
	public String getParticella() {
		return particella;
	}

	/**
	 * metodo setter che imposta il codice della particella catastale in cui è ubicata l'azienda.
	 * @param particella codice della particella catastale in cui è ubicata l'azienda.
	 */
	public void setParticella(String particella) {
		this.particella = particella;
	}

	/**
	 * metodo getter che ritorna il subalterno dell’unità immobiliare come dichiarato nella
	 * mappa catastale.
	 * @return subalterno subalterno dell'unità immobiliare come dichiarato nella mappa catastale.
	 */
	public String getSubalterno() {
		return subalterno;
	}

	/**
	 * metodo setter che imposta il subalterno dell'unità immobiliare come dichiarato nella mappa
	 * catastale.
	 * @param subalterno subalterno dell'unità immobiliare come dichiarato nella mappa catastale.
	 */
	public void setSubalterno(String subalterno) {
		this.subalterno = subalterno;
	}

	/**
	 * metodo getter che ritorna il numero dei capi presenti nell’allevamento (relativi alla
	 * specie indicata) alla data di calcolo indicata.
	 * @return capiTotali numero dei capi presenti nell'allevamento
	 */
	public BigDecimal getCapiTotali() {
		return capiTotali;
	}

	/**
	 * metodo setter che imposta il numero dei capi presenti nell'allevamento (relativi alla
	 * specie indicata) alla data di calcolo indicata.
	 * @param capiTotali numero dei capi presenti nell'allevamento.
	 */
	public void setCapiTotali(BigDecimal capiTotali) {
		this.capiTotali = capiTotali;
	}

	/**
	 * metodo getter che ritorna la data alla quale è calcolato il numero di capi presenti
	 * nell’allevamento.
	 * @return dataCalcoloCapi data alla quale è calcolato il numero di capi presenti nell'allevamento.
	 */
	public Date getDataCalcoloCapi() {
		return dataCalcoloCapi;
	}

	/**
	 * metodo setter che imposta la data alla quale è calcolato il numero di capi presenti
	 * nell'allevamento.
	 * @param dataCalcoloCapi data alla quale è calcolato il numero di capi presenti nell'allevamento.
	 */
	public void setDataCalcoloCapi(Date dataCalcoloCapi) {
		this.dataCalcoloCapi = dataCalcoloCapi;
	}

	/**
	 * metodo getter che ritorna il codice della tipologia di allevamento.
	 * @return tipoAllevCod codice della tipologia di allevamento.
	 */
	public String getTipoAllevCod() {
		return tipoAllevCod;
	}

	/**
	 * metodo setter che imposta il codice della tipologia di allevamento.
	 * @param tipoAllevCod codice della tipologia di allevamento.
	 */
	public void setTipoAllevCod(String tipoAllevCod) {
		this.tipoAllevCod = tipoAllevCod;
	}

	/**
	 * metodo getter che ritorna la descrizione della tipologia di allevamento.
	 * @return tipoAllevDescr descrizione della tipologia di allevamento.
	 */
	public String getTipoAllevDescr() {
		return tipoAllevDescr;
	}

	/**
	 * metodo setter che imposta la descrizione della tipologia di allevamento.
	 * @param tipoAllevDescr descrizione della tipologia di allevamento.
	 */
	public void setTipoAllevDescr(String tipoAllevDescr) {
		this.tipoAllevDescr = tipoAllevDescr;
	}

	/**
	 * metodo getter che ritorna la data da cui il detentore indicato risulta responsabile sui
	 * capi presenti in allevamento.
	 * @return dtInizioDetentore data da cui il detentore indicato risulta responsabile sui capi
	 * presenti in allevamento.
	 */
	public Date getDtInizoDetentore() {
		return dtInizoDetentore;
	}

	/**
	 * metodo setter che imposta la data da cui il detentore indicato risulta responsabile sui
	 * capi presenti in allevamento
	 * @param dtInizoDetentore data da cui il detentore indicato risulta essere responsabile sui
	 * capi presenti in allevamento.
	 */
	public void setDtInizoDetentore(Date dtInizoDetentore) {
		this.dtInizoDetentore = dtInizoDetentore;
	}

	/**
	 * metodo getter che ritorna la data da cui il detentore indicato risulta essere non più responsabile
	 * dei capi presenti in allevamento.
	 * @return dtFineDetentore data da cui il detentore indicato risulta essere non più responsabile dei
	 * capi presenti in allevamento.
	 */
	public Date getDtFineDetentore() {
		return dtFineDetentore;
	}

	/**
	 * metodo setter che imposta la data da cui il detentore indicato risulta essere non più responsabile
	 * dei capi presenti in allevamento.
	 * @param dtFineDetentore data da cui il detentore indicato risulta essere non più responsabile
	 * dei capi presenti in allevamento. 
	 */
	public void setDtFineDetentore(Date dtFineDetentore) {
		this.dtFineDetentore = dtFineDetentore;
	}
	
}
