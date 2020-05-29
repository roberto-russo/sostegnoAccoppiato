package it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_bovini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_ovicaprini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_clsCapoMacellato;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_errore;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_importo_unitario;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_ref03;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;
import it.csi.demetra.demetraws.zoo.model.Rpu_V_pratica_zoote;
import it.csi.demetra.demetraws.zoo.services.ControlliService;

/**
 * classe per il calcolo della quota pagabile per premio.
 * @author Bcsoft
 *
 */

@Component("ref03")
public class ref03 {

	private Rpu_V_pratica_zoote azienda;
	private Dmt_t_sessione sessione;
	private static final Logger LOGGER = LoggerFactory.getLogger(ref03.class);

	@Autowired
	ControlliService controlliService;

	/**
	 * inizializzatore delle variabili di classe.
	 * @param sessione
	 * @param azienda
	 */
	public void inizializzazione(Dmt_t_sessione sessione, Rpu_V_pratica_zoote azienda) {
		this.azienda = azienda;
		this.sessione = sessione;
	}

	/**
	 * metodo in cui viene eseguito l'algoritmo. Attraverso l'uso dei capi salvati a db e dei codici premio richiesti dall'azienda posta in esame
	 * viene calcolato il numero di capi pagabili, la quota pagata, l'esito del calcolo e la percentuale di riduzione premio. 
	 */
	public void esecuzione() {

		LOGGER.info("inizio esecuzione()");
		
		Dmt_t_output_ref03 outputCalcolo = null;
		List<Dmt_t_Tws_bdn_du_capi_bovini> listaCapiBovini = this.controlliService
				.getCapiBoviniDaCuaaAndIdSessione(this.sessione.getIdSessione(), this.azienda.getCuaa());
		List<Dmt_t_clsCapoMacellato> listaCapiMacellati = this.controlliService
				.getCapiMacellatiDaCuaaAndIdSessione(this.sessione.getIdSessione(), this.azienda.getCuaa());
		List<Dmt_t_Tws_bdn_du_capi_ovicaprini> listaCapiOvicaprini = this.controlliService
				.getCapiOvicapriniDaCuaaAndIdSessione(this.sessione.getIdSessione(), this.azienda.getCuaa());
		List<String> codiciPremio = this.controlliService.getCodicePremioPerCuaa(this.azienda.getCuaa());
		int capiAnomali = 0;
		int capiAccertati = 0;
		int capiRichiesti = 0;
		double esito = 0;
		double percentualeRiduzione = 0;
		double capiPagabili = 0;
		double importoPagato = 0;
		HashMap<String, List<Long>> capiPerPremio = new HashMap<String, List<Long>>();
		int[] result = new int[3];

		
		capiPerPremio = buildMap(listaCapiBovini, listaCapiOvicaprini, listaCapiMacellati, codiciPremio);

		

		capiPerPremio = updateMap(capiPerPremio);

		
		for (String cp : codiciPremio) {

			result = this.precalcolo(capiPerPremio, cp);
			capiAccertati = result[0];
			capiAnomali = result[1];
			capiRichiesti = result[2];

		
			try {
				esito = capiAnomali / capiAccertati;
			} catch (ArithmeticException e) {
				new Dmt_t_errore(this.sessione, this.getClass().getSimpleName(), "", "nessun capo accertato");
			}

			percentualeRiduzione = calcoloRiduzione(capiAnomali, esito);
			
			if (percentualeRiduzione == -1)
				return;
			
			if (cp.equals("320")) {
				
			} else {
				
				capiPagabili = capiAccertati * (1 - percentualeRiduzione);
				double importoUnit = this.controlliService
						.getImportoUnitarioByAnnoCampagnaAndIntervento(this.azienda.getAnnoCampagna(), cp)
						.getImportoUnitario();
				importoPagato = capiPagabili * importoUnit;
			}
			
			outputCalcolo = new Dmt_t_output_ref03();
			outputCalcolo.setAnnoCampagna(this.azienda.getAnnoCampagna());
			outputCalcolo.setCapiAccertati(capiAccertati);
			outputCalcolo.setCapiAnomali(capiAnomali);
			outputCalcolo.setCapiPagabili(capiPagabili);
			outputCalcolo.setCapiRichiesti(capiRichiesti);
			outputCalcolo.setCuaa(this.azienda.getCuaa());
			outputCalcolo.setEsito(esito);
			outputCalcolo.setImportoPagato(importoPagato);
			outputCalcolo.setIntervento(cp);
			outputCalcolo.setPercentualeRiduzione(percentualeRiduzione);
			outputCalcolo.setSessione(this.sessione);

			if (esito > 0.5)
				outputCalcolo.setDifferenzaCapiRichiestiAccertati(capiRichiesti - capiAccertati);

			this.controlliService.saveOutputRef03(outputCalcolo);
		}
		
		LOGGER.info("fine esecuzione()");
	}

