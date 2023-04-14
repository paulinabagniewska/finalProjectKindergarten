package pl.coderslab.finalproject.group;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/group")
public class GroupController {
    private final GroupRepository groupRepository;

    public GroupController(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }
    @GetMapping("/save-group")
    @ResponseBody
    public void saveGroup (Group group){
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

