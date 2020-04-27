package it.csi.demetra.demetraws.zoo.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tbdn_du_capi;

@Repository
public interface Dmt_t_Tbdn_du_capi_repository extends CrudRepository<Dmt_t_Tbdn_du_capi, Long>{

	List<Dmt_t_Tbdn_du_capi>findAll();
}