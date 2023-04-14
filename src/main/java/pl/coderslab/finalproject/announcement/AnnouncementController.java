package pl.coderslab.finalproject.announcement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.finalproject.group.Group;

@Controller
@RequestMapping("/announcement")
public class AnnouncementController {
    private final AnnouncementRepository announcementRepository;

    public AnnouncementController(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }
    @PostMapping("/add-announcement")
    @ResponseBody
    public void addAnnouncement (Announcement announcement){
        announcementRepository.save(announcement);
    }
    @GetMapping("/update-announcement")
    @ResponseBody
    public void updateAnnouncement (Announcement announcement){
        announcementRepository.save(announcement);
    }
    @GetMapping("/delete-announcement")
    @ResponseBody
    public void deleteAnnouncement (Announcement announcement){
        announcementRepository.delete(announcement);
    }
}
