package it.csi.demetra.demetraws.zoo.repository;

import it.csi.demetra.demetraws.zoo.compositeIds.CuaaScaricoManuale_id;
import it.csi.demetra.demetraws.zoo.model.CuaaScaricoManuale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuaaScaricoManuale_repository extends CrudRepository<CuaaScaricoManuale, CuaaScaricoManuale_id> {


    @Query(
            value = " SELECT * FROM DMT_T_CUAA_SCARICO_MANUALE WHERE ANNO_CAMPAGNA = :annoCampagna AND CUAA='BAITMS61A14F335Z'",
            nativeQuery = true
    )
    List<CuaaScaricoManuale> findAll(@Param("annoCampagna") Integer annoCampagna);
}
