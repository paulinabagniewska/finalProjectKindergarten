package pl.coderslab.finalproject.absence;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.finalproject.announcement.Announcement;
import pl.coderslab.finalproject.child.Child;

import java.time.LocalDate;


@Controller
@RequestMapping("/absence")
public class AbsenceController {
    private final AbsenceDao absenceDao;


    public AbsenceController(AbsenceDao absenceDao) {
        this.absenceDao = absenceDao;
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        Absence absence = new Absence();
        model.addAttribute("absence", absence);
        return "absence/form";
    }

    @RequestMapping("/absence/get/{id}")
    @ResponseBody
    public String getAbsence(@PathVariable long id) {
        Absence absence = absenceDao.findById(id);
        return absence.toString();
    }



}
