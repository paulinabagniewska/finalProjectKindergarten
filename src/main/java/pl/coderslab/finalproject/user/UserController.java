package pl.coderslab.finalproject.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
        return "user/registrationSuccessful";
    }

    @GetMapping("/list")
    public String getList(Model model, HttpSession session) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            List<User> userList = userDao.findAll();
            model.addAttribute("userList", userList);
            return "user/list";
        } else {
            return "user/noAccess";
        }
    }

    @PostMapping("/login")
    public String loginUser(User user, HttpSession session, HttpServletRequest request) {
        session.invalidate();
        HttpSession newSession = request.getSession();
        User userDatabase = userDao.findByLogin(user);
        if (userDatabase == null) {
            return "user/incorrectLogin";
        } else if (userDatabase.getRole() == Role.USER) {
            newSession.setAttribute("role", Role.USER);
            return "user/userMenu";
        } else {
            newSession.setAttribute("role", Role.ADMIN);
            return "user/adminMenu";
        }

    }

    @GetMapping("/loggedIn")
    public String showMainMenu(HttpSession session, Model model) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            return "user/adminMenu";
        } else if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.USER)) {
            return "user/userMenu";
        }else {
            return "user/incorrectLogin";
        }
    }

    @GetMapping("/logoutUser")
    public String logoutUser(Model model, HttpSession session) {
        session.invalidate();
        return showLoginForm(model);
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user/login";
    }
}
