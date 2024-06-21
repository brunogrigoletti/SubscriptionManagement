package br.pucrs.bruno.laitano.subscriptionmanagement.persistence.payment;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Payment;

public interface PaymentJpaItfRep extends CrudRepository<Payment,Long> {
    List<Payment> findAll();
    Payment findById(long id);
    void delete(Payment payment);
    void deleteById(long id);
    boolean existsById(long id);
}