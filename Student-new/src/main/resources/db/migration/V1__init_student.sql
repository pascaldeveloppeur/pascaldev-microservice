create table student (
        id bigserial not null,
        email varchar(255),
        first_name varchar(255),
        lastname varchar(255),
        school_id bigint,
        primary key (id)
    )