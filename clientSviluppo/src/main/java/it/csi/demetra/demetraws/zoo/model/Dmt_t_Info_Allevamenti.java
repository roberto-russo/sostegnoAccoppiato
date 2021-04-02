package it.csi.demetra.demetraws.zoo.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "DMT_T_INFO_ALLEVAMENTI")
public class Dmt_t_Info_Allevamenti implements Serializable{

	private static final long serialVersionUID = 7949322294669419786L;
	
	@Id
	@Column(name = "allev_id")
	/**
	 * identificativo univoco interno in BDN dell'allevamento
	 */
	private BigDecimal allevId;
	
	@Column(name = "flag_zona_montana")
	/**
	 * Flag che indica se l allevamento appartiene ad una zona montana
	 */
	private String flagZonaMontana;

//	public Long getIdSessione() {
//		return idSessione;
//	}
//
//	public void setIdSessione(Long idSessione) {
//		this.idSessione = idSessione;
//	}
//
//	public Dmt_t_sessione getSessione() {
//		return sessione;
//	}
//
//	public void setSessione(Dmt_t_sessione sessione) {
//		this.sessione = sessione;
//	}

	/**
	 * Metodo getter che ritorna il flag che indica se l'allevamento appartiene ad una zona montana.
	 * @return flagZonaMontana flag che indica se l'allevamento appartiene ad una zona montana.
	 */
	public String getFlagZonaMontana() {
		return flagZonaMontana;
	}

	/**
	 * Metodo setter che imposta il flag che indica se l'allevamento appartiene ad una zona montana.
	 * @param flagZonaMontana flag che indica se l'allevamento appartiene ad una zona montana.
	 */
	public void setFlagZonaMontana(String flagZonaMontana) {
		this.flagZonaMontana = flagZonaMontana;
	}

	/**
	 * Metodo getter che imposta l'identificativo univoco interno in BDN dell'allevamento.
	 * @return allevId identificativo univoco interno in BDN dell'allevamento.
	 */
	public BigDecimal getAllevId() {
		return allevId;
	}

	/**
	 * Metodo setter che imposta l'identificativo univoco interno in BDN dell'allevamento.
	 * @param allevId identificativo univoco interno in BDN dell'allevamento.
	 */
	public void setAllevId(BigDecimal allevId) {
		this.allevId = allevId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
