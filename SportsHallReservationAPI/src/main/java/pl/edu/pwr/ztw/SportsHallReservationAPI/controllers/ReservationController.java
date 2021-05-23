package pl.edu.pwr.ztw.SportsHallReservationAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.ztw.SportsHallReservationAPI.models.Reservation;
import pl.edu.pwr.ztw.SportsHallReservationAPI.models.SportHall;
import pl.edu.pwr.ztw.SportsHallReservationAPI.models.User;
import pl.edu.pwr.ztw.SportsHallReservationAPI.services.IReservationService;
import pl.edu.pwr.ztw.SportsHallReservationAPI.services.ISportHallService;

import java.util.NoSuchElementException;

@RestController
public class ReservationController {

    @Autowired
    private IReservationService reservationService;

    @RequestMapping(value="/get/reservations", method= RequestMethod.GET)
    public ResponseEntity<Object> getReservations(){
        return new ResponseEntity<>(reservationService.getAllReservations(), HttpStatus.OK);
    }

    @RequestMapping(value="/get/reservation/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getReservation(@PathVariable ("id") int id){
        try{
            Reservation reservation = reservationService.getReservation(id);
            return new ResponseEntity<>(reservation, HttpStatus.OK);
        }catch (NoSuchElementException ex){
            return new ResponseEntity<>("This reservation was not found", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/create/reservation", method=RequestMethod.POST)
    public ResponseEntity<Object> createReservation(@RequestBody Reservation reservation){
        reservationService.saveReservation(reservation);
        return new ResponseEntity<>("Reservation was created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value="/update/reservation/{id}", method= RequestMethod.PUT)
    public ResponseEntity<Object> updateReservation(@PathVariable("id") int id, @RequestBody Reservation reservation){
        try{
            Reservation existReservation = reservationService.getReservation(id);

            reservation.setId(id);
            reservationService.saveReservation(reservation);

            return new ResponseEntity<>("Reservation was updated successfully", HttpStatus.OK);

        }catch(NoSuchElementException ex) {
            return new ResponseEntity<>("This reservation was not found", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/delete/reservation/{id}", method= RequestMethod.DELETE)
    public ResponseEntity<Object> deleteReservation(@PathVariable("id") int id) {

        try{
            reservationService.getReservation(id);

            reservationService.deleteReservation(id);

            return new ResponseEntity<>("Reservation was deleted successfully", HttpStatus.OK);

        }catch(NoSuchElementException ex) {
            return new ResponseEntity<>("This reservation was not found", HttpStatus.NOT_FOUND);
        }

    }


}
