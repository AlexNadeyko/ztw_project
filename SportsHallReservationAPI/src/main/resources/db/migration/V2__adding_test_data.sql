INSERT INTO `user`(`name`,`surname`,`email`,`password`,`birth_date`)
VALUES ('Hleb', 'Liaonik', '248795@student.pwr.edu.pl', 'hleb123','2000-02-04'),
		('Aliaksandr', 'Nadzeika', '200192@student.pwr.edu.pl', 'alek123', NULL),
		('Test', 'Test', 'Test', 'Test', NULL);

INSERT INTO `hall_type`(`type`)
VALUES ('Basketball'),
		('Tennis'),
		('Football'),
		('Volleyball');

INSERT INTO `sport_hall`
(`type`,`work_from`,`work_to`,`price_one_hour`,`capacity`,`nr_hall`)
VALUES (1,'07:00','20:00',25.0,20,1),
		(2,'07:00','20:00',25.0,NULL,2),
		(3,'07:00','20:00',25.0,25,3),
		(4,'08:00','20:00',20.0,NULL,4),
		(1,'08:00','20:00',15.0,NULL,5),
		(2,'08:00','20:00',25.0,20,6);

INSERT INTO `reservation`
(`id_user`,`id_hall`,`reservation_date`,`time_from`,`time_to`,`full_price`,`is_paid`,`description`)
VALUES (2,1,'2021-05-18','11:00','13:00',45,1,NULL),
	   (3,2,'2021-05-28','09:00','10:00',25,0,NULL),
	   (1,3,'2021-05-17','08:00','09:00',30,1,NULL),
	   (2,2,'2021-05-18','11:00','13:00',45,1,NULL),
	   (2,3,'2021-05-19','11:00','13:00',45,1,NULL);