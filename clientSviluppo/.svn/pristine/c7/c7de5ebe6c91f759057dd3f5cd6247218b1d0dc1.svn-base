package it.csi.demetra.demetraws.zoo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_contr_loco_id;

@Entity
 @Table(name = "DMT_T_CONTR_LOCO")
@IdClass(Dmt_t_contr_loco_id.class)
public class Dmt_t_contr_loco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -244181523082419370L;

	
	
	@Column(name = "anno")
	private Integer anno;
	
	@Column(name = "regione_istat")
	private long regioneIstat;
	
	@Column(name = "regione", length = 25)
	private String regione;
	
	@Column(name = "provincia_istat")
	private Integer provinciaIstat;
	
	@Column(name = "provincia", length =25)
	private String provincia;
	
	@Id
	@Column(name = "cuaa", length = 16)
	@NotNull
	private String cuaa;
	
	@Column(name = "cuaa_normalizzato", length = 20)
	private String cuaaNormalizzato;
	
	@Column(name = "cod_ute", length = 5)
	private String codUte;
	
	@Column(name = "cod_asl", length = 16)
	private String codAsl;
	
	@Column(name = "cod_cai", length = 16)
	private String codCai;
	
	@Id
	@Column(name = "Marchio", length = 14)
	private String marchio;
	
	@Column(name = "note", length = 400)
	private String note;
	
	@Column(name = "data_nascita")
	@Temporal(TemporalType.DATE)
	private Date dtNascita;
	
	@Column(name = "sesso", length = 1)
	private String sesso;
	
	@Column(name = "anomalie_zoo")
	private Integer anomalieZoo;
	
	@Column(name = "anomalie_cgo", length = 10)
	private String anomalie_cgo;
	
	@Column(name = "descrizione_anomalia", length = 400)
	private String descrizioneAnomalia;


	public Integer getAnno() {
		return anno;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	public long getRegioneIstat() {
		return regioneIstat;
	}

	public void setRegioneIstat(long regioneIstat) {
		this.regioneIstat = regioneIstat;
	}

	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	public Integer getProvinciaIstat() {
		return provinciaIstat;
	}

	public void setProvinciaIstat(Integer provinciaIstat) {
		this.provinciaIstat = provinciaIstat;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCuaa() {
		return cuaa;
	}

	public void setCuaa(String cuaa) {
		this.cuaa = cuaa;
	}

	public String getCuaaNormalizzato() {
		return cuaaNormalizzato;
	}

	public void setCuaaNormalizzato(String cuaaNormalizzato) {
		this.cuaaNormalizzato = cuaaNormalizzato;
	}

	public String getCodUte() {
		return codUte;
	}

	public void setCodUte(String codUte) {
		this.codUte = codUte;
	}

	public String getCodAsl() {
		return codAsl;
	}

	public void setCodAsl(String codAsl) {
		this.codAsl = codAsl;
	}

	public String getCodCai() {
		return codCai;
	}

	public void setCodCai(String codCai) {
		this.codCai = codCai;
	}

	public String getMarchio() {
		return marchio;
	}

	public void setMarchio(String marchio) {
		this.marchio = marchio;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getDtNascita() {
		return dtNascita;
	}

	public void setDtNascita(Date dtNascita) {
		this.dtNascita = dtNascita;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public Integer getAnomalieZoo() {
		return anomalieZoo;
	}

	public void setAnomalieZoo(Integer anomalieZoo) {
		this.anomalieZoo = anomalieZoo;
	}

	public String getAnomalie_cgo() {
		return anomalie_cgo;
	}

	public void setAnomalie_cgo(String anomalie_cgo) {
		this.anomalie_cgo = anomalie_cgo;
	}

	public String getDescrizioneAnomalia() {
		return descrizioneAnomalia;
	}

	public void setDescrizioneAnomalia(String descrizioneAnomalia) {
		this.descrizioneAnomalia = descrizioneAnomalia;
	}
	
}
