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
public class ControlliService {

	@Autowired
	Dmt_t_tws_bdn_du_capi_bovini_repository boviniRepository;

	@Autowired
	Dmt_t_anagrafica_allevamenti_repository anaRepository;

	@Autowired
	Dmt_w_controllo_bean_repository controlloBeanRepository;

	@Autowired
	Dmt_t_output_controlli_repository outputRepository;

	@Autowired
	Dmt_t_output_esclusi_repository esclusiRepository;

	@Autowired
	Dmt_t_contr_loco_repository contrLocoRepository;

	@Autowired
	Dmt_t_clsCapoMacellato_repository macellatiRepository;

	@Autowired
	Dmt_t_SistemiDiEtichettaturaFacoltativa_repository etichettaturaRepository;

	@Autowired
	Dmt_t_certificato_igp_dop_repository igpDopRepository;

	@Autowired
	Dmt_t_anagrafica_allevamenti_repository anagraficaAllevamentiRep;

	@Autowired
	Rpu_V_pratica_zoote_repository rpuVPraticaRep;

	@Autowired
	Dmt_t_Tws_bdn_du_capi_ovicaprini_repository ovicapriniRep;

	@Autowired
	Dmt_t_importo_unitario_repository importoUnitRep;
	
	@Autowired
	Dmt_t_output_ref03_repository ref03Rep;
	

	public List<Dmt_t_Tws_bdn_du_capi_bovini> getAllBoviniSessioneCuua(Dmt_t_sessione sessione, String cuua,
			String codiceIntervento) {
		return boviniRepository.findByIdSessionAndCuaa(sessione.getIdSessione(), cuua, codiceIntervento);
	}

	public List<Dmt_t_Tws_bdn_du_capi_bovini> getVitelliNatiDaBovini(Long idSessione, Long idCapo,
			String codiceIntervento) {
		return boviniRepository.findByIdSessioneAndIdCapo(idSessione, idCapo, codiceIntervento);
	}

	public Optional<Dmt_w_controllo_bean> findByIdControlloBean(String codicePremio) {
		return controlloBeanRepository.findByCodicePremio(codicePremio);
	}

	public void saveOutput(Dmt_t_output_controlli output) {
		outputRepository.save(output);
	}

	public List<Dmt_t_clsCapoMacellato> getDuplicati(Long capoId, long idSessione, String codiceIntervento) {
		return macellatiRepository.FindByCapoId(idSessione, capoId, codiceIntervento);
	}

	public List<Dmt_t_clsCapoMacellato> getAllMacellatiSessioneCuua(Dmt_t_sessione sessione, String cuaa,
			String codiceIntervento) {
		return macellatiRepository.findByIdSessionAndCuaa(sessione.getIdSessione(), cuaa, codiceIntervento);
	}

	public List<Dmt_t_contr_loco> getEsrtazioneACampioneByCuaa(String cuaa) {

		return contrLocoRepository.findByCuaa(cuaa);
	}

	public Dmt_t_SistemiDiEtichettaturaFacoltativa getSistemaEtichettarua(String cuaa) {

		return this.etichettaturaRepository.findByCuaa(cuaa);
	}

	public Dmt_t_certificato_igp_dop getCertificatoIgpDop(String cuaa) {
		return this.igpDopRepository.findByCuaa(cuaa);
	}

	public void saveOutputEscl(Dmt_t_output_esclusi output) {
		esclusiRepository.save(output);

	}

	public Dmt_t_anagrafica_allevamenti getAnagraficaByIdAllevamento(BigDecimal allevId) {
		return anagraficaAllevamentiRep.findByAllevId(allevId);
	}

	public List<Integer> getAllevamentiBySessioneCuaaCodIntervento(Long idSessione, String cuaa,
			String codiceIntervento) {
		return boviniRepository.getAllevamentiBySessioneCuaaCodIntervento(idSessione, cuaa, codiceIntervento);
	}

	public List<Dmt_t_Tws_bdn_du_capi_bovini> getBoviniOfDetentoriAllevamentiAttivi(Long idSessione, String cuaa,
			String codiceIntervento) {
		return boviniRepository.getBoviniOfDetentoriAllevamentiAttivi(idSessione, cuaa, codiceIntervento);
	}

	public List<Dmt_t_Tws_bdn_du_capi_bovini> getBoviniOfDetentoriAllevamentiNonAttivi(Long idSessione, String cuaa,
			String codiceIntervento) {
		return boviniRepository.getBoviniOfDetentoriAllevamentiNonAttivi(idSessione, cuaa, codiceIntervento);
	}

	public List<String> getCodicePremioPerCuaa(String cuaa) {
		return rpuVPraticaRep.findByCuaa(cuaa);
	}

	public List<Dmt_t_Tws_bdn_du_capi_bovini> getCapiBoviniDaCuaaAndIdSessione(Long sessione, String cuaa) {

		return boviniRepository.findBySessioneAndCuaa(sessione, cuaa);

	}

	public List<Dmt_t_clsCapoMacellato> getCapiMacellatiDaCuaaAndIdSessione(Long sessione, String cuaa) {

		return macellatiRepository.findBySessioneAndCuaa(sessione, cuaa);
	}

	public List<Dmt_t_Tws_bdn_du_capi_ovicaprini> getCapiOvicapriniDaCuaaAndIdSessione(Long sessione, String cuaa) {

		return ovicapriniRep.findBySessioneAndCuaa(sessione, cuaa);

	}

	public List<Dmt_t_Tws_bdn_du_capi_ovicaprini> getAllOvicapriniSessioneCuaa(Long idSessione, String cuaa,
			String codiceIntervento) {
		return ovicapriniRep.findByIdSessionAndCuaa(idSessione, cuaa, codiceIntervento);
	}

	public List<Dmt_t_output_esclusi> getAllCapoIdAnomali(Long idSessione, String calcolo) {
		return esclusiRepository.findBySessioneAndCalcolo(idSessione, calcolo);
	}

	public List<Dmt_t_importo_unitario> getAllImportoUnitarioByAnnoCampagna(Integer annoCampagna) {

		return importoUnitRep.findByAnnoCampagna(annoCampagna);
	}

	public Dmt_t_importo_unitario getImportoUnitarioByAnnoCampagnaAndIntervento(Integer annoCampagna,
			String intervento) {

		return importoUnitRep.findByAnnoCampagnaAndIntervento(annoCampagna, intervento);
	}
	
	public List<String> getCodiciPremioPerCapo(Long idCapo, Long idSessione){
		return boviniRepository.findCodiciPremioByIdCapoAndIdSessione(idCapo, idSessione);
	}
	
	
	public List<Dmt_t_importo_unitario> getListImportiUnitariByAnnoCampagnaAndIntervento(Integer annoCampagna, List<String> interventi) {
		
		return importoUnitRep.findAllByAnnoCampagnaAndIntervento(annoCampagna, interventi);
	}
	
	public List<Long> isAnomalo(Long idSessione, String calcolo) {
		
		return esclusiRepository.isAnomalo(idSessione, calcolo);
	}
	
	public void saveOutputRef03(Dmt_t_output_ref03 output) {
		
		ref03Rep.save(output);
	}
	
	public Dmt_t_output_controlli getOutputControlliBySessioneAndCuaaAndAnnoCampagnaAndIntervento(Dmt_t_sessione sessione, String cuaa, Long anno, String codiceIntervento) {
		
		return outputRepository.findBySessioneAndCuaaAndAnnoCampagnaAndIntervento(sessione, cuaa, anno, codiceIntervento);
	}
}
