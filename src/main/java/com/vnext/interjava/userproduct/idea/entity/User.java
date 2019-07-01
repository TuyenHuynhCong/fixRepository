package com.vnext.interjava.userproduct.idea.entity;


import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name = "username")
    public String username;

    @Column(name = "password")
    public String password;

    @Column(name = "address")
    public String address;
    @Column(name = "role")
    public int role;

    public User() {
    }

    public User(String username, String password, String address , int role) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.role=role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
