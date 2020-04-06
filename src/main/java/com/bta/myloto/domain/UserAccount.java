package com.bta.myloto.domain;

public class UserAccount extends BaseEntenty {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Long isikuKood;
    private String email;
    private boolean active;
    private String role = "USER";

    public UserAccount() {
        super(null);
        this.active = true;
    }

    public UserAccount(Long id, String username, String password, String firstName, String lastName, Long isikuKood, Boolean active, String role, String email) {
        super(id);
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isikuKood = isikuKood;
        this.email = email;
        this.active = active;
        this.role = role;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
