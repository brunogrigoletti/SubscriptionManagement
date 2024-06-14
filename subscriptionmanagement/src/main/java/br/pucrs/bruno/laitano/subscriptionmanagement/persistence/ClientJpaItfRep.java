package br.pucrs.bruno.laitano.subscriptionmanagement.persistence;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import br.pucrs.bruno.laitano.subscriptionmanagement.dataAccess.Client;

public interface ClientJpaItfRep extends CrudRepository<Client,Long> {
    List<Client> findAll();
    Client findById(long id);
    void delete(Client client);
    void deleteById(long id);
    boolean existsById(long id);
}