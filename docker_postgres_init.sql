-- CREATE USER gianluca WITH PASSWORD 'teste12' CREATEDB;

CREATE DATABASE crudGenerico
    WITH OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'pt_BR.utf8'
    LC_CTYPE = 'pt_BR.utf8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;"