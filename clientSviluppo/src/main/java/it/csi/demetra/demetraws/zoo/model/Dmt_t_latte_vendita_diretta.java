package it.csi.demetra.demetraws.zoo.model;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_latte_vendita_diretta_id;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Tabella di raccolata dati relativi alle quantità di latte vendute dai
 * produttori in regime di vendita diretta
 *
 * @author Bcsoft
 * @version 0.1 (03/04/2020)
 */
@Entity
@Table(name = "Dmt_t_latte_vendita_diretta")
@IdClass(Dmt_t_latte_vendita_diretta_id.class)
public class Dmt_t_latte_vendita_diretta implements Serializable {

    private static final long serialVersionUID = -617789964633488044L;

    @Id
    /**
     * Codice fiscale del richiedente
     */
    private String cuua;
    @Id
    private String mese;
    @Id
    /**
     * Anno della campagna
     */
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

    /**
     * Metodo getter che ritorna il codice fiscale del richiedente
     *
     * @return cuaa codice fiscale del richiedente.
     */
    public String getCuua() {
        return cuua;
    }

    /**
     * Metodo setter che imposta il codice fiscale del richiedente.
     *
     * @param cuua codice fiscale del richiedente.
     */
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

    /**
     * Metodo getter che ritorna l'anno della campagna.
     *
     * @return annoCampagna anno della campagna.
     */
    public int getAnnoCampagna() {
        return annoCampagna;
    }

    /**
     * Metodo setter che imposta l'anno della campagna.
     *
     * @param annoCampagna anno della campagna.
     */
    public void setAnnoCampagna(int annoCampagna) {
        this.annoCampagna = annoCampagna;
    }
}
