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

        boolean hasCredential = false;

        for (Credential credential: credentialRepository.findAll()) {
            if(credential.getIdentifier().equals(identifier)) {
                hasCredential =  true;
                break;
            }
        }
        return hasCredential;
    }

    @Override
    public boolean checkPassword(Integer identifier) {

        if(! this.checkCredential(identifier)) { // Verifica si existe o no la credencial
            this.checkCredential(identifier);
        }

        boolean hasPassword = true;

        // Verifica si existe o no contraseña para ese identificador

        Credential credential = credentialRepository.findByIdentifier(identifier);

        if(credential.getPassword().equals("") || credential.getPassword() == null) hasPassword = false;

        return hasPassword;
    }
}


