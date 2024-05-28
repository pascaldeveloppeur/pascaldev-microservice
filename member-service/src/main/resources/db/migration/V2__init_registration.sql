create table registration (
	amount float(53), 
	registration_date date, 
	id bigint not null, 
	member_id bigint unique, 
	member_status varchar(255) check (member_status in ('CLASSIC','SENIOR','DISPORA')), 
	primary key (id)
	)
create sequence registration_seq start with 1 increment by 1