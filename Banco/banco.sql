--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

-- Started on 2018-11-29 19:54:43

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2826 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 196 (class 1259 OID 16424)
-- Name: carro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.carro (
    id integer NOT NULL,
    nome character varying(120) NOT NULL,
    marca character varying(80) NOT NULL,
    chassis character varying(17),
    placa character varying(7) NOT NULL,
    kilometragem double precision,
    status integer NOT NULL,
    valor_dia double precision,
    data_retirada date,
    data_devolucao date,
    cliente_id character varying(11) NOT NULL
);


ALTER TABLE public.carro OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16516)
-- Name: carros; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.carros
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.carros OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16463)
-- Name: carros_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.carros_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.carros_sequence OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16518)
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente (
    nome character varying(200) NOT NULL,
    rg character varying(14),
    cpf character varying(11) NOT NULL,
    cnh character varying
);


ALTER TABLE public.cliente OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 16465)
-- Name: locacao_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.locacao_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.locacao_sequence OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 16467)
-- Name: marca_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.marca_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.marca_sequence OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16469)
-- Name: pessoas_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pessoas_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pessoas_sequence OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16471)
-- Name: usuarios_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuarios_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuarios_sequence OWNER TO postgres;

--
-- TOC entry 2811 (class 0 OID 16424)
-- Dependencies: 196
-- Data for Name: carro; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.carro (id, nome, marca, chassis, placa, kilometragem, status, valor_dia, data_retirada, data_devolucao, cliente_id) FROM stdin;
4	TESTE2	123	123	123	123	0	12	\N	\N	2
5	TESTE3	123	123	123	123	0	123	\N	\N	1
2	MODEL S	TESLA	123456	TES1234	0	0	150	\N	\N	02456855027
6	TESTE4	123	123	123	123.5	0	123	\N	\N	123
3	MODEL X	TESLA	456878787	TES1235	1200	1	120	2018-09-10	\N	02456855027
\.


--
-- TOC entry 2818 (class 0 OID 16518)
-- Dependencies: 203
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cliente (nome, rg, cpf, cnh) FROM stdin;
TESTE2	00	123	00
LUCAS MACHADO	5234335588	02456855027	123456
TESTE3		1234	
\.


--
-- TOC entry 2827 (class 0 OID 0)
-- Dependencies: 202
-- Name: carros; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.carros', 8, true);


--
-- TOC entry 2828 (class 0 OID 0)
-- Dependencies: 197
-- Name: carros_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.carros_sequence', 1, false);


--
-- TOC entry 2829 (class 0 OID 0)
-- Dependencies: 198
-- Name: locacao_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.locacao_sequence', 1, false);


--
-- TOC entry 2830 (class 0 OID 0)
-- Dependencies: 199
-- Name: marca_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.marca_sequence', 1, false);


--
-- TOC entry 2831 (class 0 OID 0)
-- Dependencies: 200
-- Name: pessoas_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pessoas_sequence', 1, false);


--
-- TOC entry 2832 (class 0 OID 0)
-- Dependencies: 201
-- Name: usuarios_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuarios_sequence', 1, false);


--
-- TOC entry 2686 (class 2606 OID 16428)
-- Name: carro carros_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.carro
    ADD CONSTRAINT carros_pkey PRIMARY KEY (id);


--
-- TOC entry 2689 (class 2606 OID 16529)
-- Name: cliente pk_cliente; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT pk_cliente PRIMARY KEY (cpf);


--
-- TOC entry 2687 (class 1259 OID 16536)
-- Name: fki_cliente_fkey; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX fki_cliente_fkey ON public.carro USING btree (cliente_id);


-- Completed on 2018-11-29 19:54:44

--
-- PostgreSQL database dump complete
--

