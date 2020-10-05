package it.csi.demetra.demetraws.zoo.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_T_analisi_produzioni_cuua;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_SistemiDiEtichettaturaFacoltativa;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_bovini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_ovicaprini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_anagrafica_allevamenti;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_certificato_igp_dop;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_clsCapoMacellato;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_contr_loco;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_demarcazione_PSR;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_importo_unitario;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_irregolarita_intenzionale;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_esclusi;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_ref03;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;
import it.csi.demetra.demetraws.zoo.model.Dmt_w_controllo_bean;
import it.csi.demetra.demetraws.zoo.model.Rpu_V_pratica_zoote;
import it.csi.demetra.demetraws.zoo.repository.Analisi_produzioni_cuua_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_AgnelleRimonta_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_SistemiDiEtichettaturaFacoltativa_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_Tws_bdn_du_capi_ovicaprini_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_anagrafica_allevamenti_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_beneficiario_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_certificato_igp_dop_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_clsCapoMacellato_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_contr_loco_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_demarcazione_PSR_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_importo_unitario_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_irregolarita_intenzionale_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_output_controlli_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_output_esclusi_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_output_ref03_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_perc_gg_ritardo_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_premio_capi_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_tws_bdn_du_capi_bovini_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_w_controllo_bean_repository;
import it.csi.demetra.demetraws.zoo.repository.Rpu_V_pratica_zoote_repository;

/**
 * Classe service che utilizza le Query definite nei seguenti repository: <br>
 *  Dmt_t_tws_bdn_du_capi_bovin_respository <br>
 *  Dmt_t_anagrafica_allevamenti_repository <br>
 *  Dmt_w_controllo_bean_repository <br>
 *  Dmt_t_output_controlli_repository <br>
 *  Dmt_t_output_esclusi_repository <br>
 *  Dmt_t_contr_loco_repository <br>
 *  Dmt_t_clsCapoMacellato_repository <br>
 *  Dmt_t_SistemiDiEtichettaturaFacoltativa_repository <br>
 *  Dmt_t_certificato_igp_dop_repository <br>
 *  Dmt_t_anagrafica_allevamenti_repository <br>
 *  Rpu_V_pratica_zoote_repository <br>
 *  Dmt_t_Tws_bdn_du_capi_ovicaprini_repository <br>
 *  Dmt_t_importo_unitario_repository <br>
 *  Dmt_t_output_ref03_repository <br>
 *  Dmt_t_perc_gg_ritardo_repository <br>
 * @author Bcsoft
 */
@Service
public class ControlliService {

	/**
	 * Repository in cui sono definite le Query di tipo Dmt_t_tws_bdn_du_capi_bovini.
	 */
    @Autowired
    Dmt_t_tws_bdn_du_capi_bovini_repository boviniRepository;

    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_anagrafica_allevamenti.
     */
    @Autowired
    Dmt_t_anagrafica_allevamenti_repository anaRepository;

    /**
     * Repository in cui sono definite le Query di tipo Dmt_w_controllo_bean.
     */
    @Autowired
    Dmt_w_controllo_bean_repository controlloBeanRepository;

    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_output_controlli.
     */
    @Autowired
    Dmt_t_output_controlli_repository outputRepository;

    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_output_esclusi.
     */
    @Autowired
    Dmt_t_output_esclusi_repository esclusiRepository;

    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_contr_loco.
     */
    @Autowired
    Dmt_t_contr_loco_repository contrLocoRepository;

    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_clsCapoMacellato.
     */
    @Autowired
    Dmt_t_clsCapoMacellato_repository macellatiRepository;

    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_SistemiDiEtichettaturaFacoltativa.
     */
    @Autowired
    Dmt_t_SistemiDiEtichettaturaFacoltativa_repository etichettaturaRepository;

    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_certificato_igp_dop.
     */
    @Autowired
    Dmt_t_certificato_igp_dop_repository igpDopRepository;

    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_anagrafica_allevamenti.
     */
    @Autowired
    Dmt_t_anagrafica_allevamenti_repository anagraficaAllevamentiRep;

