-- Users table.

CREATE TYPE roles as enum ( 'admin', 'user' );
CREATE TYPE user_statuses as enum ( 'new', 'wait' ,'confirm','ban');

CREATE TABLE users
(
    id            BIGSERIAL,
    email         TEXT          NOT NULL CHECK (length(email) > 0),
    password_hash TEXT          NOT NULL CHECK (length(password_hash) > 0),
    full_name     TEXT          NOT NULL CHECK (length(full_name) > 0),
    status        user_statuses NOT NULL,
    role          roles         NOT NULL DEFAULT 'user',
    CONSTRAINT pk_users PRIMARY KEY (id),
    CONSTRAINT uq_users_email UNIQUE (email)
);

CREATE INDEX idx_users_full_name ON users (full_name);
CREATE INDEX idx_users_statuses ON users (status);