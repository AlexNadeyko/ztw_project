CREATE TABLE IF NOT EXISTS `hall_type` (
  `type_id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(25) NOT NULL,
  PRIMARY KEY (`type_id`)
);

CREATE TABLE IF NOT EXISTS `sport_hall` (
  `hall_id` int NOT NULL AUTO_INCREMENT,
  `type` int NOT NULL,
  `work_from` time NOT NULL,
  `work_to` time NOT NULL,
  `price_one_hour` decimal(10,0) NOT NULL,
  `capacity` int DEFAULT NULL,
  `nr_hall` int NOT NULL,
  PRIMARY KEY (`hall_id`),
  KEY `type` (`type`),
  CONSTRAINT `sport_hall_ibfk_1` FOREIGN KEY (`type`) REFERENCES `hall_type` (`type_id`)
);

CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `birth_date` date DEFAULT NULL,
  PRIMARY KEY (`user_id`)
);

CREATE TABLE IF NOT EXISTS `reservation` (
  `reservation_id` int NOT NULL AUTO_INCREMENT,
  `id_user` int NOT NULL,
  `id_hall` int NOT NULL,
  `reservation_date` date NOT NULL,
  `time_from` time NOT NULL,
  `time_to` time NOT NULL,
  `full_price` decimal(10,0) NOT NULL,
  `is_paid` bit(1) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`reservation_id`),
  KEY `id_user` (`id_user`),
  KEY `id_hall` (`id_hall`),
  CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`user_id`),
  CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`id_hall`) REFERENCES `sport_hall` (`hall_id`)
);