    /**
     * Repository in cui sono definite le Query di tipo Rpu_V_pratica_zoote.
     */
    @Autowired
    Rpu_V_pratica_zoote_repository rpuVPraticaRep;

    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_Tws_bdn_du_capi_ovicaprini.
     */
    @Autowired
    Dmt_t_Tws_bdn_du_capi_ovicaprini_repository ovicapriniRep;

    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_importo_unitario.
     */
    @Autowired
    Dmt_t_importo_unitario_repository importoUnitRep;

    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_output_ref03.
     */
    @Autowired
    Dmt_t_output_ref03_repository ref03Rep;
    
    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_perc_gg_ritardo.
     */
    @Autowired
    Dmt_t_perc_gg_ritardo_repository ggRitardoRep;
    
    @Autowired
    Dmt_t_irregolarita_intenzionale_repository irregolaritaRep;
    
    @Autowired
    Dmt_t_AgnelleRimonta_repository agnelleRep;
    
    @Autowired
    Dmt_t_premio_capi_repository premioCapiRep;
    
    @Autowired
    Dmt_t_demarcazione_PSR_repository PSRrep;
    
    @Autowired
    Analisi_produzioni_cuua_repository AnalisiProduzioniRep;
    
    @Autowired
	Dmt_t_beneficiario_repository BeneficiarioCapiDoppiRep;

    /**
     * Metodo che ritorna una lista di istanze di tipo {@link Dmt_t_Tws_bdn_du_capi_bovini} in base alla sessione, cuaa e codiceIntervento
     * {@link Dmt_t_tws_bdn_du_capi_bovini_repository#findByIdSessionAndCuaa(Long, String, String)}
     * @param sessione identificativo univoco associato all'esecuzione.
     * @param cuua codice fiscale del richiedente
     * @param codiceIntervento codice intervento
     * @return lista di istanze di tipo {@link Dmt_t_Tws_bdn_du_capi_bovini}
     */
    public List<Dmt_t_Tws_bdn_du_capi_bovini> getAllBoviniSessioneCuua(Dmt_t_sessione sessione, String cuua,
                                                                       String codiceIntervento) {
        return boviniRepository.findByIdSessionAndCuaa(sessione.getIdSessione(), cuua, codiceIntervento);
    }

    /**
     * Metodo che ritorna una lista di istanze di tipo  {@link Dmt_t_Tws_bdn_du_capi_bovini} in base ad idSessione, idCapo e codiceIntervento.
     * {@link Dmt_t_tws_bdn_du_capi_bovini_repository#findByIdSessioneAndIdCapo(Long, Long, String)}
     * @param idSessione identificativo univoco associato all'esecuzione
     * @param idCapo identificativo univoco associato al capo animale
     * @param codiceIntervento codice intervento
     * @return istanza di tipo {@link Dmt_t_Tws_bdn_du_capi_bovini}
     */
    public List<Dmt_t_Tws_bdn_du_capi_bovini> getVitelliNatiDaBovini(Long idSessione, Long idCapo,
                                                                     String codiceIntervento) {
        return boviniRepository.findByIdSessioneAndIdCapo(idSessione, idCapo, codiceIntervento);
    }

    /**
     * Metodo che ritorna un container Optional di istanze di tipo Dmt_w_controllo_bean in base al codicePremio.
     * {@link Dmt_w_controllo_bean_repository#findByCodicePremio(String)}
     * @param codicePremio codcie intervento
     * @return collection Optional di tipo {@link Dmt_w_controllo_bean}
     */
    public Optional<Dmt_w_controllo_bean> findByIdControlloBean(String codicePremio) {
        return controlloBeanRepository.findByCodicePremio(codicePremio);
    }

