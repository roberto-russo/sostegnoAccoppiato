package it.csi.demetra.demetraws.zoo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_Tlatte_vendita_diretta_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tlatte_vendita_diretta;

@Repository
public interface Dmt_t_tlatte_vendita_diretta_repository extends CrudRepository<Dmt_t_Tlatte_vendita_diretta, Dmt_t_Tlatte_vendita_diretta_id>{

}
