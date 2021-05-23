package pl.edu.pwr.ztw.SportsHallReservationAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pwr.ztw.SportsHallReservationAPI.services.IHallTypeService;
import pl.edu.pwr.ztw.SportsHallReservationAPI.services.ISportHallService;

@RestController
public class HallTypeController {

    @Autowired
    private IHallTypeService hallTypeService;

    @RequestMapping(value="/get/hall_types", method= RequestMethod.GET)
    public ResponseEntity<Object> getHallTypes(){
        return new ResponseEntity<>(hallTypeService.getAllHallTypes(), HttpStatus.OK);
    }

}
