package it.csi.demetra.demetraws.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_premio_capi;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_premio_capi_repository;

@Service
public class Dmt_t_premio_capi_services {
	@Autowired
	Dmt_t_premio_capi_repository capiRepository;
	
	public void saveAll (List<Dmt_t_premio_capi> listaCapi) {
		System.out.println(listaCapi.get(0).getIdSessione().getIdSessione());
		capiRepository.saveAll(listaCapi);
	}
	
}
