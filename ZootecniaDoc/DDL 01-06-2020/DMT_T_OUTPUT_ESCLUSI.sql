--------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DROP Table DMT_T_OUTPUT_ESCLUSI
--------------------------------------------------------

DROP TABLE "DEMETRA"."DMT_T_OUTPUT_ESCLUSI";

--------------------------------------------------------
--  DDL for Table DMT_T_OUTPUT_ESCLUSI
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_OUTPUT_ESCLUSI" 
   (	"CALCOLO" VARCHAR2(20 CHAR), 
	"CAPO_ID" NUMBER(19,0), 
	"ID_SESSIONE" NUMBER(19,0), 
	"MOTIVAZIONE_ESCLUSIONE" VARCHAR2(400 CHAR)
   ) 
  
  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_OUTPUT_ESCLUSI
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_OUTPUT_ESCLUSI" ON "DEMETRA"."DMT_T_OUTPUT_ESCLUSI" ("CALCOLO", "CAPO_ID", "ID_SESSIONE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_OUTPUT_ESCLUSI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_ESCLUSI" MODIFY ("CALCOLO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_ESCLUSI" MODIFY ("CAPO_ID" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_ESCLUSI" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_ESCLUSI" ADD CONSTRAINT "PK_DMT_T_OUTPUT_ESCLUSI" PRIMARY KEY ("CALCOLO", "CAPO_ID", "ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_OUTPUT_ESCLUSI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_OUTPUT_ESCLUSI" ADD CONSTRAINT "FK_DMT_T_SESSIONE_06" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
