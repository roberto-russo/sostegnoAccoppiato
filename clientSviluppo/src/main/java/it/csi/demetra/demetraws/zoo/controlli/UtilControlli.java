package it.csi.demetra.demetraws.zoo.controlli;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import it.csi.demetra.demetraws.zoo.model.Dmt_T_analisi_produzioni_cuua;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_bovini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_Tws_bdn_du_capi_ovicaprini;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_anagrafica_allevamenti;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_certificato_igp_dop;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_clsCapoMacellato;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_demarcazione_PSR;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_output_esclusi;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_premio_capi;
import it.csi.demetra.demetraws.zoo.model.Dmt_t_sessione;
import it.csi.demetra.demetraws.zoo.model.Rpu_V_pratica_zoote;
import it.csi.demetra.demetraws.zoo.services.ControlliService;
import it.csi.demetra.demetraws.zoo.services.Dmt_t_tws_bdn_du_capi_bovini_services;
import it.csi.demetra.demetraws.zoo.util.DateUtilService;
import it.csi.demetra.demetraws.zoo.util.LocalDateConverter;

/**
 * Classe utilizzata per raggruppare metodi comuni a più controlli
 */
public class UtilControlli {

	private final static int GIORNI_INTERPARTO = 270;
	private final static int ETA_MIN_PARTO_MESI = 20;
	private final static int ETA_MAX_PARTO_MESI = 216;

	// SOGLIE PER I CALCOLI.
	private static final Long SOGLIA_CSOM_MED = new Long(300 * 10 ^ 3);
	private static final Long SOGLIA_CMIC_MED = new Long(40 * 10 ^ 3);
	private static final Double SOGLIA_PP_MED = 3.35;

	// SOGLIE PER I CALCOLI 2.
	private static final Long SOGLIA_CSOM_MED_2 = new Long(400 * 10 ^ 3);
	private static final Long SOGLIA_CMIC_MED_2 = new Long(100 * 10 ^ 3);
	private static final Double SOGLIA_PP_MED_2 = 3.20;

	/**
	 * Questo metodo genera l'oggetto 'escluso', che verrà successivamente salvato
	 * in db in modo tale da avere uno storico dei capi non liquidabili per un
	 * controllo.
	 *
	 * @param b           istanza relativa al capo bovino di tipo
	 *                    {@link Dmt_t_Tws_bdn_du_capi_bovini}
	 * @param sessione    istanza relativa all'identificazione della sessione di
	 *                    tipo {@link Dmt_t_sessione}
	 * @param motivazione motivazione dell'esclusione del capo dal premio di tipo
	 *                    String
	 * @param calcolo     calcolo per cui il capo bovino è stato escluso
	 * @return istanza di tipo {@link Dmt_t_output_esclusi}
	 */
	public static Dmt_t_output_esclusi generaEscluso(Dmt_t_Tws_bdn_du_capi_bovini b, Dmt_t_sessione sessione,
			String motivazione, String calcolo) {
		Dmt_t_output_esclusi escluso = new Dmt_t_output_esclusi();
		escluso.setCalcolo(calcolo);
		escluso.setCapoId(b.getCapoId());
		escluso.setMotivazioneEsclusione(motivazione);
		escluso.setIdSessione(sessione);

		return escluso;
	}

	/**
	 * Metodo che restituisce la data di nascita del vitello più giovane nel caso in
	 * cui un bovino abbia partorito più volte
	 *
	 * @param b           istanza relativa al capo bovino di tipo
	 *                    {@link Dmt_t_Tws_bdn_du_capi_bovini}
	 * @param listVitelli lista di istanze relative ai vitelli di tipo
	 *                    {@link Dmt_t_Tws_bdn_du_capi_bovini}
	 * @return istanza di tipo Date relativa alla data del vitello più giovane.
	 */
	public static Date getVitelloGiovane(Dmt_t_Tws_bdn_du_capi_bovini b,
			List<Dmt_t_Tws_bdn_du_capi_bovini> listVitelli) {
		Date dataGiovane = b.getDtNascitaVitello();
		for (Dmt_t_Tws_bdn_du_capi_bovini b2 : listVitelli)
			if (null != b2.getDtNascitaVitello())
				if (null == dataGiovane)
					dataGiovane = b2.getDtNascitaVitello();
				else if (b2.getDtNascitaVitello().before(dataGiovane))
					dataGiovane = b2.getDtNascitaVitello();

		return dataGiovane;
	}

