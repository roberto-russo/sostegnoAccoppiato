--------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_DEC_TIPOLOGIA_GESTORE
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_DEC_TIPOLOGIA_GESTORE" 
   (	"ID_SESSIONE" NUMBER(19,0), 
	"DESCRIZIONE" VARCHAR2(255 CHAR), 
	"ID" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_DEC_TIPOLOGIA_GESTORE
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_DEC_TIPOLOGIA_GESTORE" ON "DEMETRA"."DMT_T_DEC_TIPOLOGIA_GESTORE" ("ID_SESSIONE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_DEC_TIPOLOGIA_GESTORE
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_DEC_TIPOLOGIA_GESTORE" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_DEC_TIPOLOGIA_GESTORE" MODIFY ("ID" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_DEC_TIPOLOGIA_GESTORE" ADD CONSTRAINT "PK_DMT_T_DEC_TIPOLOGIA_GESTORE" PRIMARY KEY ("ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_DEC_TIPOLOGIA_GESTORE
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_DEC_TIPOLOGIA_GESTORE" ADD CONSTRAINT "FK_DMT_T_SESSIONE_23" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
