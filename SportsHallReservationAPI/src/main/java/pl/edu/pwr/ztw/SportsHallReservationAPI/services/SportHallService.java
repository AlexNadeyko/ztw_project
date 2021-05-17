package pl.edu.pwr.ztw.SportsHallReservationAPI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwr.ztw.SportsHallReservationAPI.models.SportHall;
import pl.edu.pwr.ztw.SportsHallReservationAPI.models.User;
import pl.edu.pwr.ztw.SportsHallReservationAPI.repositories.SportHallRepository;
import pl.edu.pwr.ztw.SportsHallReservationAPI.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SportHallService implements ISportHallService{

    @Autowired
    private SportHallRepository repo;

    @Override
    public List<SportHall> getAllSportHalls() {
        return repo.findAll();
    }

    @Override
    public SportHall getSportHall(int id) {
        return repo.findById(id).get();
    }

    public void saveSportHall(SportHall sportHall)
    {
        repo.save(sportHall);
    }

    @Override
    public List<SportHall> getSportHallsByType(int id) {
        List<SportHall> listSportHalls;
        listSportHalls = repo.findAll().stream().filter(s -> s.getHallType().getTypeId() == id).collect(Collectors.toList());

        return  listSportHalls;
    }
}
