package br.pucrs.bruno.laitano.subscriptionmanagement.persistence.subscription;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Subscription;

public interface SubscriptionJpaItfRep extends CrudRepository<Subscription,Long> {
    List<Subscription> findAll();
    Subscription findById(long id);
    void delete(Subscription subscription);
    void deleteById(long id);
    boolean existsById(long id);
}