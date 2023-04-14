package pl.coderslab.finalproject.absence;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class AbsenceDao {
    @PersistenceContext
    EntityManager entityManager;
    public void saveAbsence(Absence absence){
        entityManager.persist(absence);
    }
    public Absence findById (long id){
        return entityManager.find(Absence.class, id);
    }
    public void updateAbsence (Absence absence){
        entityManager.merge(absence);
    }
    public  void deleteAbsence(Absence absence){
        entityManager.remove(entityManager.contains(absence)?
                absence: entityManager.merge(absence));
    }
}
