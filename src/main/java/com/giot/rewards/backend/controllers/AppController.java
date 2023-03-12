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
        System.out.println();
        return credentialRepository.findAll();
    }
    @GetMapping(value = "/list/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> listUsers () {
        return userRepository.findAll();
    }

    @GetMapping("/create")
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

    @PostMapping(value="/login/identifier", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String loginIdentifier(@RequestBody Credential body) {

        Integer identifier = body.getIdentifier();
        if(credentialServices.checkCredential(identifier)) {
            return "{\"hasCredential\":true}";
        } else {
            return "{\"hasCredential\":false}";
        }
    }

    @PostMapping(value = "/login/password", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String loginPassword(@RequestBody Credential body) {

        Integer identifier = body.getIdentifier();
        if(credentialServices.checkPassword(identifier)) {
            User user = userRepository.findByIdentifier(identifier);
            String userFirstname = user.getFirstname();

            return "{\"hasPassword\":true, \"userFirstname\":\"".concat(userFirstname).concat("\"}");
        } else {
            return "{\"hasPassword\":false}";
        }
    }
}
