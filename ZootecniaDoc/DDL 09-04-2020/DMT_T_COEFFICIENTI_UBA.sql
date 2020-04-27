--------------------------------------------------------
--  File creato - giovedì-aprile-09-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_COEFFICIENTI_UBA
--------------------------------------------------------

  CREATE TABLE "ZOOTECNIA"."DMT_T_COEFFICIENTI_UBA" 
   (	"ID_CATEGORIA" NUMBER(19,0), 
	"ID_SESSIONE" NUMBER(19,0), 
	"ID_SPECIE" NUMBER(19,0), 
	"COEFFICIENTE" FLOAT(126), 
	"SESSIONE" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0012735
--------------------------------------------------------

  CREATE UNIQUE INDEX "ZOOTECNIA"."SYS_C0012735" ON "ZOOTECNIA"."DMT_T_COEFFICIENTI_UBA" ("ID_CATEGORIA", "ID_SESSIONE", "ID_SPECIE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_COEFFICIENTI_UBA
--------------------------------------------------------

  ALTER TABLE "ZOOTECNIA"."DMT_T_COEFFICIENTI_UBA" MODIFY ("ID_CATEGORIA" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_COEFFICIENTI_UBA" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_COEFFICIENTI_UBA" MODIFY ("ID_SPECIE" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_COEFFICIENTI_UBA" MODIFY ("SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_COEFFICIENTI_UBA" ADD PRIMARY KEY ("ID_CATEGORIA", "ID_SESSIONE", "ID_SPECIE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_COEFFICIENTI_UBA
--------------------------------------------------------

  ALTER TABLE "ZOOTECNIA"."DMT_T_COEFFICIENTI_UBA" ADD CONSTRAINT "FK8AYRLH1SWFMEJEE67M8XYI0EN" FOREIGN KEY ("SESSIONE")
	  REFERENCES "ZOOTECNIA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
