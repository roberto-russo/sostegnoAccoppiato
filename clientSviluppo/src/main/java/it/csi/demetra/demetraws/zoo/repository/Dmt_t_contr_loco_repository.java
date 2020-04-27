package it.csi.demetra.demetraws.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_contr_loco_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_contr_loco;

@Repository
public interface Dmt_t_contr_loco_repository extends CrudRepository<Dmt_t_contr_loco, Dmt_t_contr_loco_id>{
	
	List<Dmt_t_contr_loco>findAll();

	@Query(value = "select * from dmt_t_contr_loco where cuaa = :cuaa", nativeQuery = true)
	List<Dmt_t_contr_loco> findByCuaa(@Param("cuaa")String cuaa);

}
