package it.csi.zoo;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.text.ParseException;

import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import it.csi.demetra.demetraws.srmanags.wsbridge2.WSBridgeInternalException_Exception;
import it.csi.demetra.demetraws.zoo.BdnWsManagerImpl;
import it.csi.demetra.demetraws.zoo.ZooApplication;
import it.csi.demetra.demetraws.zoo.calcoli.CalcoloException;
import it.csi.demetra.demetraws.zoo.controlli.visitor.ControlloException;
import it.csi.demetra.demetraws.zoo.controlli.visitor.EntityFactory;
import it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef.Controllo;
import it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef.ref03;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_ref03;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_subentro_zoo;
import it.csi.demetra.demetraws.zoo.model.Rpu_V_pratica_zoote;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_output_ref03_repository;
import it.csi.demetra.demetraws.zoo.repository.Rpu_V_pratica_zoote_repository;
import it.csi.demetra.demetraws.zoo.services.ControlliService;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_sessione_services;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_subentro_zoo_services;

/**
 * Author : Federico Pomponii
 * Suite di test per i principali 'Controlli' dell'applicativo
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ZooApplication.class)
public class ControlliFwSuiteTest {
	@Autowired
	Dmt_t_subentro_zoo_services subentroService;
	@Autowired
	private ApplicationContext applicationContext;
	@Autowired
	private Dmt_t_sessione_services sessioneService;
	@Autowired
	private BdnWsManagerImpl bdnImpl;
	@Autowired
	private ControlliService controlliService;

	private static Logger logger = LoggerFactory.getLogger(ControlliFwSuiteTest.class);

	private EntityFactory entityFactory;
	private Dmt_t_sessione sessione;
	
	@Autowired
	Rpu_V_pratica_zoote_repository aziendaRep;
	@Autowired
	Dmt_t_output_ref03_repository ref03Rep;
	@Autowired
	ref03 calcoloRef03;

	@Before
	public void init() {
		sessione = sessioneService.saveSession(new Dmt_t_sessione());
		this.entityFactory = new EntityFactory();
	}

	/*
	 * Metodo di scarico dati dalla BDN
	 */

	private Boolean scarico(String codicePremio, String cuaa, int anno, Dmt_t_sessione sessione, Dmt_t_subentro_zoo subentro) {
		try {
			bdnImpl.getElencoCapiPremio(codicePremio, cuaa, anno, sessione);
			bdnImpl.Consistenza_UBA_Censim_Ovini_2012(cuaa, "01/01/" + anno, "31/12/" + anno, "D", sessione);
			bdnImpl.Consistenza_UBA_Censim_Ovini_2012(cuaa, "01/01/" + anno, "31/12/" + anno, "P", sessione);
			bdnImpl.getAnagraficaAllevamenti(cuaa, null, codicePremio, sessione);
			if (subentro != null) {
				bdnImpl.getElencoCapiPremio2(0L, codicePremio, cuaa, subentro.getCuaaSubentro(), subentro.getAnnoCampagna(), sessione);
			}
			return true;
		} catch (JAXBException | WSBridgeInternalException_Exception | ParseException | NullPointerException e) {
			System.out.println("ERRORE: " + e.getCause());
		}
		return false;
	}

	/**
	 * Test su bovini richiesti
	 * Anno: 2018
	 * Codice premio: 310
	 */

//	@Test
//	public void TestCapiRichiestiClcInt310Mis1() {
//		String cuaa = "BBBCRL75R13L219U";
//		String cPremio = "310";
//		int anno = 2018;
//		int expRichiesti = 23;
//		Rpu_V_pratica_zoote azienda = new Rpu_V_pratica_zoote();
//		azienda.setAnnoCampagna(anno);
//		azienda.setCodicePremio(cPremio);
//		azienda.setCuaa(cuaa);
//		if (scarico(cPremio, cuaa, anno, sessione, subentroService.getSubentro(anno, cuaa))) {
//			Controllo controllo = (Controllo) applicationContext.getBean("ClcInt310Mis1");
//			controllo.setSessione(sessione);
//			controllo.setControlliService(controlliService);
//			controllo.setAzienda(azienda);
//			try {
//				controllo.preEsecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
//			} catch (CalcoloException e) {
//				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getMessage());
//			}
//			try {
//				controllo.esecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo esecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
//			}
//			try {
//				controllo.postEsecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo postEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
//			}
//			Dmt_t_output_controlli out = controlliService
//					.getOutputControlliBySessioneAndCuaaAndAnnoCampagnaAndIntervento(sessione, cuaa, Long.valueOf(anno), cPremio);
//			assertTrue(String.format("CUAA: %s\nCodice Premio: %s\nAnno: %s\nCapi richiesti(%s) non uguale a " + expRichiesti, cuaa,cPremio,anno,out.getCapiRichiesti().toString()), expRichiesti == out.getCapiRichiesti());
//		} else {
//			fail("Scarico dati non riuscito per CUAA -> " + cuaa);
//		}
//	}

	/**
	 * Test su bovini ammissibili
	 * Anno: 2018
	 * Codice premio: 310
	 */

