package it.csi.demetra.demetraws.zoo.services;


import it.csi.demetra.demetraws.zoo.model.*;
import it.csi.demetra.demetraws.zoo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe service che utilizza le Query definite nei repository: <br>
 * DsUBA_censimenti_allevamenti_ovini_repository <br>
 * Dmt_d_clsPremio_ValidazioneResponse_repository <br>
 * Dmt_t_anagrafica_allevamenti_repository <br>
 * Dmt_t_output_controlli_repository <br>
 * Dmt_t_premio_capi_repository <br>
 *
 * @author Bcsoft
 */
@Service
public class SaveOnDbService {


    /**
     * Repository in cui sono definite le Query di tipo DsUBA_censimenti_allevamenti_ovini_repository.
     */
    @Autowired
    DsUBA_censimenti_allevamenti_ovini_repository repUBA;

    /**
     * Repository in cui sono definite le Query di tipo Dmt_d_clsPremio_ValidazioneResponse_repository.
     */
    @Autowired
    Dmt_d_clsPremio_ValidazioneResponse_repository repValidResp;

    /**
     * istanza di tipo Dmt_t_Tws_bdn_du_capi_ovicaprini_services
     */
    @Autowired
    Dmt_t_Tws_bdn_du_capi_ovicaprini_services capreService;

    /**
     * istanza di tipo Dmt_t_clsCapoMacellato_services
     */
    @Autowired
    Dmt_t_clsCapoMacellato_services macellatoService;

    /**
     * istanza di tipo Dmt_t_tws_bdn_du_capi_bovini_services
     */
    @Autowired
    Dmt_t_tws_bdn_du_capi_bovini_services vaccheService;

    /**
     * istanza di tipo Dmt_t_Tbdn_du_capi_services
     */
    @Autowired
    Dmt_t_Tbdn_du_capi_services capiService;

    /**
     * istanza di tipo Dmt_t_errore_services
     */
    @Autowired
    Dmt_t_errore_services erroreService;

    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_anagrafica_allevamenti_repository.
     */
    @Autowired
    Dmt_t_anagrafica_allevamenti_repository anagraficaRep;

    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_output_controlli_repository.
     */
    @Autowired
    Dmt_t_output_controlli_repository outputControlliRep;

    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_premio_capi_repository.
     */
    Dmt_t_premio_capi_repository premioCapiService;


