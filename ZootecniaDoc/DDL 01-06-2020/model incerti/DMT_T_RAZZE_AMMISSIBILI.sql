--------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_RAZZE_AMMISSIBILI
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_RAZZE_AMMISSIBILI" 
   (	"SEZIONE_RAZZA" VARCHAR2(20 CHAR), 
	"ASSOCIAZIONE" VARCHAR2(20 CHAR), 
	"DENOM_UFF_LG" VARCHAR2(50 CHAR)
   ) 

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_RAZZE_AMMISSIBILI
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_RAZZE_AMMISSIBILI" ON "DEMETRA"."DMT_T_RAZZE_AMMISSIBILI" ("SEZIONE_RAZZA") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_RAZZE_AMMISSIBILI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_RAZZE_AMMISSIBILI" MODIFY ("SEZIONE_RAZZA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_RAZZE_AMMISSIBILI" ADD CONSTRAINT "PK_DMT_T_RAZZE_AMMISSIBILI" PRIMARY KEY ("SEZIONE_RAZZA");
