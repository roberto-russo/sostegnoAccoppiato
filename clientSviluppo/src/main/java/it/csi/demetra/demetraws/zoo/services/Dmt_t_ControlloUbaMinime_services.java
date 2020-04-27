package it.csi.demetra.demetraws.zoo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_ControlloUbaMinime;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_ControlloUbaMinime_repository;

@Service
public class Dmt_t_ControlloUbaMinime_services {

	@Autowired
	Dmt_t_ControlloUbaMinime_repository repo;
	
	public void save (Dmt_t_ControlloUbaMinime model ) {
		repo.save(model);
	}
	
}
