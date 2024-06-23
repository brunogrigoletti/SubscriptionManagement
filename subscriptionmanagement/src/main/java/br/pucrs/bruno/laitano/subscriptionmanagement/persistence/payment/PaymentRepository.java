package br.pucrs.bruno.laitano.subscriptionmanagement.persistence.payment;

import java.util.Date;
import java.util.List;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Payment;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Subscription;

public interface PaymentRepository {
    List<Payment> getPayments();
    Payment getPaymentId(long code);
    Payment createPayment(Long code, Subscription subscription, Double paymentValue, Date paymentDate, String promotion);
}