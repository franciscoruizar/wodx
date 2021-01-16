CREATE TABLE IF NOT EXISTS `workouts`.`step_types` (
  `id` CHAR(36) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `language` CHAR(20) NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `workouts`.`workouts` (
  `id` CHAR(36) NOT NULL,
  `start_date` DATETIME NOT NULL,
  `end_date` DATETIME NOT NULL,
  `coach_id` CHAR(36) NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `workouts`.`steps` (
  `id` CHAR(36) NOT NULL,
  `description` VARCHAR(45) NULL,
  `step_type_id` CHAR(36) NOT NULL,
  `workout_id` CHAR(36) NOT NULL,
  PRIMARY KEY (`id`, `step_type_id`, `workout_id`),
  INDEX `fk_steps_step_types` (`step_type_id` ASC) VISIBLE,
  INDEX `fk_steps_workouts` (`workout_id` ASC) VISIBLE,
  CONSTRAINT `fk_steps_step_types`
    FOREIGN KEY (`step_type_id`)
    REFERENCES `workouts`.`step_types` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_steps_workouts`
    FOREIGN KEY (`workout_id`)
    REFERENCES `workouts`.`workouts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `workouts`.`exercises` (
  `id` CHAR(36) NOT NULL,
  `description` VARCHAR(45) NULL,
  `media_url` VARCHAR(45) NULL,
  `step_id` CHAR(36) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_exercises_steps` (`step_id` ASC) VISIBLE,
  CONSTRAINT `fk_exercises_steps`
    FOREIGN KEY (`step_id`)
    REFERENCES `workouts`.`steps` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `workouts`.`workout_users` (
  `id` INT NOT NULL,
  `workout_id` CHAR(36) NOT NULL,
  `user_id` CHAR(36) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_workout_users_workouts1_id` (`workout_id` ASC) VISIBLE,
  CONSTRAINT `fk_workout_users_workouts`
    FOREIGN KEY (`workout_id`)
    REFERENCES `workouts`.`workouts` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
