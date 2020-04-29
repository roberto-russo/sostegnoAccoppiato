package it.csi.demetra.demetraws.zoo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.csi.demetra.demetraws.zoo.model.Dmt_w_controllo_bean;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_SistemiDiEtichettaturaFacoltativa;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_bovini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_certificato_igp_dop;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_clsCapoMacellato;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_contr_loco;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_errore;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_esclusi;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;
import it.csi.demetra.demetraws.zoo.repository.Dmt_w_controllo_bean_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_SistemiDiEtichettaturaFacoltativa_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_certificato_igp_dop_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_clsCapoMacellato_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_contr_loco_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_dsScarico_allevamenti_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_errore_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_output_controlli_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_output_esclusi_repository;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_tws_bdn_du_capi_bovini_repository;

@Service
public class ControlliService {

    @Autowired
    Dmt_t_tws_bdn_du_capi_bovini_repository boviniRepository;

    @Autowired
    Dmt_t_dsScarico_allevamenti_repository scaAllevRepository;

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
    
    

    public List<Dmt_t_Tws_bdn_du_capi_bovini> getAllBoviniSessioneCuua(Dmt_t_sessione sessione, String cuua, String codiceIntervento) {
        return boviniRepository.findByIdSessionAndCuaa(sessione.getIdSessione(), cuua, codiceIntervento);
    }

    public List<Dmt_t_Tws_bdn_du_capi_bovini> getVitelliNatiDaBovini(Long idSessione, Long idCapo, String codiceIntervento) {
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
	
	public List<Dmt_t_clsCapoMacellato> getAllMacellatiSessioneCuua(Dmt_t_sessione sessione, String cuaa, String codiceIntervento) {
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
}
