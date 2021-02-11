package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;

public class Dmt_t_Tlatte_mensile_arpea_id implements Serializable {

	private static final long serialVersionUID = 659624631818140514L;

	private Long annoSolare;
	private Long matrAcquirente;
	private Long matrAzienda;
	private Long annoRiferimentro;
	private String scoMese;
	private Long idSessione;

	public Dmt_t_Tlatte_mensile_arpea_id() {

	}

	public Dmt_t_Tlatte_mensile_arpea_id(Long annoSolare, Long matrAcquirente, Long matrAzienda, Long annoRiferimento,
			String scoMese, Long idSessione) {
		this.annoSolare = annoSolare;
		this.matrAcquirente = matrAcquirente;
		this.matrAzienda = matrAzienda;
		this.annoRiferimentro = annoRiferimento;
		this.scoMese = scoMese;
		this.idSessione = idSessione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annoRiferimentro == null) ? 0 : annoRiferimentro.hashCode());
		result = prime * result + ((annoSolare == null) ? 0 : annoSolare.hashCode());
		result = prime * result + (int) (idSessione ^ (idSessione >>> 32));
		result = prime * result + ((matrAcquirente == null) ? 0 : matrAcquirente.hashCode());
		result = prime * result + ((matrAzienda == null) ? 0 : matrAzienda.hashCode());
		result = prime * result + ((scoMese == null) ? 0 : scoMese.hashCode());
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
		Dmt_t_Tlatte_mensile_arpea_id other = (Dmt_t_Tlatte_mensile_arpea_id) obj;
		if (annoRiferimentro == null) {
			if (other.annoRiferimentro != null)
				return false;
		} else if (!annoRiferimentro.equals(other.annoRiferimentro))
			return false;
		if (annoSolare == null) {
			if (other.annoSolare != null)
				return false;
		} else if (!annoSolare.equals(other.annoSolare))
			return false;
		if (idSessione != other.idSessione)
			return false;
		if (matrAcquirente == null) {
			if (other.matrAcquirente != null)
				return false;
		} else if (!matrAcquirente.equals(other.matrAcquirente))
			return false;
		if (matrAzienda == null) {
			if (other.matrAzienda != null)
				return false;
		} else if (!matrAzienda.equals(other.matrAzienda))
			return false;
		if (scoMese == null) {
			if (other.scoMese != null)
				return false;
		} else if (!scoMese.equals(other.scoMese))
			return false;
		return true;
	}
}
