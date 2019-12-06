-- Bids table.

CREATE TABLE bids
(
    id               UUID NOT NULL PRIMARY KEY DEFAULT uuid_generate_v1mc(),
    seller_id        UUID NOT NULL,
    buyer_id         UUID NOT NULL,
    price_pattern_id UUID NOT NULL,
    bids_statuses    UUID NOT NULL,
    CONSTRAINT pk_bids UNIQUE (id),
    CONSTRAINT fk_bids_seller FOREIGN KEY (seller_id) REFERENCES sellers (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_bids_buyer FOREIGN KEY (buyer_id) REFERENCES buyers (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_bids_pattern FOREIGN KEY (price_pattern_id) REFERENCES price_patterns (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_bids_bids_statuses FOREIGN KEY (bids_statuses) REFERENCES bids_statuses (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT
);
