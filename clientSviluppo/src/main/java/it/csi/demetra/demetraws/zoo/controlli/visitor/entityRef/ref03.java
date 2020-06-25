package it.csi.demetra.demetraws.zoo.controlli.visitor.entityRef;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.csi.demetra.demetraws.zoo.calcoli.CalcoloException;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_bovini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_ovicaprini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_clsCapoMacellato;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_importo_unitario;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_irregolarita_intenzionale;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_controlli;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_ref03;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;
import it.csi.demetra.demetraws.zoo.model.Rpu_V_pratica_zoote;
import it.csi.demetra.demetraws.zoo.services.ControlliService;

@Component("ref03")
/**
 * Classe per la verifica di eventuali riduzioni da applicare per il pagamento
 * del premio zootecnia.
 * 
 * @author Bcsoft
 *
 */
public class ref03 {

	private Rpu_V_pratica_zoote azienda;
	private Dmt_t_sessione sessione;
	private static final Logger LOGGER = LoggerFactory.getLogger(ref03.class);
	private Boolean isIrregolaritaIntenzionale;
	private BigDecimal importoUnit;

	@Autowired
	ControlliService controlliService;

	/**
	 * inizializzatore delle variabili di classe.
	 * 
	 * @param sessione sessione generata per l'esecuzione corrente.
	 * @param azienda  azienda per la quale si effettua il calcolo.
	 */
	public void inizializzazione(Dmt_t_sessione sessione, Rpu_V_pratica_zoote azienda) {
		this.azienda = azienda;
		this.sessione = sessione;
	}

