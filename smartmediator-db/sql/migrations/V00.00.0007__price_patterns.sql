-- Price_patterns table.

CREATE TABLE price_patterns
(
    id          UUID         NOT NULL PRIMARY KEY DEFAULT uuid_generate_v1mc(),
    code        varchar(255) NOT NULL CHECK (length(code) > 0),
    name        varchar(255) NOT NULL CHECK (length(name) > 0),
    seller_id   UUID         NULL,
    parent_id   UUID         NULL,
    create_date TIMESTAMP    NOT NULL             DEFAULT CURRENT_DATE,
    note        TEXT         NOT NULL             DEFAULT '',
    deleted     boolean,
    CONSTRAINT pk_price_patterns UNIQUE (id),
    CONSTRAINT uk_price_patterns_code UNIQUE (code),
    CONSTRAINT fk_price_patterns_seller_id FOREIGN KEY (seller_id) REFERENCES sellers (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT
);
CREATE INDEX idx_price_create_date ON price_patterns (create_date);
CREATE INDEX idx_price_patterns_parent ON price_patterns (parent_id);
CREATE INDEX idx_price_patterns_name ON price_patterns (name);
CREATE INDEX idx_price_patterns_deleted ON price_patterns (deleted);