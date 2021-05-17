CREATE DATABASE AdvWeb;

USE AdvWeb;

CREATE TABLE HallType(
	type_id int NOT NULL AUTO_INCREMENT,
	type varchar(25) NOT NULL,
	PRIMARY KEY (type_id)
);

CREATE TABLE Users(
	user_id int NOT NULL AUTO_INCREMENT,
	name varchar(50) NOT NULL,
	surname varchar(50) NOT NULL,
	email varchar(50) NOT NULL,
	password varchar(50) NOT NULL,
	birth_date Date,
	PRIMARY KEY (user_id)
);


CREATE TABLE SportHalls(
	hall_id int NOT NULL AUTO_INCREMENT,
	type int NOT NULL,
	work_from Time NOT NULL,
	work_to Time NOT NULL,
	price_one_hour decimal NOT NULL,
	capacity int,
	nr_hall int NOT NULL,
	PRIMARY KEY (hall_id),
	FOREIGN KEY (type) REFERENCES HallType(type_id)
);


CREATE TABLE Rentals(
	rental_id int NOT NULL AUTO_INCREMENT,
	id_user int NOT NULL,
	id_hall int NOT NULL,
	rental_date date NOT NULL,
	time_from Time NOT NULL,
	time_to Time NOT NULL,
	full_price decimal NOT NULL,
	is_paid BIT NOT NULL,
	description varchar(255),
	PRIMARY KEY (rental_id),
	FOREIGN KEY (id_user) REFERENCES Users(user_id), 
	FOREIGN KEY (id_hall) REFERENCES SportHalls(hall_id)
);