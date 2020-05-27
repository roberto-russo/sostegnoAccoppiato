package it.csi.demetra.demetraws.zoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_importo_unitario_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_importo_unitario;

@Repository
public interface Dmt_t_importo_unitario_repository extends CrudRepository<Dmt_t_importo_unitario, Dmt_t_importo_unitario_id>{

	
	@Query( value = "SELECT * FROM DMT_T_IMPORTO_UNITARIO WHERE ANNO_CAMPAGNA = :annoCampagna ",
			nativeQuery = true
		)
		List<Dmt_t_importo_unitario> findByAnnoCampagna(@Param("annoCampagna") Integer annoCampagna);
		
		@Query( value = "SELECT * FROM DMT_T_IMPORTO_UNITARIO WHERE ANNO_CAMPAGNA = :annoCampagna AND intervento = :intervento ",
				nativeQuery = true
			)
			Dmt_t_importo_unitario findByAnnoCampagnaAndIntervento(@Param("annoCampagna") Integer annoCampagna, @Param("intervento") String intervento);
		
		@Query( value = "SELECT * FROM DMT_T_IMPORTO_UNITARIO WHERE ANNO_CAMPAGNA = :annoCampagna AND intervento IN :interventi ",
				nativeQuery = true
			)
			List<Dmt_t_importo_unitario> findAllByAnnoCampagnaAndIntervento(@Param("annoCampagna") Integer annoCampagna, @Param("interventi") List<String> interventi);
}
