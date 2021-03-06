package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;

public class Rpu_V_pratica_zoote_id implements Serializable{

	private static final long serialVersionUID = 8792097162764936807L;
	
	private int annoCampagna;
	private String cuaa;
	private String codicePremio;
	
	public Rpu_V_pratica_zoote_id() {}
	
	public Rpu_V_pratica_zoote_id(int annoCampagna, String cuaa, String codicePremio) {
		this.annoCampagna = annoCampagna;
		this.cuaa = cuaa;
		this.codicePremio = codicePremio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + annoCampagna;
		result = prime * result + ((codicePremio == null) ? 0 : codicePremio.hashCode());
		result = prime * result + ((cuaa == null) ? 0 : cuaa.hashCode());
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
		Rpu_V_pratica_zoote_id other = (Rpu_V_pratica_zoote_id) obj;
		if (annoCampagna != other.annoCampagna)
			return false;
		if (codicePremio == null) {
			if (other.codicePremio != null)
				return false;
		} else if (!codicePremio.equals(other.codicePremio))
			return false;
		if (cuaa == null) {
			if (other.cuaa != null)
				return false;
		} else if (!cuaa.equals(other.cuaa))
			return false;
		return true;
	}
	
}
