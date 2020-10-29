package it.csi.demetra.demetraws.zoo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.csi.demetra.demetraws.zoo.compositeIds.Dmt_t_info_allevamento_beneficiario_id;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_info_allevamento_beneficiario;

@Repository
public interface Dmt_t_info_allevamento_beneficiario_repository extends CrudRepository<Dmt_t_info_allevamento_beneficiario, Dmt_t_info_allevamento_beneficiario_id>{

	
}
