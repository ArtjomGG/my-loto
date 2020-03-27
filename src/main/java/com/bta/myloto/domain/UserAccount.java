package com.bta.myloto.domain;

public class UserAccount extends BaseEntenty {

    private String userName;
    private String userPassword;
    private String firstName;
    private String lastName;
    private Long isikuKood;
    private String email;

    public UserAccount(Long id, String userName, String userPassword, String firstName, String lastName, Long isikuKood, String email) {
        super(id);
        this.userName = userName;
        this.userPassword = userPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isikuKood = isikuKood;
        this.email = email;
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
