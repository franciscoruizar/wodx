CREATE TABLE  IF NOT EXISTS `companies` (
  `id` char(36) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `media_url` text,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;


CREATE TABLE  IF NOT EXISTS `permissions` (
  `id` char(36) NOT NULL,
  `description` varchar(45) NOT NULL,
  `entity` varchar(45) NOT NULL,
  `create` tinyint NOT NULL,
  `delete` tinyint NOT NULL,
  `update` tinyint NOT NULL,
  `read` tinyint NOT NULL,
  `read_all` tinyint NOT NULL,
  PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

CREATE TABLE  IF NOT EXISTS `roles` (
  `id` char(36) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

CREATE TABLE  IF NOT EXISTS `users` (
  `id` char(36) NOT NULL,
  `email` varchar(320) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role_id` char(36) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `phone` varchar(17) DEFAULT NULL,
  `is_active` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

CREATE TABLE  IF NOT EXISTS `user_companies` (
  `id` char(36) NOT NULL,
  `user_id` char(36) NOT NULL,
  `company_id` char(36) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_companies_company` (`company_id`),
  KEY `fk_user_companies_user` (`user_id`),
  CONSTRAINT `fk_user_companies_company` FOREIGN KEY (`company_id`) REFERENCES `companies` (`id`),
  CONSTRAINT `fk_user_companies_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `memberships` (
  `id` char(36) NOT NULL,
  `number_days_enabled` int NOT NULL DEFAULT 0,
  `price` decimal(15,2) NOT NULL DEFAULT 0.0,
  `company_id` char(36) NOT NULL,
  `is_active` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  KEY `fk_memberships_company` (`company_id`),
  CONSTRAINT `fk_memberships_company` FOREIGN KEY (`company_id`) REFERENCES `companies` (`id`)
)
	ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `user_memberships` (
  `id` char(36) NOT NULL,
  `date_from` date NOT NULL,
  `date_to` date NOT NULL,
  `membership_id` char(36) NOT NULL,
  `user_id` char(36) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_memberships_memberships` (`membership_id`),
  CONSTRAINT `fk_user_memberships_memberships` FOREIGN KEY (`membership_id`) REFERENCES `memberships` (`id`),
  KEY `fk_user_memberships_users` (`user_id`),
  CONSTRAINT `fk_user_memberships_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
)
	ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `purchases` (
  `id` char(36) NOT NULL,
  `description` varchar(36) NOT NULL,
  `date` datetime NOT NULL,
  `user_id` char(36) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_purchases_users` (`user_id`),
  CONSTRAINT `fk_purchases_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
)
	ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `purchase_items` (
  `id` char(36) NOT NULL,
  `quantity` int NOT NULL,
  `membership_id` char(36) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_purchases_memberships` (`membership_id`),
  CONSTRAINT `fk_purchases_memberships` FOREIGN KEY (`membership_id`) REFERENCES `memberships` (`id`)
)
	ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;
