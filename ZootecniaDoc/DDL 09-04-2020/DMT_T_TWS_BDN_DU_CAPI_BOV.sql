--------------------------------------------------------
--  File creato - gioved�-aprile-09-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_TWS_BDN_DU_CAPI_BOV
--------------------------------------------------------

  CREATE TABLE "ZOOTECNIA"."DMT_T_TWS_BDN_DU_CAPI_BOV" 
   (	"ID_ALLEVAMENTO" NUMBER(19,0), 
	"ID_CAPO" NUMBER(19,0), 
	"ID_SESSIONE" NUMBER(19,0), 
	"VITELLO_CAPO_ID" NUMBER(19,0), 
	"COD_AZIENDA" VARCHAR2(12 CHAR), 
	"AZIENDA_LATITUDINE" FLOAT(126), 
	"AZIENDA_LONGITUDINE" FLOAT(126), 
	"COD_LIBRO" VARCHAR2(3 CHAR), 
	"CODICE" VARCHAR2(16 CHAR), 
	"CODICE_VITELLO" VARCHAR2(16 CHAR), 
	"CUAA" VARCHAR2(16 CHAR), 
	"DATA_NASCITA" DATE, 
	"DESCR_LIBRO" VARCHAR2(500 CHAR), 
	"DATA_FINE_DETENZIONE" DATE, 
	"DATA_INIZIO_DETENZIONE" DATE, 
	"DATA_NASCITA_VITELLO" DATE, 
	"FLAG_DELEGATO" VARCHAR2(10 CHAR), 
	"FLAG_DELEGATO_INGRESSO_VACCA" VARCHAR2(1 CHAR), 
	"FLAG_DELEGATO_INGRESSO_VITELLO" VARCHAR2(1 CHAR), 
	"FLAG_DELEGATO_NASCITA_VITELLO" VARCHAR2(1 CHAR), 
	"FLAG_IBR" VARCHAR2(1 CHAR), 
	"FLAG_PROROGA_MARCATURA" VARCHAR2(1 CHAR), 
	"FLAG_RISPETTO_PREVALENZA_IBR" VARCHAR2(10 CHAR), 
	"COD_RAZZA" VARCHAR2(3 CHAR), 
	"RUOLO_UTENTE_INGR_VACCA" VARCHAR2(3 CHAR), 
	"RUOLO_UTENTE_INGR_VITELLO" VARCHAR2(3 CHAR), 
	"RUOLO_UTENTE_NASC_VITELLO" VARCHAR2(3 CHAR), 
	"SESSO" VARCHAR2(1 CHAR), 
	"SESSO_VITELLO" VARCHAR2(1 CHAR), 
	"VACCA_DATA_COM_AUT_INGRESSO" DATE, 
	"VACCA_DATA_INGRESSO" DATE, 
	"VACCA_DATA_INSER_BDN_INGRESSO" DATE, 
	"VITELLO_DATA_APPL_MARCHIO" DATE, 
	"VITELLO_DATA_COM_AUT_INGRESSO" DATE, 
	"VITELLO_DATA_COM_AUT_NASCITA" DATE, 
	"VITELLO_DATA_INSER_BDN_NASCITA" DATE, 
	"VITELLO_TIPO_ORIGINE" VARCHAR2(1 CHAR), 
	"VITELLO_DATA_INS_BDN_INGRESSO" DATE, 
	"CODICE_ERRORE_BOVINI_FK" VARCHAR2(400 CHAR), 
	"ID_SESSIONE_BOVINI_FK" NUMBER(19,0), 
	"NUMERO_CAPI_BOVINI_FK" NUMBER(19,0), 
	"SESSIONE" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0012795
--------------------------------------------------------

  CREATE UNIQUE INDEX "ZOOTECNIA"."SYS_C0012795" ON "ZOOTECNIA"."DMT_T_TWS_BDN_DU_CAPI_BOV" ("ID_ALLEVAMENTO", "ID_CAPO", "ID_SESSIONE", "VITELLO_CAPO_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_TWS_BDN_DU_CAPI_BOV
--------------------------------------------------------

  ALTER TABLE "ZOOTECNIA"."DMT_T_TWS_BDN_DU_CAPI_BOV" MODIFY ("ID_ALLEVAMENTO" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_TWS_BDN_DU_CAPI_BOV" MODIFY ("ID_CAPO" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_TWS_BDN_DU_CAPI_BOV" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_TWS_BDN_DU_CAPI_BOV" MODIFY ("VITELLO_CAPO_ID" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_TWS_BDN_DU_CAPI_BOV" MODIFY ("SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_TWS_BDN_DU_CAPI_BOV" ADD PRIMARY KEY ("ID_ALLEVAMENTO", "ID_CAPO", "ID_SESSIONE", "VITELLO_CAPO_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_TWS_BDN_DU_CAPI_BOV
--------------------------------------------------------

  ALTER TABLE "ZOOTECNIA"."DMT_T_TWS_BDN_DU_CAPI_BOV" ADD CONSTRAINT "FKIR9T6QWMIY7XO50OL9AGDUBSA" FOREIGN KEY ("CODICE_ERRORE_BOVINI_FK", "ID_SESSIONE_BOVINI_FK", "NUMERO_CAPI_BOVINI_FK")
	  REFERENCES "ZOOTECNIA"."DMT_D_CLS_PREMIO_VAL_RESP" ("CODICE_ERRORE", "ID_SESSIONE", "NUMERO_CAPI") ENABLE;
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_TWS_BDN_DU_CAPI_BOV" ADD CONSTRAINT "FKKUJVX89D9T57P10YM27Y9E7V2" FOREIGN KEY ("SESSIONE")
	  REFERENCES "ZOOTECNIA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
