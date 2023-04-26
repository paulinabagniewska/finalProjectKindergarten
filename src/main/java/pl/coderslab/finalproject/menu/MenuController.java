package pl.coderslab.finalproject.menu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.user.Role;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {
    private final MenuDao menuDao;

    public MenuController(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    @GetMapping("/add")
    public String addMenu(Model model, HttpSession session) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            Menu menu = new Menu();
            menu.setDate(LocalDate.now());
            model.addAttribute("menu", menu);
            return "menu/form";
        } else {
            return "user/noAccess";
        }
    }

    @PostMapping("/add")
    public String saveMenu(Menu menu) {
        menuDao.saveMenu(menu);
        return "redirect:/menu/list";
    }

    @PostMapping("/delete")
    public String deleteMenu(Menu menu) {
        menuDao.deleteMenu(menu);
        return "menu/list";
    }

    @GetMapping("/list")
    public String getList(Model model, HttpSession session) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            List<Menu> menuList = menuDao.findAll();
            model.addAttribute("menuList", menuList);
            return "menu/list";
        } else {
            return "user/noAccess";
        }

    }


    @GetMapping("/userList")
    public String getUserList(Model model, HttpSession session) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.USER)) {
            List<Menu> menuList = menuDao.findAll();
            model.addAttribute("menuList", menuList);
            return "menu/userList";
        } else {
            return "user/noAccess";
        }
    }

    @RequestMapping("delete/{id}")
    public String deleteMenu(@PathVariable Long id, HttpSession session) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            Menu menu = menuDao.findById(id);
            menuDao.delete(id);
            return "redirect:/menu/list";
        } else {
            return "user/noAccess";
        }
    }

    @GetMapping("/update/{id}")
    public String updateMenu(@PathVariable Long id, Model model, HttpSession session) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            Menu menu = menuDao.findById(id);
            model.addAttribute("menu", menu);
            return "menu/editForm";
        } else {
            return "user/noAccess";
        }
    }

    @PostMapping("/update")
    public String updatedMenu(@ModelAttribute Menu menu, Model model, HttpSession session) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            menuDao.saveMenu(menu);
            List<Menu> menuList = menuDao.findAll();
            model.addAttribute("menuList", menuList);
            return "menu/list";
        } else {
            return "user/noAccess";
        }
    }
}
