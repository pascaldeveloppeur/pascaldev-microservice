 create table "inscription" (
        "id" bigint not null,
        "student_name" varchar(20),
        "classe_id" bigint,
        primary key ("id")
    );
create sequence "inscription_seq" start with 1 increment by 1;

create table "classe" (
        "id" bigint not null,
        "name" varchar(255),
        primary key ("id")
    );
create sequence "classe_seq" start with 1 increment by 1;