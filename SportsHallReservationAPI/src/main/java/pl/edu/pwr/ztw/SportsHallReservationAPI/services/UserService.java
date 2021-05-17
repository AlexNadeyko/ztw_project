package pl.edu.pwr.ztw.SportsHallReservationAPI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pwr.ztw.SportsHallReservationAPI.exceptions.EmailAddressAlreadyInUseException;
import pl.edu.pwr.ztw.SportsHallReservationAPI.models.User;
import pl.edu.pwr.ztw.SportsHallReservationAPI.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService implements IUserService{

    @Autowired
    private UserRepository repo;

    public void saveUser(User user)
    {
        repo.save(user);
    }

    @Override
    public User getUser(int id) {
        return repo.findById(id).get();
    }

    @Override
    public List<User> getAllUsers() {
        return repo.findAll();
    }

}
