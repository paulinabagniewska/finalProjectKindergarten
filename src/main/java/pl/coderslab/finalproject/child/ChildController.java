package pl.coderslab.finalproject.child;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/child")
public class ChildController {

    private final ChildDao childDao;

    public ChildController(ChildDao childDao) {
        this.childDao = childDao;
    }
    @GetMapping("/add")
    public String add (){
        return "form";
    }
}

