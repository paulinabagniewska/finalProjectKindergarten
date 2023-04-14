package pl.coderslab.finalproject.absence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.finalproject.group.Group;

@Controller
@RequestMapping("/absence")
public class AbsenceController {
    private final AbsenceRepository absenceRepository;

    public AbsenceController(AbsenceRepository absenceRepository) {
        this.absenceRepository = absenceRepository;
    }
    @PostMapping("/add-absence")
    @ResponseBody
    public void addAbsence (Absence absence){
        absenceRepository.save(absence);
    }
    @GetMapping("/update-absence")
    @ResponseBody
    public void updateAbsence (Absence absence){
        absenceRepository.save(absence);
    }
    @GetMapping("/delete-absence")
    @ResponseBody
    public void deleteAbsence (Absence absence){
        absenceRepository.delete(absence);
    }
}
