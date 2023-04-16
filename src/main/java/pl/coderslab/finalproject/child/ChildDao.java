package pl.coderslab.finalproject.child;

import org.springframework.stereotype.Repository;
import pl.coderslab.finalproject.absence.Absence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.awt.print.Book;
import java.util.List;

@Repository
@Transactional
public class ChildDao {
    @PersistenceContext
    EntityManager entityManager;
    public void saveChild(Child child) {
        entityManager.persist(child);
    }

    public Child findById(long id) {
        return entityManager.find(Child.class, id);
    }

    public void update(Child child) {
        entityManager.merge(child);
    }

    public void delete(Child child) {
        entityManager.remove(entityManager.contains(child) ?
                child : entityManager.merge(child));
    }
    public List<Child> findAll() {
        Query select = entityManager
                .createQuery("SELECT c from Child c");
        return select.getResultList();
    }
}
