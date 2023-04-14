package pl.coderslab.finalproject.announcement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table (name ="announcement")
public class Announcement {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String decsription;

}
