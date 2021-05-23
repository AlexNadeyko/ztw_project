USE AdvWeb;

ALTER TABLE rentals RENAME TO reservation;
ALTER TABLE halltype RENAME TO hall_type;
ALTER TABLE sporthalls RENAME TO sport_hall;
ALTER TABLE users RENAME TO user;

ALTER TABLE reservation 
RENAME COLUMN rental_id TO reservation_id;
ALTER TABLE reservation 
RENAME COLUMN rental_date TO reservation_date;