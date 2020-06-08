package it.csi.demetra.demetraws.zoo.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_SistemiDiEtichettaturaFacoltativa;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_bovini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_ovicaprini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_anagrafica_allevamenti;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_certificato_igp_dop;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_clsCapoMacellato;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_contr_loco;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_importo_unitario;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_esclusi;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_ref03;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;
import it.csi.demetra.demetraws.zoo.model.Dmt_w_controllo_bean;
import it.csi.demetra.demetraws.zoo.model.Rpu_V_pratica_zoote;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_SistemiDiEtichettaturaFacoltativa_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_Tws_bdn_du_capi_ovicaprini_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_anagrafica_allevamenti_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_certificato_igp_dop_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_clsCapoMacellato_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_contr_loco_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_importo_unitario_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_output_controlli_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_output_esclusi_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_output_ref03_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_tws_bdn_du_capi_bovini_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_w_controllo_bean_repository;
import it.csi.demetra.demetraws.zoo.repository.Rpu_V_pratica_zoote_repository;

@Service
/**
 * Classe service che utilizza le Query definite nei seguenti repository:
 * @see Dmt_t_tws_bdn_du_capi_bovini_repository
 * @see Dmt_t_anagrafica_allevamenti_repository
 * @see Dmt_w_controllo_bean_repository
 * @see Dmt_t_output_controlli_repository
 * @see Dmt_t_output_esclusi_repository
 * @see Dmt_t_contr_loco_repository
 * @see Dmt_t_clsCapoMacellato_repository
 * @see Dmt_t_SistemiDiEtichettaturaFacoltativa_repository
 * @see Dmt_t_certificato_igp_dop_repository
 * @see Dmt_t_anagrafica_allevamenti_repository
 * @see Rpu_V_pratica_zoote_repository
 * @see Dmt_t_Tws_bdn_du_capi_ovicaprini_repository
 * @see Dmt_t_importo_unitario_repository
 * @see Dmt_t_output_ref03_repository
 * @author Bcsoft
 */
public class ControlliService {

    @Autowired
    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_tws_bdn_du_capi_bovini.
     */
    Dmt_t_tws_bdn_du_capi_bovini_repository boviniRepository;

    @Autowired
    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_anagrafica_allevamenti.
     */
    Dmt_t_anagrafica_allevamenti_repository anaRepository;

    @Autowired
    /**
     * Repository in cui sono definite le Query di tipo Dmt_w_controllo_bean_repository.
     */
    Dmt_w_controllo_bean_repository controlloBeanRepository;

    @Autowired
    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_output_controlli_repository.
     */
    Dmt_t_output_controlli_repository outputRepository;

    @Autowired
    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_output_esclusi_repository.
     */
    Dmt_t_output_esclusi_repository esclusiRepository;

    @Autowired
    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_contr_loco_repository.
     */
    Dmt_t_contr_loco_repository contrLocoRepository;

    @Autowired
    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_clsCapoMacellato_repository.
     */
    Dmt_t_clsCapoMacellato_repository macellatiRepository;

    @Autowired
    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_SistemiDiEtichettaturaFacoltativa_repository.
     */
    Dmt_t_SistemiDiEtichettaturaFacoltativa_repository etichettaturaRepository;

    @Autowired
    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_certificato_igp_dop_repository.
     */
    Dmt_t_certificato_igp_dop_repository igpDopRepository;

    @Autowired
    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_anagrafica_allevamenti_repository.
     */
    Dmt_t_anagrafica_allevamenti_repository anagraficaAllevamentiRep;

    @Autowired
    /**
     * Repository in cui sono definite le Query di tipo Rpu_V_pratica_zoote_repository.
     */
    Rpu_V_pratica_zoote_repository rpuVPraticaRep;

    @Autowired
    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_Tws_bdn_du_capi_ovicaprini_repository.
     */
    Dmt_t_Tws_bdn_du_capi_ovicaprini_repository ovicapriniRep;

    @Autowired
    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_importo_unitario_repository.
     */
    Dmt_t_importo_unitario_repository importoUnitRep;

    @Autowired
    /**
     * Repository in cui sono definite le Query di tipo Dmt_t_output_ref03_repository.
     */
    Dmt_t_output_ref03_repository ref03Rep;


