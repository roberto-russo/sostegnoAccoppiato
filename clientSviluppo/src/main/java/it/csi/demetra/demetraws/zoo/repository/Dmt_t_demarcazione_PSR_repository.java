package it.csi.demetra.demetraws.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_demarcazione_PSR_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_demarcazione_PSR;

@Repository
public interface Dmt_t_demarcazione_PSR_repository extends CrudRepository<Dmt_t_demarcazione_PSR, Dmt_t_demarcazione_PSR_id>{

	
	public List<Dmt_t_demarcazione_PSR> findAll();
	
	@Query(value = "SELECT * FROM dmt_t_demarcazione_psr WHERE anno = :anno AND marchio_auricolare = :marchioAuricolare ",
			nativeQuery = true)
	public Dmt_t_demarcazione_PSR findByAnnoAndMarchioAuricolare(@Param("anno") Integer anno, @Param("marchioAuricolare") String marchioAuricolare);
}
