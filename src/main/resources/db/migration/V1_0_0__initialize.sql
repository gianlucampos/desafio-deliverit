DROP TABLE IF EXISTS conta;

CREATE TABLE conta (
	id int8 NOT NULL,
	diasAtraso int4 NULL,
	dtPagamento date NULL,
	dtVencimento date NULL,
	nome varchar(255) NULL,
	valorCorrigido numeric(19,2) NULL,
	valorOriginal numeric(19,2) NULL,
	CONSTRAINT conta_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE seqconta
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
