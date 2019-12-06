-- Users table.

CREATE TABLE users
(
    id            UUID NOT NULL PRIMARY KEY DEFAULT uuid_generate_v1mc(),
    email         TEXT NOT NULL CHECK (length(email) > 0),
    password_hash TEXT NOT NULL CHECK (length(password_hash) > 0),
    full_name     TEXT NOT NULL CHECK (length(full_name) > 0),
    status        UUID NOT NULL,
    role          UUID NOT NULL,
    CONSTRAINT pk_users UNIQUE (id),
    CONSTRAINT uq_users_email UNIQUE (email),
    CONSTRAINT fk_users_status FOREIGN KEY (status) REFERENCES user_statuses (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT fk_users_role FOREIGN KEY (role) REFERENCES roles (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE INDEX idx_users_full_name ON users (full_name);