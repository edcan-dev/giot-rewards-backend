package com.giot.rewards.backend.models.dao;

import com.giot.rewards.backend.models.entities.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<Users, String> { }
