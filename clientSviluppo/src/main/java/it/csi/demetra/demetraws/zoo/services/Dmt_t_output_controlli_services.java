package it.csi.demetra.demetraws.zoo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_output_controlli_repository;

/**
 * Classe service che utilizza le Query definite nel repository Dmt_t_output_controlli_repository
 * per la persistenza di oggetti di tipo @see Dmt_t_output_controlli
 * @author Bcsoft
 */
@Service
public class Dmt_t_output_controlli_services {

	/**
	 * Repository in cui sono definite le Query di tipo Dmt_t_output_controlli_repository.
	 */
	@Autowired
	Dmt_t_output_controlli_repository rep;

	/**
	 * Metodo che effettua il salvataggio a DB di un'istanza di tipo Dmt_t_output_controlli.
	 * {@link Dmt_t_output_controlli_repository}
	 * @param output istanza da salvare a DB
	 */
	public void saveOutput(Dmt_t_output_controlli output) {
		rep.save(output);
	}
}
