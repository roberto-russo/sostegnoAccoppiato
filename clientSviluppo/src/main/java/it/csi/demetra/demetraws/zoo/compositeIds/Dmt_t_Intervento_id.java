package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;

public class Dmt_t_Intervento_id implements Serializable {

	private static final long serialVersionUID = -8824381752174971029L;

	private Long id;
	private int idSpecie;
	private int idCategoria;
	private Long idSessione;

	public Long getSessione() {
		return idSessione;
	}

	public void setSessione(Long idSessione) {
		this.idSessione = idSessione;
	}

	public Dmt_t_Intervento_id() {

	}

	public Dmt_t_Intervento_id(Long id, int idSpecie, int idCategoria) {
		this.id = id;
		this.idSpecie = idSpecie;
		this.idCategoria = idCategoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + idCategoria;
		result = prime * result + idSpecie;
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
		Dmt_t_Intervento_id other = (Dmt_t_Intervento_id) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idCategoria != other.idCategoria)
			return false;
		if (idSpecie != other.idSpecie)
			return false;
		return true;
	}

}
