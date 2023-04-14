package pl.coderslab.finalproject.absence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/absence")
public class AbsenceController {
    private final AbsenceDao absenceDao;
    public AbsenceController(AbsenceDao absenceDao) {

        this.absenceDao = absenceDao;
    }
}
