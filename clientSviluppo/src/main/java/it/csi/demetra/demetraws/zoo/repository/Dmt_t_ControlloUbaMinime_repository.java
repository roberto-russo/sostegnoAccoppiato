package it.csi.demetra.demetraws.zoo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_d_Ref9903_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_ControlloUbaMinime;

@Repository
public interface Dmt_t_ControlloUbaMinime_repository extends CrudRepository<Dmt_t_ControlloUbaMinime,Dmt_d_Ref9903_id>{

}
