package it.csi.demetra.demetraws.zoo.calcoli.entity;

import java.util.List;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_DsUBA_censimenti_allevamenti_ovini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_ovicaprini;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class CalcoloAgnelleDaRimontaPremioIn {
	
//	@Getter
//	@Setter
	private Long idSessione;
	
//	@Getter
//	@Setter
	private String cuaa;
	
//	@Getter
//	@Setter
	private double quotaCapiPremioRichiesti;
	
//	@Getter
//	@Setter
	private Dmt_t_DsUBA_censimenti_allevamenti_ovini ubaOviniCensimento;
	
//	@Getter
//	@Setter
	private List<Dmt_t_Tws_bdn_du_capi_ovicaprini> bdnOviniRegistroStallaList;

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

	public double getQuotaCapiPremioRichiesti() {
		return quotaCapiPremioRichiesti;
	}

	public void setQuotaCapiPremioRichiesti(double quotaCapiPremioRichiesti) {
		this.quotaCapiPremioRichiesti = quotaCapiPremioRichiesti;
	}

	public Dmt_t_DsUBA_censimenti_allevamenti_ovini getUbaOviniCensimento() {
		return ubaOviniCensimento;
	}

	public void setUbaOviniCensimento(Dmt_t_DsUBA_censimenti_allevamenti_ovini ubaOviniCensimento) {
		this.ubaOviniCensimento = ubaOviniCensimento;
	}

	public List<Dmt_t_Tws_bdn_du_capi_ovicaprini> getBdnOviniRegistroStallaList() {
		return bdnOviniRegistroStallaList;
	}

	public void setBdnOviniRegistroStallaList(List<Dmt_t_Tws_bdn_du_capi_ovicaprini> bdnOviniRegistroStallaList) {
		this.bdnOviniRegistroStallaList = bdnOviniRegistroStallaList;
	}

	public CalcoloAgnelleDaRimontaPremioIn(Long idSessione, String cuaa, double quotaCapiPremioRichiesti,
			Dmt_t_DsUBA_censimenti_allevamenti_ovini ubaOviniCensimento,
			List<Dmt_t_Tws_bdn_du_capi_ovicaprini> bdnOviniRegistroStallaList) {
		super();
		this.idSessione = idSessione;
		this.cuaa = cuaa;
		this.quotaCapiPremioRichiesti = quotaCapiPremioRichiesti;
		this.ubaOviniCensimento = ubaOviniCensimento;
		this.bdnOviniRegistroStallaList = bdnOviniRegistroStallaList;
	}

	
}