//	@Test
//	public void TestCapiAmmissibiliClcInt310Mis1() {
//		String cuaa = "BBBCRL75R13L219U";
//		String cPremio = "310";
//		int anno = 2018;
//		BigDecimal expAmmissibili = new BigDecimal (23);
//		Rpu_V_pratica_zoote azienda = new Rpu_V_pratica_zoote();
//		azienda.setAnnoCampagna(anno);
//		azienda.setCodicePremio(cPremio);
//		azienda.setCuaa(cuaa);
//		if (scarico(cPremio, cuaa, anno, sessione, subentroService.getSubentro(anno, cuaa))) {
//			Controllo controllo = (Controllo) applicationContext.getBean("ClcInt310Mis1");
//			controllo.setSessione(sessione);
//			controllo.setControlliService(controlliService);
//			controllo.setAzienda(azienda);
//			try {
//				controllo.preEsecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
//			} catch (CalcoloException e) {
//				logger.info("Test Fallito nel metodo esecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getMessage());
//			}
//			try {
//				controllo.esecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo esecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
//			}
//			try {
//				controllo.postEsecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo postEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
//			}
//			Dmt_t_output_controlli out = controlliService
//					.getOutputControlliBySessioneAndCuaaAndAnnoCampagnaAndIntervento(sessione, cuaa, Long.valueOf(anno), cPremio);
//			assertTrue(String.format("CUAA: %s\nCodice Premio: %s\nAnno: %s\nCapi ammissibili(%s) non uguale a " + expAmmissibili, cuaa,cPremio,anno,out.getCapiAmmissibili().toString()), expAmmissibili.compareTo(out.getCapiAmmissibili()) == 0);
//		} else {
//			fail("Scarico dati non riuscito per CUAA -> " + cuaa);
//		}
//	}

	/**
	 * Test capiRichiesti su TestRef03
	 * @author Antonio Pilato
	 * Anno: 2018
	 * Codice premio: 313
	 * Cuaa: BBBCRL75R13L219U
	 */
	
	@Test
	public void TestCapiRichiestiRef03() {
		String cuaa = "BBBCRL75R13L219U";
		String cPremio = "313";
		int anno = 2018;
		BigDecimal expRichiesti = new BigDecimal(17);
		Rpu_V_pratica_zoote azienda = new Rpu_V_pratica_zoote();
		azienda.setAnnoCampagna(anno);
		azienda.setCodicePremio(cPremio);
		azienda.setCuaa(cuaa);
		if (scarico(cPremio, cuaa, anno, sessione, subentroService.getSubentro(anno, cuaa))) {
			Controllo controllo = (Controllo) applicationContext.getBean("ClcInt313Mis4");
			controllo.setSessione(sessione);
			controllo.setControlliService(controlliService);
			controllo.setAzienda(azienda);
			try {
				controllo.preEsecuzione();
				controllo.esecuzione();
				controllo.postEsecuzione();
			} catch (ControlloException e) {
				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio + " | MOTIVAZIONI: " + e.getCause() + " , " + e.getMessage());
				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
			} catch (CalcoloException e) {
				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
				fail(e.getMessage());
			}
			
			try {
			calcoloRef03.inizializzazione(sessione, controllo.getAzienda());
			calcoloRef03.esecuzione();
			} catch(CalcoloException e) {
				logger.info(e.getCause() + " | " + e.getMessage());
			}
			
			Dmt_t_output_ref03 outRef03 = ref03Rep.findCapiPagabiliByAnnoCampagnaAndCuaaAndIdSessioneAndIntervento(Integer.valueOf(anno), cuaa, sessione.getIdSessione(), cPremio);
			
			BigDecimal capiRichiesti   = new BigDecimal(outRef03.getCapiRichiesti());
			
			assertTrue(capiRichiesti.compareTo(expRichiesti) == 0);
		} else {
			fail("Scarico dati non riuscito per CUAA -> " + cuaa);
		}
	}
	
	/**
	 * Test capiAccertati su TestRef03
	 * @author Antonio Pilato
	 * Anno: 2018
	 * Codice premio: 313
	 * Cuaa: BBBCRL75R13L219U
	 */
	
	@Test
	public void TestCapiAccertatiRef03() {
		String cuaa = "BBBCRL75R13L219U";
		String cPremio = "313";
		int anno = 2018;
		BigDecimal expAccertati = new BigDecimal(16);
		Rpu_V_pratica_zoote azienda = new Rpu_V_pratica_zoote();
		azienda.setAnnoCampagna(anno);
		azienda.setCodicePremio(cPremio);
		azienda.setCuaa(cuaa);
		if (scarico(cPremio, cuaa, anno, sessione, subentroService.getSubentro(anno, cuaa))) {
			Controllo controllo = (Controllo) applicationContext.getBean("ClcInt313Mis4");
			controllo.setSessione(sessione);
			controllo.setControlliService(controlliService);
			controllo.setAzienda(azienda);
			try {
				controllo.preEsecuzione();
				controllo.esecuzione();
				controllo.postEsecuzione();
			} catch (ControlloException e) {
				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio + " | MOTIVAZIONI: " + e.getCause() + " , " + e.getMessage());
				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
			} catch (CalcoloException e) {
				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
				fail(e.getMessage());
			}
			
			try {
			calcoloRef03.inizializzazione(sessione, controllo.getAzienda());
			calcoloRef03.esecuzione();
			} catch(CalcoloException e) {
				logger.info(e.getCause() + " | " + e.getMessage());
			}
			
			Dmt_t_output_ref03 outRef03 = ref03Rep.findCapiPagabiliByAnnoCampagnaAndCuaaAndIdSessioneAndIntervento(Integer.valueOf(anno), cuaa, sessione.getIdSessione(), cPremio);
			
			BigDecimal capiAmmissibili = new BigDecimal(outRef03.getCapiAccertati());
			
			assertTrue(capiAmmissibili.compareTo(expAccertati) == 0);
		} else {
			fail("Scarico dati non riuscito per CUAA -> " + cuaa);
		}
	}
	
	/**
	 * Test capiAnomali su TestRef03
	 * @author Antonio Pilato
	 * Anno: 2018
	 * Codice premio: 313
	 * Cuaa: BBBCRL75R13L219U
	 */

	@Test
	public void TestCapiAnomaliRef03() {
		String cuaa = "BBBCRL75R13L219U";
		String cPremio = "313";
		int anno = 2018;
		BigDecimal expAnomali   = new BigDecimal(1);
		Rpu_V_pratica_zoote azienda = new Rpu_V_pratica_zoote();
		azienda.setAnnoCampagna(anno);
		azienda.setCodicePremio(cPremio);
		azienda.setCuaa(cuaa);
		if (scarico(cPremio, cuaa, anno, sessione, subentroService.getSubentro(anno, cuaa))) {
			Controllo controllo = (Controllo) applicationContext.getBean("ClcInt313Mis4");
			controllo.setSessione(sessione);
			controllo.setControlliService(controlliService);
			controllo.setAzienda(azienda);
			try {
				controllo.preEsecuzione();
				controllo.esecuzione();
				controllo.postEsecuzione();
			} catch (ControlloException e) {
				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio + " | MOTIVAZIONI: " + e.getCause() + " , " + e.getMessage());
				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
			} catch (CalcoloException e) {
				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
				fail(e.getMessage());
			}
			
			try {
			calcoloRef03.inizializzazione(sessione, controllo.getAzienda());
			calcoloRef03.esecuzione();
			} catch(CalcoloException e) {
				logger.info(e.getCause() + " | " + e.getMessage());
			}
			
			Dmt_t_output_ref03 outRef03 = ref03Rep.findCapiPagabiliByAnnoCampagnaAndCuaaAndIdSessioneAndIntervento(Integer.valueOf(anno), cuaa, sessione.getIdSessione(), cPremio);
			
			BigDecimal capiAnomali     = new BigDecimal(outRef03.getCapiAnomali());
			
			assertTrue(capiAnomali.compareTo(expAnomali) == 0);
		} else {
			fail("Scarico dati non riuscito per CUAA -> " + cuaa);
		}
	}
	
	/**
	 * Test capiPagabili su TestRef03
	 * @author Antonio Pilato
	 * Anno: 2018
	 * Codice premio: 313
	 * Cuaa: BBBCRL75R13L219U
	 */
	
	@Test
	public void TestCapiPagabiliRef03() {
		String cuaa = "BBBCRL75R13L219U";
		String cPremio = "313";
		int anno = 2018;
		BigDecimal expPagabili  = new BigDecimal(15);
		Rpu_V_pratica_zoote azienda = new Rpu_V_pratica_zoote();
		azienda.setAnnoCampagna(anno);
		azienda.setCodicePremio(cPremio);
		azienda.setCuaa(cuaa);
		if (scarico(cPremio, cuaa, anno, sessione, subentroService.getSubentro(anno, cuaa))) {
			Controllo controllo = (Controllo) applicationContext.getBean("ClcInt313Mis4");
			controllo.setSessione(sessione);
			controllo.setControlliService(controlliService);
			controllo.setAzienda(azienda);
			try {
				controllo.preEsecuzione();
				controllo.esecuzione();
				controllo.postEsecuzione();
			} catch (ControlloException e) {
				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio + " | MOTIVAZIONI: " + e.getCause() + " , " + e.getMessage());
				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
			} catch (CalcoloException e) {
				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
				fail(e.getMessage());
			}
			
			try {
			calcoloRef03.inizializzazione(sessione, controllo.getAzienda());
			calcoloRef03.esecuzione();
			} catch(CalcoloException e) {
				logger.info(e.getCause() + " | " + e.getMessage());
			}
			
			Dmt_t_output_ref03 outRef03 = ref03Rep.findCapiPagabiliByAnnoCampagnaAndCuaaAndIdSessioneAndIntervento(Integer.valueOf(anno), cuaa, sessione.getIdSessione(), cPremio);
			
			BigDecimal capiPagabili    = new BigDecimal(outRef03.getCapiPagabili());
			
			assertTrue(capiPagabili.compareTo(expPagabili) == 0);
		} else {
			fail("Scarico dati non riuscito per CUAA -> " + cuaa);
		}
	}

	/**
	 * Test su bovini ammissibili
	 * Anno: 2018
	 * Codice premio: 311
	 * @throws ControlloException 
	 */