    /**
     * Metodo che effettua la persistenza di un oggetto di tipo Dmt_t_output_controlli.
     * @param output istanza di tipo {@link Dmt_t_output_controlli} da salvare a DB
     */
    public void saveOutput(Dmt_t_output_controlli output) {
        outputRepository.save(output);
    }

    /**
     * Metodo che ritorna una lista di istanze di tipo @see Dmt_t_clsCapoMacellato in base al capoId, idSessione e codiceIntervento.
     * {@link Dmt_t_clsCapoMacellato_repository#FindByCapoId(Long, Long, String)}
     * @param capoId identificativo univoco associato al capo animale
     * @param idSessione identificativo univoco associato all'esecuzione
     * @param codiceIntervento codice intervento
     * @return Dmt_t_clsCapoMacellato Lista di capi di tipo {@link Dmt_t_clsCapoMacellato}
     */
    public List<Dmt_t_clsCapoMacellato> getDuplicati(Long capoId, Long idSessione, String codiceIntervento) {
        return macellatiRepository.FindByCapoId(idSessione, capoId, codiceIntervento);
    }

    /**
     * Metodo che ritorna una lista di istanze di tipo {@link Dmt_t_clsCapoMacellato} in base a sessione, cuaa e codiceIntervento.
     * {@link Dmt_t_clsCapoMacellato_repository#findByIdSessionAndCuaa(Long, String, String)}
     * @param sessione identificativo univoco associato all'esecuzione
     * @param cuaa codice fiscale del richiedente
     * @param codiceIntervento codice intervento
     * @return lista di istanze di tipo {@link Dmt_t_clsCapoMacellato}
     */
    public List<Dmt_t_clsCapoMacellato> getAllMacellatiSessioneCuua(Dmt_t_sessione sessione, String cuaa,
                                                                    String codiceIntervento) {
        return macellatiRepository.findByIdSessionAndCuaa(sessione.getIdSessione(), cuaa, codiceIntervento);
    }

    /**
     * Metodo che ritorna una lista di istanze di tipo {@link Dmt_t_contr_loco} in base al cuaa.
     * {@link Dmt_t_contr_loco_repository#findByCuaa(String, Integer)}
     * @param cuaa codice fiscale del richiedente
     * @param annoCampagna anno della campagna
     * @return Dmt_t_contr_loco Lista di tipo {@link Dmt_t_contr_loco}
     */
    public List<Dmt_t_contr_loco> getEsrtazioneACampioneByCuaa(String cuaa, Integer annoCampagna) {

        return contrLocoRepository.findByCuaa(cuaa, annoCampagna);
    }

    /**
     * Metodo che ritorna un'istanza di tipo Dmt_t_SistemiDiEtichettaturaFacoltativa in base al cuaa
     * {@link Dmt_t_SistemiDiEtichettaturaFacoltativa_repository#findByCuaa(String)}
     * @param cuaa codice fiscale del richiedente
     * @return Dmt_t_SistemiDiEtichettaturaFacoltativa
     */
    public Dmt_t_SistemiDiEtichettaturaFacoltativa getSistemaEtichettarua(String cuaa) {

        return this.etichettaturaRepository.findByCuaa(cuaa) == null ? new Dmt_t_SistemiDiEtichettaturaFacoltativa() : this.etichettaturaRepository.findByCuaa(cuaa);
    }

    /**
     * Metodo che ritorna un'istanza di tipo {@link Dmt_t_certificato_igp_dop} in base al cuaa.
     *  {@link Dmt_t_certificato_igp_dop_repository#findByCuaa(String)}
     * @param cuaa codice fiscale del richiedente
     * @return istanza di tipo {@link Dmt_t_certificato_igp_dop}
     */
    public Dmt_t_certificato_igp_dop getCertificatoIgpDop(String cuaa) {
        return this.igpDopRepository.findByCuaa(cuaa) == null ? new Dmt_t_certificato_igp_dop() : this.igpDopRepository.findByCuaa(cuaa);
    }

