package it.csi.zoo.repositories;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.csi.demetra.demetraws.zoo.ZooApplication;
import it.csi.demetra.demetraws.zoo.model.Rpu_V_pratica_zoote;
import it.csi.demetra.demetraws.zoo.repository.Rpu_V_pratica_zoote_repository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ZooApplication.class)
public class Rpu_V_pratica_zoote_repository_TestCase {
	
	@Autowired
	Rpu_V_pratica_zoote_repository rpuVPraticaZooteRepository;
	
	@Test
	public void loadApplicationContext() {
		
	}
	
	@Test
	public void findByCodiciPremioAndAnnoCampagnaTest() {
		List<String> codiciPremio = Stream.of("320", "312").collect(Collectors.toList());
		List<Rpu_V_pratica_zoote> result = rpuVPraticaZooteRepository.findByCodiciPremioAndAnnoCampagna(codiciPremio, 2020);
		
		assertNotNull(result);
		assertTrue(!result.isEmpty());
		
	}
	
	

}
