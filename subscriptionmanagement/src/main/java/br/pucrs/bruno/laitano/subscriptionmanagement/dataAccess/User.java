package br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    private long code;
    private String username;
    private String password;

    protected User() {
    }

    public User(long code, String username, String password) {
        this.code = code;
        this.username = username;
        this.password = password;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
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

    @Override
    public String toString() {
        return "User [code=" + getCode() + ", username=" + getUsername() + ", password=" + getPassword() + "]";
    }
}