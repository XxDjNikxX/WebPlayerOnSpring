package com.project.webplayer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Document
public class User {
    @Id
    private String Id;

    private String userName;

    private String passWord;

    private String userMail;

    @DBRef
    private Collection<Song> favoriteSongs;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
