-- Users_organizations table.

CREATE TABLE users_organizations
(
    id              BIGSERIAL,
    user_id         BIGINT NOT NULL,
    organization_id BIGINT NOT NULL,
    CONSTRAINT pk_users_organizations PRIMARY KEY (id),
    CONSTRAINT fk_users_organizations_users FOREIGN KEY (user_id) REFERENCES users (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_users_organizations_organizations FOREIGN KEY (organization_id) REFERENCES organizations (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT
);