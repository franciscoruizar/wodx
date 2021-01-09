CREATE TABLE IF NOT EXISTS `workouts`.`step_types` (
  `id` CHAR(36) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `language` CHAR(20) NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `workouts`.`step_types` VALUES('a4eb5e69-de3b-4780-992b-65b36023c465', 'Warm Up', 'english');
INSERT INTO `workouts`.`step_types` VALUES('dcdb8baf-533f-48cb-a68f-4f8b36180f3d', 'Abs Workout', 'english');
INSERT INTO `workouts`.`step_types` VALUES('6cf7d718-1bd8-4f17-8239-bd735289ce21', 'Legs Workout', 'english');
INSERT INTO `workouts`.`step_types` VALUES('345485c4-b985-4c0a-a73d-d872c4686f6d', 'Shoulder Workout', 'english');
INSERT INTO `workouts`.`step_types` VALUES('958505f4-978d-43a0-a87c-87c356d250fb', 'Back Workout', 'english');
INSERT INTO `workouts`.`step_types` VALUES('00601101-0413-42c5-aac7-ea3d7b8f3199', 'Elongation Workout', 'english');
INSERT INTO `workouts`.`step_types` VALUES('4bfcb236-f0f1-42b8-97e7-3170c5c4935e', 'HIIT Workout', 'english');
INSERT INTO `workouts`.`step_types` VALUES('4ab4401a-5b75-4e48-9248-39ac8db3ffe4', 'EMOM Workout', 'english');
INSERT INTO `workouts`.`step_types` VALUES('25bcb218-8848-43ab-b088-196c90f1338a', 'AMRAP Workout', 'english');

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
