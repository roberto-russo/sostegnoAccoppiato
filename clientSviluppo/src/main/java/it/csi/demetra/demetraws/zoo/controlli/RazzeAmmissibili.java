package it.csi.demetra.demetraws.zoo.controlli;

/**
 * Razze ammissibili per ciascuna delle misure previste secondo allegato V del DM 7 giugno 2018 n. 5465
 * @author Bcsoft
 * @version 1.0.0 (15/04/2020)
 */
public class RazzeAmmissibili {

	
	public RazzeAmmissibili() {
		
	}
	
	private static boolean isAnarb(String razza) {
		if (razza.equals("BRUNA"))
			return true;
		else 
			return false;
	}
	
	private static boolean isAnabic(String razza) {
		if (razza.equals("MARCHIGIANA") || razza.equals("ROMAGNOLA") || razza.equals("CHIANINA") || razza.equals("MAREMMANA")   || razza.equals("PODOLICA"))
			return true;
		else
			return false;
	}
	
	private static boolean isAnaborapi(String razza) {
		if(razza.equals("PIEMONTESE"))
			return true;
		else
			return false;
	}
	
	private static boolean isAnaborava(String razza) {
		if(razza.equals("VALDOSTANA PEZZATA ROSSA") || razza.equals("VALDOSTANA PEZZATA NERA") || razza.equals("VALDOSTANA CASTANA"))
			return true;
		else
			return false;
	}
	
	private static boolean isAnacli(String razza) {
		if(razza.equals("CHAROLAIS") || razza.equals("LIMOUSINE"))
			return true;
		else
			return false;
	}
	
	private static boolean isAnagra(String razza) {
		if(razza.equals("GRIGIO ALPINA"))
			return true;
		else 
			return false;
	}
	
	private static boolean isAnapri(String razza) {
		if(razza.equals("PEZZATA ROSSA ITALIANA SIMMENTAL"))
			return true;
		else
			return false;
	}
	
	private static boolean isAnare(String razza) {
		if(razza.equals("RENDENA"))
			return true;
		else
			return false;
	}
	
	private static boolean isAIA(String razza) {
		if(razza.equals("PINZGAUER"))
			return true;
		else
			return false;
	}
	
	private static boolean isAIA2(String razza) {
		if(razza.equals("CABANNINA") || razza.equals("MODENESE") || razza.equals("BIANCA VAL PADANA") || razza.equals("BURLINA") || razza.equals("AGEROLESE") ||
		   razza.equals("CALVANA")   || razza.equals("CINISARA") || razza.equals("GARFAGNINA") || razza.equals("MODICANA")       || razza.equals("SICILIANA") ||
		   razza.equals("SARDA")     || razza.equals("SARDO BRUNA") || razza.equals("SARDO MODICANA") || razza.equals("MUCCA PISANA") || razza.equals("MUCCO PISANA") || razza.equals("PISANA"))
			return true;
		else
			return false;
	}
	
	private static boolean isNoClass(String razza) {
		if(razza.equals("PEZZATA ROSSA D'OROPA") || razza.equals("PONTREMOLESE") || razza.equals("PUSTERTALER SPRINZEN") || razza.equals("Pusterer Sprinzen PUSTERER SPRINZEN")    || 
		   razza.equals("PUSTERTALER SPRINZEN")  || razza.equals("PUSTERER SPRINZEN") || razza.equals("PUSTERTALER BARA'") || razza.equals("VARZESE OTTONESE TORTONESE")           ||
		   razza.equals("VARZESE OTTONESE VARZESE") || razza.equals("VARZESE OTTONESE") || razza.equals("BOLNDE D'AQUITAINE") || razza.equals("ABERDEEN") || razza.equals("ANGUS") ||
		   razza.equals("HIGLAND") || razza.equals("ANGLER") || razza.equals("AUBRAC")  || razza.equals("BEEFMASTER") || razza.equals("dexter") || razza.equals("SALERS") || razza.equals("WAGYU"))
			return true;
		else
			return false;
	}
	
	public static boolean isRazzaAmmissibile(String razza) {
		if(RazzeAmmissibili.isAIA(razza)       || RazzeAmmissibili.isAIA2(razza)      || RazzeAmmissibili.isAnabic(razza) || 
		   RazzeAmmissibili.isAnaborapi(razza) || RazzeAmmissibili.isAnaborava(razza) || 
		   RazzeAmmissibili.isAnacli(razza)    || RazzeAmmissibili.isAnagra(razza)    || RazzeAmmissibili.isAnapri(razza) || 
		   RazzeAmmissibili.isAnarb(razza)     || RazzeAmmissibili.isAnare(razza) || RazzeAmmissibili.isNoClass(razza))
			return true;
		else
			return false;
	}
}
