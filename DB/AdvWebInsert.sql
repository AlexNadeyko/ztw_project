USE AdvWeb;

INSERT INTO Users(name,surname,email,password,birth_date)
VALUES ('Hleb', 'Liaonik', '248795@student.pwr.edu.pl', 'hleb123','2000-02-04'),
		('Aliaksandr', 'Nadzeika', 'xxxxxx@student.pwr.edu.pl', 'alek123', NULL),
		('Test', 'Test', 'Test', 'Test', NULL);

INSERT INTO HallType(type)
VALUES ('Basketball'),
		('Tennis'),
		('Baseball'),
		('Golf'),
		('Volleyball');

INSERT INTO SportHalls(type,work_from,work_to,price_one_hour,capacity,nr_hall)
VALUES (2,'07:00','20:00',25.0,20,3),
		(2,'07:00','20:00',25.0,NULL,4),
		(2,'07:00','20:00',25.0,25,5),
		(3,'08:00','20:00',20.0,NULL,3),
		(1,'08:00','20:00',15.0,NULL,3),
		(4,'08:00','20:00',25.0,20,3);

INSERT INTO Rentals(id_user,id_hall,rental_date,time_from,time_to,full_price,is_paid,description)
VALUES (2,1,'2021-05-18','11:00','13:00',45,1,NULL),
	   (3,2,'2021-05-28','09:00','10:00',25,0,NULL),
	   (1,3,'2021-05-17','08:00','09:00',30,1,NULL),
	   (2,2,'2021-05-18','11:00','13:00',45,1,NULL),
	   (2,3,'2021-05-19','11:00','13:00',45,1,NULL);