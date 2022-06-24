package com.kalbanq_servlet.entity;

public class Banker {
    private String email;
    private String gender;
    private String first_name;
    private String last_name;

    public Banker(){}

    public Banker(String email, String gender, String first_name, String last_name) {
        this.email = email;
        this.gender = gender;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "Banker{" +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }
}
