package it.csi.demetra.demetraws.zoo.repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Analisi_produzioni_cuua_id;
import it.csi.demetra.demetraws.zoo.model.Analisi_produzioni_cuua;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Analisi_produzioni_cuua_repository extends JpaRepository<Analisi_produzioni_cuua_id, Analisi_produzioni_cuua> {
    List<Analisi_produzioni_cuua> getByCUUAAndYear(String CUUA,Integer year);

}