    /**
     * Metodo che effettua la persistenza a DB di un oggetto di tipo Dmt_t_output_esclusi.
     * @param output oggetto di tipo {@link Dmt_t_output_esclusi}
     */
    public void saveOutputEscl(Dmt_t_output_esclusi output) {
        esclusiRepository.save(output);

    }

    /**
     * Metodo che ritorna un'istanza di tipo {@link Dmt_t_anagrafica_allevamenti} in base ad allevId.
     * {@link Dmt_t_anagrafica_allevamenti_repository#findByAllevId(BigDecimal)}
     * @param allevId identificativo univoco interno in BDN associato all'allevamento
     * @return istanza di tipo {@link Dmt_t_anagrafica_allevamenti}
     */
    public Dmt_t_anagrafica_allevamenti getAnagraficaByIdAllevamento(BigDecimal allevId) {
        return anagraficaAllevamentiRep.findByAllevId(allevId);
    }
    
    /**
     * Metodo che ritorna un'istanza di tipo {@link Dmt_t_anagrafica_allevamenti} in base ad aziendaCodice e idSessione.
     * {@link Dmt_t_anagrafica_allevamenti_repository#findByAziendaCodiceAndIdSessione(String, Long)}
     * @param aziendaCodice codice univoco aziendale
     * @param idSessione identificativo univoco associato all'esecuzione corrente.
     * @return istanza di tipo {@link String}
     */
    public String getCodFiscaleDetenByAziendaCodiceAndIdSessione(String aziendaCodice, Long idSessione) {
        return anagraficaAllevamentiRep.findByAziendaCodiceAndIdSessione(aziendaCodice, idSessione);
    }

    /**
     * Metodo che ritorna un'istanza di tipo {@link Dmt_t_anagrafica_allevamenti} in base ad allevId e idSessione.
     * {@link Dmt_t_anagrafica_allevamenti_repository#findByAllevIdAndSessione(BigDecimal, Long)}
     * @param allevId identificativo univoco associato all'allevamento in BDN.
     * @param idSessione identificativo univoco associato all'esecuzione corrente.
     * @return istanza di tipo {@link Dmt_t_anagrafica_allevamenti}
     */
    public Dmt_t_anagrafica_allevamenti getAllevIdAndSessione(BigDecimal allevId, Long idSessione) {
    	return anagraficaAllevamentiRep.findByAllevIdAndSessione(allevId, idSessione);
    }

	 /**
     * Metodo che ritorna una Lista di identificativi univoci di allevamenti in base ad idSessione, cuaa e codiceIntervento.
     * {@link Dmt_t_tws_bdn_du_capi_bovini_repository#getAllevamentiBySessioneCuaaCodIntervento(Long, String, String)}
     * @param idSessione identificativo univoco associato all'esecuzione
     * @param cuaa codice fiscale del richiedente
     * @param codiceIntervento codice intervento
     * @return {@link Integer} lista di allevamenti.
     */
    public List<Integer> getAllevamentiBySessioneCuaaCodIntervento(Long idSessione, String cuaa,
                                                                   String codiceIntervento) {
        return boviniRepository.getAllevamentiBySessioneCuaaCodIntervento(idSessione, cuaa, codiceIntervento);
    }

    /**
     * Metodo che ritorna una lista di istanze di tipo {@link Dmt_t_Tws_bdn_du_capi_bovini} in base a idSessione, cuaa e codiceIntervento.
     * {@link Dmt_t_tws_bdn_du_capi_bovini_repository#getBoviniOfDetentoriAllevamentiAttivi(Long, String, String)}
     * @param idSessione identificativo univoco associato all'esecuzione
     * @param cuaa codice fiscale del richiedente
     * @param codiceIntervento codice intervento
     * @return lista delle istanze di tipo {@link Dmt_t_Tws_bdn_du_capi_bovini}
     */
    public List<Dmt_t_Tws_bdn_du_capi_bovini> getBoviniOfDetentoriAllevamentiAttivi(Long idSessione, String cuaa,
                                                                                    String codiceIntervento) {
        return boviniRepository.getBoviniOfDetentoriAllevamentiAttivi(idSessione, cuaa, codiceIntervento);
    }
    
