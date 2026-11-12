-- ==============================================================================
-- NexsussAPI Library Management System (LMS)
-- Database Initialization & Schema Script
-- Target Database: MySQL 8.0+
-- Author: R A Savindu Geethma
-- ==============================================================================

CREATE DATABASE IF NOT EXISTS `api_nexsuss`
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_unicode_ci;

USE `api_nexsuss`;

-- ------------------------------------------------------------------------------
-- Table: status (User and Member Account Statuses)
-- ------------------------------------------------------------------------------
DROP TABLE IF EXISTS `status`;
CREATE TABLE `status` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `status` (`id`, `name`) VALUES
(1, 'Active'),
(2, 'Suspended');

-- ------------------------------------------------------------------------------
-- Table: borrow_status (Lending Lifecycle Statuses)
-- ------------------------------------------------------------------------------
DROP TABLE IF EXISTS `borrow_status`;
CREATE TABLE `borrow_status` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `borrow_status` (`id`, `status`) VALUES
(0, 'Borrowed'),
(1, 'Returned'),
(2, 'Overdue');

-- ------------------------------------------------------------------------------
-- Table: category (Book Classifications)
-- ------------------------------------------------------------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'Fiction'),
(2, 'Non-fiction'),
(3, 'Science & Technology'),
(4, 'History'),
(5, 'Biography & Autobiography'),
(6, 'Children''s Books'),
(7, 'Religious & Philosophy'),
(8, 'Education & Textbooks'),
(9, 'Art & Literature'),
(10, 'Health & Wellness');

-- ------------------------------------------------------------------------------
-- Table: admin (System Administrators & Staff)
-- ------------------------------------------------------------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL UNIQUE,
  `mobile` VARCHAR(20) NOT NULL,
  `gender` INT DEFAULT 1,
  `NIC` VARCHAR(20) DEFAULT NULL,
  `password` VARCHAR(255) NOT NULL,
  `address` VARCHAR(255) DEFAULT NULL,
  `status_id` INT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_admin_status` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Default Administrator Account
INSERT INTO `admin` (`id`, `name`, `email`, `mobile`, `gender`, `NIC`, `password`, `address`, `status_id`) VALUES
(1, 'System Administrator', 'admin@nexsuss.com', '0771234567', 1, '200012345678', 'Admin@123', 'Colombo, Sri Lanka', 1);

-- ------------------------------------------------------------------------------
-- Table: members (Library Patrons)
-- ------------------------------------------------------------------------------
DROP TABLE IF EXISTS `members`;
CREATE TABLE `members` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Full_Name` VARCHAR(150) NOT NULL,
  `phone_number` VARCHAR(20) NOT NULL,
  `Age` INT DEFAULT NULL,
  `gender` VARCHAR(20) DEFAULT NULL,
  `Address` VARCHAR(255) DEFAULT NULL,
  `membership_date` DATE NOT NULL,
  `status_id` INT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_member_status` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `members` (`id`, `Full_Name`, `phone_number`, `Age`, `gender`, `Address`, `membership_date`, `status_id`) VALUES
(1, 'Kasun Perera', '0712345678', 24, 'Male', 'Kandy Road, Kiribathgoda', '2026-01-15', 1),
(2, 'Nimali Silva', '0769876543', 22, 'Female', 'Galle Road, Moratuwa', '2026-02-10', 1);

-- ------------------------------------------------------------------------------
-- Table: books (Library Catalog & Inventory)
-- ------------------------------------------------------------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(200) NOT NULL,
  `Author` VARCHAR(150) NOT NULL,
  `Category_id` INT DEFAULT NULL,
  `Category` VARCHAR(100) DEFAULT NULL,
  `Copies` INT NOT NULL DEFAULT 1,
  `Available_books` INT NOT NULL DEFAULT 1,
  `Barcode` VARCHAR(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_book_category` FOREIGN KEY (`Category_id`) REFERENCES `category` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `books` (`id`, `Name`, `Author`, `Category_id`, `Category`, `Copies`, `Available_books`, `Barcode`) VALUES
(1, 'Clean Code: A Handbook of Agile Software Craftsmanship', 'Robert C. Martin', 3, 'Science & Technology', 5, 5, '9780132350884'),
(2, 'Design Patterns: Elements of Reusable Object-Oriented Software', 'Erich Gamma et al.', 3, 'Science & Technology', 3, 3, '9780201633610'),
(3, 'Introduction to Algorithms (CLRS)', 'Thomas H. Cormen', 8, 'Education & Textbooks', 4, 4, '9780262033848'),
(4, 'Sapiens: A Brief History of Humankind', 'Yuval Noah Harari', 4, 'History', 6, 6, '9780062316097');

-- ------------------------------------------------------------------------------
-- Table: issue_and_returns (Circulation & Transaction Tracking)
-- ------------------------------------------------------------------------------
DROP TABLE IF EXISTS `issue_and_returns`;
CREATE TABLE `issue_and_returns` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Books_id` INT NOT NULL,
  `Members_id` INT NOT NULL,
  `borrow_status_id` INT NOT NULL DEFAULT 0,
  `borrow_date` DATE NOT NULL,
  `Recieving_date` DATE DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_ir_book` FOREIGN KEY (`Books_id`) REFERENCES `books` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_ir_member` FOREIGN KEY (`Members_id`) REFERENCES `members` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_ir_status` FOREIGN KEY (`borrow_status_id`) REFERENCES `borrow_status` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `issue_and_returns` (`id`, `Books_id`, `Members_id`, `borrow_status_id`, `borrow_date`, `Recieving_date`) VALUES
(1, 1, 1, 0, '2026-11-01', NULL),
(2, 2, 2, 1, '2026-10-15', '2026-10-25');
