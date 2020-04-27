package it.csi.demetra.demetraws.zoo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_dsScarico_allevamenti;

@Repository
public interface Dmt_t_dsScarico_allevamenti_repository extends CrudRepository<Dmt_t_dsScarico_allevamenti, BigDecimal>{
	
	List<Dmt_t_dsScarico_allevamenti>findAll();
	
	@Query(value = "SELECT * FROM dmt_t_dsScarico_allevamenti WHERE allev_id = :allevId", nativeQuery = true)
	Dmt_t_dsScarico_allevamenti findByAllevId(@Param("allevId")long allevId);

}
