package it.csi.demetra.demetraws.zoo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_d_Triep_du_premi_capi_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_d_Triep_du_premi_capi;

@Repository
public interface Dmt_d_Triep_du_premi_capi_repository extends CrudRepository<Dmt_d_Triep_du_premi_capi, Dmt_d_Triep_du_premi_capi_id>{

}
