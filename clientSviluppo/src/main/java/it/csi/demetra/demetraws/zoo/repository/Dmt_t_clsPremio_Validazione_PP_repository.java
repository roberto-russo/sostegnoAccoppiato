package it.csi.demetra.demetraws.zoo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_clsPremio_Validazione_PP_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_clsPremio_Validazione_PP;

@Repository
public interface Dmt_t_clsPremio_Validazione_PP_repository extends CrudRepository<Dmt_t_clsPremio_Validazione_PP, Dmt_t_clsPremio_Validazione_PP_id>{

}
