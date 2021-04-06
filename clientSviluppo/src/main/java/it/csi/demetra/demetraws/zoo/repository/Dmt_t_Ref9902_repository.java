package it.csi.demetra.demetraws.zoo.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
//
//import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_Ref9902_id;
//import it.csi.demetra.demetraws.zoo.model.Dmt_t_Ref9902;
//
//public interface Dmt_t_Ref9902_repository extends CrudRepository<Dmt_t_Ref9902, Dmt_t_Ref9902_id> {
//
//	
//	@Query(value = "SELECT * FROM DMT_T_REF9902 dtr where id_sessione = :idSessione AND cuaa = :cuaa ", nativeQuery = true)
//	List<Dmt_t_Ref9902> findByIdSessioneAndCuaa(@Param("idSessione") Long idSessione, @Param("cuaa") String cuaa);
//}
