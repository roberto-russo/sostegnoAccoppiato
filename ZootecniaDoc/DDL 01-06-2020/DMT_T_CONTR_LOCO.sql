--------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  Drop Table DMT_T_CONTR_LOCO
--------------------------------------------------------

DROP TABLE "DEMETRA"."DMT_T_CONTR_LOCO";

--------------------------------------------------------
--  DDL for Table DMT_T_CONTR_LOCO
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_CONTR_LOCO" 
   (	"CUAA" VARCHAR2(16 CHAR), 
	"MARCHIO" VARCHAR2(14 CHAR), 
	"ANNO" NUMBER(4,0), 
	"ANOMALIE_ZOO" NUMBER(10,0), 
	"ANOMALIE_CGO" VARCHAR2(10 CHAR), 
	"COD_ASL" VARCHAR2(16 CHAR), 
	"COD_CAI" VARCHAR2(16 CHAR), 
	"COD_UTE" VARCHAR2(5 CHAR), 
	"CUAA_NORMALIZZATO" VARCHAR2(20 CHAR), 
	"DESCRIZIONE_ANOMALIA" VARCHAR2(250 CHAR), 
	"DATA_NASCITA" DATE, 
	"NOTE" VARCHAR2(250 CHAR), 
	"PROVINCIA" VARCHAR2(25 CHAR), 
	"PROVINCIA_ISTAT" NUMBER(10,0), 
	"REGIONE" VARCHAR2(25 CHAR), 
	"REGIONE_ISTAT" NUMBER(19,0), 
	"SESSO" VARCHAR2(1 CHAR)
   ) SEGMENT CREATION DEFERRED 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_CONTR_LOCO
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_CONTR_LOCO" ON "DEMETRA"."DMT_T_CONTR_LOCO" ("CUAA", "MARCHIO", "ANNO") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_CONTR_LOCO
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_CONTR_LOCO" MODIFY ("CUAA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CONTR_LOCO" MODIFY ("MARCHIO" NOT NULL ENABLE);
  
  ALTER TABLE "DEMETRA"."DMT_T_CONTR_LOCO" MODIFY ("ANNO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CONTR_LOCO" ADD CONSTRAINT "PK_DMT_T_CONTR_LOCO" PRIMARY KEY ("CUAA", "MARCHIO", "ANNO");
