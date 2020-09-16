CREATE USER gerente WITH PASSWORD 'teste12' CREATEDB;

CREATE DATABASE contabilidade
    WITH OWNER = gerente
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_US.utf8'
    LC_CTYPE = 'en_US.utf8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;"
