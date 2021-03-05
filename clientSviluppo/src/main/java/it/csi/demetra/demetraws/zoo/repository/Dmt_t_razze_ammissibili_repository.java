package it.csi.demetra.demetraws.zoo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_razze_ammissibili;

@Repository
public interface Dmt_t_razze_ammissibili_repository extends  CrudRepository<Dmt_t_razze_ammissibili, String>{
	
	List<Dmt_t_razze_ammissibili>findAll();

}
