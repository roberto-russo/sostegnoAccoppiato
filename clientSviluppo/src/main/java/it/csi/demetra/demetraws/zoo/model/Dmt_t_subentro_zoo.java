package it.csi.demetra.demetraws.zoo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
	private int annoCampagna;
	
	@Column(name = "cuaa_domanda")
	@NotNull
	private String cuaaDomanda;
	
	@Column(name = "cuaa_subentro")
	@NotNull
	private String cuaaSubentro;
	
	@Column(name = "data_inizio")
	@Temporal(TemporalType.DATE)
	private Date dataInizio;
	
	@Column(name = "data_fine")
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

	public int getAnnoCampagna() {
		return annoCampagna;
	}

	public void setAnnoCampagna(int annoCampagna) {
		this.annoCampagna = annoCampagna;
	}

	public String getCuaaDomanda() {
		return cuaaDomanda;
	}

	public void setCuaaDomanda(String cuaaDomanda) {
		this.cuaaDomanda = cuaaDomanda;
	}

	public String getCuaaSubentro() {
		return cuaaSubentro;
	}

	public void setCuaaSubentro(String cuaaSubentro) {
		this.cuaaSubentro = cuaaSubentro;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

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
