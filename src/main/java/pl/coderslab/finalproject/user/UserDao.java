package pl.coderslab.finalproject.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class UserDao {

    @PersistenceContext
    EntityManager entityManager;

    private UserRepository userRepository;

    @Autowired

    public UserDao(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User newUser) {
        Cipher cipher = new Cipher();
        newUser.setPassword(cipher.encrypt(newUser.getPassword()));
        return userRepository.save(newUser);
    }

    public User findByLogin(User user) {
        User userDatabase = userRepository.findByLogin(user.getLogin());
        Cipher cipher = new Cipher();
        userDatabase.setPassword(cipher.decrypt(userDatabase.getPassword()));
        if (user.getPassword().equals(userDatabase.getPassword())){
            return userDatabase;
        }else{
            return null;
        }
    }

    public void deleteUser(User user) {

        userRepository.deleteById(user.getId());
    }

    public void delete(Long id) {

        userRepository.deleteById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void update(User newUser) {
        userRepository.save(newUser);
    }

}
