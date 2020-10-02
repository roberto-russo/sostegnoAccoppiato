package it.csi.demetra.demetraws.zoo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.repository.Dmt_t_beneficiario_repository;

@Service
public class Dmt_t_beneficiario_services {

	@Autowired
	Dmt_t_beneficiario_repository rep;
}
