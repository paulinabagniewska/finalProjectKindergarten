package pl.coderslab.finalproject.parent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class ParentDao {
    @PersistenceContext
    EntityManager entityManager;
  private ParentRepository parentRepository;
  @Autowired

    public ParentDao(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }
    public Parent saveParent (Parent newParent){

        return parentRepository.save(newParent);
    }
    public Parent findById(long id) {

        return entityManager.find(Parent.class, id);
    }
    public void  deleteParent (Parent parent){
        parentRepository.deleteById(parent.getId());
    }

    public List<Parent> findAll() {
        return parentRepository.findAll();
    }
    public  void delete(Long id){

        parentRepository.deleteById(id);
    }
    public  void update (Parent newParent){
        parentRepository.save(newParent);
    }
}
