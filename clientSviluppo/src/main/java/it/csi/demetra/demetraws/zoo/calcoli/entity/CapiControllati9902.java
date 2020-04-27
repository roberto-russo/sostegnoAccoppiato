package it.csi.demetra.demetraws.zoo.calcoli.entity;

public class CapiControllati9902 {
	
	private Long idSessione;
	
	private String cuaa;
	
	private Integer annoCampagna;
	
	private String codiceIntervento;
	
	private boolean esito;
	
	private String motivazioni;
	
	private Double quotaCapiPremio;
	
	public CapiControllati9902() {}
	
	public CapiControllati9902(Long idSessione, String cuaa, boolean esito, String motivazioni,
			Double quotaCapiPremio, Integer annoCampagna, String codiceIntervento) {
		super();
		this.idSessione = idSessione;
		this.cuaa = cuaa;
		this.esito = esito;
		this.motivazioni = motivazioni;
		this.quotaCapiPremio = quotaCapiPremio;
		this.annoCampagna = annoCampagna;
		this.codiceIntervento = codiceIntervento;
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

	public Double getQuotaCapiPremio() {
		return quotaCapiPremio;
	}

	public void setQuotaCapiPremio(Double quotaCapiPremio) {
		this.quotaCapiPremio = quotaCapiPremio;
	}

	public boolean isEsito() {
		return esito;
	}

	public void setEsito(boolean esito) {
		this.esito = esito;
	}

	public String getMotivazioni() {
		return motivazioni;
	}

	public void setMotivazioni(String motivazioni) {
		this.motivazioni = motivazioni;
	}

	public Integer getAnnoCampagna() {
		return annoCampagna;
	}

	public void setAnnoCampagna(Integer annoCampagna) {
		this.annoCampagna = annoCampagna;
	}

	public String getCodiceIntervento() {
		return codiceIntervento;
	}

	public void setCodiceIntervento(String codiceIntervento) {
		this.codiceIntervento = codiceIntervento;
	}
	
	


}
