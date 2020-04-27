package it.csi.demetra.demetraws.zoo.calcoli.entity;

import java.util.List;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_DsUBA_censimenti_allevamenti_ovini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_ovicaprini;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalcoloAgnelleDaRimontaPremioIn {
	
	@Getter
	@Setter
	private Long idSessione;
	
	@Getter
	@Setter
	private String cuaa;
	
	@Getter
	@Setter
	private double quotaCapiPremioRichiesti;
	
	@Getter
	@Setter
	private Dmt_t_DsUBA_censimenti_allevamenti_ovini ubaOviniCensimento;
	
	@Getter
	@Setter
	private List<Dmt_t_Tws_bdn_du_capi_ovicaprini> bdnOviniRegistroStallaList;

}
