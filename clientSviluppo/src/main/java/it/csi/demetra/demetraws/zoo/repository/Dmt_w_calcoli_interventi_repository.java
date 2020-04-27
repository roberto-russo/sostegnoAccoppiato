package it.csi.demetra.demetraws.zoo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_w_calcoli_interventi_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_w_calcoli_interventi;

@Repository
public interface Dmt_w_calcoli_interventi_repository extends CrudRepository<Dmt_w_calcoli_interventi, Dmt_w_calcoli_interventi_id>{

}
