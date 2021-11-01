-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema tracksleepdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `tracksleepdb` ;

-- -----------------------------------------------------
-- Schema tracksleepdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tracksleepdb` DEFAULT CHARACTER SET utf8 ;
USE `tracksleepdb` ;

-- -----------------------------------------------------
-- Table `sleep`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sleep` ;

CREATE TABLE IF NOT EXISTS `sleep` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `day` VARCHAR(45) NOT NULL,
  `sleep_duration` DOUBLE NOT NULL,
  `desired_sleep_time` DOUBLE NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS tracksleepuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'tracksleepuser'@'localhost' IDENTIFIED BY 'sleep';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'tracksleepuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `sleep`
-- -----------------------------------------------------
START TRANSACTION;
USE `tracksleepdb`;
INSERT INTO `sleep` (`id`, `day`, `sleep_duration`, `desired_sleep_time`, `created_at`, `updated_at`) VALUES (1, 'Monday', 8, 8, '2021-10-29', '2021-10-29');

COMMIT;

