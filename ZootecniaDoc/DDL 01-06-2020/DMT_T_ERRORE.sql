--------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_ERRORE
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_ERRORE" 
   (	"INPUT" VARCHAR2(255 CHAR), 
	"NOME_METODO" VARCHAR2(50 CHAR), 
	"ID_SESSIONE" NUMBER(19,0), 
	"ERRORE_DESCRIZIONE" VARCHAR2(100 CHAR), 
	"ERRORE_CODICE" VARCHAR2(100 CHAR)
   )

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_ERRORE
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_ERRORE" ON "DEMETRA"."DMT_T_ERRORE" ("INPUT", "NOME_METODO", "ID_SESSIONE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_ERRORE
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_ERRORE" MODIFY ("INPUT" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_ERRORE" MODIFY ("NOME_METODO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_ERRORE" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_ERRORE" ADD CONSTRAINT "PK_DMT_T_ERRORE" PRIMARY KEY ("INPUT", "NOME_METODO", "ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_ERRORE
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_ERRORE" ADD CONSTRAINT "FK_DMT_T_SESSIONE_25" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
