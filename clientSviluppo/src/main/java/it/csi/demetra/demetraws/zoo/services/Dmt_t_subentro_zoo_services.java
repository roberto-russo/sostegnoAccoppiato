package it.csi.demetra.demetraws.zoo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_subentro_zoo;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_subentro_zoo_repository;

@Service
public class Dmt_t_subentro_zoo_services {

	@Autowired
	Dmt_t_subentro_zoo_repository rep;
	
	public List<Dmt_t_subentro_zoo> getAll() {
		return rep.findAll();
	}
	
	public Dmt_t_subentro_zoo getSubentro(long annoCampagna, String cuaaDomanda) {
		return rep.findSubentroByData(annoCampagna, cuaaDomanda);
	}
	
	public void saveSubentro(Dmt_t_subentro_zoo subentro) {
		rep.save(subentro);
	}
}
