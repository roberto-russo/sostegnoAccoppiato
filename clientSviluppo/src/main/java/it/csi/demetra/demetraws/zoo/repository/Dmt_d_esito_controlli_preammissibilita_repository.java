package it.csi.demetra.demetraws.zoo.repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_d_esito_controlli_preammissibilita_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_d_esito_controlli_preammissibilita;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Dmt_d_esito_controlli_preammissibilita_repository extends CrudRepository<Dmt_d_esito_controlli_preammissibilita, Dmt_d_esito_controlli_preammissibilita_id> {

}
