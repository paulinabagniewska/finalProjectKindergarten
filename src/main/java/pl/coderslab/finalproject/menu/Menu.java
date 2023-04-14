package pl.coderslab.finalproject.menu;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter

@Entity
@Table (name = "menu")
public class Menu {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String breakfast;
    private String secondBreakfast;
    private String lunch;
    private String dessert;


}
