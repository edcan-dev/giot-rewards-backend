package com.giot.rewards.backend.models.entities;


import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class LoginCredential implements Serializable {

    @Id
    private String id;

    private Integer identifier;
    private String username;
    private String password;

    public LoginCredential() {

    }

    public LoginCredential(String id, Integer identifier, String username, String password) {
        this.id = id;
        this.identifier = identifier;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Integer getIdentifier() {
        return identifier;
    }
    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
