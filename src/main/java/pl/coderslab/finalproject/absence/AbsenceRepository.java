package pl.coderslab.finalproject.absence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface AbsenceRepository extends JpaRepository <Absence, LocalDate> {
}
