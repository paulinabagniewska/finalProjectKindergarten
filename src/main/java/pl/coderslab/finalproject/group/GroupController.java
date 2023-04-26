package pl.coderslab.finalproject.group;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.announcement.Announcement;
import pl.coderslab.finalproject.menu.Menu;
import pl.coderslab.finalproject.user.Role;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/group")
public class GroupController {
    private final GroupDao groupDao;

    public GroupController(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @GetMapping("/add")
    public String addGroup(Model model, HttpSession session) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            Group group = new Group();
            model.addAttribute("group", group);
            return "group/form";
        } else {
            return "user/noAccess";
        }
    }

    @PostMapping("/add")
    public String saveGroup(Group group) {
        groupDao.saveGroup(group);
        return "redirect:/group/list";
    }

    @PostMapping("/delete")
    public String deleteGroup(Group group) {
        groupDao.deleteGroup(group);
        return "group/list";
    }

    @GetMapping("/list")
    public String getList(Model model, HttpSession session) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            List<Group> groups = groupDao.findAll();
            model.addAttribute("groups", groups);
            return "group/list";
        } else {
            return "user/noAccess";
        }
    }
    @GetMapping("delete/{id}")
    public String deleteGroup(@PathVariable Long id, Model model, HttpSession session) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            groupDao.delete(id);
            List<Group> groups = groupDao.findAll();
            model.addAttribute("groups", groups);
            return "group/list";
        } else {
            return "user/noAccess";
        }
    }

    @GetMapping("/update/{id}")
    public String updateGroup(@PathVariable Long id, Model model, HttpSession session) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            Group group = groupDao.findById(id);
            model.addAttribute("group", group);
            return "group/editForm";
        } else {
            return "user/noAccess";
        }
    }

    @PostMapping("/update")
    public String updatedGroup(@ModelAttribute Group group, Model model, HttpSession session) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            groupDao.saveGroup(group);
            List<Group> groups = groupDao.findAll();
            model.addAttribute("groups", groups);
            return "group/list";
        } else {
            return "user/noAccess";
        }
    }
}

