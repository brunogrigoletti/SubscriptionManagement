package br.pucrs.bruno.laitano.subscriptionmanagement.persistence.subscription;

import java.util.List;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Subscription;

public interface SubscriptionRepository {
    List<Subscription> getSubscriptions();
    Subscription getSubscriptionId(long code);
}