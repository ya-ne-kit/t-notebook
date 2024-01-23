DROP TABLE IF EXISTS contacts;

CREATE TABLE IF NOT EXISTS contacts
(
    id           BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY not null,
    name         VARCHAR                                         not null,
    phone_number BIGINT                                          not null,
    email        VARCHAR,
    address      VARCHAR
);