    /**
     * Metodo che ritorna una lista di istanze di tipo {@link Dmt_t_Tws_bdn_du_capi_bovini} in base a idSessione, cuaa e codiceIntervento
     * {@link Dmt_t_tws_bdn_du_capi_bovini_repository#getBoviniOfDetentoriAllevamentiNonAttivi(Long, String, String)}
     * @param idSessione identificativo univoco associato all'esecuzione
     * @param cuaa codice fiscale del richiedente
     * @param codiceIntervento codice intervento.
     * @return  lista di istanze di tipo {@link Dmt_t_Tws_bdn_du_capi_bovini}
     */
    public List<Dmt_t_Tws_bdn_du_capi_bovini> getBoviniOfDetentoriAllevamentiNonAttivi(Long idSessione, String cuaa,
                                                                                       String codiceIntervento) {
        return boviniRepository.getBoviniOfDetentoriAllevamentiNonAttivi(idSessione, cuaa, codiceIntervento);
    }

    /**
     * Metodo che ritorna una lista di codici premio in base al cuaa.
     * {@link Dmt_t_tws_bdn_du_capi_bovini_repository#findBySessioneAndCuaa(Long, String)}
     * @param cuaa codice fiscale del richiedente
     * @return {@link String} lista dei codici premio associati al codice fiscale del richiedente.
     */
    public List<String> getCodicePremioPerCuaa(String cuaa) {
        return rpuVPraticaRep.findByCuaa(cuaa);
    }

    public List<Dmt_t_Tws_bdn_du_capi_bovini> getCapiBoviniDaCuaaAndIdSessione(Long sessione, String cuaa) {

        return boviniRepository.findBySessioneAndCuaa(sessione, cuaa);

    }

    /**
     * Metodo che ritorna una lista di istanze di tipo {@link Dmt_t_clsCapoMacellato} in base alla sessione e il cuaa.
     * {@link Dmt_t_clsCapoMacellato_repository#findBySessioneAndCuaa(Long, String)}
     * @param sessione identificativo univoco associato all'esecuzione
     * @param cuaa codice fiscale del richiedente
     * @return lista di istanze di tipo {@link Dmt_t_clsCapoMacellato}
     */
    public List<Dmt_t_clsCapoMacellato> getCapiMacellatiDaCuaaAndIdSessione(Long sessione, String cuaa) {

        return macellatiRepository.findBySessioneAndCuaa(sessione, cuaa);
    }

    /**
     * Metodo che ritorna una lista di istanze di tipo {@link Dmt_t_Tws_bdn_du_capi_ovicaprini} in base alla sessione e il cuaa
     * {@link Dmt_t_Tws_bdn_du_capi_ovicaprini_repository#findBySessioneAndCuaa(Long, String)}
     * @param sessione identificativo univoco associato all'esecuzione
     * @param cuaa codice fiscale del detentore
     * @return lista di istanze di tipo {@link Dmt_t_Tws_bdn_du_capi_ovicaprini}
     */
    public List<Dmt_t_Tws_bdn_du_capi_ovicaprini> getCapiOvicapriniDaCuaaAndIdSessione(Long sessione, String cuaa) {

        return ovicapriniRep.findBySessioneAndCuaa(sessione, cuaa);

    }

