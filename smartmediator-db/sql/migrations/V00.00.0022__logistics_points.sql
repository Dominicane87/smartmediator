-- Logistics_points table.

CREATE TABLE logistics_points
(
    id      BIGSERIAL,
    code    varchar(255)  NOT NULL CHECK (length(code) > 0),
    name    varchar(255) NOT NULL CHECK (length(name) > 0),
    address TEXT         NOT NULL CHECK (length(name) > 0),
    org_id  BIGINT       NOT NULL,
    CONSTRAINT pk_logistics_points PRIMARY KEY (id),
    CONSTRAINT fk_logistics_points_org_id FOREIGN KEY (org_id) REFERENCES organizations (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE INDEX idx_logistics_points_code ON logistics_points (code);
CREATE INDEX idx_logistics_points_name ON logistics_points (name);
