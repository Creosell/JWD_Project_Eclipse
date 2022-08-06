package by.sheshko.shop.bean.builder;

import by.sheshko.shop.bean.User;

import java.sql.Timestamp;

public final class UserBuilder {
    private int userID;
    private String name;
    private String surname;
    private String email;
    private String address;
    private String phonenumber;
    private Timestamp registrationTime;
    private String status;
    private String role;

    public UserBuilder() {
    }

    public UserBuilder userID(Integer userID) {
        this.userID = userID;
        return this;
    }

    public UserBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder status(String status) {
        this.status = status;
        return this;
    }

    public UserBuilder role(String role) {
        this.role = role;
        return this;
    }

    public UserBuilder surname(String surname) {
        this.surname = surname;
        return this;
    }

    public UserBuilder email(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder address(String address) {
        this.address = address;
        return this;
    }

    public UserBuilder phonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
        return this;
    }

    public UserBuilder registrationTime(Timestamp registrationTime) {
        this.registrationTime = registrationTime;
        return this;
    }

    public User build() {
        return new User(userID, name, surname, email, address, phonenumber, registrationTime, status, role);
    }
}
