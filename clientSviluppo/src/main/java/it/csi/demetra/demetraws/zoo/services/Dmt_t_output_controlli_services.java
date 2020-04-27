package it.csi.demetra.demetraws.zoo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_output_controlli_repository;

@Service
public class Dmt_t_output_controlli_services {

	@Autowired
	Dmt_t_output_controlli_repository rep;

	public void saveOutput(Dmt_t_output_controlli output) {
		rep.save(output);
	}
}
