package pl.coderslab.finalproject.child;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ChildDao {
    @PersistenceContext
    EntityManager entityManager;
    public void saveChild(Child child){
        entityManager.persist(child);
    }
    public Child findById (long id){
        return entityManager.find(Child.class, id);
    }
    public void updateChild (Child child){
        entityManager.merge(child);
    }
    public  void deleteChild(Child child){
        entityManager.remove(entityManager.contains(child)?
                child : entityManager.merge(child));
    }
}
