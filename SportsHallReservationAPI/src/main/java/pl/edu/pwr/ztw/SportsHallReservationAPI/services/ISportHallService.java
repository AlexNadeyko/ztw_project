package pl.edu.pwr.ztw.SportsHallReservationAPI.services;

import pl.edu.pwr.ztw.SportsHallReservationAPI.models.SportHall;
import pl.edu.pwr.ztw.SportsHallReservationAPI.models.User;

import java.util.List;

public interface ISportHallService {
    public List<SportHall> getAllSportHalls();
    public SportHall getSportHall(int id);
    public void saveSportHall(SportHall sportHall);
    public List<SportHall> getSportHallsByType(int id);

}
