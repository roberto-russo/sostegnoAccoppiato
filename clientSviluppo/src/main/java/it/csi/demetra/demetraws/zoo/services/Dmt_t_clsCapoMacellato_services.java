package it.csi.demetra.demetraws.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_clsCapoMacellato;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_clsCapoMacellato_repository;

@Service
public class Dmt_t_clsCapoMacellato_services {

	@Autowired
	Dmt_t_clsCapoMacellato_repository rep;
	
	public List<Dmt_t_clsCapoMacellato> getCapo(){
		return rep.findAll();
	}
	
	public void saveCapo(List<Dmt_t_clsCapoMacellato> capo) {
		rep.saveAll(capo);
	}
	
	public List<Dmt_t_clsCapoMacellato> getDuplicazioni(Long capoId, Long idSessione, String codiceIntervento){
		return rep.FindByCapoId(idSessione, capoId, codiceIntervento);
	}
}
