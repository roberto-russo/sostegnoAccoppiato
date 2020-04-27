package it.csi.demetra.demetraws.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_bovini;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_tws_bdn_du_capi_bovini_repository;

@Service
public class Dmt_t_tws_bdn_du_capi_bovini_services {
	
	@Autowired
	 Dmt_t_tws_bdn_du_capi_bovini_repository rep;
	
	public List< Dmt_t_Tws_bdn_du_capi_bovini> getCapo(){
		return rep.findAll();
	}
	
	public void saveCapo(List< Dmt_t_Tws_bdn_du_capi_bovini> capo) {
		rep.saveAll(capo);
	}
	
	public List<Dmt_t_Tws_bdn_du_capi_bovini> getVitelliOfVacca(Long idSessione, String cuaa, Long idCapo, Long annoCampagna) {
		return rep.getVitelliOfVacca(idSessione, cuaa, idCapo, annoCampagna);
	}
}
