package com.example.demo.Security;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="custom_user")
public class CustomUser {
    public CustomUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public CustomUser(){
        this.username = "gol";
        this.password = "gol";
    }

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

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
