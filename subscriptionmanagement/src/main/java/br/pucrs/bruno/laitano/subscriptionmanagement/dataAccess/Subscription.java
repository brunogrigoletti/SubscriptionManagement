package br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess;

import java.util.Date;
import jakarta.persistence.*;

@Entity
public class Subscription {
    @Id
    private long code;
    private Application app;
    private Client client;
    private Date startDate;
    private Date endDate;

    protected Subscription() {
    }
    
    public Subscription(long code, Application app, Client client, Date startDate, Date endDate) {
        this.code = code;
        this.app = app;
        this.client = client;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getCode() {
        return this.code;
    }

    public Application getApp() {
        return this.app;
    }

    public Client getClient() {
        return this.client;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    @Override
    public String toString() {
        return "Subscription [code=" + getCode() + ", app=" + getApp() + ", client=" + getClient() +
                ", startDate=" + getStartDate() + ", endDate=" + getEndDate() + "]";
    }
}