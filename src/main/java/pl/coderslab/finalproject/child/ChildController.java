package pl.coderslab.finalproject.child;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.finalproject.group.GroupDao;
import pl.coderslab.finalproject.parent.ParentDao;


@Controller
@RequestMapping("/child")
public class ChildController {
    private final ChildDao childDao;
    private final ParentDao parentDao;
    private final GroupDao groupDao;

    public ChildController(ChildDao childDao, ParentDao parentDao, GroupDao groupDao) {
        this.childDao = childDao;
        this.parentDao = parentDao;
        this.groupDao = groupDao;
    }

    @GetMapping("/add")
    public String addChild(Model model) {
        Child child = new Child();
        model.addAttribute("child", child);
        model.addAttribute("groups", groupDao.findAll());
        model.addAttribute("parents", parentDao.findAll());
        return "child/form";
    }

    @PostMapping("/save")
    public String saveChild(Child child) {
        childDao.saveChild(child);
        return "child/view";
    }
}

