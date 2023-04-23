package pl.coderslab.finalproject.parent;

import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;
import java.util.List;

public interface ParentRepository extends JpaRepository <Parent,Long> {
    List<Parent> findParentByChild(String name);
    List<Parent> findParentById(Long id);
    List<Parent> findParentByEmail(String email);
    List<Parent> findParentByPhone(Long phone);

}
