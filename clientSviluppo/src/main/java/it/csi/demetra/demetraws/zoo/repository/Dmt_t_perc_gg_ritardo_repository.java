package it.csi.demetra.demetraws.zoo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.csi.demetra.demetaws.zoo.compositeIds.Dmt_t_perc_gg_ritardo_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_perc_gg_ritardo;

@Repository
/**
 * interfaccia che estende CrudRepository in cui sono definiti i metodi di persistenza degli oggetti
 * di tipo @see Dmt_t_perc_gg_ritardo e le query ad esso associate.
 * @author Bcsoft
 */
public interface Dmt_t_perc_gg_ritardo_repository extends CrudRepository<Dmt_t_perc_gg_ritardo, Dmt_t_perc_gg_ritardo_id>{

	/**
	 * query che ritorna la lista delle istanze che persistono a DB di tipo Dmt_t_perc_gg_ritardo
	 */
	public List<Dmt_t_perc_gg_ritardo>findAll();
}