    /**
     * Metodo che ritorna una lista di istanze di tipo @see Dmt_t_Tws_bdn_du_capi_bovini in base alla sessione, cuaa e codiceIntervento
     * @param sessione identificativo univoco associato all'esecuzione.
     * @see Dmt_t_Tws_bdn_du_capi_bovini_repository.findByIdSessionAndCuaa
     * @param cuua codice fiscale del richiedente
     * @param codiceIntervento codice intervento
     * @return List<Dmt_t_Tws_bdn_du_capi_bovini>
     */
    public List<Dmt_t_Tws_bdn_du_capi_bovini> getAllBoviniSessioneCuua(Dmt_t_sessione sessione, String cuua,
                                                                       String codiceIntervento) {
        return boviniRepository.findByIdSessionAndCuaa(sessione.getIdSessione(), cuua, codiceIntervento);
    }

    /**
     * Metodo che ritorna una lista di istanze di tipo @see Dmt_t_Tws_bdn_du_capi_bovini in base ad idSessione, idCapo e codiceIntervento.
     * @see Dmt_t_Tws_bdn_du_capi_bovini_repository.findByIdSessioneAndIdCapo
     * @param idSessione identificativo univoco associato all'esecuzione
     * @param idCapo identificativo univoco associato al capo animale
     * @param codiceIntervento codice intervento
     * @return List<Dmt_t_Tws_bdn_du_capi_bovini>
     */
    public List<Dmt_t_Tws_bdn_du_capi_bovini> getVitelliNatiDaBovini(Long idSessione, Long idCapo,
                                                                     String codiceIntervento) {
        return boviniRepository.findByIdSessioneAndIdCapo(idSessione, idCapo, codiceIntervento);
    }

    /**
     * Metodo che ritorna un container Optional di istanze di tipo Dmt_w_controllo_bean in base al codicePremio.
     * @see Dmt_w_controllo_bean_repository.findByCodicePremio
     * @param codicePremio codcie intervento
     * @return Optional<Dmt_w_controllo_bean>
     */
    public Optional<Dmt_w_controllo_bean> findByIdControlloBean(String codicePremio) {
        return controlloBeanRepository.findByCodicePremio(codicePremio);
    }

    /**
     * Metodo che effettua la persistenza di un oggetto di tipo @see Dmt_t_output_controlli.
     * @see Dmt_t_output_controlli_repository.save
     * @param output istanza di tipo @see Dmt_t_output_controlli da salvare a DB
     */
    public void saveOutput(Dmt_t_output_controlli output) {
        outputRepository.save(output);
    }

    /**
     * Metodo che ritorna una lista di istanze di tipo @see Dmt_t_clsCapoMacellato in base al capoId, idSessione e codiceIntervento.
     * @see Dmt_t_clsCapoMacellato_repository.findByCapoId
     * @param capoId identificativo univoco associato al capo animale
     * @param idSessione identificativo univoco associato all'esecuzione
     * @param codiceIntervento codice intervento
     * @return @see List<Dmt_t_clsCapoMacellato>
     */
    public List<Dmt_t_clsCapoMacellato> getDuplicati(Long capoId, Long idSessione, String codiceIntervento) {
        return macellatiRepository.FindByCapoId(idSessione, capoId, codiceIntervento);
    }

    /**
     * Metodo che ritorna una lista di istanze di tipo @see Dmt_t_clsCapoMacellato in base a sessione, cuaa e codiceIntervento.
     * @see Dmt_t_clsCapoMacellato_repository.findByIdSessionAndCuaa
     * @param sessione identificativo univoco associato all'esecuzione
     * @param cuaa codice fiscale del richiedente
     * @param codiceIntervento codice intervento
     * @return List<Dmt_t_clsCapoMacellato>
     */
    public List<Dmt_t_clsCapoMacellato> getAllMacellatiSessioneCuua(Dmt_t_sessione sessione, String cuaa,
                                                                    String codiceIntervento) {
        return macellatiRepository.findByIdSessionAndCuaa(sessione.getIdSessione(), cuaa, codiceIntervento);
    }

    /**
     * Metodo che ritorna una lista di istanze di tipo @see Dmt_t_contr_loco in base al cuaa.
     * @see Dmt_t_contr_loco_repository.findByCuaa
     * @param cuaa codice fiscale del richiedente
     * @return List<Dmt_t_contr_loco>
     */
    public List<Dmt_t_contr_loco> getEsrtazioneACampioneByCuaa(String cuaa) {

        return contrLocoRepository.findByCuaa(cuaa);
    }

