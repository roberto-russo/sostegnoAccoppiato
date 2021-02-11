package it.csi.demetra.demetraws.zoo.util;

import org.apache.log4j.Logger;

public class DEMETRAWSConstants
{

  public static class TIPO_DOCUMENTO_DOQUI
  {
	  public static final long COMUNICAZIONE_AVVIO_PROCEDIMENTO  = 2115;
	  public static final int POSTA_ELETTRONICA_CERTIFICATA  = 9001;
  }	
	
  public static class DEMETRAWS
  {
	  public static final Long UTENTE_PORTING = 9999999995L;
	  public static final String ATTORE_PROVINCIALE = "FUNZIONARIO_PROVINCIALE";
	  public static final String ATTORE_REGIONALE = "FUNZIONARIO_REGIONALE";
	  public static final String TIPO_AMMINISTRAZIONE_PV = "PV";
  }
	
  public class JNDI
  {
    public static final String MAIL_SESSION = "java:jboss/mail/Default";
  }

  public static class OGGETTO
  {
    public static class CODICE
    {
      public static final String COMUNICAZIONE_RINUNCIA = "DRIN";
    }
  }
  
  public static class LOGGIN
  {
    public static String LOGGER_NAME = "demetraws";

    public static class LOGGER
    {
      public static Logger PRESENTATION = Logger.getLogger(LOGGIN.LOGGER_NAME + ".presentation");
//      public static Logger PRESENTATION = Logger.getLogger(LOGGIN.LOGGER_NAME + ".presentation");
    }
  }

  public static final String CRITERIO_SOVRASCRIVI_IDENTIFICATIVO = "**";

  public static class DEMETRAWEB
  {
    public static final int ID = 60;
  }

  public static class SERVICE
  {
    public static class AGRIWELL
    {
      public static class RETURN_CODE
      {
        public static final int SUCCESS = 0;
        public static final int FAIL    = 1;
      }
      public static class DOCUMENTI
      {
        public static class VISIBILITA
        {
          public static final String TUTTI = "T";
          public static final String PA    = "P";
        }
      }
    }
  }
  
  public static class FIRMA_GRAFOMETRICA
  {
    public static class TESTO
    {
      public static final String FIRMA = "Firma del richiedente";
      public static final String DATA  = "Data Firma";
      public static final String A_CAPO  = "&acapo&";
      
    }
  }
  
  public static class ELABORAZIONE_STAMPA
  {
    public static class TESTO
    {
      public static final String PROTOCOLLO = "SPAZIO RISERVATO AL PROTOCOLLO";
    }
  }
  
  public static class SIAPCOMMWS
  {
    public static class DATI_PROTOCOLLO
    {
      public static class TIPO_PROTOCOLLO
      {
        public static final String INGRESSO = "I";
        public static final String USCITA = "U";
      }
    }
  }
  public static class FLAGS
  {
    public static String SI = "S";
    public static String NO = "N";
    
    public static class FIRMA_GRAFOMETRICA
    {
      public static String DA_FIRMARE_GRAFOMETRICAMENTE = "S";
      public static String DA_NON_FIRMARE               = "N";
      public static String FIRMATA_GRAFOMETRICAMENTE    = "N";
      public static String FIRMATA_SU_CARTA             = "C";
      public static String FIRMATA_ELETTRONICAMENTE     = "E";
      public static String VALIDATA_UFFICIO             = "U";
    }
  }

  public static final class LOGGING
  {
    public static final String LOGGER_NAME = "demetraws";
  }

