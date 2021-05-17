package pl.edu.pwr.ztw.SportsHallReservationAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.ztw.SportsHallReservationAPI.models.SportHall;
import pl.edu.pwr.ztw.SportsHallReservationAPI.models.User;
import pl.edu.pwr.ztw.SportsHallReservationAPI.services.ISportHallService;
import pl.edu.pwr.ztw.SportsHallReservationAPI.services.IUserService;

import java.util.NoSuchElementException;

@RestController
public class SportHallController {

    @Autowired
    private ISportHallService sportHallsService;

    @RequestMapping(value="/get/halls", method= RequestMethod.GET)
    public ResponseEntity<Object> getHalls(){
        return new ResponseEntity<>(sportHallsService.getAllSportHalls(), HttpStatus.OK);
    }

    @RequestMapping(value="/get/hall/{id}", method = RequestMethod.GET)
    public ResponseEntity<SportHall> getSportHall(@PathVariable ("id") int id){
        try{
            SportHall sportHall = sportHallsService.getSportHall(id);
            return new ResponseEntity<SportHall>(sportHall, HttpStatus.OK);
        }catch (NoSuchElementException ex){
            return new ResponseEntity<SportHall>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/update/hall/{id}", method= RequestMethod.PUT)
    public ResponseEntity<Object> updateHall(@PathVariable("id") int id, @RequestBody SportHall sportHall){
        try{
            SportHall existSportHall = sportHallsService.getSportHall(id);
            sportHall.setId(id);
            sportHallsService.saveSportHall(sportHall);

            return new ResponseEntity<>("Sport hall was updated successfully", HttpStatus.OK);

        }catch(NoSuchElementException ex) {
            return new ResponseEntity<>("This sport hall was not found", HttpStatus.NOT_FOUND);
        }
    }

}
