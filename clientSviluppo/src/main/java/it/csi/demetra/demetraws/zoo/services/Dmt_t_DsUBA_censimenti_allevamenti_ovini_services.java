package it.csi.demetra.demetraws.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_DsUBA_censimenti_allevamenti_ovini;
import it.csi.demetra.demetraws.zoo.repository.DsUBA_censimenti_allevamenti_ovini_repository;

/**
 * Classe service che utilizza le Query definite nel repository DsUBA_censimenti_allevamenti_ovini_repository
 * per la persistenza di oggetti di tipo DsUBA_censimenti_allevamenti_ovini
 * @author Bcsoft
 */
@Service
public class Dmt_t_DsUBA_censimenti_allevamenti_ovini_services {
	
	/**
	 * Repository in cui sono definite le Query di tipo DsUBA_censimenti_allevamenti_ovini_repository.
	 */
	@Autowired
	DsUBA_censimenti_allevamenti_ovini_repository censimOviniRepository;
	
	/**
	 * Metodo che ritorna una lista di istanze di tipo {@link Dmt_t_DsUBA_censimenti_allevamenti_ovini} in base a idSessione e codiceAzienda
	 * @param idSessione identificativo univoco associato all'esecuzione
	 * @param codFiscaleDete codice fiscale del detentore
	 * @return lista di istanze di tipo {@link Dmt_t_DsUBA_censimenti_allevamenti_ovini}
	 */	
	public List<Dmt_t_DsUBA_censimenti_allevamenti_ovini> getCensimOviniByIdSessioneAndCodFiscaleDete(Long idSessione, String codFiscaleDete) {
		return censimOviniRepository.findByIdSessioneAndCodFiscaleDete(idSessione, codFiscaleDete);
	}
}
