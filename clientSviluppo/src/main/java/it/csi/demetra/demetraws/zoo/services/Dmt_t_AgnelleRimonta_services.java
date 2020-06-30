package it.csi.demetra.demetraws.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_AgnelleRimonta;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_AgnelleRimonta_repository;

/**
 * Classe service che utilizza le Query definite nel repository Dmt_t_AgnelleRimonta_repository
 * per la persistenza di oggetti di tipo Dmt_t_AgnelleRimonta
 * @author Bcsoft
 */
@Service
public class Dmt_t_AgnelleRimonta_services {
	
	/**
	 * Repository in cui sono definite le Query di tipo Dmt_t_AgnelleRimonta_repository.
	 */
	@Autowired
	Dmt_t_AgnelleRimonta_repository agnelleRimontaRepository;
	
	/**
	 * Metodo che effettua il salvataggio a DB di un'istanza di tipo {@link Dmt_t_AgnelleRimonta}
	 * @param agnelleRimonta istanza da salvare a DB
	 * @return Dmt_t_AgnelleRimonta istanza salvata a DB
	 */
	public Dmt_t_AgnelleRimonta save(Dmt_t_AgnelleRimonta agnelleRimonta) {
		return agnelleRimontaRepository.save(agnelleRimonta);
	}
	
	
	/**
	 * Metodo che ritorna una lista di istanze di tipo {@link Dmt_t_AgnelleRimonta} in base ad idSessione e cuaa
	 * @param idSessione identificativo univoco associato all'esecuzione
	 * @param cuaa codice fiscale del richiedente
	 * @return lista di istanze di tipo {@link Dmt_t_AgnelleRimonta}
	 */
	public List<Dmt_t_AgnelleRimonta> getByIdSessioneAndCuaa(Long idSessione, String cuaa) {
		return agnelleRimontaRepository.findByIdSessioneAndCuaa(idSessione, cuaa);
	}
	
	/**
	 * Metodo che ritorna la quotaCapiPremio in base ad idSessione, cuaa e codiceIntervento
	 * @param idSessione identificativo univoco associato all'esecuzione
	 * @param cuaa codice fiscale del richiedente
	 * @param codiceIntervento codice intervento
	 * @return Double quotaCapiPremio
	 */
	public Double getQuotaCapiPremioByIdSessioneAndCuaa(Long idSessione, String cuaa, String codiceIntervento) {
		return agnelleRimontaRepository.getQuotaCapiPremioByIdSessioneAndCuaa(idSessione, cuaa, codiceIntervento);
	}
}
