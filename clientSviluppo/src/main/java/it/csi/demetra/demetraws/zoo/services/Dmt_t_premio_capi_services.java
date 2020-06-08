package it.csi.demetra.demetraws.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_premio_capi;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_premio_capi_repository;

@Service
/**
 * Classe service che utilizza le Query definite nel repository @see Dmt_t_premio_capi_repository
 * per la persistenza di oggetti di tipo @see Dmt_t_premio_capi
 * @author Bcsoft
 */
public class Dmt_t_premio_capi_services {
	
	@Autowired
	/**
     * Repository in cui sono definite le Query di tipo @see Dmt_t_premio_capi_repository.
     */
	Dmt_t_premio_capi_repository capiRepository;
	
	/**
	 * Metodo che effettua il salvataggio a DB di una lista di istanze di tipo @see Dmt_t_premio_capi.
	 * @see Dmt_t_premio_capi_repository.saveAll
	 * @param output istanza da salvare a DB
	 */
	public void saveAll (List<Dmt_t_premio_capi> listaCapi) {
//		System.out.println(listaCapi.get(0).getIdSessione().getIdSessione());
		capiRepository.saveAll(listaCapi);
	}
	
}
