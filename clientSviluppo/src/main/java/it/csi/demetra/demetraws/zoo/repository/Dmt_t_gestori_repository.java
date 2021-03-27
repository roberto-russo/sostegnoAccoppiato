package it.csi.demetra.demetraws.zoo.repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_gestori_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_gestori;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Dmt_t_gestori_repository extends CrudRepository<Dmt_t_gestori, Dmt_t_gestori_id> {

}
