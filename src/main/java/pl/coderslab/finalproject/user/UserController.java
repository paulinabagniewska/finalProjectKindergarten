package pl.coderslab.finalproject.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user/registrationForm";
    }

    @PostMapping("/add")
    public String saveUser(User user) {
        userDao.saveUser(user, Role.USER);
        return "redirect:/user/list";
    }

    @GetMapping("/list")
    public String getList(Model model) {
        List<User> userList = userDao.findAll();
        model.addAttribute("userList", userList);
        return "user/list";
    }

    @PostMapping("/login")
    public String loginUser(User user) {
        User userDatabase = userDao.findByLogin(user);
        if (userDatabase == null) {
            return "user/incorrectLogin";
        }else if (userDatabase.getRole() == Role.USER){
            return "user/userMenu";
        } else {
            return "user/adminMenu";
        }
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user/login";
    }
}
