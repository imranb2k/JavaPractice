drop schema IF EXISTS register_schema CASCADE;

CREATE SCHEMA IF NOT EXISTS register_schema;
SET search_path TO register_schema;

DROP TABLE IF EXISTS REGISTER CASCADE;

CREATE TABLE REGISTER (
    ID INTEGER NOT NULL,
    USER_NAME VARCHAR(50) NOT NULL,
    PASSWORD VARCHAR(50) NOT NULL
);

CREATE INDEX IXFK_REGISTRATION
ON REGISTER (USER_NAME);

ALTER TABLE REGISTER ADD CONSTRAINT PK_REGISTER
PRIMARY KEY (ID);

CREATE SEQUENCE registerid start 1;
