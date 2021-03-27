package it.csi.demetra.demetraws.zoo.repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_Intervento_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Intervento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Dmt_t_Intervento_repository extends CrudRepository<Dmt_t_Intervento, Dmt_t_Intervento_id> {

}
