--------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_W_CALCOLI_INTERVENTI
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_W_CALCOLI_INTERVENTI" 
   (	"ID_GESTORE" NUMBER(19,0), 
	"ID_INTERVENTO" NUMBER(19,0), 
	"ORDINE_ESECUZIONE" VARCHAR2(10 CHAR),
	"ID_SESSIONE" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_W_CALCOLI_INTERVENTI
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_W_CALCOLI_INTERVENTI" ON "DEMETRA"."DMT_W_CALCOLI_INTERVENTI" ("ID_GESTORE", "ID_INTERVENTO", "ORDINE_ESECUZIONE", "ID_SESSIONE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_W_CALCOLI_INTERVENTI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_W_CALCOLI_INTERVENTI" MODIFY ("ID_GESTORE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_CALCOLI_INTERVENTI" MODIFY ("ID_INTERVENTO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_CALCOLI_INTERVENTI" MODIFY ("ORDINE_ESECUZIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_CALCOLI_INTERVENTI" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_W_CALCOLI_INTERVENTI" ADD PRIMARY KEY ("ID_GESTORE", "ID_INTERVENTO", "ORDINE_ESECUZIONE", "ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_W_CALCOLI_INTERVENTI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_W_CALCOLI_INTERVENTI" ADD CONSTRAINT "FK_DMT_T_SESSIONE_31" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
