package pl.coderslab.finalproject.child;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.finalproject.group.Group;


@Controller
@RequestMapping("/child")
public class ChildController {

    private final ChildRepository childRepository;

    public ChildController(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    @PostMapping("/add-child")
    @ResponseBody
    public void addChild(Child child) {
        childRepository.save(child);
    }

    @GetMapping("/update-child")
    @ResponseBody
    public void updateChild(Child child) {
        childRepository.save(child);
    }

    @GetMapping("/delete-child")
    @ResponseBody
    public void deleteChild(Child child) {
        childRepository.delete(child);
    }
}

