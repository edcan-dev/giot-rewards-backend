package com.giot.rewards.backend.models.dao;

import com.giot.rewards.backend.models.entities.Credential;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialRepository extends MongoRepository<Credential,String> {
}
