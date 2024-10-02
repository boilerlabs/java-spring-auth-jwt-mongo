package com.boilerlabs.auth.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.boilerlabs.auth.entities.User;

public interface UserRepository extends MongoRepository<User, String> {

}