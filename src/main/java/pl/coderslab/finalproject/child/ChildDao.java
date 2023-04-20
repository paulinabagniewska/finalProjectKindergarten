package pl.coderslab.finalproject.child;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Service
public class ChildDao {
    @PersistenceContext
    EntityManager entityManager;
    private ChildRepository childRepository;

    @Autowired
    public ChildDao(ChildRepository childRepository) {

        this.childRepository = childRepository;
    }

    public Child saveChild(Child newChild) {

        return childRepository.save(newChild);
    }

    public Child findById(long id) {

        return entityManager.find(Child.class, id);
    }

    public void deleteChild(Child child) {

        childRepository.deleteById(child.getId());
    }

    public  void delete(Long id){

        childRepository.deleteById(id);
    }

    public List<Child> findAll() {

        return childRepository.findAll();
    }


    public void update(Child newChild) {
        childRepository.save(newChild);
    }
}
