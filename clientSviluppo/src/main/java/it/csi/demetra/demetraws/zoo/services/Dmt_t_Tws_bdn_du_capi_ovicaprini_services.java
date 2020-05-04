package it.csi.demetra.demetraws.zoo.services;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_ovicaprini;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_Tws_bdn_du_capi_ovicaprini_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Dmt_t_Tws_bdn_du_capi_ovicaprini_services {

    @Autowired
    Dmt_t_Tws_bdn_du_capi_ovicaprini_repository rep;

    public List<Dmt_t_Tws_bdn_du_capi_ovicaprini> getCapo() {
        return rep.findAll();
    }

    public void saveCapo(List<Dmt_t_Tws_bdn_du_capi_ovicaprini> capo) {
        rep.saveAll(capo);
    }

    public void print() {
        System.out.println("OGGI R? UNA BELLA GIORNATA");
    }

    public List<Dmt_t_Tws_bdn_du_capi_ovicaprini> getCapiOviByIdSessioneCuaaCodInt(Long idSessione, String cuaa, String codIntervento) {
        return rep.findByIdSessionAndCuaa(idSessione, cuaa, codIntervento);
    }
}
