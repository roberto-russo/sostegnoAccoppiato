package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;

public class Dmt_t_consistenza_uba_censim_ovini_id implements Serializable{

	private static final long serialVersionUID = -3861768116996488618L;

	private Long idSessione;
	private String pCuaa;
	
	public Dmt_t_consistenza_uba_censim_ovini_id() {
		super();
	}
	
	public Dmt_t_consistenza_uba_censim_ovini_id(Long idSessione, String pCuaa) {
		super();
		this.idSessione = idSessione;
		this.pCuaa = pCuaa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idSessione ^ (idSessione >>> 32));
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
		if (idSessione != other.idSessione)
			return false;
		if (pCuaa == null) {
			if (other.pCuaa != null)
				return false;
		} else if (!pCuaa.equals(other.pCuaa))
			return false;
		return true;
	}
}
