package pl.coderslab.finalproject.announcement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.absence.Absence;

import java.util.List;

@Controller
@RequestMapping("/announcement")
public class AnnouncementController {
    private final AnnouncementDao announcementDao;

    public AnnouncementController(AnnouncementDao announcementDao) {

        this.announcementDao = announcementDao;
    }

    @GetMapping("/add")
    public String addAnnouncement(Model model) {
        Announcement announcement = new Announcement();
        model.addAttribute("announcement", announcement);
        return "announcement/form";
    }

    @PostMapping("/add")
    public String saveAnnouncement(Announcement announcement) {
        announcementDao.saveAnnouncement(announcement);
        return "redirect:/announcement/list";
    }

    @GetMapping("/list")
    public String getList(Model model) {
        List<Announcement> announcements = announcementDao.findAll();
        model.addAttribute("announcements", announcements);
        return "announcement/list";
    }

    @RequestMapping("delete/{id}")
    public String deleteAnnouncement(@PathVariable Long id) {
        Announcement announcement = announcementDao.findById(id);
        announcementDao.delete(id);
        return "redirect:/announcement/list";
    }

    @GetMapping("/update/{id}")
    public String updateAnnouncement(@PathVariable Long id, Model model) {
        Announcement announcement = announcementDao.findById(id);
        model.addAttribute("announcement", announcement);
        return "announcement/editForm";
    }

 @PostMapping("/update")
    public String updatedAnnouncement(@ModelAttribute Announcement announcement, Model model) {
        announcementDao.saveAnnouncement(announcement);
        List <Announcement> announcements = announcementDao.findAll();
        model.addAttribute("announcements", announcements);

        return "announcement/list";
    }

}