    /**
     * Metodo che ritorna un'istanza di tipo Dmt_t_SistemiDiEtichettaturaFacoltativa in base al cuaa
     * @see Dmt_t_SistemiDiEtichettaturaFacoltativa_repository.findByCuaa
     * @param cuaa codice fiscale del richiedente
     * @return Dmt_t_SistemiDiEtichettaturaFacoltativa
     */
    public Dmt_t_SistemiDiEtichettaturaFacoltativa getSistemaEtichettarua(String cuaa) {

        return this.etichettaturaRepository.findByCuaa(cuaa);
    }

    /**
     * Metodo che ritorna un'istanza di tipo @see Dmt_t_certificato_igp_dop in base al cuaa.
     * @see Dmt_t_certificato_igp_dop_repository.findByCuaa
     * @param cuaa codice fiscale del richiedente
     * @return Dmt_t_certificato_igp_dop
     */
    public Dmt_t_certificato_igp_dop getCertificatoIgpDop(String cuaa) {
        return this.igpDopRepository.findByCuaa(cuaa);
    }

    /**
     * Metodo che effettua la persistenza a DB di un oggetto di tipo @see Dmt_t_output_esclusi.
     * @see Dmt_t_output_esclusi_repository.save
     * @param output oggetto di tipo Dmt_t_output_esclusi
     */
    public void saveOutputEscl(Dmt_t_output_esclusi output) {
        esclusiRepository.save(output);

    }

    /**
     * Metodo che ritorna un'istanza di tipo @see Dmt_t_anagrafica_allevamenti in base ad allevId.
     * @see Dmt_t_anagrafica_allevamenti.findByAllevId
     * @param allevId identificativo univoco interno in BDN associato all'allevamento
     * @return Dmt_t_anagrafica_allevamenti
     */
    public Dmt_t_anagrafica_allevamenti getAnagraficaByIdAllevamento(BigDecimal allevId) {
        return anagraficaAllevamentiRep.findByAllevId(allevId);
    }

    /**
     * Metodo che ritorna una Lista di identificativi univoci di allevamenti in base ad idSessione, cuaa e codiceIntervento.
     * @see Dmt_t_Tws_bdn_du_capi_bovini_repository.getAllevamentiBySessioneCuaaCodIntervento
     * @param idSessione identificativo univoco associato all'esecuzione
     * @param cuaa codice fiscale del richiedente
     * @param codiceIntervento codice intervento
     * @return List<Integer> lista di allevamenti.
     */
    public List<Integer> getAllevamentiBySessioneCuaaCodIntervento(Long idSessione, String cuaa,
                                                                   String codiceIntervento) {
        return boviniRepository.getAllevamentiBySessioneCuaaCodIntervento(idSessione, cuaa, codiceIntervento);
    }

    /**
     * Metodo che ritorna una lista di istanze di tipo @see Dmt_t_Tws_bdn_du_capi_bovini in base a idSessione, cuaa e codiceIntervento.
     * @see Dmt_t_Tws_bdn_du_capi_bovini.getBoviniOfDetentoriAllevamentiAttivi
     * @param idSessione identificativo univoco associato all'esecuzione
     * @param cuaa codice fiscale del richiedente
     * @param codiceIntervento codice intervento
     * @return List<Dmt_t_Tws_bdn_du_capi_bovini>
     */
    public List<Dmt_t_Tws_bdn_du_capi_bovini> getBoviniOfDetentoriAllevamentiAttivi(Long idSessione, String cuaa,
                                                                                    String codiceIntervento) {
        return boviniRepository.getBoviniOfDetentoriAllevamentiAttivi(idSessione, cuaa, codiceIntervento);
    }
    
    /**
     * Metodo che ritorna una lista di istanze di tipo @see Dmt_t_Tws_bdn_du_capi_bovini in base a idSessione, cuaa e codiceIntervento
     * @see Dmt_t_Tws_bdn_du_capi_bovini_repository.getBoviniOfDetentoriAllevamentiNonAttivi
     * @param idSessione identificativo univoco associato all'esecuzione
     * @param cuaa codice fiscale del richiedente
     * @param codiceIntervento codice intervento.
     * @return  List<Dmt_t_Tws_bdn_du_capi_bovini>
     */
    public List<Dmt_t_Tws_bdn_du_capi_bovini> getBoviniOfDetentoriAllevamentiNonAttivi(Long idSessione, String cuaa,
                                                                                       String codiceIntervento) {
        return boviniRepository.getBoviniOfDetentoriAllevamentiNonAttivi(idSessione, cuaa, codiceIntervento);
    }

