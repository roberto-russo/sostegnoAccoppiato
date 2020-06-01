package it.csi.demetra.demetraws.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_clsCapoMacellato;

@Repository
/**
 * interfaccia che estende CrudRepository in cui sono definiti i metodi di persistenza degli oggetti
 * di tipo @see Dmt_t_clsCapoMacellato e le query ad esso associate.
 * @author Bcsoft
 */
public interface Dmt_t_clsCapoMacellato_repository extends CrudRepository<Dmt_t_clsCapoMacellato, Long>{

	/**
	 * query che ritorna la lista delle istanze che persistono a DB di tipo Dmt_t_clsCapoMacellato
	 */
	List<Dmt_t_clsCapoMacellato>findAll();
	
	@Query(value = "SELECT * FROM DMT_T_CLS_CAPO_MACELLATO WHERE ID_SESSIONE = :idSessione ", nativeQuery = true)
	/**
	 * query che ritorna una lista di istanze di tipo Dmt_t_clsCapoMacellato in base all' idSessione.
	 * @param idSessione codice di sessione associato all'esecuzione
	 * @return List<Dmt_t_clsCapoMacellato>
	 */
	List<Dmt_t_clsCapoMacellato>findByIdSession(@Param("idSessione") Long idSessione);
	
	@Query(value = "SELECT * FROM DMT_T_CLS_CAPO_MACELLATO WHERE ID_SESSIONE = :idSessione AND CUAA = :cuaa and CODICE_PREMIO = :codiceIntervento", nativeQuery = true)
	/**
	 * query che ritorna una lista di istanze di tipo Dmt_t_clsCapoMacellato in base all'idSesione, il cuaa e il codiceIntervento
	 * @param idSessione codice di sessione associato all'esecuzione
	 * @param cuaa codice fiscale del richiedente
	 * @param codiceIntervento codice intervento per cui il cuaa ha fatto richiesta.
	 * @return List<Dmt_t_clsCapoMacellato>
	 */
	List<Dmt_t_clsCapoMacellato>findByIdSessionAndCuaa(@Param("idSessione") Long idSessione, @Param("cuaa") String cuaa, @Param("codiceIntervento") String codiceIntervento);
	
	@Query(value = "SELECT * FROM DMT_T_CLS_CAPO_MACELLATO "
				 + "WHERE ID_SESSIONE = :idSessione AND CUAA = :cuaa "
				 + "AND months_between(SYSDATE,TO_DATE(:dataNascita,'dd/mm/yy'))>20 "
				 + "AND months_between(SYSDATE,TO_DATE(:dataNascita,'dd/mm/yy'))/12 <= 18", 
		   nativeQuery = true)
	/**
	 * query che ritorna una lista di istanze di tipo Dmt_t_clsCapoMacellato in base all'idSessione, il cuaa  e dataNascita compresa tra  [18,20)
	 * @param idSessione codice di sessione associato all'esecuzione
	 * @param cuaa codice fiscale del richiedente
	 * @return List<Dmt_t_clsCapoMacellato>
	 */
	List<Dmt_t_clsCapoMacellato>findByIdSessionAndCuaa9903(@Param("idSessione") Long idSessione, @Param("cuaa") String cuaa);
	
	@Query(value = "select * from dmt_t_cls_capo_macellato where id_sessione = :idSessione and codice_premio = :codiceIntervento and capo_id = :capoId ", nativeQuery= true )
	/**
	 * query che ritorna una lista di istanze di tipo Dmt_t_cls_capoMacellato in base all'idSessione, il codiceIntervento e il capoId
	 * @param idSessione codice di sessione associato all'esecuzione
	 * @param capoId identificativo del capo animale
	 * @param codiceIntervento codice identificativo del premio
	 * @return Liat<Dmt_t_clsCapoMacellato>
	 */
	List<Dmt_t_clsCapoMacellato> FindByCapoId(@Param("idSessione") Long idSessione, @Param("capoId") Long capoId, @Param("codiceIntervento") String codiceIntervento);

	
	@Query(
			value = "SELECT * FROM DMT_T_CLS_CAPO_MACELLATO WHERE ID_SESSIONE = :idSessione and CUAA = :cuaa ",
			nativeQuery = true
		)
	/**
	 * query che ritorna una lista di istanze di tipo Dmt_t_clsCapoMacellato in base allìidSessione e il cuaa
	 * @param idSessione codice di sessione associato all'esecuzione
	 * @param cuaa codice fiscale del richiedente
	 * @return List<Dmt_t_clsCapoMacellato>
	 */
	List<Dmt_t_clsCapoMacellato> findBySessioneAndCuaa(@Param("idSessione")Long idSessione, @Param("cuaa") String cuaa);

}
