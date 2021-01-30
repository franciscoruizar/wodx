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
