--------------------------------------------------------
--  File creato - luned�-giugno-01-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DROP TABLE DMT_T_CLS_CAPO_MACELLATO
--------------------------------------------------------

DROP TABLE "DEMETRA"."DMT_T_CLS_CAPO_MACELLATO";

--------------------------------------------------------
--  DDL for Table DMT_T_CLS_CAPO_MACELLATO
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_CLS_CAPO_MACELLATO" 
   (	"ID_AUTOGENERATO" NUMBER(19,0), 
	"ALLEV_ID" NUMBER(19,0), 
	"AZIENDA_CODICE" VARCHAR2(12 CHAR), 
	"AZIENDA_LATITUDINE" NUMBER(11,6), 
	"AZIENDA_LONGITUDINE" NUMBER(11,6), 
	"CAPO_ID" NUMBER(19,0), 
	"COD_LIBRO" VARCHAR2(5 CHAR), 
	"CODICE" VARCHAR2(20 CHAR), 
	"CODICE_PREMIO" VARCHAR2(3 CHAR), 
	"CUAA" VARCHAR2(16 CHAR), 
	"DESCR_LIBRO" VARCHAR2(255 CHAR), 
	"DT_COM_AUTORITA_INGRESSO" DATE, 
	"DT_COM_AUTORITA_USCITA" DATE, 
	"DT_FINE_DETENZIONE" DATE, 
	"DT_INGRESSO" DATE, 
	"DT_INIZIO_DETENZIONE" DATE, 
	"DT_INSERIMENTO_BDN_INGRESSO" DATE, 
	"DT_INSERIMENTO_BDN_USCITA" DATE, 
	"DT_MACELLAZIONE" DATE, 
	"DT_NASCITA" DATE, 
	"DT_USCITA" DATE, 
	"FLAG_DELEGATO_INGRESSO" VARCHAR2(10 CHAR), 
	"FLAG_DELEGATO_USCITA" VARCHAR2(10 CHAR), 
	"RAZZA_CODICE" VARCHAR2(5 CHAR), 
	"RUOLO_UTENTE_INGRESSO" VARCHAR2(10 CHAR), 
	"RUOLO_UTENTE_USCITA" VARCHAR2(10 CHAR), 
	"SESSO" VARCHAR2(1 CHAR), 
	"FK_DMT_D_CLS_PREM_VALID" NUMBER(19,0), 
	"ID_SESSIONE" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 
  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_CLS_CAPO_MACELLATO
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_CLS_CAPO_MACELLATO" ON "DEMETRA"."DMT_T_CLS_CAPO_MACELLATO" ("ID_AUTOGENERATO") 
  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_CLS_CAPO_MACELLATO
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_CLS_CAPO_MACELLATO" MODIFY ("ID_AUTOGENERATO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CLS_CAPO_MACELLATO" MODIFY ("ALLEV_ID" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CLS_CAPO_MACELLATO" MODIFY ("CAPO_ID" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CLS_CAPO_MACELLATO" MODIFY ("CODICE_PREMIO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CLS_CAPO_MACELLATO" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CLS_CAPO_MACELLATO" ADD CONSTRAINT "PK_DMT_T_CLS_CAPO_MACELLATO" PRIMARY KEY ("ID_AUTOGENERATO");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_CLS_CAPO_MACELLATO
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_CLS_CAPO_MACELLATO" ADD CONSTRAINT "FK_DMT_T_SESSIONE_04" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
 
  ALTER TABLE "DEMETRA"."DMT_T_CLS_CAPO_MACELLATO" ADD CONSTRAINT "FK_DMT_D_CLS_PREMIO_VAL_RESP_01" FOREIGN KEY ("FK_DMT_D_CLS_PREM_VALID")
	  REFERENCES "DEMETRA"."DMT_D_CLS_PREMIO_VAL_RESP" ("ID_AUTOGENERATO") ENABLE;
