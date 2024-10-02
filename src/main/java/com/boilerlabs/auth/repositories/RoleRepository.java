package com.boilerlabs.auth.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.boilerlabs.auth.entities.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(String name);

    boolean existsByName(String name);
}