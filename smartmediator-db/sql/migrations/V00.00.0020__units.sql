-- Units table.

CREATE TABLE units
(
    id   BIGSERIAL,
    code varchar(50) NOT NULL CHECK (length(code) > 0),
    name varchar(50) NOT NULL CHECK (length(name) > 0),
    CONSTRAINT pk_units PRIMARY KEY (id),
    CONSTRAINT uq_units_code UNIQUE (code),
    CONSTRAINT uq_units_name UNIQUE (name)
);