    /**
     * Metodo che ritorna una lista di istanze di tipo {@link Dmt_t_Tws_bdn_du_capi_ovicaprini} in base a idSessione, cuaa e codiceIntervento.
     * {@link Dmt_t_Tws_bdn_du_capi_ovicaprini_repository#findByIdSessionAndCuaa(Long, String, String)}
     * @param idSessione identificativo univoco associato all'esecuzione
     * @param cuaa codice fiscale del richiedente
     * @param codiceIntervento codice intervento
     * @return istanza di tipo {@link Dmt_t_Tws_bdn_du_capi_ovicaprini}
     */
    public List<Dmt_t_Tws_bdn_du_capi_ovicaprini> getAllOvicapriniSessioneCuaa(Long idSessione, String cuaa,
                                                                               String codiceIntervento) {
        return ovicapriniRep.findByIdSessionAndCuaa(idSessione, cuaa, codiceIntervento);
    }

    /**
     * Metodo che ritorna una lista di istanze di tipo {@link Dmt_t_output_esclusi} in base a idSessione e calcolo.
     * {@link Dmt_t_output_esclusi_repository#findBySessioneAndCalcolo(Long, String)}
     * @param idSessione identificativo univoco associato all'esecuzione
     * @param calcolo calcolo intervento associato al codice intervento.
     * @return istanza di tipo {@link Dmt_t_output_esclusi}
     */
    public List<Dmt_t_output_esclusi> getAllCapoIdAnomali(Long idSessione, String calcolo) {
        return esclusiRepository.findBySessioneAndCalcolo(idSessione, calcolo);
    }

    /**
     * Metodo che ritorna una lista di istanze di tipo {@link Dmt_t_importo_unitario} in base ad annoCampagna
     * {@link Dmt_t_importo_unitario_repository#findByAnnoCampagna(Integer)}
     * @param annoCampagna anno della campagna
     * @return lista di istanze di tipo {@link Dmt_t_importo_unitario}
     */
    public List<Dmt_t_importo_unitario> getAllImportoUnitarioByAnnoCampagna(Integer annoCampagna) {

        return importoUnitRep.findByAnnoCampagna(annoCampagna);
    }

    /**
     * Metodo che ritorna un'istanza di tipo @see Dmt_t_importo_unitario in base ad annoCampagna e intervento.
     * {@link Dmt_t_importo_unitario_repository#findAllByAnnoCampagnaAndIntervento(Integer, List)}
     * @param annoCampagna anno della campagna
     * @param intervento codice intervento
     * @return istanza di tipo {@link Dmt_t_importo_unitario}
     */
    public Dmt_t_importo_unitario getImportoUnitarioByAnnoCampagnaAndIntervento(Integer annoCampagna,
                                                                                String intervento) {

        return importoUnitRep.findByAnnoCampagnaAndIntervento(annoCampagna, intervento);
    }

    /**
     * Metodo che ritorna una lista codici premio in base a idCapo ed idSessione.
     * {@link Dmt_t_premio_capi_repository#findCodiciPremioByIdCapoAndIdSessione(Long, Long)}
     * @param idCapo identificativo univoco associato al capo animale
     * @param idSessione identificativo univoco associato all'esecuzione
     * @return lista di codici premio associati ad un capo animale.
     */
    public List<String> getCodiciPremioPerCapo(Long idCapo, Long idSessione) {
        return premioCapiRep.findCodiciPremioByIdCapoAndIdSessione(idCapo, idSessione);
    }


    /**
     * Metodo che ritorna una lista di istanze di tipo {@link Dmt_t_importo_unitario} in base ad annoCampagna ed una lista di codici intervento
     * {@link Dmt_t_importo_unitario_repository#findAllByAnnoCampagnaAndIntervento(Integer, List)}
     * @param annoCampagna anno della campagna
     * @param interventi lista di codici interventi
     * @return lista degli importi unitari in base ad una lista di codici intervento
     */
    public List<Dmt_t_importo_unitario> getListImportiUnitariByAnnoCampagnaAndIntervento(Integer annoCampagna, List<String> interventi) {

        return importoUnitRep.findAllByAnnoCampagnaAndIntervento(annoCampagna, interventi);
    }

