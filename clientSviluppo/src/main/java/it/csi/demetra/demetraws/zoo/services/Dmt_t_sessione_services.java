package it.csi.demetra.demetraws.zoo.services;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_sessione_repository;

@Service
public class Dmt_t_sessione_services {

	@Autowired
	Dmt_t_sessione_repository rep;

	public List<Dmt_t_sessione> getAll() {
		return rep.findAll();
	}
	
	public Dmt_t_sessione get(Date dataEora) {
		return rep.findSessioneByDataEora(dataEora);
	}
	
	public Dmt_t_sessione saveSession(Dmt_t_sessione sessione) {
		return rep.save(sessione);
	}
	
	public Dmt_t_sessione getById(Long idSessione) {
		return rep.findById(idSessione).orElseThrow( () ->  new NoSuchElementException());
	}
}
