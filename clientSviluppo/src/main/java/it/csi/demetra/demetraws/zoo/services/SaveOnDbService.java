package it.csi.demetra.demetraws.zoo.services;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_d_clsPremio_ValidazioneResponse;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_DsUBA_censimenti_allevamenti_ovini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_anagrafica_allevamenti;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_errore;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;
import it.csi.demetra.demetraws.zoo.repository.Dmt_d_clsPremio_ValidazioneResponse_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_anagrafica_allevamenti_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_output_controlli_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_premio_capi_repository;
import it.csi.demetra.demetraws.zoo.repository.DsUBA_censimenti_allevamenti_ovini_repository;

@Service
/**
 * Classe service che utilizza le Query definite nei repository: <br>
 *  DsUBA_censimenti_allevamenti_ovini_repository <br>
 *  Dmt_d_clsPremio_ValidazioneResponse_repository <br>
 *  Dmt_t_anagrafica_allevamenti_repository <br>
 *  Dmt_t_output_controlli_repository <br>
 *  Dmt_t_premio_capi_repository <br>
 * @author Bcsoft
 */
public class SaveOnDbService {
	
    @Autowired
    /**
     * Repository in cui sono definite le Query di tipo DsUBA_censimenti_allevamenti_ovini_repository.
     */
    DsUBA_censimenti_allevamenti_ovini_repository repUBA;

    @Autowired
    /**
     * Repository in cui sono definite le Query di tipo Dmt_d_clsPremio_ValidazioneResponse_repository.
     */
    Dmt_d_clsPremio_ValidazioneResponse_repository repValidResp;

    @Autowired
    /**
     * istanza di tipo Dmt_t_Tws_bdn_du_capi_ovicaprini_services
     */
    Dmt_t_Tws_bdn_du_capi_ovicaprini_services capreService;

    @Autowired
    /**
     * istanza di tipo Dmt_t_clsCapoMacellato_services
     */
    Dmt_t_clsCapoMacellato_services MacellatoService;

    @Autowired
    /**
     * istanza di tipo Dmt_t_tws_bdn_du_capi_bovini_services
     */
    Dmt_t_tws_bdn_du_capi_bovini_services vaccheService;

    @Autowired
    /**
     * istanza di tipo Dmt_t_Tbdn_du_capi_services
     */
    Dmt_t_Tbdn_du_capi_services capiService;

    @Autowired
    /**
     * istanza di tipo Dmt_t_errore_services
     */
    Dmt_t_errore_services erroreService;
    
    @Autowired
    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_anagrafica_allevamenti_repository.
     */
    Dmt_t_anagrafica_allevamenti_repository anagraficaRep;
    
    @Autowired
    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_output_controlli_repository.
     */
    Dmt_t_output_controlli_repository outputControlliRep;
    
    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_premio_capi_repository.
     */
    Dmt_t_premio_capi_repository premioCapiService;
    
    
    
    /**
     * Metodo che effettua il salvataggio a DB di una lista di istanze di tipo Dmt_t_anagrafica_allevamenti.
     * {@link Dmt_t_anagrafica_allevamenti_repository#findByIdSessioneAndAllevIdAndAziendaCodice(Long, java.math.BigDecimal, String)}
     * {@link Dmt_t_anagrafica_allevamenti_repository#save(Dmt_t_anagrafica_allevamenti)}
     * @param lista di istanze da salvare a DB.
     */
    public void saveOnDb(List<Dmt_t_anagrafica_allevamenti> beans) {
    	try {
    		for(Dmt_t_anagrafica_allevamenti bean : beans) {
    			if(anagraficaRep.findByIdSessioneAndAllevIdAndAziendaCodice(bean.getIdSessione().getIdSessione(), bean.getAllevId(), bean.getAziendacodice()).equals(new Integer(0))) {
    			anagraficaRep.save(bean);
    			}
    		}
    		
    	} catch(ConstraintViolationException e) {
    		System.out.println(e.getMessage());
    	}
    }

    /**
     * Metodo che effettua il salvataggio a DB di un'istanza di tipo {@link Dmt_t_DsUBA_censimenti_allevamenti_ovini} in base a sessione.
     * {@link DsUBA_censimenti_allevamenti_ovini_repository#save(Dmt_t_DsUBA_censimenti_allevamenti_ovini)}
     * {@link Dmt_t_errore_services#saveError(Dmt_t_errore)}
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
     * {@link Dmt_t_clsCapoMacellato_services#saveCapo(List)}
     * {@link Dmt_t_tws_bdn_du_capi_bovini_services#saveCapo(List)}
     * {@link Dmt_t_Tws_bdn_du_capi_ovicaprini_services#saveCapo(List)}
     * {@link Dmt_d_clsPremio_ValidazioneResponse_repository#save(Dmt_d_clsPremio_ValidazioneResponse)}
     */
    public void saveOnDb(Dmt_d_clsPremio_ValidazioneResponse bean) {

        try {
            if (bean.getClsCapoOvicaprino() != null)
                capreService.saveCapo(bean.getClsCapoOvicaprino());

            if (bean.getClsCapoVacca() != null)
                vaccheService.saveCapo(bean.getClsCapoVacca());

            if (bean.getClsCapoMacellato() != null)
                MacellatoService.saveCapo(bean.getClsCapoMacellato());

            if (bean.getClsCapo() != null)
                capiService.saveCapo(bean.getClsCapo());
            
            repValidResp.save(bean);
        } catch (IllegalStateException e) {
            System.out.println("DUPLICAZIONE CAMPO");
        } 
    }
}