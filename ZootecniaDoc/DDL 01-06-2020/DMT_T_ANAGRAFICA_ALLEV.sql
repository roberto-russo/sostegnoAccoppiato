--------------------------------------------------------
--  File creato - mercoled�-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DROP Table DMT_T_ANAGRAFICA_ALLEV
--------------------------------------------------------

  DROP TABLE "DEMETRA"."DMT_T_ANAGRARFICA_ALLEV"; 

--------------------------------------------------------
--  DDL for Table DMT_T_ANAGRAFICA_ALLEV
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_ANAGRAFICA_ALLEV" 
   (	"ID_AUTOGENERATO" NUMBER(19,0), 
	"ALLEV_ID" NUMBER(19,2), 
	"AUTORIZZAZIONE_LATTE" VARCHAR2(1 CHAR), 
	"AZIENDA_CODICE" VARCHAR2(15 CHAR), 
	"CAP" VARCHAR2(5 CHAR), 
	"CAPI_TOTALI" NUMBER(19,2), 
	"COD_FISCALE_PROP" VARCHAR2(16 CHAR), 
	"COD_FISCALE_DETEN" VARCHAR2(16 CHAR), 
	"COMUNE" VARCHAR2(50 CHAR), 
	"DATA_CALCOLO_CAPI" DATE, 
	"DENOM_DETENTORE" VARCHAR2(100 CHAR), 
	"DENOM_PROPRIETARIO" VARCHAR2(100 CHAR), 
	"DENOMINAZIONE" VARCHAR2(100 CHAR), 
	"DT_FINE_ATTIVITA" DATE, 
	"DT_FINE_DETENTORE" DATE, 
	"DT_INIZIO_ATTIVITA" DATE, 
	"DT_INIZIO_DETENTORE" DATE, 
	"FOGLIO_CATASTALE" VARCHAR2(255 CHAR), 
	"INDIRIZZO" VARCHAR2(100 CHAR), 
	"LATITUDINE" NUMBER(11,6), 
	"LOCALITA" VARCHAR2(50 CHAR), 
	"LONGITUDINE" NUMBER(11,6), 
	"ORIENTAMENTO_PRODUTTIVO" VARCHAR2(50 CHAR), 
	"PARTICELLA" VARCHAR2(255 CHAR), 
	"SEZIONE" VARCHAR2(255 CHAR), 
	"SOCCIDA" VARCHAR2(255 CHAR), 
	"SPE_CODICE" VARCHAR2(15 CHAR), 
	"SUBALTERNO" VARCHAR2(255 CHAR), 
	"TIPO_ALLEV_COD" VARCHAR2(5 CHAR), 
	"TIPO_ALLEV_DESCR" VARCHAR2(25 CHAR), 
	"TIPO_PRODUZIONE" VARCHAR2(5 CHAR), 
	"ID_SESSIONE" NUMBER(19,0)
   ) SEGMENT CREATION IMMEDIATE 
  
  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_ANAGRAFICA_ALLEV
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_ANAGRAFICA_ALLEV" ON "DEMETRA"."DMT_T_ANAGRAFICA_ALLEV" ("ID_AUTOGENERATO") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_ANAGRAFICA_ALLEV
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_ANAGRAFICA_ALLEV" MODIFY ("ID_AUTOGENERATO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_ANAGRAFICA_ALLEV" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_ANAGRAFICA_ALLEV" ADD CONSTRAINT PK_DMT_T_ANAGRAFICA_ALLEV PRIMARY KEY ("ID_AUTOGENERATO");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_ANAGRAFICA_ALLEV
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_ANAGRAFICA_ALLEV" ADD CONSTRAINT "FK_DMT_T_SESSIONE_12" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;