package carmencaniglia.bes5l5.dao;

import carmencaniglia.bes5l5.entities.User;
import carmencaniglia.bes5l5.exceptions.ItemNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserDAO userDAO;
    public void save(User user){
    if (user.getName().length()<2) throw new RuntimeException("the name must have more than two letters!");
    userDAO.save(user);
    log.info("User correctly saved");
    }

    public User findById(long id){
        /*Optional<User> userOptional = userDAO.findById(id);
        if (userOptional.isPresent()){
            return userOptional.get();
        }else{
            throw new ItemNotFoundException(id);
        }*/
        return userDAO.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    public List<User> findAll() {
        return userDAO.findAll();
    }

    public void deleteUser(long id) {
        userDAO.deleteById(id);
        log.info("user with id: " +id+ " successfully deleted!");
    }

    public void updateUser(long id, User user) {
        User found = this.findById(id);
        found.setUsername(user.getUsername());
        found.setName(user.getName());
        found.setSurname(user.getSurname());
        found.setEmail(user.getEmail());
        userDAO.save(found);
        log.info("User with id " + id + " successfully updated!");
    }

    public long count() {
        return userDAO.count();
    }

}
