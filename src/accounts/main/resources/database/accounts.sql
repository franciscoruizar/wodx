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

create table if not exists memberships
(
	id char(36) not null
		primary key,
	number_days_enabled int default 0 not null,
	price decimal(15,2) default 0.00 not null,
	company_id char(36) not null,
	description varchar(36) not null,
	is_active tinyint(1) default 1 not null,
	constraint fk_memberships_company
		foreign key (company_id) references companies (id)
);

create table if not exists roles
(
	id char(36) not null
		primary key,
	description varchar(45) null
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
	constraint fk_user_companies_company
		foreign key (company_id) references companies (id),
	constraint fk_user_companies_user
		foreign key (user_id) references users (id)
);

create table if not exists user_memberships
(
	id char(36) not null
		primary key,
	date_from date not null,
	date_to date not null,
	membership_id char(36) not null,
	user_id char(36) not null,
	constraint fk_user_memberships_memberships
		foreign key (membership_id) references memberships (id),
	constraint fk_user_memberships_users
		foreign key (user_id) references users (id)
);

create table if not exists purchases
(
	id char(36) not null
		primary key,
	description varchar(36) not null,
	date datetime not null,
	user_id char(36) not null,
	company_id varchar(36) null,
	constraint fk_purchases_companies
		foreign key (company_id) references companies (id),
	constraint fk_purchases_users
		foreign key (user_id) references users (id)
);

create table if not exists purchase_items
(
	id char(36) not null
		primary key,
	quantity int not null,
	membership_id char(36) not null,
	constraint fk_purchases_memberships
		foreign key (membership_id) references memberships (id)
);
