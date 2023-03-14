package com.giot.rewards.backend.controllers;

import com.giot.rewards.backend.models.dao.CredentialRepository;
import com.giot.rewards.backend.models.dao.UserRepository;
import com.giot.rewards.backend.models.entities.Credential;
import com.giot.rewards.backend.models.entities.User;
import com.giot.rewards.backend.services.ICredentialServices;
import com.giot.rewards.backend.services.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.ClientEndpoint;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class AppController {

    @Autowired
    private CredentialRepository credentialRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IUserServices userServices;
    @Autowired
    private ICredentialServices credentialServices;

    @GetMapping("/list/credentials")
    public List<Credential> listCredentials () {
        System.out.println();
        return credentialRepository.findAll();
    }
    @GetMapping(value = "/list/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> listUsers () {
        return userRepository.findAll();
    }

    @GetMapping("/create")
    public void crear() {
        credentialRepository.insert(new Credential(201920732,"Pass123"));
        credentialRepository.insert(new Credential(201910642,""));
        //userRepository.insert(new User(201920732,"Edgar","Cano","student","","",100));
        //userRepository.insert(new User(201920732,"Yesenia","Hernández","student","","",100));
        //userRepository.insert(new User(201920732,"Iván","Larios","student","","",100));

    }


}
