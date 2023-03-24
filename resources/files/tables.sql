CREATE TABLE `customers` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_name` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `city` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `state_region` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `zip_code` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `phone_number` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ip` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `customer_invalid` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_name` VARCHAR(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `city` VARCHAR(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `state_region` VARCHAR(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `zip_code` VARCHAR(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `phone_number` VARCHAR(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` VARCHAR(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ip` VARCHAR(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `customer_valid` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_name` VARCHAR(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `city` VARCHAR(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `state_region` VARCHAR(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `zip_code` VARCHAR(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `phone_number` VARCHAR(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` VARCHAR(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ip` VARCHAR(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;