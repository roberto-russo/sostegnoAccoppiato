package it.csi.demetra.demetraws.zoo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;

@Repository
public interface Dmt_t_sessione_repository  extends JpaRepository<Dmt_t_sessione,Long> {

	List<Dmt_t_sessione>findAll();
	
	@Query(value = "select id_sessione from sessione where data_e_ora = :#{#dataEora}", nativeQuery = true)
	Dmt_t_sessione findSessioneByDataEora(@Param("dataEora") Date dataEora);
}
