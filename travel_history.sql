-- Table: public.travel_history

-- DROP TABLE IF EXISTS public.travel_history;

CREATE TABLE IF NOT EXISTS public.travel_history
(
    from_station character varying(50) COLLATE pg_catalog."default",
    to_station character varying(50) COLLATE pg_catalog."default",
    mode character varying COLLATE pg_catalog."default",
    card_number character varying COLLATE pg_catalog."default",
    fare_charged character varying COLLATE pg_catalog."default",
    travel_id integer NOT NULL DEFAULT nextval('travel_history_travel_id_seq'::regclass)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.travel_history
    OWNER to postgres;