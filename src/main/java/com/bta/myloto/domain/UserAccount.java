package com.bta.myloto.domain;

public class UserAccount {
    private Long id;
    private String userName;
    private String userPassword;
    private String firstName;
    private String lastName;
    private Long isikuKood;
    private String email;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public Long getIsikuKood() {
        return isikuKood;
    }

    public void setIsikuKood(Long isikuKood) {
        this.isikuKood = isikuKood;
    }
}
