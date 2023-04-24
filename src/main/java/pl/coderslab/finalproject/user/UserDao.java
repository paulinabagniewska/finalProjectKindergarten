package pl.coderslab.finalproject.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.finalproject.parent.Parent;

import javax.annotation.PostConstruct;
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

    @PostConstruct
    public void addAdmin(){
        if(userRepository.findByLogin("admin") == null){
            User admin = new User();
            admin.setLogin("admin");
            admin.setPassword("koniczynka");

            saveUser(admin, Role.ADMIN);
        }
    }

    public User saveUser(User newUser, Role role) {
        Cipher cipher = new Cipher();
        newUser.setPassword(cipher.encrypt(newUser.getPassword()));
        newUser.setRole(role);
        return userRepository.save(newUser);
    }

    public User findByLogin(User user) {
        User userDatabase = userRepository.findByLogin(user.getLogin());
        if (userDatabase == null) {
            return null;
        } else {
            Cipher cipher = new Cipher();
            userDatabase.setPassword(cipher.decrypt(userDatabase.getPassword()));
            if (user.getPassword().equals(userDatabase.getPassword())) {
                return userDatabase;
            } else {
                return null;
            }
        }
    }
    public List<User> findAll() {
        return userRepository.findAll();
    }

}
