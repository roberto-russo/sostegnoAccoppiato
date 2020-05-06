package it.csi.zoo.calcoli;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.csi.demetra.demetraws.zoo.ZooApplication;
import it.csi.demetra.demetraws.zoo.calcoli.CalcoloException;
import it.csi.demetra.demetraws.zoo.calcoli.CtlAgnelleDaRimonta;
import it.csi.demetra.demetraws.zoo.calcoli.entity.CalcoloAgnelleDaRimontaPremioIn;
import it.csi.demetra.demetraws.zoo.calcoli.entity.CapiControllati9902;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_DsUBA_censimenti_allevamenti_ovini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_ovicaprini;
import it.csi.demetra.demetraws.zoo.model.Rpu_V_pratica_zoote;
import it.csi.demetra.demetraws.zoo.repository.Dmt_t_AgnelleRimonta_repository;
import it.csi.demetra.demetraws.zoo.services.AziendaService;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_DsUBA_censimenti_allevamenti_ovini_services;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_AgnelleRimonta_services;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_Tws_bdn_du_capi_ovicaprini_services;
import it.csi.demetra.demetraws.zoo.shared.Constants;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ZooApplication.class)
public class Ref9902TestCase {
	
	public static List<String> livelliScrapie = Stream.of("L1", "L2", "L3").collect(Collectors.toList());
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	CtlAgnelleDaRimonta ref9902Calcolo = new CtlAgnelleDaRimonta();
	
	@Mock
	Dmt_t_Tws_bdn_du_capi_ovicaprini_services bdnCapiOvicapriniService;
	
	@Mock
	AziendaService aziendaService;
	
	
	@Spy
	@Autowired
	Dmt_t_AgnelleRimonta_services ref9902Service;
	
	@Autowired

	Dmt_t_AgnelleRimonta_repository ref9902Repository;


	@Mock
	Dmt_t_DsUBA_censimenti_allevamenti_ovini_services ubaCensimentiOviniService;
	



	 @Before
    public void init() {
		 MockitoAnnotations.initMocks(this);
//		when(praticaZooteRepository.findByCodiciPremioAndAnnoCampagna(Mockito.isA(List.class), Mockito.isA(Integer.class))).thenReturn(aziendeSupplier.get());
//
//		when(censimOviniRepository.findByIdSessioneAndCodiceAzienda(Mockito.isA(Long.class), Mockito.isA(String.class))).thenReturn(dsUBaCensimOviniSupplier.get());
//    
//		when(bdnCapiOvicapriniRepository.findByIdSessionAndCuaa(Mockito.isA(Long.class), Mockito.isA(String.class))).thenReturn(bdnCapiOvicapriniSupplier.get());
//		
		
		when(aziendaService.getByCodiciPremioAndAnnoCampagna(Mockito.isA(List.class), Mockito.isA(Integer.class))).thenReturn(aziendeSupplier.get());

		when(ubaCensimentiOviniService.getCensimOviniByIdSessioneAndCodiceAzienda(Mockito.isA(Long.class), Mockito.isA(String.class))).thenReturn(dsUBaCensimOviniSupplier.get());
    
		//when(bdnCapiOvicapriniService.getCapiOvicapriniBdnByIdSessioneAndCuaa(Mockito.isA(Long.class), Mockito.isA(String.class))).thenReturn(bdnCapiOvicapriniSupplier.get());
		
		// testSingleCuaaPreEsecuzioneError mocking
		when(ubaCensimentiOviniService.getCensimOviniByIdSessioneAndCodiceAzienda(Mockito.eq(3L), Mockito.eq("GHGFNC64M66D969A"))).thenReturn(null);
		//when(bdnCapiOvicapriniService.getCapiOvicapriniBdnByIdSessioneAndCuaa(Mockito.eq(3L), Mockito.eq("GHGFNC64M66D969A"))).thenReturn(null);


		// missing livello scrapie test case mocking
		when(ubaCensimentiOviniService.getCensimOviniByIdSessioneAndCodiceAzienda(Mockito.isA(Long.class), Mockito.eq("GHGFNC64M66D969C"))).thenReturn(wrongDsUBaCensimOviniSupplier.get());

		
	 }
	 

	
	
