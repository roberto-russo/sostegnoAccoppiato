package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;

public class Dmt_t_premio_capi_id implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idSessione;
    private String cuaa;
    private Long idAllevamento;
    private String codicePremio;
    private Long idCapo;

    public Dmt_t_premio_capi_id() {

    }

    public Dmt_t_premio_capi_id(Long idSessione, String cuaa, Long idAllevamento, String codicePremio, Long idCapo) {
        this.idSessione = idSessione;
        this.cuaa = cuaa;
        this.idAllevamento = idAllevamento;
        this.codicePremio = codicePremio;
        this.idCapo = idCapo;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getIdSessione() {
        return idSessione;
    }

    public void setIdSessione(Long idSessione) {
        this.idSessione = idSessione;
    }

    public String getCuaa() {
        return cuaa;
    }

    public void setCuaa(String cuaa) {
        this.cuaa = cuaa;
    }

    public Long getIdAllevamento() {
        return idAllevamento;
    }

    public void setIdAllevamento(Long idAllevamento) {
        this.idAllevamento = idAllevamento;
    }

    public String getCodicePremio() {
        return codicePremio;
    }

    public void setCodicePremio(String codicePremio) {
        this.codicePremio = codicePremio;
    }

    public Long getIdCapo() {
        return idCapo;
    }

    public void setIdCapo(Long idCapo) {
        this.idCapo = idCapo;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codicePremio == null) ? 0 : codicePremio.hashCode());
		result = prime * result + ((cuaa == null) ? 0 : cuaa.hashCode());
		result = prime * result + ((idAllevamento == null) ? 0 : idAllevamento.hashCode());
		result = prime * result + ((idCapo == null) ? 0 : idCapo.hashCode());
		result = prime * result + ((idSessione == null) ? 0 : idSessione.hashCode());
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
		Dmt_t_premio_capi_id other = (Dmt_t_premio_capi_id) obj;
		if (codicePremio == null) {
			if (other.codicePremio != null)
				return false;
		} else if (!codicePremio.equals(other.codicePremio))
			return false;
		if (cuaa == null) {
			if (other.cuaa != null)
				return false;
		} else if (!cuaa.equals(other.cuaa))
			return false;
		if (idAllevamento == null) {
			if (other.idAllevamento != null)
				return false;
		} else if (!idAllevamento.equals(other.idAllevamento))
			return false;
		if (idCapo == null) {
			if (other.idCapo != null)
				return false;
		} else if (!idCapo.equals(other.idCapo))
			return false;
		if (idSessione == null) {
			if (other.idSessione != null)
				return false;
		} else if (!idSessione.equals(other.idSessione))
			return false;
		return true;
	}


}
