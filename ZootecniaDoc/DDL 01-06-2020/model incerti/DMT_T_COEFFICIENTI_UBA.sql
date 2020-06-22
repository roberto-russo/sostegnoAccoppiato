--------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_COEFFICIENTI_UBA
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_COEFFICIENTI_UBA" 
   (	"ID_CATEGORIA" NUMBER(19,0), 
	"ID_SPECIE" NUMBER(19,0), 
	"ID_SESSIONE" NUMBER(19,0), 
	"COEFFICIENTE" NUMBER(*,2)
   )

  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_COEFFICIENTI_UBA
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_COEFFICIENTI_UBA" ON "DEMETRA"."DMT_T_COEFFICIENTI_UBA" ("ID_CATEGORIA", "ID_SPECIE", "ID_SESSIONE") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_COEFFICIENTI_UBA
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_COEFFICIENTI_UBA" MODIFY ("ID_CATEGORIA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_COEFFICIENTI_UBA" MODIFY ("ID_SPECIE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_COEFFICIENTI_UBA" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_COEFFICIENTI_UBA" ADD CONSTRAINT "PK_DMT_T_COEFFICIENTI_UBA" PRIMARY KEY ("ID_CATEGORIA", "ID_SPECIE", "ID_SESSIONE");
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_COEFFICIENTI_UBA
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_COEFFICIENTI_UBA" ADD CONSTRAINT "FK_DMT_T_SESSIONE_20" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "DEMETRA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
