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
@Table(name = "DMT_T_TWS_BDN_DU_CAPI_BOV")
/**
 * Classe dei capi bovini
 * 
 * @version 0.1 (03/04/2020)
 * @author Bcsoft
 *
 */
public class Dmt_t_Tws_bdn_du_capi_bovini implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -543360576165358523L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name= "id_autogenerato")
    private Long idAutogenerato;


	@ManyToOne
	@JoinColumn(name = "idSessione", nullable = false)
	private Dmt_t_sessione idSessione;

	@ManyToOne
	@JoinColumn(name = "FK_dmt_d_clsPrem_Valid", nullable = true)
	private Dmt_d_clsPremio_ValidazioneResponse dmt_d_clsPremio_ValidazioneResponse;

	@Column(name = "id_allevamento", precision = 10)
	@NotNull
	/**
	 * Identificativo univoco in DBN dell’allevamento
	 */
	private long allev_id;

	@Column(name = "id_capo", precision = 10)
	@NotNull
	/**
	 * Identificativo univoco in BDN del capo bovino
	 */
	private long capoId;

	@Column(name = "sesso_vitello", length = 1)
	/**
	 * Sesso del vitello
	 */
	private String sessoVitello;

	@Column(name = "CODICE_PREMIO")
	@NotNull
	private String codicePremio;

	@Column(name = "codice_vitello", length = 16)
	/**
	 * Codice identificativo del vitello
	 */
	private String codiceVitello;

	@Column(name = "codice", length = 16)
	/**
	 * Codice della marca auricolare applicata al capo bovino
	 */
	private String codice;

	@Column(name = "cod_libro", length = 3)
	/**
	 * Codice del libro genealogico se iscritta
	 */
	private String codLibro;

	@Column(name = "descr_libro", length = 500)
	/**
	 * Denominazione del libro genealogico se iscritta
	 */
	private String descLibro;

	@Column(name = "data_nascita")
	@Temporal(TemporalType.DATE)
	/**
	 * Data di nascita del capo
	 */
	private Date dataNascita;

	@Column(name = "data_nascita_vitello")
	@Temporal(TemporalType.DATE)
	/**
	 * Data di nascita del vitello
	 */
	private Date dtNascitaVitello;

	@Column(name = "cod_razza", length = 3)
	/**
	 * Codice della razza della vacca
	 */
	private String razzaCodice;

	@Column(name = "data_inizio_detenzione")
	@Temporal(TemporalType.DATE)
	/**
	 * Data di inizio detenzione. E valorizzata solo se il capo deve verificare in
	 * BDN un periodo minimo di detenzione
	 */
	private Date dtInizioDetenzione;

	@Column(name = "data_fine_detenzione")
	@Temporal(TemporalType.DATE)
	/**
	 * Data di fine detenzione. A partire dalla campagna 2010 è valorizzata solo se
	 * il capo deve verificare in BDN un periodo minimo di detenzione
	 */
	private Date dtFineDetenzione;

	@Column(name = "cod_azienda", length = 12)
	/**
	 * Codice dell''azienda presso cui è nato il vitello
	 */
	private String aziendaCodice;

	@Column(name = "azienda_longitudine", precision = 11, scale = 6)
	/**
	 * Longitudine dell azienda
	 */
	private double aziendaLongitudine;

	@Column(name = "azienda_latitudine", precision = 11, scale = 6)
	/**
	 * Latitudine dell azienda
	 */
	private double aziendaLatitudine;

	@Column(name = "flag_ibr", length = 1)
	/**
	 * Flag che indica se l azienda aderisce o meno, per l anno di campagna, a piani
	 * di risanamento per la IBR
	 */
	private String flagIbr;

	@Column(name = "flag_rispetto_prevalenza_ibr", length = 10)
	/**
	 * Flag che indica se l allevamento ha rispettato o meno l obiettivo prefissato
	 * per il rispetto della sieroprevalenza per lâ€™anno di riferimento
	 */
	private String flagRispettoPrevalenzaIbr;

	@Column(name = "vacca_data_ingresso")
	@Temporal(TemporalType.DATE)
	/**
	 * Data di ingresso in stalla del capo
	 */
	private Date vaccaDtIngresso;

	@Column(name = "vacca_data_com_aut_ingresso")
	@Temporal(TemporalType.DATE)
	/**
	 * Data di comunicazione all autorita competente dellâ€™ingresso
	 */
	private Date vaccaDtComAutIngresso;

	@Column(name = "vacca_data_inser_bdn_ingresso")
	@Temporal(TemporalType.DATE)
	/**
	 * Data di registrazione dell ingresso in BDN
	 */
	private Date vaccaDtInserBdnIngresso;

	@Column(name = "vitello_data_appl_marchio")
	@Temporal(TemporalType.DATE)
	/**
	 * Data di identificazione del vitello
	 */
	private Date vitelloDtApplMarchio;

	@Column(name = "vitello_data_com_aut_nascita")
	@Temporal(TemporalType.DATE)
	/**
	 * Data di comunicazione all autorita competente della nascita del vitello
	 */
	private Date vitelloDtComAutNascita;

	@Column(name = "vitello_data_inser_bdn_nascita")
	@Temporal(TemporalType.DATE)
	/**
	 * Data di registrazione in BDN della nascita del capo
	 */
	private Date vitelloDtInserBdnNascita;

	@Column(name = "flag_proroga_marcatura", length = 1)
	/**
	 * Flag che indica se l allevamento e o meno autorizzato a prorogare la
	 * marcatura dei capi entro 180 giorni dalla nascita
	 */
	private String flagProrogaMarcatura;

	@Column(name = "cuaa", length = 16)
	/**
	 * Codice fiscale del richiedente
	 */
	private String cuaa;

	@Column(name = "sesso", length = 1)
	/**
	 * Sesso del capo madre
	 */
	private String sesso;

	@Column(name = "vitello_capo_id", precision = 16)
	/**
	 * Identificativo univoco in BDN del vitello
	 */
	private long vitelloCapoId;

	@Column(name = "vitello_tipo_origine", length = 1)
	/**
	 * Flag che indica il tipo origine del vitello. N = nato in stella , W = nato in
	 * stalla da parto gemellare
	 */
	private String vitelloTipoOrigine;

	@Column(name = "vitello_data_com_aut_ingresso")
	@Temporal(TemporalType.DATE)
	/**
	 * Data di comunicazione all'autorita competente dell ingresso in stalla del
	 * vitello. Essendo nato in stalla coincide con la comunicazione della data di
	 * nascita
	 */
	private Date vitelloDtComAutIngresso;

	@Column(name = "vitello_data_ins_bdn_ingresso")
	@Temporal(TemporalType.DATE)
	/**
	 * Data di registrazione dell ingresso in stalla del vitello. Essendo nato in
	 * stalla coincide con la data di registrazione della nascita
	 */
	private Date vitello_data_ins_bdn_ingresso;

	@Column(name = "flag_delegato", length = 10)
	/**
	 * lag che indica se l allevamento ha conferito delega per operare in BDN
	 */
	private String flagDelegato;

	@Column(name = "flag_delegato_ingresso_vacca", length = 1)
	/**
	 * Flag che assume i seguenti valori: N= se l’ingresso è stato registrato in BDN
	 * dal detentore (e quindi non ha delegato altri ad operare in BDN) R= se la
	 * delega è regionale. In questo caso esiste un polo regionale che ha registrato
	 * l’ingresso del capo S= in tutti gli altri casi in cui il delegato è uno dei
	 * soggetti previsti dalla normativa in grado di operare in BDN su delega
	 * implicita o esplicita dell’allevatore (Associazione Professionale, Servizio
	 * Veterinario o Veterinario Aziendale )
	 */
	private String flagDelegatoIngressoVacca;

	@Column(name = "flag_delegato_nascita_vitello", length = 1)
	/**
	 * Flag che assume i seguenti valori: N= se il capo è stato iscritto dal
	 * detentore (e quindi non ha delegato altri ad operare in BDN) R= se la delega
	 * è regionale. In questo caso esiste un polo regionale che ha registrato la
	 * nascita del capo S= in tutti gli altri casi in cui il delegato è uno dei
	 * soggetti previsti dalla normativa in grado di operare in BDN su delega
	 * implicita o esplicita dell’allevatore (Associazione Professionale, Servizio
	 * Veterinario o Veterinario Aziendale )
	 */
	private String flagDelegatoNascitaVitello;

	@Column(name = "flag_delegato_ingresso_vitello", length = 1)
	/**
	 * Flag che assume i seguenti valori: N= se il capo è stato iscritto dal
	 * detentore (e quindi non ha delegato altri ad operare in BDN) R= se la delega
	 * è regionale. In questo caso esiste un polo regionale che ha registrato la
	 * nascita del capo S= in tutti gli altri casi in cui il delegato è uno dei
	 * soggetti previsti dalla normativa in grado di operare in BDN su delega
	 * implicita o esplicita dell’allevatore (Associazione Professionale, Servizio
	 * Veterinario o Veterinario Aziendale )
	 */
	private String flagDelegatoIngressoVitello;

	@Column(name = "ruolo_utente_ingr_vacca", length = 3)
	/**
	 *
	 */
	private String ruoloUtenteIngressoVacca;

	@Column(name = "ruolo_utente_nasc_vitello", length = 3)
	/**
	 *
	 */
	private String ruoloUtenteNascitaVitello;

	@Column(name = "ruolo_utente_ingr_vitello", length = 3)
	/**
	 *
	 */
	private String ruoloUtenteIngressovitello;

	/**
	 * @return
	 */
	public String getRuoloUtenteIngressoVacca() {
		return ruoloUtenteIngressoVacca;
	}

	/**
	 * @param ruoloUtenteIngressoVacca
	 */
	public void setRuoloUtenteIngressoVacca(String ruoloUtenteIngressoVacca) {
		this.ruoloUtenteIngressoVacca = ruoloUtenteIngressoVacca;
	}

	/**
	 * @return
	 */
	public String getRuoloUtenteNascitaVitello() {
		return ruoloUtenteNascitaVitello;
	}

	/**
	 * @param ruoloUtenteNascitaVitello
	 */
	public void setRuoloUtenteNascitaVitello(String ruoloUtenteNascitaVitello) {
		this.ruoloUtenteNascitaVitello = ruoloUtenteNascitaVitello;
	}

	/**
	 * @return
	 */
	public String getRuoloUtenteIngressovitello() {
		return ruoloUtenteIngressovitello;
	}

	/**
	 * @param ruoloUtenteIngressovitello
	 */
	public void setRuoloUtenteIngressovitello(String ruoloUtenteIngressovitello) {
		this.ruoloUtenteIngressovitello = ruoloUtenteIngressovitello;
	}

	/**
	 * Metodo get che ritorna l'identificativo univoco in BDN dell'allevamento
	 *
	 * @return allev_id identificativo univoco in BDN dell'allevamento
	 */
	public long getAllev_id() {
		return allev_id;
	}

	/**
	 * Metodo set che setta l'identificativo univoco in BDN dell'allevamento
	 *
	 * @param allev_id identificativo univoco in BDN dell'allevamento
	 */
	public void setAllev_id(long allev_id) {
		this.allev_id = allev_id;
	}

	/**
	 * Metodo get che ritorna l'identificativo univoco in BDN del capo bovino
	 *
	 * @return capoId identificativo univoco in BDN del capo bovino
	 */
	public long getCapoId() {
		return capoId;
	}

	/**
	 * Metodo set che setta l'identificativo univoco in BDN del capo bovino
	 *
	 * @param capoId identificativo univoco in BDN del capo bovino
	 */
	public void setCapoId(long capoId) {
		this.capoId = capoId;
	}

	/**
	 * Metodo get che ritorna il sesso del vitello
	 *
	 * @return sessoVitello sesso del vitello
	 */
	public String getSessoVitello() {
		return sessoVitello;
	}

	/**
	 * Metodo set che setta il sesso de vitello
	 *
	 * @param sessoVitello sesso del vitello
	 */
	public void setSessoVitello(String sessoVitello) {
		this.sessoVitello = sessoVitello;
	}

	/**
	 * Metodo get che ritorna il codice identificativo del vitello
	 *
	 * @return codiceVitello codice identificativo del vitello
	 */
	public String getCodiceVitello() {
		return codiceVitello;
	}

	/**
	 * Metodo set che setta il codice identificativo del vitello
	 *
	 * @param codiceVitello codice identificativo del vitello
	 */
	public void setCodiceVitello(String codiceVitello) {
		this.codiceVitello = codiceVitello;
	}

	/**
	 * Metodo get che ritorna il codice della marca auricolare applicata al capo
	 * bovino
	 *
	 * @return codice codice della marca auricolare applicata al capo bovino
	 */
	public String getCodice() {
		return codice;
	}

	/**
	 * Metodo set che setta il codice della marca auricolare applicata al capo
	 * bovino
	 *
	 * @param codice codice della marca auricolare applicata al capo bovino
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}

	/**
	 * Metodo get che ritorna il codice del libro genealogico se è iscritta
	 *
	 * @return codLibro codice del libro genealogico se è iscritta
	 */
	public String getCodLibro() {
		return codLibro;
	}

	/**
	 * Metodo set che setta il codice libro genealogico se è iscritta
	 *
	 * @param codLibro codice libro genealogico se è iscritta
	 */
	public void setCodLibro(String codLibro) {
		this.codLibro = codLibro;
	}

	/**
	 * Metodo get che ritorna la denominazione del libro genealogico se è iscritta
	 *
	 * @return descLibro denominazione del libro genealogico se è iscritta
	 */
	public String getDescLibro() {
		return descLibro;
	}

	/**
	 * Metodo set che ritorna la denominazione del libro genealogico se è iscritta
	 *
	 * @param descLibro denominazione del libro genealogico se è iscritta
	 */
	public void setDescLibro(String descLibro) {
		this.descLibro = descLibro;
	}

	/**
	 * Metodo get che ritorna la data di nascita del capo
	 *
	 * @return dataNascita data di nascita del capo
	 */
	public Date getDataNascita() {
		return dataNascita;
	}

	/**
	 * Metodo set che setta la data di nascita del capo
	 *
	 * @param dataNascita data di nascita del capo
	 */
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	/**
	 * Metodo get che ritorna la data di nascita del vitello
	 *
	 * @return dataNascitaVitello data di nascita del vitello
	 */
	public Date getDtNascitaVitello() {
		return dtNascitaVitello;
	}

	/**
	 * Metodo set che setta la data di nascita del vitello
	 *
	 * @param dataNascitaVitello data di nascita del vitello
	 */
	public void setDtNascitaVitello(Date dtNascitaVitello) {
		this.dtNascitaVitello = dtNascitaVitello;
	}

	/**
	 * Metodo get che ritorna il codice della razza della vacca
	 *
	 * @return razzaCodice codice della razza della vacca
	 */
	public String getRazzaCodice() {
		return razzaCodice;
	}

	/**
	 * Metodo set che setta il codice della razza della vacca
	 *
	 * @param razzaCodice docie della razza della vacca
	 */
	public void setRazzaCodice(String razzaCodice) {
		this.razzaCodice = razzaCodice;
	}

	/**
	 * Metodo get che ritorna la data di inizio detenzione.
	 *
	 * @return dtInizioDetenzione data di inizio detenzione
	 */
	public Date getDtInizioDetenzione() {
		return dtInizioDetenzione;
	}

	/**
	 * Metodo set che setta la data di inizio detenzione
	 *
	 * @param dtInizioDetenzione data di inizio detenzione
	 */
	public void setDtInizioDetenzione(Date dtInizioDetenzione) {
		this.dtInizioDetenzione = dtInizioDetenzione;
	}

	/**
	 * Metodo get che ritorna la data di fine detenzione
	 *
	 * @return stFineDetenzione data di fine detenzione
	 */
	public Date getDtFineDetenzione() {
		return dtFineDetenzione;
	}

	/**
	 * Metodo set che setta la data di fine detenzione
	 *
	 * @param dtFineDetenzione
	 */

	public void setDtFineDetenzione(Date dtFineDetenzione) {
		this.dtFineDetenzione = dtFineDetenzione;
	}

	/**
	 * Metodo get che ritorna il codice dell'azienda presso cui è nato il vitello
	 *
	 * @return aziendaCodice codice dell'azienda presso cui è nato il vitello
	 */
	public String getAziendaCodice() {
		return aziendaCodice;
	}

	/**
	 * Metodo set che setta il codice dell'azienda presso cui è nato il vitello
	 *
	 * @param aziendaCodice codice dell'azienda presso cui è nato i vitello
	 */
	public void setAziendaCodice(String aziendaCodice) {
		this.aziendaCodice = aziendaCodice;
	}

	/**
	 * Metodo get che ritorna la posizione longitudinale dell'azienda
	 *
	 * @return aziendaLongitudine posizione longitudinale dell'azienda
	 */
	public double getAziendaLongitudine() {
		return aziendaLongitudine;
	}

	/**
	 * Metodo set che setta la posizione longitudinale dell'azienda
	 *
	 * @param aziendaLongitudine posizione longitudinale dell'azienda
	 */
	public void setAziendaLongitudine(double aziendaLongitudine) {
		this.aziendaLongitudine = aziendaLongitudine;
	}

	/**
	 * Metodo get che ritorna la posizione latitudinale dell'azienda
	 *
	 * @return aziendaLatitudine posizione latitudinale dell'azienda
	 */
	public double getAziendaLatitudine() {
		return aziendaLatitudine;
	}

	/**
	 * Metodo set che setta la posizione latitudinale dell'azienda
	 *
	 * @param aziendaLatitudine posizione latitudinale dell'azienda
	 */
	public void setAziendaLatitudine(double aziendaLatitudine) {
		this.aziendaLatitudine = aziendaLatitudine;
	}

	/**
	 * Metodo get che ritorna il flag che indica se l'azienda aderisce o meno per
	 * l'anno campagna a piani di risanamento per la IBR
	 *
	 * @return flagIbr flag che indica se l'azienda aderisce o meno per l'anno
	 *         campagna a piani di risanamento pr la IBR
	 */
	public String getFlagIbr() {
		return flagIbr;
	}

	/**
	 * Metodo set che setta il flag che indica se l'azienda aderisce o meno per
	 * l'anno campagna a piani di risanamento per la IBR
	 *
	 * @param flagIbr flag che indica se l'azienda aderisce o meno per l'anno
	 *                campagna a piani di risanamento per la IBR
	 */
	public void setFlagIbr(String flagIbr) {
		this.flagIbr = flagIbr;
	}

	/**
	 * Metodo get che ritorna il flag che indica se l'allevamento ha rispettato o
	 * meno l'obiettivo prefissato per il rispetto della sieroprevalenza per l'anno
	 * di riferimento
	 *
	 * @return flagRispettoPrevalenzaIbr flag che indica se l'allevamento ha
	 *         rispettato o meno l'obiettivo prefissato per il rispetto della
	 *         sieroprevalenza per l'anno di riferimento
	 */
	public String getFlagRispettoPrevalenzaIbr() {
		return flagRispettoPrevalenzaIbr;
	}

	/**
	 * Metodo set che setta il flag che indica se l'allevamento ha rispettato o meno
	 * l'obiettivo prefissato per il rispetto della siroprevalenza per l'anno di
	 * riferimento
	 *
	 * @param flagRispettoPrevalenzaIbr flag che indica se l'allevamento ha
	 *                                  rispettato o meno l'obiettivo prefissato per
	 *                                  il rispetto della sieroprevalenza per l'anno
	 *                                  di riferimento
	 */
	public void setFlagRispettoPrevalenzaIbr(String flagRispettoPrevalenzaIbr) {
		this.flagRispettoPrevalenzaIbr = flagRispettoPrevalenzaIbr;
	}

	/**
	 * Metodo get che ritorna la data di ingresso in stalla del capo
	 *
	 * @return vaddaDtInfresso data di ingresso in stalla del capo
	 */
	public Date getVaccaDtIngresso() {
		return vaccaDtIngresso;
	}

	/**
	 * Metodo set che setta la data di ingresso in stalla del capo
	 *
	 * @param vaccaDtIngresso data di ingresso installa del capo
	 */
	public void setVaccaDtIngresso(Date vaccaDtIngresso) {
		this.vaccaDtIngresso = vaccaDtIngresso;
	}

	/**
	 * Metodo get che ritorna la data di comunicazione all'autorita competente
	 * dell'ingresso
	 *
	 * @return vaccaDtComAutIngresso data di comunicazione all'autorita competente
	 *         dell'ingresso
	 */
	public Date getVaccaDtComAutIngresso() {
		return vaccaDtComAutIngresso;
	}

	/**
	 * Metodo set che setta la data di comunicazione all'autorita competente
	 * dell'ingresso
	 *
	 * @param vaccaDtComAutIngresso data di comunicazione all'autorita competente
	 *                              dell'ingresso
	 */
	public void setVaccaDtComAutIngresso(Date vaccaDtComAutIngresso) {
		this.vaccaDtComAutIngresso = vaccaDtComAutIngresso;
	}

	/**
	 * Metodo get che ritorna la data di registrazione dell'ingresso in BDN
	 *
	 * @return vaccaDtInserBdnIngresso data di registrazione dell'ingresso in BDN
	 */
	public Date getVaccaDtInserBdnIngresso() {
		return vaccaDtInserBdnIngresso;
	}

	/**
	 * Metodo set che setta la data di registrazione dell'ingresso in BDN
	 *
	 * @param vaccaDtInserBdnIngresso data di registrazione dell'ingresso in BDN
	 */
	public void setVaccaDtInserBdnIngresso(Date vaccaDtInserBdnIngresso) {
		this.vaccaDtInserBdnIngresso = vaccaDtInserBdnIngresso;
	}

	/**
	 * Metodo get che ritorna la data di identificazione del vitello
	 *
	 * @return vitelloDtApplMarchio data di identificazione del vitello
	 */
	public Date getVitelloDtApplMarchio() {
		return vitelloDtApplMarchio;
	}

	/**
	 * Metodo set che ritorna la data di identificazione del vitello
	 *
	 * @param vitelloDtApplMarchio data di identificazione del vitello
	 */
	public void setVitelloDtApplMarchio(Date vitelloDtApplMarchio) {
		this.vitelloDtApplMarchio = vitelloDtApplMarchio;
	}

	/**
	 * Metodo get che ritorna la data di comunicazione all'autorita competente della
	 * nascita del vitello
	 *
	 * @return vitelloDtcomAutNascita data di comunicazione all'autorita competente
	 *         della nascita del vitello
	 */
	public Date getVitelloDtComAutNascita() {
		return vitelloDtComAutNascita;
	}

	/**
	 * Metodo set che setta la data di comunicazione all'autorita competente della
	 * nascita del vitello
	 *
	 * @param vitelloDtComAutNascita data do comunicazione al'autorita competente
	 *                               della nascita del vitello
	 */
	public void setVitelloDtComAutNascita(Date vitelloDtComAutNascita) {
		this.vitelloDtComAutNascita = vitelloDtComAutNascita;
	}

	/**
	 * Metodo get che ritorna la data di registrazione in BDN della nascita del
	 * vitello
	 *
	 * @return vitelloDtInserBdnNascita data di registrazione in BDN della nascita
	 *         del vitello
	 */
	public Date getVitelloDtInserBdnNascita() {
		return vitelloDtInserBdnNascita;
	}

	/**
	 * Metodo set che ritorna la data di registrazione in BDN della nascita del
	 * vitello
	 *
	 * @param vitelloDtInserBdnNascita data di registrazione in BDN della nascita
	 *                                 del vitello
	 */
	public void setVitelloDtInserBdnNascita(Date vitelloDtInserBdnNascita) {
		this.vitelloDtInserBdnNascita = vitelloDtInserBdnNascita;
	}

	/**
	 * Metodo get che ritorna il flag che indica se l'allevamento è o meno
	 * autorizzato a prorogare la marcatura dei capi entro 180 giorni dalla nascita
	 *
	 * @return detFlagProrogaMarcatura flag che indica se l'allevamento è o meno
	 *         autorizzato a prorogare la marcature dei capi entro 180 giorni dalla
	 *         nascita
	 */
	public String getFlagProrogaMarcatura() {
		return flagProrogaMarcatura;
	}

	/**
	 * Metodo set che setta il flag che indica se l'allevamento è o meno autorizzato
	 * a prorogare la marcatura dei capi entro 180 giorni dalla nascita
	 *
	 * @param flagProrogaMarcatura flag che indica se l'allevamento è o meno
	 *                             autorizzato a prorogare la marcatura dei capi
	 *                             entro 180 giorni dalla nascita
	 */
	public void setFlagProrogaMarcatura(String flagProrogaMarcatura) {
		this.flagProrogaMarcatura = flagProrogaMarcatura;
	}

	/**
	 * Metodo get che ritorna il codice fiscale del richiedente
	 *
	 * @return cuaa codice fiscale del richiedente
	 */
	public String getCuaa() {
		return cuaa;
	}

	/**
	 * Metodo set che setta il codice fiscale del richiedente
	 *
	 * @param cuaa codice fiscale del richiedente
	 */
	public void setCuaa(String cuaa) {
		this.cuaa = cuaa;
	}

	/**
	 * Metodo get che ritorna il sesso del capo
	 *
	 * @return sesso sesso del capo
	 */
	public String getSesso() {
		return sesso;
	}

	/**
	 * Metodo set che setta il sesso del capo
	 *
	 * @param sesso
	 */
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	/**
	 * Metodo get che ritorna l'identificativo univoco in BDN del vitello
	 *
	 * @return vitelloCapoId identificativo univoco in BDN del vitello
	 */
	public long getVitelloCapoId() {
		return vitelloCapoId;
	}

	/**
	 * Metodo set che setta l'identificativo univoco in BDN del vitello
	 *
	 * @param vitelloCapoId identificativo univoco in BDN del vitello
	 */
	public void setVitelloCapoId(long vitelloCapoId) {
		this.vitelloCapoId = vitelloCapoId;
	}

	/**
	 * Metodo get che ritorna il flag che indica il tipo di origine del vitello
	 *
	 * @return vitelloTipoOrigine flag che indica il tipo di origine del vitello
	 */
	public String getVitelloTipoOrigine() {
		return vitelloTipoOrigine;
	}

	/**
	 * Metodo set che setta il flag che indica il tipo di origine del vitello
	 *
	 * @param vitelloTipoOrigine flag che indica il tipo di origine del vitello
	 */
	public void setVitelloTipoOrigine(String vitelloTipoOrigine) {
		this.vitelloTipoOrigine = vitelloTipoOrigine;
	}

	/**
	 * Meyofo get che ritorna la data di comunicazione all'autorita competente
	 * dell'ingresso in stalla del vitello
	 *
	 * @return vitelloDtComAutIngresso data di comunicazione all'autorita competente
	 *         dell'ingresso in stalla del vitello
	 */
	public Date getVitelloDtComAutIngresso() {
		return vitelloDtComAutIngresso;
	}

	/**
	 * Metodo set che setta la data di comunicazione all'autorita competente
	 * dell'ingresso in stalla del vitello
	 *
	 * @param vitelloDtComAutIngresso data di comunicazione all'autorita competente
	 *                                dell'ingresso in stalla del vitello
	 */
	public void setVitelloDtComAutIngresso(Date vitelloDtComAutIngresso) {
		this.vitelloDtComAutIngresso = vitelloDtComAutIngresso;
	}

	/**
	 * Metodo get che ritorna la data di registrazione dell'ingresso in stalla del
	 * vitello
	 *
	 * @return vitello_data_ins_bdn_ingresso data di registrazione dell'ingresso in
	 *         stalla del vitello
	 */
	public Date getVitello_data_ins_bdn_ingresso() {
		return vitello_data_ins_bdn_ingresso;
	}

	/**
	 * Metodo set che setta la data di registrazione dell'ingresso in stalla del
	 * vitello
	 *
	 * @param vitello_data_ins_bdn_ingresso data di registrazione dell'ingresso
	 *                                      installa del vitello
	 */
	public void setVitello_data_ins_bdn_ingresso(Date vitello_data_ins_bdn_ingresso) {
		this.vitello_data_ins_bdn_ingresso = vitello_data_ins_bdn_ingresso;
	}

	/**
	 * Metodo get che ritorna il flag che indica se l'allevamento ha conferito
	 * delega per operare in BDN
	 *
	 * @return flagDelegato flag che indica se l'allevamento ha conferito delega per
	 *         operare in BDN
	 */
	public String getFlagDelegato() {
		return flagDelegato;
	}

	/**
	 * Metodo set che setta il flag che indica se l'allevamento ha conferito delega
	 * per operare in BDN
	 *
	 * @param flagDelegato
	 */
	public void setFlagDelegato(String flagDelegato) {
		this.flagDelegato = flagDelegato;
	}

	/**
	 * Metodo get che ritorna il flag che può assumere i seguenti valori: N R S, per
	 * i dettagli vedere descrizione attributo.
	 *
	 * @return flagDelegatoIngressoVacca flag che può assumere i seguenti valori: N
	 *         R S
	 */
	public String getFlagDelegatoIngressoVacca() {
		return flagDelegatoIngressoVacca;
	}

	/**
	 * Metodo set che setta il flag che può assumere i seguenti valori: N R S, per i
	 * dettagli vedere descrizione attributo
	 *
	 * @param flagDelegatoIngressoVacca flag che può assumere i seguenti valori: N R
	 *                                  S
	 */
	public void setFlagDelegatoIngressoVacca(String flagDelegatoIngressoVacca) {
		this.flagDelegatoIngressoVacca = flagDelegatoIngressoVacca;
	}

	/**
	 * Metodo get che ritorna il flag che può assumere i seguenti valori: N R S, per
	 * i dettagli vedere desceizione attributo
	 *
	 * @return flagDelegatoNascitaVitello flag che può assumere i seguenti valori: N
	 *         R S.
	 */
	public String getFlagDelegatoNascitaVitello() {
		return flagDelegatoNascitaVitello;
	}

	/**
	 * Metodo set che ritorna il flag che può assumere i seguenti valori: N R S, per
	 * i dettagli vedere descrizione attributo
	 *
	 * @param flagDelegatoNascitaVitello flag che può assumere i seguenti valori: N
	 *                                   R S
	 */
	public void setFlagDelegatoNascitaVitello(String flagDelegatoNascitaVitello) {
		this.flagDelegatoNascitaVitello = flagDelegatoNascitaVitello;
	}

	/**
	 * Metodo get che ritorna il flag che può assumere i seguenti valori: N R S, per
	 * i dettagli vedere desceizione attributo
	 *
	 * @return flagDelegatoIngressoVitello flag che può assumere i seguenti valori:
	 *         N R S.
	 */
	public String getFlagDelegatoIngressoVitello() {
		return flagDelegatoIngressoVitello;
	}

	/**
	 * Metodo set che ritorna il flag che può assumere i seguenti valori: N R S, per
	 * i dettagli vedere descrizione attributo
	 *
	 * @param flagDelegatoIngressoVitello flag che può assumere i seguenti valori: N
	 *                                    R S
	 */
	public void setFlagDelegatoIngressoVitello(String flagDelegatoIngressoVitello) {
		this.flagDelegatoIngressoVitello = flagDelegatoIngressoVitello;
	}

	public Dmt_t_sessione getIdSessione() {
		return this.idSessione;
	}

	public void setIdSessione(Dmt_t_sessione sessione) {
		this.idSessione = sessione;
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