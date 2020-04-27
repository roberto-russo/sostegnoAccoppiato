package it.csi.demetra.demetraws.zoo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_esclusi;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_output_esclusi_repository;


@Service
public class Dmt_t_output_esclusi_services {

	@Autowired
	Dmt_t_output_esclusi_repository rep;

	public void saveOutputEscl(Dmt_t_output_esclusi output) {
		rep.save(output);
	}
}
