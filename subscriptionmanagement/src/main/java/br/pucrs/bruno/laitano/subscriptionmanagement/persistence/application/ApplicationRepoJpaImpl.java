package br.pucrs.bruno.laitano.subscriptionmanagement.persistence.application;

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Application;

@Repository
@Primary
public class ApplicationRepoJpaImpl implements ApplicationRepository {
    private ApplicationJpaItfRep repository;

    @Autowired
    public ApplicationRepoJpaImpl(ApplicationJpaItfRep repository) {
        this.repository = repository;
    }

    @Override
    public List<Application> getApps() {
        List<Application> apps = repository.findAll();
        if (apps.size() == 0) {
            return new LinkedList<Application>();
        }
        else {
            return apps.stream().toList();
        }
    }

    @Override
    public Application getAppId(long code) {
        Application app = repository.findById(code);
        return app;
    }
}