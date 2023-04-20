package pl.coderslab.finalproject.menu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private final MenuDao menuDao;


    public MenuController(MenuDao menuDao) {
        this.menuDao = menuDao;
    }
    @GetMapping("/add")
    public String addMenu (Model model) {
      Menu menu = new Menu();
        model.addAttribute("menu", menu);
        return "menu/form";
    }
    @PostMapping("/add")
    public String saveMenu (Menu menu) {
        menuDao.saveMenu(menu);
        return "redirect:/menu/list";
    }
    @PostMapping("/delete")
    public String deleteMenu(Menu menu) {
        menuDao.deleteMenu(menu);
        return "menu/list";
    }
    @GetMapping("/list")
    public String getList( Model model){
        List<Menu> menuList = menuDao.findAll();
        model.addAttribute("menuList ", menuList );
        return  "menu/list";
    }
    @PostMapping("delete/{id}")
    public  String deleteMenu(@PathVariable Long id, Model model){
        menuDao.delete(id);
        List<Menu> menuList  = menuDao.findAll();
        model.addAttribute("menuList ", menuList );
        return "menu/list";
    }
    @PostMapping ("/update")
    public String updateMenu(@RequestBody Menu menu, Model model){
        menuDao.saveMenu(menu);
        List <Menu> menuList  = menuDao.findAll();
        model.addAttribute("menuList", menuList );
        return "menu/list";
    }
}
