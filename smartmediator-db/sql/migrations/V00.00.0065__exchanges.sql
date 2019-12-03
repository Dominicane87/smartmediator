-- Exchanges table.

CREATE TYPE handlers as enum (
    'get_orders',
    'set_orders',
    'get_statuses',
    'set_statuses',
    'get_points' );
CREATE TYPE handler_statuses as enum ('process', 'success' ,'fail');

CREATE TABLE exchanges
(
    id          BIGSERIAL,
    org_id      BIGINT           NOT NULL,
    handler     handlers         NOT NULL,
    status      handler_statuses NOT NULL,
    attempts    smallint         NOT NULL CHECK (attempts >= 0),
    create_date TIMESTAMP        NOT NULL DEFAULT CURRENT_DATE,
    CONSTRAINT pk_exchanges PRIMARY KEY (id),
    CONSTRAINT fk_pk_exchanges_org FOREIGN KEY (org_id) REFERENCES organizations (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE INDEX idx_exchanges_handler ON exchanges (handler);
CREATE INDEX idx_exchanges_status ON exchanges (status);
CREATE INDEX idx_exchanges_attempts ON exchanges (attempts);
