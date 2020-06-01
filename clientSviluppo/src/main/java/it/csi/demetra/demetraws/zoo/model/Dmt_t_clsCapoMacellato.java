package it.csi.demetra.demetraws.zoo.model;

import java.io.Serializable;
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

@Entity
@Table(name = "DMT_T_CLS_CAPO_MACELLATO")
/**
 * Classe model di resoconto dei capi bovini macellati
 *
 * @version 0.1 (02/04/2020)
 * @author bcsoft
 */
public class Dmt_t_clsCapoMacellato implements Serializable {

	private static final long serialVersionUID = -787054678069256335L;


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name= "id_autogenerato")
    /**
     * id autogenerato associato all'oggetto di tipo Dmt_t_clsCapoMacellato
     */
    private Long idAutogenerato;


	@ManyToOne
	@JoinColumn(name = "id_sessione", nullable = false)
	/**
	 * codice di sessione associato all'esecuzione
	 */
	private Dmt_t_sessione sessione;

	@ManyToOne
	@JoinColumn(name = "FK_dmt_d_clsPrem_Valid", nullable = true)
	private Dmt_d_clsPremio_ValidazioneResponse dmt_d_clsPremio_ValidazioneResponse;

	@Column(name = "capo_id")
	@NotNull
	/**
	 * Identificativo univoco in BDN del capo bovino
	 */
	private Long capoId;

	@Column(name = "allev_id")
	@NotNull
	/**
	 * Identificativo univoco in BDN dell’allevamento di detenzione del capo
	 */
	private Long allevId;

	@Column(name = "CODICE_PREMIO")
	@NotNull
	private String codicePremio;

	@Column(name = "codice", length = 400)
	/**
	 * Codice della marca auricolare applicata al capo bovino.
	 */
	private String codice;

	@Column(name = "razza_codice", length = 400)
	/**
	 * Codice della razza del capo
	 */
	private String razzaCodice;

	@Column(name = "sesso", length = 1)
	/**
	 * Sesso del capo.
	 */
	private String sesso;

	@Column(name = "dt_nascita")
	@Temporal(TemporalType.DATE)
	/**
	 * Data di nascita del capo.
	 */
	private Date dtNascita;

	@Column(name = "azienda_codice", length = 400)
	/**
	 * Codice dell’azienda di detenzione
	 */
	private String aziendaCodice;

	@Column(name = "azienda_latitudine", length = 11, precision = 4)
	/**
	 * Latitudine dell’azienda
	 */
	private Double aziendaLatitudine;

	@Column(name = "azienda_longitudine", length = 11, precision = 4)
	/**
	 * Longitudine dell’azienda
	 */
	private Double aziendaLongitudine;

	@Column(name = "dt_ingresso")
	@Temporal(TemporalType.DATE)
	/**
	 * Data di ingresso del capo
	 */
	private Date dtIngresso;

	@Column(name = "dt_macellazione")
	@Temporal(TemporalType.DATE)
	/**
	 * Data di macellazione del capo
	 */
	private Date dtMacellazione;

	@Column(name = "cod_libro", length = 400)
	/**
	 * Codice del libro genealogico, se iscritto
	 */
	private String codLibro;

	@Column(name = "descr_libro", length = 400)
	/**
	 * Descrizione del libro genealogico, se iscritto
	 */
	private String descrLibro;

	@Column(name = "dt_com_autorita_ingresso")
	@Temporal(TemporalType.DATE)
	/**
	 * Data di comunicazione all’autorità competente dell’ingresso in stalla
	 */
	private Date dtComAutoritaIngresso;

	@Column(name = "dt_inserimento_bdn_ingresso")
	@Temporal(TemporalType.DATE)
	/**
	 * Data di registrazione in BDN dell’ingresso in stalla
	 */
	private Date dtInserimentoBdnIngresso;

	@Column(name = "cuaa", length = 16)
	/**
	 * Codice fiscale del richiedente
	 */
	private String cuaa;

	@Column(name = "dt_com_autorita_uscita")
	@Temporal(TemporalType.DATE)
	/**
	 * Data di comunicazione all’autorità competente dell’uscita del capo verso
	 * macello
	 */
	private Date dtComAutoritaUscita;

	@Column(name = "dt_uscita")
	@Temporal(TemporalType.DATE)
	/**
	 * Data di uscita
	 */
	private Date dtUscita;

	@Column(name = "dt_inserimento_bdn_uscita")
	@Temporal(TemporalType.DATE)
	/**
	 * Data di registrazione in BDN dell’uscita del capo verso macello.
	 */
	private Date dtInserimentoBdnUscita;

	@Column(name = "dt_Inizio_Detenzione")
	@Temporal(TemporalType.DATE)
	/**
	 * Data di inizio detenzione del capo
	 */
	private Date dtInizioDetenzione;

	@Column(name = "dt_fine_detenzione")
	@Temporal(TemporalType.DATE)
	/**
	 * Data fine detenzione del capo
	 */
	private Date dtFineDetenzione;

	@Column(name = "flag_delegato_ingresso", length = 10)
	/**
	 * Flag che assume valori a seconda dell'ingresso del capo
	 */
	private String flagDelegatoIngresso;

	@Column(name = "ruolo_utente_ingresso", length = 10)
	/**
	 * Flag che rappresenta il tipo delegato che ha registrato l'ingresso del capo
	 * in BDN.
	 */
	private String ruoloUtenteIngresso;

	@Column(name = "flag_delegato_uscita", length = 10)
	/**
	 * Flag che assume valori a seconda dell'uscita del capo
	 */
	private String flagDelegatoUscita;

	@Column(name = "ruolo_utente_uscita", length = 10)
	/**
	 * Flag che rappresenta il tipo delegato che ha registrato l’uscita del capo in
	 * BDN.
	 */
	private String ruoloUtenteUscita;

	/**
	 * Recupera l'dentificativo univoco in BDN del capo bovino
	 *
	 * @return capoId identificativo del capo bovino
	 */
	public Long getCapoId() {
		return capoId;
	}

	/**
	 * Imposta l'identificativo univoco in BDN del capo bovino
	 *
	 * @param capoId identificativo del capo bovino
	 */
	public void setCapoId(Long capoId) {
		this.capoId = capoId;
	}

	/**
	 * Recupera l'identificativo univoco dell'allevamento di detenzione
	 *
	 * @return allevId identificativo dell'allevamento
	 */
	public Long getAllevId() {
		return allevId;
	}

	/**
	 * Imposta l'identificativo univoco dell'allevamento di detenzione
	 *
	 * @param allevId identificativo dell'allevamento
	 */
	public void setAllevId(Long allevId) {
		this.allevId = allevId;
	}

	/**
	 * Recupera il codice dell'auricolare applicata al capo
	 *
	 * @return codice il codice sull'auricolare
	 */
	public String getCodice() {
		return codice;
	}

	/**
	 * Imposta il codice dell'auricolare applicata al capo
	 *
	 * @param codice il codice sull'auricolare
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}

	/**
	 * Recupera il codice della razza del capo
	 *
	 * @return razzaCodice il codice della razza del capo
	 */
	public String getRazzaCodice() {
		return razzaCodice;
	}

	/**
	 * Imposta il codice della razza del capo
	 *
	 * @param razzaCodice il codice della razza del capo
	 */
	public void setRazzaCodice(String razzaCodice) {
		this.razzaCodice = razzaCodice;
	}

	/**
	 * Recupera il sesso del capo
	 *
	 * @return sesso il sesso del capo
	 */
	public String getSesso() {
		return sesso;
	}

	/**
	 * Imposta il sesso del capo
	 *
	 * @param sesso il sesso del capo
	 */
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	/**
	 * Recupera la data di nascita del capo
	 *
	 * @return dtNascita la data di nascita del capo
	 */
	public Date getDtNascita() {
		return dtNascita;
	}

	/**
	 * Imposta la data di nascita del capo
	 *
	 * @param dtNascita la data di nascita del capo
	 */
	public void setDtNascita(Date dtNascita) {
		this.dtNascita = dtNascita;
	}

	/**
	 * Recupera il codice dell’azienda di detenzione
	 *
	 * @return aziendaCodice il codice dell’azienda di detenzione
	 */
	public String getAziendaCodice() {
		return aziendaCodice;
	}

	/**
	 * Imposta il codice dell’azienda di detenzione
	 *
	 * @param aziendaCodice il codice dell’azienda di detenzione
	 */
	public void setAziendaCodice(String aziendaCodice) {
		this.aziendaCodice = aziendaCodice;
	}

	/**
	 * Recupera la latitudine dell'azienda
	 *
	 * @return aziendaLatitudiine la latitudine dell'azineda
	 */
	public Double getAziendaLatitudine() {
		return aziendaLatitudine;
	}

	/**
	 * Imposta la latituine dell'azienda
	 *
	 * @param aziendLatitudine la latitudine dell'azineda
	 */
	public void setAziendaLatitudine(Double aziendaLatitudine) {
		this.aziendaLatitudine = aziendaLatitudine;
	}

	/**
	 * Ritorna la longitudine dell'azienda
	 *
	 * @return aziendaLongitudine la longitudine dell'azienda
	 */
	public Double getAziendaLongitudine() {
		return aziendaLongitudine;
	}

	/**
	 * Imposta la longitudine dell'azienda
	 *
	 * @param aziendaLongitudine la longitudine dell'azienda
	 */
	public void setAziendaLongitudine(Double aziendaLongitudine) {
		this.aziendaLongitudine = aziendaLongitudine;
	}

	/**
	 * Recupera il tipo delegato che ha registrato l’ingresso del capo in BDN
	 *
	 * @return ruoloUtenteIngresso ritorna il ruolo dell'utente che ha registrato
	 *         l'ingresso
	 */
	public String getRuoloUtenteIngresso() {
		return ruoloUtenteIngresso;
	}

	/**
	 * Imposta il tipo delegato che ha registrato l’ingresso del capo in BDN
	 *
	 * @param ruoloUtenteIngresso ritorna il ruolo dell'utente che ha registrato
	 *                            l'ingresso
	 */
	public void setRuoloUtenteIngresso(String ruoloUtenteIngresso) {
		this.ruoloUtenteIngresso = ruoloUtenteIngresso;
	}

	/**
	 * Recupera la data di ingresso del capo
	 *
	 * @return dtIngresso la data di ingresso del capo
	 */
	public Date getDtIngresso() {
		return dtIngresso;
	}

	/**
	 * Imposta la data di ingresso del capo
	 *
	 * @param dtIngresso la data di ingresso del capo
	 */
	public void setDtIngresso(Date dtIngresso) {
		this.dtIngresso = dtIngresso;
	}

	/**
	 * Recupera la data di macellazione del capo
	 *
	 * @return dtMacellazione la data di macellazione del capo
	 */
	public Date getDtMacellazione() {
		return dtMacellazione;
	}

	/**
	 * Imposta la data di macellazione del capo
	 *
	 * @param dtMacellazione la data di macellazione del capo
	 */
	public void setDtMacellazione(Date dtMacellazione) {
		this.dtMacellazione = dtMacellazione;
	}

	/**
	 * Recupera il codice del libro genealogico, se iscritto
	 *
	 * @return codLibro il codice del libro genealogico
	 */
	public String getCodLibro() {
		return codLibro;
	}

	/**
	 * Imposta il codice del libro genealogico, se iscritto
	 *
	 * @param codLibro il codice del libro genealogico
	 */
	public void setCodLibro(String codLibro) {
		this.codLibro = codLibro;
	}

	/**
	 * Recupera la descrizione del libro genealogico, se iscritto
	 *
	 * @return descrLibro la descrizione del libro genealogico
	 */
	public String getDescrLibro() {
		return descrLibro;
	}

	/**
	 * Imposta la descrizione del libro genealogico, se iscritto
	 *
	 * @param descrLibro la descrizione del libro genealogico
	 */
	public void setDescrLibro(String descrLibro) {
		this.descrLibro = descrLibro;
	}

	/**
	 * Recupera la data di comunicazione all’autorità competente dell’ingresso in
	 * stalla
	 *
	 * @return dtComAutoritaIngresso la data di comunicazione dell'ingresso in
	 *         stalla
	 */
	public Date getDtComAutoritaIngresso() {
		return dtComAutoritaIngresso;
	}

	/**
	 * Imposta la data di comunicazione all’autorità competente dell’ingresso in
	 * stalla
	 *
	 * @param dtComAutoritaIngresso la data di comunicazione dell'ingresso in stalla
	 */
	public void setDtComAutoritaIngresso(Date dtComAutoritaIngresso) {
		this.dtComAutoritaIngresso = dtComAutoritaIngresso;
	}

	/**
	 * Recupera la data di registrazione in BDN dell’ingresso in stalla
	 *
	 * @return dtInserimentoBdnIngresso la data di registrazione in BDN
	 *         dell'ingresso in stalla
	 */
	public Date getDtInserimentoBdnIngresso() {
		return dtInserimentoBdnIngresso;
	}

	/**
	 * Imposta la data di registrazione in BDN dell’ingresso in stalla
	 *
	 * @param dtInserimentoBdnIngresso la data di registrazione in BDN dell'ingresso
	 *                                 in stalla *
	 */
	public void setDtInserimentoBdnIngresso(Date dtInserimentoBdnIngresso) {
		this.dtInserimentoBdnIngresso = dtInserimentoBdnIngresso;
	}

	/**
	 * Recupera il codice fiscale del richiedente
	 *
	 * @return cuaa il codice fiscale del richiedente
	 */
	public String getCuaa() {
		return cuaa;
	}

	/**
	 * Imposta il codice fiscale del richiedente
	 *
	 * @param cuaa il codice fiscale del richiedente
	 */
	public void setCuaa(String cuaa) {
		this.cuaa = cuaa;
	}

	/**
	 * Recupera la data di comunicazione all’autorità competente dell’uscita del
	 * capo verso il macello
	 *
	 * @param dtComAutoritaUscita la data di comunicazione dell'uscita del capo
	 *                            verso il macello
	 */
	public Date getDtComAutoritaUscita() {
		return dtComAutoritaUscita;
	}

	/**
	 * Imposta la data di comunicazione all’autorità competente dell’uscita del capo
	 * verso il macello
	 *
	 * @return dtComAutoritaUscita la data di comunicazione dell'uscita del capo
	 *         verso il macello
	 */
	public void setDtComAutoritaUscita(Date dtComAutoritaUscita) {
		this.dtComAutoritaUscita = dtComAutoritaUscita;
	}

	/**
	 * Recupera la data di uscita del capo
	 *
	 * @return dtUscita la data di uscita del capo
	 */
	public Date getDtUscita() {
		return dtUscita;
	}

	/**
	 * Imposta la data di uscita del capo
	 *
	 * @param dtUscita la data di uscita del capo
	 */
	public void setDtUscita(Date dtUscita) {
		this.dtUscita = dtUscita;
	}

	/**
	 * Recupera la data di registrazione in BDN dell’uscita del capo verso macello.
	 *
	 * @return dtInserimentoBdnUscita la data di registrazione in BDN dell’uscita
	 *         del capo
	 */
	public Date getDtInserimentoBdnUscita() {
		return dtInserimentoBdnUscita;
	}

	/**
	 * Imposta la data di registrazione in BDN dell’uscita del capo verso macello.
	 *
	 * @param dtInserimentoBdnUscita la data di registrazione in BDN dell’uscita del
	 *                               capo
	 */
	public void setDtInserimentoBdnUscita(Date dtInserimentoBdnUscita) {
		this.dtInserimentoBdnUscita = dtInserimentoBdnUscita;
	}

	/**
	 * Recupera la data di inizio detenzione del capo
	 *
	 * @return dtInzioDetenzione la data di inizio detenzione del capo
	 */
	public Date getDtInizioDetenzione() {
		return dtInizioDetenzione;
	}

	/**
	 * Imposta la data di inizio detenzione del capo
	 *
	 * @param dtInzioDetenzione la data di inizio detenzione del capo
	 */
	public void setDtInizioDetenzione(Date dtInizioDetenzione) {
		this.dtInizioDetenzione = dtInizioDetenzione;
	}

	/**
	 * Recupera la data di fine detenzione del capo
	 *
	 * @return dtFineDetenzione la data di fine detenzione del capo
	 */
	public Date getDtFineDetenzione() {
		return dtFineDetenzione;
	}

	/**
	 * Imposta la data di fine detenzione del capo
	 *
	 * @Param dtFineDetenzione la data di fine detenzione del capo
	 */
	public void setDtFineDetenzione(Date dtFineDetenzione) {
		this.dtFineDetenzione = dtFineDetenzione;
	}

	/**
	 * Recupera il flag che assume valori a seconda dell'uscita del capo
	 *
	 * @return flagDelegatoUscita il flag dell'uscita del capo
	 */
	public String getFlagDelegatoUscita() {
		return flagDelegatoUscita;
	}

	/**
	 * Imposta il flag che assume valori a seconda dell'uscita del capo
	 *
	 * @param flagDelegatoUscita il flag dell'uscita del capo
	 */
	public void setFlagDelegatoUscita(String flagDelegatoUscita) {
		this.flagDelegatoUscita = flagDelegatoUscita;
	}

	/**
	 * Recupera il tipo delegato che ha registrato l’uscita del capo in BDN.
	 *
	 * @return ruoloUtenteUscita il ruolo dell'utente che ha registratp l'uscita del
	 *         capo
	 */
	public String getRuoloUtenteUscita() {
		return ruoloUtenteUscita;
	}

	/**
	 * Imposta il tipo delegato che ha registrato l’uscita del capo in BDN.
	 *
	 * @param ruoloUtenteUscita il ruolo dell'utente che ha registratp l'uscita del
	 *                          capo
	 */
	public void setRuoloUtenteUscita(String ruoloUtenteUscita) {
		this.ruoloUtenteUscita = ruoloUtenteUscita;
	}

	/**
	 * Recupera il flag che assume valori a seconda dell'ingresso del capo
	 *
	 * @return flagDelegatoUscita il flag dell'ingresso del capo
	 */
	public String getFlagDelegatoIngresso() {
		return flagDelegatoIngresso;
	}

	/**
	 * Imposta il flag che assume valori a seconda dell'ingresso del capo
	 *
	 * @param flagDelegatoUscita il flag dell'ingresso del capo
	 */
	public void setFlagDelegatoIngresso(String flagDelegatoIngresso) {
		this.flagDelegatoIngresso = flagDelegatoIngresso;
	}

	public Dmt_t_sessione getSessione() {
		return this.sessione;
	}

	public void setSessione(Dmt_t_sessione sessione) {
		this.sessione = sessione;
	}

	public String getCodicePremio() {
		return codicePremio;
	}

	public void setCodicePremio(String codicePremio) {
		this.codicePremio = codicePremio;
	}

	public Dmt_d_clsPremio_ValidazioneResponse getDmt_d_clsPremio_ValidazioneResponse() {
		return dmt_d_clsPremio_ValidazioneResponse;
	}

	public void setDmt_d_clsPremio_ValidazioneResponse(
			Dmt_d_clsPremio_ValidazioneResponse dmt_d_clsPremio_ValidazioneResponse) {
		this.dmt_d_clsPremio_ValidazioneResponse = dmt_d_clsPremio_ValidazioneResponse;
	}


}