//	@Test
//	public void TestAmmissibiliClcInt311Mis2() {
//		String cuaa = "BRCCRL50T64E973U";
//		String cPremio = "311";
//		int anno = 2018;
//		BigDecimal expAmmissibili = new BigDecimal (10);
//		Rpu_V_pratica_zoote azienda = new Rpu_V_pratica_zoote();
//		azienda.setAnnoCampagna(anno);
//		azienda.setCodicePremio(cPremio);
//		azienda.setCuaa(cuaa);
//		if (scarico(cPremio, cuaa, anno, sessione, subentroService.getSubentro(anno, cuaa))) {
//			Controllo controllo = (Controllo) applicationContext.getBean("ClcInt311Mis2");
//			controllo.setSessione(sessione);
//			controllo.setControlliService(controlliService);
//			controllo.setAzienda(azienda);
//			try {
//				controllo.preEsecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
//			} catch (CalcoloException e) {
//				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getMessage());
//			}
//			try {
//				controllo.esecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo esecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
//			}
//			try {
//				controllo.postEsecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo postEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
//			}
//			Dmt_t_output_controlli out = controlliService
//					.getOutputControlliBySessioneAndCuaaAndAnnoCampagnaAndIntervento(sessione, cuaa, Long.valueOf(anno), cPremio);
//			assertTrue(String.format("CUAA: %s\nCodice Premio: %s\nAnno: %s\nCapi ammissibili(%s) non uguale a " + expAmmissibili, cuaa,cPremio,anno,out.getCapiAmmissibili().toString()), expAmmissibili.compareTo(out.getCapiAmmissibili()) == 0);
//		} else {
//			fail("Scarico dati non riuscito per CUAA -> " + cuaa);
//		}
//	}

	/**
	 * Test su bovini richiesti
	 * Anno: 2018
	 * Codice premio: 313
	 */

