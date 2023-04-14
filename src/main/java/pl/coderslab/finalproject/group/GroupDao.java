package pl.coderslab.finalproject.group;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class GroupDao {
    @PersistenceContext
    EntityManager entityManager;
    public void saveGroup(Group group){

        entityManager.persist(group);
    }
    public Group findById (long id){

        return entityManager.find(Group.class, id);
    }
    public void updateGroup(Group group){

        entityManager.merge(group);
    }
    public  void deleteGroup(Group group){
        entityManager.remove(entityManager.contains(group)?
                group : entityManager.merge(group));
    }
}
