package it.csi.demetra.demetraws.zoo.repository;

import it.csi.demetra.demetraws.zoo.model.Dmt_d_clsPremio_ValidazioneResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Dmt_d_clsPremio_ValidazioneResponse_repository extends CrudRepository<Dmt_d_clsPremio_ValidazioneResponse, Long> {

    List<Dmt_d_clsPremio_ValidazioneResponse> getByIdSessione(Long idSessione);

    @Query(value = "SELECT * FROM DMT_D_CLS_PREMIO_VAL_RESP where id_sessione = :idSessione AND cuaa LIKE(:cuaa)", nativeQuery = true)
    List<Dmt_d_clsPremio_ValidazioneResponse> getByIdSessioneAndCuaa(Long idSessione, String cuaa);
}
