package it.csi.demetra.demetraws.zoo.compositeIds;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Analisi_produzioni_cuua_id implements Serializable {

    private static final long serialVersionUID = 7424654727989979857L;
    private String CUUA;
    private Date dataAnalisi;
    private int annoCampagna;

    public Analisi_produzioni_cuua_id(String CUUA, Date dataAnalisi, int annoCampagna) {
        this.CUUA = CUUA;
        this.dataAnalisi = dataAnalisi;
        this.annoCampagna = annoCampagna;
    }

    public Analisi_produzioni_cuua_id() {
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

    public int getAnnoCampagna() {
        return annoCampagna;
    }

    public void setAnnoCampagna(int annoCampagna) {
        this.annoCampagna = annoCampagna;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Analisi_produzioni_cuua_id that = (Analisi_produzioni_cuua_id) o;
        return annoCampagna == that.annoCampagna &&
                Objects.equals(CUUA, that.CUUA) &&
                Objects.equals(dataAnalisi, that.dataAnalisi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CUUA, dataAnalisi, annoCampagna);
    }
}