	/**
	 * in base alla mappa di hash e al codice premio preso in esame, vengono valorizzate le seguenti variabili:
	 * - capiAnomali   -> capi valorizzati nella tabella dmt_t_output_esclusi.
	 * - capiAccertati -> capi che possono concorrere al premio in questione.
	 * - capiRichiesti -> capi presenti nella richiesta a premio del richiedente.
	 * 
	 * @param capiPerPremio
	 * @param cp
	 * @return result[] -> array in cui sono presenti le variabili valorizzate.
	 */
	private int[] precalcolo(HashMap<String, List<Long>> capiPerPremio, String cp) {

		int capiAnomali = 0;
		int capiAccertati = 0;
		int capiRichiesti = 0;

		int result[] = new int[3];

		if (capiAnomali != 0)
			capiAnomali = 0;

		if (capiPerPremio.get(cp) != null)
			capiAccertati = capiPerPremio.get(cp).size();
		capiRichiesti = this.controlliService.getAllBoviniSessioneCuua(this.sessione, this.azienda.getCuaa(), cp).size()
				+ this.controlliService
						.getAllOvicapriniSessioneCuaa(this.sessione.getIdSessione(), this.azienda.getCuaa(), cp).size()
				+ this.controlliService.getAllMacellatiSessioneCuua(this.sessione, this.azienda.getCuaa(), cp).size();

		for (Long c : capiPerPremio.get(cp)) {
			try {
				List<Long> capiAnomaliPerCodicePremio = this.controlliService.isAnomalo(this.sessione.getIdSessione(),
						cp);

				for (Long anomali : capiAnomaliPerCodicePremio) {
					if (anomali != null && anomali.equals(c)) {
						capiAnomali++;
						capiAccertati--;
					}
				}
				capiAnomaliPerCodicePremio.clear();
			} catch (NullPointerException e) {
			}
		}

		result[0] = capiAccertati;
		result[1] = capiAnomali;
		result[2] = capiRichiesti;

		return result;
	}

	/**
	 * in base al numero di capi anomali e all'esito viene valorizzata la variabile di
	 * percentuale di riduzione a premio. Tale variabile sara' necessaria al calcolo della quota pagata al richiedente.
	 * @param capiAnomali
	 * @param esito
	 * @return percRid -> percentuale di riduzione della quota riconosciuta al richiedente
	 */
	private double calcoloRiduzione(int capiAnomali, double esito) {
		double percRid = -1;
		if ((capiAnomali >= 0 && capiAnomali <= 3) || (capiAnomali > 3 && esito <= 0.1))
			return percRid = esito;
		if (capiAnomali > 3) {

			if (esito > 0.1 && esito <= 0.2)
				return percRid = esito * 2;

			if (esito > 0.2 && esito <= 0.5)
				return percRid = 1;

			if (esito > 0.5)
				return percRid = 1;
		}

		// condizione momentaneamente sospesa, aspettare direttive per l'implementazione
		/*
		 * if(Irregolarità intenzionale riscontrata) return percRid = 1;
		 */

		return percRid;
	}