  public static final class PARAMETRO
  {
    public static final String DOQUIAGRI_CARTELLA                        = "DOQUIAGRI_CARTELLA";
    public static final String DOQUIAGRI_CLASS_REG                       = "DOQUIAGRI_CLASS_REG";
    public static final String DOQUIAGRI_FASCICOLA                       = "DOQUIAGRI_FASCICOLA";
    public static final String BATCH_GESTIONE_ANOMALIE_SUI_FILE_ALLEGATI = "ALLEG_FILE_ANOMALIE";
    public static final String MAIL_BATCH_RPDTAL000                      = "MAIL_RPDTAL000";
    public static final String MAIL_BATCH_RPDTTM000                      = "MAIL_RPDTTM000";
    public static final String MAIL_BATCH_RPDTPE000                      = "MAIL_RPDTPE000";
    public static final String DOQUIAGRI_FLAG_PROT                       = "DOQUIAGRI_FLAG_PROT";
    public static final String DOQUIAGRI_FLAG_PEC                        = "DOQUIAGRI_FLAG_PEC";
    public static final String DOQUIAGRI_ALLEG_ERED                      = "DOQUIAGRI_ALLEG_ERED";
    public static final String DOQUIAGRI_ALLEG_PROT                      = "DOQUIAGRI_ALLEG_PROT";
    public static final String DOQUIAGRI_USR_PSW_SC                      = "DOQUIAGRI_USR_PSW_SC"; //user#password
    public static final String OGGETTO_RICEVUTA                          = "OGGETTO_RICEVUTA";
    public static final String MITTENTE_RICEVUTA                         = "MITTENTE_RICEVUTA";
    public static final String TESTO_RICEVUTA                            = "TESTO_RICEVUTA";
    public static final String OGGETTO_ISTR                        		 = "OGGETTO_ISTR";
    public static final String CORPO_ISTR                        		 = "CORPO_ISTR";
  }

  public static final class STATO
  {
    public static final class OGGETTO_STAMPA
    {
      public static final class ID
      {
        public static final int GENERAZIONE_STAMPA_IN_CORSO          = 1;
        public static final int IN_ATTESA_FIRMA_GRAFOMETRICA         = 2;
        public static final int IN_ATTESA_FIRMA_SU_CARTA             = 3;
        public static final int IN_ATTESA_FIRMA_ELETTRONICA_LEGGERA  = 4;
        public static final int FIRMATA_GRAFOMETRICAMENTE            = 5;
        public static final int FIRMATO_CON_CREDENZIALI_BENEFICIARIO = 6;
        public static final int FIRMATO_SU_CARTA                     = 7;
        public static final int STAMPA_FALLITA                       = 8;
        public static final int STAMPA_ALLEGATA                      = 10;
        public static final int STAMPATA                             = 11;
      }
    }
    public static final class ELAB_MASSIVA
    {
      public static final class ESITO
      {
        public static final String DA_ELABORARE = "R";
        public static final String IN_CORSO = "I";
        public static final String IN_CORSO_PEC = "X";
        public static final String TRASMISSIONE_FALLITA = "1";
        public static final String TRASMISSIONE_EFFETTUATA = "0";
        public static final String CONTROLLO_PEC_EFFETTUATO = "0";
      }
    }

    public static final class PROCEDIMENTO_OGGETTO
    {
      public static final class ESITO
      {
        public static final class ID
        {
          public static final int POSITIVO  = 1;
          public static final int TRASMESSO = 4;
        }
      }

      public static final class ITER
      {
        public static final class ID
        {
          public static final int TRASMESSO = 10;
          public static final int RINUNCIA_BENEFICIARIO = 98;
        }
      }
    }
  }
  
  public static class USECASE
  {
    public static class STAMPE_OGGETTO
    {
      public static final String INSERISCI_STAMPA_OGGETTO = "CU-demetra-126-I";
      public static final String GENERA_STAMPA_PRATICA    = "CU-demetra-128";
      public static final String GENERA_STAMPA_PSL        = "CU-demetra-134";
    }
  }
  
  public static class demetra
  {
    public static final int ID_TIPOLOGIA_DOC_DMT_SU_DOQUIAGRI = 2000;
    public static final int ID_EDIZIONE_DMT_2014_2020         = 1;
  }
  
  public static class SQL
  {
	  public static class RESULT_CODE
	  {
	    public static final int ERRORE_CRITICO       = 1;
	    public static final int ERRORE_GRAVE         = 2;
	    public static final int ERRORE_NON_BLOCCANTE = 3;
	    public static final int NESSUN_ERRORE        = 0;
	  }
	  
	  public static class MESSAGE
	    {
	      public static final String PLSQL_ERRORE_CRITICO = "Si &egrave; verificato un errore di sistema. Contattare l'assistenza comunicando il seguente messaggio: ";
	      public static final String PLSQL_ERRORE_GRAVE   = "Si &egrave; verificato il seguente errore: ";
	    }
  }
}
