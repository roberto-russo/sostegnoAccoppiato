package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;

public class Dmt_t_gestori_id implements Serializable{

	
	private static final long serialVersionUID = 6301971279336589749L;
	
	private Long id;
	private Long idSessione;
	private Long id_tipologia;
	
	public Dmt_t_gestori_id() {
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((id_tipologia == null) ? 0 : id_tipologia.hashCode());
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
		Dmt_t_gestori_id other = (Dmt_t_gestori_id) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (id_tipologia == null) {
			if (other.id_tipologia != null)
				return false;
		} else if (!id_tipologia.equals(other.id_tipologia))
			return false;
		return true;
	}
	
	
}
