package it.csi.demetra.demetraws.zoo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Rpu_V_pratica_zoote;
import it.csi.demetra.demetraws.zoo.repository.Rpu_V_pratica_zoote_repository;

import java.util.List;

@Service
public class AziendaService {

    @Autowired
    Rpu_V_pratica_zoote_repository rep;

    public List<Rpu_V_pratica_zoote> getAll(Integer annoCampagna) {
        return rep.findAll(annoCampagna);
    }
    
    public List<Rpu_V_pratica_zoote> getByCodiciPremioAndAnnoCampagna(List<String> codiciPremioList, Integer annoCampagna) {
    	
    	return rep.findByCodiciPremioAndAnnoCampagna(codiciPremioList, annoCampagna);
    }
    
}
