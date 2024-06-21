package br.pucrs.bruno.laitano.subscriptionmanagement.persistence.subscription;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Subscription;

@Repository
@Primary
public class SubscriptionRepoJpaImpl implements SubscriptionRepository {
    private SubscriptionJpaItfRep repository;

    @Autowired
    public SubscriptionRepoJpaImpl(SubscriptionJpaItfRep repository) {
        this.repository = repository;
    }

    @Override
    public List<Subscription> getSubscriptions() {
        List<Subscription> subs = repository.findAll();
        if (subs.size() == 0) {
            return new LinkedList<Subscription>();
        }
        else {
            return subs.stream().toList();
        }
    }

    @Override
    public Subscription getSubscriptionId(long code) {
        Subscription sub = repository.findById(code);
        return sub;
    }
}