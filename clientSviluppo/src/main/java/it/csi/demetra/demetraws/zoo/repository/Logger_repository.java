package it.csi.demetra.demetraws.zoo.repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_d_logger_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_d_logger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Logger_repository extends CrudRepository<Dmt_d_logger, Dmt_d_logger_id> {

}
