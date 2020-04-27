package it.csi.demetra.demetraws.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_dsScarico_allevamenti;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_dsScarico_allevamenti_repository;

@Service
public class Dmt_t_dsScarico_allevamenti_services {

	@Autowired
	Dmt_t_dsScarico_allevamenti_repository rep;

	public List<Dmt_t_dsScarico_allevamenti> getAll() {
		return rep.findAll();
	}
}
