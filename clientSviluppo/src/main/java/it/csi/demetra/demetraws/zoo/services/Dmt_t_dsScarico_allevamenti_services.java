package it.csi.demetra.demetraws.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_dsScarico_allevamenti;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_dsScarico_allevamenti_repository;

/**
 * Classe service che utilizza le Query definite nel repository Dmt_t_dsScarico_allevamenti_repository
 * per la persistenza di oggetti di tipo Dmt_t_dsScarico_allevamenti
 * @author Bcsoft
 */
@Service
public class Dmt_t_dsScarico_allevamenti_services {

	/**
	 * Repository in cui sono definite le Query di tipo Dmt_t_dsScarico_allevamenti_repository.
	 */
	@Autowired
	Dmt_t_dsScarico_allevamenti_repository rep;

	/**
     * Metodo che restituisce una lista di tutte le istanze che persistono in DB di tipo {@link Dmt_t_dsScarico_allevamenti} in base ad annoCampagna.
     * @return lista degli oggetti di tipo {@link Dmt_t_dsScarico_allevamenti}
     */
	public List<Dmt_t_dsScarico_allevamenti> getAll() {
		return rep.findAll();
	}
}
