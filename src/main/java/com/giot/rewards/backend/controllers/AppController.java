package com.giot.rewards.backend.controllers;

import com.giot.rewards.backend.models.dao.CredentialRepository;
import com.giot.rewards.backend.models.dao.UserRepository;
import com.giot.rewards.backend.models.entities.Credential;
import com.giot.rewards.backend.models.entities.User;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.script.ScriptEngine;
import java.io.LineNumberReader;
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
        //return userRepository.findAll();
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
        credentialRepository.insert(new Credential(201920732,"pass123"));
        credentialRepository.insert(new Credential(201920495,"pass123"));
        credentialRepository.insert(new Credential(201920499,"pass123"));
    }

    @GetMapping("/login")
    public String index(@RequestParam(value="username", required = false) String username,@RequestParam(value="password", required = false) String password) {

        if(username != null && password != null) {
            return "Username: ".concat(username).concat("\nPassword: ".concat(password));
        } else {
            return "GIoT Rewards Backend - Esperando Credenciales...";
        }
    }

    @PostMapping(value = "/login", consumes = MediaType.TEXT_PLAIN_VALUE)
    public String login(@RequestBody String identifier) {

        String result = null;

        try {
            Integer parsedIdentifier  = Integer.parseInt(identifier);
        } catch(NumberFormatException e) {

        }

        System.out.println(parsedIdentifier);


        if(credentialRepository.findByIdentifier(parsedIdentifier) != null) { // Busca si existen las credenciales segun la Matrícula
            Credential matchedCrendential = credentialRepository.findByIdentifier(parsedIdentifier);

            if ( matchedCrendential.getPassword().equals("")){ // Aqui se inyectan los services
                result = "Usuario sin contraseña";
            } else {
                result = "Usuario con contraseña";
            }

        } else {
            result = "No existe el usuario";
        }

        return result;
    }
}
