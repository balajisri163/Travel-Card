-- Table: public.wallet

-- DROP TABLE IF EXISTS public.wallet;

CREATE TABLE IF NOT EXISTS public.wallet
(
    cardnumber character varying(50) COLLATE pg_catalog."default" NOT NULL,
    amount character varying(50) COLLATE pg_catalog."default" NOT NULL,
    id integer NOT NULL DEFAULT nextval('wallet_id_seq'::regclass),
    CONSTRAINT wallet_pkey PRIMARY KEY (cardnumber)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.wallet
    OWNER to postgres;