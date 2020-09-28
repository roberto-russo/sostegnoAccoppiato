package it.csi.demetra.demetraws.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_demarcazione_PSR;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_demarcazione_PSR_repository;

@Service
public class Dmt_t_demarcazione_PSR_services {

	@Autowired
	Dmt_t_demarcazione_PSR_repository rep;

	
	public List<Dmt_t_demarcazione_PSR> getAll() {
		return rep.findAll();
	}
}
