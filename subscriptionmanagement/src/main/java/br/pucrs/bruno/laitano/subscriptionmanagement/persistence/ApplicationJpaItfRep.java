package br.pucrs.bruno.laitano.subscriptionmanagement.persistence;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Application;

public interface ApplicationJpaItfRep extends CrudRepository<Application,Long> {
    List<Application> findAll();
    Application findById(long id);
    void delete(Application app);
    void deleteById(long id);
    boolean existsById(long id);
}