package it.csi.demetra.demetraws.zoo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_Intervento_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Intervento;

@Repository
public interface Dmt_t_Intervento_repository extends CrudRepository<Dmt_t_Intervento, Dmt_t_Intervento_id>{

}
