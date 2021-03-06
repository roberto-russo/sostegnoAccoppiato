package it.csi.demetra.demetraws.zoo.calcoli.entity;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_bovini;

public class Capo9901 extends Capo<Dmt_t_Tws_bdn_du_capi_bovini> {
	
	/**
	 * Tempo di Identificazione del vitello - marchio auricolare
	 */
	private int tI;
	
	/**
	 * Tempo di Registrazione del Vitello in BDN
	 */
	private int tR;
	
	
	public Capo9901(Dmt_t_Tws_bdn_du_capi_bovini capo, int tI, int tR) {
		
		setCapo(capo);
		this.tI = tI;
		this.tR = tR;
		
	}

	public int gettI() {
		return tI;
	}

	public void settI(int tI) {
		this.tI = tI;
	}

	public int gettR() {
		return tR;
	}

	public void settR(int tR) {
		this.tR = tR;
	}
	
}
