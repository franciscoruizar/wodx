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
	is_active tinyint default 1 not null,
	constraint fk_users__roles foreign key (role_id) references roles (id)
);

insert into roles (id, description) values('f7030ab4-d20f-469b-8ee4-a1c5e27bee36', 'ADMIN');
insert into roles (id, description) values('870c1fe5-af03-43f1-a0b3-1988058ed405', 'COMPANY');
insert into roles (id, description) values('ccdc5863-1061-4b9c-9061-4af9a6c60357', 'EMPLOYEE');
insert into roles (id, description) values('3f321312-4efd-4e8d-a4fe-ba2d9fe9ed84', 'USER');
