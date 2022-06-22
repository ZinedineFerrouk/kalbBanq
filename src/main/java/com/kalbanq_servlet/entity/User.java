package com.kalbanq_servlet.entity;

import java.util.Date;

public class User {
    private String id;
    private String roles;
    private String user_token;
    private Date created_at;
    private Date updated_at;

    public User(){}

    public User(String id, String roles, String user_token, Date created_at, Date updated_at) {
        this.id = id;
        this.roles = roles;
        this.user_token = user_token;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
                ", roles='" + roles + '\'' +
                ", user_token='" + user_token + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
