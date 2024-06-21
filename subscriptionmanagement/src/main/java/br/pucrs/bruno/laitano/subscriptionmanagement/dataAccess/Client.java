package br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess;

import jakarta.persistence.*;

@Entity
public class Client {
    @Id
    private long code;
    private String name;
    private String email;

    protected Client() {
    }
    
    public Client(long code, String name, String email) {
        this.code = code;
        this.name = name;
        this.email = email;
    }

    public long getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client [code=" + getCode() + ", name=" + getName() + ", email=" + getEmail() + "]";
    }    
}