package br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess;

import jakarta.persistence.*;

@Entity
public class Application {
    @Id
    private long code;
    private String name;
    private float monthlyCost;

    protected Application() {
    }

    public Application(long code, String name, float monthlyCost) {
        this.code = code;
        this.name = name;
        this.monthlyCost = monthlyCost;
    }

    public long getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public float getMonthlyCost() {
        return this.monthlyCost;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMonthlyCost(float monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    @Override
    public String toString() {
        return "Application [code=" + getCode() + ", name=" + getName() + ", monthlyCost=" + getMonthlyCost() + "]";
    }
}