	@Test
	public void testSingleCuaaSuccess() {
		
		Long idSessione = 3L;
		String cuaa = "GHGFNC64M66D969R";
		Long annoCampagna = 2020L;
		String codIntervento = "320";
		
//		ref9902Calcolo = new CtlAgnelleDaRimonta(idSessione, codIntervento, annoCampagna, cuaa);
		ref9902Calcolo.setIdSessione(idSessione);
		ref9902Calcolo.setCuaa(cuaa);
		ref9902Calcolo.setAnnoCampagna(annoCampagna);
		ref9902Calcolo.setCodIntrervento(codIntervento);
		

	
		//  PRE-ESECUZIONE
		try {
			ref9902Calcolo.preEsecuzione();
			
			CalcoloAgnelleDaRimontaPremioIn calcoloAgnelleDaRimontaPremioIn = ref9902Calcolo.getCalcoloAgnelleDaRimontaIn();
		
			assertNotNull("calcoloAgnelleDaRimontaPremioIn is null", calcoloAgnelleDaRimontaPremioIn);
			
		} catch (CalcoloException ex) {
			fail("calcoloException caught during preEsecuzione  " + ex.getMessage());
		}
		
		// ESECUZIONE
		try {
			ref9902Calcolo.esecuzione();
			
			CapiControllati9902 capiControllati9902 = ref9902Calcolo.getCapiControllati9902();
			
			assertNotNull("capiControllati9902 is null", capiControllati9902);

			
		} catch (CalcoloException ex) {
			fail("calcoloException caught during esecuzione  " + ex.getMessage());

		}
		
		// POST-ESECUZIONE
		try {
			ref9902Calcolo.postEsecuzione();

		} catch (CalcoloException ex) {
			fail("calcoloException caught during post-esecuzione  " + ex.getMessage());

		}

	}
	
	
	@Test
	public void testSingleCuaaCalcoloSuccess() {
		
		Long idSessione = 3L;
		String cuaa = "02823470360";
		Long annoCampagna = 2020L;
		String codIntervento = "320";
		
//		ref9902Calcolo = new CtlAgnelleDaRimonta(idSessione, codIntervento, annoCampagna, cuaa);
		ref9902Calcolo.setIdSessione(idSessione);
		ref9902Calcolo.setCuaa(cuaa);
		ref9902Calcolo.setAnnoCampagna(annoCampagna);
		ref9902Calcolo.setCodIntrervento(codIntervento);
		

	
		//  PRE-ESECUZIONE
		try {
			ref9902Calcolo.calcolo();
			
			CapiControllati9902 capiControllati9902 = ref9902Calcolo.getCapiControllati9902();
			
			assertNotNull("capiControllati9902 is null", capiControllati9902);

			
		} catch (CalcoloException ex) {
			fail("calcoloException caught during calcolo  " + ex.getMessage());
		}
		


	}
	
	
	@Test
	public void testSingleCuaaPreEsecuzioneError() {
		
		Long idSessione = 3L;
		String cuaa = "GHGFNC64M66D969A";
		String codIntervento = "320";
		Long annoCampagna = 2020L;
		
//		ref9902Calcolo = new CtlAgnelleDaRimonta(idSessione, codIntervento, annoCampagna, cuaa);
		
		ref9902Calcolo.setIdSessione(idSessione);
		ref9902Calcolo.setCuaa(cuaa);
		ref9902Calcolo.setAnnoCampagna(annoCampagna);
		ref9902Calcolo.setCodIntrervento(codIntervento);
		
		boolean ok = false;
	
		//  PRE-ESECUZIONE
		try {
			ref9902Calcolo.preEsecuzione();
			
		} catch (CalcoloException ex) {
			if (ex.getMessage().contains("Non è possibile effettuare il calcolo per idSessione")) 
				ok = true;
		}
		
		assertTrue(ok);
	}
	
	@Test
	public void testSingleCuaaEsecuzioneError() {
		
		Long idSessione = 3L;
		String cuaa = "GHGFNC64M66D969R";
		String codIntervento = "320";
		
		
		boolean ok = false;
		
		ref9902Calcolo.init(idSessione, codIntervento, null, cuaa);
		try {
			ref9902Calcolo.calcolo();
		} catch (Exception ex) {
			
			if (ex.getMessage().contains("campi obbligatori non valorizzati"))
				ok = true;
			
		}
		
		
		assertTrue(ok);
		
	
	}
	
