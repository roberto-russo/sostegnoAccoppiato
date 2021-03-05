package it.csi.demetra.demetraws.zoo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_esclusi;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_output_esclusi_repository;


/**
 * Classe service che utilizza le Query definite nel repository Dmt_t_output_esclusi_repository
 * per la persistenza di oggetti di tipo Dmt_t_output_esclusi
 * @author Bcsoft
 */
@Service
public class Dmt_t_output_esclusi_services {

	/**
	 * Repository in cui sono definite le Query di tipo Dmt_t_output_esclusi_repository.
	 */
	@Autowired
	Dmt_t_output_esclusi_repository rep;

	/**
	 * Metodo che effettua il salvataggio a DB di un'istanza di tipo Dmt_t_output_esclusi.
	 * {@link Dmt_t_output_esclusi_repository}
	 * @param output istanza da salvare a DB di tipo  {@link Dmt_t_output_esclusi}
	 */
	public void saveOutputEscl(Dmt_t_output_esclusi output) {
		rep.save(output);
	}
}