	/**
	 * Controllo che il cuaa sia il detentore dell'allevamento al momento del parto
	 * e qualora la vacca abbia partorito più di una volta nel corso dell’anno
	 * presso la stalla di diversi detentori susseguitisi nel tempo, il premio è
	 * erogato al detentore presso il quale è nato il primo capo.
	 *
	 * @param b           istanza relativa al capo bovino di tipo
	 *                    {@link Dmt_t_Tws_bdn_du_capi_bovini}
	 * @param listVitelli lista di istanze relative ai vitelli di tipo
	 *                    {@link Dmt_t_Tws_bdn_du_capi_bovini}
	 * @return <b>true:</b> se il capo animale è in detenzione, <b>false:</b>
	 *         altrimenti
	 */
	public static Boolean isDetentoreParto(Dmt_t_Tws_bdn_du_capi_bovini b,
			List<Dmt_t_Tws_bdn_du_capi_bovini> listVitelli) {
		Date dataGiovane = UtilControlli.getVitelloGiovane(b, listVitelli);
		return (b.getDtFineDetenzione().after(dataGiovane) && b.getDtInizioDetenzione().before(dataGiovane));
	}

	public static double mediaGeometrica(List<BigDecimal> valori) {
		double n = 0.00;
		double res = 1.00;
		for (BigDecimal v : valori) {
			n += 1.00;
			res = res * v.doubleValue();
		}
		return Math.pow(res, n);
	}

	public static double mediaAritmetica(List<BigDecimal> valori) {
		int n = 0;
		double res = 0.00;
		for (BigDecimal v : valori) {
			n++;
			res += v.doubleValue();
		}
		return res / n;
	}

	public static Integer convertCodiceMeseInt(String codiceMese) {
		switch (codiceMese) {
		case "GEN":
			return 1;

		case "FEB":
			return 2;

		case "MAR":
			return 3;

		case "APR":
			return 4;

		case "MAG":
			return 5;

		case "GIU":
			return 6;
		case "LUG":
			return 7;
		case "AGO":
			return 8;
		case "SET":
			return 9;
		case "OTT":
			return 10;
		case "NOV":
			return 11;
		case "DIC":
			return 12;
		}
		return 0;
	}

	public static List<Dmt_t_clsCapoMacellato> filtraAnimaleMacellato(List<Dmt_t_premio_capi> animaliAmmessi,
			List<Dmt_t_clsCapoMacellato> animaliDaFiltrare) {

		List<Dmt_t_clsCapoMacellato> animaliFiltrati = new ArrayList<Dmt_t_clsCapoMacellato>();

		if (animaliFiltrati != null || !animaliFiltrati.isEmpty())
			animaliFiltrati.clear();

		for (Dmt_t_clsCapoMacellato capoMac : animaliDaFiltrare)
			if (contains(animaliAmmessi, capoMac))
				animaliFiltrati.add(capoMac);

		return animaliFiltrati;
	}

	public static List<Dmt_t_Tws_bdn_du_capi_bovini> filtraAnimaleBovino(List<Dmt_t_premio_capi> animaliAmmessi,
			List<Dmt_t_Tws_bdn_du_capi_bovini> animaliDaFiltrare) {

		List<Dmt_t_Tws_bdn_du_capi_bovini> animaliFiltrati = new ArrayList<Dmt_t_Tws_bdn_du_capi_bovini>();

		if (animaliFiltrati != null || !animaliFiltrati.isEmpty())
			animaliFiltrati.clear();

		for (Dmt_t_Tws_bdn_du_capi_bovini capoBov : animaliDaFiltrare)
			if (contains(animaliAmmessi, capoBov))
				animaliFiltrati.add(capoBov);

		return animaliFiltrati;
	}