    /**
     * Metodo che effettua il salvataggio a DB di una lista di istanze di tipo Dmt_t_anagrafica_allevamenti.
     * {@link Dmt_t_anagrafica_allevamenti_repository#findByIdSessioneAndAllevIdAndAziendaCodice(Long, java.math.BigDecimal, String)}
     *
     * @param beans lista di istanze da salvare a DB.
     */
    public void saveOnDb(List<Dmt_t_anagrafica_allevamenti> beans) {
        try {
            for (Dmt_t_anagrafica_allevamenti bean : beans) {
                if (anagraficaRep.findByIdSessioneAndAllevIdAndAziendaCodice(bean.getIdSessione().getIdSessione(), bean.getAllevId(), bean.getAziendacodice()).equals(new Integer(0))) {
                    anagraficaRep.save(bean);
                }
            }

        } catch (ConstraintViolationException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metodo che effettua il salvataggio a DB di un'istanza di tipo {@link Dmt_t_DsUBA_censimenti_allevamenti_ovini} in base a sessione.
     *
     * @param bean     bean
     * @param sessione sessione
     *                 {@link Dmt_t_errore_services#saveError(Dmt_t_errore)}
     */
    public void saveOnDb(Dmt_t_DsUBA_censimenti_allevamenti_ovini bean, Dmt_t_sessione sessione) {
        try {
            repUBA.save(bean);
        } catch (ConstraintViolationException e) {
            System.out.println("LA CHIAMATA AL METODO DELLA BDN E' NULL");
            Dmt_t_errore errore = new Dmt_t_errore();
            String input = new String("-1, dati non disponibili");
            errore.setNomeMetodo("GetConsistenzaUbaCensimOVini2012");
            errore.setInput(input);
            System.out.println("ID SESSIONE ERRORE: " + sessione.getIdSessione());
            errore.setIdSessione(sessione);
            erroreService.saveError(errore);
        }
    }

    /**
     * Metodo che effettua il salvataggio a DB di un'istanza di tipo Dmt_d_clsPremio_ValidazioneResponse.
     *
     * @param bean bean
     *             {@link Dmt_t_clsCapoMacellato_services#saveCapo(List)}
     *             {@link Dmt_t_tws_bdn_du_capi_bovini_services#saveCapo(List)}
     *             {@link Dmt_t_Tws_bdn_du_capi_ovicaprini_services#saveCapo(List)}
     */
    public void saveOnDb(Dmt_d_clsPremio_ValidazioneResponse bean) {
        try {
            if (bean.getClsCapoOvicaprino() != null)
                capreService.saveCapo(bean.getClsCapoOvicaprino());

            if (bean.getClsCapoVacca() != null)
                vaccheService.saveCapo(bean.getClsCapoVacca());

            if (bean.getClsCapoMacellato() != null)
                macellatoService.saveCapo(bean.getClsCapoMacellato());

            if (bean.getClsCapo() != null)
                capiService.saveCapo(bean.getClsCapo());

            repValidResp.save(bean);
        } catch (IllegalStateException e) {
            System.out.println("DUPLICAZIONE CAMPO");
        }
    }

    public void duplicaSessioneByCuaa(Rpu_V_pratica_zoote azienda, Dmt_t_sessione sessioneOld, Dmt_t_sessione sessioneNew) {
        List<Dmt_t_Tws_bdn_du_capi_ovicaprini> listCapre = capreService.getCapiOviByIdSessioneCuaaCodInt(sessioneOld.getIdSessione(), azienda.getCuaa(), azienda.getCodicePremio());
        List<Dmt_t_Tws_bdn_du_capi_bovini> listVacche = vaccheService.getByIDSessionCuaaCodInt(sessioneOld.getIdSessione(), azienda.getCuaa(), azienda.getCodicePremio());
        List<Dmt_t_clsCapoMacellato> listMacellato = macellatoService.getCapiMacellatiByIDSessionCuaaCodInt(sessioneOld.getIdSessione(), azienda.getCuaa(), azienda.getCodicePremio());

        List<Dmt_t_Tws_bdn_du_capi_ovicaprini> listCapreNew = new ArrayList<>();
        List<Dmt_t_Tws_bdn_du_capi_bovini> listBoviniNew = new ArrayList<>();
        List<Dmt_t_clsCapoMacellato> listMacellatoNew = new ArrayList<>();

        for (Dmt_t_Tws_bdn_du_capi_ovicaprini d : listCapre) {
            Dmt_t_Tws_bdn_du_capi_ovicaprini newObj = new Dmt_t_Tws_bdn_du_capi_ovicaprini(d);
            newObj.setIdSessione(sessioneNew);
            listCapreNew.add(newObj);
        }

        for (Dmt_t_Tws_bdn_du_capi_bovini d : listVacche) {
            Dmt_t_Tws_bdn_du_capi_bovini newObj = new Dmt_t_Tws_bdn_du_capi_bovini(d);
            newObj.setIdSessione(sessioneNew);
            listBoviniNew.add(newObj);
        }

        for (Dmt_t_clsCapoMacellato d : listMacellato) {
            Dmt_t_clsCapoMacellato newObj = new Dmt_t_clsCapoMacellato(d);
            newObj.setIdSessione(sessioneNew);
            listMacellatoNew.add(newObj);
        }

        capreService.saveCapo(listCapreNew);
        vaccheService.saveCapo(listBoviniNew);
        macellatoService.saveCapo(listMacellatoNew);
    }
}
