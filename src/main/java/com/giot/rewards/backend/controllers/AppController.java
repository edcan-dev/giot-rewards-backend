package com.giot.rewards.backend.controllers;

import com.giot.rewards.backend.models.dao.CredentialRepository;
import com.giot.rewards.backend.models.dao.UserRepository;
import com.giot.rewards.backend.models.entities.Credential;
import com.giot.rewards.backend.models.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class AppController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CredentialRepository credentialRepository;

    /*@GetMapping("/list")
    public String list() {

        String result = "";

        // Encontrando a todos los users
        for (User user: userRepository.findAll()) {
            System.out.println(user.toString());
            result.concat(user.toString());
        }

        return result;
    }*/

    @GetMapping("/list")
    public List<User>list() {
        //return userRepository.findAll();
        //Users userEx = new Users(12312,"Iván","Larios","student","","",100);
        //userRepository.save(userEx);
        return userRepository.findAll();

    }

    @GetMapping("/post")
    public void post() {
        List<User> list = new ArrayList<>();
        list.add(new User(201920495,"Iván","Larios","student","","",100));
        list.add(new User(201920499,"Rams","Ramos","student","","",100));
        userRepository.insert(list);
    }

    @GetMapping("/postCredential")
    public void post2() {
        credentialRepository.insert(new Credential(201920732,"edcan","pass123"));
        credentialRepository.insert(new Credential(201920495,"fluffy","pass123"));
        credentialRepository.insert(new Credential(201920499,"rams","pass123"));
    }

    @GetMapping("/login")
    public String index(@RequestParam(value="username", required = false) String username,@RequestParam(value="password", required = false) String password) {

        if(username != null && password != null) {
            return "Username: ".concat(username).concat("\nPassword: ".concat(password));
        } else {
            return "GIoT Rewards Backend - Esperando Credenciales...";
        }
    }
}
