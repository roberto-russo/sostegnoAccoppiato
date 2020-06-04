--------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DROP Table DMT_T_SUBENTRO_ZOO
--------------------------------------------------------

  DROP TABLE "DEMETRA"."DMT_T_SUBENTRO_ZOO";
  
--------------------------------------------------------
--  DDL for Table DMT_T_SUBENTRO_ZOO
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_SUBENTRO_ZOO" 
   (	"ID_SUBENTRO_ZOO" NUMBER(19,0), 
	"ANNO_CAMPAGNA" NUMBER(10,0), 
	"CUAA_DOMANDA" VARCHAR2(16 CHAR), 
	"CUAA_SUBENTRO" VARCHAR2(16 CHAR), 
	"DATA_FINE" DATE, 
	"DATA_INIZIO" DATE, 
	"EXT_ID_UTENTE_AGGIORNAMENTO" NUMBER(19,0), 
	"NOTE" VARCHAR2(255 CHAR)
   ) SEGMENT CREATION IMMEDIATE 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_SUBENTRO_ZOO
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_SUBENTRO_ZOO" ON "DEMETRA"."DMT_T_SUBENTRO_ZOO" ("ID_SUBENTRO_ZOO") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_SUBENTRO_ZOO
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_SUBENTRO_ZOO" MODIFY ("ID_SUBENTRO_ZOO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_SUBENTRO_ZOO" MODIFY ("CUAA_DOMANDA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_SUBENTRO_ZOO" MODIFY ("CUAA_SUBENTRO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_SUBENTRO_ZOO" ADD CONSTRAINT "PK_DMT_T_SUBENTRO_ZOO" PRIMARY KEY ("ID_SUBENTRO_ZOO");