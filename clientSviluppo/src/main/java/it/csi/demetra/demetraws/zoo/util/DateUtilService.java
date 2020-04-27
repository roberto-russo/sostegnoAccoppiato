package it.csi.demetra.demetraws.zoo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DateUtilService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DateUtilService.class);
	
	private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
	
	private static String ANNO ;
	
	private static Date capodanno;
	private final static String capodannoString = "01/01";
	
	private static Date epifania;
	private final static String epifaniaString = "06/01";
	
	private static Date pasqua;
	private final static String pasquaString = "12/04";
	
	private static Date pasquetta;
	private final static String pasquettaString = "22/04";
	
	private static Date anniversarioLiberazione;
	private final static String anniversarioLiberazioneString = "25/04";
	
	private static Date festaLavoro;
	private final static String festaLavoroString = "01/05";
	
	private static Date festaRepubblica;
	private final static String festaRepubblicaString = "02/06";
	
	private static Date ferragosto;
	private final static String ferragostoString = "15/08";
	
	private static Date tuttiSanti;
	private final static String tuttiSantiString = "01/11";
	
	private static Date immacolata;
	private final static String immacolataString = "08/12";
	
	private static Date natale;
	private final static String nataleString = "25/12";
	
	private static Date santoStefano;
	private final static String santoStefanoString = "26/12";
	
	private static List<Date> giorniFestivi = new ArrayList<Date>();

	public static List<Date> getGiorniFestivi(String anno) {
		
		ANNO = anno;
		
		giorniFestivi.add(DateUtilService.getCapodanno());
		giorniFestivi.add(DateUtilService.getEpifania());
		giorniFestivi.add(DateUtilService.getPasqua());
		giorniFestivi.add(DateUtilService.getPasquetta());
		giorniFestivi.add(DateUtilService.getAnniversarioLiberazione());
		giorniFestivi.add(DateUtilService.getFestaLavoro());
		giorniFestivi.add(DateUtilService.getFestaRepubblica());
		giorniFestivi.add(DateUtilService.getFerragosto());
		giorniFestivi.add(DateUtilService.getTuttiSanti());
		giorniFestivi.add(DateUtilService.getImmacolata());
		giorniFestivi.add(DateUtilService.getNatale());
		giorniFestivi.add(DateUtilService.getSantoStefano());
		
		return giorniFestivi;
		
	}
	
	public static Date getDatefromString (String dateString) {
		LOGGER.info("Inizio conversione data: getDatefromString() ");
		try {
			Date dateConverted = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").parse(dateString);
			LOGGER.info("Fine conversione data: getDatefromString() ");
			return dateConverted;
		} catch (ParseException e) {
			e.printStackTrace();
			LOGGER.error("Errore durante la conversione della data: - ",e);
			return null;
		} 
	}

	private static Date getCapodanno() {
		LOGGER.info("Inizio creazione data: getCapodanno() ");
		try {
			capodanno = SIMPLE_DATE_FORMAT.parse(capodannoString+"/"+ANNO);
			LOGGER.info("Fine creazione data: getCapodanno() ");
			return capodanno;
		} catch (ParseException e) {
			System.err.println(e);
			LOGGER.error("Errore durante la creazione della data: - ",e);
			return null;
		}
	}

	private static Date getEpifania() {
		LOGGER.info("Inizio creazione data: getEpifania() ");
		try {
			epifania = SIMPLE_DATE_FORMAT.parse(epifaniaString+"/"+ANNO);
			LOGGER.info("Fine creazione data: getEpifania() ");
			return epifania;
		} catch (ParseException e) {
			System.err.println(e);
			LOGGER.error("Errore durante la creazione della data: - ",e);
			return null;
		}	
	}

	private static Date getPasqua() {
		LOGGER.info("Inizio creazione data: getPasqua() ");
		try {
			pasqua = SIMPLE_DATE_FORMAT.parse(pasquaString+"/"+ANNO);
			LOGGER.info("Fine creazione data: getPasqua() ");
			return pasqua;
		} catch (ParseException e) {
			System.err.println(e);
			LOGGER.error("Errore durante la creazione della data: - ",e);
			return null;
		}	
	}

	private static Date getPasquetta() {
		LOGGER.info("Inizio creazione data: getPasquetta() ");
		try {
			pasquetta = SIMPLE_DATE_FORMAT.parse(pasquettaString+"/"+ANNO);
			LOGGER.info("Fine creazione data: getPasquetta() ");
			return pasquetta;
		} catch (ParseException e) {
			System.err.println(e);
			LOGGER.error("Errore durante la creazione della data: - ",e);
			return null;
		}	
	}

	private static Date getAnniversarioLiberazione() {
		LOGGER.info("Inizio creazione data: getAnniversarioLiberazione() ");
		try {
			anniversarioLiberazione = SIMPLE_DATE_FORMAT.parse(anniversarioLiberazioneString+"/"+ANNO);
			LOGGER.info("Fine creazione data: getAnniversarioLiberazione() ");
			return anniversarioLiberazione;
		} catch (ParseException e) {
			System.err.println(e);
			LOGGER.error("Errore durante la creazione della data: - ",e);
			return null;
		}
	}

	private static Date getFestaLavoro() {
		LOGGER.info("Inizio creazione data: getFestaLavoro() ");
		try {
			festaLavoro = SIMPLE_DATE_FORMAT.parse(festaLavoroString+"/"+ANNO);
			LOGGER.info("Fine creazione data: getFestaLavoro() ");
			return festaLavoro;
		} catch (ParseException e) {
			System.err.println(e);
			LOGGER.error("Errore durante la creazione della data: - ",e);
			return null;
		}	
	}

	private static Date getFestaRepubblica() {
		LOGGER.info("Inizio creazione data: getFestaRepubblica() ");
		try {
			festaRepubblica = SIMPLE_DATE_FORMAT.parse(festaRepubblicaString+"/"+ANNO);
			LOGGER.info("Fine creazione data: getFestaRepubblica() ");
			return festaRepubblica;
		} catch (ParseException e) {
			System.err.println(e);
			LOGGER.error("Errore durante la creazione della data: - ",e);
			return null;
		}	
	}

	private static Date getFerragosto() {
		LOGGER.info("Inizio creazione data: getFerragosto() ");
		try {
			ferragosto = SIMPLE_DATE_FORMAT.parse(ferragostoString+"/"+ANNO);
			LOGGER.info("Fine creazione data: getFerragosto() ");
			return ferragosto;
		} catch (ParseException e) {
			System.err.println(e);
			LOGGER.error("Errore durante la creazione della data: - ",e);
			return null;
		}	
	}

	private static Date getTuttiSanti() {
		LOGGER.info("Inizio creazione data: getTuttiSanti() ");
		try {
			tuttiSanti = SIMPLE_DATE_FORMAT.parse(tuttiSantiString+"/"+ANNO);
			LOGGER.info("Fine creazione data: getTuttiSanti() ");
			return tuttiSanti;
		} catch (ParseException e) {
			System.err.println(e);
			LOGGER.error("Errore durante la creazione della data: - ",e);
			return null;
		}	
	}

	private static Date getImmacolata() {
		LOGGER.info("Inizio creazione data: getImmacolata() ");
		try {
			immacolata = SIMPLE_DATE_FORMAT.parse(immacolataString+"/"+ANNO);
			LOGGER.info("Fine creazione data: getImmacolata() ");
			return immacolata;
		} catch (ParseException e) {
			System.err.println(e);
			LOGGER.error("Errore durante la creazione della data: - ",e);
			return null;
		}	
	}

	private static Date getNatale() {
		LOGGER.info("Inizio creazione data: getNatale() ");
		try {
			natale = SIMPLE_DATE_FORMAT.parse(nataleString+"/"+ANNO);
			LOGGER.info("Fine creazione data: getNatale() ");
			return natale;
		} catch (ParseException e) {
			System.err.println(e);
			LOGGER.error("Errore durante la creazione della data: - ",e);
			return null;
		}	
	}

	private static Date getSantoStefano() {
		LOGGER.info("Inizio creazione data: getSantoStefano() ");
		try {
			santoStefano = SIMPLE_DATE_FORMAT.parse(santoStefanoString+"/"+ANNO);
			LOGGER.info("Fine creazione data: getSantoStefano() ");
			return santoStefano;
		} catch (ParseException e) {
			System.err.println(e);
			LOGGER.error("Errore durante la creazione della data: - ",e);
			return null;
		}	
	}	
}
