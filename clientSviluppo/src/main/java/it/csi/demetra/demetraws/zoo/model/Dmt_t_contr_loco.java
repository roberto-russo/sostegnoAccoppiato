package it.csi.demetra.demetraws.zoo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_contr_loco_id;

@Entity
 @Table(name = "DMT_T_CONTR_LOCO")
@IdClass(Dmt_t_contr_loco_id.class)
public class Dmt_t_contr_loco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -244181523082419370L;

	
	
	@Column(name = "anno")
	/**
	 * Anno della campagna premi per cui si è formulata la
	 * richiesta di estrazione
	 */
	private Integer anno;
	
	@Column(name = "regione_istat")
	/**
	 * codice istat associato alla regione
	 */
	private long regioneIstat;
	
	@Column(name = "regione", length = 25)
	/**
	 * denominazione della regione
	 */
	private String regione;
	
	@Column(name = "provincia_istat")
	/**
	 * codice istat associato alla provincia
	 */
	private Integer provinciaIstat;
	
	@Column(name = "provincia", length =25)
	/**
	 * denominazione della provincia
	 */
	private String provincia;
	
	@Id
	@Column(name = "cuaa", length = 16)
	@NotNull
	/**
	 * codice fiscale del richiedente.
	 */
	private String cuaa;
	
	@Column(name = "cuaa_normalizzato", length = 20)
	/**
	 * codice fiscale del richiedente normalizzato.
	 */
	private String cuaaNormalizzato;
	
	@Column(name = "cod_ute", length = 5)
	private String codUte;
	
	@Column(name = "cod_asl", length = 16)
	private String codAsl;
	
	@Column(name = "cod_cai", length = 16)
	private String codCai;
	
	@Id
	@Column(name = "Marchio", length = 14)
	/**
	 * codice del marchio apposto al capo animale.
	 */
	private String marchio;
	
	@Column(name = "note", length = 400)
	/**
	 * descrizione
	 */
	private String note;
	
	@Column(name = "data_nascita")
	/**
	 * data di nascita del capo animale
	 */
	@Temporal(TemporalType.DATE)
	private Date dtNascita;
	
	@Column(name = "sesso", length = 1)
	/**
	 * sesso del capo animale
	 */
	private String sesso;
	
	@Column(name = "anomalie_zoo")
	private Integer anomalieZoo;
	
	@Column(name = "anomalie_cgo", length = 10)
	private String anomalie_cgo;
	
	@Column(name = "descrizione_anomalia", length = 400)
	/**
	 * descrizione dell'anomalia
	 */
	private String descrizioneAnomalia;


	/**
	 * metodo getter che ritorna l'anno campagna per cui si è formulata la richiesta
	 * di estrazione
	 * @return anno campagna per cui si è formulata la richiesta di estrazione.
	 */
	public Integer getAnno() {
		return anno;
	}

	/**
	 * metodo setter che imposta l'anno campagna
	 * @param anno anno campagna per cui si è formulata la richiesta di estrazione.
	 */
	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	/**
	 * metodo getter che ritorna il codice regione istat
	 * @return regioneIStat codice istat associato alla regione
	 */
	public long getRegioneIstat() {
		return regioneIstat;
	}

	/**
	 * metodo setter che imposta il codice regione istat
	 * @param regioneIstat codice istat associato alla regione
	 */
	public void setRegioneIstat(long regioneIstat) {
		this.regioneIstat = regioneIstat;
	}

	/**
	 * metodo getter che ritorna la denominazione della regionr
	 * @return regione denominazione della regione
	 */
	public String getRegione() {
		return regione;
	}

	/**
	 * metodo setter che imposta la denominazione della regione
	 * @param regione denominazione della regione
	 */
	public void setRegione(String regione) {
		this.regione = regione;
	}

	/**
	 * metodo getter che ritorna il codice proviciale istat
	 * @return provinciaIstat codice istat associato alla provincia
	 */
	public Integer getProvinciaIstat() {
		return provinciaIstat;
	}

	/**
	 * metodo setter che imposta il codice provinciale istat
	 * @param provinciaIstat codice istat associato alla provincia
	 */
	public void setProvinciaIstat(Integer provinciaIstat) {
		this.provinciaIstat = provinciaIstat;
	}

	/**
	 * metodo getter che ritorna la denominazione della provincia
	 * @return provincia denominazione della provincia.
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * meotodo setter che imposta la denominazione della provincia
	 * @param provincia denominazione della provincia.
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	/**
	 * metodo getter che ritorna il codice fiscale del richiedente
	 * @return cuaa codice fiscale del richiedente
	 */
	public String getCuaa() {
		return cuaa;
	}

	/**
	 * metodo setter che imposta il codice fiscale del richiedente
	 * @param cuaa codice fiscale del richiedente
	 */
	public void setCuaa(String cuaa) {
		this.cuaa = cuaa;
	}

	/**
	 * metodo getter che ritorna il codice fiscale del richiedente normalizzato
	 * @return cuaaNormalizzato codice fiscale del richiedente normalizzato.
	 */
	public String getCuaaNormalizzato() {
		return cuaaNormalizzato;
	}

	/**
	 * metodo setter che imposta il codice fiscale del richiedente normalizzato
	 * @param cuaaNormalizzato codice fiscale del richiedente normalizzato.s
	 */
	public void setCuaaNormalizzato(String cuaaNormalizzato) {
		this.cuaaNormalizzato = cuaaNormalizzato;
	}

	public String getCodUte() {
		return codUte;
	}

	public void setCodUte(String codUte) {
		this.codUte = codUte;
	}

	public String getCodAsl() {
		return codAsl;
	}

	public void setCodAsl(String codAsl) {
		this.codAsl = codAsl;
	}

	public String getCodCai() {
		return codCai;
	}

	public void setCodCai(String codCai) {
		this.codCai = codCai;
	}

	/**
	 * metodo getter che ritorna il codice marchio apposto al capo animale
	 * @return marchio codice marchio apposto al capo animale.
	 */
	public String getMarchio() {
		return marchio;
	}

	/**
	 * metodo setter che imposta il codice marchio apposto al capo animale
	 * @param marchio codice marchio apposto al capo animale.
	 */
	public void setMarchio(String marchio) {
		this.marchio = marchio;
	}

	/**
	 * metodo getter che ritorna le note
	 * @return note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * metodo setter che imposta le note
	 * @param note
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * metodo getter che ritorna la data di nascita del capo animale
	 * @return dtNascita data di nascita del capo animale.
	 */
	public Date getDtNascita() {
		return dtNascita;
	}

	/**
	 * metodo setter che imposta la data di nascita del capo animale.
	 * @param dtNascita data di nascita del capo animale.
	 */
	public void setDtNascita(Date dtNascita) {
		this.dtNascita = dtNascita;
	}

	/**
	 * metodo getter che ritorna il sesso del capo animale
	 * @return sesso sesso del capo animale
	 */
	public String getSesso() {
		return sesso;
	}

	/**
	 * metodo setter che imposta il sesso del capo animale
	 * @param sesso sesso del capo animale
	 */
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public Integer getAnomalieZoo() {
		return anomalieZoo;
	}

	public void setAnomalieZoo(Integer anomalieZoo) {
		this.anomalieZoo = anomalieZoo;
	}

	public String getAnomalie_cgo() {
		return anomalie_cgo;
	}

	public void setAnomalie_cgo(String anomalie_cgo) {
		this.anomalie_cgo = anomalie_cgo;
	}

	/**
	 * metodo getter che ritorna la descrizione dell'anomalia del capo animale
	 * @return descrizioneAnomalia descrizione dell'anomalia del capo animale.
	 */
	public String getDescrizioneAnomalia() {
		return descrizioneAnomalia;
	}

	/**
	 * metodo setter che imposta la descrizione dell'anomalia del capo aimale
	 * @param descrizioneAnomalia anomalia del capo animale.
	 */
	public void setDescrizioneAnomalia(String descrizioneAnomalia) {
		this.descrizioneAnomalia = descrizioneAnomalia;
	}
	
}
