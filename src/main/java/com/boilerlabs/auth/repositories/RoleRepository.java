package com.boilerlabs.auth.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.boilerlabs.auth.entities.Role;

public interface RoleRepository extends MongoRepository<Role, String> {

}