package pl.coderslab.finalproject.group;

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
public class GroupDao {
    @PersistenceContext
    EntityManager entityManager;
    public void saveGroup(Group group) {
        entityManager.persist(group);
    }

    public Group findById(long id) {
        return entityManager.find(Group.class, id);
    }

    public void update(Group group) {
        entityManager.merge(group);
    }

    public void delete(Group group) {
        entityManager.remove(entityManager.contains(group) ?
                group : entityManager.merge(group));
    }
    public List<Group> findAll() {
        Query select = entityManager
                .createQuery("SELECT g from Group g");
        return select.getResultList();
    }
}
