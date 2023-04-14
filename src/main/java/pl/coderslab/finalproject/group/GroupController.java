package pl.coderslab.finalproject.group;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/group")
public class GroupController {
    private final GroupRepository groupRepository;

    public GroupController(GroupRepository groupRepository) {

        this.groupRepository = groupRepository;
    }
    @PostMapping ("/add-group")
    @ResponseBody
    public void addGroup (Group group){
        groupRepository.save(group);
    }
    @GetMapping("/update-group")
    @ResponseBody
    public void updateGroup (Group group){
        groupRepository.save(group);
    }
    @GetMapping("/delete-group")
    @ResponseBody
    public void deleteGroup (Group group){
        groupRepository.delete(group);
    }
}

