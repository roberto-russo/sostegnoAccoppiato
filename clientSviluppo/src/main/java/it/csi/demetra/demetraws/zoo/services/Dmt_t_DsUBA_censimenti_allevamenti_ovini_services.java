package it.csi.demetra.demetraws.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_DsUBA_censimenti_allevamenti_ovini;
import it.csi.demetra.demetraws.zoo.repository.DsUBA_censimenti_allevamenti_ovini_repository;

@Service
/**
 * Classe service che utilizza le Query definite nel repository @see DsUBA_censimenti_allevamenti_ovini_repository
 * per la persistenza di oggetti di tipo @see DsUBA_censimenti_allevamenti_ovini
 * @author Bcsoft
 */
public class Dmt_t_DsUBA_censimenti_allevamenti_ovini_services {
	
	@Autowired
	/**
     * Repository in cui sono definite le Query di tipo @see DsUBA_censimenti_allevamenti_ovini_repository.
     */
	DsUBA_censimenti_allevamenti_ovini_repository censimOviniRepository;
	
	/**
	 * Metodo che ritorna una lista di istanze di tipo @see Dmt_t_DsUBA_censimenti_allevamenti_ovini in base a idSessione e codiceAzienda
	 * @see Dmt_t_DsUBA_censimenti_allevamenti_ovini_repository.findByIdSessioneAndCodiceAzienda
	 * @param idSessione identificativo univoco associato all'esecuzione
	 * @param codiceAzienda identificativo asssociato all'azienda
	 * @return List<Dmt_t_DsUBA_censimenti_allevamenti_ovini>
	 */
	public List<Dmt_t_DsUBA_censimenti_allevamenti_ovini> getCensimOviniByIdSessioneAndCodiceAzienda(Long idSessione, String codiceAzienda) {
		return censimOviniRepository.findByIdSessioneAndCodiceAzienda(idSessione, codiceAzienda);
	}
}
