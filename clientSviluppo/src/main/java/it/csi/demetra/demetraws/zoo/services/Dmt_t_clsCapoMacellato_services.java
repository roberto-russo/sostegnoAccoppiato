package it.csi.demetra.demetraws.zoo.services;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_clsCapoMacellato;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_clsCapoMacellato_repository;

/**
 * Classe service che utilizza le Query definite nel repository Dmt_t_clsCapoMacellato_repository
 * per la persistenza di oggetti di tipo Dmt_t_clsCapoMacellato
 * @author Bcsoft
 */
@Service
public class Dmt_t_clsCapoMacellato_services {

	/**
	 * Repository in cui sono definite le Query di tipo Dmt_t_clsCapoMacellato_repository.
	 */
	@Autowired
	Dmt_t_clsCapoMacellato_repository rep;
	
	/**
     * Metodo che restituisce una lista di tutte le istanze che persistono in DB di tipo {@link Dmt_t_clsCapoMacellato} in base ad annoCampagna.
     * @return  lista degli oggetti di tipo {@link Dmt_t_clsCapoMacellato}
     */
	public List<Dmt_t_clsCapoMacellato> getCapo(){
		return rep.findAll();
	}
	
	/**
	 * Metodo che effettua il salvataggio di una lista di istanze di tipo Dtm_t_clsCapoMacellato
	 * @param capo lista di istanze da salvare a DB
	 */
	public void saveCapo(List<Dmt_t_clsCapoMacellato> capo) {
		for(Dmt_t_clsCapoMacellato c : capo)
			rep.save(c);
//		rep.saveAll(capo);
	}
	
	/**
	 * Metodo che ritorna una lista di istanze di tipo @see Dmt_t_clsCapoMacellato in base a capoId, idSessione e codiceIntervento
	 * @param capoId identificativo univoco associato al capo animale
	 * @param idSessione identificativo univoco associato all'esecuzione
	 * @param codiceIntervento codice intervento
	 * @return Dmt_t_clsCapoMacellato
	 */
	public List<Dmt_t_clsCapoMacellato> getDuplicazioni(Long capoId, Long idSessione, String codiceIntervento){
		return rep.FindByCapoId(idSessione, capoId, codiceIntervento);
	}
	
	/**
	 * Metodo che ritorna una lista di tipo {@link Dmt_t_clsCapoMacellato} in base a idSessione, cuaa e codiceIntervento
	 * @param idSessione identificativo univoco associato all'esecuzione
	 * @param cuaa codice fiscale del richiedente
	 * @param codiceIntervento codice intervento
	 * @return Dmt_t_clsCapoMacellato
	 */
	public List<Dmt_t_clsCapoMacellato> getCapiMacellatiByIDSessionCuaaCodInt(Long idSessione,String cuaa,String codiceIntervento){
		return rep.findByIdSessionAndCuaa(idSessione, cuaa, codiceIntervento);
	}
	
	/**
	 * Metodo che ritorna una lista di tipo {@link Dmt_t_clsCapoMacellato} in base a idSessione, cuaa e codiceIntervento.
	 * @see Dmt_t_clsCapoMacellato_repository
	 * @param idSessione identificativo univoco associato all'esecuzione
	 * @param cuaa codice fiscale del richiedente
	 * @param codIntervento codice intervento
	 * @return lista di istanze di tipo {@link Dmt_t_clsCapoMacellato}
	 */
	public List<Dmt_t_clsCapoMacellato>getMacellatiUbaMinime(Long idSessione, String cuaa, String codIntervento) {
		return rep.getMacellatiUbaMinime(idSessione, cuaa, codIntervento);
	}

	public List<Dmt_t_clsCapoMacellato> getCapiMacellatiByStalla(Long idSessione, String cuaa, String codiceAsl, Long idCapo) {
		return rep.getCapiMacellatiByStalla(idSessione,cuaa,codiceAsl,idCapo);
	}
}
