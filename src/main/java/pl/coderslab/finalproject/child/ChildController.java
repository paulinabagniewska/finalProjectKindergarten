package pl.coderslab.finalproject.child;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.finalproject.announcement.Announcement;


@Controller
@RequestMapping("/child")
public class ChildController {

    private final ChildDao childDao;

    public ChildController(ChildDao childDao) {
        this.childDao = childDao;
    }
    @GetMapping("/add")
    public String addChild(Model model) {
        Child child = new Child();
        model.addAttribute("child", child);
        return "child/form";
    }
    @PostMapping("/save")
    public String saveChild(Child child) {
       childDao.saveChild(child);
        return "child/view";
    }
    //@ModelAttribute
    // tablica z nazwami tych grup jak na zajęciach
}

