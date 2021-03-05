package it.csi.demetra.demetraws.zoo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_coefficienti_uba_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_coefficienti_uba;

@Repository
public interface Dmt_t_coefficienti_uba_repository extends CrudRepository<Dmt_t_coefficienti_uba, Dmt_t_coefficienti_uba_id>{

}
