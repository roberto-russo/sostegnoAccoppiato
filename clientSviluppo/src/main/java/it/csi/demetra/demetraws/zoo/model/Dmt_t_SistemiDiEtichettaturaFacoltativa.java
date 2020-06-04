package it.csi.demetra.demetraws.zoo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Dmt_t_sistemi_etichettatura")
public class Dmt_t_SistemiDiEtichettaturaFacoltativa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1421420988744825874L;

	
	
	
	@Id
	@Column(name = "cuaa")
	/**
	 * cuaa del soggetto richiedente
	 */
	private String cuaa;
	
	@Column(name= "flag_etichettatura")
	/**
	 * S -> se l'intestatario conincide con il soggetto aderente a sistemi di etichettatura facoltativa
	 * N -> se l'intenstatario non conincide con il soggetto aderente a sistemi di etichettatura facoltativa
	 */
	private String flagEtichettatura;

	public String getCuaa() {
		return cuaa;
	}

	public void setCuaa(String cuaa) {
		this.cuaa = cuaa;
	}

	public String getFlagEtichettatura() {
		return flagEtichettatura;
	}

	public void setFlagEtichettatura(String flagEtichettatura) {
		this.flagEtichettatura = flagEtichettatura;
	}
	
	
}
