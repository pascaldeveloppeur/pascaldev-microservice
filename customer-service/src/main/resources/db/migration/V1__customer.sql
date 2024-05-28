CREATE TABLE IF NOT EXISTS CUSTOMER (
    id BIGINT not null,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(50),
    PRIMARY KEY (id)

);
CREATE SEQUENCE customer_seq START WITH 1 INCREMENT BY 1;


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

CREATE TABLE IF NOT EXISTS ACCOUNT (
    id BIGINT not null,
    balance float(53) not null,
    create_at date,
    customer_id bigint,
    account_id varchar(255) not null,
    currency varchar(255),
    type varchar(255) check (type in ('CURRENT_ACCOUNT','SAVING_ACCOUNT')),
    PRIMARY KEY (id)

);
CREATE SEQUENCE user_seq START WITH 1 INCREMENT BY 1;

create table account (      primary key (account_id))