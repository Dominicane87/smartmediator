-- Product_features table

-- CREATE TABLE product_features
-- (
--     id         BIGSERIAL,
--     product_id BIGINT       NOT NULL,
--     code       varchar(255) NOT NULL CHECK (length(code) > 0),
--     name       varchar(255) NOT NULL CHECK (length(code) > 0),
--     note       TEXT         NOT NULL DEFAULT ''
--     CONSTRAINT pk_product_features_products PRIMARY KEY (id),
--     CONSTRAINT fk_orders_products_products FOREIGN KEY (product_id) REFERENCES products (id)
--         ON DELETE RESTRICT ON UPDATE RESTRICT
-- );
--
-- CREATE INDEX idx_product_features_code ON product_features (code);
-- CREATE INDEX idx_product_features_name ON product_features (name);