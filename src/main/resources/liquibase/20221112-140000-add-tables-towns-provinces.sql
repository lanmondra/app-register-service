--liquibase formatted sql

-- changeset angel:20221112-141000-1

-- -----------------------------------------------------
-- Table province
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `province` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,

  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) )

 ENGINE = InnoDB
;


-- -----------------------------------------------------
-- Table town
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `town` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `province_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),


    CONSTRAINT `town_province_fk`
    FOREIGN KEY (`province_id`)
    REFERENCES `province` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)


ENGINE = InnoDB
;