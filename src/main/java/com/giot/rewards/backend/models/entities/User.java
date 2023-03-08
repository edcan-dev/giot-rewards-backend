package com.giot.rewards.backend.models.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
@Document(collection = "users")
public class User implements Serializable {

    @Id
    private String _id;

    private Integer identifier; // Matricula o número de empleado
    private String firstname;
    private String lastname;
    private String type;
    private String email;
    private String phone;
    private Integer points;


    public User() {
    }

    public User(Integer identifier, String firstname, String lastname, String type, String email, String phone, Integer points) {
        this.identifier = identifier;
        this.firstname = firstname;
        this.lastname = lastname;
        this.type = type;
        this.email = email;
        this.phone = phone;
        this.points = points;
    }


    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public Integer getIdentifier() {
        return identifier;
    }
    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Integer getPoints() {
        return points;
    }
    public void setPoints(Integer points) {
        this.points = points;
    }
    @Override
    public String toString() {
        return "Nombre: ".concat(firstname).concat(" Apellido: ").concat(lastname);
    }

}
