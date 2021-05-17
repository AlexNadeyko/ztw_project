package pl.edu.pwr.ztw.SportsHallReservationAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pwr.ztw.SportsHallReservationAPI.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
