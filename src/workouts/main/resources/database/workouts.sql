--
-- Table structure for table `exercises`
--

DROP TABLE IF EXISTS `exercises`;
CREATE TABLE `exercises` (
  `id` char(36) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `media_url` text COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Table structure for table `step_types`
--

DROP TABLE IF EXISTS `step_types`;
CREATE TABLE `step_types` (
  `id` char(36) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `language` char(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Table structure for table `steps`
--

DROP TABLE IF EXISTS `steps`;
CREATE TABLE `steps` (
  `id` char(36) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `step_type_id` char(36) COLLATE utf8mb4_unicode_ci NOT NULL,
  `workout_id` char(36) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`,`step_type_id`,`workout_id`),
  KEY `fk_steps_step_types` (`step_type_id`),
  KEY `fk_steps_workouts` (`workout_id`),
  CONSTRAINT `fk_steps_step_types` FOREIGN KEY (`step_type_id`) REFERENCES `step_types` (`id`),
  CONSTRAINT `fk_steps_workouts` FOREIGN KEY (`workout_id`) REFERENCES `workouts` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Table structure for table `workout_exercises`
--

DROP TABLE IF EXISTS `workout_exercises`;
CREATE TABLE `workout_exercises` (
  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `series` int NOT NULL,
  `value` int NOT NULL,
  `time_unit` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `exercise_id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `workout_id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_workout_exercise_exercises` (`exercise_id`),
  KEY `fk_workout_exercise_workouts` (`workout_id`),
  CONSTRAINT `fk_workout_exercise_exercises` FOREIGN KEY (`exercise_id`) REFERENCES `exercises` (`id`),
  CONSTRAINT `fk_workout_exercise_workouts` FOREIGN KEY (`workout_id`) REFERENCES `workouts` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Table structure for table `workout_users`
--

DROP TABLE IF EXISTS `workout_users`;
CREATE TABLE `workout_users` (
  `id` int NOT NULL,
  `workout_id` char(36) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_id` char(36) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_workout_users_workouts1_id` (`workout_id`),
  CONSTRAINT `fk_workout_users_workouts` FOREIGN KEY (`workout_id`) REFERENCES `workouts` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Table structure for table `workouts`
--

DROP TABLE IF EXISTS `workouts`;
CREATE TABLE `workouts` (
  `id` char(36) COLLATE utf8mb4_unicode_ci NOT NULL,
  `start_date` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  `coach_id` char(36) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
