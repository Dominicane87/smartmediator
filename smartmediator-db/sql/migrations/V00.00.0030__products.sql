-- Products table.

CREATE TABLE products
(
    id        BIGSERIAL,
    code      varchar(50)    NOT NULL CHECK (length(code) > 0),
    name      varchar(50)    NOT NULL CHECK (length(name) > 0),
    unit_id   BIGINT         NOT NULL,
    seller_id BIGINT         NOT NULL,
    available decimal(20, 3) NOT NULL CHECK (available >= 0),
    note      TEXT           NOT NULL DEFAULT '',
    CONSTRAINT pk_products PRIMARY KEY (id),
    CONSTRAINT uq_products_code UNIQUE (code),
    CONSTRAINT fk_products_units FOREIGN KEY (unit_id) REFERENCES units (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_products_sellers FOREIGN KEY (seller_id) REFERENCES organizations (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE INDEX idx_products_code ON products (code);
CREATE INDEX idx_products_name ON products (name);
CREATE INDEX idx_products_available ON products (available);
