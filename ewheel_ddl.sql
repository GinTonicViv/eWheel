CREATE TABLE IF NOT EXISTS `Vehicle` (
                                         `uuid` BINARY(16) NOT NULL UNIQUE,
    `name` VARCHAR(50) NOT NULL,
    `licence_plate` VARCHAR(7) NOT NULL,
    `category` VARCHAR(3) NOT NULL,
    `is_active` BOOLEAN NOT NULL,
    `kilometers` DECIMAL(7,1) NOT NULL,
    `last_stk` DATE NOT NULL,
    `next_oil_change_kilometers` DECIMAL(7,1) NOT NULL,
    `next_oil_change_date` DATE NOT NULL,
    PRIMARY KEY(`uuid`)
    );


CREATE TABLE IF NOT EXISTS `Vehicle_Contract` (
                                                  `uuid` BINARY(16) NOT NULL UNIQUE,
    `Vehicle_id` BINARY(16) NOT NULL,
    `contract_number` VARCHAR(100) NOT NULL UNIQUE,
    `contract_type` ENUM('PURCHASE', 'LEASING', 'RENTAL') NOT NULL,
    `provider` VARCHAR(150) NOT NULL,
    `start_date` DATE NOT NULL,
    `end_date` DATE,
    `price` DECIMAL(12,2) NOT NULL,
    `start_kilometers` DECIMAL(7,1) NOT NULL,
    `end_kilometers` DECIMAL(7,1),
    PRIMARY KEY(`uuid`)
    );


CREATE TABLE IF NOT EXISTS `Vehicle_Service` (
                                                 `uuid` BINARY(16) NOT NULL UNIQUE,
    `vehicle_id` BINARY(16) NOT NULL,
    `title` ENUM('Oil change', 'Technical inspection (STK)', 'Emissions test', 'Brake replacement', 'Gearbox replacement', 'Other') NOT NULL,
    `title_optional` VARCHAR(50),
    `info` TEXT(500) NOT NULL,
    `date` DATE NOT NULL,
    PRIMARY KEY(`uuid`)
    );


CREATE TABLE IF NOT EXISTS `User` (
                                      `uuid` BINARY(16) NOT NULL UNIQUE,
    `email` VARCHAR(100) NOT NULL,
    `name` VARCHAR(50) NOT NULL,
    `last_name` VARCHAR(50) NOT NULL,
    `role` ENUM('ADMIN', 'EMPLOYEE') NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `is_active` BOOLEAN NOT NULL,
    `birthdate` DATE NOT NULL,
    `driving_licence` VARCHAR(50) NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    PRIMARY KEY(`uuid`)
    );


CREATE TABLE IF NOT EXISTS `Activity_Logging` (
                                                  `uuid` BINARY(16) NOT NULL UNIQUE,
    `action` VARCHAR(100) NOT NULL,
    `body` VARCHAR(255) NOT NULL,
    `user_id` BINARY(16) NOT NULL,
    `status` VARCHAR(50) NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    PRIMARY KEY(`uuid`)
    );


CREATE TABLE IF NOT EXISTS `Business_Trip` (
                                               `uuid` BINARY(16) NOT NULL UNIQUE,
    `reason` ENUM('business_trip', 'client_visit', 'on_site_work', 'transport_of_goods', 'training', 'service_maintenance', 'other') NOT NULL,
    `note` TEXT(500),
    `status` VARCHAR(30) NOT NULL,
    `vehicle_id` BINARY(16) NOT NULL,
    `user_id` BINARY(16) NOT NULL,
    `start_date` DATETIME NOT NULL,
    `end_date` DATETIME NOT NULL,
    `start_address` BINARY(16) NOT NULL,
    `destination_address` BINARY(16) NOT NULL,
    PRIMARY KEY(`uuid`)
    );


CREATE TABLE IF NOT EXISTS `Address` (
                                         `uuid` BINARY(16) NOT NULL,
    `street` VARCHAR(150),
    `Number` VARCHAR(20) NOT NULL,
    `City` VARCHAR(100) NOT NULL,
    `zip` VARCHAR(5) NOT NULL,
    `region` ENUM('BA', 'TT', 'TN', 'NR', 'ZA', 'BB', 'PO', 'KE') NOT NULL,
    PRIMARY KEY(`uuid`)
    );


ALTER TABLE `Vehicle_Contract`
    ADD FOREIGN KEY(`Vehicle_id`) REFERENCES `Vehicle`(`uuid`)
        ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `Vehicle_Service`
    ADD FOREIGN KEY(`vehicle_id`) REFERENCES `Vehicle`(`uuid`)
        ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `Activity_Logging`
    ADD FOREIGN KEY(`user_id`) REFERENCES `User`(`uuid`)
        ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `Business_Trip`
    ADD FOREIGN KEY(`vehicle_id`) REFERENCES `Vehicle`(`uuid`)
        ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `Business_Trip`
    ADD FOREIGN KEY(`user_id`) REFERENCES `User`(`uuid`)
        ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `Business_Trip`
    ADD FOREIGN KEY(`start_address`) REFERENCES `Address`(`uuid`)
        ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE `Business_Trip`
    ADD FOREIGN KEY(`destination_address`) REFERENCES `Address`(`uuid`)
        ON UPDATE NO ACTION ON DELETE NO ACTION;