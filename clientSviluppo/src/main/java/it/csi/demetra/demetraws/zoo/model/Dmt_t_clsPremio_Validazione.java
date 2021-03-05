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

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_clsPremio_Validazione_id;

/**
 * Classe model di ingresso dati per il metodo getElencoCapiPremioNew
 *
 * @version 0.1 (02/04/2020)
 * @author bcsoft
 */
@Entity
@Table(name = "DMT_T_CLS_PREMIO_VALID")
@IdClass(Dmt_t_clsPremio_Validazione_id.class)
public class Dmt_t_clsPremio_Validazione implements Serializable {

	private static final long serialVersionUID = 2031702160950376333L;

	@Id
	@Column(name = "id_sessione")
	private Long idSessione;

	@Id
	@Column(name = "codice_Intervento")
	@NotNull
	/**
	 * Codice Intervento codificato nella tabella PREMI in BDN.
	 */
	private String codiceIntervento;

	@Id
	@Column(name = "cuaa")
	@NotNull
	/**
	 * Identificativo Fiscale del soggetto che ha presentato la domanda
	 */
	private String cuaa;

	@Id
	@Column(name = "anno_campagna")
	@NotNull
	/**
	 * Anno della campagna
	 */
	private Integer annoCampagna;

	/**
	 * Recupera il codice Intervento codificato nella tabella PREMI in BDN.
	 *
	 * @return codiceIntervento il codice Intervento codificato nella tabella PREMI
	 *         in BDN.
	 */
	public String getCodiceIntervento() {
		return codiceIntervento;
	}

	/**
	 * Recupera l'identificativo Fiscale del soggetto che ha presentato la domanda
	 *
	 * @return cuaa identificativo Fiscale del soggetto che ha presentato la domanda
	 */
	public String getCuaa() {
		return cuaa;
	}

	/**
	 * Recupera l'anno della campagna
	 *
	 * @return l'anno della campagna
	 */
	public Integer getAnnoCampagna() {
		return annoCampagna;
	}

	public Long getIdSessione() {
		return idSessione;
	}

	public void setIdSessione(Dmt_t_sessione sessione) {
		this.idSessione = sessione.getIdSessione();
	}

	public void setCodiceIntervento(String codiceIntervento) {
		this.codiceIntervento = codiceIntervento;
	}

	public void setCuaa(String cuaa) {
		this.cuaa = cuaa;
	}

	public void setAnnoCampagna(Integer annoCampagna) {
		this.annoCampagna = annoCampagna;
	}


}
