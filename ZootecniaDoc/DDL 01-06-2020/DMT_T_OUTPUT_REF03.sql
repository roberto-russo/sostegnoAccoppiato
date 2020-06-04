--------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DROP Table DMT_T_OUTPUT_REF03
--------------------------------------------------------

  DROP TABLE "DEMETRA"."DMT_T_OUTPUT_REF03"; 
  
--------------------------------------------------------
--  DDL for Table DMT_T_OUTPUT_REF03
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_OUTPUT_REF03" 
   (	"ANNO_CAMPAGNA" NUMBER(10,0), 
	"CUAA" VARCHAR2(16 CHAR), 
	"INTERVENTO" VARCHAR2(3 CHAR), 
	"ID_SESSIONE" NUMBER(19,0), 
	"CAPI_ACCERTATI" NUMBER(10,0), 
	"CAPI_ANOMALI" NUMBER(10,0), 
	"CAPI_PAGABILI" NUMBER(15,5), 
	"CAPI_RICHIESTI" NUMBER(10,0), 
	"DIFF_RICHIESTI_ACCERTATI" NUMBER(10,0), 
	"ESITO" NUMBER(10,2), 
	"IMPORTO_PAGATO" NUMBER(10,2), 
	"PERCENTUALE_RIDUZIONE" NUMBER(10,2)
   ) SEGMENT CREATION IMMEDIATE 
 
  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_OUTPUT_REF03
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_OUTPUT_REF03" ON "DEMETRA"."DMT_T_OUTPUT_REF03" ("ANNO_CAMPAGNA", "CUAA", "INTERVENTO", "ID_SESSIONE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_OUTPUT_REF03
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_REF03" MODIFY ("ANNO_CAMPAGNA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_REF03" MODIFY ("CUAA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_REF03" MODIFY ("INTERVENTO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_REF03" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_REF03" ADD CONSTRAINT "PK_DMT_T_OUTPUT_REF03" PRIMARY KEY ("ANNO_CAMPAGNA", "CUAA", "INTERVENTO", "ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_OUTPUT_REF03
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_REF03" ADD CONSTRAINT "FK_DMT_T_SESSIONE_35" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
