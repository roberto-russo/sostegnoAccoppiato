package it.csi.demetra.demetraws.zoo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "dmt_t_subentro_zoo")
public class Dmt_t_subentro_zoo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6478340611320768649L;

	@Id
	@Column(name= "id_subentro_zoo")
	@NotNull
	private long idSubentro;
	
	@Column(name = "anno_campagna")
	/**
	 * Anno della campagna
	 */
	private int annoCampagna;
	
	@Column(name = "cuaa_domanda")
	@NotNull
	/**
	 * codice fiscale del richiedente
	 */
	private String cuaaDomanda;
	
	@Column(name = "cuaa_subentro")
	@NotNull
	/**
	 * Codice fiscale del subentrante
	 */
	private String cuaaSubentro;
	
	@Column(name = "data_inizio")
	@Temporal(TemporalType.DATE)
	/**
	 * Data di inizio subentro
	 */
	private Date dataInizio;
	
	@Column(name = "data_fine")
	/**
	 * Data di fine subentro
	 */
	@Temporal(TemporalType.DATE)
	private Date dataFine;
	
	@Column(name = "ext_id_utente_aggiornamento")
	private long extIdUtenteAggiornamento;
	
	@Column(name = "note")
	private String note;

	public long getIdSubentro() {
		return idSubentro;
	}

	public void setIdSubentro(long idSubentro) {
		this.idSubentro = idSubentro;
	}

	/**
	 * Metodo getter che imposta l'anno della campagna
	 * @return annoCampagna anno della campagna
	 */
	public int getAnnoCampagna() {
		return annoCampagna;
	}

	/**
	 * Metodo setter che imposta l'anno della campagna
	 * @param annoCampagna anno della campagna
	 */
	public void setAnnoCampagna(int annoCampagna) {
		this.annoCampagna = annoCampagna;
	}

	/**
	 * Metodo getter che ritorna il codice fiscale del richiedente
	 * @return cuaaDomanda codice fiscale del richiedente
	 */
	public String getCuaaDomanda() {
		return cuaaDomanda;
	}

	/**
	 * Metodo setter che imposta il codice fiscale del richiedente
	 * @param cuaaDomanda codice fiscale del richiedente
	 */
	public void setCuaaDomanda(String cuaaDomanda) {
		this.cuaaDomanda = cuaaDomanda;
	}

	/**
	 * Metodo getter che ritorna il codice fiscale del subentrante
	 * @return cuaaSubentro codice fiscale del subentrante
	 */
	public String getCuaaSubentro() {
		return cuaaSubentro;
	}

	/**
	 * Metodo setter che imposta il codice fiscale del subentrante
	 * @param cuaaSubentro codice fiscale del subentro
	 */
	public void setCuaaSubentro(String cuaaSubentro) {
		this.cuaaSubentro = cuaaSubentro;
	}

	/**
	 * Metodo getter che ritorna la data di inizio subentro
	 * @return dataInizio data di inizio subentro
	 */
	public Date getDataInizio() {
		return dataInizio;
	}

	/**
	 * Metodo setter che imposta la data di inizio subentro
	 * @param dataInizio data di inizio subentro
	 */
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	/**
	 * Metodo getter che ritorna la data di fine subentro
	 * @return dataFine data di fine subentro
	 */
	public Date getDataFine() {
		return dataFine;
	}

	/**
	 * Metodo setter che imposta la data di fine subentro
	 * @param dataFine data di fine subentro
	 */
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public long getExtIdUtenteAggiornamento() {
		return extIdUtenteAggiornamento;
	}

	public void setExtIdUtenteAggiornamento(long extIdUtenteAggiornamento) {
		this.extIdUtenteAggiornamento = extIdUtenteAggiornamento;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
