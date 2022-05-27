package com.project.webplayer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Song {
    @Id
    private String id;

    private String fileName;

    private String title;

    private String artist;

    private boolean isFavorited;

    public String getTitle() {
        return title;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getArtist() {
        return artist;
    }
}
