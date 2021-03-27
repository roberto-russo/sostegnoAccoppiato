package it.csi.demetra.demetraws.zoo.calcoli.entity;

import java.util.List;

public class CapiControllati9901 extends CapiControllati<Capo9901> {

    public List<Capo9901> getListaCapi9901() {
        return super.getListaCapi();
    }

    public void setListaCapi9901(List<Capo9901> listaCapi9901) {
        super.setListaCapi(listaCapi9901);
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
