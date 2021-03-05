package it.csi.demetra.demetraws.zoo.util;

import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public final class LocalDateConverter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LocalDateConverter.class);

	public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
	    try {
	    	return Instant.ofEpochMilli(dateToConvert.getTime())
	        .atZone(ZoneId.systemDefault())
	        .toLocalDate();
	    } catch (DateTimeException e) {
	    	System.err.println("Errore nella conversione della data.");
			System.out.println("Errore LocalDateConverter: - ");
	    	return null;

	    }
	}
	
	public static Date convertToDateViaInstant(LocalDate dateToConvert) {
		try {
		    return java.util.Date.from(dateToConvert.atStartOfDay()
		      .atZone(ZoneId.systemDefault())
		      .toInstant());
		} catch (Exception e) {
			System.err.println("Errore nella conversione della data.");
			System.out.println("Errore LocalDateConverter: - ");
	    	return null;
		}
	}

	
}
