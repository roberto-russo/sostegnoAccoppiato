package it.csi.demetra.demetraws.zoo.calcoli.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Questa classe serve a gestire i capi da controllare,
 * una volta effettuati i controlli, verrà settato l'esito.
 */
public class CapiControllati<T> {

    private List<T> listaCapi = new ArrayList<T>();

    /**
     * Parametro che indica l'esito del calcolo
     */
    private static boolean esito = true;

    /**
     * Parametro che indica la motivazione
     * dell'esito del calcolo
     */
    private static String motivazioneEsitoCalcolo = "";


    protected List<T> getListaCapi() {
        return listaCapi;
    }

    protected void setListaCapi(List<T> listaCapi) {
        this.listaCapi = listaCapi;
    }

    protected static boolean getEsito() {
        return esito;
    }

    protected static void setEsito(boolean esito) {
        CapiControllati.esito = esito;
    }

    protected static String getMotivazioneEsitoCalcolo() {
        return motivazioneEsitoCalcolo;
    }

    protected static void setMotivazioneEsitoCalcolo(String motivazioneCalcolo) {
        CapiControllati.motivazioneEsitoCalcolo = motivazioneCalcolo;
    }
}
