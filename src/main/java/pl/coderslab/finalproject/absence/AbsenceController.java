package pl.coderslab.finalproject.absence;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.finalproject.child.Child;

import java.time.LocalDate;


@Controller
@RequestMapping("/absence")
public class AbsenceController {
    private final AbsenceDao absenceDao;


    public AbsenceController(AbsenceDao absenceDao) {
        this.absenceDao = absenceDao;
    }
  @RequestMapping("/absence/add")
  @ResponseBody
   public String addAbsence() {
   Absence absence = new Absence();
      LocalDate startsOfAbsence =  LocalDate.of(2023,5,2);
      LocalDate endsOfAbsence = LocalDate.of(2023,5,5);
      absence.setStartsOfAbsence(startsOfAbsence);
      absence.setEndsOfAbsence(endsOfAbsence);
      absence.setCauseOfAbsence("przeziębienie");
      absence.setChild(new Child());
      absenceDao.saveAbsence(absence);
      return "Id dodanej nieobecności to:"
              + absence.getId();
  }
    @RequestMapping("/absence/get/{id}")
    @ResponseBody
    public String getAbsence(@PathVariable long id) {
        Absence absence = absenceDao.findById(id);
        return absence.toString();
    }



}
