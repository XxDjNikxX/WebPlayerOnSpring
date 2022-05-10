package com.project.SpringWebPlayer.controllers;


import com.project.SpringWebPlayer.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {
    private final StorageService storageService;
    private final SongController songController;

    @Autowired
    public IndexController(StorageService storageService,SongController songController) {
        this.storageService = storageService;
        this.songController = songController;
    }

    @GetMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("songsFile", storageService.getSongFileNames());
        model.addAttribute("songName",songController.getSong("62717d55ae7539360f5e1c9e"));
        return "index";
    }

    @GetMapping("/about")
    public String getAboutPage() {
        return "about";
    }

    @GetMapping("/contact")
    public String getContactPage(){
        return "contact";
    }
}
