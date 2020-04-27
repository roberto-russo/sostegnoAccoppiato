package it.csi.demetra.demetraws.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_razze_ammissibili;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_razze_ammissibili_repository;

@Service
public class Dmt_t_razze_ammissibili_services {

	@Autowired
	Dmt_t_razze_ammissibili_repository rep;
	
	 public List<Dmt_t_razze_ammissibili> getAll() {
	        return rep.findAll();
	    }
}
