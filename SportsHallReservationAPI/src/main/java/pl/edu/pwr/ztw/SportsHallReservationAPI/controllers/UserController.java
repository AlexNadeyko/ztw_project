package pl.edu.pwr.ztw.SportsHallReservationAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pwr.ztw.SportsHallReservationAPI.models.User;
import pl.edu.pwr.ztw.SportsHallReservationAPI.services.IUserService;
import pl.edu.pwr.ztw.SportsHallReservationAPI.services.UserService;

import java.util.NoSuchElementException;

@RestController
public class UserController {
    @Autowired
    private IUserService usersService;

    @RequestMapping(value="/get/users", method= RequestMethod.GET)
    public ResponseEntity<Object> getUsers(){
        return new ResponseEntity<>(usersService.getAllUsers(), HttpStatus.OK);
    }

    @RequestMapping(value="/create/user", method=RequestMethod.POST)
    public ResponseEntity<Object> createUser(@RequestBody User user){
        usersService.saveUser(user);
        return new ResponseEntity<>("User was created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value="/update/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateUser(@PathVariable("id") int id, @RequestBody User user){
        try{
            User existUser = usersService.getUser(id);

            /*boolean isEmailExist = usersService.getAllUsers().stream().anyMatch(u->u.getEmail().equals(user.getEmail()));
            if (isEmailExist)
            {
                return new ResponseEntity<>("This email address is already in use", HttpStatus.BAD_REQUEST);
            }*/

            user.setId(id);
            usersService.saveUser(user);

            return new ResponseEntity<>("User was updated successfully", HttpStatus.OK);

        }catch(NoSuchElementException ex) {
            return new ResponseEntity<>("This user was not found", HttpStatus.NOT_FOUND);
        }
    }
}
