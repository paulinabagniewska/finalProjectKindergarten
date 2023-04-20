package pl.coderslab.finalproject.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.finalproject.announcement.Announcement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Service
public class GroupDao {
    @PersistenceContext
    EntityManager entityManager;
    private GroupRepository groupRepository;
@Autowired
    public GroupDao(GroupRepository groupRepository) {

    this.groupRepository = groupRepository;
    }
    public Group saveGroup (Group newGroup){

    return groupRepository.save(newGroup);
    }
    public Group findById(long id) {

        return entityManager.find(Group.class, id);
    }
    public void  deleteGroup (Group group){

    groupRepository.deleteById(group.getId());
    }
    public  void delete(Long id){

        groupRepository.deleteById(id);
    }

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public  void update (Group newGroup){
        groupRepository.save(newGroup);
    }
}
