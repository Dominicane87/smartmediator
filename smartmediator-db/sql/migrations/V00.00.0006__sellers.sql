-- Sellers table;

CREATE TABLE sellers
(
    id               BIGSERIAL,
    org_id           BIGINT NOT NULL,
    price_pattern_id BIGINT NOT NULL,
    CONSTRAINT pk_sellers PRIMARY KEY (id),
    CONSTRAINT uk_sellers_org_id UNIQUE (org_id),
    CONSTRAINT fk_sellers_org_id FOREIGN KEY (org_id) REFERENCES organizations (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_sellers_price_pattern_id FOREIGN KEY (price_pattern_id) REFERENCES price_patterns (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT
);

