create table if not exists products
(
	id char(36) not null primary key,
	title varchar(36) not null,
	description varchar(155) not null,
	price decimal(15,2) default 0.00 not null,
	company_id char(36) not null,
	is_active tinyint(1) default 1 not null,
	constraint fk_products__companies foreign key (company_id) references companies (id)
);

create table if not exists memberships
(
	id char(36) not null primary key,
	number_days_enabled int default 0 not null,
	constraint fk_memberships__products foreign key (id) references products (id)
);

create table if not exists material_products
(
	id char(36) not null primary key,
	weight int default 0 not null,
	constraint fk_material_products__products foreign key (id) references products (id)
);

create table if not exists purchases
(
	id char(36) not null primary key,
	description varchar(36) not null,
	date datetime not null,
	user_id char(36) not null,
	company_id varchar(36) null,
	constraint fk_purchases__companies foreign key (company_id) references companies (id),
	constraint fk_purchases__users foreign key (user_id) references users (id)
);

create table if not exists items
(
	id char(36) not null primary key,
	quantity int not null,
	unit_price double not null,
	product_id char(36) not null,
	purchase_id char(36) null,
	constraint fk_items__products foreign key (product_id) references products (id),
	constraint fk_items__purchases foreign key (purchase_id) references purchases (id)
);
