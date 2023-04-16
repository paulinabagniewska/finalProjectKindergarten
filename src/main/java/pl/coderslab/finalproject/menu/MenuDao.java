package pl.coderslab.finalproject.menu;

import org.springframework.stereotype.Repository;
import pl.coderslab.finalproject.child.Child;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.awt.print.Book;
import java.util.List;

@Repository
@Transactional
public class MenuDao {
    @PersistenceContext
    EntityManager entityManager;
    public void saveMenu(Menu menu) {
        entityManager.persist(menu);
    }

    public Menu findById(long id) {
        return entityManager.find(Menu.class, id);
    }

    public void update(Menu menu) {
        entityManager.merge(menu);
    }

    public void delete(Menu menu) {
        entityManager.remove(entityManager.contains(menu) ?
                menu : entityManager.merge(menu));
    }
    public List<Menu> findAll() {
        Query select = entityManager
                .createQuery("SELECT m from Menu m");
        return select.getResultList();
    }
}
