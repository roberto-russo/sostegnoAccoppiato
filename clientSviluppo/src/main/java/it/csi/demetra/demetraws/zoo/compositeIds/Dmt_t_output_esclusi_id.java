package it.csi.demetra.demetraws.zoo.compositeIds;

import javax.persistence.Column;
import java.io.Serializable;

public class Dmt_t_output_esclusi_id implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9217875139729319085L;


	private Long sessione;

	private String calcolo;
	private Long capoId;
	public Dmt_t_output_esclusi_id(Long sessione, String calcolo, Long capoId) {
		super();
		this.sessione = sessione;
		this.calcolo = calcolo;
		this.capoId = capoId;
	}
	public Dmt_t_output_esclusi_id() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((calcolo == null) ? 0 : calcolo.hashCode());
		result = prime * result + ((capoId == null) ? 0 : capoId.hashCode());
		result = prime * result + ((sessione == null) ? 0 : sessione.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dmt_t_output_esclusi_id other = (Dmt_t_output_esclusi_id) obj;
		if (calcolo == null) {
			if (other.calcolo != null)
				return false;
		} else if (!calcolo.equals(other.calcolo))
			return false;
		if (capoId == null) {
			if (other.capoId != null)
				return false;
		} else if (!capoId.equals(other.capoId))
			return false;
		if (sessione == null) {
			if (other.sessione != null)
				return false;
		} else if (!sessione.equals(other.sessione))
			return false;
		return true;
	}


}
