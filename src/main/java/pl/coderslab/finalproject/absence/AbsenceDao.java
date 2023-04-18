package pl.coderslab.finalproject.absence;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.awt.print.Book;
import java.util.List;

@Service
public class AbsenceDao {
    @PersistenceContext
    EntityManager entityManager;
    public void saveAbsence(Absence absence) {
        entityManager.persist(absence);
    }

    public Absence findById(long id) {
        return entityManager.find(Absence.class, id);
    }

    public void update(Absence absence) {

        entityManager.merge(absence);
    }

    public void delete(Absence absence) {
        entityManager.remove(entityManager.contains(absence) ?
                absence : entityManager.merge(absence));
    }
    public List<Absence> findAll() {
        Query select = entityManager
                .createQuery("SELECT a from Absence a");
        return select.getResultList();
    }
}
