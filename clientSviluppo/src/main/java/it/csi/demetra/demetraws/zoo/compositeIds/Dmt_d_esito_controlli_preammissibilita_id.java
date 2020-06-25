package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;

public class Dmt_d_esito_controlli_preammissibilita_id implements Serializable{

	private static final long serialVersionUID = -4136050190900085764L;

	private Long id;
	private String cuaa;
	private double anno;
	private Long idGestore;
	private Long idSessione;
	
	public Dmt_d_esito_controlli_preammissibilita_id() {
		
	}
	
	public Dmt_d_esito_controlli_preammissibilita_id(Long id, String cuaa, double anno, Long idGestore, Long idSessione) {
		this.id = id;
		this.cuaa = cuaa;
		this.anno = anno;
		this.idGestore = idGestore;
		this.idSessione = idSessione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(anno);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((cuaa == null) ? 0 : cuaa.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idGestore == null) ? 0 : idGestore.hashCode());
		result = prime * result + (int) (idSessione ^ (idSessione >>> 32));
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
		Dmt_d_esito_controlli_preammissibilita_id other = (Dmt_d_esito_controlli_preammissibilita_id) obj;
		if (Double.doubleToLongBits(anno) != Double.doubleToLongBits(other.anno))
			return false;
		if (cuaa == null) {
			if (other.cuaa != null)
				return false;
		} else if (!cuaa.equals(other.cuaa))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idGestore == null) {
			if (other.idGestore != null)
				return false;
		} else if (!idGestore.equals(other.idGestore))
			return false;
		if (idSessione != other.idSessione)
			return false;
		return true;
	}
}