package it.csi.demetra.demetraws.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_contr_loco_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_contr_loco;

/**
 * interfaccia che estende CrudRepository in cui sono definiti i metodi di persistenza degli oggetti
 * di tipo Dmt_t_contr_loco e le query ad esso associate.
 * @author Bcsoft
 */
@Repository
public interface Dmt_t_contr_loco_repository extends CrudRepository<Dmt_t_contr_loco, Dmt_t_contr_loco_id>{
	
	/**
	 * query che ritorna la lista delle istanze che persistono a DB di tipo Dmt_t_contr_loco
	 */
	List<Dmt_t_contr_loco>findAll();

	/**
	 * query che ritorna una lista di istanze di tipo Dmt_t_contr_loco in base al cuaa
	 * @param cuaa codice fiscale del detentore
	 * @param annoCampagna anno della campagna
	 * @return lista di istanze di tipo Dmt_t_contr_loco
	 */
	@Query(value = "select * from dmt_t_contr_loco where cuaa = :cuaa and anno = :annoCampagna", nativeQuery = true)
	List<Dmt_t_contr_loco> findByCuaa(@Param("cuaa")String cuaa, @Param("annoCampagna") Integer annoCampagna);
}
