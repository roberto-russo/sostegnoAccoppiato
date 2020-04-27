package it.csi.demetra.demetraws.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_certificato_igp_dop;

@Repository
public interface Dmt_t_certificato_igp_dop_repository extends CrudRepository<Dmt_t_certificato_igp_dop, String>{

	List<Dmt_t_certificato_igp_dop>findAll();
	
@Query(value = "select * from Dmt_t_certif_igp_dop where cuaa = :cuaa", nativeQuery = true)
	Dmt_t_certificato_igp_dop findByCuaa(@Param("cuaa") String cuaa);
}
