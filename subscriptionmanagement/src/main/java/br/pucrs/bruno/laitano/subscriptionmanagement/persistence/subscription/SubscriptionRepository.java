package br.pucrs.bruno.laitano.subscriptionmanagement.persistence.subscription;

import java.util.Date;
import java.util.List;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Application;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Client;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Subscription;

public interface SubscriptionRepository {
    List<Subscription> getSubscriptions();
    Subscription getSubscriptionId(long code);
    Subscription createSubscription(long code, Application app, Client client, Date startDate, Date endDate);
}