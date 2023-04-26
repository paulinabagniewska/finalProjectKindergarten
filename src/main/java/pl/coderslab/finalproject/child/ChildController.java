package pl.coderslab.finalproject.child;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.announcement.Announcement;
import pl.coderslab.finalproject.group.GroupDao;
import pl.coderslab.finalproject.parent.Parent;
import pl.coderslab.finalproject.parent.ParentDao;
import pl.coderslab.finalproject.user.Role;

import javax.servlet.http.HttpSession;
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
    public String addChild(Model model, HttpSession session) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            Child child = new Child();
            model.addAttribute("child", child);
            model.addAttribute("groups", groupDao.findAll());
            model.addAttribute("parents", parentDao.findAll());
            return "child/form";
        } else {
            return "user/noAccess";
        }
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
    public String getList(Model model, HttpSession session) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            List<Child> children = childDao.findAll();
            model.addAttribute("children", children);
            return "child/list";
        } else {
            return "user/noAccess";
        }
    }

    @RequestMapping("delete/{id}")
    public String deleteChild(@PathVariable Long id, HttpSession session) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            Child child = childDao.findById(id);
            childDao.delete(id);
            return "redirect:/child/list";
        } else {
            return "user/noAccess";
        }
    }

    @GetMapping("/update/{id}")
    public String updateChild(@PathVariable Long id, Model model,HttpSession session) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            Child child = childDao.findById(id);
            model.addAttribute("child", child);
            model.addAttribute("groups", groupDao.findAll());
            model.addAttribute("parents", parentDao.findAll());
            return "child/editForm";
        } else {
            return "user/noAccess";
        }
    }

    @PostMapping("/update")
    public String updatedChild(@ModelAttribute Child child, Model model, HttpSession session) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            childDao.saveChild(child);
            List<Child> children = childDao.findAll();
            model.addAttribute("children", children);
            return "child/list";
        } else {
            return "user/noAccess";
        }
    }
}

