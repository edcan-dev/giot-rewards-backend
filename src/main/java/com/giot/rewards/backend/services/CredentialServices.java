package com.giot.rewards.backend.services;

//import com.giot.rewards.backend.models.dao.*;
import com.giot.rewards.backend.models.dao.CredentialRepository;
import com.giot.rewards.backend.models.dao.UserRepository;
import com.giot.rewards.backend.models.entities.Credential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CredentialServices implements ICredentialServices {

    @Autowired
    private CredentialRepository credentialRepository;

    @Override
    public boolean checkCredential(Integer identifier) {

        boolean result = false;

        for (Credential credential: credentialRepository.findAll()) {
            if(credential.getIdentifier().equals(identifier)) {
                result =  true;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean checkPassword(Integer identifier) {
        return false;
    }
}


