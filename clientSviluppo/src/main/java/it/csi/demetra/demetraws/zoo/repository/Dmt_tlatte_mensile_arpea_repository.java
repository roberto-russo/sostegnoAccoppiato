package it.csi.demetra.demetraws.zoo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_Tlatte_mensile_arpea_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tlatte_mensile_arpea;

@Repository
public interface Dmt_tlatte_mensile_arpea_repository extends CrudRepository<Dmt_t_Tlatte_mensile_arpea, Dmt_t_Tlatte_mensile_arpea_id> {

}
