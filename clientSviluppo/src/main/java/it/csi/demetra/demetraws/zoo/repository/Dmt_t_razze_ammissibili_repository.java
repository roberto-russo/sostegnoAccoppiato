package it.csi.demetra.demetraws.zoo.repository;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_razze_ammissibili;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Dmt_t_razze_ammissibili_repository extends CrudRepository<Dmt_t_razze_ammissibili, String> {

    List<Dmt_t_razze_ammissibili> findAll();

}
