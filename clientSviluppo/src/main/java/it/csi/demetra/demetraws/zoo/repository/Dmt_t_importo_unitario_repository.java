package it.csi.demetra.demetraws.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_importo_unitario_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_importo_unitario;

@Repository
/**
 * interfaccia che estende CrudRepository in cui sono definiti i metodi di persistenza degli oggetti
 * di tipo @see Dmt_t_importo_unitario e le query ad esso associate.
 * @author Bcsoft
 */
public interface Dmt_t_importo_unitario_repository extends CrudRepository<Dmt_t_importo_unitario, Dmt_t_importo_unitario_id>{

	
	@Query( value = "SELECT * FROM DMT_T_IMPORTO_UNITARIO WHERE ANNO_CAMPAGNA_INIZIO = :annoCampagna ",
			nativeQuery = true
		)
	/**
	 * query che ritorna una lista di istanze di tipo Dmt_t_importo_unitario in base  a annoCampagna
	 * @param annoCampagna anno di campagna per cui viene effettuato lo scarico
	 * @return List<Dmt_t_importo_unitario>
	 */
		List<Dmt_t_importo_unitario> findByAnnoCampagna(@Param("annoCampagna") Integer annoCampagna);
		
		@Query( value = "SELECT * FROM DMT_T_IMPORTO_UNITARIO WHERE ANNO_CAMPAGNA_INIZIO = :annoCampagna AND CODICE = :intervento ",
				nativeQuery = true
			)
		/**
		 * query che ritorna un'istanza di tipo Dmt_t_importo_unitario in base ad annoCampagna e intervento
		 * @param annoCampagna anno di campagna per cui viene effettuato lo scarico
		 * @param intervento codice premio per cui il cuaa effettua la richiesta
		 * @return Dmt_t_importo_unitario
		 */
			Dmt_t_importo_unitario findByAnnoCampagnaAndIntervento(@Param("annoCampagna") Integer annoCampagna, @Param("intervento") String intervento);
		
		@Query( value = "SELECT * FROM DMT_T_IMPORTO_UNITARIO WHERE ANNO_CAMPAGNA_INIZIO = :annoCampagna AND CODICE IN :interventi ",
				nativeQuery = true
			)
		/**
		 * query che ritorna una lista di istanze di tipo Dmt_t_importo_unitario in base ad annoCampagna ed intervento.
		 * <b>attenzione</b> si verifica che il codice intervento inserito appartenga ad una lista di codici intervento.
		 * Se il codice intervento inserito appartiene alla suddetta lista, allora la query ritorna la lista degli importi unitari,
		 * altrimenti ritorna null.
		 * @param annoCampagna anno di campagna per cui viene effettuato lo scarico
		 * @param interventi lista dei codici premio associati alle richieste dei cuaa
		 * @return List<Dmt_t_importo_unitario>
		 */
			List<Dmt_t_importo_unitario> findAllByAnnoCampagnaAndIntervento(@Param("annoCampagna") Integer annoCampagna, @Param("interventi") List<String> interventi);
}
