package com.giot.rewards.backend.models.dao;

import com.giot.rewards.backend.models.entities.Credential;
import com.giot.rewards.backend.models.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    public default User findByIdentifier(Integer identifier) {
        for (User user: findAll()) {
            if(user.getIdentifier().equals(identifier)) {
                return user;
            }
        }
        return null;
    }
}
