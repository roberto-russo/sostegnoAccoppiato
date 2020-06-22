--------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_D_ESITO_CONTR_PREAMM
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_D_ESITO_CONTR_PREAMM" 
   (	"ANNO" NUMBER(4,0), 
	"CUAA" VARCHAR2(16 CHAR), 
	"ID" NUMBER(19,0), 
	"ID_GESTORE" NUMBER(19,0), 
	"ID_SESSIONE" NUMBER(19,0), 
	"DATA" DATE, 
	"ESITO" VARCHAR2(1 CHAR), 
	"MSG" VARCHAR2(400 CHAR)
   )
  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_D_ESITO_CONTR_PREAMM
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_D_ESITO_CONTR_PREAMM" ON "DEMETRA"."DMT_D_ESITO_CONTR_PREAMM" ("ANNO", "CUAA", "ID", "ID_GESTORE", "ID_SESSIONE") 
  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_D_ESITO_CONTR_PREAMM
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_D_ESITO_CONTR_PREAMM" MODIFY ("ANNO" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_D_ESITO_CONTR_PREAMM" MODIFY ("CUAA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_D_ESITO_CONTR_PREAMM" MODIFY ("ID" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_D_ESITO_CONTR_PREAMM" MODIFY ("ID_GESTORE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_D_ESITO_CONTR_PREAMM" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_D_ESITO_CONTR_PREAMM" ADD CONSTRAINT "PK_DMT_D_ESITO_CONTR_PREAMM" PRIMARY KEY ("ANNO", "CUAA", "ID", "ID_GESTORE", "ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_D_ESITO_CONTR_PREAMM
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_D_ESITO_CONTR_PREAMM" ADD CONSTRAINT "FK_DMT_T_SESSIONE_01" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
