-- User_role table.

CREATE TABLE user_role
(
    user_id UUID         NOT NULL,
    roles   varchar(255) NOT NULL,
    CONSTRAINT fk_users_roles_users FOREIGN KEY (user_id) REFERENCES users (id)
        ON DELETE RESTRICT ON UPDATE RESTRICT
);