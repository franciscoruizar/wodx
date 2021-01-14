CREATE TABLE IF NOT EXISTS `accounts`.`permissions` (
  `id` CHAR(36) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `entity` VARCHAR(45) NOT NULL,
  `create` TINYINT NOT NULL,
  `delete` TINYINT NOT NULL,
  `update` TINYINT NOT NULL,
  `read` TINYINT NOT NULL,
  `read_all` TINYINT NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `accounts`.`roles` (
  `id` CHAR(36) NOT NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `accounts`.`role_permissions` (
  `id` CHAR(36) NOT NULL,
  `permission_id` CHAR(36) NOT NULL,
  `role_id` CHAR(36) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_role_permissions_permissions` (`permission_id` ASC) VISIBLE,
  INDEX `fk_role_permissions_roles` (`role_id` ASC) VISIBLE,
  CONSTRAINT `fk_role_permissions_permissions`
    FOREIGN KEY (`permission_id`)
    REFERENCES `accounts`.`permissions` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_permissions_roles`
    FOREIGN KEY (`role_id`)
    REFERENCES `accounts`.`roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `accounts`.`companies` (
  `id` CHAR(36) NOT NULL,
  `description` VARCHAR(45) NULL,
  `media_url` TEXT NULL,
  `latitude` DOUBLE NULL,
  `longitude` DOUBLE NULL,
  `is_active` BOOLEAN NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `accounts`.`users` (
  `id` CHAR(36) NOT NULL,
  `email` VARCHAR(320) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `company_id` CHAR(36) NOT NULL,
  `role_id` CHAR(36) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_company` (`company_id` ASC) VISIBLE,
  INDEX `fk_users_roles` (`role_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_company`
    FOREIGN KEY (`company_id`)
    REFERENCES `accounts`.`companies` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`role_id`)
    REFERENCES `accounts`.`roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
