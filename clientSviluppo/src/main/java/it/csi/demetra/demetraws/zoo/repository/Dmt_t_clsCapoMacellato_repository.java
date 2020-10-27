package it.csi.demetra.demetraws.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_clsCapoMacellato;

/**
 * interfaccia che estende CrudRepository in cui sono definiti i metodi di persistenza degli oggetti
 * di tipo @see Dmt_t_clsCapoMacellato e le query ad esso associate.
 * @author Bcsoft
 */
@Repository
public interface Dmt_t_clsCapoMacellato_repository extends CrudRepository<Dmt_t_clsCapoMacellato, Long>{

	/**
	 * query che ritorna la lista delle istanze che persistono a DB di tipo Dmt_t_clsCapoMacellato
	 */
	List<Dmt_t_clsCapoMacellato>findAll();
	
	/**
	 * query che ritorna una lista di istanze di tipo Dmt_t_clsCapoMacellato in base all' idSessione.
	 * @param idSessione - codice di sessione associato all'esecuzione
	 * @return lista di istanze di tipo @see Dmt_t_clsCapoMacellato
	 */
	@Query(value = "SELECT * FROM DMT_T_CLS_CAPO_MACELLATO where id_sessione = :idSessione ", nativeQuery = true)
	List<Dmt_t_clsCapoMacellato>findByIdSession(@Param("idSessione") Long idSessione);
	
	/**
	 * query che ritorna una lista di istanze di tipo Dmt_t_clsCapoMacellato in base all'idSesione, il cuaa e il codiceIntervento
	 * @param idSessione - codice di sessione associato all'esecuzione
	 * @param cuaa - codice fiscale del richiedente
	 * @param codiceIntervento - codice intervento per cui il cuaa ha fatto richiesta.
	 * @return lista di istanze di tipo Dmt_t_clsCapoMacellato
	 */
	@Query(value = "SELECT * FROM DMT_T_CLS_CAPO_MACELLATO where id_sessione = :idSessione AND CUAA = :cuaa and CODICE_PREMIO = :codiceIntervento", nativeQuery = true)
	List<Dmt_t_clsCapoMacellato>findByIdSessionAndCuaa(@Param("idSessione") Long idSessione, @Param("cuaa") String cuaa, @Param("codiceIntervento") String codiceIntervento);
	
	/**
	 * query che ritorna una lista di istanze di tipo Dmt_t_clsCapoMacellato in base all'idSessione, il cuaa  e dataNascita compresa tra  [18,20)
	 * @param idSessione - codice di sessione associato all'esecuzione
	 * @param cuaa - codice fiscale del richiedente
	 * @return lista di istanze di tipo Dmt_t_clsCapoMacellato
	 */
	@Query(value = "SELECT * FROM DMT_T_CLS_CAPO_MACELLATO "
				 + "where id_sessione = :idSessione AND CUAA = :cuaa "
				 + "AND months_between(SYSDATE,TO_DATE(:dataNascita,'dd/mm/yy'))>20 "
				 + "AND months_between(SYSDATE,TO_DATE(:dataNascita,'dd/mm/yy'))/12 <= 18", 
		   nativeQuery = true)
	List<Dmt_t_clsCapoMacellato>findByIdSessionAndCuaa9903(@Param("idSessione") Long idSessione, @Param("cuaa") String cuaa);
	
	/**
	 * query che ritorna una lista di istanze di tipo Dmt_t_cls_capoMacellato in base all'idSessione, il codiceIntervento e il capoId
	 * @param idSessione codice di sessione associato all'esecuzione
	 * @param capoId identificativo del capo animale
	 * @param codiceIntervento codice identificativo del premio
	 * @return lista di istanze di tipo Dmt_t_clsCapoMacellato
	 */
	@Query(value = "select * from dmt_t_cls_capo_macellato where id_sessione = :idSessione and codice_premio = :codiceIntervento and capo_id = :capoId ", nativeQuery= true )
	List<Dmt_t_clsCapoMacellato> FindByCapoId(@Param("idSessione") Long idSessione, @Param("capoId") Long capoId, @Param("codiceIntervento") String codiceIntervento);

	
	/**
	 * query che ritorna una lista di istanze di tipo Dmt_t_clsCapoMacellato in base allìidSessione e il cuaa
	 * @param idSessione codice di sessione associato all'esecuzione
	 * @param cuaa codice fiscale del richiedente
	 * @return lista di istanze di tipo Dmt_t_clsCapoMacellato
	 */
	@Query(
			value = "SELECT * FROM DMT_T_CLS_CAPO_MACELLATO where id_sessione = :idSessione and CUAA = :cuaa ",
			nativeQuery = true
		)
	List<Dmt_t_clsCapoMacellato> findBySessioneAndCuaa(@Param("idSessione")Long idSessione, @Param("cuaa") String cuaa);

	
	@Query(value = "SELECT * FROM DMT_T_CLS_CAPO_MACELLATO WHERE CAPO_ID IN (SELECT ID_CAPO FROM DMT_T_PREMIO_CAPI WHERE DMT_T_PREMIO_CAPI.ID_SESSIONE = :idSessione AND CUAA = :cuaa AND CODICE_PREMIO = :codiceIntervento) "
			+ " AND id_SESSIONE = :idSessione AND CUAA = :cuaa AND CODICE_PREMIO = :codiceIntervento ", nativeQuery = true )
	List<Dmt_t_clsCapoMacellato> getMacellatiUbaMinime(@Param("idSessione") Long idSessione, @Param("cuaa") String cuaa, @Param("codiceIntervento") String codiceIntervento);

	@Query(value = "SELECT * FROM DMT_T_CLS_CAPO_MACELLATO WHERE CUAA= :cuaa AND CODICE_PREMIO = :codiceIntervento AND CAPO_ID= :capoId AND ID_SESSIONE = :idSessione", nativeQuery= true)
	Dmt_t_clsCapoMacellato FindCapoMacellato(@Param("cuaa") String cuaa, @Param("codiceIntervento")String codiceIntervento, @Param("capoId")Long capoId, @Param("idSessione")Long IdSessione);
}
