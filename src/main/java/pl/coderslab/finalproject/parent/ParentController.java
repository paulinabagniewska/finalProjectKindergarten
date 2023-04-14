package pl.coderslab.finalproject.parent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.finalproject.menu.Menu;

@Controller
@Slf4j
@RequestMapping("/parent")
public class ParentController {
    private final ParentRepository parentRepository;

    public ParentController(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }
    @PostMapping("/add-parent")
    @ResponseBody
    public void addParent (Parent parent){
        parentRepository.save(parent);
    }
    @GetMapping("/update-parent")
    @ResponseBody
    public void updateParent (Parent parent){
        parentRepository.save(parent);
    }
    @GetMapping("/delete-parent")
    @ResponseBody
    public void deleteParent (Parent parent){
       parentRepository.delete(parent);
    }
}