	@Test
	public void testMissingLivelloScrapiePreEsecuzioneError() {
		
		Long idSessione = 3L;
		String cuaa = "GHGFNC64M66D969C";
		String codIntervento = "320";
		Long annoCampagna = 2020L;
		
		ref9902Calcolo.setIdSessione(idSessione);
		ref9902Calcolo.setCuaa(cuaa);
		ref9902Calcolo.setAnnoCampagna(annoCampagna);
		ref9902Calcolo.setCodIntrervento(codIntervento);
		
		try {
			ref9902Calcolo.preEsecuzione();
		} catch (Exception ex) {
			
			assertTrue(ex.getMessage().contains("Non è possibile effettuare il calcolo per idSessione"));

			
		}
		
		assertNotNull("capiControllati9902 is null ", ref9902Calcolo.getCapiControllati9902());
		
		assertTrue(ref9902Calcolo.getCapiControllati9902().getMotivazioni().contains("livello scrapie non presente"), "livello scrapie presente");

		
	
	}
	

	

	@Test
	public void testMultipleCuaaCalculus() {
		
		Long idSessione = 2L;
		
		ref9902Calcolo.setIdSessione(idSessione);
		
		try {
			List<CapiControllati9902> listaCapiControllati9902 = ref9902Calcolo.calcoloMassivo();
			
			assertNotNull("listaCapiControllati9902 is null", listaCapiControllati9902);
			
		} catch (Exception ex) {
			
			fail("calcoloException caught during calcoloMassivo  " + ex.getMessage());

			
		}
		
	}
	
	public Supplier<Rpu_V_pratica_zoote> aziendaSupplier = () -> {
		Rpu_V_pratica_zoote res = new Rpu_V_pratica_zoote();
		List<String> cuaaList = Stream.of(
				  "GHGFNC64M66D969R"
				, "02823470360"
				, "03563870363"
				, "ZNSLGU59D12I473E")
				.collect(Collectors.toList());
		
		
		res.setAnnoCampagna(2020);
		res.setCodicePremio(Constants.PREMIO_320);
		res.setCodiceMisura(Constants.PREMIO_320);
		
		Random rand = new Random();
	    String cuaa = cuaaList.get(rand.nextInt(cuaaList.size()));
		res.setCuaa(cuaa);
		
		
		return res;
	};
	
	public Supplier<List<Rpu_V_pratica_zoote>> aziendeSupplier = () -> {
		IntStream stream = IntStream.range(0, 3); 
		List<Rpu_V_pratica_zoote> result = new ArrayList<>();
		stream.forEach(x -> {
			result.add(aziendaSupplier.get());
		});
		
		
		return result;
		
	};
	
	public Supplier<List<Dmt_t_DsUBA_censimenti_allevamenti_ovini>> dsUBaCensimOviniSupplier = () -> {
		List<Dmt_t_DsUBA_censimenti_allevamenti_ovini> result = new ArrayList<>();
		
		Dmt_t_DsUBA_censimenti_allevamenti_ovini dsUbaCensimOvini = new Dmt_t_DsUBA_censimenti_allevamenti_ovini();
		dsUbaCensimOvini.setoCapiTot(new BigDecimal(70L));
		
		Random rand = new Random();
	    String livelloScrapie = livelliScrapie.get(rand.nextInt(livelliScrapie.size()));
		dsUbaCensimOvini.setCodQualificaScrapie(livelloScrapie);
		
		result.add(dsUbaCensimOvini);
		return result;
		
	};
	
	public Supplier<List<Dmt_t_DsUBA_censimenti_allevamenti_ovini>> wrongDsUBaCensimOviniSupplier = () -> {
		List<Dmt_t_DsUBA_censimenti_allevamenti_ovini> result = new ArrayList<>();
		
		Dmt_t_DsUBA_censimenti_allevamenti_ovini dsUbaCensimOvini = new Dmt_t_DsUBA_censimenti_allevamenti_ovini();
		dsUbaCensimOvini.setoCapiTot(new BigDecimal(70L));
		
		result.add(dsUbaCensimOvini);
		return result;
		
	};
	
	
	public Supplier<List<Dmt_t_Tws_bdn_du_capi_ovicaprini>> bdnCapiOvicapriniSupplier = () -> {
		List<Dmt_t_Tws_bdn_du_capi_ovicaprini> result = new ArrayList<>();
		
		IntStream stream = IntStream.range(0, 100); 
		
		stream.forEach(x -> {
			result.add(new Dmt_t_Tws_bdn_du_capi_ovicaprini());
		});
		
		
		return result;
		
	};
	

	
	
	
	
	
}
