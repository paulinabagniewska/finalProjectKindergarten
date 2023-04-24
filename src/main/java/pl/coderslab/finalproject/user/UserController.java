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
        userDao.saveUser(user);
        return "redirect:/user/list";
    }

    @GetMapping("/list")
    public String getList(Model model) {
        List<User> userList = userDao.findAll();
        model.addAttribute("userList", userList);
        return "user/list";
    }
    @PostMapping("/login")
    public String loginUser(User user){
        User userDatabase = userDao.findByLogin(user);
        if(userDatabase == null){
            return "incorrectLogin";
        }else{
            return "userMenu";
        }
    }

    /*    @RequestMapping("delete/{id}")
        public String deleteUser(@PathVariable String login) {
            User user = userDao.findByLogin(login);
            userDao.delete(login);
            return "redirect:/user/list";
        }*/
/*    @PostMapping("/delete")
    public String deleteUser(User user) {
        userDao.deleteUser(user);
        return "user/list";
    }*/

/*    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable String login, Model model) {
        User user = userDao.findByLogin(login);
        model.addAttribute("user", user);

        return "user/editForm";
    }

    @PostMapping("/update")
    public String updatedUser(@ModelAttribute User user, Model model) {
        userDao.saveUser(user);
        List<User> userList = userDao.findAll();
        model.addAttribute("userList", userList);
        return "user/list";
    }*/
}
