--------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_W_CONTR_PREAM
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_W_CONTR_PREAM" 
   (	"ID_INTERVENTO" NUMBER(19,0), 
	"NOME_CLASSE_CALCOLO" VARCHAR2(30 CHAR), 
	"ORDINE_ESECUZIONE" VARCHAR2(10 CHAR), 
	"ID_SESSIONE" NUMBER(19,0)
   ) 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_W_CONTR_PREAM
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_W_CONTR_PREAM" ON "DEMETRA"."DMT_W_CONTR_PREAM" ("ID_INTERVENTO", "NOME_CLASSE_CALCOLO", "ORDINE_ESECUZIONE", "ID_SESSIONE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_W_CONTR_PREAM
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_W_CONTR_PREAM" MODIFY ("ID_INTERVENTO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_CONTR_PREAM" MODIFY ("NOME_CLASSE_CALCOLO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_CONTR_PREAM" MODIFY ("ORDINE_ESECUZIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_CONTR_PREAM" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_CONTR_PREAM" ADD CONSTRAINT "PK_DMT_W_CONTR_PREAM" PRIMARY KEY ("ID_INTERVENTO", "NOME_CLASSE_CALCOLO", "ORDINE_ESECUZIONE", "ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_W_CONTR_PREAM
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_W_CONTR_PREAM" ADD CONSTRAINT "FK_DMT_T_SESSIONE_32" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
