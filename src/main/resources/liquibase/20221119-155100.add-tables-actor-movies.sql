--liquibase formatted sql

-- changeset Angel:20221119-150000-1


-- -----------------------------------------------------
-- Table actor
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `actor` (
	`id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(100) NOT NULL,
	`last_name` VARCHAR(100),
	`date_born` DATE  NOT NULL,
	`country` VARCHAR(150) NOT NULL,

	PRIMARY KEY (`id`),
	 UNIQUE INDEX `id_UNIQUE` (`id`) )

ENGINE=InnoDB;


-- -----------------------------------------------------
-- Table movies
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie` (
	`id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	`title` VARCHAR(100) NOT NULL,
	`imDbRating` VARCHAR(10),
	`image` VARCHAR(255) NOT NULL,
	`idImdb` VARCHAR(35) NOT NULL,
	`year` VARCHAR(10),
	`created` TIMESTAMP NOT NULL,
    `updated` TIMESTAMP NULL,
    `deleted` TIMESTAMP NULL,

	PRIMARY KEY (`id`),
	UNIQUE KEY `id_UNIQUE` (`id`)  ,
	UNIQUE INDEX `idImdb_UNIQUE` (`idImdb`) )
ENGINE=InnoDB;

-- -----------------------------------------------------
-- Table actor movies
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS actors_movies (
  `actor_id`  INT(10) UNSIGNED NOT NULL,
  `movie_id` INT(10) UNSIGNED NOT NULL,
   PRIMARY KEY (`actor_id`, `movie_id`),

    CONSTRAINT `actor_fk_actor`
    FOREIGN KEY (`actor_id`)
    REFERENCES `actor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,

    CONSTRAINT `movie_fk_movie`
    FOREIGN KEY (`movie_id`)
    REFERENCES `movie` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    )

  ENGINE=InnoDB;