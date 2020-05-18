package it.csi.demetra.demetraws.zoo.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


@Entity
@Table(name = "DMT_T_INFO_ALLEVAMENTI")
public class Dmt_t_Info_Allevamenti implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7949322294669419786L;
	
	@Id
	@Column(name = "allev_id", precision = 10)
	/**
	 * identificativo univoco interno in BDN dell'allevamento
	 */
	private BigDecimal allevId;
	
	@Column(name = "flag_zona_montana", length = 10)
	/**
	 * Flag che indica se l allevamento appartiene ad una zona montana
	 */
	private String flagZonaMontana;

	public Long getIdSessione() {
		return idSessione;
	}

	public void setIdSessione(Long idSessione) {
		this.idSessione = idSessione;
	}

	public Dmt_t_sessione getSessione() {
		return sessione;
	}

	public void setSessione(Dmt_t_sessione sessione) {
		this.sessione = sessione;
	}

	public String getFlagZonaMontana() {
		return flagZonaMontana;
	}

	public void setFlagZonaMontana(String flagZonaMontana) {
		this.flagZonaMontana = flagZonaMontana;
	}

	public BigDecimal getAllevId() {
		return allevId;
	}

	public void setAllevId(BigDecimal allevId) {
		this.allevId = allevId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
