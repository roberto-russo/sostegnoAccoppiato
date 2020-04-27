package it.csi.demetra.demetraws.zoo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_coefficienti_uba_id;

@Entity
@Table(name = "DMT_T_COEFFICIENTI_UBA")
@IdClass(Dmt_t_coefficienti_uba_id.class)
public class Dmt_t_coefficienti_uba implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 4821666006881108733L;

	@Id
	@Column(name = "id_sessione")
	private Long idSessione;

	@MapsId
	@ManyToOne
	@JoinColumn(name = "id_sessione", nullable = false)
	private Dmt_t_sessione sessione;

	@Id
	@Column(name = "id_specie")
	@NotNull
	private Long idSpecie;

	@Id
	@Column(name = "id_categoria")
	@NotNull
	private Long idCategoria;

	@Column(name = "coefficiente", length = 5, precision = 3)
	private double coefficiente;

	public Long getIdSpecie() {
		return idSpecie;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public double getCoefficiente() {
		return coefficiente;
	}

	public void setCoefficiente(double coefficiente) {
		this.coefficiente = coefficiente;
	}

	public Dmt_t_sessione getSessione() {
		return sessione;
	}

	public void setSessione(Dmt_t_sessione sessione) {
		this.sessione = sessione;
	}

	public void setIdSpecie(Long idSpecie) {
		this.idSpecie = idSpecie;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Long getIdSessione() {
		return idSessione;
	}

	public void setIdSessione(Long idSessione) {
		this.idSessione = idSessione;
	}

}
