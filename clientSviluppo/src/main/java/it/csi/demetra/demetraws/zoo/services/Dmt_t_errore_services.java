package it.csi.demetra.demetraws.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_errore;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_errore_repository;

/**
 * Classe service che utilizza le Query definite nel repository Dmt_t_errore_repository
 * per la persistenza di oggetti di tipo Dmt_t_errore
 * @author Bcsoft
 */
@Service
public class Dmt_t_errore_services {

	/**
	 * Repository in cui sono definite le Query di tipo DsUBA_censimenti_allevamenti_ovini_repository.
	 */
	@Autowired
	Dmt_t_errore_repository error_rep;
	
	/**
     * Metodo che restituisce una lista di tutte le istanze che persistono in DB di tipo {@link Dmt_t_errore} in base ad annoCampagna.
     * @see Dmt_t_errore_repository
     * @return Dmt_t_errore lista degli oggetti di tipo {@link Dmt_t_errore}
     */
	public List<Dmt_t_errore> getAll() {
		return error_rep.findAll();
	}
	
	/**
	 * Metodo che effettua il salvataggio a DB di un'istanza di tipo Dmt_t_errore.
	 * @see Dmt_t_errore_repository
	 * @param errore istanza da salvare a DB
	 */
	public void saveError(Dmt_t_errore errore) {
		error_rep.save(errore);
	}
}
