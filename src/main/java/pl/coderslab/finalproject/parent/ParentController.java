package pl.coderslab.finalproject.parent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/parent")
public class ParentController {
    private final ParentDao parentDao;

    public ParentController(ParentDao parentDao) {
        this.parentDao = parentDao;
    }
}
