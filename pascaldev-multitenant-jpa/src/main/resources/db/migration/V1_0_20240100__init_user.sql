
create table "user" (
        "id" bigint not null,
        "name" varchar(20),
        "email" varchar(255) not null unique,
        primary key ("id")
    );
create sequence "school_seq" start with 1 increment by 1