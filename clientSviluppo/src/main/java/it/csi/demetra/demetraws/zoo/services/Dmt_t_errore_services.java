package it.csi.demetra.demetraws.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_errore;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_errore_repository;

@Service
public class Dmt_t_errore_services {

	@Autowired
	Dmt_t_errore_repository error_rep;
	
	public List<Dmt_t_errore> getAll() {
		return error_rep.findAll();
	}
	
	public void saveError(Dmt_t_errore errore) {
		error_rep.save(errore);
	}
}
