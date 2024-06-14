 create table "course" (
        "id" bigint not null,
        "course_name" varchar(20),
        primary key ("id")
    );
create sequence "course_seq" start with 1 increment by 1;

create table "subject" (
        "id" bigint not null,
        "subject_desription" varchar(255),
        "subject_name" varchar(20),
        "course_id" bigint,
        primary key ("id")
    );
create sequence "subject_seq" start with 1 increment by 1;