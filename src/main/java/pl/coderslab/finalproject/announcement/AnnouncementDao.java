package pl.coderslab.finalproject.announcement;

import org.springframework.stereotype.Repository;
import pl.coderslab.finalproject.absence.Absence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.awt.print.Book;
import java.util.List;

@Repository
@Transactional
public class AnnouncementDao {
    @PersistenceContext
    EntityManager entityManager;

    public void saveAnnouncement(Announcement announcement) {
        entityManager.persist(announcement);
    }

    public Announcement findById(long id) {
        return entityManager.find(Announcement.class, id);
    }

    public void update(Announcement announcement) {
        entityManager.merge(announcement);
    }

    public void delete(Announcement announcement) {
        entityManager.remove(entityManager.contains(announcement) ?
                announcement : entityManager.merge(announcement));
    }
    public List<Announcement> findAll() {
        Query select = entityManager
                .createQuery("SELECT a from Announcement a");
        return select.getResultList();
    }
}