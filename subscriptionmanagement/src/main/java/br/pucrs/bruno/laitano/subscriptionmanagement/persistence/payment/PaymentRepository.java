package br.pucrs.bruno.laitano.subscriptionmanagement.persistence.payment;

import java.util.List;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Payment;

public interface PaymentRepository {
    List<Payment> getPayments();
    Payment getPaymentId(long code);
}