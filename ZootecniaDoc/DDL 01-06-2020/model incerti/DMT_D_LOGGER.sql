--------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_D_LOGGER
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_D_LOGGER" 
   (	"ID_LOG" NUMBER(19,0), 
	"ID_SESSIONE" NUMBER(19,0), 
	"DATA_GENERAZIONE_LOG" DATE, 
	"MESSAGGIO" VARCHAR2(255 CHAR) DEFAULT 'no message avaible', 
	"NOME_CLASSE_CHIAMANTE" VARCHAR2(50 CHAR), 
	"TIPO_LOG" VARCHAR2(10 CHAR) DEFAULT 'INFO'
   )

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_D_LOGGER
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_D_LOGGER" ON "DEMETRA"."DMT_D_LOGGER" ("ID_LOG", "ID_SESSIONE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_D_LOGGER
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_D_LOGGER" MODIFY ("ID_LOG" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_D_LOGGER" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_D_LOGGER" MODIFY ("DATA_GENERAZIONE_LOG" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_D_LOGGER" MODIFY ("NOME_CLASSE_CHIAMANTE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_D_LOGGER" ADD CONSTRAINT "PK_DMT_D_LOGGER" PRIMARY KEY ("ID_LOG", "ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_D_LOGGER
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_D_LOGGER" ADD CONSTRAINT "FK_DMT_T_SESSIONE_17" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