//	@Test
//	public void TestRichiestiClcInt313Mis4() {
//		String cuaa = "9877230012";
//		String cPremio = "313";
//		int anno = 2018;
//		int expRichiesti = 26;
//		Rpu_V_pratica_zoote azienda = new Rpu_V_pratica_zoote();
//		azienda.setAnnoCampagna(anno);
//		azienda.setCodicePremio(cPremio);
//		azienda.setCuaa(cuaa);
//		if (scarico(cPremio, cuaa, anno, sessione, subentroService.getSubentro(anno, cuaa))) {
//			Controllo controllo = (Controllo) applicationContext.getBean("ClcInt313Mis4");
//			controllo.setSessione(sessione);
//			controllo.setControlliService(controlliService);
//			controllo.setAzienda(azienda);
//			try {
//				controllo.preEsecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
//			} catch (CalcoloException e) {
//				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getMessage());
//			}
//			try {
//				controllo.esecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo esecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
//			}
//			try {
//				controllo.postEsecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo postEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
//			}
//			Dmt_t_output_controlli out = controlliService
//					.getOutputControlliBySessioneAndCuaaAndAnnoCampagnaAndIntervento(sessione, cuaa, Long.valueOf(anno), cPremio);
//			assertTrue(String.format("CUAA: %s\nCodice Premio: %s\nAnno: %s\nCapi richiesti(%s) non uguale a " + expRichiesti, cuaa,cPremio,anno,out.getCapiRichiesti().toString()), expRichiesti == out.getCapiRichiesti());
//		} else {
//			fail("Scarico dati non riuscito per CUAA -> " + cuaa);
//		}
//	}

	/**
	 * Test su bovini ammissibili
	 * Anno: 2018
	 * Codice premio: 313
	 */

