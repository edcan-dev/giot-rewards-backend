package com.giot.rewards.backend.models.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "credentials")
public class Credential implements Serializable {

    @Id
    private String _id;

    private Integer identifier;
    private String username;
    private String password;

    public Credential() {

    }

    public Credential(Integer identifier, String username, String password) {
        this.identifier = identifier;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return _id;
    }
    public void setId(String id) {
        this._id = _id;
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