	/**
	 * nel metodo esecuzione vengono calcolati il numero di capi pagabili, la quota
	 * pagata, l'esito del calcolo e la percentuale di riduzione premio. Per
	 * effettuare tali calcoli, vengono utilizzati i capi appartenenti all'azienda
	 * analizzata e dei codici premio per cui tale azienda concorre. Dopo aver
	 * effettuato tali calcoli, verranno salvati a db nella rispettiva tabella di
	 * output. @see Dmt_t_output_ref03
	 * @throws CalcoloException eccezione riferita al calcolo @see Calcolo
	 */
	public void esecuzione() throws CalcoloException {

		LOGGER.info("inizio esecuzione()");

		this.importoUnit = new BigDecimal(0);
		this.isIrregolaritaIntenzionale = false;
		Dmt_t_output_ref03 outputCalcolo = null;
		List<Dmt_t_Tws_bdn_du_capi_bovini> listaCapiBovini = this.controlliService
				.getCapiBoviniDaCuaaAndIdSessione(this.sessione.getIdSessione(), this.azienda.getCuaa());
		List<Dmt_t_clsCapoMacellato> listaCapiMacellati = this.controlliService
				.getCapiMacellatiDaCuaaAndIdSessione(this.sessione.getIdSessione(), this.azienda.getCuaa());
		List<Dmt_t_Tws_bdn_du_capi_ovicaprini> listaCapiOvicaprini = this.controlliService
				.getCapiOvicapriniDaCuaaAndIdSessione(this.sessione.getIdSessione(), this.azienda.getCuaa());
		List<String> codiciPremio = this.controlliService.getCodicePremioPerCuaa(this.azienda.getCuaa());
		BigDecimal capiAnomali = new BigDecimal(0);
		BigDecimal capiAccertati = new BigDecimal(0);
		BigDecimal capiRichiesti = new BigDecimal(0);
		BigDecimal esito = new BigDecimal(0);
		BigDecimal percentualeRiduzione = new BigDecimal(0);
		BigDecimal capiPagabili = new BigDecimal(0);
		BigDecimal importoPagatoLordoDecurtazione = new BigDecimal(0);
		HashMap<String, List<Long>> capiPerPremio = new HashMap<String, List<Long>>();
		HashMap<String, BigDecimal> result = new HashMap<String, BigDecimal>();
		Integer giorniRitardo = this.controlliService.getGiorniRitardoPresentazioneDomanda(this.azienda.getCuaa(),
				this.azienda.getCodicePremio(), this.azienda.getAnnoCampagna());
		BigDecimal percDecurtazione = null;
		BigDecimal importoPagatoNettoDecurtazione = null;

		capiPerPremio = buildMap(listaCapiBovini, listaCapiOvicaprini, listaCapiMacellati, codiciPremio);

		capiPerPremio = updateMap(capiPerPremio);

		for (String cp : codiciPremio) {

			result = this.precalcolo(capiPerPremio, cp);
			capiAccertati = result.get("accertati");
			capiAnomali = result.get("anomali");
			capiRichiesti = result.get("richiesti");

			try {
				esito = capiAnomali.divide(capiAccertati, MathContext.DECIMAL128);
			} catch (ArithmeticException e) {
//				throw new CalcoloException("errore durante il calcolo dell'esito");
			}

			percentualeRiduzione = calcoloRiduzione(capiAnomali, esito);

			this.importoUnit = new BigDecimal(this.controlliService
					.getImportoUnitarioByAnnoCampagnaAndIntervento(this.azienda.getAnnoCampagna(), cp)
					.getImportoUnitario());
			
			if (cp.equals("320")) {
				try {
					importoPagatoLordoDecurtazione = this.controlliService
							.getQuotaCapiPremioByCuaaAndIdSessioneAndAnnoCampagnaAndCodInt(this.azienda.getCuaa(),
									this.sessione.getIdSessione(), this.azienda.getAnnoCampagna(), cp).multiply(this.importoUnit);
				} catch (NullPointerException e) {
					throw new CalcoloException("errore durante il calcolo dell'importo pagato al lordo della decurtazione");
				}

			} else {
				try {
					capiPagabili = capiAccertati.multiply((BigDecimal.ONE.subtract(percentualeRiduzione)));
					importoPagatoLordoDecurtazione = capiPagabili.multiply(this.importoUnit);

				} catch (NullPointerException e) {
					throw new CalcoloException("errore durante il calcolo dell'importo pagato al lordo della decurtazione");
				}
			}
			if (giorniRitardo != null && !giorniRitardo.equals(new Integer(0))) {
				try {
					percDecurtazione = this.controlliService
							.getPercentualeDiDecurtazione(this.azienda.getAnnoCampagna(), giorniRitardo);
					importoPagatoNettoDecurtazione = percDecurtazione != null ? importoPagatoLordoDecurtazione.subtract(
							(importoPagatoLordoDecurtazione.multiply(percDecurtazione)).divide(new BigDecimal(100)))
							: BigDecimal.ZERO;
				} catch (NullPointerException e) {
					throw new CalcoloException("errore durante il calcolo dell'importo pagato al netto della decurtazione");
				}
			}

			outputCalcolo = new Dmt_t_output_ref03();
			outputCalcolo.setAnnoCampagna(this.azienda.getAnnoCampagna());
			outputCalcolo.setCapiAccertati(capiAccertati.intValue());
			outputCalcolo.setCapiAnomali(capiAnomali.intValue());
			outputCalcolo.setCapiPagabili(capiPagabili.doubleValue());
			outputCalcolo.setCapiRichiesti(capiRichiesti.intValue());
			outputCalcolo.setCuaa(this.azienda.getCuaa());
			outputCalcolo.setEsito(esito.doubleValue());
			outputCalcolo.setImportoPagatoLordoDecurtazione(importoPagatoLordoDecurtazione);
			outputCalcolo.setImportoPagatoNettoDecurtazione(importoPagatoNettoDecurtazione);
			outputCalcolo.setIntervento(cp);
			outputCalcolo.setPercentualeRiduzione(percentualeRiduzione.doubleValue());
			outputCalcolo.setPercentualeDecurtazione(percDecurtazione);
			outputCalcolo.setIdSessione(this.sessione);

			if (esito.compareTo(new BigDecimal("0.5")) > 0 || this.isIrregolaritaIntenzionale) {
				outputCalcolo.setDifferenzaCapiRichiestiAccertati(capiRichiesti.subtract(capiAccertati).intValue());
				outputCalcolo.setImportoARecupero(
						new BigDecimal(outputCalcolo.getDifferenzaCapiRichiestiAccertati()).multiply(this.importoUnit));
				this.isIrregolaritaIntenzionale = false;
			}

			this.controlliService.saveOutputRef03(outputCalcolo);
		}

		LOGGER.info("fine esecuzione()");
	}

