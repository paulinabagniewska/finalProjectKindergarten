package pl.coderslab.finalproject.absence;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.finalproject.child.Child;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table (name = "absence")
public class Absence {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startsOfAbsence;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate endsOfAbsence;

    private String causeOfAbsence;

    @ManyToOne
    private Child child;


}
