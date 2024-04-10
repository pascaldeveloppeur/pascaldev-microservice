
create table Author (id bigint not null, zipcode_id bigint, name varchar(255), primary key (id));
create sequence author_seq start with 1 increment by 1;

create table author_books (author_id bigint not null, books_id bigint not null);

create table Book (category_id bigint, id bigint not null, name varchar(255), primary key (id));
create sequence book_seq start with 1 increment by 1;

create table book_author (author_id bigint not null, book_id bigint not null);

create table Category (id bigint not null, name varchar(255), primary key (id));
create sequence category_seq start with 1 increment by 1;

create table City (id bigint not null, name varchar(255), primary key (id));
create sequence city_seq start with 1 increment by 1;

create table Zipcode (city_id bigint unique, id bigserial not null, name varchar(255), primary key (id));
create sequence zipcode_seq start with 1 increment by 1;