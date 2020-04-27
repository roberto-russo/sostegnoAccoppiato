
  CREATE TABLE "ZOOTECNIA"."DMT_T_CONTROLLO_UBA_MINIME" 
   (	"CUAA" VARCHAR2(255 CHAR) NOT NULL ENABLE, 
	"FK_ID_SESSIONE" NUMBER(19,0) NOT NULL ENABLE, 
	"CODICE_INTERVENTO" VARCHAR2(400 CHAR) NOT NULL ENABLE, 
	"ANNO_CAMPAGNA" NUMBER(10,0) NOT NULL ENABLE, 
	"ESITO" VARCHAR2(255 CHAR), 
	"MOTIVAZIONI" VARCHAR2(1000 CHAR), 
	"UBA" FLOAT(126)
   ) 
 TABLESPACE "DEMETRA_TBL" ;

  
  ALTER TABLE "ZOOTECNIA"."DMT_T_CONTROLLO_UBA_MINIME" ADD CONSTRAINT "PK_DMT_T_CONTROLLO_UBA_MINIME"  PRIMARY KEY ("CUAA", "FK_ID_SESSIONE");
  ALTER TABLE "ZOOTECNIA"."DMT_T_CONTROLLO_UBA_MINIME" ADD CONSTRAINT "FK_DMT_T_CONTROLLO_UBA_MINIME_01" FOREIGN KEY ("FK_ID_SESSIONE") REFERENCES "ZOOTECNIA"."DMT_S_SESSIONE" ("ID_SESSIONE") ENABLE;

  
   
CREATE UNIQUE INDEX "ZOOTECNIA"."IDX_DMT_T_CONTROLLO_UBA_MINIME_01" ON "ZOOTECNIA"."DMT_T_CONTROLLO_UBA_MINIME" ("CUAA", "FK_ID_SESSIONE") 
 TABLESPACE "DEMETRA_IDX" ;
