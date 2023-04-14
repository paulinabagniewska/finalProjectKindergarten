package pl.coderslab.finalproject.announcement;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class AnnouncementDao {
    @PersistenceContext
    EntityManager entityManager;
    public void saveAnnouncement(Announcement announcement){
        entityManager.persist(announcement);
    }
    public Announcement findById (long id){
        return entityManager.find(Announcement.class, id);
    }
    public void updateAnnouncement (Announcement announcement){
        entityManager.merge(announcement);
    }
    public  void deleteAnnouncement(Announcement announcement){
        entityManager.remove(entityManager.contains(announcement)?
                announcement : entityManager.merge(announcement));
    }
}
