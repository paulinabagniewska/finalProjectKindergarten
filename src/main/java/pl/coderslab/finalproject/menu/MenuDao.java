package pl.coderslab.finalproject.menu;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class MenuDao {
    @PersistenceContext
    EntityManager entityManager;
    public void saveGroup(Menu menu){
        entityManager.persist(menu);
    }
    public Menu findById (long id){
        return entityManager.find(Menu.class, id);
    }
    public void updateGroup(Menu menu){
        entityManager.merge(menu);
    }
    public  void deleteGroup(Menu menu){
        entityManager.remove(entityManager.contains(menu)?
                menu : entityManager.merge(menu));
    }
}
