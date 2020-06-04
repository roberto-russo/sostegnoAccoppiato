--------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DROP Table DMT_T_OUTPUT_CONTROLLI
--------------------------------------------------------

  DROP TABLE "DEMETRA"."DMT_T_OUTPUT_CONTROLLI";
  
--------------------------------------------------------
--  DDL for Table DMT_T_OUTPUT_CONTROLLI
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_OUTPUT_CONTROLLI" 
   (	"ANNO_CAMPAGNA" NUMBER(10,0), 
	"CUAA" VARCHAR2(16 CHAR), 
	"INTERVENTO" VARCHAR2(3 CHAR), 
	"ID_SESSIONE" NUMBER(19,0), 
	"CAPI_AMMISSIBILI" NUMBER(*,2), 
	"CAPI_RICHIESTI" NUMBER(10,0)
   ) SEGMENT CREATION DEFERRED 
 
  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_OUTPUT_CONTROLLI
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_OUTPUT_CONTROLLI" ON "DEMETRA"."DMT_T_OUTPUT_CONTROLLI" ("ANNO_CAMPAGNA", "CUAA", "INTERVENTO", "ID_SESSIONE") 
  
  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_OUTPUT_CONTROLLI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_CONTROLLI" MODIFY ("ANNO_CAMPAGNA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_CONTROLLI" MODIFY ("CUAA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_CONTROLLI" MODIFY ("INTERVENTO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_CONTROLLI" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_CONTROLLI" ADD CONSTRAINT "PK_DMT_T_OUTPUT_CONTROLLI" PRIMARY KEY ("ANNO_CAMPAGNA", "CUAA", "INTERVENTO", "ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_OUTPUT_CONTROLLI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_CONTROLLI" ADD CONSTRAINT "FK_DMT_T_SESSIONE_10" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
