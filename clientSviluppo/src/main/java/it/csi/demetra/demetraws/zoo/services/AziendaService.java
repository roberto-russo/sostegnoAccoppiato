package it.csi.demetra.demetraws.zoo.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Rpu_V_pratica_zoote;
import it.csi.demetra.demetraws.zoo.repository.Rpu_V_pratica_zoote_repository;

@Service
/**
 * Classe service che utilizza le Query definite nel repository @see Rpu_V_pratica_zoote_repository
 * per la persistenza di oggetti di tipo @see Rpu_V_pratica_zoote
 * @author Bcsoft
 */
public class AziendaService {

    @Autowired
    /**
     * Repository in cui sono definite le Query di tipo @see Rpu_V_pratica_zoote_repository.
     */
    Rpu_V_pratica_zoote_repository rep;

    /**
     * Metodo che restituisce una lista di tutte le istanze che persistono in DB di tipo @seeRpu_V_pratica_zoote in base ad annoCampagna.
     * @see Rpu_V_pratica_zoote_repository.findAll
     * @param annoCampagna anno della campagna
     * @return List<Rpu_V_pratica_zoote> lista degli oggetti di tipo @Rpu_V_pratica_zoote
     */
    public List<Rpu_V_pratica_zoote> getAll(Integer annoCampagna) {
        return rep.findAll(annoCampagna);
    }
    
    /**
     * Metodo che restituisce una lista di istanze di tipo @see Rpu_V_pratica_zoote che persistono in DB di tipo @Rpu_V_pratica_zoote in base  ad una lista di codici premio e ad  annoCampagna
     * @param codiciPremioList lista dei codici premio
     * @param annoCampagna anno della campagna
     * @return List<Rpu_V_pratica_zoote> lista di oggetti di tipo @Rpu_V_pratica_zoote.
     */
    public List<Rpu_V_pratica_zoote> getByCodiciPremioAndAnnoCampagna(List<String> codiciPremioList, Integer annoCampagna) {
    	
    	return rep.findByCodiciPremioAndAnnoCampagna(codiciPremioList, annoCampagna);
    }
    
}
