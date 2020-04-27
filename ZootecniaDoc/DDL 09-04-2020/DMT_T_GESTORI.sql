--------------------------------------------------------
--  File creato - giovedì-aprile-09-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_GESTORI
--------------------------------------------------------

  CREATE TABLE "ZOOTECNIA"."DMT_T_GESTORI" 
   (	"ID" NUMBER(19,0), 
	"ID_TIPOLOGIA" NUMBER(19,0), 
	"NOME_SERVICE" VARCHAR2(30 CHAR), 
	"ID_SESSIONE" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0012753
--------------------------------------------------------

  CREATE UNIQUE INDEX "ZOOTECNIA"."SYS_C0012753" ON "ZOOTECNIA"."DMT_T_GESTORI" ("ID", "ID_TIPOLOGIA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_GESTORI
--------------------------------------------------------

  ALTER TABLE "ZOOTECNIA"."DMT_T_GESTORI" MODIFY ("ID" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_GESTORI" MODIFY ("ID_TIPOLOGIA" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_GESTORI" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_GESTORI" ADD PRIMARY KEY ("ID", "ID_TIPOLOGIA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_GESTORI
--------------------------------------------------------

  ALTER TABLE "ZOOTECNIA"."DMT_T_GESTORI" ADD CONSTRAINT "FKH7NAY0CU2BG87DMMFG1OGHKAJ" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "ZOOTECNIA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
