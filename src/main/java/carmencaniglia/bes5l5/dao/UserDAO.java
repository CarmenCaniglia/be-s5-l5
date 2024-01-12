package carmencaniglia.bes5l5.dao;

import carmencaniglia.bes5l5.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    List<User> findByUsername(String username);

    List<User> findBySurname(String surname);

    List<User> findByEmailContaining(String ex);

    List<User> findByNameAndSurname(String name, String surname);
    //@Query("SELECT u FROM User u WHERE u.name = ?1 AND u.surname = ?2")

    boolean existsByEmail(String email);
}
