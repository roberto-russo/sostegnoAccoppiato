-- Table: public.dmt_t_latte_vendita_diretta

-- DROP TABLE public.dmt_t_latte_vendita_diretta;

CREATE TABLE public.dmt_t_latte_vendita_diretta
(
    anno_campagna integer NOT NULL,
    cuua character varying(255) COLLATE pg_catalog."default" NOT NULL,
    mese character varying(255) COLLATE pg_catalog."default" NOT NULL,
    matricola character varying(255) COLLATE pg_catalog."default",
    quantita bigint,
    CONSTRAINT dmt_t_latte_vendita_diretta_pkey PRIMARY KEY (anno_campagna, cuua, mese)
)