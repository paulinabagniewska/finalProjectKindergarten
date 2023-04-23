package pl.coderslab.finalproject.menu;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MenuRepository extends JpaRepository <Menu, Long> {

List<Menu> findMenuByDate(LocalDate date);
List<Menu> findMenuById (Long id);
}