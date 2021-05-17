package pl.edu.pwr.ztw.SportsHallReservationAPI.services;

import pl.edu.pwr.ztw.SportsHallReservationAPI.models.User;

import java.util.List;

public interface IUserService {

    public void saveUser(User user);
    public User getUser(int id);
    public List<User> getAllUsers();

}
