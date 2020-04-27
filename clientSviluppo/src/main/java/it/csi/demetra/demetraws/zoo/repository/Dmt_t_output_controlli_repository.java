package it.csi.demetra.demetraws.zoo.repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_output_controlli_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Dmt_t_output_controlli_repository extends CrudRepository<Dmt_t_output_controlli, Dmt_t_output_controlli_id> {

}
