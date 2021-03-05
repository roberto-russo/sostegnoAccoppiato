package it.csi.demetra.demetraws.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_premio_capi;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_premio_capi_repository;

/**
 * Classe service che utilizza le Query definite nel repository Dmt_t_premio_capi_repository
 * per la persistenza di oggetti di tipo Dmt_t_premio_capi
 * @author Bcsoft
 */
@Service
public class Dmt_t_premio_capi_services {
	
	/**
	 * Repository in cui sono definite le Query di tipo Dmt_t_premio_capi_repository.
	 */
	@Autowired
	Dmt_t_premio_capi_repository capiRepository;
	
	/**
	 * Metodo che effettua il salvataggio a DB di una lista di istanze di tipo Dmt_t_premio_capi.
	 * @param listaCapi output istanza da salvare a DB
	 */
	public void saveAll (List<Dmt_t_premio_capi> listaCapi) {
		for(Dmt_t_premio_capi c : listaCapi)
			capiRepository.save(c);
//		capiRepository.saveAll(listaCapi);
	}
	
}
