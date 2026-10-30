CREATE DATABASE IF NOT EXISTS eWheelDB;
       USE eWheelDB;
CREATE TABLE IF NOT EXISTS `Vehicle` (
                                         `Vehicle_id` BINARY(16) NOT NULL UNIQUE,
    `name` VARCHAR(255) NOT NULL,
    `licence_plate` VARCHAR(255) NOT NULL,
    `category` VARCHAR(255) NOT NULL,
    `is_active` BOOLEAN NOT NULL,
    `kilometers` DECIMAL(7,1) NOT NULL,
    PRIMARY KEY(`Vehicle_id`)
    );


CREATE TABLE IF NOT EXISTS `Vehicle_Contract` (
                                                  `Vehicle_Contract_id` BINARY(16) NOT NULL UNIQUE,
    `Vehicle_id` BINARY(16) NOT NULL,
    `contract_number` VARCHAR(100) NOT NULL UNIQUE,
    `contract_type` ENUM('PURCHASE', 'LEASING', 'RENTAL') NOT NULL,
    `provider` VARCHAR(150) NOT NULL,
    `start_date` DATE NOT NULL,
    `end_date` DATE,
    `price` DECIMAL(12,2) NOT NULL,
    PRIMARY KEY(`Vehicle_Contract_id`)
    );


CREATE TABLE IF NOT EXISTS `Vehicle_Service` (
                                                 `Vehicle_Service_id` BINARY(16) NOT NULL UNIQUE,
    `vehicle_id` BINARY(16) NOT NULL,
    `vehicle_inspection_exp` DATE NOT NULL,
    `emissions_inspection_exp` DATE NOT NULL,
    `next_oil_change` BIGINT,
    PRIMARY KEY(`Vehicle_Service_id`)
    );


CREATE TABLE IF NOT EXISTS `User` (
                                      `User_id` BINARY(16) NOT NULL UNIQUE,
    `email` VARCHAR(100) NOT NULL,
    `name` VARCHAR(50) NOT NULL,
    `last_name` VARCHAR(50) NOT NULL,
    `role` ENUM('ADMIN', 'EMPLOYEE') NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `is_active` BOOLEAN NOT NULL,
    `birthdate` DATE NOT NULL,
    `driving_licence` VARCHAR(50) NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    PRIMARY KEY(`User_id`)
    );


CREATE TABLE IF NOT EXISTS `Activity_Logging` (
                                                  `Activity_Logging_id` BINARY(16) NOT NULL UNIQUE,
    `action` VARCHAR(100) NOT NULL,
    `body` VARCHAR(255) NOT NULL,
    `user_id` BINARY(16) NOT NULL,
    `status` VARCHAR(50) NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    PRIMARY KEY(`Activity_Logging_id`)
    );


CREATE TABLE IF NOT EXISTS `Business_Trip` (
                                               `Business_Trip_id` BINARY(16) NOT NULL UNIQUE,
    `reason` TEXT(65535) NOT NULL,
    `status` VARCHAR(30) NOT NULL,
    `vehicle_id` BINARY(16) NOT NULL,
    `user_id` BINARY(16) NOT NULL,
    `start_date` DATETIME NOT NULL,
    `end_date` DATETIME NOT NULL,
    `start_address` BINARY(16) NOT NULL,
    `destination_address` BINARY(16) NOT NULL,
    PRIMARY KEY(`Business_Trip_id`)
    );


CREATE TABLE IF NOT EXISTS `Address` (
                                         `address_id` BINARY(16) NOT NULL,
    `street` VARCHAR(150),
    `Number` VARCHAR(20) NOT NULL,
    `City` VARCHAR(100) NOT NULL,
    `zip` VARCHAR(5) NOT NULL,
    `region` ENUM('BA', 'TT', 'TN', 'NR', 'ZA', 'BB', 'PO', 'KE') NOT NULL,
    PRIMARY KEY(`address_id`)
    );


ALTER TABLE `Vehicle_Contract`
    ADD FOREIGN KEY(`Vehicle_id`) REFERENCES `Vehicle`(`Vehicle_id`)
        ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `Vehicle_Service`
    ADD FOREIGN KEY(`vehicle_id`) REFERENCES `Vehicle`(`Vehicle_id`)
        ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `Activity_Logging`
    ADD FOREIGN KEY(`user_id`) REFERENCES `User`(`User_id`)
        ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `Business_Trip`
    ADD FOREIGN KEY(`vehicle_id`) REFERENCES `Vehicle`(`Vehicle_id`)
        ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `Business_Trip`
    ADD FOREIGN KEY(`user_id`) REFERENCES `User`(`User_id`)
        ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `Business_Trip`
    ADD FOREIGN KEY(`start_address`) REFERENCES `Address`(`address_id`)
        ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `Business_Trip`
    ADD FOREIGN KEY(`destination_address`) REFERENCES `Address`(`address_id`)
        ON UPDATE NO ACTION ON DELETE NO ACTION;