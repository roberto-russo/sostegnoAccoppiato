--------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DROP Table DMT_T_TBDN_DU_CAPI
--------------------------------------------------------

  DROP TABLE "DEMETRA"."DMT_T_TBDN_DU_CAPI";

--------------------------------------------------------
--  DDL for Table DMT_T_TBDN_DU_CAPI
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_TBDN_DU_CAPI" 
   (	"ID_AUTOGENERATO" NUMBER(19,0), 
	"ALLEV_ID" NUMBER(19,0), 
	"COD_AZIENDA" VARCHAR2(16 CHAR), 
	"CAPO_COD_MADRE" VARCHAR2(25 CHAR), 
	"ID_CAPO" NUMBER(19,0), 
	"COD_LIBRO" VARCHAR2(25 CHAR), 
	"CODICE" VARCHAR2(15 CHAR), 
	"CODICE_PREMIO" VARCHAR2(3 CHAR), 
	"DESC_LIBRO_MADRE" VARCHAR2(50 CHAR), 
	"DATA_FINE_DETENZ" DATE, 
	"DATA_INIZIO_DETENZ" DATE, 
	"DATA_MACELLAZIONE" DATE, 
	"DATA_NASCITA" DATE, 
	"COD_RAZZA" VARCHAR2(3 CHAR) DEFAULT 'TRB', 
	"SESSO" VARCHAR2(1 CHAR), 
	"FK_DMT_D_CLS_PREM_VALID" NUMBER(19,0), 
	"ID_SESSIONE" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_TBDN_DU_CAPI
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_TBDN_DU_CAPI" ON "DEMETRA"."DMT_T_TBDN_DU_CAPI" ("ID_AUTOGENERATO") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_TBDN_DU_CAPI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_TBDN_DU_CAPI" MODIFY ("ID_AUTOGENERATO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TBDN_DU_CAPI" MODIFY ("ALLEV_ID" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TBDN_DU_CAPI" MODIFY ("ID_CAPO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TBDN_DU_CAPI" MODIFY ("CODICE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TBDN_DU_CAPI" MODIFY ("CODICE_PREMIO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TBDN_DU_CAPI" MODIFY ("COD_RAZZA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TBDN_DU_CAPI" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_TBDN_DU_CAPI" ADD CONSTRAINT PK_DMT_T_TBDN_DU_CAPI PRIMARY KEY ("ID_AUTOGENERATO");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_TBDN_DU_CAPI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_TBDN_DU_CAPI" ADD CONSTRAINT "FK_DMT_D_CLS_PREM_VAL_RESP" FOREIGN KEY ("FK_DMT_D_CLS_PREM_VALID")
	  REFERENCES "DEMETRA"."DMT_D_CLS_PREMIO_VAL_RESP" ("DMT_T_TBDN_DU_CAPI") ENABLE;
 
  ALTER TABLE "DEMETRA"."DMT_T_TBDN_DU_CAPI" ADD CONSTRAINT "FK_DMT_T_SESSIONE_13" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
