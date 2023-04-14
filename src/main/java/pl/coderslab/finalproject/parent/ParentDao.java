package pl.coderslab.finalproject.parent;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ParentDao {
    @PersistenceContext
    EntityManager entityManager;
    public void saveChild(Parent parent){
        entityManager.persist(parent);
    }
    public Parent findById (long id){
        return entityManager.find(Parent.class, id);
    }
    public void updateParent (Parent parent){
        entityManager.merge(parent);
    }
    public  void deleteParent(Parent parent){
        entityManager.remove(entityManager.contains(parent)?
                parent : entityManager.merge(parent));
    }
}
