package it.csi.demetra.demetraws.zoo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_d_logger_id;

@Entity
@Table(name = "DMT_D_LOGGER")
@IdClass(Dmt_d_logger_id.class)
public class Dmt_d_logger implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1515828060901867701L;


	  @Id
		@Column(name = "id_sessione")
		private Long idSessione;
		
		@MapsId
		@ManyToOne
		@JoinColumn(name = "id_sessione", nullable = false)
		private Dmt_t_sessione sessione;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_log")
	private Long idLog;
	
	@Column(name = "tipo_log", length = 10)
	@ColumnDefault("'INFO'")
	private String tipoLog;
	
	@Column(name = "nome_classe_chiamante", length = 100)
	@NotNull
	private String nomeClasseChiamante;
	
	@Column(name = "messaggio", length = 400)
	@ColumnDefault("'no message avaible'")
	private String messaggio;
	
	@Column(name = "data_generazione_log")
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date dataGenerazioneLog;
	
	public Dmt_d_logger() {
		
	}
	
	public Dmt_d_logger(Long idLog) {
		this.idLog = idLog;
	}

	public Long getIdLog() {
		return idLog;
	}

	public String getTipoLog() {
		return tipoLog;
	}

	public void setTipoLog(String tipoLog) {
		this.tipoLog = tipoLog;
	}

	public String getNomeClasseChiamante() {
		return nomeClasseChiamante;
	}

	public void setNomeClasseChiamante(String nomeClasseChiamante) {
		this.nomeClasseChiamante = nomeClasseChiamante;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}

	public Date getDataGenerazioneLog() {
		return dataGenerazioneLog;
	}

	public void setDataGenerazioneLog(Date dataGenerazioneLog) {
		this.dataGenerazioneLog = dataGenerazioneLog;
	}

	public Dmt_t_sessione getSessione() {
		return sessione;
	}

	public void setSessione(Dmt_t_sessione sessione) {
		this.sessione = sessione;
	}

	public void setIdLog(Long idLog) {
		this.idLog = idLog;
	}

	public Long getIdSessione() {
		return idSessione;
	}

	public void setIdSessione(Long idSessione) {
		this.idSessione = idSessione;
	}
	

}
