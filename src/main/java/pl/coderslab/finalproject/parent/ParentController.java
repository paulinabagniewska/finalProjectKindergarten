package pl.coderslab.finalproject.parent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/parent")
public class ParentController {
    private final ParentDao parentDao;

    public ParentController(ParentDao parentDao) {
        this.parentDao = parentDao;
    }
    @GetMapping("/add")
    public String addParent(Model model) {
        Parent parent = new Parent();
        model.addAttribute("parent", parent);
        return "parent/form";
    }
    @PostMapping("/add")
    public String saveParent (Parent parent) {
        parentDao.saveParent(parent);
        return "redirect:/parent/list";
    }
    @PostMapping("/delete")
    public String deleteParent(Parent parent) {
        parentDao.deleteParent(parent);
        return "parent/list";
    }
    @GetMapping("/list")
    public String getList( Model model){
        List<Parent> parents = parentDao.findAll();
        model.addAttribute("parents ", parents );
        return  "parent/list";
    }
    @PostMapping("delete/{id}")
    public  String deleteParent(@PathVariable Long id, Model model){
        parentDao.delete(id);
        List<Parent> parents  = parentDao.findAll();
        model.addAttribute("parents ", parents );
        return "parent/list";
    }
    @PostMapping ("/update")
    public String updateParent(@RequestBody Parent parent, Model model){
        parentDao.saveParent(parent);
        List <Parent> parents  = parentDao.findAll();
        model.addAttribute("parents", parents );
        return "parent/list";
    }
}
