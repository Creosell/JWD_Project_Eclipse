package by.sheshko.shop.bean;

import by.sheshko.shop.entity.role.Role;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private static final long serialVersionUID = 147947946884646719L;
    private int userID;
    private String login;
    private String name;
    private String surname;
    private String email;
    private String phonenumber;
    private Date registrationTime;
    private String status;
    private String role;

    public User() {
    }

    public User(String login) {
        this.login = login;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(Integer roleID) {
        this.role = new Role().getRoleName(roleID);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", login='" + login + '\'' +
                ", username='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", registrationTime=" + registrationTime +
                ", status='" + status + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

