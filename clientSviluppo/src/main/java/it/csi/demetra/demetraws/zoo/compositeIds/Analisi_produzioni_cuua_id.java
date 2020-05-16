package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;
import java.util.Date;

public class Analisi_produzioni_cuua_id implements Serializable {

    private String CUUA;
    private Date dataAnalisi;

    public Analisi_produzioni_cuua_id(String CUUA, Date dataAnalisi) {
        this.CUUA = CUUA;
        this.dataAnalisi = dataAnalisi;
    }

    public String getCUUA() {
        return CUUA;
    }

    public void setCUUA(String CUUA) {
        this.CUUA = CUUA;
    }

    public Date getDataAnalisi() {
        return dataAnalisi;
    }

    public void setDataAnalisi(Date dataAnalisi) {
        this.dataAnalisi = dataAnalisi;
    }
}
