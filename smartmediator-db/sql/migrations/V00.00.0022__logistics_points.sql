-- Logistics_points table.

CREATE TABLE logistics_points
(
    id      BIGSERIAL,
    code    varchar(50) NOT NULL CHECK (length(code) > 0),
    name    varchar(255) NOT NULL CHECK (length(name) > 0),
    address TEXT        NOT NULL CHECK (length(name) > 0),
    CONSTRAINT pk_logistics_points PRIMARY KEY (id),
    CONSTRAINT uq_logistics_points_code UNIQUE (code)
);

CREATE INDEX idx_logistics_points_code ON logistics_points (code);
CREATE INDEX idx_logistics_points_name ON logistics_points (name);
