package com.giot.rewards.backend.services;

import com.giot.rewards.backend.models.entities.Credential;

public interface ICredentialServices {
    public boolean checkCredential(Integer identifier);
    public boolean checkPassword(Integer identifier);
}
