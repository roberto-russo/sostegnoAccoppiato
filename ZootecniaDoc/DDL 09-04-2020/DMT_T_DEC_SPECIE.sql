--------------------------------------------------------
--  File creato - gioved�-aprile-09-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_DEC_SPECIE
--------------------------------------------------------

  CREATE TABLE "ZOOTECNIA"."DMT_T_DEC_SPECIE" 
   (	"ID" NUMBER(19,0), 
	"DESCRIZIONE" VARCHAR2(400 CHAR), 
	"ID_SESSIONE" NUMBER(19,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0012742
--------------------------------------------------------

  CREATE UNIQUE INDEX "ZOOTECNIA"."SYS_C0012742" ON "ZOOTECNIA"."DMT_T_DEC_SPECIE" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_DEC_SPECIE
--------------------------------------------------------

  ALTER TABLE "ZOOTECNIA"."DMT_T_DEC_SPECIE" MODIFY ("ID" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_DEC_SPECIE" MODIFY ("ID_SESSIONE" NOT NULL ENABLE);
 
  ALTER TABLE "ZOOTECNIA"."DMT_T_DEC_SPECIE" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table DMT_T_DEC_SPECIE
--------------------------------------------------------

  ALTER TABLE "ZOOTECNIA"."DMT_T_DEC_SPECIE" ADD CONSTRAINT "FKDL9ML89OO14EA3RFKCJQ1A03G" FOREIGN KEY ("ID_SESSIONE")
	  REFERENCES "ZOOTECNIA"."DMT_T_SESSIONE" ("ID_SESSIONE") ENABLE;
