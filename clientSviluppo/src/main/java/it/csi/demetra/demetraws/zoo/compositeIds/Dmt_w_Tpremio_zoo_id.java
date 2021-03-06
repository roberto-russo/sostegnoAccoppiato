package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;

public class Dmt_w_Tpremio_zoo_id implements Serializable {

	private static final long serialVersionUID = 8427851855934601189L;

	private Long id_azienda;
	private Long versione;
	private String cod_allevamento;
	private String id_allev_bdn;
	private String sco_specie;
	private String cod_specie;
	private Long idSessione;

	public Dmt_w_Tpremio_zoo_id() {

	}

	public Dmt_w_Tpremio_zoo_id(Long id_azienda, Long versione, String cod_allevamento, String id_allev_bdn,
			String sco_specie, String cod_specie, Long idSessione) {
		this.id_azienda = id_azienda;
		this.versione = versione;
		this.cod_allevamento = cod_allevamento;
		this.id_allev_bdn = id_allev_bdn;
		this.sco_specie = sco_specie;
		this.cod_specie = cod_specie;
		this.idSessione = idSessione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod_allevamento == null) ? 0 : cod_allevamento.hashCode());
		result = prime * result + ((cod_specie == null) ? 0 : cod_specie.hashCode());
		result = prime * result + (int) (idSessione ^ (idSessione >>> 32));
		result = prime * result + ((id_allev_bdn == null) ? 0 : id_allev_bdn.hashCode());
		result = prime * result + ((id_azienda == null) ? 0 : id_azienda.hashCode());
		result = prime * result + ((sco_specie == null) ? 0 : sco_specie.hashCode());
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
		Dmt_w_Tpremio_zoo_id other = (Dmt_w_Tpremio_zoo_id) obj;
		if (cod_allevamento == null) {
			if (other.cod_allevamento != null)
				return false;
		} else if (!cod_allevamento.equals(other.cod_allevamento))
			return false;
		if (cod_specie == null) {
			if (other.cod_specie != null)
				return false;
		} else if (!cod_specie.equals(other.cod_specie))
			return false;
		if (idSessione != other.idSessione)
			return false;
		if (id_allev_bdn == null) {
			if (other.id_allev_bdn != null)
				return false;
		} else if (!id_allev_bdn.equals(other.id_allev_bdn))
			return false;
		if (id_azienda == null) {
			if (other.id_azienda != null)
				return false;
		} else if (!id_azienda.equals(other.id_azienda))
			return false;
		if (sco_specie == null) {
			if (other.sco_specie != null)
				return false;
		} else if (!sco_specie.equals(other.sco_specie))
			return false;
		if (versione == null) {
			if (other.versione != null)
				return false;
		} else if (!versione.equals(other.versione))
			return false;
		return true;
	}
}
