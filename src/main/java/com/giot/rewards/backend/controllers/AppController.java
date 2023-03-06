package com.giot.rewards.backend.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/login")
    public String index(@RequestParam(value="username", required = false) String username,@RequestParam(value="password", required = false) String password) {

        if(username != null && password != null) {
            return "Username: ".concat(username).concat("\nPassword: ".concat(password));
        } else {
            return "GIoT Rewards Backend - Esperando Credenciales...";
        }
    }
}
