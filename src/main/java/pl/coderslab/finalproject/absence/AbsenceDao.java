package pl.coderslab.finalproject.absence;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.lang.Long;

@Service
public class AbsenceDao {
    @PersistenceContext
    EntityManager entityManager;

    private final AbsenceRepository absenceRepository;

    @Autowired

    public AbsenceDao(AbsenceRepository absenceRepository) {

        this.absenceRepository = absenceRepository;
    }

    public Absence saveAbsence(Absence newAbsence) {

        return absenceRepository.save(newAbsence);
    }

    public Absence findById(long id) {

        return entityManager.find(Absence.class, id);
    }

    public void  deleteAbsence (Absence absence){
        absenceRepository.deleteById(absence.getId());
    }
    public  void delete(Long id){
        absenceRepository.deleteById(id);
    }


        public List<Absence> findAll () {
            return absenceRepository.findAll();
        }
        public  Absence update(Absence absence){
        return absenceRepository.save(absence);
        }
    }
