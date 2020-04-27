--------------------------------------------------------
--  File creato - giovedì-aprile-09-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_LOGGER
--------------------------------------------------------

  CREATE TABLE "ZOOTECNIA"."DMT_T_LOGGER" 
   (	"ID_LOG" NUMBER(19,0), 
	"ID_SESSIONE" NUMBER(19,0), 
	"DATA_GENERAZIONE_LOG" DATE, 
	"MESSAGGIO" VARCHAR2(400 CHAR) DEFAULT 'no message avaible', 
	"NOME_CLASSE_CHIAMANTE" VARCHAR2(100 CHAR), 
	"TIPO_LOG" VARCHAR2(10 CHAR) DEFAULT 'INFO', 
	"SESSIONE" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0012860
--------------------------------------------------------

  CREATE UNIQUE INDEX "ZOOTECNIA"."SYS_C0012860" ON "ZOOTECNIA"."DMT_T_LOGGER" ("ID_LOG", "ID_SESSIONE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_LOGGER
--------------------------------------------------------

  ALTER TABLE "ZOOTECNIA"."DMT_T_LOGGER" MODIFY ("ID_LOG" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_LOGGER" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_LOGGER" MODIFY ("DATA_GENERAZIONE_LOG" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_LOGGER" MODIFY ("NOME_CLASSE_CHIAMANTE" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_LOGGER" MODIFY ("SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_LOGGER" ADD PRIMARY KEY ("ID_LOG", "ID_SESSIONE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_LOGGER
--------------------------------------------------------

  ALTER TABLE "ZOOTECNIA"."DMT_T_LOGGER" ADD CONSTRAINT "FKBV1KV503MJNR6QMRWWID9GW3R" FOREIGN KEY ("SESSIONE")
	  REFERENCES "ZOOTECNIA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