	/**
	 * metodo di costruzione della tabella di hash. In base alla lista dei capi bovini, ovicaprini e macellati, 
	 * viene costruita un'hashmap in cui le chiavi sono i codici_premio e i valori sono le liste di capi concorrenti a tali codici premio.
	 * La lista di capi e' costruita in modo tale da conservare l'informazione del capoId, utile al riconosciumento del singolo capo.
	 * Le altre informazioni vengono ignorate poiche' ritenute ignorabili. 
	 * @param listaCapiBovini
	 * @param listaCapiOvicaprini
	 * @param listaCapiMacellati
	 * @param codiciPremio
	 * @return tempHashmap -> hashmap valorizzata (codice_premio, lista_capi)
	 */
	public HashMap<String, List<Long>> buildMap(List<Dmt_t_Tws_bdn_du_capi_bovini> listaCapiBovini,
			List<Dmt_t_Tws_bdn_du_capi_ovicaprini> listaCapiOvicaprini, List<Dmt_t_clsCapoMacellato> listaCapiMacellati,
			List<String> codiciPremio) {

		HashMap<String, List<Long>> tempHashmap = new HashMap<String, List<Long>>();

		for (String c : codiciPremio)
			tempHashmap.put(c, new ArrayList<Long>());

		for (String c : codiciPremio) {
			for (Dmt_t_Tws_bdn_du_capi_bovini b : listaCapiBovini) {
				if (b.getCodicePremio().equals(c)) {
					tempHashmap.get(c).add(b.getCapoId());
				}
			}

			for (Dmt_t_Tws_bdn_du_capi_ovicaprini o : listaCapiOvicaprini) {
				if (o.getCodicePremio().equals(c)) {
					tempHashmap.get(c).add(o.getCapoId());
				}
			}

			for (Dmt_t_clsCapoMacellato m : listaCapiMacellati) {
				if (m.getCodicePremio().equals(c)) {
					tempHashmap.get(c).add(m.getCapoId());
				}
			}
		}
		return tempHashmap;
	}

