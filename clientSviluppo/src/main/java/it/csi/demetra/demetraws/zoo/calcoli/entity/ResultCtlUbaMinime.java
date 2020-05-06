package it.csi.demetra.demetraws.zoo.calcoli.entity;
import java.util.List;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_premio_capi;

public class ResultCtlUbaMinime {

	private boolean result;
	
	private boolean errors;
	
	private List<Dmt_t_premio_capi> listaCapi;

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public boolean isErrors() {
		return errors;
	}

	public void setErrors(boolean errors) {
		this.errors = errors;
	}

	public List<Dmt_t_premio_capi> getListaCapi() {
		return listaCapi;
	}

	public void setListaCapi(List<Dmt_t_premio_capi> listaCapi) {
		this.listaCapi = listaCapi;
	}
	
	
	
}
