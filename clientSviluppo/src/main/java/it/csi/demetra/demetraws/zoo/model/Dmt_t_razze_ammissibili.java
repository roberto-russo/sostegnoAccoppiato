package it.csi.demetra.demetraws.zoo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name= "dmt_t_razze_ammissibili")
/**
 * Classe delle razze ammissibili in base al decreto N 5465 7 giugno 2018
 * @version 0.0.1 (20/04/2020)
 * @author Bcsoft
 *
 */
public class Dmt_t_razze_ammissibili {

	@Column(name = "associazione", length = 20)
	private String associazione;
	
	@Column(name = "Denom_uff_LG", length = 50)
	private String denominaizoneUfficialeLG;
	
	
	
	@Id
	@Column(name = "Sezione_Razza", length = 20)
	@NotNull
	private String razza;

	public String getAssociazione() {
		return associazione;
	}

	public void setAssociazione(String associazione) {
		this.associazione = associazione;
	}

	public String getDenominaizoneUfficialeLG() {
		return denominaizoneUfficialeLG;
	}

	public void setDenominaizoneUfficialeLG(String denominaizoneUfficialeLG) {
		this.denominaizoneUfficialeLG = denominaizoneUfficialeLG;
	}

	public String getRazza() {
		return razza;
	}

	public void setRazza(String razza) {
		this.razza = razza;
	}
}
