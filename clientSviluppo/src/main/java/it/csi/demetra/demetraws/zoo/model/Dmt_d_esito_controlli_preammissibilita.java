package it.csi.demetra.demetraws.zoo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_d_esito_controlli_preammissibilita_id;

@Entity
@Table(name = "DMT_D_ESITO_CONTR_PREAMM")
@IdClass(Dmt_d_esito_controlli_preammissibilita_id.class)
/**
 * Classe model di rappresentazione dell'output dei metodi getElencoCapiPremioNew e
 * getElencoCapiPremio2New
 *
 * @version 1.0 (02/04/2020)
 * @author bcsoft
 */
public class Dmt_d_esito_controlli_preammissibilita implements Serializable {

	private static final long serialVersionUID = -5710450180310221303L;

	@Id
	@Column(name = "id_sessione")
	private Long idSessione;

	@MapsId
	@ManyToOne
	@JoinColumn(name = "id_sessione", nullable = false)
	private Dmt_t_sessione sessione;

	@Id
	@Column(name = "ID")
	@NotNull
	private Long id;

	@Id
	@Column(name = "CUAA", length = 16)
	@NotNull
	private String cuaa;

	@Column(name = "data")
	@Temporal(TemporalType.DATE)
	private Date data;

	@Id
	@Column(name = "anno", length = 4, precision = 0)
	@NotNull
	private double anno;

	@Id
	@Column(name = "id_gestore")
	@NotNull
	private Long idGestore;

	@Column(name = "esito", length = 1)
	private String esito;

	@Column(name = "msg", length = 400)
	private String msg;

	public Long getId() {
		return id;
	}

	public String getCuaa() {
		return cuaa;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getAnno() {
		return anno;
	}

	public Long getIdGestore() {
		return idGestore;
	}

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
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

	public void setCuaa(String cuaa) {
		this.cuaa = cuaa;
	}

	public void setAnno(double anno) {
		this.anno = anno;
	}

	public void setIdGestore(Long idGestore) {
		this.idGestore = idGestore;
	}

	public Long getIdSessione() {
		return idSessione;
	}

	public void setIdSessione(Long idSessione) {
		this.idSessione = idSessione;
	}

}
