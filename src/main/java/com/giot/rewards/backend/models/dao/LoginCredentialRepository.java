package com.giot.rewards.backend.models.dao;

import com.giot.rewards.backend.models.entities.LoginCredential;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LoginCredentialRepository extends MongoRepository<LoginCredential,String> {
    public LoginCredential getById(String id);
}
