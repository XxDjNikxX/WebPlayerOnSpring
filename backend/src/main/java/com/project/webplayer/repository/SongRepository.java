package com.project.webplayer.repository;

import com.project.webplayer.model.Song;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SongRepository  extends MongoRepository<Song, String> {
    boolean existsSongByFileNameEquals(String fileName);
    boolean existsSongByTitleEquals(String title);
}