	public static List<Dmt_t_Tws_bdn_du_capi_ovicaprini> filtraAnimaleOvicaprino(List<Dmt_t_premio_capi> animaliAmmessi,
			List<Dmt_t_Tws_bdn_du_capi_ovicaprini> animaliDaFiltrare) {

		List<Dmt_t_Tws_bdn_du_capi_ovicaprini> animaliFiltrati = new ArrayList<Dmt_t_Tws_bdn_du_capi_ovicaprini>();

		if (animaliFiltrati != null || !animaliFiltrati.isEmpty())
			animaliFiltrati.clear();

		for (Dmt_t_Tws_bdn_du_capi_ovicaprini capoOvi : animaliDaFiltrare)
			if (contains(animaliAmmessi, capoOvi))
				animaliFiltrati.add(capoOvi);

		return animaliFiltrati;
	}

	private static Boolean contains(List<Dmt_t_premio_capi> animaliAmmessi,
			Dmt_t_clsCapoMacellato animaleDaControllare) {

		for (Dmt_t_premio_capi animaleAmmesso : animaliAmmessi)
			if (animaleAmmesso.getIdCapo().equals(animaleDaControllare.getCapoId()))
				return true;

		return false;
	}

	public static long differenzaMesi(Date dataInizio, Date dataFine) {

		LocalDate data1 = LocalDateConverter.convertToLocalDateViaInstant(dataInizio);
		LocalDate data2 = LocalDateConverter.convertToLocalDateViaInstant(dataFine);
		return data1.compareTo(data2) < 0 ? ChronoUnit.MONTHS.between(data1, data2)
				: ChronoUnit.MONTHS.between(data2, data1);
	}

	public static long differenzaGiorni(Date dataInizio, Date dataFine) {

		LocalDate data1 = LocalDateConverter.convertToLocalDateViaInstant(dataInizio);
		LocalDate data2 = LocalDateConverter.convertToLocalDateViaInstant(dataFine);
		return data1.compareTo(data2) < 0 ? ChronoUnit.DAYS.between(data1, data2)
				: ChronoUnit.DAYS.between(data2, data1);
	}

	private static Boolean contains(List<Dmt_t_premio_capi> animaliAmmessi,
			Dmt_t_Tws_bdn_du_capi_bovini animaleDaControllare) {

		for (Dmt_t_premio_capi animaleAmmesso : animaliAmmessi)
			if (animaleAmmesso.getIdCapo().equals(animaleDaControllare.getCapoId()))
				return true;

		return false;
	}

	public static void clearList(List<?> listaDaPulire) {

		if (listaDaPulire != null && !listaDaPulire.isEmpty())
			listaDaPulire.clear();
	}

	public static Boolean controlloDataInterpartoBovino(Dmt_t_Tws_bdn_du_capi_bovini bovino,
			ControlliService controlliService, Long idSessione) {

		List<Date> listaDate = controlliService.getDataNascitaVitelloByIdCapoAndIdSessione(bovino.getCapoId(),
				idSessione);
		Iterator<Date> itr = listaDate.listIterator();
		Date data1;
		Date data2;

		while (itr.hasNext()) {

			data1 = itr.next();

			if (itr.hasNext()) {
				data2 = itr.next();
				/*
				 * SE I MESI CHE INTERCORRONO TRA LE DUE DATE SONO < A 270 ALLORA IL CAPO
				 * ANIMALE NON VIENE CONTEGGIATO
				 */
				if (differenzaGiorni(data1, data2) < GIORNI_INTERPARTO &&
				/*
				 * SE L'ETA DEL CAPO ANIMALE RISPETTO ALLA DATA DI PARTO E' INFERIORE AL
				 * REQUISITO MINIMO O MAGGIORE RISPETTO AL REQUISITO MASSIMO IL CAPO ANIMALE NON
				 * VIENE CONTEGGIATO, SI CONTROLLANO AMBO LE DATE
				 */
						(differenzaMesi(bovino.getDataNascita(), data1) < ETA_MIN_PARTO_MESI
								&& (differenzaMesi(bovino.getDataNascita(), data1) > ETA_MAX_PARTO_MESI)
								&& (differenzaMesi(bovino.getDataNascita(), data2) < ETA_MIN_PARTO_MESI
										&& (differenzaMesi(bovino.getDataNascita(), data2) > ETA_MAX_PARTO_MESI))))
					return false;

			} else { /*
						 * SE C'E SOLO UNA DATA DI PARTO SI CONTROLLA SOLO IL REQUISITO DELL'ETA DEL
						 * CAPO ANIMALE
						 */

				if (differenzaMesi(bovino.getDataNascita(), data1) < ETA_MIN_PARTO_MESI
						&& differenzaMesi(bovino.getDataNascita(), data1) > ETA_MAX_PARTO_MESI)
					return false;
			}

		}

		return true;
	}

