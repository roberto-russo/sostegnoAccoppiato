package it.csi.demetra.demetraws.zoo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_esclusi;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_output_esclusi_repository;


@Service
/**
 * Classe service che utilizza le Query definite nel repository @see Dmt_t_output_esclusi_repository
 * per la persistenza di oggetti di tipo @see Dmt_t_output_esclusi
 * @author Bcsoft
 */
public class Dmt_t_output_esclusi_services {

	@Autowired
	/**
     * Repository in cui sono definite le Query di tipo @see Dmt_t_output_esclusi_repository.
     */
	Dmt_t_output_esclusi_repository rep;

	/**
	 * Metodo che effettua il salvataggio a DB di un'istanza di tipo @see Dmt_t_output_esclusi.
	 * @see Dmt_t_output_esclusi_repository
	 * @param output istanza da salvare a DB
	 */
	public void saveOutputEscl(Dmt_t_output_esclusi output) {
		rep.save(output);
	}
}
