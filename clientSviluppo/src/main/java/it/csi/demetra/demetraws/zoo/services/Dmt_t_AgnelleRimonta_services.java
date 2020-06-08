package it.csi.demetra.demetraws.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_AgnelleRimonta;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_AgnelleRimonta_repository;

@Service
/**
 * Classe service che utilizza le Query definite nel repository @see Dmt_t_AgnelleRimonta_repository
 * per la persistenza di oggetti di tipo @see Dmt_t_AgnelleRimonta
 * @author Bcsoft
 */
public class Dmt_t_AgnelleRimonta_services {
	
	@Autowired
	  /**
     * Repository in cui sono definite le Query di tipo @see Dmt_t_AgnelleRimonta_repository.
     */
	Dmt_t_AgnelleRimonta_repository agnelleRimontaRepository;
	
	/**
	 * Metodo che effettua il salvataggio a DB di un'istanza di tipo @see Dmt_t_AgnelleRimonta
	 * @see Dmt_t_AgnelleRimonta_repository.save
	 * @param agnelleRimonta istanza da salvare a DB
	 * @return Dmt_t_AgnelleRimonta istanza salvata a DB
	 */
	public Dmt_t_AgnelleRimonta save(Dmt_t_AgnelleRimonta agnelleRimonta) {
		return agnelleRimontaRepository.save(agnelleRimonta);
	}
	
	
	/**
	 * Metodo che ritorna una lista di istanze di tipo @see Dmt_t_AgnelleRimonta in base ad idSessione e cuaa
	 * @see Dmt_t_AgnelleRimonta_repository.findBiIdSessioneAndCuaa.
	 * @param idSessione identificativo univoco associato all'esecuzione
	 * @param cuaa codice fiscale del richiedente
	 * @return List<dmt_t_AgnelleRimonta>
	 */
	public List<Dmt_t_AgnelleRimonta> getByIdSessioneAndCuaa(Long idSessione, String cuaa) {
		return agnelleRimontaRepository.findByIdSessioneAndCuaa(idSessione, cuaa);
	}
	
	/**
	 * Metodo che ritorna la quotaCapiPremio in base ad idSessione, cuaa e codiceIntervento
	 * @see Dmt_t_AgnelleRimonta_repository.getQuotaCapiPremioByIdSessioneAndCuaa
	 * @param idSessione identificativo univoco associato all'esecuzione
	 * @param cuaa codice fiscale del richiedente
	 * @param codiceIntervento codice intervento
	 * @return Double quotaCapiPremio
	 */
	public Double getQuotaCapiPremioByIdSessioneAndCuaa(Long idSessione, String cuaa, String codiceIntervento) {
		return agnelleRimontaRepository.getQuotaCapiPremioByIdSessioneAndCuaa(idSessione, cuaa, codiceIntervento);
	}
}
