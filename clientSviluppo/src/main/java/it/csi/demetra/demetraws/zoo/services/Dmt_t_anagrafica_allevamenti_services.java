package it.csi.demetra.demetraws.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_anagrafica_allevamenti;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_anagrafica_allevamenti_repository;

@Service
/**
 * Classe service che utilizza le Query definite nel repository @see Dmt_t_anagrafica_allevamenti_repository
 * per la persistenza di oggetti di tipo @see Dmt_t_anagrafica_allevamenti
 * @author Bcsoft
 */
public class Dmt_t_anagrafica_allevamenti_services {

	@Autowired
	  /**
     * Repository in cui sono definite le Query di tipo @see Dmt_t_anagrafica_allevamenti_repository.
     */
	Dmt_t_anagrafica_allevamenti_repository rep;

	/**
     * Metodo che restituisce una lista di tutte le istanze che persistono in DB di tipo Dmt_t_anagrafica_allevamenti in base ad annoCampagna.
     * @see Dmt_t_anagrafica_allevamenti_repository
     * @return Dmt_t_anagrafica_allevamenti lista degli oggetti di tipo Dmt_t_anagrafica_allevamenti
     */
	public List<Dmt_t_anagrafica_allevamenti> getAll() {
		return rep.findAll();
	}
}
