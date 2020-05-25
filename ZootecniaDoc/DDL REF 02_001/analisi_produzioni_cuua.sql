-- Table: public.dmt_t_analisi_produzioni_cuua

-- DROP TABLE public.dmt_t_analisi_produzioni_cuua;

CREATE TABLE public.dmt_t_analisi_produzioni_cuua
(
    cuua character varying(255) COLLATE pg_catalog."default" NOT NULL,
    anno_campagna integer NOT NULL,
    data_analisi timestamp without time zone NOT NULL,
    carica_batterica numeric(19,2),
    cellule_somatiche numeric(19,2),
    codice_asl character varying(255) COLLATE pg_catalog."default",
    partita_iva character varying(255) COLLATE pg_catalog."default",
    proteine numeric(19,2),
    ragione_sociale character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT dmt_t_analisi_produzioni_cuua_pkey PRIMARY KEY (cuua, anno_campagna, data_analisi)
)