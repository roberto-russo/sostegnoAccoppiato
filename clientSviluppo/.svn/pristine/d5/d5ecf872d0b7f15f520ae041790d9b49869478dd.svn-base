package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;

public class Dmt_t_Tlatte_vendita_diretta_id implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6671288667490072801L;

	private Long idAzienda;
	private Long versione;
	private Long progrRiga;
	private Long matricola;
	private long sessione;

	public Dmt_t_Tlatte_vendita_diretta_id() {

	}

	public Dmt_t_Tlatte_vendita_diretta_id(Long idAzienda, Long versione, Long progrRiga, Long matricola, long sessione) {
		this.idAzienda = idAzienda;
		this.versione = versione;
		this.progrRiga = progrRiga;
		this.matricola = matricola;
		this.sessione = sessione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAzienda == null) ? 0 : idAzienda.hashCode());
		result = prime * result + (int) (sessione ^ (sessione >>> 32));
		result = prime * result + ((matricola == null) ? 0 : matricola.hashCode());
		result = prime * result + ((progrRiga == null) ? 0 : progrRiga.hashCode());
		result = prime * result + ((versione == null) ? 0 : versione.hashCode());
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
		Dmt_t_Tlatte_vendita_diretta_id other = (Dmt_t_Tlatte_vendita_diretta_id) obj;
		if (idAzienda == null) {
			if (other.idAzienda != null)
				return false;
		} else if (!idAzienda.equals(other.idAzienda))
			return false;
		if (sessione != other.sessione)
			return false;
		if (matricola == null) {
			if (other.matricola != null)
				return false;
		} else if (!matricola.equals(other.matricola))
			return false;
		if (progrRiga == null) {
			if (other.progrRiga != null)
				return false;
		} else if (!progrRiga.equals(other.progrRiga))
			return false;
		if (versione == null) {
			if (other.versione != null)
				return false;
		} else if (!versione.equals(other.versione))
			return false;
		return true;
	}
}
