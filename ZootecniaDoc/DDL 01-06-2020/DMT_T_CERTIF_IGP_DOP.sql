--------------------------------------------------------
--  File creato - mercoledì-giugno-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DMT_T_CERTIF_IGP_DOP
--------------------------------------------------------

DROP TABLE "DEMETRA"."DMT_T_CERTIF_IGP_DOP";

--------------------------------------------------------
--  DDL for Table DMT_T_CERTIF_IGP_DOP
--------------------------------------------------------

  CREATE TABLE "DEMETRA"."DMT_T_CERTIF_IGP_DOP" 
   (	"CUAA" VARCHAR2(16 CHAR), 
	"FLAG_DOP" VARCHAR2(1 CHAR), 
	"FLAG_IGP" VARCHAR2(1 CHAR), 
	"ALPEGGIO" VARCHAR2(1 CHAR), 
	"ZONA" VARCHAR2(1 CHAR)
   )
   
  TABLESPACE "DEMETRA_TBL" ;
--------------------------------------------------------
--  DDL for Index IE_DMT_T_CERTIF_IGP_DOP
--------------------------------------------------------

  CREATE UNIQUE INDEX "DEMETRA"."IE_DMT_T_CERTIF_IGP_DOP" ON "DEMETRA"."DMT_T_CERTIF_IGP_DOP" ("CUAA") 

  TABLESPACE "DEMETRA_IDX" ;
--------------------------------------------------------
--  Constraints for Table DMT_T_CERTIF_IGP_DOP
--------------------------------------------------------

  ALTER TABLE "DEMETRA"."DMT_T_CERTIF_IGP_DOP" MODIFY ("CUAA" NOT NULL ENABLE);
 
  ALTER TABLE "DEMETRA"."DMT_T_CERTIF_IGP_DOP" ADD CONSTRAINT "PK_DMT_T_CERTIF_IGP_DOP" PRIMARY KEY ("CUAA");
