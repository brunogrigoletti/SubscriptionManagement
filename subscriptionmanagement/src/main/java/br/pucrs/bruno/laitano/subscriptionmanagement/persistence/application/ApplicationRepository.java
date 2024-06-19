package br.pucrs.bruno.laitano.subscriptionmanagement.persistence.application;

import java.util.List;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Application;

public interface ApplicationRepository {
    List<Application> getApps();
    Application getAppId(long code);
}