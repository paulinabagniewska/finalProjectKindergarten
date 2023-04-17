package pl.coderslab.finalproject.group;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/group")
public class GroupController {
    private final GroupDao groupDao;


    public GroupController(GroupDao groupDao) {
        this.groupDao = groupDao;
    }
    @ModelAttribute("group")
    public List<String> groupList (){
        return Arrays.asList("Stokrotki", "Dmuchawce","Bratki");
    }
}

