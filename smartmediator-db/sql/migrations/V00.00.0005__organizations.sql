-- Organizations table;


CREATE TABLE organizations
(
    id        BIGSERIAL,
    full_name TEXT         NOT NULL CHECK (length(full_name) > 0),
    name      TEXT         NOT NULL CHECK (length(name) > 0),
    inn       varchar(255) NOT NULL CHECK (length(name) > 0),
    status    BIGINT       NOT NULL,
    address   TEXT         NOT NULL DEFAULT '',
    --     accesses         TEXT               NOT NULL DEFAULT '',
    CONSTRAINT pk_organizations PRIMARY KEY (id),
    CONSTRAINT uk_organizations_name UNIQUE (inn),
    CONSTRAINT fk_organizations_status FOREIGN KEY (status) REFERENCES org_statuses (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT
);
