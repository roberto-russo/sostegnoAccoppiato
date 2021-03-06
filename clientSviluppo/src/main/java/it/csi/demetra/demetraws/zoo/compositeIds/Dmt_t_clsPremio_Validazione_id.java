package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;

public class Dmt_t_clsPremio_Validazione_id implements Serializable {

	private static final long serialVersionUID = -534954640914917834L;

	private String codiceIntervento;
	private String cuaa;
	private Integer annoCampagna;
	private Long idSessione;

	public Dmt_t_clsPremio_Validazione_id() {

	}

	public Dmt_t_clsPremio_Validazione_id(String codiceIntervento, String cuaa, Integer annoCampagna, Long idSessione) {

		this.codiceIntervento = codiceIntervento;
		this.cuaa = cuaa;
		this.annoCampagna = annoCampagna;
		this.idSessione = idSessione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annoCampagna == null) ? 0 : annoCampagna.hashCode());
		result = prime * result + ((codiceIntervento == null) ? 0 : codiceIntervento.hashCode());
		result = prime * result + ((cuaa == null) ? 0 : cuaa.hashCode());
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
		Dmt_t_clsPremio_Validazione_id other = (Dmt_t_clsPremio_Validazione_id) obj;
		if (annoCampagna == null) {
			if (other.annoCampagna != null)
				return false;
		} else if (!annoCampagna.equals(other.annoCampagna))
			return false;
		if (codiceIntervento == null) {
			if (other.codiceIntervento != null)
				return false;
		} else if (!codiceIntervento.equals(other.codiceIntervento))
			return false;
		if (cuaa == null) {
			if (other.cuaa != null)
				return false;
		} else if (!cuaa.equals(other.cuaa))
			return false;
		if (idSessione != other.idSessione)
			return false;
		return true;
	}
}
