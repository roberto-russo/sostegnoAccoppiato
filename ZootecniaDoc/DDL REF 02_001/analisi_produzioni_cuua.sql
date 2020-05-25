
CREATE TABLE public.analisi_produzioni_cuua
(
    cuua character varying(255) COLLATE pg_catalog."default" NOT NULL,
    data_analisi timestamp without time zone NOT NULL,
    carica_batterica real NOT NULL,
    cellule_somatiche real NOT NULL,
    codice_asl character varying(255) COLLATE pg_catalog."default",
    partita_iva character varying(255) COLLATE pg_catalog."default",
    proteine real NOT NULL,
    ragione_sociale character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT analisi_produzioni_cuua_pkey PRIMARY KEY (cuua, data_analisi)
)