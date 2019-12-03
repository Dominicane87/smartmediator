-- Organizations table;

CREATE TYPE type_organizations as enum ( 'seller', 'buyer' );
CREATE TYPE org_statuses as enum ( 'new', 'wait' ,'confirm','ban');

CREATE TABLE organizations
(
    id               BIGSERIAL,
    full_name        TEXT               NOT NULL
        CONSTRAINT non_empty_full_name CHECK (length(full_name) > 0),
    status           org_statuses       NOT NULL,
    address          TEXT               NOT NULL DEFAULT '',
    accesses         TEXT               NOT NULL DEFAULT '',
    type_org         type_organizations NOT NULL DEFAULT 'buyer',
    price_pattern_id BIGINT             NULL,
    CONSTRAINT pk_organizations PRIMARY KEY (id),
    CONSTRAINT fk_org_pattern FOREIGN KEY (price_pattern_id) REFERENCES organizations (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE INDEX idx_organizations_full_name ON organizations (full_name);
CREATE INDEX idx_organizations_type_org ON organizations (type_org);
CREATE INDEX idx_organizations_statuses ON organizations (status);
