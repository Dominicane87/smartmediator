-- Trace_orders table.

CREATE TABLE trace_orders
(
    id          UUID      NOT NULL PRIMARY KEY DEFAULT uuid_generate_v1mc(),
    order_id    UUID      NOT NULL,
    status      UUID      NOT NULL,
    author      UUID      NOT NULL,
    create_date TIMESTAMP NOT NULL             DEFAULT CURRENT_DATE,
    note        TEXT      NOT NULL             DEFAULT '',
    CONSTRAINT pk_trace_orders UNIQUE (id),
    CONSTRAINT fk_trace_orders_order FOREIGN KEY (order_id) REFERENCES orders (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_trace_orders_status FOREIGN KEY (status) REFERENCES order_statuses (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_trace_orders_author FOREIGN KEY (author) REFERENCES users (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE INDEX idx_trace_orders_create_date ON trace_orders (create_date);
