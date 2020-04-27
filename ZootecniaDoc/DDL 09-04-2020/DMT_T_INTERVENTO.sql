--------------------------------------------------------
--  File creato - giovedì-aprile-09-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_INTERVENTO
--------------------------------------------------------

  CREATE TABLE "ZOOTECNIA"."DMT_T_INTERVENTO" 
   (	"ID" NUMBER(19,0), 
	"ID_CATEGORIA" NUMBER(10,0), 
	"ID_SPECIE" NUMBER(10,0), 
	"INTERVENTO" VARCHAR2(3 CHAR), 
	"MISURA" FLOAT(126), 
	"ID_SESSIONE" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0012758
--------------------------------------------------------

  CREATE UNIQUE INDEX "ZOOTECNIA"."SYS_C0012758" ON "ZOOTECNIA"."DMT_T_INTERVENTO" ("ID", "ID_CATEGORIA", "ID_SPECIE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_INTERVENTO
--------------------------------------------------------

  ALTER TABLE "ZOOTECNIA"."DMT_T_INTERVENTO" MODIFY ("ID" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_INTERVENTO" MODIFY ("ID_CATEGORIA" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_INTERVENTO" MODIFY ("ID_SPECIE" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_INTERVENTO" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_INTERVENTO" ADD PRIMARY KEY ("ID", "ID_CATEGORIA", "ID_SPECIE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_INTERVENTO
--------------------------------------------------------

  ALTER TABLE "ZOOTECNIA"."DMT_T_INTERVENTO" ADD CONSTRAINT "FK2DWYH63CJI7AXMO5OE6FGMO6T" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "ZOOTECNIA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
