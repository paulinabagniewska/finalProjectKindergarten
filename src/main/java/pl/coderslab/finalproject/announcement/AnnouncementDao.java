package pl.coderslab.finalproject.announcement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.finalproject.child.Child;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.awt.print.Book;
import java.util.List;


@Service
public class AnnouncementDao {
    @PersistenceContext
    EntityManager entityManager;
    private AnnouncementRepository announcementRepository;
    @Autowired
    public AnnouncementDao(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }
    public Announcement saveAnnouncement (Announcement newAnnouncement){
        return announcementRepository.save(newAnnouncement);
    }

    public Announcement findById(long id) {

        return entityManager.find(Announcement.class, id);
    }
    public void  deleteAnnouncement (Announcement announcement){
        announcementRepository.deleteById(announcement.getId());
    }
    public  void delete(Long id){
       announcementRepository.deleteById(id);
    }

    public List<Announcement> findAll() {
        return announcementRepository.findAll();
    }
    public  void update (Announcement newAnnouncement){

        announcementRepository.save(newAnnouncement);
    }
}