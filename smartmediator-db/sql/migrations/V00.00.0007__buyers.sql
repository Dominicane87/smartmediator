-- Buyers table;

CREATE TABLE buyers
(
    id     BIGSERIAL,
    org_id BIGINT NOT NULL,
    CONSTRAINT pk_buyers PRIMARY KEY (id),
    CONSTRAINT uk_buyers_org_id UNIQUE (org_id),
    CONSTRAINT fk_buyers_org_id FOREIGN KEY (org_id) REFERENCES organizations (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT
);

