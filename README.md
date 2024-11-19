# Springboot

Overview
This is a simple user management system implemented using Spring Boot, MyBatis, and MySQL. The project includes features for creating, updating, deleting, and retrieving user information.

Key Components
# DemoApplication.java
This is the main class of the Spring Boot application that contains the main method. It starts the Spring Boot application by calling the SpringApplication.run method. The @SpringBootApplication annotation enables auto-configuration, component scanning, and Spring Bean initialization.

# UserController.java
The controller class for user management. It defines methods for adding, deleting, updating, and retrieving users by invoking the corresponding operations in the UserService.

# UserService.java
This is the service interface that defines business operations related to user management. The methods in this interface are implemented by the UserServiceImpl class.

# UserServiceImpl.java
The implementation class of the UserService interface. It performs the CRUD operations by interacting with the UserDao.

# UserDao.java
The data access object (DAO) responsible for interacting with the database. It uses methods defined in the UserMapper interface with MyBatis annotations to execute SQL operations.

# UserMapper.java
The MyBatis mapper interface where SQL queries for user management are defined using annotations. Each method corresponds to a SQL statement for inserting, deleting, updating, or querying user information.

# User.java
The user model class that defines the properties of a user (e.g., ID, username, gender, age, etc.). It also includes the necessary getter, setter, and other basic methods.

# application.properties
The configuration file for the Spring Boot application. It contains database connection settings and MyBatis configurations.

# pom.xml
The Maven configuration file that defines the project dependencies and build plugins. Key dependencies include Spring Boot, MyBatis, MySQL Connector, JUnit 5, and Mockito for testing.

# Database Setup
The following SQL script is used to create and configure the database table. It has already been imported into the local environment:

# sql
CREATE DATABASE db1;
USE db1;
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT 'Primary Key',
    username VARCHAR(50) NOT NULL COMMENT 'Username',
    gender TINYINT(1) NOT NULL COMMENT 'Gender',
    age INT NOT NULL COMMENT 'Age',
    create_user VARCHAR(40) NOT NULL COMMENT 'Creator Identifier',
    create_user_name VARCHAR(128) NOT NULL COMMENT 'Creator Name',
    create_time DATETIME NOT NULL COMMENT 'Creation Time',
    update_user VARCHAR(40) NOT NULL COMMENT 'Last Updater Identifier',
    update_user_name VARCHAR(128) NOT NULL COMMENT 'Last Updater Name',
    update_time DATETIME NOT NULL COMMENT 'Last Update Time',
    is_delete TINYINT(1) DEFAULT 0 NOT NULL COMMENT 'Delete Flag: 0 - Not Deleted, 1 - Deleted'
);
