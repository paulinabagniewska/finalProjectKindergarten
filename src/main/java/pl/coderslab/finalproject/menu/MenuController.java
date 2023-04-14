package pl.coderslab.finalproject.menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.finalproject.group.Group;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private final MenuRepository menuRepository;


    public MenuController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }
    @PostMapping("/add-menu")
    @ResponseBody
    public void addGroup (Menu menu){
        menuRepository.save(menu);
    }
    @GetMapping("/update-menu")
    @ResponseBody
    public void updateMenu (Menu menu){
        menuRepository.save(menu);
    }
    @GetMapping("/delete-menu")
    @ResponseBody
    public void deleteMenu (Menu menu){
        menuRepository.delete(menu);
    }
}
