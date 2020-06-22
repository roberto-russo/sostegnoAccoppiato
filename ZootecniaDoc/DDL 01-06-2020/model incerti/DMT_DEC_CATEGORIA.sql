--------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_DEC_CATEGORIA
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_DEC_CATEGORIA" 
   (	"ID_SESSIONE" NUMBER(19,0), 
	"DESCRIZIONE" VARCHAR2(255 CHAR), 
	"ID" NUMBER(19,0)
   )
  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_DEC_CATEGORIA
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_DEC_CATEGORIA" ON "DEMETRA"."DMT_DEC_CATEGORIA" ("ID_SESSIONE") 
  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_DEC_CATEGORIA
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_DEC_CATEGORIA" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_DEC_CATEGORIA" MODIFY ("ID" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_DEC_CATEGORIA" ADD CONSTRAINT "PK_DMT_DEC_CATEGORIA" PRIMARY KEY ("ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_DEC_CATEGORIA
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_DEC_CATEGORIA" ADD CONSTRAINT "FK_DMT_T_SESSIONE_18" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
