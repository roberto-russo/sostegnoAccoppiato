package it.csi.demetra.demetraws.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_DsUBA_censimenti_allevamenti_ovini;
import it.csi.demetra.demetraws.zoo.repository.DsUBA_censimenti_allevamenti_ovini_repository;

@Service
public class Dmt_t_DsUBA_censimenti_allevamenti_ovini_services {
	
	@Autowired
	DsUBA_censimenti_allevamenti_ovini_repository censimOviniRepository;
	
	
	public List<Dmt_t_DsUBA_censimenti_allevamenti_ovini> getCensimOviniByIdSessioneAndCodFiscaleDete(Long idSessione, String codFiscaleDete) {
		return censimOviniRepository.findByIdSessioneAndCodFiscaleDete(idSessione, codFiscaleDete);
	}
	
	
	
	 
	

}
