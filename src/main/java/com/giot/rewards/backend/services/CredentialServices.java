package com.giot.rewards.backend.services;

//import com.giot.rewards.backend.models.dao.*;
import com.giot.rewards.backend.models.dao.CredentialRepository;
import com.giot.rewards.backend.models.dao.UserRepository;
import com.giot.rewards.backend.models.entities.Credential;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CredentialServices implements ICredentialServices {

    Logger logger = LoggerFactory.getLogger(CredentialServices.class);

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

        boolean hasPassword = true;

        // Verifica si existe o no contraseña para ese identificador

        Credential credential = credentialRepository.findByIdentifier(identifier);

        try {
            if(credential.getPassword().equals("") || credential.getPassword() == null) hasPassword = false;
        } catch(NullPointerException ex) {
            logger.warn("Petición incorrecta...");
            return false;
        }
        return hasPassword;
    }

    @Override
    public boolean validateLogin(Integer identifier, String password) {

        boolean validated = false;

        Credential credential = credentialRepository.findByIdentifier(identifier);

        if(password == null) {
            return false;
        }

        if(checkPassword(identifier)) {
            if(credential.getPassword().equals(password)) {
                logger.warn("Login validado...");
                validated = true;
            } else {
                logger.warn("Login inválido...");
            }
        } else {
            credential.setPassword(password);
            System.out.println(credential);
            credentialRepository.save(credential); // Definimos el nuevo pass
            validated = true;
        }
        return validated;
    }
}


