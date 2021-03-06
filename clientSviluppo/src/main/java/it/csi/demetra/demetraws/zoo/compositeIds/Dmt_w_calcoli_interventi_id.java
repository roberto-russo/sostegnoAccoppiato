package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;

public class Dmt_w_calcoli_interventi_id implements Serializable {

	private static final long serialVersionUID = -5537378989307980411L;

	private Long idGestore;
	private Long idIntervento;
	private String ordineEsecuzione;
	private Long idSessione;

	public Dmt_w_calcoli_interventi_id() {

	}

	public Dmt_w_calcoli_interventi_id(Long idGestore, Long idIntervento, String ordineEsecuzione, Long idSessione) {
		this.idGestore = idGestore;
		this.idIntervento = idIntervento;
		this.ordineEsecuzione = ordineEsecuzione;
		this.idSessione = idSessione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idGestore == null) ? 0 : idGestore.hashCode());
		result = prime * result + ((idIntervento == null) ? 0 : idIntervento.hashCode());
		result = prime * result + (int) (idSessione ^ (idSessione >>> 32));
		result = prime * result + ((ordineEsecuzione == null) ? 0 : ordineEsecuzione.hashCode());
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
		Dmt_w_calcoli_interventi_id other = (Dmt_w_calcoli_interventi_id) obj;
		if (idGestore == null) {
			if (other.idGestore != null)
				return false;
		} else if (!idGestore.equals(other.idGestore))
			return false;
		if (idIntervento == null) {
			if (other.idIntervento != null)
				return false;
		} else if (!idIntervento.equals(other.idIntervento))
			return false;
		if (idSessione != other.idSessione)
			return false;
		if (ordineEsecuzione == null) {
			if (other.ordineEsecuzione != null)
				return false;
		} else if (!ordineEsecuzione.equals(other.ordineEsecuzione))
			return false;
		return true;
	}
}
