package com.sweater.entities;

import com.sweater.enums.UserRole;

import javax.persistence.*;

@Entity
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue
    private int id;
    private String userName;
    private String password;
    private UserRole userrole;
    @Transient
    private String passwordConfirm;

    //getters and setters

    public User() {

    }

    public User(int id, String name, String password, UserRole userrole,  String passwordConfirm) {
        this.id = id;
        this.userName = name;
        this.password = password;
        this.userrole = userrole;
        this.passwordConfirm = passwordConfirm;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public  UserRole getRole() {
        return userrole;
    }

    public void setRole(UserRole userrole) {
        this.userrole = userrole;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}