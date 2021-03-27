package it.csi.demetra.demetraws.zoo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Classe delle razze ammissibili in base al decreto N 5465 7 giugno 2018
 *
 * @author Bcsoft
 * @version 0.0.1 (20/04/2020)
 */
@Entity
@Table(name = "dmt_t_razze_ammissibili")
public class Dmt_t_razze_ammissibili {

    @Column(name = "associazione")
    private String associazione;

    @Column(name = "Denom_uff_LG")
    private String denominaizoneUfficialeLG;


    @Id
    @Column(name = "Sezione_Razza")
    @NotNull
    private String razza;

    public String getAssociazione() {
        return associazione;
    }

    public void setAssociazione(String associazione) {
        this.associazione = associazione;
    }

    public String getDenominaizoneUfficialeLG() {
        return denominaizoneUfficialeLG;
    }

    public void setDenominaizoneUfficialeLG(String denominaizoneUfficialeLG) {
        this.denominaizoneUfficialeLG = denominaizoneUfficialeLG;
    }

    public String getRazza() {
        return razza;
    }

    public void setRazza(String razza) {
        this.razza = razza;
    }
}
