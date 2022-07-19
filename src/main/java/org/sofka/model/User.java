package org.sofka.model;

import lombok.Data;
import org.apache.commons.codec.digest.DigestUtils;

@Data
public class User {
    private String name;
    private String lastName;
    private String email;
    private String password;


    public User(String name, String lastname, String email, String password) {
        this.name = name;
        this.lastName = lastname;
        this.email = email;
        this.password = DigestUtils
                .md5Hex(password).toUpperCase();
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = DigestUtils
                .md5Hex(password).toUpperCase();
    }
    public void save(){

    }
}
