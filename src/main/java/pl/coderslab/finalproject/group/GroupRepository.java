package pl.coderslab.finalproject.group;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository <Group,Long> {

    List<Group> findGroupByName(String name);
    List<Group>findGroupById(Long id);

}
