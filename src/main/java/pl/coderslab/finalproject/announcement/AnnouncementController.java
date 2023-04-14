package pl.coderslab.finalproject.announcement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/announcement")
public class AnnouncementController {
    private final AnnouncementDao announcementDao;


    public AnnouncementController(AnnouncementDao announcementDao) {
        this.announcementDao = announcementDao;
    }
}