	/**
	 * nel metodo precalcolo vengono valorizzate le seguenti variabili in base alla
	 * mappa di hash e al codice premio preso in esame: - capiAnomali -> capi
	 * valorizzati nella tabella dmt_t_output_esclusi. - capiAccertati -> capi che
	 * possono concorrere al premio in questione. - capiRichiesti -> capi presenti
	 * nella richiesta a premio del richiedente.
	 * 
	 * @param capiPerPremio tabella di hash contentente i codici premio e la lista
	 *                      degli animali concorrenti a premio
	 * @param cp            codice premio da analizzare
	 * @return result -> mappa di hash in cui sono presenti le variabili
	 *         valorizzate.
	 */
	private HashMap<String, BigDecimal> precalcolo(HashMap<String, List<Long>> capiPerPremio, String cp) {

		Dmt_t_output_controlli outputControlli = new Dmt_t_output_controlli();
		BigDecimal capiAnomali = new BigDecimal(0);
		BigDecimal capiAccertati = new BigDecimal(0);
		BigDecimal capiRichiesti = new BigDecimal(0);
		HashMap<String, BigDecimal> result = new HashMap<String, BigDecimal>();
		outputControlli = this.controlliService.getOutputControlliBySessioneAndCuaaAndAnnoCampagnaAndIntervento(
				this.sessione, this.azienda.getCuaa(), Long.valueOf(this.azienda.getAnnoCampagna()), cp);

		if (outputControlli != null) {
			capiRichiesti = new BigDecimal(outputControlli.getCapiRichiesti());
			capiAccertati = new BigDecimal(outputControlli.getCapiAmmissibili());
			capiAnomali = capiRichiesti.subtract(capiAccertati);
		}

//		for (Long c : capiPerPremio.get(cp)) {
//			try {
//				List<Long> capiAnomaliPerCodicePremio = this.controlliService.isAnomalo(this.sessione.getIdSessione(),
//						cp);
//
//				for (Long anomali : capiAnomaliPerCodicePremio) {
//					if (anomali != null && anomali.equals(c)) {
//							capiAccertati=capiAccertati.subtract(BigDecimal.ONE);
//							capiAnomali=capiAnomali.add(BigDecimal.ONE);
//						}
//					}
//				capiAnomaliPerCodicePremio.clear();
//			} catch (NullPointerException e) {
//			}
//		}		
		result.put("accertati", capiAccertati);
		result.put("anomali", capiAnomali);
		result.put("richiesti", capiRichiesti);

		return result;
	}

	/**
	 * nel metodo calcoloRiduzione vengono valorizzate la seguente variabile in base
	 * al numero di capi anomali e all'esito: - percentuale di riduzione a premio.
	 * Tale variabile sara' necessaria al calcolo della quota pagata al richiedente.
	 * 
	 * @param capiAnomali -> numero di capi che non hanno passato i controlli.
	 * @param esito
	 * @return percRid -> percentuale di riduzione della quota riconosciuta al
	 *         richiedente
	 */
	private BigDecimal calcoloRiduzione(BigDecimal capiAnomali, BigDecimal esito) {
		
		if (isIrregolaritaIntenzionale().compareTo(BigDecimal.ZERO) > 0) {

			if (esito.compareTo(new BigDecimal("0.2")) <= 0) {
				this.isIrregolaritaIntenzionale = false;
				return BigDecimal.ZERO;
			}

			else if (esito.compareTo(new BigDecimal("0.2")) > 0) {
				this.isIrregolaritaIntenzionale = true;
				return BigDecimal.ONE;
			}
		}

		if ((capiAnomali.compareTo(BigDecimal.ZERO) >= 0 && capiAnomali.compareTo(new BigDecimal(3)) <= 0)
				|| (capiAnomali.compareTo(new BigDecimal(3)) == 1 && esito.compareTo(new BigDecimal("0.1")) <= 0))
			return esito;
		
		if (capiAnomali.compareTo(new BigDecimal(3)) == 1) {

			if (esito.compareTo(new BigDecimal("0.1")) > 0 && esito.compareTo(new BigDecimal("0.2")) <= 0)
				return esito.multiply(new BigDecimal(2));

			if (esito.compareTo(new BigDecimal("0.2")) > 0 && esito.compareTo(new BigDecimal("0.5")) <= 0)
				return BigDecimal.ONE;

			if (esito.compareTo(new BigDecimal("0.5")) > 0)
				return BigDecimal.ONE;
		}

		return BigDecimal.ZERO;
	}

