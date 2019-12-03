-- Price_patterns table.

CREATE TABLE price_patterns
(
    id          BIGSERIAL,
    name        varchar(255) NOT NULL CHECK (length(name) > 0),
    parent_id   BIGINT       NULL,
    create_date TIMESTAMP    NOT NULL DEFAULT CURRENT_DATE,
    note        TEXT         NOT NULL DEFAULT '',
    CONSTRAINT pk_price_patterns PRIMARY KEY (id)
);

CREATE INDEX idx_price_patterns_name ON price_patterns (name);
CREATE INDEX idx_price_create_date ON price_patterns (create_date);
CREATE INDEX idx_price_patterns_parent ON price_patterns (parent_id);