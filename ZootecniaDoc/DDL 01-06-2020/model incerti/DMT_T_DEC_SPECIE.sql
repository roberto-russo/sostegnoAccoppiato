--------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_DEC_SPECIE
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_DEC_SPECIE" 
   (	"ID_SESSIONE" NUMBER(19,0), 
	"DESCRIZIONE" VARCHAR2(255 CHAR), 
	"ID" NUMBER(19,0)
   )

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_DEC_SPECIE
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_DEC_SPECIE" ON "DEMETRA"."DMT_T_DEC_SPECIE" ("ID_SESSIONE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_DEC_SPECIE
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_DEC_SPECIE" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_DEC_SPECIE" MODIFY ("ID" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_DEC_SPECIE" ADD CONSTRAINT "PK_DMT_T_DEC_SPECIE" PRIMARY KEY ("ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_DEC_SPECIE
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_DEC_SPECIE" ADD CONSTRAINT "FK_DMT_T_SESSIONE_22" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
