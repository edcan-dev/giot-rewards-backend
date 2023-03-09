package com.giot.rewards.backend.models.dao;

import com.giot.rewards.backend.models.entities.Credential;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialRepository extends MongoRepository<Credential,String> {
    public default Credential findByIdentifier(Integer identifier) {
        for (Credential crendential: findAll()) {
            if(crendential.getIdentifier().equals(identifier)) {
                return crendential;
            }
        }
        return null;
    }
}
