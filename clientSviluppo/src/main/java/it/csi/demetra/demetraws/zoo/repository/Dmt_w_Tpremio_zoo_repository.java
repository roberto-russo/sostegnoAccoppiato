package it.csi.demetra.demetraws.zoo.repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_w_Tpremio_zoo_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_w_Tpremio_zoo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Dmt_w_Tpremio_zoo_repository extends CrudRepository<Dmt_w_Tpremio_zoo, Dmt_w_Tpremio_zoo_id> {

}
