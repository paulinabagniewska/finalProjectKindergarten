package pl.coderslab.finalproject.absence;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.child.ChildDao;
import pl.coderslab.finalproject.group.Group;

import java.util.List;


@Controller
@RequestMapping("/absence")
public class AbsenceController {
    private final AbsenceDao absenceDao;
    private final ChildDao childDao;
    public AbsenceController(AbsenceDao absenceDao, ChildDao childDao) {
        this.absenceDao = absenceDao;
        this.childDao = childDao;
    }

    @GetMapping("/add")
    public String addAbsence(Model model) {
        Absence absence = new Absence();
        model.addAttribute("absence", absence);
        model.addAttribute("children", childDao.findAll());
        return "absence/form";
    }

    @PostMapping("/add")
    public String saveAbsence( Absence absence) {
        absenceDao.saveAbsence(absence);
        return "redirect:/absence/list";
    }


   @GetMapping("/list")
    public String getList(Model model) {
        List<Absence> absences = absenceDao.findAll();
        model.addAttribute("absences", absences);
        model.addAttribute("children", childDao.findAll());
        return "absence/list";
    }
    @GetMapping("/userList")
    public String getUserList(Model model) {
        List<Absence> absences = absenceDao.findAll();
        model.addAttribute("absences", absences);
        model.addAttribute("children", childDao.findAll());
        return "absence/userList";
    }

    @GetMapping("delete/{id}")
    public  String deleteAbsence(@PathVariable Long id, Model model) {
        absenceDao.delete(id);
        List<Absence> absences = absenceDao.findAll();
        model.addAttribute("absences", absences);
        return "absence/list";
    }
    @PostMapping("/delete")
    public String deleteAbsence(Absence absence) {
        absenceDao.deleteAbsence(absence);
        return "absence/list";
    }

    @GetMapping("/update/{id}")
    public String updateAbsence(@PathVariable Long id, Model model) {
        Absence absence = absenceDao.findById(id);
        model.addAttribute("absence", absence);
        model.addAttribute("children", childDao.findAll());
        return "absence/editForm";
    }

 @PostMapping("/update")
    public String updatedAbsence(@ModelAttribute Absence absence, Model model) {
        absenceDao.saveAbsence(absence);
        List<Absence> absences = absenceDao.findAll();
        model.addAttribute("absences", absences);
        return "absence/list";
    }
}
