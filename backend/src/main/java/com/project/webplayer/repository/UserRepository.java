package com.project.webplayer.repository;

import com.project.webplayer.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {

    boolean existsUserByUserMailAndPassWordEquals(String userMail, String userPassword);

}
