--------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_CLS_PREMIO_VALID_PP
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_CLS_PREMIO_VALID_PP" 
   (	"ID_ALLE_BDN" NUMBER(19,0),  
	"ID_SESSIONE" NUMBER(19,0), 
	"ANNO_CAMPAGNA" NUMBER(4,0), 
	"CODICE_INTERVENTO" VARCHAR2(3 CHAR), 
	"CUAA" VARCHAR2(16 CHAR), 
	"CUAA2" VARCHAR2(16 CHAR)
   )
  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_CLS_PREMIO_VALID_PP
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_CLS_PREMIO_VALID_PP" ON "DEMETRA"."DMT_T_CLS_PREMIO_VALID_PP" ("ID_ALLE_BDN", "ID_SESSIONE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_CLS_PREMIO_VALID_PP
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_CLS_PREMIO_VALID_PP" MODIFY ("ID_ALLE_BDN" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CLS_PREMIO_VALID_PP" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CLS_PREMIO_VALID_PP" MODIFY ("ANNO_CAMPAGNA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CLS_PREMIO_VALID_PP" MODIFY ("CODICE_INTERVENTO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CLS_PREMIO_VALID_PP" MODIFY ("CUAA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CLS_PREMIO_VALID_PP" MODIFY ("CUAA2" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CLS_PREMIO_VALID_PP" ADD CONSTRAINT "PK_DMT_T_CLS_PREMIO_VALID_PP" PRIMARY KEY ("ID_ALLE_BDN", "ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_CLS_PREMIO_VALID_PP
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_CLS_PREMIO_VALID_PP" ADD CONSTRAINT "FK_DMT_T_SESSIONE_34" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
