package pl.coderslab.finalproject.announcement;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnnouncementRepository extends JpaRepository <Announcement, Long> {
    List <Announcement> findAnnouncementById (Long id);
}
