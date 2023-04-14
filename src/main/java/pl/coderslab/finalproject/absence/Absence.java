package pl.coderslab.finalproject.absence;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.finalproject.child.Child;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter

@Entity
@Table (name = "absence")
public class Absence {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startsOfAbsence;
    private LocalDate endsOfAbsence;

    private String causeOfAbsence;

    @ManyToOne
    private Child child;


}
