package it.csi.demetra.demetraws.zoo.model;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_latte_vendita_diretta_id;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Dmt_t_latte_vendita_diretta")
/**
 * Tabella di raccolata dati relativi alle quantità di latte vendute dai
 * produttori in regime di vendita diretta
 *
 * @vesion 0.1 (03/04/2020)
 * @author Bcsoft
 *
 */
@IdClass(Dmt_t_latte_vendita_diretta_id.class)
public class Dmt_t_latte_vendita_diretta implements Serializable {

    private static final long serialVersionUID = -617789964633488044L;

    @Id
    private String cuua;
    @Id
    private String mese;
    @Id
    private int annoCampagna;
    private String matricola;
    private Long quantita;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMese() {
        return mese;
    }

    public void setMese(String mese) {
        this.mese = mese;
    }

    public String getCuua() {
        return cuua;
    }

    public void setCuua(String cuua) {
        this.cuua = cuua;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public Long getQuantita() {
        return quantita;
    }

    public void setQuantita(Long quantita) {
        this.quantita = quantita;
    }

    public int getAnnoCampagna() {
        return annoCampagna;
    }

    public void setAnnoCampagna(int annoCampagna) {
        this.annoCampagna = annoCampagna;
    }
}