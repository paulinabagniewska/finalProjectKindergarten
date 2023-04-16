package pl.coderslab.finalproject.group;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/group")
public class GroupController {
    private final GroupDao groupDao;


    public GroupController(GroupDao groupDao) {
        this.groupDao = groupDao;
    }
}

