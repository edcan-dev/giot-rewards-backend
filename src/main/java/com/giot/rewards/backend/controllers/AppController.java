package com.giot.rewards.backend.controllers;

import com.giot.rewards.backend.models.dao.CredentialRepository;
import com.giot.rewards.backend.models.dao.UserRepository;
import com.giot.rewards.backend.models.entities.Credential;
import com.giot.rewards.backend.models.entities.User;
import com.giot.rewards.backend.services.UserServices;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Generated;
import javax.script.ScriptEngine;
import java.io.LineNumberReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class AppController {

    @Autowired
    private CredentialRepository credentialRepository;
    @Autowired
    private UserRepository userRepository;

    //@Autowired
    //private UserServices userServices;



    //@Autowired
    //private UserRepository userRepository;
    //@Autowired
    //private CredentialRepository credentialRepository;

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

    /*@GetMapping("/list")
    public List<User>list() {
        //return userRepository.findAll();
        //return userRepository.findAll();
        //return userRepository.findAll();
        //Users userEx = new Users(12312,"Iván","Larios","student","","",100);
        //userRepository.save(userEx);
        return userRepository.findAll();
    }*/

    /*@GetMapping("/post")
    public void post() {
        List<User> list = new ArrayList<>();
        list.add(new User(201920495,"Iván","Larios","student","","",100));
        list.add(new User(201920499,"Rams","Ramos","student","","",100));
        userRepository.insert(list);
    }*/

    /*@GetMapping("/postCredential")
    public void post2() {
<<<<<<< HEAD
        credentialRepository.insert(new Credential(201920732,"edcan","pass123"));
        credentialRepository.insert(new Credential(201920495,"fluffy","pass123"));
        credentialRepository.insert(new Credential(201920499,"rams","pass123"));
    }*/

    /*@GetMapping("/login")
    public String index(@RequestParam(value="username", required = false) String username,@RequestParam(value="password", required = false) String password) {

        if(username != null && password != null) {
            return "Username: ".concat(username).concat("\nPassword: ".concat(password));
        } else {
            return "GIoT Rewards Backend - Esperando Credenciales...";
        }
    }*/

    @GetMapping("/list/credentials")
    public List<Credential> listCredentials () {
        return credentialRepository.findAll();
    }
    @GetMapping("/list/users")
    public List<User> listUsers () {



        for (User user : userRepository.findAll()) {
            System.out.println(user.getPoints());
            UserServices userService = new UserServices(user);
            userService.addPoints(150.0);
            user.setPoints(userService.getPoints());
            System.out.println(user.getPoints());
        }


        return userRepository.findAll();
    }

    @GetMapping("/crear")
    public void crear() {
        userRepository.insert(new User(201920732,"Edgar","Cano","","","",100));
    }


    /*
    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String login(@RequestBody MultiValueMap<String, String> form) {

        System.out.println(form.getFirst("identifier"));


        String result = null;

        Integer parsedIdentifier  = Integer.parseInt(identifier);

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

        return "";
    }*/
    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String login(@RequestBody Credential data) {

        System.out.println(data.toString());

        /*
        String result = null;

        Integer parsedIdentifier  = Integer.parseInt(identifier);

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
        } */

        return data.getIdentifier().toString();
    }
}
