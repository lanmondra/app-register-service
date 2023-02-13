--liquibase formatted sql

-- changeset Angel:20221119-120000-1

-- -----------------------------------------------------
-- Insert user test
-- -----------------------------------------------------

INSERT INTO base_user (id, uuid,name, first_last_name, second_last_name, email, password, default_lang, town_code, post_code) VALUES
            (2, 'AAAA','admin', 'lastName', 'secondLastName', 'admin@admin.es','admin','es',803, '08026');

INSERT INTO user_roles (id, user_id, role_id) VALUES
            (3,2,1);

