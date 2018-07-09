-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mileagedb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mileagedb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mileagedb` DEFAULT CHARACTER SET utf8 ;
USE `mileagedb` ;

-- -----------------------------------------------------
-- Table `mileagedb`.`mileage`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mileagedb`.`mileage` ;

CREATE TABLE IF NOT EXISTS `mileagedb`.`mileage` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `miles_driven` DOUBLE NOT NULL,
  `gallons_filled` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SET SQL_MODE = '';
GRANT USAGE ON *.* TO student;
 DROP USER student;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'student' IDENTIFIED BY 'student';

GRANT SELECT, INSERT, TRIGGER ON TABLE `mileagedb`.* TO 'student';
GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE `mileagedb`.* TO 'student';
SET SQL_MODE = '';
GRANT USAGE ON *.* TO root;
 DROP USER root;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'root' IDENTIFIED BY 'root';

GRANT ALL ON `mileagedb`.* TO 'root';
GRANT SELECT, INSERT, TRIGGER ON TABLE `mileagedb`.* TO 'root';
GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE `mileagedb`.* TO 'root';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
