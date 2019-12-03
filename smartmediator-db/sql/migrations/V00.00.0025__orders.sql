-- Orders table.

CREATE TYPE order_statuses as enum (
    'draft', 'new' ,'cancel','taken','shipped','delivered','lost');

CREATE TYPE delivery_type as enum ('pickup', 'supply');

CREATE TABLE orders
(
    id               BIGSERIAL,
    status           order_statuses NOT NULL,
    buyer_id         BIGINT         NOT NULL,
    delivery         delivery_type  NOT NULL,
    price_pattern_id BIGINT         NOT NULL,
    get_from         BIGINT         NOT NULL,
    set_to           BIGINT         NULL,
    note             TEXT           NOT NULL DEFAULT '',
    CONSTRAINT pk_orders PRIMARY KEY (id),
    CONSTRAINT fk_orders_buyers FOREIGN KEY (buyer_id) REFERENCES organizations (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_orders_price_pattern FOREIGN KEY (price_pattern_id) REFERENCES price_patterns (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_orders_get_from FOREIGN KEY (get_from) REFERENCES logistics_points (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_orders_set_to FOREIGN KEY (set_to) REFERENCES logistics_points (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE INDEX idx_orders_statuses ON orders (status);
CREATE INDEX idx_orders_delivery ON orders (delivery);
