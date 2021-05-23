package pl.edu.pwr.ztw.SportsHallReservationAPI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwr.ztw.SportsHallReservationAPI.models.Reservation;
import pl.edu.pwr.ztw.SportsHallReservationAPI.repositories.ReservationRepository;
import pl.edu.pwr.ztw.SportsHallReservationAPI.repositories.SportHallRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReservationService implements IReservationService{

    @Autowired
    private ReservationRepository repo;


    @Override
    public List<Reservation> getAllReservations() {
        return repo.findAll();
    }

    @Override
    public Reservation getReservation(int id) {
        return repo.findById(id).get();
    }

    @Override
    public void saveReservation(Reservation reservation) {
        repo.save(reservation);
    }

    @Override
    public void deleteReservation(int id) {
        repo.deleteById(id);
    }




}
