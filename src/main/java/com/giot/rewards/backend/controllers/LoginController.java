package com.giot.rewards.backend.controllers;

import com.giot.rewards.backend.models.dao.CredentialRepository;
import com.giot.rewards.backend.models.dao.UserRepository;
import com.giot.rewards.backend.models.entities.Credential;
import com.giot.rewards.backend.models.entities.User;
import com.giot.rewards.backend.services.ICredentialServices;
import com.giot.rewards.backend.services.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CredentialRepository credentialRepository;
    @Autowired
    private IUserServices userServices;
    @Autowired
    private ICredentialServices credentialServices;

    @PostMapping(value="/identifier", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String loginIdentifier(@RequestBody Credential body) {

        Integer identifier = body.getIdentifier();
        if(credentialServices.checkCredential(identifier)) {
            return "{\"hasCredential\":true}";
        } else {
            return "{\"hasCredential\":false}";
        }
    }

    @PostMapping(value = "/password", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String loginPassword(@RequestBody Credential body) {

        Integer identifier = body.getIdentifier();
        if(credentialServices.checkPassword(identifier) && credentialServices.checkCredential(identifier)) {
            User user = userRepository.findByIdentifier(identifier);

            String userFirstname = user.getFirstname();

            return "{\"hasPassword\":true, \"userFirstname\":\"".concat(userFirstname).concat("\"}");
        } else {
            return "{\"hasPassword\":false}";
        }
    }
}
