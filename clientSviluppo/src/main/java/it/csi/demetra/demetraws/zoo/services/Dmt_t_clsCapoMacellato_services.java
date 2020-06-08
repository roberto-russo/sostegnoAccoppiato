package it.csi.demetra.demetraws.zoo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_clsCapoMacellato;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_clsCapoMacellato_repository;

@Service
/**
 * Classe service che utilizza le Query definite nel repository @see Dmt_t_clsCapoMacellato_repository
 * per la persistenza di oggetti di tipo @see Dmt_t_clsCapoMacellato
 * @author Bcsoft
 */
public class Dmt_t_clsCapoMacellato_services {

	@Autowired
	/**
     * Repository in cui sono definite le Query di tipo @see Dmt_t_clsCapoMacellato_repository.
     */
	Dmt_t_clsCapoMacellato_repository rep;
	
	/**
     * Metodo che restituisce una lista di tutte le istanze che persistono in DB di tipo @see Dmt_t_clsCapoMacellato in base ad annoCampagna.
     * @see Dmt_t_clsCapoMacellato_repository.findAll
     * @return List<Dmt_t_clsCapoMacellato> lista degli oggetti di tipo @see Dmt_t_clsCapoMacellato
     */
	public List<Dmt_t_clsCapoMacellato> getCapo(){
		return rep.findAll();
	}
	
	/**
	 * Metodo che effettua il salvataggio di una lista di istanze di tipo @see Dtm_t_clsCapoMacellato
	 * @see Dmt_t_clsCapoMacellato_repository.saveAll
	 * @param capo lista di istanze da salvare a DB
	 */
	public void saveCapo(List<Dmt_t_clsCapoMacellato> capo) {
		rep.saveAll(capo);
	}
	
	/**
	 * Metodo che ritorna una lista di istanze di tipo @see Dmt_t_clsCapoMacellato in base a capoId, idSessione e codiceIntervento
	 * @see Dmt_t_clsCapoMacellato_repository.findByCapoId
	 * @param capoId identificativo univoco associato al capo animale
	 * @param idSessione identificativo univoco associato all'esecuzione
	 * @param codiceIntervento codice intervento
	 * @return List<Dmt_t_clsCapoMacellato>
	 */
	public List<Dmt_t_clsCapoMacellato> getDuplicazioni(Long capoId, Long idSessione, String codiceIntervento){
		return rep.FindByCapoId(idSessione, capoId, codiceIntervento);
	}
	
	/**
	 * Metodo che ritorna una lista di tipo @see Dmt_t_clsCapoMacellato in base a idSessione, cuaa e codiceIntervento
	 * @see Dmt_t_clsCapoMacellato_repository.findByIdSessionAndCuaa
	 * @param idSessione identificativo univoco associato all'esecuzione
	 * @param cuaa codice fiscale del richiedente
	 * @param codiceIntervento codice intervento
	 * @return List<Dmt_t_clsCapoMacellato>
	 */
	public List<Dmt_t_clsCapoMacellato> getCapiMacellatiByIDSessionCuaaCodInt(Long idSessione,String cuaa,String codiceIntervento){
		return rep.findByIdSessionAndCuaa(idSessione, cuaa, codiceIntervento);
	}
}
