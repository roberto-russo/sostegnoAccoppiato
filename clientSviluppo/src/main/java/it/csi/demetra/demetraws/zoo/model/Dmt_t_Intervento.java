package it.csi.demetra.demetraws.zoo.model;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_Intervento_id;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "DMT_T_INTERVENTO")
@IdClass(Dmt_t_Intervento_id.class)
public class Dmt_t_Intervento implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4722066700077619343L;


    @Id
    @Column(name = "id_sessione")
    private Long idSessione;

    @Id
    @Column(name = "ID")
    @NotNull
    private Long id;

    @Column(name = "Intervento")
    private String intervento;

    @Column(name = "Misura")
    private double misura;

    @Id
    @Column(name = "id_specie")
    @NotNull
    private int idSpecie;

    @Id
    @Column(name = "id_categoria")
    @NotNull
    private int idCategoria;

    public Long getId() {
        return id;
    }

    public String getIntervento() {
        return intervento;
    }

    public void setIntervento(String intervento) {
        this.intervento = intervento;
    }

    public double getMisura() {
        return misura;
    }

    public void setMisura(double misura) {
        this.misura = misura;
    }

    public int getIdSpecie() {
        return idSpecie;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public Long getIdSessione() {
        return idSessione;
    }

    public void setIdSessione(Dmt_t_sessione sessione) {
        this.idSessione = sessione.getIdSessione();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdSpecie(int idSpecie) {
        this.idSpecie = idSpecie;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }


}
