-- PostgreSQL database dump
--

-- Dumped from database version 13.6 (Ubuntu 13.6-0ubuntu0.21.10.1)
-- Dumped by pg_dump version 13.6 (Ubuntu 13.6-0ubuntu0.21.10.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: id-carro; Type: SEQUENCE; Schema: public; Owner: ti2cc
--

CREATE SEQUENCE public."id-carro"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 1000000
    CACHE 1;


ALTER TABLE public."id-carro" OWNER TO ti2cc;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: carro; Type: TABLE; Schema: public; Owner: ti2cc
--

CREATE TABLE public.carro (
    id integer DEFAULT nextval('public."id-carro"'::regclass) NOT NULL,
    modelo text NOT NULL,
    marca text NOT NULL,
    ano_fabricacao integer,
    cor text,
    preco double precision,
    quilometragem integer,
    data_cadastro timestamp without time zone DEFAULT now(),
    disponivel boolean DEFAULT true
);


ALTER TABLE public.carro OWNER TO ti2cc;

--
-- Name: carro carro_pkey; Type: CONSTRAINT; Schema: public; Owner: ti2cc
--

ALTER TABLE ONLY public.carro
    ADD CONSTRAINT carro_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--
