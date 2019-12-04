-- Org_statuses, User_statuses, Roles tables.

CREATE TABLE org_statuses
(
    id   BIGSERIAL,
    -- 'new', 'wait' ,'confirm','ban'
    code varchar(255) NOT NULL CHECK (length(code) > 0),
    name varchar(255) NOT NULL CHECK (length(code) > 0),
    CONSTRAINT pk_org_statuses PRIMARY KEY (id),
    CONSTRAINT uk_org_code UNIQUE (code),
    CONSTRAINT uk_org_name UNIQUE (name)
);

CREATE TABLE user_statuses
(
    id   BIGSERIAL,
    -- 'new', 'wait' ,'confirm','ban'
    code varchar(255) NOT NULL CHECK (length(code) > 0),
    name varchar(255) NOT NULL CHECK (length(code) > 0),
    CONSTRAINT pk_user_statuses PRIMARY KEY (id),
    CONSTRAINT uk_user_statuses_code UNIQUE (code),
    CONSTRAINT uk_user_statuses_name UNIQUE (name)
);

CREATE TABLE roles
(
    id   BIGSERIAL,
    -- 'admin', 'user'
    code varchar(255) NOT NULL CHECK (length(code) > 0),
    name varchar(255) NOT NULL CHECK (length(code) > 0),
    CONSTRAINT pk_roles PRIMARY KEY (id),
    CONSTRAINT uk_roles_code UNIQUE (code),
    CONSTRAINT uk_roles_name UNIQUE (name)
);

CREATE TABLE order_statuses
(
    id   BIGSERIAL,
    -- 'draft', 'new' ,'cancel','taken','shipped','delivered','lost'
    code varchar(255) NOT NULL CHECK (length(code) > 0),
    name varchar(255) NOT NULL CHECK (length(code) > 0),
    CONSTRAINT pk_order_statuses PRIMARY KEY (id),
    CONSTRAINT uk_order_statuses_code UNIQUE (code),
    CONSTRAINT uk_order_statuses_name UNIQUE (name)
);

CREATE TABLE delivery_types
(
    id   BIGSERIAL,
    -- 'pickup', 'supply'
    code varchar(255) NOT NULL CHECK (length(code) > 0),
    name varchar(255) NOT NULL CHECK (length(code) > 0),
    CONSTRAINT pk_delivery_type PRIMARY KEY (id),
    CONSTRAINT uk_delivery_type_code UNIQUE (code),
    CONSTRAINT uk_delivery_type_name UNIQUE (name)
);
