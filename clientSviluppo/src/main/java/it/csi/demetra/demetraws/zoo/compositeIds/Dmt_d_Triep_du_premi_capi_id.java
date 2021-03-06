package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;

public class Dmt_d_Triep_du_premi_capi_id implements Serializable{

	private static final long serialVersionUID = 8390248024394536960L;
	
	private Long idDomanda;
	private String scoAttivita;
	private Long idRichiesta;
	private String codPremio;
	private Long idSessione;
	
	public Dmt_d_Triep_du_premi_capi_id() {
		
	}
	
	public Dmt_d_Triep_du_premi_capi_id(Long idDomanda, String scoAttivita, Long idRichiesta, String codPremio, Long idSessione) {
		this.idDomanda = idDomanda;
		this.scoAttivita = scoAttivita;
		this.codPremio = codPremio;
		this.idSessione = idSessione;
		this.idRichiesta = idRichiesta;
	}
	
	public Long getIdDomanda() {
		return this.idDomanda;
	}
	
	public String getScoAttivita() {
		return this.scoAttivita;
	}
	
	
	public Long getIdRichiesta() {
		return this.idRichiesta;
	}
	
	public String getCodPremio() {
		return this.codPremio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codPremio == null) ? 0 : codPremio.hashCode());
		result = prime * result + ((idDomanda == null) ? 0 : idDomanda.hashCode());
		result = prime * result + ((idRichiesta == null) ? 0 : idRichiesta.hashCode());
		result = prime * result + (int) (idSessione ^ (idSessione >>> 32));
		result = prime * result + ((scoAttivita == null) ? 0 : scoAttivita.hashCode());
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
		Dmt_d_Triep_du_premi_capi_id other = (Dmt_d_Triep_du_premi_capi_id) obj;
		if (codPremio == null) {
			if (other.codPremio != null)
				return false;
		} else if (!codPremio.equals(other.codPremio))
			return false;
		if (idDomanda == null) {
			if (other.idDomanda != null)
				return false;
		} else if (!idDomanda.equals(other.idDomanda))
			return false;
		if (idRichiesta == null) {
			if (other.idRichiesta != null)
				return false;
		} else if (!idRichiesta.equals(other.idRichiesta))
			return false;
		if (idSessione != other.idSessione)
			return false;
		if (scoAttivita == null) {
			if (other.scoAttivita != null)
				return false;
		} else if (!scoAttivita.equals(other.scoAttivita))
			return false;
		return true;
	}
}
