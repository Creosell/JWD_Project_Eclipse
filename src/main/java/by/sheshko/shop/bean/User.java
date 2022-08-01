package by.sheshko.shop.bean;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private static final long serialVersionUID = 147947946884646719L;
    private int userID;
    private String name;
    private String surname;
    private String email;
    private String phonenumber;
    private Date registrationTime;
    private String status;
    private String role;
//todo equals hash
    public User() {
    }

    public User(final int userID) {
        this.userID = userID;
    }


    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(final int userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(final String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(final Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(final Integer roleID) {
        this.role = new Role().getRoleName(roleID);
    }


    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", username='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", registrationTime=" + registrationTime +
                ", status='" + status + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

