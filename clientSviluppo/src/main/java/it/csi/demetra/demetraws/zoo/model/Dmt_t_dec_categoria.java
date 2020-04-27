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

@Entity
@Table(name = "DMT_DEC_CATEGORIA")
public class Dmt_t_dec_categoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 894107074038700750L;

	@Id
	@Column(name = "id_sessione")
	private Long idSessione;

	@MapsId
	@ManyToOne
	@JoinColumn(name = "id_sessione", nullable = false)
	private Dmt_t_sessione sessione;

	@Column(name = "ID")
	@NotNull
	private Long id;

	@Column(name = "descrizione", length = 400)
	private String descrizione;

	public Long getId() {
		return id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Dmt_t_sessione getSessione() {
		return sessione;
	}

	public void setSessione(Dmt_t_sessione sessione) {
		this.sessione = sessione;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdSessione() {
		return idSessione;
	}

	public void setIdSessione(Long idSessione) {
		this.idSessione = idSessione;
	}

}
