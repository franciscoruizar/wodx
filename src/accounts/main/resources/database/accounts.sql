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

INSERT INTO `accounts`.`permissions` VALUES('aa1c22f9-965a-4c1b-92e7-775e44ea01c6','companies','companies',1,1,1,1,1);
INSERT INTO `accounts`.`permissions` VALUES('455cb748-8cbf-47d0-8f02-3dd0a72202f1','companies','companies',0,0,0,1,1);
INSERT INTO `accounts`.`permissions` VALUES('d8468997-f03a-4905-b19f-2eedad9313a3','companies','companies',0,0,0,1,0);
INSERT INTO `accounts`.`permissions` VALUES('7639c189-fb99-4457-b95b-87d6cf828b0a','companies','companies',0,0,1,1,0);
INSERT INTO `accounts`.`permissions` VALUES('d0bf137d-6ff5-41d5-8880-c7eb075dabd9','accounts','users',1,1,1,1,1);
INSERT INTO `accounts`.`permissions` VALUES('18541bb4-9810-4296-8ed2-cab759ba1afa','accounts','users',0,0,0,1,0);
INSERT INTO `accounts`.`permissions` VALUES('6b12ccfd-bc94-4362-a913-26f413ebf83a','accounts','users',0,0,1,0,1);
INSERT INTO `accounts`.`permissions` VALUES('fe8c3087-71e3-4590-b411-57c5480bb11c','workouts','workouts',1,1,1,1,1);
INSERT INTO `accounts`.`permissions` VALUES('b677d311-fe31-42f0-9546-f6f63a4e1b51','workouts','workouts',0,0,0,1,1);


CREATE TABLE IF NOT EXISTS `accounts`.`roles` (
  `id` CHAR(36) NOT NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `accounts`.`roles` VALUES('b473929a-92b2-4838-bb08-7887a028bc4c','ADMIN');
INSERT INTO `accounts`.`roles` VALUES('47f9d5b7-5886-476c-a2f6-ea742453f3a4','COMPANY');
INSERT INTO `accounts`.`roles` VALUES('699c38ab-4eb5-447e-8b70-cef2e60ec422','EMPLOYEE');
INSERT INTO `accounts`.`roles` VALUES('1764a6e7-cf77-4061-aac0-b589f5810cf5','COACH');
INSERT INTO `accounts`.`roles` VALUES('6e5cbf77-8a3b-45ed-98d2-6f97a08c0ca1','ATHLETE');

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

/*                                                         ADMIN                                                                   */
INSERT INTO `accounts`.`role_permissions` VALUES('63bbaa01-2047-464c-b403-c1422daaa00f','aa1c22f9-965a-4c1b-92e7-775e44ea01c6','b473929a-92b2-4838-bb08-7887a028bc4c');
INSERT INTO `accounts`.`role_permissions` VALUES('f203a96e-c8d2-4f63-9dc4-f13ee7da9d46','d0bf137d-6ff5-41d5-8880-c7eb075dabd9','b473929a-92b2-4838-bb08-7887a028bc4c');
INSERT INTO `accounts`.`role_permissions` VALUES('8b4e1cb1-e01e-46b6-b10e-98f6c6661004','fe8c3087-71e3-4590-b411-57c5480bb11c','b473929a-92b2-4838-bb08-7887a028bc4c');

/*                                                         COMPANY                                                                  */
INSERT INTO `accounts`.`role_permissions` VALUES('09423fda-9e0f-4f19-920c-e911ba5e02b8','7639c189-fb99-4457-b95b-87d6cf828b0a','47f9d5b7-5886-476c-a2f6-ea742453f3a4');
INSERT INTO `accounts`.`role_permissions` VALUES('cbe11d74-ef5c-4f0e-81fc-6a38f1d09666','d0bf137d-6ff5-41d5-8880-c7eb075dabd9','47f9d5b7-5886-476c-a2f6-ea742453f3a4');
INSERT INTO `accounts`.`role_permissions` VALUES('1b752bdb-92a5-4580-874f-9bf751a07059','fe8c3087-71e3-4590-b411-57c5480bb11c','b473929a-92b2-4838-bb08-7887a028bc4c');

/*                                                         EMPLOYEE                                                                 */
INSERT INTO `accounts`.`role_permissions` VALUES('91591ca6-326f-48f2-a060-d7d101eabe6e','d8468997-f03a-4905-b19f-2eedad9313a3','699c38ab-4eb5-447e-8b70-cef2e60ec422');
INSERT INTO `accounts`.`role_permissions` VALUES('d8ac6cfe-3553-45ec-97f4-4a492c96fa85','18541bb4-9810-4296-8ed2-cab759ba1afa','699c38ab-4eb5-447e-8b70-cef2e60ec422');
INSERT INTO `accounts`.`role_permissions` VALUES('628c26b6-0c5f-4d1b-80b1-a71076e4fd81','fe8c3087-71e3-4590-b411-57c5480bb11c','b473929a-92b2-4838-bb08-7887a028bc4c');

/*                                                         COACH                                                                    */
INSERT INTO `accounts`.`role_permissions` VALUES('3bbbfd91-b6a2-4f8a-93b8-e1d3ae4883e8','d8468997-f03a-4905-b19f-2eedad9313a3','1764a6e7-cf77-4061-aac0-b589f5810cf5');
INSERT INTO `accounts`.`role_permissions` VALUES('e688f6ce-44e5-4f62-bd48-58ef1041c075','18541bb4-9810-4296-8ed2-cab759ba1afa','1764a6e7-cf77-4061-aac0-b589f5810cf5');
INSERT INTO `accounts`.`role_permissions` VALUES('910009bc-77cf-43b3-a7ff-90044c71a35b','fe8c3087-71e3-4590-b411-57c5480bb11c','b473929a-92b2-4838-bb08-7887a028bc4c');

/*                                                         ATHLETE                                                                   */
INSERT INTO `accounts`.`role_permissions` VALUES('8ca79655-72a0-4a24-ad04-3e61fe9047d8','d8468997-f03a-4905-b19f-2eedad9313a3','6e5cbf77-8a3b-45ed-98d2-6f97a08c0ca1');
INSERT INTO `accounts`.`role_permissions` VALUES('fd7e0ce9-bd4a-4d2d-b6ee-8d598c66ed86','6b12ccfd-bc94-4362-a913-26f413ebf83a','6e5cbf77-8a3b-45ed-98d2-6f97a08c0ca1');
INSERT INTO `accounts`.`role_permissions` VALUES('f5166bc7-68f5-42c5-ad86-887de007b6fe','b677d311-fe31-42f0-9546-f6f63a4e1b51','b473929a-92b2-4838-bb08-7887a028bc4c');

CREATE TABLE IF NOT EXISTS `accounts`.`companies` (
  `id` CHAR(36) NOT NULL,
  `description` VARCHAR(45) NULL,
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
