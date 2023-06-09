package pl.coderslab.finalproject.absence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AbsenceRepository extends JpaRepository <Absence, Long> {
    List<Absence> findAllByChild_Id(Long id);

    List<Absence> findAllByStartsOfAbsenceAfter(LocalDate date);

    List<Absence> findAllByEndsOfAbsence(LocalDate date);
    void deleteAbsenceById (Long id);

}
