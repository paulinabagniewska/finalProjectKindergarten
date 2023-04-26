package pl.coderslab.finalproject.announcement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.absence.Absence;
import pl.coderslab.finalproject.user.Role;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/announcement")
public class AnnouncementController {
    private final AnnouncementDao announcementDao;

    public AnnouncementController(AnnouncementDao announcementDao) {

        this.announcementDao = announcementDao;
    }

    @GetMapping("/add")
    public String addAnnouncement(Model model, HttpSession session) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            Announcement announcement = new Announcement();
            model.addAttribute("announcement", announcement);
            return "announcement/form";
        } else {
            return "user/noAccess";
        }
    }

    @PostMapping("/add")
    public String saveAnnouncement(Announcement announcement) {
        announcementDao.saveAnnouncement(announcement);
        return "redirect:/announcement/list";
    }

    @GetMapping("/list")
    public String getList(Model model, HttpSession session) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            List<Announcement> announcements = announcementDao.findAll();
            model.addAttribute("announcements", announcements);
            return "announcement/list";
        } else {
            return "user/noAccess";
        }
    }

    @GetMapping("/userList")
    public String getUserList(Model model, HttpSession session) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.USER)) {
            List<Announcement> announcements = announcementDao.findAll();
            model.addAttribute("announcements", announcements);
            return "announcement/userList";
        } else {
            return "user/noAccess";
        }
    }


    @RequestMapping("delete/{id}")
    public String deleteAnnouncement(@PathVariable Long id, HttpSession session) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            Announcement announcement = announcementDao.findById(id);
            announcementDao.delete(id);
            return "redirect:/announcement/list";
        } else {
            return "user/noAccess";
        }
    }

    @GetMapping("/update/{id}")
    public String updateAnnouncement(@PathVariable Long id, Model model, HttpSession session) {

        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            Announcement announcement = announcementDao.findById(id);
            model.addAttribute("announcement", announcement);
            return "announcement/editForm";
        } else {
            return "user/noAccess";
        }

    }

    @PostMapping("/update")
    public String updatedAnnouncement(@ModelAttribute Announcement announcement, Model model, HttpSession session) {
        if (session.getAttribute("role") != null && session.getAttribute("role").equals(Role.ADMIN)) {
            announcementDao.saveAnnouncement(announcement);
            List<Announcement> announcements = announcementDao.findAll();
            model.addAttribute("announcements", announcements);
            return "announcement/list";
        } else {
            return "user/noAccess";
        }
    }

}
