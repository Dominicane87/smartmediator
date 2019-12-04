-- Trace_orders table.

CREATE TABLE trace_orders
(
    id          BIGSERIAL,
    order_id    BIGINT    NOT NULL,
    status      BIGINT    NOT NULL,
    author      BIGINT    NOT NULL,
    create_date TIMESTAMP NOT NULL DEFAULT CURRENT_DATE,
    note        TEXT      NOT NULL DEFAULT '',
    CONSTRAINT pk_trace_orders PRIMARY KEY (id),
    CONSTRAINT fk_trace_orders_order FOREIGN KEY (order_id) REFERENCES orders (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_trace_orders_status FOREIGN KEY (status) REFERENCES order_statuses (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_trace_orders_author FOREIGN KEY (author) REFERENCES users (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE INDEX idx_trace_orders_create_date ON trace_orders (create_date);
