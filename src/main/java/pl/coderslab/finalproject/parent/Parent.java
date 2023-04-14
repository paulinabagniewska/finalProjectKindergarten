package pl.coderslab.finalproject.parent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.coderslab.finalproject.child.Child;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;


@Getter
@NoArgsConstructor
@Setter
@Entity
@Table (name = "Parent")
public class Parent {
    public Parent(Long id, String name, String surname, String email, Long phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @Email
    private String email;
    @NotNull
    private Long phone;

    @OneToMany (mappedBy = "parent")
    private List <Child> child;



}
