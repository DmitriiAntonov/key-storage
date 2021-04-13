--liquibase formatted sql

--changeset antonov:init-schema splitStatements:false runOnChange:false logicalFilePath:liquibase/init-schema/1.sql
--comment Инициализация базы данных

CREATE SEQUENCE composite_key_sequence START 1 INCREMENT 1;

CREATE TABLE composite_key
(
    id BIGINT NOT NULL DEFAULT nextval('composite_key_sequence'),
    CONSTRAINT pk_composite_key PRIMARY KEY (id)
);

CREATE SEQUENCE field_sequence START 1 INCREMENT 1;

CREATE TABLE field
(
    id BIGINT NOT NULL DEFAULT nextval('field_sequence'),
    name VARCHAR NOT NULL,
    key VARCHAR NOT NULL,
    is_key BOOLEAN NOT NULL,
    value VARCHAR NOT NULL,
    composite_key_id BIGINT NOT NULL,
    CONSTRAINT pk_field PRIMARY KEY (id),
    CONSTRAINT idx_key_name UNIQUE (key, name)
);

