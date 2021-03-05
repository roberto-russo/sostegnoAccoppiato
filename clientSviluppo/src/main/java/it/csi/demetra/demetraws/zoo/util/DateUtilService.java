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
		
		if(!giorniFestivi.isEmpty()){
			giorniFestivi.clear();
		}
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
		try {
			Date dateConverted = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").parse(dateString);
			return dateConverted;
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("Errore durante la conversione della data: - ");
			return null;
		} 
	}

	private static Date getCapodanno() {
		try {
			capodanno = SIMPLE_DATE_FORMAT.parse(capodannoString+"/"+ANNO);
			return capodanno;
		} catch (ParseException e) {
			System.err.println(e);
			System.out.println("Errore durante la creazione della data: - ");
			return null;
		}
	}

	private static Date getEpifania() {
		try {
			epifania = SIMPLE_DATE_FORMAT.parse(epifaniaString+"/"+ANNO);
			return epifania;
		} catch (ParseException e) {
			System.err.println(e);
			System.out.println("Errore durante la creazione della data: - ");
			return null;
		}	
	}

	private static Date getPasqua() {
		try {
			pasqua = SIMPLE_DATE_FORMAT.parse(pasquaString+"/"+ANNO);
			return pasqua;
		} catch (ParseException e) {
			System.err.println(e);
			System.out.println("Errore durante la creazione della data: - ");
			return null;
		}	
	}

	private static Date getPasquetta() {
		try {
			pasquetta = SIMPLE_DATE_FORMAT.parse(pasquettaString+"/"+ANNO);
			return pasquetta;
		} catch (ParseException e) {
			System.err.println(e);
			System.out.println("Errore durante la creazione della data: - ");
			return null;
		}	
	}

	private static Date getAnniversarioLiberazione() {
		try {
			anniversarioLiberazione = SIMPLE_DATE_FORMAT.parse(anniversarioLiberazioneString+"/"+ANNO);
			return anniversarioLiberazione;
		} catch (ParseException e) {
			System.err.println(e);
			System.out.println("Errore durante la creazione della data: - ");
			return null;
		}
	}

	private static Date getFestaLavoro() {
		try {
			festaLavoro = SIMPLE_DATE_FORMAT.parse(festaLavoroString+"/"+ANNO);
			return festaLavoro;
		} catch (ParseException e) {
			System.err.println(e);
			System.out.println("Errore durante la creazione della data: - ");
			return null;
		}	
	}

	private static Date getFestaRepubblica() {
		try {
			festaRepubblica = SIMPLE_DATE_FORMAT.parse(festaRepubblicaString+"/"+ANNO);
			return festaRepubblica;
		} catch (ParseException e) {
			System.err.println(e);
			System.out.println("Errore durante la creazione della data: - ");
			return null;
		}	
	}

	private static Date getFerragosto() {
		try {
			ferragosto = SIMPLE_DATE_FORMAT.parse(ferragostoString+"/"+ANNO);
			return ferragosto;
		} catch (ParseException e) {
			System.err.println(e);
			System.out.println("Errore durante la creazione della data: - ");
			return null;
		}	
	}

	private static Date getTuttiSanti() {
		try {
			tuttiSanti = SIMPLE_DATE_FORMAT.parse(tuttiSantiString+"/"+ANNO);
			return tuttiSanti;
		} catch (ParseException e) {
			System.err.println(e);
			System.out.println("Errore durante la creazione della data: - ");
			return null;
		}	
	}

	private static Date getImmacolata() {
		try {
			immacolata = SIMPLE_DATE_FORMAT.parse(immacolataString+"/"+ANNO);
			return immacolata;
		} catch (ParseException e) {
			System.err.println(e);
			System.out.println("Errore durante la creazione della data: - ");
			return null;
		}	
	}

	private static Date getNatale() {
		try {
			natale = SIMPLE_DATE_FORMAT.parse(nataleString+"/"+ANNO);
			return natale;
		} catch (ParseException e) {
			System.err.println(e);
			System.out.println("Errore durante la creazione della data: - ");
			return null;
		}	
	}

	private static Date getSantoStefano() {
		try {
			santoStefano = SIMPLE_DATE_FORMAT.parse(santoStefanoString+"/"+ANNO);
			return santoStefano;
		} catch (ParseException e) {
			System.err.println(e);
			System.out.println("Errore durante la creazione della data: - ");
			return null;
		}	
	}	
}
