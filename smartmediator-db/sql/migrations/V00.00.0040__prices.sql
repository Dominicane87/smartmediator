-- Prices table.

CREATE TABLE prices
(
    id               BIGSERIAL,
    cost             money not null DEFAULT 0,
    product_id       BIGINT NOT NULL,
    price_pattern_id BIGINT NOT NULL,
    CONSTRAINT pk_prices PRIMARY KEY (id),
    CONSTRAINT fk_prices_product FOREIGN KEY (product_id) REFERENCES products (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_prices_price_pattern FOREIGN KEY (price_pattern_id) REFERENCES price_patterns (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE INDEX idx_prices_cost ON prices (cost);