    /**
     * Metodo che ritorna una lista di capo_id in base ad idSessione e calcolo.
     * {@link Dmt_t_output_esclusi_repository#isAnomalo(Long, String)}
     * @param idSessione identificativo univoco associato all'esecuzione
     * @param calcolo calcolo intervento associato al codice intervento
     * @return Long lista di capo_id
     */
    public List<Long> isAnomalo(Long idSessione, String calcolo) {

        return esclusiRepository.isAnomalo(idSessione, calcolo);
    }

    /**
     * Metodo che effettua il salvataggio a DB di un'istanza di Dmt_t_output_ref03.
     * @param output istanza di tipo {@link Dmt_t_output_ref03}
     */
    public void saveOutputRef03(Dmt_t_output_ref03 output) {

        ref03Rep.save(output);
    }

    /**
     * Metodo che ritorna una lista di istanze di tipo {@link Dmt_t_Tws_bdn_du_capi_ovicaprini} in base a idSessione, cuaa e codicePremio.
     * {@link Dmt_t_Tws_bdn_du_capi_ovicaprini_repository#findByIdSessionAndCuaa(Long, String, String)}
     * @param idSessione identificativo univoco associato all'esecuzione
     * @param cuaa codice fiscale del richiedente
     * @param codicePremio codice intervento
     * @return lista di istanze di tipo {@link Dmt_t_Tws_bdn_du_capi_ovicaprini}
     */
    public List<Dmt_t_Tws_bdn_du_capi_ovicaprini> getOvicapriniBySessioneCuaaCodIntervento(Long idSessione, String cuaa, String codicePremio) {
        return ovicapriniRep.findByIdSessionAndCuaa(idSessione, cuaa, codicePremio);
    }

    /**
     * Metodo che ritorna un'istanza di tipo {@link Rpu_V_pratica_zoote} in base ad annoCampagna, cuaa e codicePremio
     * {@link Rpu_V_pratica_zoote_repository#findByAnnoCampagnaAndCuaaAndCodicePremio(Integer, String, String)}
     * @param annoCampagna anno della campagna
     * @param cuaa codice fiscale del richiedente
     * @param codicePremio codice intervento
     * @return istanza di tipo {@link Rpu_V_pratica_zoote}
     */
    public Rpu_V_pratica_zoote getByAnnoCampagnaAndCuaaAndCodicePremio(Integer annoCampagna, String cuaa, String codicePremio) {
    	return rpuVPraticaRep.findByAnnoCampagnaAndCuaaAndCodicePremio(annoCampagna, cuaa, codicePremio);
    }

    /**
     * Metodo che ritorna un'istanza di tipo {@link Dmt_t_output_controlli} in base a sessione, cuaa, valueOf e cp.
     * {@link Dmt_t_output_controlli_repository#findBySessioneAndCuaaAndAnnoCampagnaAndIntervento(Dmt_t_sessione, String, Long, String)}
     * @param sessione identificativo univoco associato all'esecuzione
     * @param cuaa codice fiscale del richiedente
     * @param valueOf annoCampagna
     * @param cp codice premio
     * @return istanza di tipo {@link Dmt_t_output_controlli}
     */
    public Dmt_t_output_controlli getOutputControlliBySessioneAndCuaaAndAnnoCampagnaAndIntervento(Dmt_t_sessione sessione, String cuaa, Long valueOf, String cp) {
        return outputRepository.findBySessioneAndCuaaAndAnnoCampagnaAndIntervento(sessione, cuaa, valueOf, cp);
    }
    
    public Integer getGiorniRitardoPresentazioneDomanda(String cuaa, String codicePremio, Integer annoCampagna) {
    	
    	return rpuVPraticaRep.findByCuaaAndCodicePremioAndAnnoCampagna(cuaa, codicePremio,  annoCampagna);
    }
    
    public BigDecimal getPercentualeDiDecurtazione(Integer annoCampagna, Integer giorniRitardo) {
    	
    	return ggRitardoRep.findByAnnoCampagnaAndGiorniDiRitardo(annoCampagna, giorniRitardo);
    }

