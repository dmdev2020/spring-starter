--liquibase formatted sql

--changeset dmatveyenka:1
ALTER TABLE users
ADD COLUMN image VARCHAR(64);

--changeset dmatveyenka:2
ALTER TABLE users_aud
ADD COLUMN image VARCHAR(64);