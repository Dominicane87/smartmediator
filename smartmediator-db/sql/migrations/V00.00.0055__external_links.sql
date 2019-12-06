-- External_links table.

CREATE TABLE external_links
(
    id         UUID         NOT NULL PRIMARY KEY DEFAULT uuid_generate_v1mc(),
    seller_id  UUID         NOT NULL,
    product_id UUID         NOT NULL,
    code       varchar(255) NOT NULL CHECK (length(code) > 0),
    CONSTRAINT pk_external_links UNIQUE (id),
    CONSTRAINT fk_external_links_seller FOREIGN KEY (seller_id) REFERENCES sellers (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_external_links_product FOREIGN KEY (product_id) REFERENCES products (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE INDEX idx_external_links_code ON external_links (code);
