package pl.coderslab.finalproject.menu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.finalproject.absence.Absence;
import pl.coderslab.finalproject.announcement.Announcement;
import pl.coderslab.finalproject.child.Child;

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
    public String addMenu(Model model) {
        Menu menu = new Menu();
        menu.setDate(LocalDate.now());
        model.addAttribute("menu", menu);
        return "menu/form";
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
    public String getList(Model model) {
        List<Menu> menuList = menuDao.findAll();
        model.addAttribute("menuList", menuList);
        return "menu/list";
    }
    @GetMapping("/userList")
    public String getUserList(Model model) {
        List<Menu> menuList = menuDao.findAll();
        model.addAttribute("menuList", menuList);

        return "menu/userList";
    }
    @RequestMapping("delete/{id}")
    public String deleteMenu(@PathVariable Long id) {
        Menu menu = menuDao.findById(id);
        menuDao.delete(id);
        return "redirect:/menu/list";
    }

    @GetMapping("/update/{id}")
    public String updateMenu(@PathVariable Long id, Model model) {
        Menu menu = menuDao.findById(id);
        model.addAttribute("menu", menu);

        return "menu/editForm";
    }

    @PostMapping("/update")
    public String updatedMenu(@ModelAttribute Menu menu, Model model) {
        menuDao.saveMenu(menu);
        List<Menu> menuList = menuDao.findAll();
        model.addAttribute("menuList", menuList);
        return "menu/list";
    }
}