	public static Boolean controlloRegistrazioneVitello(Dmt_t_Tws_bdn_du_capi_bovini bovino,
			ControlliService controlliService, Long idSessione, String codIntervento) {

		List<Dmt_t_Tws_bdn_du_capi_bovini> listaVitelli = controlliService.getVitelliNatiDaBovini(idSessione,
				bovino.getCapoId(), codIntervento);

		// SE C'E ALMENO UN VITELLO CON LA DATA DI REGISTRAZIONE PRESENTATA IN RITARDO
		// PER QUEL CAPO ANIMALE, IL CAPO ANIMALE VIENE ESCLUSO

		Date dataNascitaVitello;
		Date dataInsBdnNascitaVitello;
		String flagDelegatoNascitaVitello;
		String flagProrogaMarcatura;

		for (Dmt_t_Tws_bdn_du_capi_bovini vitello : listaVitelli) {
			dataNascitaVitello = controlliService
					.getDataNascitaVitelloByVitelloCapoIdAndIdSessione(vitello.getVitelloCapoId(), idSessione);
			dataInsBdnNascitaVitello = controlliService
					.getVitelloDataInserBdnNascitaByVitelloCapoIdAndIdSessione(vitello.getVitelloCapoId(), idSessione);
			flagDelegatoNascitaVitello = controlliService
					.getFlagDelegatoNascitaVitelloByVitelloCapoIdAndIdSessione(vitello.getVitelloCapoId(), idSessione);
			if(flagDelegatoNascitaVitello == null)
				flagDelegatoNascitaVitello = "N";
			flagProrogaMarcatura = controlliService
					.getFlagProrogaMarcaturaByVitelloCapoIdAndIdSessione(vitello.getVitelloCapoId(), idSessione);
			if(flagProrogaMarcatura == null)
				flagProrogaMarcatura = "N";

			// CASO 1- NON C'E DELEGA SULLA NASCITA E NON C'E PROROGA SULLA MARCATURA
			if (flagDelegatoNascitaVitello.toUpperCase().equals("N")
					&& flagProrogaMarcatura.toUpperCase().equals("N")) {

				if (differenzaMesi(dataInsBdnNascitaVitello, dataNascitaVitello) > 27)
					return false;
			}
			// CASO 2- NON C'E DELEGA SULLA NASCITA MA C'E PROROGA SULLA MARCATURA
			if (flagDelegatoNascitaVitello.toUpperCase().equals("N")
					&& flagProrogaMarcatura.toUpperCase().equals("S")) {

				if (differenzaMesi(dataInsBdnNascitaVitello, dataNascitaVitello) > 180)
					return false;
			}

			// CASO 3- C'E DELEGA SULLA NASCITA E NON C'E PROROGA SULLA MARCATURA
			if (flagDelegatoNascitaVitello.toUpperCase().equals("S")
					&& flagProrogaMarcatura.toUpperCase().equals("N")) {

				if (differenzaMesi(dataInsBdnNascitaVitello, dataNascitaVitello) > 34)
					return false;
			}

			// CASO 3- C'E DELEGA SULLA NASCITA E C'E PROROGA SULLA MARCATURA
			if (flagDelegatoNascitaVitello.toUpperCase().equals("S")
					&& flagProrogaMarcatura.toUpperCase().equals("S")) {

				if (differenzaMesi(dataInsBdnNascitaVitello, dataNascitaVitello) > 187)
					return false;
			}
		}

		return true;
	}

//	public static Boolean controlloAmmissibilitaPremioPerPremiCompatibili(Dmt_t_Tws_bdn_du_capi_bovini bovino) {
//
//		return true;
//	}
//
//	public static Boolean controlloAmmissibilitaPremioPerPremiCompatibili(Dmt_t_clsCapoMacellato macellato) {
//
//		return true;
//	}

	public static Boolean controlloDemarcazione(Dmt_t_Tws_bdn_du_capi_bovini bovino, ControlliService controlliService,
			Integer annoCampagna) {

		Dmt_t_demarcazione_PSR PSR = controlliService.getByAnnoAndMarchioAuricolare(annoCampagna, bovino.getCodice());
		if (PSR.getMarchioAuricolare() != null && !PSR.getMarchioAuricolare().equals(""))
			return false;

		return true;
	}

