package it.csi.demetra.demetraws.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tbdn_du_capi;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_Tbdn_du_capi_repository;

@Service
public class Dmt_t_Tbdn_du_capi_services {
	
	@Autowired
	Dmt_t_Tbdn_du_capi_repository rep;
	
	public List<Dmt_t_Tbdn_du_capi> getCapo(){
		return rep.findAll();
	}
	
	public void saveCapo(List<Dmt_t_Tbdn_du_capi> capo) {
		rep.saveAll(capo);
	}
}
