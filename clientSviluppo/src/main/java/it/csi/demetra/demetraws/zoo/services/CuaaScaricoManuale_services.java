package it.csi.demetra.demetraws.zoo.services;

import it.csi.demetra.demetraws.zoo.model.CuaaScaricoManuale;
import it.csi.demetra.demetraws.zoo.repository.CuaaScaricoManuale_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CuaaScaricoManuale_services {

    @Autowired
    CuaaScaricoManuale_repository scaricoCuaaRep;

    public List<CuaaScaricoManuale> getAll(Integer annoCampagna) {

        List<CuaaScaricoManuale> list = scaricoCuaaRep.findAll(annoCampagna);
        return list != null ? list : Collections.emptyList();
    }
}
