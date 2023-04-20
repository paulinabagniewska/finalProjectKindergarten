package pl.coderslab.finalproject.absence;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Service
public class AbsenceDao {
    @PersistenceContext
    EntityManager entityManager;

    private final AbsenceRepository absenceRepository;

    @Autowired

    public AbsenceDao(AbsenceRepository absenceRepository) {
        this.absenceRepository = absenceRepository;
    }
    public Absence saveAbsence (Absence newAbsence){
        return absenceRepository.save(newAbsence);
    }

    public Absence findById(long id) {

        return entityManager.find(Absence.class, id);
    }
    public void  deleteAbsence (Absence absence){

        absenceRepository.deleteAll();
    }
 /*   public  void delete(Long id){
        absenceRepository.deleteById (LocalDate.EPOCH);
    }*/

    public List<Absence> findAll() {
        return absenceRepository.findAll();
    }

    public  void update (Absence newAbsence){

        absenceRepository.save(newAbsence);
    }
}
