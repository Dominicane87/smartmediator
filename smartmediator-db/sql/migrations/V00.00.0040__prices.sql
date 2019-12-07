-- Prices table.

CREATE TABLE prices
(
    id               UUID  NOT NULL PRIMARY KEY DEFAULT uuid_generate_v1mc(),
    cost             money not null             DEFAULT 0,
    product_id       UUID  NOT NULL,
    price_pattern_id UUID  NOT NULL,
    CONSTRAINT pk_prices UNIQUE (id),
    CONSTRAINT fk_prices_product FOREIGN KEY (product_id) REFERENCES products (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_prices_price_pattern FOREIGN KEY (price_pattern_id) REFERENCES price_patterns (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE INDEX idx_prices_cost ON prices (cost);