	/**
	 * metodo in cui viene effettuato l'aggiornamento dei capi in base al codice premio.
	 *  i premi zootecnici non sono tutti tra loro cumulabili. I soli interventi che sono cumulabili tra di loro sono le seguenti coppie di misure:
     *   - Misura 1 (310) con la misura 2 (311) 
     *   - Misura 4 (313) con la misura 18 (314)
     *  Pertanto, qualora un capo dovesse risultare ammissibile al pagamento per una pluralità di misure zootecniche tra loro non cumulabili,
     *   il sostegno è erogato con riferimento alla misura per la quale è previsto l’importo unitario più elevato 
     *   (o alla somma dei importi unitari nel caso di misure cumulabili).
     *   
	 * @param capiPerPremio
	 * @return tempHash -> hashmap con valori aggiornati
	 */
	public HashMap<String, List<Long>> updateMap(HashMap<String, List<Long>> capiPerPremio) {

		List<String> codiciPremioFiltratiPerAnimaliAPremio = new ArrayList<String>();
		HashMap<String, List<Long>> tempHash = new HashMap<String, List<Long>>();
		Dmt_t_importo_unitario maxImportoUnitario = new Dmt_t_importo_unitario();

		for (String k : capiPerPremio.keySet())
			tempHash.put(k, new ArrayList<Long>());

		for (Entry<String, List<Long>> tuple : capiPerPremio.entrySet())
			for (Long e : tuple.getValue()) {

				Boolean coppia310 = false;
				Boolean coppia313 = false;

				codiciPremioFiltratiPerAnimaliAPremio = this.controlliService.getCodiciPremioPerCapo(e,
						this.sessione.getIdSessione());

				if (codiciPremioFiltratiPerAnimaliAPremio.size() == 1) {
					tempHash.get(tuple.getKey()).add(e);
					continue;
				}

				if (codiciPremioFiltratiPerAnimaliAPremio.size() >= 2) {

					List<Dmt_t_importo_unitario> importiUnitariPerAnimale = new ArrayList<Dmt_t_importo_unitario>();
					importiUnitariPerAnimale = this.controlliService.getListImportiUnitariByAnnoCampagnaAndIntervento(
							this.azienda.getAnnoCampagna(), codiciPremioFiltratiPerAnimaliAPremio);

					String importoDaNonConsiderare = "";
					Dmt_t_importo_unitario importo1 = null;
					Dmt_t_importo_unitario importo2 = null;

					if (contains(codiciPremioFiltratiPerAnimaliAPremio, "310")
							&& contains(codiciPremioFiltratiPerAnimaliAPremio, "311")) {

						coppia310 = true;
						importo1 = this.controlliService
								.getImportoUnitarioByAnnoCampagnaAndIntervento(this.azienda.getAnnoCampagna(), "310");
						importo2 = this.controlliService
								.getImportoUnitarioByAnnoCampagnaAndIntervento(this.azienda.getAnnoCampagna(), "311");

						importoDaNonConsiderare = importo1.getImportoUnitario() < importo2.getImportoUnitario()
								? importo1.getIntervento()
								: importo2.getIntervento();

					} else if (contains(codiciPremioFiltratiPerAnimaliAPremio, "313")
							&& contains(codiciPremioFiltratiPerAnimaliAPremio, "314")) {

						coppia313 = true;
						importo1 = this.controlliService
								.getImportoUnitarioByAnnoCampagnaAndIntervento(this.azienda.getAnnoCampagna(), "313");
						importo2 = this.controlliService
								.getImportoUnitarioByAnnoCampagnaAndIntervento(this.azienda.getAnnoCampagna(), "314");

						importoDaNonConsiderare = importo1.getImportoUnitario() < importo2.getImportoUnitario()
								? importo1.getIntervento()
								: importo2.getIntervento();

					}

					double max = Double.MIN_VALUE;

					for (int i = 0; i < importiUnitariPerAnimale.size(); i++) {
						if ((!importiUnitariPerAnimale.get(i).getIntervento().equals(importoDaNonConsiderare))
								&& (importiUnitariPerAnimale.get(i).getImportoUnitario() > max)) {
							max = importiUnitariPerAnimale.get(i).getImportoUnitario();
							maxImportoUnitario = importiUnitariPerAnimale.get(i);
						}
					}
					List<Dmt_t_importo_unitario> listaImportiMassimi = new ArrayList<>();

					if (coppia310) {

						listaImportiMassimi.add(this.controlliService
								.getImportoUnitarioByAnnoCampagnaAndIntervento(this.azienda.getAnnoCampagna(), "310"));
						listaImportiMassimi.add(this.controlliService
								.getImportoUnitarioByAnnoCampagnaAndIntervento(this.azienda.getAnnoCampagna(), "311"));
					} else if (coppia313) {
						listaImportiMassimi.add(this.controlliService
								.getImportoUnitarioByAnnoCampagnaAndIntervento(this.azienda.getAnnoCampagna(), "313"));
						listaImportiMassimi.add(this.controlliService
								.getImportoUnitarioByAnnoCampagnaAndIntervento(this.azienda.getAnnoCampagna(), "314"));
					} else {
						listaImportiMassimi.add(maxImportoUnitario);
					}

					for (HashMap.Entry<String, List<Long>> entry : capiPerPremio.entrySet()) {
						for (Long l : entry.getValue()) {
							if (e == l) {
								if (listaImportiMassimi.size() == 1) {
									if (!entry.getKey().equals(listaImportiMassimi.get(0).getIntervento())) {
										tempHash.get(entry.getKey()).add(l);
									}
								} else if (listaImportiMassimi.size() > 1) {
									if (!entry.getKey().equals(listaImportiMassimi.get(0).getIntervento())
											|| !entry.getKey().equals(listaImportiMassimi.get(1).getIntervento())) {
										tempHash.get(entry.getKey()).add(l);
									}
								}
							}

						}
					}

					listaImportiMassimi.clear();
					importiUnitariPerAnimale.clear();
				}
				codiciPremioFiltratiPerAnimaliAPremio.clear();
			}
		return tempHash;
	}

	/**
	 * metodo in cui viene confrontato un dato codice premio con i valori presenti nella lista dei codici premio
	 * per cui un dato animale concorre. Se il codice premio ricercato viene trovato nella lista dei codici premio 
	 * associati al dato animale, allora viene ritornato un valore booleano true, altrimenti viene ritornato un
	 * valore booleano false
	 * @param codiciPremioFiltratiPerAnimaliAPremio
	 * @param codPremio
	 * @return boolean -> (true se codPremio si trova  in codiciPremioFiltratiPerAnimaliAPremio, false altrimenti)
	 */
	public Boolean contains(List<String> codiciPremioFiltratiPerAnimaliAPremio, String codPremio) {

		for (String cp : codiciPremioFiltratiPerAnimaliAPremio)
			if (cp.equals(codPremio))
				return true;

		return false;
	}

}