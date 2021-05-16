
CREATE DATABASE AdvWeb;

CREATE TABLE HallType(
	Typeid int NOT NULL IDENTITY(1,1),
	Type varchar(25) NOT NULL,
	PRIMARY KEY (Typeid)
);

CREATE TABLE Users(
	Userid int NOT NULL IDENTITY(1,1),
	Name varchar(50) NOT NULL,
	Surname varchar(50) NOT NULL,
	Mail varchar(50) NOT NULL,
	Password varchar(50) NOT NULL,
	BirthDate Date,
	PRIMARY KEY (Userid)
);


CREATE TABLE SportHalls(
	Hallid int NOT NULL IDENTITY(1,1),
	Type int NOT NULL,
	WorkFrom Time NOT NULL,
	WorkTo Time NOT NULL,
	PriceOneHour decimal NOT NULL,
	Capacity int,
	NrHall int NOT NULL,
	PRIMARY KEY (Hallid),
	FOREIGN KEY (Type) REFERENCES HallType([Typeid])
);


CREATE TABLE Rentals(
	Rentalid int NOT NULL IDENTITY(1,1),
	IdUser int NOT NULL,
	IdHall int NOT NULL,
	RentalDate date NOT NULL,
	TimeFrom Time NOT NULL,
	TimeTo Time NOT NULL,
	FullPrice decimal NOT NULL,
	Paid BIT NOT NULL,
	Description varchar(255)
	PRIMARY KEY (Rentalid),
	FOREIGN KEY (IdUser) REFERENCES Users(Userid),
	FOREIGN KEY (IdHall) REFERENCES SportHalls(Hallid)
);