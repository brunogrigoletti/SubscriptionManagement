package br.pucrs.bruno.laitano.subscriptionmanagement.persistence.subscription;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Application;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Client;
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

    @Override
    public Subscription createSubscription(long code, Application app, Client client, Date startDate, Date endDate) {
        ArrayList<Long> usedCodes = new ArrayList<>();
        if (!usedCodes.contains(code)) {
            Subscription newSub = new Subscription(code, app, client, startDate, endDate);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(endDate);
            calendar.add(Calendar.DAY_OF_MONTH, 7);
            Date freeWeek = calendar.getTime();
            newSub.setEndDate(freeWeek);
            repository.save(newSub);
            usedCodes.add(code);
            return newSub;
        }
        else {
            return null;
        }
    }
}