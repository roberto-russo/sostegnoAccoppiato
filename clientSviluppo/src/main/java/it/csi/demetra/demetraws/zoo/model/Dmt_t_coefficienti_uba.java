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


	private static final long serialVersionUID = 4821666006881108733L;

	@Id
	@Column(name = "id_sessione")
	/**
	 * codice sessione associato all'esecuzione
	 */
	private Long idSessione;

	@Id
	@Column(name = "id_specie")
	@NotNull
	/**
	 * Codice Specie animale allevata
	 */
	private Long idSpecie;

	@Id
	@Column(name = "id_categoria")
	@NotNull
	private Long idCategoria;

	@Column(name = "coefficiente")
	private double coefficiente;

	/**
	 * metodo getter che ritorna il codice specie animale allevata
	 * @return idSpecie codice specie animale allevata
	 */
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

	/**
	 * metodo getter che ritorna il codice della sessione associato all'esecuzione.
	 * @return sessione codice della sessione associata all'esecuzione.
	 */
	public Long getIdSessione() {
		return idSessione;
	}

	/**
	 * metodo setter che imposta il codice della sessione associato all'esecuzione.
	 * @param sessione codice della sessione associato all'esecuzione.
	 */
	public void setIdSessione(Dmt_t_sessione sessione) {
		this.idSessione = sessione.getIdSessione();
	}

	/**
	 * metodo setter che imposta il codice della specie animale allevata.
	 * @param idSpecie codice della specie animale allevata.
	 */
	public void setIdSpecie(Long idSpecie) {
		this.idSpecie = idSpecie;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

}
