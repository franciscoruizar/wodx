create table if not exists companies
(
	id char(36) not null
		primary key,
	description varchar(45) null,
	media_url text null,
	latitude double null,
	longitude double null,
	is_active tinyint(1) null
);

create table if not exists roles
(
	id char(36) not null
		primary key,
	description varchar(45) not null
);

create table if not exists users
(
	id char(36) not null
		primary key,
	email varchar(320) not null,
	password varchar(320) null,
	role_id char(36) not null,
	name varchar(45) null,
	surname varchar(45) null,
	phone varchar(25) null,
	is_active tinyint default 1 not null
);


create table if not exists user_companies
(
	id char(36) not null
		primary key,
	user_id char(36) not null,
	company_id char(36) not null,
	constraint fk_user_companies__companies foreign key (company_id) references companies (id),
	constraint fk_user_companies__users foreign key (user_id) references users (id)
);