	public static Boolean controlloParametriIgienicoSanitari(Dmt_t_Tws_bdn_du_capi_bovini bovino,
			Rpu_V_pratica_zoote azienda, ControlliService controlliService) {

		List<Dmt_T_analisi_produzioni_cuua> listAnalisiProduzioniCuua = controlliService
				.getProduzioniByCuaaAndYear(azienda.getCuaa(), azienda.getAnnoCampagna());
		List<BigDecimal> csomList = new ArrayList<>();
		List<BigDecimal> cmicList = new ArrayList<>();
		List<BigDecimal> ppList = new ArrayList<>();

		Dmt_t_certificato_igp_dop dmtCID = controlliService.getCertificatoIgpDop(azienda.getCuaa());

		Boolean isProduttoreMontagna = dmtCID.getZona() != null && dmtCID.getZona().toUpperCase().equals("M");
		Boolean isCircuitoQualitaFormaggio = dmtCID.getFlagDop() != null
				&& dmtCID.getFlagDop().toUpperCase().equals("S");
		Boolean isProduttoreChecked = false;

		for (Dmt_T_analisi_produzioni_cuua apc : listAnalisiProduzioniCuua) {
			csomList.add(apc.getCelluleSomatiche());
			cmicList.add(apc.getCaricaBatterica());
			ppList.add(apc.getProteine());
		}

		double CSOM_MED = UtilControlli.mediaGeometrica(csomList);
		double CMIC_MED = UtilControlli.mediaGeometrica(cmicList);
		double PP_MED = UtilControlli.mediaAritmetica(ppList);

		int FLAG_MEDIE_CSOM = 0;
		int FLAG_MEDIE_CMIC = 0;
		int FLAG_MEDIE_PP = 0;

		if (CSOM_MED < SOGLIA_CSOM_MED)
			FLAG_MEDIE_CSOM++;
		if (CMIC_MED < SOGLIA_CMIC_MED)
			FLAG_MEDIE_CMIC++;
		if (PP_MED > SOGLIA_PP_MED)
			FLAG_MEDIE_PP++;

		int FLAG_MEDIE = FLAG_MEDIE_CMIC + FLAG_MEDIE_CSOM + FLAG_MEDIE_PP;

		if (FLAG_MEDIE < 3) {
			if (isProduttoreMontagna && isCircuitoQualitaFormaggio && FLAG_MEDIE == 0) {
				isProduttoreChecked = false;
			} else if (FLAG_MEDIE < 2) {
				isProduttoreChecked = false;
			} else {
				if (FLAG_MEDIE_CSOM == 0) {
					isProduttoreChecked = CSOM_MED < SOGLIA_CSOM_MED_2;
				}
				if (FLAG_MEDIE_CMIC == 0) {
					isProduttoreChecked = CMIC_MED < SOGLIA_CMIC_MED_2;
				}
				if (FLAG_MEDIE_PP == 0) {
					isProduttoreChecked = PP_MED > SOGLIA_PP_MED_2;
				}
			}
		}

		return isProduttoreChecked;
	}

	public static Boolean controlloStallaMontana(Dmt_t_Tws_bdn_du_capi_bovini bovino,
			Dmt_t_tws_bdn_du_capi_bovini_services boviniService) {

		if (boviniService.getFlagZonaMontanaByAllevId(bovino.getAllev_id()).toUpperCase().equals("S"))
			return true;

		return false;
	}

