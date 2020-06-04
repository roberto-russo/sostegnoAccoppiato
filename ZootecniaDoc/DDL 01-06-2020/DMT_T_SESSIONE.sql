--------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_SESSIONE
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_SESSIONE" 
   (	"ID_SESSIONE" NUMBER(19,0), 
	"DATA_E_ORA" TIMESTAMP (6)
   ) SEGMENT CREATION IMMEDIATE 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_SESSIONE
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_SESSIONE" ON "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") 
 
  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_SESSIONE
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_SESSIONE" MODIFY ("DATA_E_ORA" NOT NULL ENABLE);

  ALTER TABLE "DEMETRA"."DMT_T_SESSIONE" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_SESSIONE" ADD CONSTRAINT "PK_DMT_T_SESSIONE" PRIMARY KEY ("ID_SESSIONE");
