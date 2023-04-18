package pl.coderslab.finalproject.group;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.announcement.Announcement;
import pl.coderslab.finalproject.child.Child;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/group")
public class GroupController {
    private final GroupDao groupDao;
    public GroupController(GroupDao groupDao) {
        this.groupDao = groupDao;
    }
    @GetMapping("/add")
    public String addGroup(Model model) {
        Group group = new Group();
        model.addAttribute("group", group);
        return "group/form";
    }
    @PostMapping("/save")
    public String saveGroup (Group group) {
        groupDao.saveGroup(group);
        return "group/view";
    }
    @PostMapping("/delete")
    public String deleteGroup(Group group) {
        groupDao.deleteGroup(group);
        return "group/list";
    }
    @GetMapping("/list")
    public String getList( Model model){
        List <Group> groups = groupDao.findAll();
        model.addAttribute("groups", groups);
        return  "group/list";
    }
    @PostMapping("delete/{id}")
    public  String deleteGroup(@PathVariable Long id, Model model){
        groupDao.delete(id);
        List<Group> groups = groupDao.findAll();
        model.addAttribute("groups", groups);
        return "group/list";
    }
    @PostMapping ("/update")
    public String updateGroup( @RequestBody Group group, Model model){
        groupDao.saveGroup(group);
        List <Group> groups = groupDao.findAll();
        model.addAttribute("groups", groups);
        return "group/list";
    }
}

