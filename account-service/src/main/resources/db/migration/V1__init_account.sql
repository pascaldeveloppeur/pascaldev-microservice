create table account (
        balance float(53) not null,
        create_at date,
        customer_id bigint,
        id bigserial not null,
        currency varchar(255),
        type varchar(255) check (type in ('CURRENT_ACCOUNT','SAVING_ACCOUNT')),
        primary key (id)
    );
    
 create sequence account_seq start with 1 increment by 1;   