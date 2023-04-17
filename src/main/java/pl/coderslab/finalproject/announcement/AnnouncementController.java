package pl.coderslab.finalproject.announcement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/announcement")
public class AnnouncementController {
    private final AnnouncementDao announcementDao;

    public AnnouncementController(AnnouncementDao announcementDao) {
        this.announcementDao = announcementDao;
    }

    @RequestMapping("/announcement/add")
    @ResponseBody
    public String addAnnouncement() {
        Announcement announcement = new Announcement();
        announcement.setDescription("treść ogłoszenia");
        return "Id dodanego ogłoszenia to:"
                + announcement.getId();
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        Announcement announcement = new Announcement();
        model.addAttribute("announcement", announcement);
        return "announcement/form";
    }

    @GetMapping("/announcement")
    public String add(Model model) {
        model.addAttribute("announcement", announcementDao.findAll());
        return "announcement/form";
    }

    @PostMapping("/announcement")
    public String save(Announcement announcement) {
        announcementDao.saveAnnouncement(announcement);
        return "announcement/form";
    }

/*        @PostMapping("/save")
        public String saveAnnouncement(@RequestParam String description){
            return
        }*/

    @RequestMapping("/announcement/get/{id}")
    @ResponseBody
    public String getAnnouncement(@PathVariable long id) {
        Announcement announcement = announcementDao.findById(id);
        return announcement.toString();
    }

    @RequestMapping("/announcement/update/{id}/{description}")
    @ResponseBody
    public String updateAnnouncement(@PathVariable long id, @PathVariable String description) {

        Announcement announcement = announcementDao.findById(id);
        announcement.setDescription("treść ogłoszenia 222");

        announcementDao.update(announcement);
        return announcement.toString();
    }

    @RequestMapping("/announcement/delete/{id}")
    @ResponseBody
    public String deleteAnnouncement(@PathVariable long id) {
        Announcement announcement = announcementDao.findById(id);
        announcementDao.delete(announcement);
        return "deleted";
    }
}
