--------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_GESTORI
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_GESTORI" 
   (	"ID" NUMBER(19,0), 
	"ID_TIPOLOGIA" NUMBER(19,0), 
	"ID_SESSIONE" NUMBER(19,0), 
	"NOME_SERVICE" VARCHAR2(30 CHAR)
   )

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_GESTORI
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_GESTORI" ON "DEMETRA"."DMT_T_GESTORI" ("ID", "ID_TIPOLOGIA") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_GESTORI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_GESTORI" MODIFY ("ID" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_GESTORI" MODIFY ("ID_TIPOLOGIA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_GESTORI" ADD CONSTRAINT "PK_DMT_T_GESTORI" PRIMARY KEY ("ID", "ID_TIPOLOGIA");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_GESTORI
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_GESTORI" ADD CONSTRAINT "FK_DMT_T_SESSIONE_26" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
