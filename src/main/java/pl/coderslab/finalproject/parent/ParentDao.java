package pl.coderslab.finalproject.parent;

import org.springframework.stereotype.Repository;
import pl.coderslab.finalproject.menu.Menu;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.awt.print.Book;
import java.util.List;

@Repository
@Transactional
public class ParentDao {
    @PersistenceContext
    EntityManager entityManager;
    public void saveParent(Parent parent) {
        entityManager.persist(parent);
    }

    public Parent findById(long id) {
        return entityManager.find(Parent.class, id);
    }

    public void update(Parent parent) {
        entityManager.merge(parent);
    }

    public void delete(Parent parent) {
        entityManager.remove(entityManager.contains(parent) ?
                parent : entityManager.merge(parent));
    }
    public List<Parent> findAll() {
        Query select = entityManager
                .createQuery("SELECT p from Parent p");
        return select.getResultList();
    }
}
