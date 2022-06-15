package com.kalbanq_servlet.entity;

import java.util.Date;

public class User {
    private int id;
    private String email;
    private String password;
    private String roles;
    private String user_token;
    private boolean activated;
    private Date created_at;
    private Date updated_at;

    public User(){}

    public User(int id, String email, String password, String roles, String user_token, boolean activated, Date created_at, Date updated_at) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.user_token = user_token;
        this.activated = activated;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getUser_token() {
        return user_token;
    }

    public void setUser_token(String user_token) {
        this.user_token = user_token;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + roles + '\'' +
                ", user_token='" + user_token + '\'' +
                ", activated=" + activated +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
