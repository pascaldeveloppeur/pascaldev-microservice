create table customer (
        id bigint not null,
        email varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        primary key (id)
    );
create sequence customer_seq start with 1 increment by 1;


