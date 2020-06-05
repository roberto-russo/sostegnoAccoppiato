--------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_CONSIST_UBA_CENSIM_OVINI
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_CONSIST_UBA_CENSIM_OVINI" 
   (	"P_CUAA" VARCHAR2(16 CHAR),  
	"ID_SESSIONE" NUMBER(19,0), 
	"DATA_FINE_PERIODO" VARCHAR2(12 CHAR), 
	"DATA_INIZIO_PERIODO" VARCHAR2(12 CHAR), 
	"P_TIPO_RESPONSABILITA" VARCHAR2(1 CHAR)
   ) SEGMENT CREATION DEFERRED 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_CONSIST_UBA_CENSIM_OVINI
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_CONS_UBA_CENS_OV" ON "DEMETRA"."DMT_T_CONSIST_UBA_CENSIM_OVINI" ("P_CUAA", "ID_SESSIONE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_CONSIST_UBA_CENSIM_OVINI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_CONSIST_UBA_CENSIM_OVINI" MODIFY ("P_CUAA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CONSIST_UBA_CENSIM_OVINI" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CONSIST_UBA_CENSIM_OVINI" ADD CONSTRAINT "PK_DMT_T_CONS_UBA_CENS_OV" PRIMARY KEY ("P_CUAA", "ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_CONSIST_UBA_CENSIM_OVINI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_CONSIST_UBA_CENSIM_OVINI" ADD CONSTRAINT "FK_DMT_T_SESSIONE_21" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
