package pl.coderslab.finalproject.absence;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.child.ChildDao;
import pl.coderslab.finalproject.group.Group;
import pl.coderslab.finalproject.user.Role;

import javax.servlet.http.HttpSession;
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
    public String addAbsence(Model model, HttpSession session) {
        if (session.getAttribute("role") != null ) {
            Absence absence = new Absence();
            model.addAttribute("absence", absence);
            model.addAttribute("children", childDao.findAll());
            return "absence/form";
        } else {
            return "user/noAccess";
        }
    }

    @PostMapping("/add")
    public String saveAbsence(Absence absence) {
        absenceDao.saveAbsence(absence);
        return "redirect:/absence/list";
    }

    @GetMapping("/list")
    public String getList(Model model, HttpSession session) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            List<Absence> absences = absenceDao.findAll();
            model.addAttribute("absences", absences);
            model.addAttribute("children", childDao.findAll());
            return "absence/list";
        } else {
            return "user/noAccess";
        }
    }

    @GetMapping("/userList")
    public String getUserList(Model model) {
            List<Absence> absences = absenceDao.findAll();
            model.addAttribute("absences", absences);
            model.addAttribute("children", childDao.findAll());
            return "absence/userList";
        }


    @GetMapping("delete/{id}")
    public String deleteAbsence(@PathVariable Long id, Model model, HttpSession session) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            absenceDao.delete(id);
            List<Absence> absences = absenceDao.findAll();
            model.addAttribute("absences", absences);
            return "absence/list";
        } else {
            return "user/noAccess";
        }
    }

    @PostMapping("/delete")
    public String deleteAbsence(Absence absence) {
        absenceDao.deleteAbsence(absence);
        return "absence/list";
    }

    @GetMapping("/update/{id}")
    public String updateAbsence(@PathVariable Long id, Model model, HttpSession session) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            Absence absence = absenceDao.findById(id);
            model.addAttribute("absence", absence);
            model.addAttribute("children", childDao.findAll());
            return "absence/editForm";
        } else {
            return "user/noAccess";
        }
    }

    @PostMapping("/update")
    public String updatedAbsence(@ModelAttribute Absence absence, Model model, HttpSession session) {

        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            absenceDao.saveAbsence(absence);
            List<Absence> absences = absenceDao.findAll();
            model.addAttribute("absences", absences);
            return "absence/list";
        } else {
            return "user/noAccess";
        }
    }
}