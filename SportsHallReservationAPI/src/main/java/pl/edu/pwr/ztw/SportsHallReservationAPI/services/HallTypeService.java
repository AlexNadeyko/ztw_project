package pl.edu.pwr.ztw.SportsHallReservationAPI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwr.ztw.SportsHallReservationAPI.models.HallType;
import pl.edu.pwr.ztw.SportsHallReservationAPI.repositories.HallTypeRepository;
import pl.edu.pwr.ztw.SportsHallReservationAPI.repositories.SportHallRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class HallTypeService implements IHallTypeService{

    @Autowired
    private HallTypeRepository repo;

    @Override
    public List<HallType> getAllHallTypes() {
        return repo.findAll();
    }
}
