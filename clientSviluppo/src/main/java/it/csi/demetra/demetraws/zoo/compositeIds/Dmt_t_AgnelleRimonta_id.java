package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;

public class Dmt_t_AgnelleRimonta_id implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5621454556915205458L;

	private String cuaa;
	private long sessione;
	
	public Dmt_t_AgnelleRimonta_id() {}
	
	public Dmt_t_AgnelleRimonta_id(String cuaa, long sessione) {
		this.cuaa = cuaa;
		this.sessione = sessione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cuaa == null) ? 0 : cuaa.hashCode());
		result = prime * result + (int) (sessione ^ (sessione >>> 32));
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
		Dmt_t_AgnelleRimonta_id other = (Dmt_t_AgnelleRimonta_id) obj;
		if (cuaa == null) {
			if (other.cuaa != null)
				return false;
		} else if (!cuaa.equals(other.cuaa))
			return false;
		if (sessione != other.sessione)
			return false;
		return true;
	}
}
