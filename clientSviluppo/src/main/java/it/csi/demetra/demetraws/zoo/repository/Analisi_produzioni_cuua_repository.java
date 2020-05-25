package it.csi.demetra.demetraws.zoo.repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Analisi_produzioni_cuua_id;
import it.csi.demetra.demetraws.zoo.model.Analisi_produzioni_cuua;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Analisi_produzioni_cuua_repository extends JpaRepository<Analisi_produzioni_cuua, Analisi_produzioni_cuua_id> {

    @Query(value = "SELECT * FROM analisi_produzioni_cuua WHERE CUUA = :CUUA AND to_char(data_analisi,'YYYY') = :mYear", nativeQuery = true)
    List<Analisi_produzioni_cuua> getByCUUAAndYear(@Param("CUUA") String CUUA, @Param("mYear") String mYear);

}