    /**
     * Metodo che ritorna una lista di codici premio in base al cuaa.
     * @see Rpu_V_pratica_zoote_repository.findByCuaa
     * @param cuaa codice fiscale del richiedente
     * @return List<String> lista dei codici premio associati al codice fiscale del richiedente.
     */
    public List<String> getCodicePremioPerCuaa(String cuaa) {
        return rpuVPraticaRep.findByCuaa(cuaa);
    }

    public List<Dmt_t_Tws_bdn_du_capi_bovini> getCapiBoviniDaCuaaAndIdSessione(Long sessione, String cuaa) {

        return boviniRepository.findBySessioneAndCuaa(sessione, cuaa);

    }

    /**
     * Metodo che ritorna una lista di istanze di tipo @see Dmt_t_clsCapoMacellato in base alla sessione e il cuaa.
     * @see Dmt_t_clsCapoMacellato_repository.findBySessioneAndCuaa.
     * @param sessione identificativo univoco associato all'esecuzione
     * @param cuaa codice fiscale del richiedente
     * @return List<Dmt_t_clsCapoMacellato>
     */
    public List<Dmt_t_clsCapoMacellato> getCapiMacellatiDaCuaaAndIdSessione(Long sessione, String cuaa) {

        return macellatiRepository.findBySessioneAndCuaa(sessione, cuaa);
    }

    /**
     * Metodo che ritorna una lista di istanze di tipo @see Dmt_t_Tws_bdn_du_capi_ovicaprini in base alla sessione e il cuaa
     * @see Dmt_t_Tws_bdn_du_capi_ovicaprini_repository.findBySessioneAndCuaa
     * @param sessione identificativo univoco associato all'esecuzione
     * @param cuaa codice fiscale del detentore
     * @return  List<Dmt_t_Tws_bdn_du_capi_ovicaprini>
     */
    public List<Dmt_t_Tws_bdn_du_capi_ovicaprini> getCapiOvicapriniDaCuaaAndIdSessione(Long sessione, String cuaa) {

        return ovicapriniRep.findBySessioneAndCuaa(sessione, cuaa);

    }

    /**
     * Metodo che ritorna una lista di istanze di tipo @see Dmt_t_Tws_bdn_du_capi_ovicaprini in base a idSessione, cuaa e codiceIntervento.
     * @see Dmt_t_Tws_bdn_du_capi_ovicaprini_repository.findByIdSessionAndCuaa
     * @param idSessione identificativo univoco associato all'esecuzione
     * @param cuaa codice fiscale del richiedente
     * @param codiceIntervento codice intervento
     * @return List<Dmt_t_Tws_bdn_du_capi_ovicaprini>
     */
    public List<Dmt_t_Tws_bdn_du_capi_ovicaprini> getAllOvicapriniSessioneCuaa(Long idSessione, String cuaa,
                                                                               String codiceIntervento) {
        return ovicapriniRep.findByIdSessionAndCuaa(idSessione, cuaa, codiceIntervento);
    }

    /**
     * Metodo che ritorna una lista di istanze di tipo @see Dmt_t_output_esclusi in base a idSessione e calcolo.
     * @see Dmt_t_output_esclusi_repository.getAllCapoIdAnomali
     * @param idSessione identificativo univoco associato all'esecuzione
     * @param calcolo calcolo intervento associato al codice intervento.
     * @return List<Dmt_t_output_esclusi>
     */
    public List<Dmt_t_output_esclusi> getAllCapoIdAnomali(Long idSessione, String calcolo) {
        return esclusiRepository.findBySessioneAndCalcolo(idSessione, calcolo);
    }

    /**
     * Metodo che ritorna una lista di istanze di tipo @see Dmt_t_importo_unitario in base ad annoCampagna
     * @see Dmt_t_importo_unitario_repository.findByAnnoCampagna
     * @param annoCampagna anno della campagna
     * @return List<Dmt_t_importo_unitario>
     */
    public List<Dmt_t_importo_unitario> getAllImportoUnitarioByAnnoCampagna(Integer annoCampagna) {

        return importoUnitRep.findByAnnoCampagna(annoCampagna);
    }

    /**
     * Metodo che ritorna un'istanza di tipo @see Dmt_t_importo_unitario in base ad annoCampagna e intervento.
     * @see Dmt_t_importo_unitario_repository.findByAnnoCampagnaAndIntervento
     * @param annoCampagna anno della campagna
     * @param intervento codice intervento
     * @return Dmt_t_importo_unitario
     */
    public Dmt_t_importo_unitario getImportoUnitarioByAnnoCampagnaAndIntervento(Integer annoCampagna,
                                                                                String intervento) {

        return importoUnitRep.findByAnnoCampagnaAndIntervento(annoCampagna, intervento);
    }

