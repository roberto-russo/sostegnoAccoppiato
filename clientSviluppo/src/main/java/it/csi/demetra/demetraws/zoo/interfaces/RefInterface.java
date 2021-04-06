package it.csi.demetra.demetraws.zoo.interfaces;

import it.csi.demetra.demetraws.zoo.calcoli.CalcoloException;

import java.util.List;

public interface RefInterface<T> {


    T calcolo() throws CalcoloException;

    List<T> calcoloMassivo() throws CalcoloException;


}
