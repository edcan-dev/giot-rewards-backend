package com.giot.rewards.backend.services;

import com.giot.rewards.backend.models.entities.Credential;
import org.springframework.stereotype.Service;

@Service
public interface ICredentialServices {
    public boolean checkCredential(Integer identifier);
    public boolean checkPassword(Integer identifier);
    public boolean validateLogin(Integer identifier, String password);
}
