package pl.coderslab.finalproject.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class MenuDao {
    @PersistenceContext
    EntityManager entityManager;
    private MenuRepository menuRepository;

    @Autowired

    public MenuDao(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }
    public Menu saveMenu (Menu newMenu){

        return menuRepository.save(newMenu);
    }
    public Menu findById(long id) {

        return entityManager.find(Menu.class, id);
    }
    public void  deleteMenu (Menu menu){
        menuRepository.deleteById(menu.getId());
    }
    public  void delete(Long id){

        menuRepository.deleteById(id);
    }

    public List<Menu> findAll() {
        return menuRepository.findAll();
    }

    public  void update (Menu newMenu){
        menuRepository.save(newMenu);
    }
}