	public static Boolean controlloDetenzioneMinimaPerTempisticheRegistrazione(Dmt_t_Tws_bdn_du_capi_bovini bovino) {

		// AL CALCOLO DEI GIORNI CHE INTERCORRONO TRA LE DUE DATE, INSERIRE I GIORNI
		// FESTIVI CHE INTERCORRONO
		if ((differenzaGiorni(bovino.getVaccaDtComAutIngresso(), bovino.getVaccaDtIngresso()) > 7)
				&& (differenzaGiorni(bovino.getVaccaDtInserBdnIngresso(), bovino.getVaccaDtComAutIngresso()) > 7
						+ (contaFestivi(bovino.getVaccaDtInserBdnIngresso(), bovino.getVaccaDtComAutIngresso())))) {

			// VERIFICA DEL RISPETTO DEL PERIODO DI PERMANENZA
			if (differenzaMesi(bovino.getDtFineDetenzione(), bovino.getVaccaDtInserBdnIngresso()) > 6)

				// CAPO PAGATO E SANZIONATO
				return true;
			else

				// CAPO ESCLUSO DAL PAGAMENTO
				return false;

		} else if ((differenzaGiorni(bovino.getVaccaDtComAutIngresso(), bovino.getVaccaDtIngresso()) < 7)
				&& (differenzaGiorni(bovino.getVaccaDtInserBdnIngresso(), bovino.getVaccaDtComAutIngresso()) <= 7)) {

			if (differenzaMesi(bovino.getDtFineDetenzione(), bovino.getDtInizioDetenzione()) > 6)
				// CAPO PAGATO
				return true;
			else

				// CAPO ESCLUSO DAL PAGAMENTO
				return false;
		}

		// SE NON RIENTRO IN NESSUNO DEI CASI SOPRA ELENCANTI, RITORNO FALSE
		return false;
	}

	public static Boolean controlloAmmissibilitaPremio314(Dmt_t_Tws_bdn_du_capi_bovini bovino) {

		/*
		 * SE LA VACCCA NUTRICE FA PARTE DI ALLEVAMENTI CHE ADERISCONO A PIANI DI
		 * GESTIONE DELLA RAZZA FINALIZZATI AL RISANAMENTO DAL VIRUS RESPONSABILE DELLA
		 * RINOTRACHEITE INFETTIVA DEL BOVINO IBR ALLORA VA CONTATO, ALTRIMENTI NO
		 */

		if (null != bovino.getFlagIbr() && bovino.getFlagIbr().toUpperCase().equals("S"))
			return true;

		return false;
	}

	public static Boolean controlloIscrizioneconsorzioEtichettatura(Dmt_t_clsCapoMacellato macellato,
			ControlliService controlliService) {

		String sistemaEtichettatura = controlliService.getSistemaEtichettarua(macellato.getCuaa())
				.getFlagEtichettatura();
		if (sistemaEtichettatura != null && sistemaEtichettatura.toUpperCase().equals("S"))
			return true;

		return false;
	}

	public static Boolean controlloDocg(Dmt_t_clsCapoMacellato macellato, ControlliService controlliService) {

		Dmt_t_certificato_igp_dop certifIgpDop = controlliService.getCertificatoIgpDop(macellato.getCuaa());

		if (certifIgpDop != null && (certifIgpDop.getFlagIgp().toUpperCase().equals("S")
				|| certifIgpDop.getFlagDop().toUpperCase().equals("S")))
			return true;

		return false;
	}

	private static Boolean contains(List<Dmt_t_premio_capi> animaliAmmessi,
			Dmt_t_Tws_bdn_du_capi_ovicaprini animaleDaControllare) {

		for (Dmt_t_premio_capi animaleAmmesso : animaliAmmessi)
			if (animaleAmmesso.getIdCapo().equals(animaleDaControllare.getCapoId()))
				return true;

		return false;
	}

	public static Integer contaFestivi(Date dataPrecedente, Date dataSuccessiva) {

		int domeniche = 0;
		int numeroGiorniFestiviCompresi = 0;
		List<Date> giorniFestivi = new ArrayList<Date>();
		if (!giorniFestivi.isEmpty())
			giorniFestivi.clear();
		LocalDate data1 = LocalDateConverter.convertToLocalDateViaInstant(dataPrecedente);
		LocalDate data2 = LocalDateConverter.convertToLocalDateViaInstant(dataSuccessiva);
		int anno1 = data1.getYear();
		int anno2 = data2.getYear();

		// se le date sono lo stesso giorno
		if (data1.isEqual(data2)) {
			domeniche = 0;
		}

		if (data1.isBefore(data2)) {

			do {

				data1 = data1.plusDays(1);
				if (data1.getDayOfWeek() == DayOfWeek.SUNDAY) {
					domeniche++;
				}
			} while (!data1.isEqual(data2));
		} else {
			if (data1.isAfter(data2)) {

				do {

					data2 = data2.plusDays(1);
					if (data2.getDayOfWeek() == DayOfWeek.SUNDAY) {
						domeniche++;
					}
				} while (!(data2.isEqual(data1)));
			}
		}
		// se le due date non si trovano nello stesso anno

		if (anno1 != anno2) {

			giorniFestivi.addAll(DateUtilService.getGiorniFestivi(String.valueOf(anno1)));
			giorniFestivi.addAll(DateUtilService.getGiorniFestivi(String.valueOf(anno2)));

		} else {

			giorniFestivi.addAll(DateUtilService.getGiorniFestivi(String.valueOf(anno1)));

		}

		for (Date giorno : giorniFestivi) {
			if (giorno.after(dataPrecedente) && giorno.before(dataSuccessiva)) {
				numeroGiorniFestiviCompresi++;
			}

		}
		return numeroGiorniFestiviCompresi + domeniche;
	}

