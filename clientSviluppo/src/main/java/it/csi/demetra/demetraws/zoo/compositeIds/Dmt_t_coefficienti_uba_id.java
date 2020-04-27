package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;

public class Dmt_t_coefficienti_uba_id implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5621454556915205458L;

	private Long idSpecie;
	private Long idCategoria;
	private long sessione;
	
	public Dmt_t_coefficienti_uba_id() {}
	
	public Dmt_t_coefficienti_uba_id(Long idSpecie, Long idCategoria, long sessione) {
		this.idSpecie = idSpecie;
		this.idCategoria = idCategoria;
		this.sessione = sessione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCategoria == null) ? 0 : idCategoria.hashCode());
		result = prime * result + (int) (sessione ^ (sessione >>> 32));
		result = prime * result + ((idSpecie == null) ? 0 : idSpecie.hashCode());
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
		Dmt_t_coefficienti_uba_id other = (Dmt_t_coefficienti_uba_id) obj;
		if (idCategoria == null) {
			if (other.idCategoria != null)
				return false;
		} else if (!idCategoria.equals(other.idCategoria))
			return false;
		if (sessione != other.sessione)
			return false;
		if (idSpecie == null) {
			if (other.idSpecie != null)
				return false;
		} else if (!idSpecie.equals(other.idSpecie))
			return false;
		return true;
	}
}
