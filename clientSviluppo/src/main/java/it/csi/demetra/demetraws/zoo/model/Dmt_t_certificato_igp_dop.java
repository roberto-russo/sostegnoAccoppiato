package it.csi.demetra.demetraws.zoo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Dmt_t_certif_igp_dop")
public class Dmt_t_certificato_igp_dop implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5666097958872142621L;

	
	@Id
	@Column(name = "cuaa", length = 16)
	private String cuaa;
	
	@Column(name = "flag_igp", length = 1)
	/**
	 * indicazione geografica protetta
	 * puo' assumere valori: S, N
	 */
	private String flagIgp;
	
	@Column(name = "flag_dop", length = 1)
	/**
	 * certificato a denominazione di origine protetta
	 * puo' assumere valori: S, N
	 */
	private String flagDop;


	public String getCuaa() {
		return cuaa;
	}

	public void setCuaa(String cuaa) {
		this.cuaa = cuaa;
	}

	public String getFlagIgp() {
		return flagIgp;
	}

	public void setFlagIgp(String flagIgp) {
		this.flagIgp = flagIgp;
	}

	public String getFlagDop() {
		return flagDop;
	}

	public void setFlagDop(String flagDop) {
		this.flagDop = flagDop;
	}	
}
