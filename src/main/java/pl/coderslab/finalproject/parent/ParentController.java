package pl.coderslab.finalproject.parent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.announcement.Announcement;
import pl.coderslab.finalproject.user.Role;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/parent")
public class ParentController {
    private final ParentDao parentDao;

    public ParentController(ParentDao parentDao) {
        this.parentDao = parentDao;
    }

    @GetMapping("/add")
    public String addParent(Model model, HttpSession session) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            Parent parent = new Parent();
            model.addAttribute("parent", parent);
            return "parent/form";
        } else {
            return "user/noAccess";
        }
    }

    @PostMapping("/add")
    public String saveParent(Parent parent) {
        parentDao.saveParent(parent);
        return "redirect:/parent/list";
    }

    @PostMapping("/delete")
    public String deleteParent(Parent parent, HttpSession session) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            parentDao.deleteParent(parent);
            return "parent/list";
        } else {
            return "user/noAccess";
        }
    }

    @GetMapping("/list")
    public String getList(Model model, HttpSession session) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            List<Parent> parents = parentDao.findAll();
            model.addAttribute("parents", parents);
            return "parent/list";
        } else {
            return "user/noAccess";
        }
    }


    @RequestMapping("delete/{id}")
    public String deleteParent(@PathVariable Long id, HttpSession session) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            Parent parent = parentDao.findById(id);
            parentDao.delete(id);
            return "redirect:/parent/list";
        } else {
            return "user/noAccess";
        }
    }

    @GetMapping("/update/{id}")
    public String updateParent(@PathVariable Long id, Model model, HttpSession session) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            Parent parent = parentDao.findById(id);
            model.addAttribute("parent", parent);
            return "parent/editForm";
        } else {
            return "user/noAccess";
        }
    }

    @PostMapping("/update")
    public String updatedParent(@ModelAttribute Parent parent, Model model, HttpSession session) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            parentDao.saveParent(parent);
            List<Parent> parents = parentDao.findAll();
            model.addAttribute("parents", parents);
            return "parent/list";
        } else {
            return "user/noAccess";
        }
    }
}
