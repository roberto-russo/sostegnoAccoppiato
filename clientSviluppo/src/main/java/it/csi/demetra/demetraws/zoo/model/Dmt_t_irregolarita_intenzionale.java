package it.csi.demetra.demetraws.zoo.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_irregolarita_intenzionale_id;

@Entity
@Table(name = "DMT_T_IRREG_INTEN")
@IdClass(Dmt_t_irregolarita_intenzionale_id.class)
public class Dmt_t_irregolarita_intenzionale implements Serializable{

	private static final long serialVersionUID = 2983519368195903558L;
	
	
	@Id
	@SequenceGenerator(name="irreg_inten_id_seq",sequenceName="IRREG_INTEN_ID_SEQ", allocationSize=1)
	@Column(name = "progr")
    private Long progressivo;
	
	@Id
	@Column(name = "CUAA")
	private String cuaa;
	
	@Id
	@Column(name = "COD_STALLA")
	private String codiceStalla;
	
	@Column(name = "INTENZIONALITA")
	private String intenzionalitaRiscontrata;
	
	@Column(name = "MARCA_AURICOLARE")
	private String marcaAuricolare;
	
	@Column(name = "N_ANIMALI_ANOMALI")
	private BigInteger numeroAnimaliAnomali;
	
	@Column(name = "ANNO_CAMPAGNA")
	Integer annoCampagna;
	
	
	public Integer getAnnoCampagna() {
		return annoCampagna;
	}

	public void setAnnoCampagna(Integer annoCampagna) {
		this.annoCampagna = annoCampagna;
	}

	public String getCuaa() {
		return cuaa;
	}
	
	public Long getProgressivo() {
		return progressivo;
	}
	
	public void setCuaa(String cuaa) {
		this.cuaa = cuaa;
	}

	public String getCodiceStalla() {
		return codiceStalla;
	}

	public void setCodiceStalla(String codiceStalla) {
		this.codiceStalla = codiceStalla;
	}

	public String getIntenzionalitaRiscontrata() {
		return intenzionalitaRiscontrata;
	}

	public void setIntenzionalitaRiscontrata(String intenzionalitaRiscontrata) {
		this.intenzionalitaRiscontrata = intenzionalitaRiscontrata;
	}

	public String getMarcaAuricolare() {
		return marcaAuricolare;
	}

	public void setMarcaAuricolare(String marcaAuricolare) {
		this.marcaAuricolare = marcaAuricolare;
	}

	public BigInteger getNumeroAnimaliAnomali() {
		return numeroAnimaliAnomali;
	}

	public void setNumeroAnimaliAnomali(BigInteger numeroAnimaliAnomali) {
		this.numeroAnimaliAnomali = numeroAnimaliAnomali;
	}
}
