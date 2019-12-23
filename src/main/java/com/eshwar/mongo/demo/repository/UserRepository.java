package com.eshwar.mongo.demo.repository;

import com.eshwar.mongo.demo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository  extends MongoRepository<User, String> {

}
