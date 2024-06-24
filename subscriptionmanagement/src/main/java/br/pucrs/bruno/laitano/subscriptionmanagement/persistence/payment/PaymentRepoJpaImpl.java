package br.pucrs.bruno.laitano.subscriptionmanagement.persistence.payment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Payment;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Subscription;

@Repository
@Primary
public class PaymentRepoJpaImpl implements PaymentRepository {
    private PaymentJpaItfRep repository;

    @Autowired
    public PaymentRepoJpaImpl(PaymentJpaItfRep repository) {
        this.repository = repository;
    }

    @Override
    public List<Payment> getPayments() {
        List<Payment> payments = repository.findAll();
        if (payments.size() == 0) {
            return new LinkedList<Payment>();
        }
        else {
            return payments.stream().toList();
        }
    }

    @Override
    public Payment getPaymentId(long code) {
        Payment payment = repository.findById(code);
        return payment;
    }

    @Override
    public Payment createPayment(Long code, Subscription subscription, Double paymentValue, Date paymentDate,
            String promotion) {
        ArrayList<Long> usedCodes = new ArrayList<>();
        if (paymentValue<subscription.getApp().getMonthlyCost() || usedCodes.contains(code)) {
            return null;
        }
        else {
            Payment newPayment = new Payment(code, subscription, paymentValue, null, promotion);
            newPayment.setPaymentDate(new java.sql.Date(paymentDate.getTime()));

            Date oneMoreMonth = new Date();
            if (subscription.getType().equalsIgnoreCase("ATIVA")) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(subscription.getEndDate());
                calendar.add(Calendar.DAY_OF_MONTH, 30);
                oneMoreMonth = calendar.getTime();
            }
            else {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(paymentDate);
                calendar.add(Calendar.DAY_OF_MONTH, 30);
                oneMoreMonth = calendar.getTime();
            }
            subscription.setEndDate(oneMoreMonth);
            subscription.setType("ACTIVE");

            repository.save(newPayment);
            usedCodes.add(code);
            return newPayment;
        }
    }
}