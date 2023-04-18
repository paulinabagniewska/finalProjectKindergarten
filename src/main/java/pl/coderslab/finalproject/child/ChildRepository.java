package pl.coderslab.finalproject.child;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChildRepository extends JpaRepository <Child, Long> {
    List<Child> findAllByGroup_Id(Long id);

    List<Child> findAllByParent_Id(Long id);

    List<Child> findAllByName(String name);
}
