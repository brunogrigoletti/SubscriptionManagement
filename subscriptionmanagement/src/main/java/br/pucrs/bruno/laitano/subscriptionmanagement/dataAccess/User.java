package br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name="_USER")
public class User {
    @Id
    private long code;
    private String username;
    private String password;
    /* @OneToMany (mappedBy= "user")
    private List<Application> apps;
 */
    protected User() {
    }

    public User(long code, String username, String password) {
        this.code = code;
        this.username = username;
        this.password = password;
        //this.apps = new ArrayList<>();
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

    
    /* public List<Application> getApplicationsfromUser(){
        return this.apps;
    }

    public boolean addNewApp(Application app){
        if(apps.contains(app)){
            return false;
        }
        apps.add(app);
        return true;
    }

    public boolean removeApp(Application app){
        if(apps.contains(app)){
            apps.remove(app);
            return true;
        }
        else{
            return false;
        }
    }

     public boolean removeAppByID(long code){
        Application app = apps.stream()
        .filter( a -> a.getCode()==code)
        .findFirst()
        .orElse(null);

        if(app == null){
            return false;
        }
        else{
            apps.remove(app);
            return true;
        }
    } */
}