	/**
	 * nel metodo buildùmap viene costruita la tabella di hash in base alla lista
	 * dei capi bovini, ovicaprini e macellati. Le chiavi sono i codici_premio e i
	 * valori sono le liste di capi concorrenti a tali codici premio. La lista di
	 * capi e' costruita in modo tale da conservare l'informazione del capoId, utile
	 * al riconosciumento del singolo capo. Le altre informazioni vengono ignorate
	 * poiche' ritenute non necessarie ai fini del calcolo.
	 * 
	 * @param listaCapiBovini     - lista degli animali di tipo bovino appartenenti
	 *                            all'azienda che si sta analizzando.
	 * @param listaCapiOvicaprini - lista degli animali di tipo ovicaprino
	 *                            appartenenti all'azienda che si sta analizzando.
	 * @param listaCapiMacellati  - lista degli animali di tipo macellato
	 *                            appartenenti all'azienda che si sta analizzando.
	 * @param codiciPremio        - codici premio per cui concorre l'azienda che si
	 *                            sta analizzando.
	 * @return tempHashmap - hashmap valorizzata (codice_premio, lista_capi)
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
	 * nel metodo updateMap viene effettuato l'aggiornamento dei capi in base al
	 * codice premio. i premi zootecnici non sono tutti tra loro cumulabili. I soli
	 * interventi che sono cumulabili tra di loro sono le seguenti coppie di misure:
	 * - Misura 1 (310) con la misura 2 (311) - Misura 4 (313) con la misura 18
	 * (314) Pertanto, qualora un capo dovesse risultare ammissibile al pagamento
	 * per una pluralità di misure zootecniche tra loro non cumulabili, il sostegno
	 * è erogato con riferimento alla misura per la quale è previsto l’importo
	 * unitario più elevato (o alla somma dei importi unitari nel caso di misure
	 * cumulabili).
	 * 
	 * @param capiPerPremio tabella di hash degli animali concorrenti a premio.
	 * @return tempHash -> tabella di hash con valori aggiornati.
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
											&& !entry.getKey().equals(listaImportiMassimi.get(1).getIntervento())) {
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
	 * nel metodo contains viene confrontato un dato codice premio con i valori
	 * presenti nella lista dei codici premio per cui un dato animale concorre. Se
	 * il codice premio ricercato viene trovato nella lista dei codici premio
	 * associati al dato animale, allora viene ritornato un valore booleano true,
	 * altrimenti viene ritornato un valore booleano false
	 * 
	 * @param codiciPremioFiltratiPerAnimaliAPremio - lista dei codici premio per
	 *                                              cui un dato animale concorre.
	 * @param codPremio                             - codice premio che si sta
	 *                                              analizzando.
	 * @return boolean - (true se codPremio si trova in
	 *         codiciPremioFiltratiPerAnimaliAPremio, false altrimenti).
	 */
	public Boolean contains(List<String> codiciPremioFiltratiPerAnimaliAPremio, String codPremio) {

		for (String cp : codiciPremioFiltratiPerAnimaliAPremio)
			if (cp.equals(codPremio))
				return true;

		return false;
	}

	private BigDecimal isIrregolaritaIntenzionale() {
		BigDecimal numeroAnimaliAnomali = new BigDecimal(0);
		List<Dmt_t_irregolarita_intenzionale> listaIrregolaritaIntenzionali = this.controlliService
				.getIrregolaritaByCuaaAndAnnoCampagna(this.azienda.getCuaa(), new Integer(this.azienda.getAnnoCampagna()));

		if (listaIrregolaritaIntenzionali != null && !listaIrregolaritaIntenzionali.isEmpty()
				&& listaIrregolaritaIntenzionali.size() == 1)
			return listaIrregolaritaIntenzionali.get(0).getIntenzionalitaRiscontrata().equals("S")
					? new BigDecimal(listaIrregolaritaIntenzionali.get(0).getNumeroAnimaliAnomali())
					: BigDecimal.ZERO;
		else if (listaIrregolaritaIntenzionali != null && !listaIrregolaritaIntenzionali.isEmpty()
				&& listaIrregolaritaIntenzionali.size() > 1)
			for (Dmt_t_irregolarita_intenzionale ir : listaIrregolaritaIntenzionali)
				if (ir.getIntenzionalitaRiscontrata().equals("S"))
					numeroAnimaliAnomali.add(BigDecimal.ONE);

		listaIrregolaritaIntenzionali.clear();
		return numeroAnimaliAnomali;
	}

}
