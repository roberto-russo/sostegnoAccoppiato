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

import org.hibernate.annotations.ColumnDefault;

@Entity
/*
 * Tabella dei Capi per Premio ed allevamento scaricati da BDN con Web Service
 * relativi alle Domande Uniche.
 */
@Table(name = "DMT_T_TBDN_DU_CAPI")
/**
 * Model dei Capi per Premio ed allevamento scaricati da BDN con Web Service
 * relativi alle Domande Uniche.
 * 
 * @version 0.1 (2-04-2020)
 * @author Bcsoft
 *
 */
public class Dmt_t_Tbdn_du_capi implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 2868564329283728964L;

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

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ALLEV_ID")
	@NotNull
	/**
	 * Identificativo univoco in BDN dell’allevamento di detenzione del capo
	 */
	private long allevId;

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_CAPO", length = 25)
	@NotNull
	/**
	 * Identificativo univoco in BDN del capo bovino
	 */
	private long capoId;

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CODICE", length = 15)
	@NotNull
	/**
	 * Codice della marca auricolare applicata al capo bovino
	 */
	private String codice;

	@Column(name = "SESSO", length = 1)
	/**
	 * Sesso del capo
	 */
	private String sesso;

	@Column(name = "CODICE_PREMIO")
	@NotNull
	private String codicePremio;

	@Column(name = "DATA_NASCITA")
	@Temporal(TemporalType.DATE)
	/**
	 * Data di nascita del capo.
	 */
	private Date dtNascita;

	@Column(name = "COD_RAZZA", length = 3)
	@NotNull
	@ColumnDefault("'TRB'")
	/**
	 * Codice della razza del capo
	 */
	private String razzaCodice;

	@Column(name = "DATA_INIZIO_DETENZ")
	@Temporal(TemporalType.DATE)
	/**
	 * Data di inizio detenzione. A partire dalla campagna 2010 è valorizzata solo
	 * se il capo deve verificare in BDN un periodo minimo di detenzione
	 */
	private Date dtInizioDetenzione;

	@Column(name = "DATA_FINE_DETENZ")
	@Temporal(TemporalType.DATE)
	/*
	 * Data di fine detenzione. A partire dalla campagna 2010 è valorizzata solo se
	 * il capo deve verificare in BDN un periodo minimo di detenzione
	 */
	private Date dtFineDetenzione;

	@Column(name = "COD_AZIENDA", length = 16)
	/**
	 * Codice aziendale
	 */
	private String aziendaCodice;

	@Column(name = "CAPO_COD_MADRE", length = 25)
	/**
	 * Codice della madre del vitello. Valorizzato solo a partire dalla campagna
	 * 2010
	 */
	private String capoCodMadre;

	@Column(name = "COD_LIBRO", length = 25)
	/**
	 * Codice del libro genealogico a cui risulta iscritta la madre del vitello al
	 * momento del parto. Valorizzato solo a partire dalla campagna 2010
	 * 
	 */
	private String codLibroMadre;

	@Column(name = "DESC_LIBRO_MADRE", length = 50)
	/**
	 * Descrizione estesa del libro genealogico a cui risulta iscritta la madre del
	 * vitello al momento del parto. Valorizzato solo a partire dalla campagna 2010
	 */
	private String descLibroMadre;

	@Column(name = "DATA_MACELLAZIONE")
	@Temporal(TemporalType.DATE)
	/**
	 * Identificativo univoco in BDN dell’allevamento di detenzione del capo
	 */
	private Date dtMacellazione;

	/**
	 * Metodo get che tirorna l'id allevamento
	 *
	 * @return allevId id allevamento di tipo long
	 */
	public long getAllevId() {
		return allevId;
	}

	/**
	 * Metodo set che setta l'attributo allevId ovvero l'id dell'allevamento.
	 *
	 * @param allevId id allevamento di tipo long
	 */
	public void setAllevId(long allevId) {
		this.allevId = allevId;
	}

	/**
	 * Metodo get che ritorna l'id del capo animale.
	 *
	 * @return capoId id del capo animale di tipo long
	 */
	public long getCapoId() {
		return capoId;
	}

	/**
	 * Metodo set che setta l'id del capo animale.
	 *
	 * @param capoId id del capo animale di tipo long
	 */
	public void setCapoId(long capoId) {
		this.capoId = capoId;
	}

	/**
	 * Metodo get che ritorna il codice della marca auricolare applicata al capo.
	 *
	 * @return codice codice della marca auricolare applicata al capo di tipo long.
	 */
	public String getCodice() {
		return codice;
	}

	/**
	 * Metodo set che setta il codice della marca auricolare applicata al capo
	 *
	 * @param codice codice della marca auricolare applicata al capo di tipo long
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}

	/**
	 * Metodo get che ritorna il sesso del capo di tipo String.
	 *
	 * @return sesso sesso del capo di tipo String.
	 */
	public String getSesso() {
		return sesso;
	}

	/**
	 * Metodo set che setta il sesso del capo animale
	 *
	 * @param sesso sesso del capo animale di tipo String.
	 */
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	/**
	 * Metodo get che ritorna la data di nascita del capo.
	 *
	 * @return dtNascita data di nascita del capo di tipo String.
	 */
	public Date getDtNascita() {
		return dtNascita;
	}

	/**
	 * Metodo set che setta la data di nascita del capo
	 *
	 * @param dtNascita data di nascita del capo di tipo String.
	 */
	public void setDtNascita(Date dtNascita) {
		this.dtNascita = dtNascita;
	}

	/**
	 * Metodo get che ritorna il codice della razza di appartenenza del capo
	 * codificata nella tabella RAZZE.
	 *
	 * @return razaCodice codice della razza di appartenenza del capo animale di
	 *         tipo String.
	 */
	public String getRazzaCodice() {
		return razzaCodice;
	}

	/**
	 * Metodo set che setta il codice della razza di appartenenza del capo
	 * codificata nella tabella RAZZE.
	 *
	 * @param razzaCodice codice della razza di appartenenza del capo animale di
	 *                    tipo String.
	 */
	public void setRazzaCodice(String razzaCodice) {
		this.razzaCodice = razzaCodice;
	}

	/**
	 * etodo get che ritorna la data di inizio detenzione.
	 *
	 * @return dtInizioDetenzione data di inizio detenzione di tipo String.
	 */
	public Date getDtInizioDetenzione() {
		return dtInizioDetenzione;
	}

	/**
	 * Metodo set che setta la data di inizio detenzione.
	 *
	 * @param dtInizioDetenzione data di inizio detenzione di tipo String.
	 */
	public void setDtInizioDetenzione(Date dtInizioDetenzione) {
		this.dtInizioDetenzione = dtInizioDetenzione;
	}

	/**
	 * Metodo get che ritorna la tada di fine detenzione.
	 *
	 * @return dtFineDetenzione data di fine detenzione di tipo String.
	 */
	public Date getDtFineDetenzione() {
		return dtFineDetenzione;
	}

	/**
	 * Metodo set che setta la data di fine detenzione.
	 *
	 * @param dtFineDetenzione data di fine detenzione di tipo String.
	 */
	public void setDtFineDetenzione(Date dtFineDetenzione) {
		this.dtFineDetenzione = dtFineDetenzione;
	}

	/**
	 * Metodo get che ritorna il codice aziendale.
	 *
	 * @return aziendaCodice codice aziendale di tipo String.
	 */
	public String getAziendaCodice() {
		return aziendaCodice;
	}

	/**
	 * Metodo set che setta il codice aziendale
	 *
	 * @param aziendaCodice codice aziendale di tipo String.
	 */
	public void setAziendaCodice(String aziendaCodice) {
		this.aziendaCodice = aziendaCodice;
	}

	/**
	 * Metodo get che ritorna il codice della madre del vitello.
	 *
	 * @return capoCodMadre codice della madre del vitello di tipo String.
	 */
	public String getCapoCodMadre() {
		return capoCodMadre;
	}

	/**
	 * Metodo set che setta il codice della madre del vitello.
	 *
	 * @param capoCodMadre codice della madre del vitello di tipo String.
	 */
	public void setCapoCodMadre(String capoCodMadre) {
		this.capoCodMadre = capoCodMadre;
	}

	/**
	 * Metodo get che ritorna il codice del libro genealogico a cui risulta iscritta
	 * la madre del vitello al momento del parto
	 *
	 * @return codLibroMadre codice del libro genealogico a cui risulta iscritta la
	 *         madre del vitello al momento del parto di tipo String.
	 */
	public String getCodLibroMadre() {
		return codLibroMadre;
	}

	/**
	 * Metodo set che setta il codice del libro genealogico a cui risulta iscritta
	 * la madre del vitello al momento del parto.
	 *
	 * @param codLibroMadre codice del libro genealogico a cui risulta iscritta la
	 *                      madre del vitello al momento del parto di tipo String.
	 */
	public void setCodLibroMadre(String codLibroMadre) {
		this.codLibroMadre = codLibroMadre;
	}

	/**
	 * Metodo get che ritorna la descrizione estesa del libro genealogico a cui
	 * risulta iscritta la madre del vitello al momento del parto.
	 *
	 * @return descLibroMadre descrizione estesa del libro a cui risulta iscritta la
	 *         madre del vitello al momento del parto di tipo String.
	 */
	public String getDescLibroMadre() {
		return descLibroMadre;
	}

	/**
	 * Metodo set che setta la descrizione estesa del libro genealogico a cui
	 * risulta iscritta la madre del vitello al momento del parto.
	 *
	 * @param descLibroMadre descrizione estesa del libro a cui risulta iscritta la
	 *                       madre del vitello al momento del parto di tipo String.
	 */
	public void setDescLibroMadre(String descLibroMadre) {
		this.descLibroMadre = descLibroMadre;
	}

	/**
	 * metodo get che ritorna la data di macellazione del capo.
	 *
	 * @return dtMacellazione data di macellazione del capo di tipo String.
	 */
	public Date getDtMacellazione() {
		return dtMacellazione;
	}

	/**
	 * Metodo set che setta la data di macellazione del capo.
	 *
	 * @param dtMacellazione data di macellazione del capo.
	 */
	public void setDtMacellazione(Date dtMacellazione) {
		this.dtMacellazione = dtMacellazione;
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