	public static Boolean isBeneficiarioCapiDoppi(Integer annoCampagna, String codicePremio, String cuaaProprietario, Long idCapo, ControlliService controlliService) {
		
		String cuaaBeneficiario = controlliService.getCuaaBeneficiarioCapiDoppi(annoCampagna, codicePremio, idCapo);
		
		if(!cuaaBeneficiario.equals("") && cuaaBeneficiario.toUpperCase().equals(cuaaProprietario.toUpperCase()))
			
			//SONO IO IL BENEFICIARIO DEL CAPO ANIMALE
			return true;
		
		else
			
			//SONO SONO IO IL BENEFICIARIO DEL CAPO ANIMALE
			return false;
	}
	
	public static HashMap<String, BigDecimal> calcoloEsito(BigDecimal capiAccertati,BigDecimal capiAnomali,BigDecimal capiSanzionati, BigDecimal capiRichiesti){
	
		HashMap<String, BigDecimal> result = new HashMap<>();
	    BigDecimal capiPagabili = BigDecimal.ZERO;
		BigDecimal esito = BigDecimal.ZERO;
		BigDecimal sogliaPagabiliVenti = new BigDecimal("0.2");
		BigDecimal sogliaPagabiliDieci = new BigDecimal("0.1");
			
		esito = capiSanzionati.add(capiAnomali).divide(capiAccertati.subtract(capiAnomali), MathContext.DECIMAL128);
		BigDecimal newEsito = esito.setScale(2, RoundingMode.HALF_UP);
		if (newEsito.compareTo(sogliaPagabiliDieci) <= 0 )
			capiPagabili = capiAccertati.multiply(BigDecimal.ONE.subtract(newEsito).setScale(0, RoundingMode.HALF_UP));
			else if (newEsito.compareTo(sogliaPagabiliDieci) > 0 && newEsito.compareTo(sogliaPagabiliVenti) <= 0 ) 
				capiPagabili = capiAccertati.multiply(BigDecimal.valueOf(2).subtract(newEsito).setScale(0, RoundingMode.HALF_UP));
		else
			capiPagabili = BigDecimal.ZERO;

	result.put("capiPagabili", capiPagabili);
	result.put("esito", newEsito);
	return result;
		
	}

	
	public static Boolean flagDuplicatiRichiedenti(List<Dmt_t_clsCapoMacellato> duplicatiMacellati, String cuaa, ControlliService controlliService) {

		Dmt_t_anagrafica_allevamenti allev1;

		if (duplicatiMacellati.size() == 1 && duplicatiMacellati.get(0).getCuaa().equals(cuaa))
			return true;
		
		if (duplicatiMacellati.size() == 2) {

			// se la vacca compare due volte nello stesso allevamento, controllare chi è il
			// proprietario e chi è il detentore
			if (duplicatiMacellati.get(0).getAllevId().equals(duplicatiMacellati.get(1).getAllevId())) {

				allev1 = controlliService
						.getAnagraficaByIdAllevamento(BigDecimal.valueOf(duplicatiMacellati.get(0).getAllevId()));

				if (((!allev1.getCod_fiscale_deten().equals(null))
						&& (allev1.getCod_fiscale_deten().equals(duplicatiMacellati.get(0).getCuaa())
								&& allev1.getCodFiscaleProp().equals(duplicatiMacellati.get(1).getCuaa())))
						|| ((!allev1.getCod_fiscale_deten().equals(null))
								&& (allev1.getCod_fiscale_deten().equals(duplicatiMacellati.get(1).getCuaa())
										&& allev1.getCodFiscaleProp().equals(duplicatiMacellati.get(0).getCuaa()))))
					if(allev1.getCod_fiscale_deten().equals(cuaa))
						return allev1.getCod_fiscale_deten() != null && allev1.getCod_fiscale_deten().equals(cuaa);
				
			} 
		} 
			
		return false;
	}
	