    /**
     * Metodo che ritorna una lista codici premio in base a idCapo ed idSessione.
     * @see Dmt_t_Tws_bdn_du_capi_bovini_repository.findCodiciPremioBuIdSessione
     * @param idCapo identificativo univoco associato al capo animale
     * @param idSessione identificativo univoco associato all'esecuzione
     * @return List<String> lista di codici premio associati ad un capo animale.
     */
    public List<String> getCodiciPremioPerCapo(Long idCapo, Long idSessione) {
        return boviniRepository.findCodiciPremioByIdCapoAndIdSessione(idCapo, idSessione);
    }


    /**
     * Metodo che ritorna una lista di istanze di tipo @see Dmt_t_importo_unitario in base ad annoCampagna ed una lista di codici intervento
     * @see Dmt_t_importo_unitario_repository.findByAnnoCampagnaAndIntervento
     * @param annoCampagna anno della campagna
     * @param interventi lista di codici interventi
     * @return List<Dmt_t_importo_unitario> lista degli importi unitari in base ad una lista di codici intervento
     */
    public List<Dmt_t_importo_unitario> getListImportiUnitariByAnnoCampagnaAndIntervento(Integer annoCampagna, List<String> interventi) {

        return importoUnitRep.findAllByAnnoCampagnaAndIntervento(annoCampagna, interventi);
    }

    /**
     * Metodo che ritorna una lista di capo_id in base ad idSessione e calcolo-
     * @see Dmt_t_output_esclusi_repository.isAnomalo. 
     * @param idSessione identificativo univoco associato all'esecuzione
     * @param calcolo calcolo intervento associato al codice intervento
     * @return List<Long> lista di capo_id
     */
    public List<Long> isAnomalo(Long idSessione, String calcolo) {

        return esclusiRepository.isAnomalo(idSessione, calcolo);
    }

    /**
     * Metodo che effettua il salvataggio a DB di un'istanza di @see Dmt_t_output_ref03.
     * @see Dmt_t_output_ref03.repository.saveOutputRef03
     * @param output
     */
    public void saveOutputRef03(Dmt_t_output_ref03 output) {

        ref03Rep.save(output);
    }

    /**
     * Metodo che ritorna una lista di istanze di tipo @see Dmt_t_Tws_bdn_du_capi_ovicaprini in base a idSessione, cuaa e codicePremio.
     * @see Dmt_t_Tws_bdn_du_capi_ovicaprini_repository.findByIdSessioneAndCuaa
     * @param idSessione identificativo univoco associato all'esecuzione
     * @param cuaa codice fiscale del richiedente
     * @param codicePremio codice intervento
     * @return List<Dmt_t_Tws_bdn_du_capi_ovicaprini>
     */
    public List<Dmt_t_Tws_bdn_du_capi_ovicaprini> getOvicapriniBySessioneCuaaCodIntervento(Long idSessione, String cuaa, String codicePremio) {
        return ovicapriniRep.findByIdSessionAndCuaa(idSessione, cuaa, codicePremio);
    }

    /**
     * Metodo che ritorna un'istanza di tipo @see Rpu_V_pratica_zoote in base ad annoCampagna, cuaa e codicePremio
     * @param annoCampagna anno della campagna
     * @param cuaa codice fiscale del richiedente
     * @param codicePremio codice intervento
     * @return Rpu_V_pratica_zoote
     */
    public Rpu_V_pratica_zoote getByAnnoCampagnaAndCuaaAndCodicePremio(Integer annoCampagna, String cuaa, String codicePremio) {
        return rpuVPraticaRep.findByAnnoCampagnaAndCuaaAndCodicePremio(annoCampagna, cuaa, codicePremio);
    }

    /**
     * Metodo che ritorna un'istanza di tipo @see Dmt_t_output_controlli in base a sessione, cuaa, valueOf e cp
     * @see Dmt_t_output_controlli_repository.findBySessioneAndCuaaAndAnnoCampagnaAndIntervento
     * @param sessione identificativo univoco associato all'esecuzione
     * @param cuaa codice fiscale del richiedente
     * @param valueOf annoCampagna
     * @param cp codice premio
     * @return
     */
    public Dmt_t_output_controlli getOutputControlliBySessioneAndCuaaAndAnnoCampagnaAndIntervento(Dmt_t_sessione sessione, String cuaa, Long valueOf, String cp) {
        return outputRepository.findBySessioneAndCuaaAndAnnoCampagnaAndIntervento(sessione, cuaa, valueOf, cp);
    }
}
