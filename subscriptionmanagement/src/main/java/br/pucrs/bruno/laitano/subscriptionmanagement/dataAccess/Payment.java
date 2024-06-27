package br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Payment {
    @Id
    private long code;
    @ManyToOne
    private Subscription subscription;
    private Double paymentValue;
    private Date paymentDate;
    private String promotion;

    protected Payment() {
    }

    public Payment(Long code, Subscription subscription, Double paymentValue, Date paymentDate, String promotion) {
        this.code = code;
        this.subscription = subscription;
        this.paymentDate = paymentDate;
        this.promotion = promotion;
        this.paymentValue = paymentValue;
    }

    @PostLoad
    public void calculatePromotion() {
        if (this.promotion.equals("15"))
            this.paymentValue = paymentValue * 0.85;
        else if (this.promotion.equals("25"))
            this.paymentValue = paymentValue * 0.75;
        else if (this.promotion.equals("50"))
            this.paymentValue = paymentValue * 0.50;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public Double getPaymentValue() {
        return paymentValue;
    }

    public void setPaymentValue(Double paymentValue) {
        this.paymentValue = paymentValue;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    @Override
    public String toString() {
        return "Payment [code=" + getCode() + ", subscription=" + getSubscription() + ", paymentValue="
                + getPaymentValue()
                + ", paymentDate=" + getPaymentDate() + ", promotion=" + getPromotion() + "]";
    }
}