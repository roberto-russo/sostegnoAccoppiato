package it.csi.demetra.demetraws.zoo.controlli;

/**
 * Razze ammissibili per ciascuna delle misure previste secondo allegato V del DM 7 giugno 2018 n. 5465
 *
 * @author Bcsoft
 * @version 1.0.0 (15/04/2020)
 */
public class RazzeAmmissibili {


    public RazzeAmmissibili() {

    }

    private static boolean isAnarb(String razza) {
        return razza.equals("BRUNA");
    }

    private static boolean isAnabic(String razza) {
        return razza.equals("MARCHIGIANA") || razza.equals("ROMAGNOLA") || razza.equals("CHIANINA") || razza.equals("MAREMMANA") || razza.equals("PODOLICA");
    }

    private static boolean isAnaborapi(String razza) {
        return razza.equals("PIEMONTESE");
    }

    private static boolean isAnaborava(String razza) {
        return razza.equals("VALDOSTANA PEZZATA ROSSA") || razza.equals("VALDOSTANA PEZZATA NERA") || razza.equals("VALDOSTANA CASTANA");
    }

    private static boolean isAnacli(String razza) {
        return razza.equals("CHAROLAIS") || razza.equals("LIMOUSINE");
    }

    private static boolean isAnagra(String razza) {
        return razza.equals("GRIGIO ALPINA");
    }

    private static boolean isAnapri(String razza) {
        return razza.equals("PEZZATA ROSSA ITALIANA SIMMENTAL");
    }

    private static boolean isAnare(String razza) {
        return razza.equals("RENDENA");
    }

    private static boolean isAIA(String razza) {
        return razza.equals("PINZGAUER");
    }

    private static boolean isAIA2(String razza) {
        return razza.equals("CABANNINA") || razza.equals("MODENESE") || razza.equals("BIANCA VAL PADANA") || razza.equals("BURLINA") || razza.equals("AGEROLESE") ||
                razza.equals("CALVANA") || razza.equals("CINISARA") || razza.equals("GARFAGNINA") || razza.equals("MODICANA") || razza.equals("SICILIANA") ||
                razza.equals("SARDA") || razza.equals("SARDO BRUNA") || razza.equals("SARDO MODICANA") || razza.equals("MUCCA PISANA") || razza.equals("MUCCO PISANA") || razza.equals("PISANA");
    }

    private static boolean isNoClass(String razza) {
        return razza.equals("PEZZATA ROSSA D'OROPA") || razza.equals("PONTREMOLESE") || razza.equals("PUSTERTALER SPRINZEN") || razza.equals("Pusterer Sprinzen PUSTERER SPRINZEN") ||
                razza.equals("PUSTERTALER SPRINZEN") || razza.equals("PUSTERER SPRINZEN") || razza.equals("PUSTERTALER BARA'") || razza.equals("VARZESE OTTONESE TORTONESE") ||
                razza.equals("VARZESE OTTONESE VARZESE") || razza.equals("VARZESE OTTONESE") || razza.equals("BOLNDE D'AQUITAINE") || razza.equals("ABERDEEN") || razza.equals("ANGUS") ||
                razza.equals("HIGLAND") || razza.equals("ANGLER") || razza.equals("AUBRAC") || razza.equals("BEEFMASTER") || razza.equals("dexter") || razza.equals("SALERS") || razza.equals("WAGYU");
    }

    public static boolean isRazzaAmmissibile(String razza) {
        return RazzeAmmissibili.isAIA(razza) || RazzeAmmissibili.isAIA2(razza) || RazzeAmmissibili.isAnabic(razza) ||
                RazzeAmmissibili.isAnaborapi(razza) || RazzeAmmissibili.isAnaborava(razza) ||
                RazzeAmmissibili.isAnacli(razza) || RazzeAmmissibili.isAnagra(razza) || RazzeAmmissibili.isAnapri(razza) ||
                RazzeAmmissibili.isAnarb(razza) || RazzeAmmissibili.isAnare(razza) || RazzeAmmissibili.isNoClass(razza);
    }
}
