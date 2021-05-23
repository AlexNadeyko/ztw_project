USE AdvWeb;

ALTER TABLE rentals RENAME TO reservation;
ALTER TABLE halltype RENAME TO hall_type;
ALTER TABLE sporthalls RENAME TO sport_hall;
ALTER TABLE users RENAME TO user;