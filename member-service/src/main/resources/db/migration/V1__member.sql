CREATE TABLE IF NOT EXISTS MEMBER (
    id BIGINT not null,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    user_name VARCHAR(50),
    email VARCHAR(50),
    password VARCHAR(50),
    PRIMARY KEY (id)

);
CREATE SEQUENCE user_seq START WITH 1 INCREMENT BY 1;