package it.csi.demetra.demetraws.zoo.calcoli;

public interface Calcolo {

    void preEsecuzione() throws CalcoloException;

    void esecuzione() throws CalcoloException;

    void postEsecuzione() throws CalcoloException;

}
