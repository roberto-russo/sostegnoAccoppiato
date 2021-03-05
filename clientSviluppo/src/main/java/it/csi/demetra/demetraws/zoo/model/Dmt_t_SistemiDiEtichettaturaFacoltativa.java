package it.csi.demetra.demetraws.zoo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Dmt_t_sistemi_etichettatura")
public class Dmt_t_SistemiDiEtichettaturaFacoltativa implements Serializable{


	private static final long serialVersionUID = 1421420988744825874L;

	
	
	
	@Id
	@Column(name = "cuaa")
	/**
	 * codice fiscale del richiedente
	 */
	private String cuaa;
	
	@Column(name= "flag_etichettatura")
	/**
	 * Flag che indica l'adesione ai sistemi di etichettatura facoltativa.
	 * Puo' assumere i seguenti valori:
	 * - S -> se l'intestatario conincide con il soggetto aderente a sistemi di etichettatura facoltativa
	 * - N -> se l'intenstatario non conincide con il soggetto aderente a sistemi di etichettatura facoltativa
	 */
	private String flagEtichettatura;

	/**
	 * Metodo getter che ritorna il codice fiscale del richiedente
	 * @return cuaa codice fiscale del richiedente
	 */
	public String getCuaa() {
		return cuaa;
	}

	/**
	 * Metodo setter che ritorna il codice fiscale del richiedente
	 * @param cuaa codice fiscale del richiedente
	 */
	public void setCuaa(String cuaa) {
		this.cuaa = cuaa;
	}

	/**
	 * Metodo getter che ritorna il flag di adesione ai sistemi di etichettatura facoltativa
	 * @return flagEtichettatura flag di adesione ai sistemi di etichettatura facoltativa
	 */
	public String getFlagEtichettatura() {
		return flagEtichettatura;
	}

	/**
	 * Metodo setter che imposta il flag di adesione ai sistemi di eitchettatura facoltativa
	 * @param flagEtichettatura flag di adesione ai sistemi di etichettatura facoltativa
	 */
	public void setFlagEtichettatura(String flagEtichettatura) {
		this.flagEtichettatura = flagEtichettatura;
	}
}
