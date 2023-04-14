package pl.coderslab.finalproject.menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private final MenuDao menuDao;


    public MenuController(MenuDao menuDao) {
        this.menuDao = menuDao;
    }
}
