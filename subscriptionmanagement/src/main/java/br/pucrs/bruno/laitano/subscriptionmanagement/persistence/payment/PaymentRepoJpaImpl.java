package br.pucrs.bruno.laitano.subscriptionmanagement.persistence.payment;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Payment;

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
}