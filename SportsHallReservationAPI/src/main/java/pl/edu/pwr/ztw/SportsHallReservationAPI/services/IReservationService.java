package pl.edu.pwr.ztw.SportsHallReservationAPI.services;

import pl.edu.pwr.ztw.SportsHallReservationAPI.models.Reservation;
import pl.edu.pwr.ztw.SportsHallReservationAPI.models.SportHall;

import java.util.List;

public interface IReservationService {
    public List<Reservation> getAllReservations();
    public Reservation getReservation(int id);
    public void saveReservation(Reservation reservation);
    public void deleteReservation(int id);

}
