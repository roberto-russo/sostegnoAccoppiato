package it.csi.demetra.demetraws.zoo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_anagrafica_allevamenti;

@Repository
public interface Dmt_t_anagrafica_allevamenti_repository extends CrudRepository<Dmt_t_anagrafica_allevamenti, Long>{
	
	List<Dmt_t_anagrafica_allevamenti>findAll();
	
	@Query(value = "SELECT * FROM Dmt_t_anagrafica_allev WHERE allev_id = :allevId", nativeQuery = true)
	Dmt_t_anagrafica_allevamenti findByAllevId(@Param("allevId")BigDecimal allevId);

}
