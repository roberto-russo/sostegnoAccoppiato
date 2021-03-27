package it.csi.demetra.demetraws.zoo.services;

import it.csi.demetra.demetraws.zoo.repository.Dmt_t_beneficiario_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Dmt_t_beneficiario_services {

    @Autowired
    Dmt_t_beneficiario_repository rep;
}
