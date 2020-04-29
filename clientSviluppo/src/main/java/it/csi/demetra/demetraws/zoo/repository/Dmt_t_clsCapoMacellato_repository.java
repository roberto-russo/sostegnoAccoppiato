package it.csi.demetra.demetraws.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_clsCapoMacellato;

@Repository
public interface Dmt_t_clsCapoMacellato_repository extends CrudRepository<Dmt_t_clsCapoMacellato, Long>{

	List<Dmt_t_clsCapoMacellato>findAll();
	
	@Query(value = "SELECT * FROM DMT_T_CLS_CAPO_MACELLATO WHERE ID_SESSIONE = :idSessione ", nativeQuery = true)
	List<Dmt_t_clsCapoMacellato>findByIdSession(@Param("idSessione") Long idSessione);
	
	@Query(value = "SELECT * FROM DMT_T_CLS_CAPO_MACELLATO WHERE ID_SESSIONE = :idSessione AND CUAA = :cuaa and CODICE_PREMIO = :codiceIntervento", nativeQuery = true)
	List<Dmt_t_clsCapoMacellato>findByIdSessionAndCuaa(@Param("idSessione") Long idSessione, @Param("cuaa") String cuaa, @Param("codiceIntervento") String codiceIntervento);
	
	@Query(value = "SELECT * FROM DMT_T_CLS_CAPO_MACELLATO "
				 + "WHERE ID_SESSIONE = :idSessione AND CUAA = :cuaa "
				 + "AND months_between(SYSDATE,TO_DATE(:dataNascita,'dd/mm/yy'))>20 "
				 + "AND months_between(SYSDATE,TO_DATE(:dataNascita,'dd/mm/yy'))/12 <= 18", 
		   nativeQuery = true)
	List<Dmt_t_clsCapoMacellato>findByIdSessionAndCuaa9903(@Param("idSessione") Long idSessione, @Param("cuaa") String cuaa);
	
	@Query(value = "select * from DMT_T_cls_capo_Macellato where id_sessione = :idSessione and capo_id = ( select capo_id from DMT_T_cls_capo_Macellato "
			+ "where id_sessione = :idSessione and capo_id = :capoId and CODICE_PREMIO = :codiceIntervento "
			+ "group by capo_id having count (capo_id)>1)", nativeQuery= true )
	List<Dmt_t_clsCapoMacellato> FindByCapoId(@Param("idSessione") Long idSessione, @Param("capoId") Long capoId, @Param("codiceIntervento") String codiceIntervento);


}
