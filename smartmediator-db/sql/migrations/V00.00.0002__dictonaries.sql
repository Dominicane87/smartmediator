-- Org_statuses, User_statuses, Roles, Order_statuses, Delivery_types tables.

CREATE EXTENSION IF NOT EXISTS "uuid-ossp" schema pg_catalog;

CREATE TABLE org_statuses
(
    id   UUID         NOT NULL PRIMARY KEY DEFAULT uuid_generate_v1mc(),
    -- 'new', 'wait' ,'confirm','ban'
    code varchar(255) NOT NULL CHECK (length(code) > 0),
    name varchar(255) NOT NULL CHECK (length(code) > 0),
    CONSTRAINT uk_org_statuses UNIQUE (id),
    CONSTRAINT uk_org_code UNIQUE (code),
    CONSTRAINT uk_org_name UNIQUE (name)
);

CREATE TABLE user_statuses
(
    id   UUID         NOT NULL PRIMARY KEY DEFAULT uuid_generate_v1mc(),
    -- 'new', 'wait' ,'confirm','ban'
    code varchar(255) NOT NULL CHECK (length(code) > 0),
    name varchar(255) NOT NULL CHECK (length(code) > 0),
    CONSTRAINT uk_user_statuses UNIQUE (id),
    CONSTRAINT uk_user_statuses_code UNIQUE (code),
    CONSTRAINT uk_user_statuses_name UNIQUE (name)
);

CREATE TABLE roles
(
    id   UUID         NOT NULL PRIMARY KEY DEFAULT uuid_generate_v1mc(),
    -- 'admin', 'user'
    code varchar(255) NOT NULL CHECK (length(code) > 0),
    name varchar(255) NOT NULL CHECK (length(code) > 0),
    CONSTRAINT uk_roles UNIQUE (id),
    CONSTRAINT uk_roles_code UNIQUE (code),
    CONSTRAINT uk_roles_name UNIQUE (name)
);

CREATE TABLE order_statuses
(
    id   UUID         NOT NULL PRIMARY KEY DEFAULT uuid_generate_v1mc(),
    -- 'draft', 'new' ,'cancel','taken','shipped','delivered','lost'
    code varchar(255) NOT NULL CHECK (length(code) > 0),
    name varchar(255) NOT NULL CHECK (length(code) > 0),
    CONSTRAINT uk_order_statuses UNIQUE (id),
    CONSTRAINT uk_order_statuses_code UNIQUE (code),
    CONSTRAINT uk_order_statuses_name UNIQUE (name)
);

CREATE TABLE delivery_types
(
    id   UUID         NOT NULL PRIMARY KEY DEFAULT uuid_generate_v1mc(),
    -- 'pickup', 'supply'
    code varchar(255) NOT NULL CHECK (length(code) > 0),
    name varchar(255) NOT NULL CHECK (length(code) > 0),
    CONSTRAINT uk_delivery_types UNIQUE (id),
    CONSTRAINT uk_delivery_type_code UNIQUE (code),
    CONSTRAINT uk_delivery_type_name UNIQUE (name)
);

CREATE TABLE bids_statuses
(
    id   UUID         NOT NULL PRIMARY KEY DEFAULT uuid_generate_v1mc(),
    -- 'new', 'confirmed', 'denied, 'refresh'
    code varchar(255) NOT NULL CHECK (length(code) > 0),
    name varchar(255) NOT NULL CHECK (length(code) > 0),
    CONSTRAINT uk_bids_statuses UNIQUE (id),
    CONSTRAINT uk_bids_statuses_code UNIQUE (code),
    CONSTRAINT uk_bids_statuses_name UNIQUE (name)
);
