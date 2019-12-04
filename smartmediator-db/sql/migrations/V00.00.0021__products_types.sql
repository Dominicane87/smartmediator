-- Products_types table.

CREATE TABLE products_types
(
    id   BIGSERIAL,
    code varchar(50) NOT NULL CHECK (length(code) > 0),
    name varchar(50) NOT NULL CHECK (length(name) > 0),
    CONSTRAINT pk_products_types PRIMARY KEY (id),
    CONSTRAINT uq_products_types_code UNIQUE (code),
    CONSTRAINT uq_products_types_name UNIQUE (name)
);
