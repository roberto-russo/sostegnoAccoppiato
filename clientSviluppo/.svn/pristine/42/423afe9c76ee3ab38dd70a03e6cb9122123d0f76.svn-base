package it.csi.demetra.demetraws.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_AgnelleRimonta;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_AgnelleRimonta_repository;

@Service
public class Dmt_t_AgnelleRimonta_services {
	
	@Autowired
	Dmt_t_AgnelleRimonta_repository agnelleRimontaRepository;
	
	
	public Dmt_t_AgnelleRimonta save(Dmt_t_AgnelleRimonta agnelleRimonta) {
		return agnelleRimontaRepository.save(agnelleRimonta);
	}
	
	
	public List<Dmt_t_AgnelleRimonta> getByIdSessioneAndCuaa(Long idSessione, String cuaa) {
		return agnelleRimontaRepository.findByIdSessioneAndCuaa(idSessione, cuaa);
	}
	
	public Double getQuotaCapiPremioByIdSessioneAndCuaa(Long idSessione, String cuaa, String codiceIntervento) {
		return agnelleRimontaRepository.getQuotaCapiPremioByIdSessioneAndCuaa(idSessione, cuaa, codiceIntervento);
	}
}
