package it.csi.demetra.demetraws.zoo.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Rpu_V_pratica_zoote;
import it.csi.demetra.demetraws.zoo.repository.Rpu_V_pratica_zoote_repository;

/**
 * Classe service che utilizza le Query definite nel repository Rpu_V_pratica_zoote_repository
 * per la persistenza di oggetti di tipo Rpu_V_pratica_zoote
 * @author Bcsoft
 */
@Service
public class AziendaService {

	/**
	 * Repository in cui sono definite le Query di tipo Rpu_V_pratica_zoote_repository.
	 */
    @Autowired
    Rpu_V_pratica_zoote_repository rep;

    /**
     * Metodo che restituisce una lista di tutte le istanze che persistono in DB di tipo {@link Rpu_V_pratica_zoote} in base ad annoCampagna.
     * {@link Rpu_V_pratica_zoote_repository#findAll()}
     * @param annoCampagna anno della campagna
     * @return Rpu_V_pratica_zoote lista degli oggetti di tipo {@link Rpu_V_pratica_zoote}
     */
    public List<Rpu_V_pratica_zoote> getAll(Integer annoCampagna) {
        return rep.findAll(annoCampagna);
    }
    
    /**
     * Metodo che restituisce una lista di istanze di tipo @see {@link Rpu_V_pratica_zoote} che persistono in DB di tipo @Rpu_V_pratica_zoote in base  ad una lista di codici premio e ad  annoCampagna
     * {@link Rpu_V_pratica_zoote_repository#findByCodiciPremioAndAnnoCampagna(List, Integer)}
     * @param codiciPremioList lista dei codici premio
     * @param annoCampagna anno della campagna
     * @return Rpu_V_pratica_zoote lista di oggetti di tipo Rpu_V_pratica_zoote.
     */
    public List<Rpu_V_pratica_zoote> getByCodiciPremioAndAnnoCampagna(List<String> codiciPremioList, Integer annoCampagna) {
    	
    	return rep.findByCodiciPremioAndAnnoCampagna(codiciPremioList, annoCampagna);
    }
    
}
