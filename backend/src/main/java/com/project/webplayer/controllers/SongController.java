package com.project.webplayer.controllers;


import com.project.webplayer.model.Song;
import com.project.webplayer.repository.SongRepository;
import com.project.webplayer.services.StorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class SongController {
    private final StorageService storageService;
    private final SongRepository songRepository;

    public SongController(SongRepository songRepository, StorageService storageService) {
        this.storageService = storageService;
        this.songRepository = songRepository;
    }

    @GetMapping("/getAllSongs")
    public ResponseEntity<List<Song>> getSongs() {
        return ResponseEntity.ok(songRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> getSong(@PathVariable String id) {
       Optional<Song> song  = songRepository.findById(id);
       if(song.isPresent()) {
           return ResponseEntity.ok(song.get());
       } else {
           return ResponseEntity.notFound().build();
       }
    }
    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<?> createSong(@RequestPart("songs") Song song, @RequestPart("file")MultipartFile file) throws IOException {
        if(songRepository.existsSongByFileNameEquals(song.getFileName())
                || songRepository.existsSongByTitleEquals(song.getTitle())) {
            return ResponseEntity.badRequest().body("taken");
        } else {
            System.out.println("Uploading file...");
            storageService.uploadSong(file);
            song.setFileName(file.getOriginalFilename());
            Song insertedSong = songRepository.insert(song);
            return new ResponseEntity<>(insertedSong, HttpStatus.CREATED);
        }
    }

    @GetMapping("/getSongFileName/{id}")
    public ResponseEntity<?> getSongFileName(@RequestParam(name="fileName",required = false) @PathVariable String id) {
        Optional<Song> song  = songRepository.findById(id);
        if(song.isPresent()) {
            return ResponseEntity.ok(song.get().getFileName());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
