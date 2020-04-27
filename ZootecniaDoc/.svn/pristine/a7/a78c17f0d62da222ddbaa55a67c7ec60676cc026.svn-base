--------------------------------------------------------
--  File creato - martedì-aprile-14-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_ERRORE
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_ERRORE" 
   (	"INPUT" VARCHAR2(255 CHAR), 
	"NOME_METODO" VARCHAR2(255 CHAR), 
	"FK_ID_SESSIONE" NUMBER(19,0), 
	"ERRORE_DESCRIZIONE" VARCHAR2(400 CHAR), 
	"ERRORE_CODICE" VARCHAR2(400 CHAR)
   )
  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index DMT_T_ERRORE_04
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."DMT_T_ERRORE_04" ON "DEMETRA"."DMT_T_ERRORE" ("INPUT", "NOME_METODO", "FK_ID_SESSIONE") 
  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_ERRORE
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_ERRORE" MODIFY ("INPUT" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_ERRORE" MODIFY ("NOME_METODO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_ERRORE" MODIFY ("FK_ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_ERRORE" ADD CONSTRAINT "PK_DMT_T_ERRORE" PRIMARY KEY ("INPUT", "NOME_METODO", "FK_ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_ERRORE
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_ERRORE" ADD CONSTRAINT "FK_DMT_T_SESSIONE_03" FOREIGN KEY ("FK_ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
