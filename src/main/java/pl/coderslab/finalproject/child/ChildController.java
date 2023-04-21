package pl.coderslab.finalproject.child;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.announcement.Announcement;
import pl.coderslab.finalproject.group.GroupDao;
import pl.coderslab.finalproject.parent.ParentDao;

import java.util.List;


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

    @PostMapping("/add")
    public String saveChild(Child child) {
        childDao.saveChild(child);
        return "redirect:/child/list";
    }
    @PostMapping("/delete")
    public String deleteChild(Child child) {
        childDao.deleteChild(child);
        return "child/list";
    }


   @GetMapping("/list")
    public String getList(Model model) {
        List<Child> children = childDao.findAll();
        model.addAttribute("children", children);
        return "child/list";
    }


    @PostMapping("delete/{id}")
    public String deleteChild(@PathVariable Long id, Model model) {
        childDao.delete(id);
        List<Child> children = childDao.findAll();
        model.addAttribute("children", children);
        return "child/list";
    }

   @GetMapping("/update/{id}")
    public String updateChild(@PathVariable Long id, Model model) {
        Child child = childDao.findById(id);
        model.addAttribute("child", child);
        model.addAttribute("groups", groupDao.findAll());
        model.addAttribute("parents", parentDao.findAll());
        return "child/editForm";
    }
    @PostMapping ("/update")
    public String updatedChild(@ModelAttribute Child child, Model model){
        childDao.saveChild(child);
        List <Child> children = childDao.findAll();
        model.addAttribute("children", children);
        return "child/list";
    }
}

