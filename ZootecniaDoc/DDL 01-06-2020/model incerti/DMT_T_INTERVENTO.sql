--------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_INTERVENTO
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_INTERVENTO" 
   (	"ID" NUMBER(19,0), 
	"ID_CATEGORIA" NUMBER(10,0), 
	"ID_SESSIONE" NUMBER(19,0), 
	"ID_SPECIE" NUMBER(10,0), 
	"INTERVENTO" VARCHAR2(3 CHAR), 
	"MISURA" NUMBER(*,2)
   )

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_INTERVENTO
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_INTERVENTO" ON "DEMETRA"."DMT_T_INTERVENTO" ("ID", "ID_CATEGORIA", "ID_SESSIONE", "ID_SPECIE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_INTERVENTO
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_INTERVENTO" MODIFY ("ID" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_INTERVENTO" MODIFY ("ID_CATEGORIA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_INTERVENTO" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_INTERVENTO" MODIFY ("ID_SPECIE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_INTERVENTO" ADD CONSTRAINT "PK_DMT_T_INTERVENTO" PRIMARY KEY ("ID", "ID_CATEGORIA", "ID_SESSIONE", "ID_SPECIE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_INTERVENTO
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_INTERVENTO" ADD CONSTRAINT "FK_DMT_T_SESSIONE_27" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
