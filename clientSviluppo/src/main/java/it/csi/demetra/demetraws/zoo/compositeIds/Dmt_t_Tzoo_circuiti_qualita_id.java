package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;

public class Dmt_t_Tzoo_circuiti_qualita_id implements Serializable {

	private String cuaa;
	private String id_allev_bdn;
	private String sco_cat_cq;
	private String sco_denom_cq;
	private Long idSessione;

	public Dmt_t_Tzoo_circuiti_qualita_id() {

	}

	public Dmt_t_Tzoo_circuiti_qualita_id(String cuaa, String id_allev_bdn, String sco_cat_cq, String sco_denom_cq, Long idSessione) {
		this.cuaa = cuaa;
		this.id_allev_bdn = id_allev_bdn;
		this.sco_cat_cq = sco_cat_cq;
		this.sco_denom_cq = sco_denom_cq;
		this.idSessione = idSessione;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cuaa == null) ? 0 : cuaa.hashCode());
		result = prime * result + (int) (idSessione ^ (idSessione >>> 32));
		result = prime * result + ((id_allev_bdn == null) ? 0 : id_allev_bdn.hashCode());
		result = prime * result + ((sco_cat_cq == null) ? 0 : sco_cat_cq.hashCode());
		result = prime * result + ((sco_denom_cq == null) ? 0 : sco_denom_cq.hashCode());
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
		Dmt_t_Tzoo_circuiti_qualita_id other = (Dmt_t_Tzoo_circuiti_qualita_id) obj;
		if (cuaa == null) {
			if (other.cuaa != null)
				return false;
		} else if (!cuaa.equals(other.cuaa))
			return false;
		if (idSessione != other.idSessione)
			return false;
		if (id_allev_bdn == null) {
			if (other.id_allev_bdn != null)
				return false;
		} else if (!id_allev_bdn.equals(other.id_allev_bdn))
			return false;
		if (sco_cat_cq == null) {
			if (other.sco_cat_cq != null)
				return false;
		} else if (!sco_cat_cq.equals(other.sco_cat_cq))
			return false;
		if (sco_denom_cq == null) {
			if (other.sco_denom_cq != null)
				return false;
		} else if (!sco_denom_cq.equals(other.sco_denom_cq))
			return false;
		return true;
	}
}