//	@Test
//	public void TestAmmissibiliClcInt313Mis4() {
//		String cuaa = "9877230012";
//		String cPremio = "313";
//		int anno = 2018;
//		BigDecimal expAmmissibili = new BigDecimal (26);
//		Rpu_V_pratica_zoote azienda = new Rpu_V_pratica_zoote();
//		azienda.setAnnoCampagna(anno);
//		azienda.setCodicePremio(cPremio);
//		azienda.setCuaa(cuaa);
//		if (scarico(cPremio, cuaa, anno, sessione, subentroService.getSubentro(anno, cuaa))) {
//			Controllo controllo = (Controllo) applicationContext.getBean("ClcInt313Mis4");
//			controllo.setSessione(sessione);
//			controllo.setControlliService(controlliService);
//			controllo.setAzienda(azienda);
//			try {
//				controllo.preEsecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());			
//			} catch (CalcoloException e) {
//				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getMessage());
//			}
//			try {
//				controllo.esecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo esecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
//			}
//			try {
//				controllo.postEsecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo postEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
//			}
//			Dmt_t_output_controlli out = controlliService
//					.getOutputControlliBySessioneAndCuaaAndAnnoCampagnaAndIntervento(sessione, cuaa, Long.valueOf(anno), cPremio);
//			System.out.println(out);
//			assertTrue(String.format("CUAA: %s\nCodice Premio: %s\nAnno: %s\nCapi ammissibili(%s) non uguale a " + expAmmissibili, cuaa,cPremio,anno,out.getCapiAmmissibili().toString()), expAmmissibili.compareTo(out.getCapiAmmissibili()) == 0);
//		} else {
//			fail("Scarico dati non riuscito per CUAA -> " + cuaa);
//		}
//	}
//
//	/**
//	 * Test su bovini richiesti
//	 * Anno: 2018
//	 * Codice premio: 314
//	 */
//
//	@Test
//	public void TestRichiestiClcInt314Mis18() {
//		String cuaa = "BNDLNZ85S06L304Y";
//		String cPremio = "314";
//		int anno = 2018;
//		int expRichiesti = 0;
//		Rpu_V_pratica_zoote azienda = new Rpu_V_pratica_zoote();
//		azienda.setAnnoCampagna(anno);
//		azienda.setCodicePremio(cPremio);
//		azienda.setCuaa(cuaa);
//		if (scarico(cPremio, cuaa, anno, sessione, subentroService.getSubentro(anno, cuaa))) {
//			Controllo controllo = (Controllo) applicationContext.getBean("ClcInt314Mis18");
//			controllo.setSessione(sessione);
//			controllo.setControlliService(controlliService);
//			controllo.setAzienda(azienda);
//			try {
//				controllo.preEsecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
//			} catch (CalcoloException e) {
//				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getMessage());
//			}
//			try {
//				controllo.esecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo esecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
//			}
//			try {
//				controllo.postEsecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo postEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
//			}
//			Dmt_t_output_controlli out = controlliService
//					.getOutputControlliBySessioneAndCuaaAndAnnoCampagnaAndIntervento(sessione, cuaa, Long.valueOf(anno), cPremio);
//			assertTrue(String.format("CUAA: %s\nCodice Premio: %s\nAnno: %s\nCapi richiesti(%s) non uguale a " + expRichiesti, cuaa,cPremio,anno,out.getCapiRichiesti().toString()), expRichiesti == out.getCapiRichiesti());
//		} else {
//			fail("Scarico dati non riuscito per CUAA -> " + cuaa);
//		}
//	}
//
//	/**
//	 * Test su bovini ammissibili 
//	 * Anno: 2018
//	 * Codice premio: 314
//	 */
//
//	@Test
//	public void TestAmmissibiliClcInt314Mis18() {
//		String cuaa = "BNDLNZ85S06L304Y";
//		String cPremio = "314";
//		int anno = 2018;
//		BigDecimal expAmmissibili = new BigDecimal(1);
//		Rpu_V_pratica_zoote azienda = new Rpu_V_pratica_zoote();
//		azienda.setAnnoCampagna(anno);
//		azienda.setCodicePremio(cPremio);
//		azienda.setCuaa(cuaa);
//		if (scarico(cPremio, cuaa, anno, sessione, subentroService.getSubentro(anno, cuaa))) {
//			Controllo controllo = (Controllo) applicationContext.getBean("ClcInt314Mis18");
//			controllo.setSessione(sessione);
//			controllo.setControlliService(controlliService);
//			controllo.setAzienda(azienda);
//			try {
//				controllo.preEsecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
//			} catch (CalcoloException e) {
//				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getMessage());
//			}
//			try {
//				controllo.esecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo esecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
//			}
//			try {
//				controllo.postEsecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo postEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
//			}
//			Dmt_t_output_controlli out = controlliService
//					.getOutputControlliBySessioneAndCuaaAndAnnoCampagnaAndIntervento(sessione, cuaa, Long.valueOf(anno), cPremio);
//			assertTrue(String.format("CUAA: %s\nCodice Premio: %s\nAnno: %s\nCapi ammissibili(%s) non uguale a " + expAmmissibili, cuaa,cPremio,anno,out.getCapiAmmissibili().toString()), expAmmissibili.compareTo(out.getCapiAmmissibili()) == 0);
//		} else {
//			fail("Scarico dati non riuscito per CUAA -> " + cuaa);
//		}
//	}
//
//	/**
//	 * Test su bovini richiesti
//	 * Anno: 2018
//	 * Codice premio: 315
//	 */
//
//	@Test
//	public void TestRichiestiClcInt315Mis5() {
//		String cuaa = "SCNLRT90S14C589D";
//		String cPremio = "315";
//		int anno = 2018;
//		int expRichiesti = 0;
//		Rpu_V_pratica_zoote azienda = new Rpu_V_pratica_zoote();
//		azienda.setAnnoCampagna(anno);
//		azienda.setCodicePremio(cPremio);
//		azienda.setCuaa(cuaa);
//		if (scarico(cPremio, cuaa, anno, sessione, subentroService.getSubentro(anno, cuaa))) {
//			Controllo controllo = (Controllo) applicationContext.getBean("ClcInt315Mis5");
//			controllo.setSessione(sessione);
//			controllo.setControlliService(controlliService);
//			controllo.setAzienda(azienda);
//			try {
//				controllo.preEsecuzione();
//			} catch (ControlloException e) {
//				e.printStackTrace();
//				//                fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
//			} catch (CalcoloException e) {
//				//                fail(e.getMessage());
//			}
//			try {
//				controllo.esecuzione();
//			} catch (ControlloException e) {
//				e.printStackTrace();
//			}
//			try {
//				controllo.postEsecuzione();
//			} catch (ControlloException e) {
//				e.printStackTrace();
//			}
//			Dmt_t_output_controlli out = controlliService
//					.getOutputControlliBySessioneAndCuaaAndAnnoCampagnaAndIntervento(sessione, cuaa, Long.valueOf(anno), cPremio);
//			System.out.println(out);
//			assertTrue(String.format("CUAA: %s\nCodice Premio: %s\nAnno: %s\nCapi richiesti(%s) non uguale a " + expRichiesti, cuaa,cPremio,anno,out.getCapiRichiesti().toString()), expRichiesti == out.getCapiRichiesti());
//		} else {
//			fail("Scarico dati non riuscito per CUAA -> " + cuaa);
//		}
//	}
//
//	/**
//	 * Test su bovini ammissibili
//	 * Anno: 2018
//	 * Codice premio: 315
//	 */
//
//	@Test
//	public void TestAmmissibiliClcInt315Mis5() {
//		String cuaa = "BRBRNN48E70L048G";
//		String cPremio = "315";
//		int anno = 2018;
//		BigDecimal expAmmissibili = new BigDecimal(0);
//		Rpu_V_pratica_zoote azienda = new Rpu_V_pratica_zoote();
//		azienda.setAnnoCampagna(anno);
//		azienda.setCodicePremio(cPremio);
//		azienda.setCuaa(cuaa);
//		if (scarico(cPremio, cuaa, anno, sessione, subentroService.getSubentro(anno, cuaa))) {
//			Controllo controllo = (Controllo) applicationContext.getBean("ClcInt315Mis5");
//			controllo.setSessione(sessione);
//			controllo.setControlliService(controlliService);
//			controllo.setAzienda(azienda);
//			try {
//				controllo.preEsecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
//			} catch (CalcoloException e) {
//				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getMessage());
//			}
//			try {
//				controllo.esecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo esecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
//			}
//			try {
//				controllo.postEsecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo postEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
//			}
//			Dmt_t_output_controlli out = controlliService
//					.getOutputControlliBySessioneAndCuaaAndAnnoCampagnaAndIntervento(sessione, cuaa, Long.valueOf(anno), cPremio);
//			assertTrue(String.format("CUAA: %s\nCodice Premio: %s\nAnno: %s\nCapi ammissibili(%s) non uguale a " + expAmmissibili, cuaa,cPremio,anno,out.getCapiAmmissibili().toString()), expAmmissibili.compareTo(out.getCapiAmmissibili()) == 0);
//		} else {
//			fail("Scarico dati non riuscito per CUAA -> " + cuaa);
//		}
//	}
//
//	/**
//	 * Test su bovini richiesti
//	 * Anno: 2018
//	 * Codice premio: 316
//	 */
//
//	@Test
//	public void TestRichiestiClcInt316Mis19() {
//		String cuaa = "BBBDNC67P61L219R";
//		String cPremio = "316";
//		int anno = 2018;
//		int expRichiesti = 2;
//		Rpu_V_pratica_zoote azienda = new Rpu_V_pratica_zoote();
//		azienda.setAnnoCampagna(anno);
//		azienda.setCodicePremio(cPremio);
//		azienda.setCuaa(cuaa);
//		if (scarico(cPremio, cuaa, anno, sessione, subentroService.getSubentro(anno, cuaa))) {
//			Controllo controllo = (Controllo) applicationContext.getBean("ClcInt316Mis19");
//			controllo.setSessione(sessione);
//			controllo.setControlliService(controlliService);
//			controllo.setAzienda(azienda);
//			try {
//				controllo.preEsecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
//			} catch (CalcoloException e) {
//				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getMessage());
//			}
//			try {
//				controllo.esecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo esecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
//			}
//			try {
//				controllo.postEsecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo postEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());			
//			}
//			Dmt_t_output_controlli out = controlliService
//					.getOutputControlliBySessioneAndCuaaAndAnnoCampagnaAndIntervento(sessione, cuaa, Long.valueOf(anno), cPremio);
//			assertTrue(String.format("CUAA: %s\nCodice Premio: %s\nAnno: %s\nCapi richiesti(%s) non uguale a " + expRichiesti, cuaa,cPremio,anno,out.getCapiRichiesti().toString()), expRichiesti == out.getCapiRichiesti());
//		} else {
//			fail("Scarico dati non riuscito per CUAA -> " + cuaa);
//		}
//	}
//
//	/**
//	 * Test su bovini ammissibili
//	 * Anno: 2018
//	 * Codice premio: 316
//	 */
//
//	@Test
//	public void TestAmmissibiliClcInt316Mis19() {
//		String cuaa = "BRBVCN63M29D205G";
//		String cPremio = "316";
//		int anno = 2018;
//		BigDecimal expAmmissibili = new BigDecimal(2);
//		Rpu_V_pratica_zoote azienda = new Rpu_V_pratica_zoote();
//		azienda.setAnnoCampagna(anno);
//		azienda.setCodicePremio(cPremio);
//		azienda.setCuaa(cuaa);
//		if (scarico(cPremio, cuaa, anno, sessione, subentroService.getSubentro(anno, cuaa))) {
//			Controllo controllo = (Controllo) applicationContext.getBean("ClcInt316Mis19");
//			controllo.setSessione(sessione);
//			controllo.setControlliService(controlliService);
//			controllo.setAzienda(azienda);
//			try {
//				controllo.preEsecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());				
//			} catch (CalcoloException e) {
//				logger.info("Test Fallito nel metodo esecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getMessage());
//			}
//			try {
//				controllo.esecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo esecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());			
//			}
//			try {
//				controllo.postEsecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo postEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());			
//			}			
//			Dmt_t_output_controlli out = controlliService
//					.getOutputControlliBySessioneAndCuaaAndAnnoCampagnaAndIntervento(sessione, cuaa, Long.valueOf(anno), cPremio);
//			assertTrue(String.format("CUAA: %s\nCodice Premio: %s\nAnno: %s\nCapi ammissibili(%s) non uguale a " + expAmmissibili, cuaa,cPremio,anno,out.getCapiAmmissibili().toString()), expAmmissibili.compareTo(out.getCapiAmmissibili()) == 0);
//		} else {
//			fail("Scarico dati non riuscito per CUAA -> " + cuaa);
//		}
//	}
//
//	/**
//	 * Test su bovini richiesti
//	 * Anno: 2018
//	 * Codice premio: 318
//	 */
//
//	@Test
//	public void TestRichiestiClcInt318Mis19() {
//		String cuaa = "BRBVCN63M29D205G";
//		String cPremio = "318";
//		int anno = 2018;
//		int expRichiesti = 2;
//		Rpu_V_pratica_zoote azienda = new Rpu_V_pratica_zoote();
//		azienda.setAnnoCampagna(anno);
//		azienda.setCodicePremio(cPremio);
//		azienda.setCuaa(cuaa);
//		if (scarico(cPremio, cuaa, anno, sessione, subentroService.getSubentro(anno, cuaa))) {
//			Controllo controllo = (Controllo) applicationContext.getBean("ClcInt318Mis19");
//			controllo.setSessione(sessione);
//			controllo.setControlliService(controlliService);
//			controllo.setAzienda(azienda);
//			try {
//				controllo.preEsecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());			
//			} catch (CalcoloException e) {
//				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getMessage());			
//			}
//			try {
//				controllo.esecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo esecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());			
//			}
//			try {
//				controllo.postEsecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo postEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
//			}
//			Dmt_t_output_controlli out = controlliService
//					.getOutputControlliBySessioneAndCuaaAndAnnoCampagnaAndIntervento(sessione, cuaa, Long.valueOf(anno), cPremio);
//			assertTrue(String.format("CUAA: %s\nCodice Premio: %s\nAnno: %s\nCapi richiesti(%s) non uguale a " + expRichiesti, cuaa,cPremio,anno,out.getCapiRichiesti().toString()), expRichiesti == out.getCapiRichiesti());
//		} else {
//			fail("Scarico dati non riuscito per CUAA -> " + cuaa);
//		}
//	}
//
//	/**
//	 * Test su bovini ammissibili
//	 * Anno: 2018
//	 * Codice premio: 318
//	 */
//
//	@Test
//	public void TestAmmissibiliClcInt318Mis19() {
//		String cuaa = "BRBVCN63M29D205G";
//		String cPremio = "318";
//		int anno = 2018;
//		BigDecimal expAmmissibili = new BigDecimal(2);
//		Rpu_V_pratica_zoote azienda = new Rpu_V_pratica_zoote();
//		azienda.setAnnoCampagna(anno);
//		azienda.setCodicePremio(cPremio);
//		azienda.setCuaa(cuaa);
//		if (scarico(cPremio, cuaa, anno, sessione, subentroService.getSubentro(anno, cuaa))) {
//			Controllo controllo = (Controllo) applicationContext.getBean("ClcInt318Mis19");
//			controllo.setSessione(sessione);
//			controllo.setControlliService(controlliService);
//			controllo.setAzienda(azienda);
//			try {
//				controllo.preEsecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
//			} catch (CalcoloException e) {
//				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getMessage());
//			}
//			try {
//				controllo.esecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo esecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());;
//			}
//			try {
//				controllo.postEsecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo postEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());			
//			}
//			Dmt_t_output_controlli out = controlliService
//					.getOutputControlliBySessioneAndCuaaAndAnnoCampagnaAndIntervento(sessione, cuaa, Long.valueOf(anno), cPremio);
//			assertTrue(String.format("CUAA: %s\nCodice Premio: %s\nAnno: %s\nCapi ammissibili(%s) non uguale a " + expAmmissibili, cuaa,cPremio,anno,out.getCapiAmmissibili().toString()), expAmmissibili.compareTo(out.getCapiAmmissibili()) == 0);
//		} else {
//			fail("Scarico dati non riuscito per CUAA -> " + cuaa);
//		}
//	}
//
//	/**
//	 * Test su bovini richiesti
//	 * Anno: 2018
//	 * Codice premio: 320
//	 */
//
//	@Test
//	public void TestRichiestiClcInt320Mis6() {
//		String cuaa = "BRCCRL50T64E973U";
//		String cPremio = "320";
//		int anno = 2018;
//		int expRichiesti = 4;
//		Rpu_V_pratica_zoote azienda = new Rpu_V_pratica_zoote();
//		azienda.setAnnoCampagna(anno);
//		azienda.setCodicePremio(cPremio);
//		azienda.setCuaa(cuaa);
//		if (scarico(cPremio, cuaa, anno, sessione, subentroService.getSubentro(anno, cuaa))) {
//			Controllo controllo = (Controllo) applicationContext.getBean("ClcInt320Mis6");
//			controllo.setSessione(sessione);
//			controllo.setControlliService(controlliService);
//			controllo.setAzienda(azienda);
//			try {
//				controllo.preEsecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());			
//			} catch (CalcoloException e) {
//				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getMessage());
//			}
//			try {
//				controllo.esecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo esecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());			
//			}
//			try {
//				controllo.postEsecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo potEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());			
//			}
//			Dmt_t_output_controlli out = controlliService
//					.getOutputControlliBySessioneAndCuaaAndAnnoCampagnaAndIntervento(sessione, cuaa, Long.valueOf(anno), cPremio);
//			assertTrue(String.format("CUAA: %s\nCodice Premio: %s\nAnno: %s\nCapi richiesti(%s) non uguale a " + expRichiesti, cuaa,cPremio,anno,out.getCapiRichiesti().toString()), expRichiesti == out.getCapiRichiesti());
//		} else {
//			fail("Scarico dati non riuscito per CUAA -> " + cuaa);
//		}
//	}
//
//	/**
//	 * Test su bovini ammissibili
//	 * Anno: 2018
//	 * Codice premio: 320
//	 */
//
//	@Test
//	public void TestAmmissibiliClcInt320Mis6() {
//		String cuaa = "BRCCRL50T64E973U";
//		String cPremio = "320";
//		int anno = 2018;
//		BigDecimal expAmmissibili = new BigDecimal(2);
//		Rpu_V_pratica_zoote azienda = new Rpu_V_pratica_zoote();
//		azienda.setAnnoCampagna(anno);
//		azienda.setCodicePremio(cPremio);
//		azienda.setCuaa(cuaa);
//		if (scarico(cPremio, cuaa, anno, sessione, subentroService.getSubentro(anno, cuaa))) {
//			Controllo controllo = (Controllo) applicationContext.getBean("ClcInt320Mis6");
//			controllo.setSessione(sessione);
//			controllo.setControlliService(controlliService);
//			controllo.setAzienda(azienda);
//			try {
//				controllo.preEsecuzione();
//			} catch (ControlloException e) {
//				e.printStackTrace();
//				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());			
//			} catch (CalcoloException e) {
//				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getMessage());
//			}
//			try {
//				controllo.esecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo secuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());			
//			}
//			try {
//				controllo.postEsecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo postEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());			
//			}
//			Dmt_t_output_controlli out = controlliService
//					.getOutputControlliBySessioneAndCuaaAndAnnoCampagnaAndIntervento(sessione, cuaa, Long.valueOf(anno), cPremio);
//			assertTrue(String.format("CUAA: %s\nCodice Premio: %s\nAnno: %s\nCapi ammissibili(%s) non uguale a " + expAmmissibili, cuaa,cPremio,anno,out.getCapiAmmissibili().toString()), expAmmissibili.compareTo(out.getCapiAmmissibili()) == 0);
//		} else {
//			fail("Scarico dati non riuscito per CUAA -> " + cuaa);
//		}
//	}
//
//	/**
//	 * Test su bovini richiesti
//	 * Anno: 2018
//	 * Codice premio: 322
//	 */
//
//	@Test
//	public void TestRichiestiClcInt322Mis20() {
//		String cuaa = "BRBRRT70D65H037C";
//		String cPremio = "322";
//		int anno = 2018;
//		int expRichiesti = 4;
//		Rpu_V_pratica_zoote azienda = new Rpu_V_pratica_zoote();
//		azienda.setAnnoCampagna(anno);
//		azienda.setCodicePremio(cPremio);
//		azienda.setCuaa(cuaa);
//		if (scarico(cPremio, cuaa, anno, sessione, subentroService.getSubentro(anno, cuaa))) {
//			Controllo controllo = (Controllo) applicationContext.getBean("ClcInt322Mis20");
//			controllo.setSessione(sessione);
//			controllo.setControlliService(controlliService);
//			controllo.setAzienda(azienda);
//			try {
//				controllo.preEsecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
//			} catch (CalcoloException e) {
//				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getMessage());
//			}
//			try {
//				controllo.esecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo esecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());			
//			}
//			try {
//				controllo.postEsecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo postEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
//			}
//			Dmt_t_output_controlli out = controlliService
//					.getOutputControlliBySessioneAndCuaaAndAnnoCampagnaAndIntervento(sessione, cuaa, Long.valueOf(anno), cPremio);
//			assertTrue(String.format("CUAA: %s\nCodice Premio: %s\nAnno: %s\nCapi richiesti(%s) non uguale a " + expRichiesti, cuaa,cPremio,anno,out.getCapiRichiesti().toString()), expRichiesti == out.getCapiRichiesti());
//		} else {
//			fail("Scarico dati non riuscito per CUAA -> " + cuaa);
//		}
//	}
//
//	/**
//	 * Test su bovini ammissibili
//	 * Anno: 2018
//	 * Codice premio: 322
//	 */
//
//	@Test
//	public void TestAmmissibiliClcInt322Mis20() {
//		String cuaa = "BRBRRT70D65H037C";
//		String cPremio = "322";
//		int anno = 2018;
//		BigDecimal expAmmissibili = new BigDecimal(4);
//		Rpu_V_pratica_zoote azienda = new Rpu_V_pratica_zoote();
//		azienda.setAnnoCampagna(anno);
//		azienda.setCodicePremio(cPremio);
//		azienda.setCuaa(cuaa);
//		if (scarico(cPremio, cuaa, anno, sessione, subentroService.getSubentro(anno, cuaa))) {
//			Controllo controllo = (Controllo) applicationContext.getBean("ClcInt322Mis20");
//			controllo.setSessione(sessione);
//			controllo.setControlliService(controlliService);
//			controllo.setAzienda(azienda);
//			try {
//				controllo.preEsecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
//			} catch (CalcoloException e) {
//				logger.info("Test Fallito nel metodo preEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getMessage());
//			}
//			try {
//				controllo.esecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo esecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());			
//			}
//			try {
//				controllo.postEsecuzione();
//			} catch (ControlloException e) {
//				logger.info("Test Fallito nel metodo postEsecuzione CUAA: " + cuaa + " |" + " CODICE PREMIO: " + cPremio);
//				fail(e.getErrore() != null ? e.getErrore().getErroreDesc() : e.getMessage());
//			}
//			Dmt_t_output_controlli out = controlliService
//					.getOutputControlliBySessioneAndCuaaAndAnnoCampagnaAndIntervento(sessione, cuaa, Long.valueOf(anno), cPremio);
//			assertTrue(String.format("CUAA: %s\nCodice Premio: %s\nAnno: %s\nCapi ammissibili(%s) non uguale a " + expAmmissibili, cuaa,cPremio,anno,out.getCapiAmmissibili().toString()), expAmmissibili.compareTo(out.getCapiAmmissibili()) == 0);
//		} else {
//			fail("Scarico dati non riuscito per CUAA -> " + cuaa);
//		}
//	}
}