    public List<Dmt_t_irregolarita_intenzionale> getIrregolaritaByCuaaAndAnnoCampagna(String cuaa, Integer annoCampagna) {
    	return irregolaritaRep.findIrregByCuaaAndAnnoCampagna(cuaa, annoCampagna);
    }
    
    public BigDecimal getQuotaCapiPremioByCuaaAndIdSessioneAndAnnoCampagnaAndCodInt(String cuaa, Long idSessione, Integer annoCampagna, String codInt) {
    	return agnelleRep.getQuotaCapiPremioByCuaaAndIdSessioneAndAnnoCampagnaAndCodInt(cuaa, idSessione, annoCampagna, codInt);
    }
    
    public List<Long> getListaCapiEsito(Dmt_t_sessione idSessione, String cuaa, String codPremio) {
    	return premioCapiRep.getListaCapiEsitoByIdSessioneAndFlagAmmissibileAndCuaaAndCodPremio(idSessione.getIdSessione(), cuaa, codPremio);
    }
    
    public Dmt_t_output_ref03 getCapiPagabiliPerCuaaAndCodicePremio(Integer annoCampagna, String cuaa, Dmt_t_sessione sessione, String codicePremio) {
    	return ref03Rep.findCapiPagabiliByAnnoCampagnaAndCuaaAndIdSessioneAndIntervento(annoCampagna, cuaa, sessione.getIdSessione(), codicePremio);
    }
    
    public List<Date> getDataNascitaVitelloByIdCapoAndIdSessione(Long idCapo, Long idSessione) {
  		return boviniRepository.findDataNascitaVitelloByIdCapoAndIdSessione(idCapo, idSessione);
  	}
    
    public Date getDataNascitaVitelloByVitelloCapoIdAndIdSessione(Long idCapo, Long idSessione) {
		return boviniRepository.findDataNascitaVitelloByVitelloCapoIdAndIdSessione(idCapo, idSessione);
	}
    
    public Date getVitelloDataInserBdnNascitaByVitelloCapoIdAndIdSessione(Long idCapo, Long idSessione) {
		return boviniRepository.findDataInsBdnNascitaByVitelloCapoIdAndIdSessione(idCapo, idSessione);
	}
    
    public String getFlagDelegatoNascitaVitelloByVitelloCapoIdAndIdSessione(Long idCapo, Long idSessione) {
    	return boviniRepository.findFlagDelegatoNascitaVitelloByVitelloCapoIdAndIdSessione(idCapo, idSessione);
    }
    
    public String getFlagProrogaMarcaturaByVitelloCapoIdAndIdSessione(Long idCapo, Long idSessione) {
    	return boviniRepository.findFlagProrogaMarcaturaByVitelloCapoIdAndIdSessione(idCapo, idSessione);
    }
    
    public Dmt_t_demarcazione_PSR getByAnnoAndMarchioAuricolare(Integer anno, String marchioAuricolare) {
		return PSRrep.findByAnnoAndMarchioAuricolare(anno, marchioAuricolare) == null ? new Dmt_t_demarcazione_PSR() : PSRrep.findByAnnoAndMarchioAuricolare(anno, marchioAuricolare);
	}
    
    public List<Dmt_T_analisi_produzioni_cuua> getProduzioniByCuaaAndYear(String cuaa, int year) {
    	
    	return this.AnalisiProduzioniRep.getByCUUAAndYear(cuaa, year);
    }
    
    public String getCuaaBeneficiarioCapiDoppi(Integer annoCampagna, String codicePremio, Long idCapo) {
    	return BeneficiarioCapiDoppiRep.findCuaaByAnnoCampagnaAndCodcePremioAndIdCapo(annoCampagna, codicePremio, idCapo) == null ? "" : BeneficiarioCapiDoppiRep.findCuaaByAnnoCampagnaAndCodcePremioAndIdCapo(annoCampagna, codicePremio, idCapo);
    }
}