	public static Boolean controlloTempisticheDiRegistrazione(Dmt_t_Tws_bdn_du_capi_bovini b) {
			
		int contatoreFestivita = 0;
		contatoreFestivita= UtilControlli.contaFestivi(b.getVaccaDtInserBdnIngresso(), b.getVaccaDtComAutIngresso());
		if((UtilControlli.differenzaGiorni(b.getVaccaDtComAutIngresso(), b.getVaccaDtIngresso()) <= 7) &&
		   	(UtilControlli.differenzaGiorni(b.getVaccaDtInserBdnIngresso(), b.getVaccaDtComAutIngresso()) <= 7 )) {
		   		return true;
		   	}else if((UtilControlli.differenzaGiorni(b.getVaccaDtComAutIngresso(), b.getVaccaDtIngresso()) > 7) ||
		   	    	(UtilControlli.differenzaGiorni(b.getVaccaDtInserBdnIngresso(), b.getVaccaDtComAutIngresso()) > 7 + contatoreFestivita)) {
		   		return false;
		   	}
		return false;
	}
	
	public static Boolean controlloTempisticheDiRegistrazione(Dmt_t_clsCapoMacellato m) {
		
		int contatoreFestivita = 0;
		contatoreFestivita= UtilControlli.contaFestivi(m.getDtInserimentoBdnIngresso(), m.getDtComAutoritaIngresso());
		if((UtilControlli.differenzaGiorni(m.getDtComAutoritaIngresso(), m.getDtIngresso()) <= 7) &&
	    	(UtilControlli.differenzaGiorni(m.getDtInserimentoBdnIngresso(), m.getDtComAutoritaIngresso()) <= 7 )) {
				return true;
	   	}else if((UtilControlli.differenzaGiorni(m.getDtComAutoritaIngresso(), m.getDtIngresso()) > 7) ||
	    	    	(UtilControlli.differenzaGiorni(m.getDtInserimentoBdnIngresso(), m.getDtComAutoritaIngresso()) > 7 + contatoreFestivita)) {
	    		return false;
	    	}
		return false;
	}
	
	public static void controlloRegistrazioneStallaDuplicato(Dmt_t_Tws_bdn_du_capi_bovini b, ControlliService controlliService, String cuaa,Integer annoCampagna, Dmt_t_sessione sessione) {
		
		//SI PRENDE LA LISTA DEGLI ALLEVAMENTI DEL CUAA E SI FA IL MACHING CON L'ID DELL'ALLEVAMENTO DEL CAPO E SE COMBACIA LO SALVO A DB.
		List<Long> listaAllevamentiPerCuaa = controlliService.getListaAllevamentiPerCuaa(cuaa, sessione.getIdSessione());
		if(!listaAllevamentiPerCuaa.isEmpty() && listaAllevamentiPerCuaa.contains(b.getAllev_id()))
			controlliService.saveAllevamentoBeneficiarioControlloStallaDoppia(sessione, b.getCapoId(), b.getAllev_id(),annoCampagna , cuaa);
	}
	
	public static void controlloRegistrazioneStallaDuplicato(Dmt_t_clsCapoMacellato m, ControlliService controlliService, String cuaa,Integer annoCampagna, Dmt_t_sessione sessione) {
		
		//SI PRENDE LA LISTA DEGLI ALLEVAMENTI DEL CUAA E SI FA IL MACHING CON L'ID DELL'ALLEVAMENTO DEL CAPO E SE COMBACIA LO SALVO A DB.
		List<Long> listaAllevamentiPerCuaa = controlliService.getListaAllevamentiPerCuaa(cuaa, sessione.getIdSessione());
		if(!listaAllevamentiPerCuaa.isEmpty() && listaAllevamentiPerCuaa.contains(m.getAllevId()))
			controlliService.saveAllevamentoBeneficiarioControlloStallaDoppia(sessione, m.getCapoId(), m.getAllevId(),annoCampagna , cuaa);
	}
	
}