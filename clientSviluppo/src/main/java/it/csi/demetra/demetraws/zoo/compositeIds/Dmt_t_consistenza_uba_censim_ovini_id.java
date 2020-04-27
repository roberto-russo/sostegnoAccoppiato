package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;

public class Dmt_t_consistenza_uba_censim_ovini_id implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3861768116996488618L;

	private long sessione;
	private String pCuaa;
	
	public Dmt_t_consistenza_uba_censim_ovini_id() {
		super();
	}
	
	public Dmt_t_consistenza_uba_censim_ovini_id(long sessione, String pCuaa) {
		super();
		this.sessione = sessione;
		this.pCuaa = pCuaa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (sessione ^ (sessione >>> 32));
		result = prime * result + ((pCuaa == null) ? 0 : pCuaa.hashCode());
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
		Dmt_t_consistenza_uba_censim_ovini_id other = (Dmt_t_consistenza_uba_censim_ovini_id) obj;
		if (sessione != other.sessione)
			return false;
		if (pCuaa == null) {
			if (other.pCuaa != null)
				return false;
		} else if (!pCuaa.equals(other.pCuaa))
			return false;
		return true;
	}
}
