package pl.coderslab.finalproject.announcement;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

@Entity
@Table (name ="announcement")
public class Announcement {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String decsription;

}
