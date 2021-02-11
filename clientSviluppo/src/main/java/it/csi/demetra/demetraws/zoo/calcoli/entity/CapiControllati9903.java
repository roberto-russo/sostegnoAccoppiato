package it.csi.demetra.demetraws.zoo.calcoli.entity;

import java.util.List;

public class CapiControllati9903 extends CapiControllati<Capo9903>{

	public List<Capo9903> getListaCapi9903() {
		return super.getListaCapi();
	}

	public void setListaCapi9903(List<Capo9903> listaCapi9903) {
		super.setListaCapi(listaCapi9903);
	}
	public static boolean getEsito() {
		return CapiControllati.getEsito();
	}

	public static void setEsito(boolean esito) {
		CapiControllati.setEsito(esito);
	}

	public static String getMotivazioneEsitoCalcolo() {
		return CapiControllati.getMotivazioneEsitoCalcolo();
	}

	public static void setMotivazioneEsitoCalcolo(String motivazioneCalcolo) {
		CapiControllati.setMotivazioneEsitoCalcolo(motivazioneCalcolo);
	}
}
