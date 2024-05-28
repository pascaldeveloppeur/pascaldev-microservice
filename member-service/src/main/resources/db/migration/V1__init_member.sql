create table member (
	id bigint not null, 
	user_name varchar(10), 
	first_name varchar(20), 
	last_name varchar(20), 
	email varchar(255) not null unique, 
	password varchar(255) unique, 
	primary key (id)
	)
create sequence user_seq start with 1 increment by 1