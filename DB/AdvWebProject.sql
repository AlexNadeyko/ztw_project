
CREATE DATABASE AdvWeb;

USE AdvWeb;

CREATE TABLE HallType(
	TypeId int NOT NULL AUTO_INCREMENT,
	Type varchar(25) NOT NULL,
	PRIMARY KEY (TypeId)
);

CREATE TABLE Users(
	UserId int NOT NULL AUTO_INCREMENT,
	Name varchar(50) NOT NULL,
	Surname varchar(50) NOT NULL,
	Mail varchar(50) NOT NULL,
	Password varchar(50) NOT NULL,
	BirthDate Date,
	PRIMARY KEY (UserId)
);


CREATE TABLE SportHalls(
	HallId int NOT NULL AUTO_INCREMENT,
	Type int NOT NULL,
	WorkFrom Time NOT NULL,
	WorkTo Time NOT NULL,
	PriceOneHour decimal NOT NULL,
	Capacity int,
	NrHall int NOT NULL,
	PRIMARY KEY (HallId),
	FOREIGN KEY (Type) REFERENCES HallType(TypeId)
);


CREATE TABLE Rentals(
	RentalId int NOT NULL AUTO_INCREMENT,
	IdUser int NOT NULL,
	IdHall int NOT NULL,
	RentalDate date NOT NULL,
	TimeFrom Time NOT NULL,
	TimeTo Time NOT NULL,
	FullPrice decimal NOT NULL,
	Paid BIT NOT NULL,
	Description varchar(255),
	PRIMARY KEY (RentalId),
	FOREIGN KEY (IdUser) REFERENCES Users(UserId),
	FOREIGN KEY (IdHall) REFERENCES SportHalls(HallId)
);