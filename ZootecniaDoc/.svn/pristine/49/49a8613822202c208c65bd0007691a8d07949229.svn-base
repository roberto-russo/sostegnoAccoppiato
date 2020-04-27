--------------------------------------------------------
--  File creato - giovedì-aprile-09-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_SESSIONE
--------------------------------------------------------

  CREATE TABLE "ZOOTECNIA"."DMT_T_SESSIONE" 
   (	"ID_SESSIONE" NUMBER(19,0), 
	"DATA_E_ORA" TIMESTAMP (6)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0012868
--------------------------------------------------------

  CREATE UNIQUE INDEX "ZOOTECNIA"."SYS_C0012868" ON "ZOOTECNIA"."DMT_T_SESSIONE" ("ID_SESSIONE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_SESSIONE
--------------------------------------------------------

  ALTER TABLE "ZOOTECNIA"."DMT_T_SESSIONE" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_SESSIONE" MODIFY ("DATA_E_ORA" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_SESSIONE" ADD PRIMARY KEY ("ID_SESSIONE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE;
