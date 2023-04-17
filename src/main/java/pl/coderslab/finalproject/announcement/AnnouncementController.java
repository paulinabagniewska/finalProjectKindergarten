package pl.coderslab.finalproject.announcement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/announcement")
public class AnnouncementController {
    private final AnnouncementDao announcementDao;

    public AnnouncementController(AnnouncementDao announcementDao) {

        this.announcementDao = announcementDao;
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        Announcement announcement = new Announcement();
        model.addAttribute("announcement", announcement);
        return "announcement/form";
    }

   @GetMapping("/save")
    public  String savedAnnouncement (@Valid @ModelAttribute ("announcement") Announcement announcement,
                                      BindingResult result, ModelMap model){
        if(result.hasErrors()){
            return "errors";
        }
        model.addAttribute("id", announcement.getId());
        model.addAttribute("description", announcement.getDescription());
        return "view";
   }
}
