--------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_CLS_PREMIO_VALID
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_CLS_PREMIO_VALID" 
   (	"ANNO_CAMPAGNA" NUMBER(10,0), 
	"CODICE_INTERVENTO" VARCHAR2(3 CHAR), 
	"CUAA" VARCHAR2(16 CHAR), 
	"ID_SESSIONE" NUMBER(19,0)
   )
 
  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_CLS_PREMIO_VALID
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_CLS_PREMIO_VALID" ON "DEMETRA"."DMT_T_CLS_PREMIO_VALID" ("ANNO_CAMPAGNA", "CODICE_INTERVENTO", "CUAA", "ID_SESSIONE") 
  
  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_CLS_PREMIO_VALID
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_CLS_PREMIO_VALID" MODIFY ("ANNO_CAMPAGNA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CLS_PREMIO_VALID" MODIFY ("CODICE_INTERVENTO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CLS_PREMIO_VALID" MODIFY ("CUAA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CLS_PREMIO_VALID" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CLS_PREMIO_VALID" ADD CONSTRAINT "PK_DMT_T_CLS_PREMIO_VALID" PRIMARY KEY ("ANNO_CAMPAGNA", "CODICE_INTERVENTO", "CUAA", "ID_SESSIONE");

--------------------------------------------------------
--  Ref Constraints for Table DMT_T_CLS_PREMIO_VALID
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_CLS_PREMIO_VALID" ADD CONSTRAINT "FK_DMT_T_SESSIONE_05" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
