package br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import jakarta.persistence.*;

@Entity
public class Subscription {
    @Id
    private long code;
    @ManyToOne
    private Application app;
    @ManyToOne
    private Client client;
    private Date startDate;
    private Date endDate;
    @Transient
    private String type;
    @Transient
    private Date paymentDate;

    protected Subscription() {
    }
    
    public Subscription(long code, Application app, Client client, Date startDate, Date endDate) {
        this.code = code;
        this.app = app;
        this.client = client;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @PostLoad
    public void calculateTypeAndPaymentDate() {
        LocalDate endLocalDate = this.endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate currentDate = LocalDate.now();
        if (endLocalDate.isAfter(currentDate)) {
            this.type = "ACTIVE";
        } else {
            this.type = "INACTIVE";
        }

        this.paymentDate = new Date(this.startDate.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.startDate);
        calendar.set(Calendar.DAY_OF_MONTH, 20);
        this.paymentDate = calendar.getTime();
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

    public String getType() {
        return this.type;
    }

    public Date getPaymentDate() {
        return this.paymentDate;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public void setApp(Application app) {
        this.app = app;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "Subscription [code=" + getCode() + ", app=" + getApp() + ", client=" + getClient() +
            ", startDate=" + getStartDate() + ", endDate=" + getEndDate() + ", type=" + getType() +
            ", paymentDate=" + getPaymentDate() + "]";
    }
}