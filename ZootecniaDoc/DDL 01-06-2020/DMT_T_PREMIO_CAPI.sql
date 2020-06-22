--------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DROP Table DMT_T_PREMIO_CAPI
--------------------------------------------------------

DROP TABLE "DEMETRA"."DMT_T_PREMIO_CAPI";

--------------------------------------------------------
--  DDL for Table DMT_T_PREMIO_CAPI
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_PREMIO_CAPI" 
   (	"CODICE_PREMIO" VARCHAR2(3 CHAR), 
	"CUAA" VARCHAR2(16 CHAR), 
	"ID_ALLEVAMENTO" NUMBER(19,0), 
	"ID_CAPO" NUMBER(19,0), 
	"ID_SESSIONE" NUMBER(19,0), 
	"COD_AZIENDA" VARCHAR2(15 CHAR), 
	"CODICE_VITELLO" VARCHAR2(20 CHAR), 
	"FLAG_AMISSIBILE" VARCHAR2(1 CHAR), 
	"MSG" VARCHAR2(255 CHAR)
   )

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_PREMIO_CAPI
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_PREMIO_CAPI" ON "DEMETRA"."DMT_T_PREMIO_CAPI" ("CODICE_PREMIO", "CUAA", "ID_ALLEVAMENTO", "ID_CAPO", "ID_SESSIONE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_PREMIO_CAPI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_PREMIO_CAPI" MODIFY ("CODICE_PREMIO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_PREMIO_CAPI" MODIFY ("CUAA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_PREMIO_CAPI" MODIFY ("ID_ALLEVAMENTO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_PREMIO_CAPI" MODIFY ("ID_CAPO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_PREMIO_CAPI" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_PREMIO_CAPI" MODIFY ("COD_AZIENDA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_PREMIO_CAPI" MODIFY ("FLAG_AMISSIBILE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_PREMIO_CAPI" ADD CONSTRAINT "PK_DMT_T_PREMIO_CAPI" PRIMARY KEY ("CODICE_PREMIO", "CUAA", "ID_ALLEVAMENTO", "ID_CAPO", "ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_PREMIO_CAPI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_PREMIO_CAPI" ADD CONSTRAINT "FK_DMT_T_SESSIONE_07" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
